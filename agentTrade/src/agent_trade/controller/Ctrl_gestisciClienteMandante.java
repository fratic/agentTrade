package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.ui.content.agenti.Ricerca_agente;
import agent_trade.ui.content.clienti.AlberoClienti_Mandante;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.sconti.riepilogo.Ricerca_sconto;
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
		
		super.ricercaCliente(c, pi, cf, city);
		
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
		super.annullaRicercaCliente();
		Ricerca_cliente.getInstance().svuotaTabella();
		Ricerca_cliente.getInstance().resetRicerca();
		Ricerca_cliente.getInstance().setVisibleErroreRicercaCliente(false);
	}
	
	
	public void recuperaCliente(int idCliente) throws PersistentException {	
		
		super.recuperaCliente(idCliente);
		
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
//		AlberoClienti.abilitaAlbero();
//		AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}
	
	
	public void modificaCliente(M_Cliente c) throws PersistentException { 
		
		c.setVersione(c.getVersione()+1);
		
		super.modificaCliente(c);
		
		M_Cliente.updateClienteRemoto(c);
	}
	
	
	public M_Cliente [] caricaClienti() throws PersistentException {
		
		M_Cliente [] listClienti = null;
		
		listClienti = M_Cliente.caricaClientiRemoto();
		
		return listClienti;
	}
	
	
	public void btnCerca() {
		
		super.btnCerca();
		
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
		
		super.btnCercaSconto();
		
		Ricerca_sconto.getInstance().popolaTab(M_Sconto.caricaScontiRemoto());
		Ricerca_sconto.getInstance().setVisibleBtnVisualizza(false);
		Ricerca_sconto.getInstance().setVisibleBtnModificaCliente(true);
		Ricerca_sconto.getInstance().setVisibleBtnModificaProdotto(false);
		Ricerca_sconto.getInstance().setVisibleErroreRicercaSconto(false);
		Ricerca_sconto.getInstance().setVisible(true);	
		
	}
		

	public void assegnaSconto(int idSconto) throws PersistentException{
		
		super.assegnaSconto(idSconto);
		
		Ricerca_sconto.getInstance().dispose();
		Ricerca_sconto.cancInstanza();
		
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(idSconto);
		
		Ricerca_sconto.getInstance().setVisibleErroreRicercaSconto(false);
		
		if(sconto instanceof M_ScontoCliente){
			Ricerca_sconto.getInstance().dispose();
			Ricerca_sconto.cancInstanza();
			PrimaryMandanteView.getInstance().setScontoCliente(sconto);
		}
		else{
			Ricerca_sconto.getInstance().setErrore(Costanti.MESSAGGIO_SCONTO_CLIENTE_ERRATO);
			Ricerca_sconto.getInstance().setVisibleErroreRicercaSconto(true);
		}	
	}
		

	public void btnCercaAgente()throws PersistentException {
		
		super.btnCercaAgente();
		
		Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgentiRemoto());
		Ricerca_agente.getInstance().setVisibleBtnVisualizza(false);
		Ricerca_agente.getInstance().setVisibleBtnModifica(true);
		Ricerca_agente.getInstance().setVisible(true);
	}
		

	public void assegnaAgente(int idAgente) throws PersistentException{
		
		super.assegnaAgente(idAgente);
		
		Ricerca_agente.getInstance().dispose();
		Ricerca_agente.cancInstanza();
		
		M_Agente agenteRif = M_Agente.cercaAgenteRemoto(idAgente);
		
		PrimaryMandanteView.getInstance().setAgenteRif(agenteRif);
		AlberoClienti_Mandante.refresh();
	}
	

}
