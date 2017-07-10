package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.orm.PersistentException;

import agent_trade.model.M_Cliente;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.clienti.confermaCancCliente;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciClienteAgente extends Ctrl_gestisciClienteFactory{

	private static Ctrl_gestisciClienteAgente instance;
	
	public static Ctrl_gestisciClienteAgente getInstance(){
		if (instance==null)
			instance = new Ctrl_gestisciClienteAgente();
		return instance;	 
	}
	
	private boolean check(String regex, String input){
		
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(input);

		  if (matcher.matches())
		    return true;
		  else
		    return false;
		}
	
	private String ControlloCampi(M_Cliente cliente){
		
		String errore= null;
		String campoErrato = "";
		
		if(cliente.getNome().equals("") || cliente.getCognome().equals("") || cliente.getCodice_fiscale().equals("") || cliente.getPartita_iva().equals("") || cliente.getCitta().equals("") || cliente.getCAP().equals("") || cliente.getIndirizzo().equals("") || cliente.getCell().equals("")){
			return errore = Costanti.MESSAGGIO_CAMPI_VUOTI_CLIENTE;
		}
		if(!check(Costanti.REG_EX_COGNOME, cliente.getCognome())){
			campoErrato = campoErrato + "cognome ";
		}
		if(!check(Costanti.REG_EX_NOME, cliente.getNome())){
			campoErrato = campoErrato + "nome ";
		}
		if(!check(Costanti.REG_EX_COD_FISC, cliente.getCodice_fiscale())){
			campoErrato = campoErrato + "codice fiscale ";
		}
		if(!check(Costanti.REG_EX_PART_IVA, cliente.getPartita_iva())){
			campoErrato = campoErrato + "partita iva ";
		}
		if(!check(Costanti.REG_EX_INDIRIZZO, cliente.getIndirizzo())){
			campoErrato = campoErrato +"indirizzo ";
		}
		if(!check(Costanti.REG_EX_CITTA, cliente.getCitta())){
			campoErrato = campoErrato +"città ";
		}
		if(!check(Costanti.REG_EX_CAP, cliente.getCAP())){
			campoErrato = campoErrato +"cap ";
		}
		if(cliente.getTelefono()!= null && !cliente.getTelefono().equals("")){
			if(!check(Costanti.REG_EX_TELEFONO, cliente.getTelefono()))
				campoErrato = campoErrato +"telefono ";
		}
		if(!check(Costanti.REG_EX_CELLULARE, cliente.getCell())){
			campoErrato = campoErrato +"cellulare ";
		}
		if(cliente.getFax()!= null && !cliente.getFax().equals("")){
			if(!check(Costanti.REG_EX_FAX, cliente.getFax()))
				campoErrato = campoErrato +"fax ";
		}
		if(cliente.getEmail()!= null && !cliente.getEmail().equals("")){
			if(!check(Costanti.REG_EX_EMAIL, cliente.getEmail()))
				campoErrato = campoErrato +"email ";
		}
		if (errore == null && campoErrato != "")
		{
			errore = Costanti.MESSAGGIO_CAMPI_ERRATI + campoErrato;
		}
		return errore;
	}
	
	
		
	//per la tabella cerca cliente in gestione cliente
	public void ricercaCliente(String c, String pi, String cf, String city) throws PersistentException {
		
		
		if ((c.equals("") || c==null) && (pi.equals("") || pi==null) && (cf.equals("") || cf==null) && (city.equals("") || city==null)){
			
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciClienteAgente.getInstance().caricaClienti());
		}
		else {
			
				M_Cliente [] listClienti = null;
			
				listClienti = M_Cliente.caricaClientiParametri(c, pi, cf, city);
								
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
		
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		
		M_Cliente cliente = M_Cliente.cercaCliente(idCliente);
		
		M_Sconto sconto = M_Sconto.caricaSconto(cliente.getSconto());
		
		Ricerca_cliente.getInstance().dispose();
		Ricerca_cliente.cancInstanza();
		
		PrimaryAgenteView.initRiepilogoClienteView();
		PrimaryAgenteView.getInstance().setSchedaCliente(cliente);
		PrimaryAgenteView.getInstance().setScontoCliente(sconto);
		PrimaryAgenteView.getInstance().disattivaSalvaModifiche(false);
		PrimaryAgenteView.getInstance().disattivaAnnullaModifiche(false);
		PrimaryAgenteView.getInstance().disattivaModSconto(false);
		PrimaryAgenteView.getInstance().disattivaModAgente(false);
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(true);
		PrimaryAgenteView.getInstance().setVisibleErroreRiepCliente(false);
		AlberoClienti.abilitaAlbero();
		AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}		
		
	
	public void inserisciNuovoCliente(M_Cliente cliente) throws PersistentException	{
		
		
//		la stringa errore serve per il controllo campi se viene restituita null vuol dire che non ci sono errori
		String errore= ControlloCampi(cliente);
		if(errore==null){
			
		cliente.setAttivo(1);
		cliente.setVersione(1);
		M_ScontoCliente scontoBase = M_ScontoCliente.caricaScontoBase();
		cliente.setSconto(scontoBase.getId());
		
		M_Cliente.salvaCliente(cliente);

		PrimaryAgenteView.getInstance().resetNuovoCliente();
		PrimaryAgenteView.getInstance().setVisibleErroreNuovoCliente(false);
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
				
		int id = M_Cliente.getMaxId();
		recuperaCliente(id);
			
		AlberoClienti.inserisciNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
		AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
		AlberoClienti.abilitaAlbero();
				
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(true);
		PrimaryAgenteView.getInstance().setEnableCercaCliente(true);
		PrimaryAgenteView.getInstance().setEnableUpdateCliente(true);
		}
		else{
			PrimaryAgenteView.getInstance().setVisibleErroreNuovoCliente(true);
			PrimaryAgenteView.getInstance().setErroreNuovoCliente(errore);
		}
	}
		
		
	public void modificaCliente(M_Cliente c) throws PersistentException {
		
		
		String errore = ControlloCampi(c);
		
		if(errore == null){				
			
			c.setVersione(c.getVersione()+1);
			
			M_Cliente.aggiornaCliente(c);
							
			PrimaryAgenteView.getInstance().resetCliente();
			PrimaryAgenteView.getInstance().disattivaModifica(true);
			PrimaryAgenteView.getInstance().disattivaSalvaModifiche(false);
			PrimaryAgenteView.getInstance().disattivaCancella(true);
			PrimaryAgenteView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryAgenteView.getInstance().setEnableTabPreventivo(true);
			PrimaryAgenteView.getInstance().setEnableTabCatalogo(true);
			PrimaryAgenteView.getInstance().setEnableNewCliente(true);
			PrimaryAgenteView.getInstance().setEnableCercaCliente(true);
			PrimaryAgenteView.getInstance().setEnableUpdateCliente(true);
			PrimaryAgenteView.getInstance().disattivaInviaPosta(true);
			PrimaryAgenteView.getInstance().setInvisibleToolTip();
			PrimaryAgenteView.getInstance().setLabel(false);
			AlberoClienti.updateNodo(c.getIdCliente()+ " - " +c.getCognome()+ " - " +c.getNome());
			AlberoClienti.selectNode(c.getIdCliente()+ " - " +c.getCognome()+ " - " +c.getNome());
			AlberoClienti.abilitaAlbero();
			AlberoClienti.refresh();
			AlberoPreventivi.refresh();
		}
		else{
			PrimaryAgenteView.getInstance().setVisibleErroreRiepCliente(true);
			PrimaryAgenteView.getInstance().setErroreRiepCliente(errore);
		}
	}
	
	
	public void cancellaCliente(String id){
		
		confermaCancCliente.getInstance().setCliente(id);
		confermaCancCliente.getInstance().setVisible(true);
	}
		
		
	public M_Cliente [] caricaClienti() throws PersistentException {
		
		M_Cliente [] listClienti = null;
		listClienti = M_Cliente.caricaClientiAgente();
		return listClienti;
	}
		
		
	public void apriViewCercaCliente() throws PersistentException {
		//relativo alla ricerca del cliente in nuovo preventivo
		
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciClienteAgente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);
	} 
		
		
	public void newCliente() {	
		
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.initDettaglioCliente();
		AlberoClienti.disabilitaAlbero();
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(false);
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(false);
		PrimaryAgenteView.getInstance().setEnableCercaCliente(false);
		PrimaryAgenteView.getInstance().setEnableUpdateCliente(false);
	}
	
	
	public void annullaNewCliente() {
		
		PrimaryAgenteView.getInstance().resetNuovoCliente();
		PrimaryAgenteView.getInstance().setVisibleErroreNuovoCliente(false);
	}
	
	
	public void esciNewCliente() {
		
		PrimaryAgenteView.getInstance().resetNuovoCliente();
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.getInstance().setSfondoCliente();
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(true);
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableCercaCliente(true);
		PrimaryAgenteView.getInstance().setEnableUpdateCliente(true);
		PrimaryAgenteView.getInstance().setVisibleErroreNuovoCliente(false);
		AlberoClienti.abilitaAlbero();
	}
	
	
	public void btnCerca() {	
		
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.getInstance().setSfondoCliente();
		try {
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciClienteAgente.getInstance().caricaClienti());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_cliente.getInstance().setVisible(true);
	}
	
	
	public void abilitaModifica() {

		PrimaryAgenteView.getInstance().setModifiche(true);
		PrimaryAgenteView.getInstance().setLabel(true);
		PrimaryAgenteView.getInstance().disattivaModifica(false);
		PrimaryAgenteView.getInstance().disattivaCancella(false);
		PrimaryAgenteView.getInstance().disattivaInviaPosta(false);
		PrimaryAgenteView.getInstance().disattivaSalvaModifiche(true);
		PrimaryAgenteView.getInstance().disattivaAnnullaModifiche(true);
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(false);
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(false);
		PrimaryAgenteView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryAgenteView.getInstance().setEnableNewCliente(false);
		PrimaryAgenteView.getInstance().setEnableCercaCliente(false);
		PrimaryAgenteView.getInstance().setEnableUpdateCliente(false);
		PrimaryAgenteView.getInstance().setVisibleToolTip();
		AlberoClienti.disabilitaAlbero();
	}
		
	
	public void annullaModificheCliente(String id) throws PersistentException {
		
		PrimaryAgenteView.getInstance().resetCliente();
		int idCliente=Integer.parseInt(id);
		recuperaCliente(idCliente);
		
		PrimaryAgenteView.getInstance().disattivaModifica(true);
		PrimaryAgenteView.getInstance().disattivaCancella(true);
		PrimaryAgenteView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryAgenteView.getInstance().disattivaInviaPosta(true);
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(true);
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableNewCliente(true);
		PrimaryAgenteView.getInstance().setEnableCercaCliente(true);
		PrimaryAgenteView.getInstance().setEnableUpdateCliente(true);
		PrimaryAgenteView.getInstance().setInvisibleToolTip();
		PrimaryAgenteView.getInstance().setLabel(false);
		AlberoClienti.abilitaAlbero();
	}
	
	
	public void postConfermaCancCliente(String id) throws PersistentException {
		
		int idCliente=Integer.parseInt(id);
		
		M_Cliente cliente=M_Cliente.cercaCliente(idCliente);
		cliente.setAttivo(0);
		cliente.setVersione(cliente.getVersione()+1);
		M_Cliente.aggiornaCliente(cliente);

		AlberoClienti.rimuoviNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
		confermaCancCliente.getInstance().setVisible(false);		
		confermaCancCliente.cancInst();
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.getInstance().setSfondoCliente();
	}
	
	
	public void notConfermaCancCliente(){
		confermaCancCliente.getInstance().setVisible(false);
		confermaCancCliente.cancInst();
	}
	

	public void mostraCliente(Object obj) throws PersistentException {
		
		if(((DefaultMutableTreeNode)obj).isLeaf()) {
			
			String c=obj.toString();
			int i=0;
			i = c.indexOf(" -");
			if(i!=-1){
				c = c.substring(0, i);
				int id=Integer.parseInt(c);
				PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
				recuperaCliente(id);
				PrimaryAgenteView.getInstance().setVisibleErroreRiepCliente(false);
				PrimaryAgenteView.getInstance().setEnableTabCatalogo(true);
				PrimaryAgenteView.getInstance().setEnableTabPreventivo(true);}
			}
			else {
				PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
				PrimaryAgenteView.getInstance().setSfondoCliente();
			}
	}	
	

	public String mostraScontoCliente(int idSconto) throws PersistentException{
		
		String scnt = "0%";
		
		M_Sconto sconto = M_Sconto.caricaSconto(idSconto);		
		
		if (sconto instanceof M_ScontoCliente){
			scnt = ((M_ScontoCliente) sconto).getPercent()*100 + "%"; 
		}
		return scnt;
	}
	
}
