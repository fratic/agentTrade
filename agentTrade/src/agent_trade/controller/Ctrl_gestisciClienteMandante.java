package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Sconto;
import agent_trade.ui.content.agenti.Ricerca_agente;
import agent_trade.ui.content.clienti.AlberoClienti_Mandante;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.sconti.riepilogo.Ricerca_scontoCliente;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciClienteMandante extends Ctrl_gestisciClienteFactory {
	
	private static Ctrl_gestisciClienteMandante instance;
	
	
	
	public static Ctrl_gestisciClienteMandante getInstance(){
		if (instance==null)
			instance = new Ctrl_gestisciClienteMandante();
		return instance;	 
	}
	
	
	public void ricercaCliente(String c, String pi, String cf, String city) throws PersistentException {
		
		if ((c.equals("") || c==null) && (pi.equals("") || pi==null) && (cf.equals("") || cf==null) && (city.equals("") || city==null)){
			
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciClienteMandante.getInstance().caricaClienti());
		}
		else {
			
			M_Cliente [] listClienti = null;

			listClienti = M_Cliente.caricaClientiParametriRemoto(c, pi, cf, city);
			
			if(listClienti.length==0) {
		
				Ricerca_cliente.getInstance().setErrore(Costanti.MESSAGGIO_CLIENTE_NON_TROVATO);
				Ricerca_cliente.getInstance().setVisibleErroreRicercaCliente(true);
			}
		
			else{
				
				Ricerca_cliente.getInstance().svuotaTabella();

				for (M_Cliente cLoad : listClienti) {
					Ricerca_cliente.getInstance().updateTable(cLoad.getIdCliente(), cLoad.getCognome(), cLoad.getNome(), cLoad.getCodice_fiscale(), cLoad.getPartita_iva(), cLoad.getCitta());
				}
			}
		}
	}
	
	
	//reset campi finestra ricerca cliente e reset tabella
	public void annullaRicercaCliente() {

		Ricerca_cliente.getInstance().svuotaTabella();
		Ricerca_cliente.getInstance().resetRicerca();
		Ricerca_cliente.getInstance().setVisibleErroreRicercaCliente(false);
	}
	
	
	public void recuperaCliente(int idCliente) throws PersistentException {	
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleCliente();
				
		M_Cliente cliente = M_Cliente.cercaClienteRemotoMandante(idCliente);
		
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(cliente.getSconto());
				
		Ricerca_cliente.getInstance().dispose();
		Ricerca_cliente.cancInstanza();
				
		PrimaryMandanteView.initRiepilogoClienteView();
		PrimaryMandanteView.getInstance().setSchedaCliente(cliente);
		PrimaryMandanteView.getInstance().setScontoCliente(sconto);
		PrimaryMandanteView.getInstance().disattivaSalvaModifiche(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModifiche(false);
		PrimaryMandanteView.getInstance().disattivaInviaPosta(false);
		PrimaryMandanteView.getInstance().disattivaModifica(false);
		PrimaryMandanteView.getInstance().disattivaCancella(false);
		PrimaryMandanteView.getInstance().disattivaModSconto(true);
		PrimaryMandanteView.getInstance().disattivaModAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
	}
	
	
	public void modificaCliente(M_Cliente c) throws PersistentException { 
		
		c.setVersione_download(c.getVersione_download()+1);
		M_Cliente.updateClienteRemoto(c);
	}
	
	
	public M_Cliente [] caricaClienti() throws PersistentException {
		
		M_Cliente [] listClienti = null;
		
		listClienti = M_Cliente.caricaClientiRemoto();
		
		return listClienti;
	}
	
	
	public void btnCerca() {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleCliente();
		PrimaryMandanteView.getInstance().setSfondoCliente();
		try {
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciClienteMandante.getInstance().caricaClienti());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_cliente.getInstance().setVisible(true);
	}
	
	
	public void btnCercaSconto() throws PersistentException{
		
		Ricerca_scontoCliente.getInstance().popolaTab(M_Sconto.caricaScontiRemoto());
		Ricerca_scontoCliente.getInstance().setVisible(true);	
		
	}

	public void assegnaSconto(int idSconto) throws PersistentException{
		
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(idSconto);
	
		RiepilogoClienteView.cliente.setSconto(sconto.getId());
		Ctrl_gestisciClienteFactory.getInstance().modificaCliente(RiepilogoClienteView.cliente);
		
		Ricerca_scontoCliente.getInstance().dispose();
		Ricerca_scontoCliente.cancInstanza();
		PrimaryMandanteView.getInstance().setScontoCliente(sconto);	
	}
		

	public void btnCercaAgente()throws PersistentException {
			
		Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgentiRemoto());
		Ricerca_agente.getInstance().setVisibleBtnVisualizza(false);
		Ricerca_agente.getInstance().setVisibleBtnModifica(true);
		Ricerca_agente.getInstance().setVisible(true);
	}
		

	public void assegnaAgente(M_Cliente cliente, int idAgente) throws PersistentException{
			
		M_Agente agente = M_Agente.caricaAgenteRemoto(idAgente);
		M_Cliente nuovoCliente=cliente.clone();
		nuovoCliente.setAgenteAssociato(agente);
		nuovoCliente.setVersione(1);
		nuovoCliente.setIdclienteagente(0);
		M_Cliente.salvaClienteRemoto(nuovoCliente);
			
		cliente.setAttivo(0);

		Ctrl_gestisciClienteFactory.getInstance().modificaCliente(cliente);
		
		Ricerca_agente.getInstance().dispose();
		Ricerca_agente.cancInstanza();
		
		M_Agente agenteRif = M_Agente.cercaAgenteRemoto(idAgente);
		
		PrimaryMandanteView.getInstance().setAgenteRif(agenteRif);
		AlberoClienti_Mandante.refresh();
	}
	
}
