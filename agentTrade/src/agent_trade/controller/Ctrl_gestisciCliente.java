package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.orm.PersistentException;

import agent_trade.model.M_Cliente;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.clienti.confermaCancCliente;
import agent_trade.ui.primaryView.PrimaryViewFactory;
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
	
	private String ControlloCampi(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax){
		
		String errore= null;
		String campoErrato = "";
		
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || citta.equals("") || cap.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || cellulare.equals("") || fax.equals("")){
			return errore = Costanti.MESSAGGIO_CAMPI_VUOTI;
		}
		if(!check(Costanti.REG_EX_COGNOME, cognome)){
			campoErrato = campoErrato + "cognome ";
		}
		if(!check(Costanti.REG_EX_NOME, nome)){
			campoErrato = campoErrato + "nome ";
		}
		if(!check(Costanti.REG_EX_COD_FISC, codFiscale)){
			campoErrato = campoErrato + "codice fiscale ";
		}
		if(!check(Costanti.REG_EX_PART_IVA, partitaIva)){
			campoErrato = campoErrato + "partita iva ";
		}
		if(!check(Costanti.REG_EX_INDIRIZZO, indirizzo)){
			campoErrato = campoErrato +"indirizzo ";
		}
		if(!check(Costanti.REG_EX_CITTA, citta)){
			campoErrato = campoErrato +"città ";
		}
		if(!check(Costanti.REG_EX_CAP, cap)){
			campoErrato = campoErrato +"cap ";
		}
		if(!check(Costanti.REG_EX_TELEFONO, telefono)){
			campoErrato = campoErrato +"telefono ";
		}
		if(!check(Costanti.REG_EX_CELLULARE, cellulare)){
			campoErrato = campoErrato +"cellulare ";
		}
		if(!check(Costanti.REG_EX_FAX, fax)){
			campoErrato = campoErrato +"fax ";
		}
		if(!check(Costanti.REG_EX_EMAIL, email)){
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
			
			M_Cliente [] listClienti = M_Cliente.caricaClientiParametri(c, pi, cf, city);
			
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
	
	
	public void recuperaCliente(int idCliente) throws PersistentException
	{	
	
			PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
			
			M_Cliente cliente = M_Cliente.cercaCliente(idCliente);
			
			Ricerca_cliente.getInstance().dispose();
			Ricerca_cliente.cancInstanza();
			
			PrimaryViewFactory.initRiepilogoClienteView();
			PrimaryViewFactory.getInstance().setSchedaCliente(""+cliente.getIdCliente(), cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getCitta(),cliente.getCAP(),cliente.getEmail(),cliente.getTelefono(),cliente.getCell(),cliente.getFax(), cliente.getAgenteAssociato());
			PrimaryViewFactory.getInstance().disattivaSalvaModifiche(false);
			PrimaryViewFactory.getInstance().disattivaAnnullaModifiche(false);
			PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
			PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
			PrimaryViewFactory.getInstance().setVisibleErroreRiepCliente(false);
			AlberoClienti.abilitaAlbero();
			AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}
	
	
	public void inserisciNuovoCliente(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
//		la stringa errore serve per il controllo campi se viene restituita null vuol dire che non ci sono errori
		String errore= ControlloCampi(nome, cognome, codFiscale, partitaIva, citta, cap, indirizzo, email, telefono, cellulare, fax);
		if(errore==null)
		{
			M_Cliente cliente = new M_Cliente();
				
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_iva(partitaIva);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setFax(fax);
			cliente.setCitta(citta);
			cliente.setCAP(cap);
			cliente.setCell(cellulare);
			cliente.setAttivo(1);
			
			M_Cliente.salvaCliente(cliente);

			PrimaryViewFactory.getInstance().resetNuovoCliente();
			PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
				
			int id = M_Cliente.getMaxId();
			recuperaCliente(id);
				
			AlberoClienti.inserisciNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
			
			PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
			PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
			PrimaryViewFactory.getInstance().setEnableCercaCliente(true);
			
		}
		else{
			PrimaryViewFactory.getInstance().setVisibleErroreNuovoCliente(true);
			DettaglioClienteView.getInstance().setErrore(errore);
		}
	}
	
	
	public void modificaCliente(int id, String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
		String errore = ControlloCampi(nome, cognome, codFiscale, partitaIva, citta, cap, indirizzo, email, telefono, cellulare, fax);
		
		if(errore == null)
		{	
			M_Cliente cliente = M_Cliente.cercaCliente(id);
		
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_iva(partitaIva);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setFax(fax);
			//cliente.setAgenteAssociato(Ctrl_System.getAgenteLog());			
			cliente.setCitta(citta);
			cliente.setCAP(cap);
			cliente.setCell(cellulare);
			
			M_Cliente.aggiornaCliente(cliente);
							
			PrimaryViewFactory.getInstance().resetCliente();
			PrimaryViewFactory.getInstance().disattivaModifica(true);
			PrimaryViewFactory.getInstance().disattivaSalvaModifiche(false);
			PrimaryViewFactory.getInstance().disattivaCancella(true);
			PrimaryViewFactory.getInstance().disattivaAnnullaModifiche(false);
			PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
			PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
			PrimaryViewFactory.getInstance().setEnableNewCliente(true);
			PrimaryViewFactory.getInstance().setEnableCercaCliente(true);
			PrimaryViewFactory.getInstance().disattivaInviaPosta(true);
			PrimaryViewFactory.getInstance().setInvisibleToolTip();
			AlberoClienti.updateNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
								
		}
		else{
			PrimaryViewFactory.getInstance().setVisibleErroreRiepCliente(true);
			RiepilogoClienteView.getInstance().setErrore(errore);
		}
	}
	

	public void cancellaCliente(String id){
		
		confermaCancCliente.getInstance().setCliente(id);
		confermaCancCliente.getInstance().setVisible(true);
	}
	
	//bisogna decidere il criterio di caricamento. Decidere se è adeguata questa struttura dati
	public M_Cliente [] caricaClienti() throws PersistentException 
	{
		M_Cliente [] listClienti = M_Cliente.caricaClientiAgente();
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
		PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
		PrimaryViewFactory.initDettaglioCliente();
		AlberoClienti.disabilitaAlbero();
		PrimaryViewFactory.getInstance().setEnableTabPreventivo(false);
		PrimaryViewFactory.getInstance().setEnableTabCatalogo(false);
		PrimaryViewFactory.getInstance().setEnableCercaCliente(false);
	}
	
	public void annullaNewCliente()
	{
		PrimaryViewFactory.getInstance().resetNuovoCliente();
		PrimaryViewFactory.getInstance().setVisibleErroreNuovoCliente(false);
	}
	
	public void esciNewCliente() {
		
		PrimaryViewFactory.getInstance().resetNuovoCliente();
		PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
		PrimaryViewFactory.getInstance().setSfondoCliente();
		PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
		PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
		PrimaryViewFactory.getInstance().setEnableCercaCliente(true);
		PrimaryViewFactory.getInstance().setVisibleErroreNuovoCliente(false);
		AlberoClienti.abilitaAlbero();
		
	}
	
	public void btnCerca() 
	{	
		PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
		PrimaryViewFactory.getInstance().setSfondoCliente();
		try {
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_cliente.getInstance().setVisible(true);
		
	}
	
	public void abilitaModifica()
	{

		PrimaryViewFactory.getInstance().setModifiche(true);
		PrimaryViewFactory.getInstance().disattivaModifica(false);
		PrimaryViewFactory.getInstance().disattivaCancella(false);
		PrimaryViewFactory.getInstance().disattivaInviaPosta(false);
		PrimaryViewFactory.getInstance().disattivaSalvaModifiche(true);
		PrimaryViewFactory.getInstance().disattivaAnnullaModifiche(true);
		PrimaryViewFactory.getInstance().setEnableTabCatalogo(false);
		PrimaryViewFactory.getInstance().setEnableTabPreventivo(false);
		PrimaryViewFactory.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryViewFactory.getInstance().setEnableNewCliente(false);
		PrimaryViewFactory.getInstance().setEnableCercaCliente(false);
		PrimaryViewFactory.getInstance().setVisibleToolTip();
		AlberoClienti.disabilitaAlbero();
	}
		
	public void annullaModificheCliente(String id) throws PersistentException
	{
		PrimaryViewFactory.getInstance().resetCliente();
//		M: trasforma stringa in intero
		int idCliente=Integer.parseInt(id);
		recuperaCliente(idCliente);
		PrimaryViewFactory.getInstance().disattivaModifica(true);
		PrimaryViewFactory.getInstance().disattivaCancella(true);
		PrimaryViewFactory.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryViewFactory.getInstance().disattivaInviaPosta(true);
		PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
		PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
		PrimaryViewFactory.getInstance().setEnableNewCliente(true);
		PrimaryViewFactory.getInstance().setEnableCercaCliente(true);
		PrimaryViewFactory.getInstance().setInvisibleToolTip();
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
		PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
		PrimaryViewFactory.getInstance().setSfondoCliente();
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
				PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
				recuperaCliente(id);
				PrimaryViewFactory.getInstance().setVisibleErroreRiepCliente(false);
				PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
				PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);}
		}
			else {
				PrimaryViewFactory.getInstance().resetPannelloCentraleCliente();
				PrimaryViewFactory.getInstance().setSfondoCliente();
			}
	}	
}
