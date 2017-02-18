package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Cliente;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.ClienteCriteria;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.clienti.confermaCancCliente;

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
			return errore= "inserisci tutti i campi";
		}
		if(!check("[a-zA-Z'._%-& \\s]+", cognome)){
			campoErrato=campoErrato + "cognome ";
		}
		if(!check("[a-zA-Z'\\s]+", nome)){
			campoErrato= campoErrato + "nome ";
		}
		if(!check("[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]", codFiscale)){
			campoErrato=campoErrato + "codice fiscale ";
		}
		if(!check("[0-9]{11}", partitaIva)){
			campoErrato=campoErrato + "partita iva ";
		}
		if(!check("[a-zA-Z'. \\s]+[0-9]{0,4}", indirizzo)){
			campoErrato= campoErrato +"indirizzo ";
		}
		if(!check("[a-zA-Z'\\s]+", citta)){
			campoErrato= campoErrato +"città ";
		}
		if(!check("[0-9]{5}", cap)){
			campoErrato= campoErrato +"cap ";
		}
		if(!check("[0-9]{10}", telefono)){
			campoErrato= campoErrato +"telefono ";
		}
		if(!check("[0-9]{10}", cellulare)){
			campoErrato= campoErrato +"cellulare ";
		}
		if(!check("[0-9]{10}", fax)){
			campoErrato= campoErrato +"fax ";
		}
		if(!check("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email)){
			campoErrato= campoErrato +"email ";
		}
		if (errore == null && campoErrato != "")
		{
			errore= "I seguenti campi sono errati: "+ campoErrato;
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
			M_Cliente [] listClienti=null;

			try{
				
				ClienteCriteria criteriaCliente= new ClienteCriteria();
				
				//JOIN per recuperare solo i clienti dell'agente loggato
				criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			
				//BISOGNA RIPORTARE LA STRINGA TUTTA IN MINUSCOLO PERCHE è CASE SENSITIVE				
				criteriaCliente.cognome.like("%"+c+"%");
				
				listClienti = criteriaCliente.listCliente();

			}
			finally {
				AgentTradePersistentManager.instance().disposePersistentManager();
			}
						
			if (listClienti.length!=0)
			{
				CercaClienteView.getInstance().popolaTab(listClienti);
			}
			else{		
				CercaClienteView.getInstance().setErrore("Cliente non trovato");
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
			
			M_Cliente [] listClienti=null;
			
			try{
				
				ClienteCriteria criteriaCliente= new ClienteCriteria();
				
				//JOIN per recuperare solo i clienti dell'agente loggato
				criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
				
				//BISOGNA RIPORTARE LA STRINGA TUTTA IN MINUSCOLO PERCHE è CASE SENSITIVE				
				criteriaCliente.cognome.like("%"+c+"%");
				criteriaCliente.partita_iva.like("%"+pi+"%");
				criteriaCliente.codice_fiscale.like("%"+cf+"%");
				criteriaCliente.citta.like("%"+city+"%");
			
				listClienti = criteriaCliente.listCliente();

			}
			finally {
				AgentTradePersistentManager.instance().disposePersistentManager();
			}
			
			if(listClienti.length==0) {
		
				Ricerca_cliente.getInstance().setErrore("Cliente non trovato");
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
	
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			
			ClienteCriteria criteria= new ClienteCriteria();
			criteria.idCliente.eq(idCliente);
			criteria.agenteAssociato.equals(Ctrl_System.getInstance());

			M_Cliente cliente = criteria.listCliente()[0];
			
			Ricerca_cliente.getInstance().dispose();
			Ricerca_cliente.cancInstanza();
			
			PrimaryView.initRiepilogoClienteView();
			PrimaryView.getInstance().setSchedaCliente(""+cliente.getIdCliente(), cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getCitta(),cliente.getCAP(),cliente.getEmail(),cliente.getTelefono(),cliente.getCell(),cliente.getFax(), cliente.getAgenteAssociato());
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
			AlberoClienti.abilitaAlbero();
			AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}
	
	
	public void inserisciNuovoCliente(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
//		la stringa errore serve per il controllo campi se viene restituita null vuol dire che non ci sono errori
		String errore= ControlloCampi(nome, cognome, codFiscale, partitaIva, citta, cap, indirizzo, email, telefono, cellulare, fax);
		if(errore==null)
		{
			PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
			try 
			{				
				M_Cliente cliente=new M_Cliente();
				
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
				
				AgentTradePersistentManager.instance().getSession().save(cliente);
				
				// commit per il salvataggio
				t.commit();

				PrimaryView.getInstance().resetNuovoCliente();
				PrimaryView.getInstance().resetPannelloCentraleCliente();
				
				//Che fa?? secondo me ha un alto accoppiamento e una bassa coesione
//				M: SERVE PER VISUALIZZARE IL CLIENTE APPENA INSERITO MA COME LO RECUPERO SE NON CONOSCO ANCORA L'ID?
				
//				M: MODIFICHE PER RECUPERARE ULTIMO ID (prossime 3 righe)
				ClienteCriteria criteria= new ClienteCriteria();
				criteria.setProjection(Projections.max("id"));
				int id=(int) criteria.uniqueResult();
				
				recuperaCliente(id);
				
				AlberoClienti.inserisciNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
				AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
				AlberoClienti.abilitaAlbero();
			
				PrimaryView.getInstance().setEnableTabPreventivo(true);
				PrimaryView.getInstance().setEnableTabCatalogo(true);
				PrimaryView.getInstance().setEnableCercaCliente(true);
			}
			
			catch (Exception e) {
				t.rollback();
			}
			finally {
				AgentTradePersistentManager.instance().disposePersistentManager();
			}
		}
		else{
			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
			DettaglioClienteView.getInstance().setErrore(errore);
		}
	}
	
	
	public void modificaCliente(int id, String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
		String errore= ControlloCampi(nome, cognome, codFiscale, partitaIva, citta, cap, indirizzo, email, telefono, cellulare, fax);
		
		if(errore==null)
		{	
			M_Cliente cliente = null;	
			try{
				
				ClienteCriteria criteriaCliente= new ClienteCriteria();
				
				//JOIN per recuperare solo i clienti dell'agente loggato
				criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
				criteriaCliente.idCliente.eq(id);
				
				cliente = criteriaCliente.listCliente()[0];

			}
			finally {
				AgentTradePersistentManager.instance().disposePersistentManager();
			}
		
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_iva(partitaIva);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setFax(fax);
			cliente.setAgenteAssociato(Ctrl_System.getAgenteLog());			
			cliente.setCitta(citta);
			cliente.setCAP(cap);
			cliente.setCell(cellulare);
			
			PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
			try {
				AgentTradePersistentManager.instance().getSession().update(cliente);
				t.commit();
			}
			catch (Exception e) {
				t.rollback();
			}
							
			PrimaryView.getInstance().resetCliente();
			PrimaryView.getInstance().disattivaModifica(true);
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaCancella(true);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setEnableNewCliente(true);
			PrimaryView.getInstance().setEnableCercaCliente(true);
			PrimaryView.getInstance().disattivaInviaPosta(true);
			PrimaryView.getInstance().setInvisibleToolTip();
			AlberoClienti.updateNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
			
			
						
		}
		else{
			PrimaryView.getInstance().setVisibleErroreRiepCliente(true);
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
		M_Cliente [] listClienti=null;
		try{
			
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			listClienti = criteriaCliente.listCliente();
//
//			for (M_Cliente cLoad : listClienti) {
//				//aggiustare, crea doppioni nell albero
//				AlberoClienti.inserisciNodo(cLoad.getCognome()+ " - " +cLoad.getNome());
//			}
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
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
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.initDettaglioCliente();
		AlberoClienti.disabilitaAlbero();
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
		PrimaryView.getInstance().setEnableCercaCliente(false);
	}
	
	public void annullaNewCliente()
	{
		PrimaryView.getInstance().resetNuovoCliente();
		PrimaryView.getInstance().setVisibleErroreNuovoCliente(false);
	}
	
	public void esciNewCliente() {
		
		PrimaryView.getInstance().resetNuovoCliente();
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
		PrimaryView.getInstance().setEnableTabCatalogo(true);
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		PrimaryView.getInstance().setEnableCercaCliente(true);
		PrimaryView.getInstance().setVisibleErroreNuovoCliente(false);
		AlberoClienti.abilitaAlbero();
		
	}
	
	public void btnCerca() 
	{	
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
		try {
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_cliente.getInstance().setVisible(true);
		
	}
	
	public void abilitaModifica()
	{

		PrimaryView.getInstance().setModifiche(true);
		PrimaryView.getInstance().disattivaModifica(false);
		PrimaryView.getInstance().disattivaCancella(false);
		PrimaryView.getInstance().disattivaInviaPosta(false);
		PrimaryView.getInstance().disattivaSalvaModifiche(true);
		PrimaryView.getInstance().disattivaAnnullaModifiche(true);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryView.getInstance().setEnableNewCliente(false);
		PrimaryView.getInstance().setEnableCercaCliente(false);
		PrimaryView.getInstance().setVisibleToolTip();
		AlberoClienti.disabilitaAlbero();
	}
		
	public void annullaModificheCliente(String id) throws PersistentException
	{
		PrimaryView.getInstance().resetCliente();
//		M: trasforma stringa in intero
		int idCliente=Integer.parseInt(id);
		recuperaCliente(idCliente);
		PrimaryView.getInstance().disattivaModifica(true);
		PrimaryView.getInstance().disattivaCancella(true);
		PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryView.getInstance().disattivaInviaPosta(true);
		PrimaryView.getInstance().setEnableTabCatalogo(true);
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		PrimaryView.getInstance().setEnableNewCliente(true);
		PrimaryView.getInstance().setEnableCercaCliente(true);
		PrimaryView.getInstance().setInvisibleToolTip();
		AlberoClienti.abilitaAlbero();
	}
	
	public void postConfermaCancCliente(String id) throws PersistentException{
		
		int idCliente=Integer.parseInt(id);
		
		M_Cliente cliente=null;
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();

		try{
			
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.idCliente.eq(idCliente);
			cliente = criteriaCliente.listCliente()[0];

			AgentTradePersistentManager.instance().getSession().delete(cliente);
			
			t.commit();
		}

		catch (Exception e) {
			t.rollback();
		}	
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
//		M: PROBLEMA CON LA SELEZIONE DELL'ALBERO
		AlberoClienti.rimuoviNodo(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
		confermaCancCliente.getInstance().setVisible(false);		
		confermaCancCliente.cancInst();
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
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
				PrimaryView.getInstance().resetPannelloCentraleCliente();
				recuperaCliente(id);
				PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
				PrimaryView.getInstance().setEnableTabCatalogo(true);
				PrimaryView.getInstance().setEnableTabPreventivo(true);}
		}
			else {
				PrimaryView.getInstance().resetPannelloCentraleCliente();
				PrimaryView.getInstance().setSfondoCliente();
			}
	}	
}
