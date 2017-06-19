package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.ui.content.agenti.Ricerca_agente;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.clienti.confermaCancCliente;
import agent_trade.ui.content.sconti.riepilogo.Ricerca_sconto;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciCliente {

	
	/*attributi di classe*/
	
	private static Ctrl_gestisciCliente instance;
	
	/*attributi privati*/

	
	/*costruttori*/
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciCliente getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciCliente() : instance);	
	}

	
	//OSS: bisogna rivedere tutto il codice perche alune operazioni vengono 
	//fatte a prescindere ed invece, andrebbero fatte solo se sul db è tutto ok. 
	//Esempio, se cancello un cliente ma sul db ci sono stati problemi,
	//il software mostra tutto come se è andato ok

	
	
	/*metodi privati*/
	
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
		
		if(cliente.getNome().equals("") || cliente.getCognome().equals("") || cliente.getCodice_fiscale().equals("") || cliente.getPartita_iva().equals("") || cliente.getCitta().equals("") || cliente.getCAP().equals("") || cliente.getIndirizzo().equals("") || cliente.getEmail().equals("") || cliente.getTelefono().equals("") || cliente.getCell().equals("") || cliente.getFax().equals("")){
			return errore = Costanti.MESSAGGIO_CAMPI_VUOTI;
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
		if(!check(Costanti.REG_EX_TELEFONO, cliente.getTelefono())){
			campoErrato = campoErrato +"telefono ";
		}
		if(!check(Costanti.REG_EX_CELLULARE, cliente.getCell())){
			campoErrato = campoErrato +"cellulare ";
		}
		if(!check(Costanti.REG_EX_FAX, cliente.getFax())){
			campoErrato = campoErrato +"fax ";
		}
		if(!check(Costanti.REG_EX_EMAIL, cliente.getEmail())){
			campoErrato = campoErrato +"email ";
		}
		if (errore == null && campoErrato != "")
		{
			errore = Costanti.MESSAGGIO_CAMPI_ERRATI + campoErrato;
		}
		return errore;
	}
	
	
	/*metodi pubblici*/
	
	//serve in nuovo preventivo per cercare ed inserire i clienti
	public void cercaCliente(String c) throws PersistentException//qui andrebbe cambiato il modo di ricerca
	{
		if (c.equals("") || c==null){
			CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		else
		{
			M_Cliente [] listClienti = M_Cliente.caricaClientiCognome(c);
						
			if (listClienti.length!=0)
			{
				CercaClienteView.getInstance().popolaTab(listClienti);
			}
			else{		
				CercaClienteView.getInstance().setErrore(Costanti.MESSAGGIO_CLIENTE_NON_TROVATO);
			}
		}
	}
	
	//per la tabella cerca cliente in gestione cliente
	public void ricercaCliente(String c, String pi, String cf, String city) throws PersistentException
	{
		if ((c.equals("") || c==null) && (pi.equals("") || pi==null) && (cf.equals("") || cf==null) && (city.equals("") || city==null)){
			
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		else {
			
			M_Cliente [] listClienti = null;
//			A seconda della versione carico i clienti relativi all'agente o al mandante
			if(Costanti.version.equals(Costanti.agente)){
				listClienti = M_Cliente.caricaClientiParametri(c, pi, cf, city);
			}
			else if(Costanti.version.equals(Costanti.mandante)){
				listClienti = M_Cliente.caricaClientiParametriRemoto(c, pi, cf, city);
			}
			
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
	
	
	public void recuperaCliente(int idCliente) throws PersistentException{

		if(Costanti.version.equals(Costanti.agente)){
			recuperaClienteAgente(idCliente);
		}
		else if(Costanti.version.equals(Costanti.mandante)){
			recuperaClienteMandante(idCliente);
		}
	}
	
	
	public void recuperaClienteAgente(int idCliente) throws PersistentException
	{	
	
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
	
	
	public void recuperaClienteMandante(int idCliente) throws PersistentException
	{	
		
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
	
	
	public void inserisciNuovoCliente(M_Cliente cliente) throws PersistentException
	{
//		la stringa errore serve per il controllo campi se viene restituita null vuol dire che non ci sono errori
		String errore= ControlloCampi(cliente);
		if(errore==null)
		{
			
			cliente.setAttivo(1);
			cliente.setVersione(1);
			M_ScontoCliente scontoBase = M_ScontoCliente.caricaScontoBase();
			cliente.setSconto(scontoBase.getId());
			
			M_Cliente.salvaCliente(cliente);

			PrimaryAgenteView.getInstance().resetNuovoCliente();
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
			DettaglioClienteView.getInstance().setErrore(errore);
		}
	}
	
	
	public void modificaCliente(M_Cliente c) throws PersistentException{
		
		if(Costanti.version.equals(Costanti.agente)){
			modificaClienteAgente(c);
		}
		else if(Costanti.version.equals(Costanti.mandante)){
			modificaClienteMandante(c);
		}
	}
	
	
	public void modificaClienteAgente(M_Cliente c) throws PersistentException
	{
		String errore = ControlloCampi(c);
		
		if(errore == null)
		{				
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
			AlberoClienti.updateNodo(c.getIdCliente()+ " - " +c.getCognome()+ " - " +c.getNome());
			AlberoClienti.selectNode(c.getIdCliente()+ " - " +c.getCognome()+ " - " +c.getNome());
			AlberoClienti.abilitaAlbero();
								
		}
		else{
			PrimaryAgenteView.getInstance().setVisibleErroreRiepCliente(true);
			RiepilogoClienteView.getInstance().setErrore(errore);
		}
	}
	
	
	public void modificaClienteMandante(M_Cliente c) throws PersistentException
	{
		M_Cliente.updateClienteRemoto(c);
	}
	

	public void cancellaCliente(String id){
		
		confermaCancCliente.getInstance().setCliente(id);
		confermaCancCliente.getInstance().setVisible(true);
	}
	
	//bisogna decidere il criterio di caricamento. Decidere se è adeguata questa struttura dati
	public M_Cliente [] caricaClienti() throws PersistentException 
	{
		M_Cliente [] listClienti = null;
//		A seconda della versione carico i clienti relativi all'agente o al mandante
		if(Costanti.version.equals(Costanti.agente)){
			listClienti = M_Cliente.caricaClientiAgente();
		}
		else if(Costanti.version.equals(Costanti.mandante)){
			listClienti = M_Cliente.caricaClientiRemoto();
		}
		return listClienti;
	}

	public void apriViewCercaCliente() throws PersistentException
	{
		//relativo alla ricerca del cliente in nuovo preventivo
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);
	} 
	
	public void newCliente()
	{	
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.initDettaglioCliente();
		AlberoClienti.disabilitaAlbero();
		PrimaryAgenteView.getInstance().setEnableTabPreventivo(false);
		PrimaryAgenteView.getInstance().setEnableTabCatalogo(false);
		PrimaryAgenteView.getInstance().setEnableCercaCliente(false);
		PrimaryAgenteView.getInstance().setEnableUpdateCliente(false);

	}
	
	public void annullaNewCliente()
	{
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
	
	
	public void btnCerca(){
		
		if(Costanti.version.equals(Costanti.agente)){
			btnCercaClientiAgente();
		}
		else if(Costanti.version.equals(Costanti.mandante)){
			btnCercaClientiMandante();
		}
	}
	
	
	public void btnCercaClientiAgente() 
	{	
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.getInstance().setSfondoCliente();
		try {
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_cliente.getInstance().setVisible(true);
		
	}
	
	
	public void btnCercaClientiMandante() {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleCliente();
		PrimaryMandanteView.getInstance().setSfondoCliente();
		try {
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_cliente.getInstance().setVisible(true);
			
	}
	
	
	public void abilitaModifica()
	{

		PrimaryAgenteView.getInstance().setModifiche(true);
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
		
	public void annullaModificheCliente(String id) throws PersistentException
	{
		PrimaryAgenteView.getInstance().resetCliente();
//		M: trasforma stringa in intero
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
		AlberoClienti.abilitaAlbero();
	}
	
	public void postConfermaCancCliente(String id) throws PersistentException{
		
		int idCliente=Integer.parseInt(id);
		
		M_Cliente cliente=M_Cliente.cercaCliente(idCliente);
		cliente.setAttivo(0);
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
		
		if(((DefaultMutableTreeNode)obj).isLeaf())
		{
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
	
//	DA RIVEDERE NON SO SE VA BENE
	public String mostraScontoCliente(int idSconto) throws PersistentException{
		
		String scnt = "0%";
		
		M_Sconto sconto = M_Sconto.caricaSconto(idSconto);		
		
		if (sconto instanceof M_ScontoCliente){
			scnt = ((M_ScontoCliente) sconto).getPercent()*100 + "%"; 
		}
		return scnt;
	}
	
//	SPOSTARE IN CTRL SCONTO?
	public void btnCercaSconto() throws PersistentException{
		
		Ricerca_sconto.getInstance().popolaTab(M_Sconto.caricaScontiRemoto());
		Ricerca_sconto.getInstance().setVisibleBtnVisualizza(false);
		Ricerca_sconto.getInstance().setVisibleBtnModifica(true);
		Ricerca_sconto.getInstance().setVisible(true);
		
	}
		
//	SPOSTARE IN CTRL SCONTO?	
	public void assegnaSconto(int idSconto) throws PersistentException{
		
		Ricerca_sconto.getInstance().dispose();
		Ricerca_sconto.cancInstanza();
		
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(idSconto);
		
		PrimaryMandanteView.getInstance().setScontoCliente(sconto);
	}
		
//	SPOSTARE IN CTRL AGENTE?
	public void btnCercaAgente()throws PersistentException{
		
		Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgentiRemoto());
		Ricerca_agente.getInstance().setVisibleBtnVisualizza(false);
		Ricerca_agente.getInstance().setVisibleBtnModifica(true);
		Ricerca_agente.getInstance().setVisible(true);
	}
		
//	SPOSTARE IN CTRL AGENTE?
	public void assegnaAgente(int idAgente) throws PersistentException{
		
		Ricerca_agente.getInstance().dispose();
		Ricerca_agente.cancInstanza();
		
		M_Agente agenteRif = M_Agente.cercaAgenteRemoto(idAgente);
		
		PrimaryMandanteView.getInstance().setAgenteRif(agenteRif);
	}
	
	
}
