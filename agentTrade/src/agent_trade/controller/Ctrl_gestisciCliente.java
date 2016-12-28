package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import persistent.AgentTradePersistentManager;
import persistent.ClienteCriteria;
import agent_trade.model.M_Cliente;
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

	/*metodi privati*/
	
	//a che serve?? 
	private boolean check(String regex, String input){
		
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(input);

		  if (matcher.matches())
		    return true;
		  else
		    return false;
		}
	
	private boolean ControlloCampi(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax){
		
		//PERCHE UNA FUNZIONE CHE FA UN SEMPLICE CONTROLLO FA DELLE MODIFICHE ALLA VIEW???
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
			DettaglioClienteView.getInstance().setErrore("inserisci tutti i campi");
			return false;
		}
//		if(!check("[a-zA-Z]", nome)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("nome errato");
//			return false;
//		}
//		if(!check("[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]", codFiscale)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("codice fiscale errato");
//			return false;
//		}
//		if(!check("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("emali non corretta");
//			return false;
//		}
		
		
		
		return true;
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
				persistent.AgentTradePersistentManager.instance().disposePersistentManager();
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
	public void ricercaCliente(String c) throws PersistentException
	{
		if (c.equals("") || c==null){
			
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
			
				listClienti = criteriaCliente.listCliente();

			}
			finally {
				persistent.AgentTradePersistentManager.instance().disposePersistentManager();
			}
			
			if(listClienti.length==0) {
		
				Ricerca_cliente.getInstance().setErrore("Cliente non trovato");
			}
		
			else{
				
				Ricerca_cliente.getInstance().svuotaTabella();

				for (M_Cliente cLoad : listClienti) {
					Ricerca_cliente.getInstance().updateTable(cLoad.getCognome(), cLoad.getNome(), cLoad.getCodice_fiscale(), cLoad.getPartita_iva());
				}
			}
		}
	}
	
//	a che servono due funzioni uguali? AGGIUSTARE
	public void recuperaCliente(String cognome) throws PersistentException
	{	
		
			//A CHE SERVE QUESTA FUNZIONE??
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			
			M_Cliente cliente = null;
			
			ClienteCriteria criteria= new ClienteCriteria();
			
			criteria.cognome.eq(cognome);
			criteria.agenteAssociato.equals(Ctrl_System.getInstance().getIdAgente());
			//IMPOSTARE L'ORDINAMENTO PER COGNOME E POI NOI IN ORDINE ALFABETICO
			//criteria.addOrder()
			M_Cliente [] listClienti = criteria.listCliente();
			cliente=listClienti[0];
			Ricerca_cliente.getInstance().dispose();
			Ricerca_cliente.cancInstanza();
			
			PrimaryView.initRiepilogoClienteView();
			PrimaryView.getInstance().setSchedaCliente(""+cliente.getIdCliente(), cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getCitta(),cliente.getCAP(),cliente.getEmail(),cliente.getTelefono(),cliente.getCellulare(),cliente.getFax(),"");
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
			AlberoClienti.deselezionaNodo(cognome);
			AlberoClienti.abilitaAlbero();
	}
	
	
	public void recuperaCliente(int idCliente) throws PersistentException
	{	
	
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			
			ClienteCriteria criteria= new ClienteCriteria();
			criteria.idCliente.equals(idCliente);
			criteria.agenteAssociato.equals(Ctrl_System.getInstance());

			M_Cliente cliente = criteria.listCliente()[0];
			
			Ricerca_cliente.getInstance().dispose();
			Ricerca_cliente.cancInstanza();
			
			PrimaryView.initRiepilogoClienteView();
			PrimaryView.getInstance().setSchedaCliente(""+cliente.getIdCliente(), cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getCitta(),cliente.getCAP(),cliente.getEmail(),cliente.getTelefono(),/*cliente.getCellulare(),*/"",cliente.getFax(),"");
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
			AlberoClienti.abilitaAlbero();
	}
	
	
	public void inserisciNuovoCliente(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
		if(ControlloCampi(nome, cognome, codFiscale, partitaIva, citta, cap, indirizzo, email, telefono, cellulare, fax))
		{
			PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
			try 
			{				
				M_Cliente cliente=new M_Cliente();
				
				//cliente.setAgenteAssociato(Ctrl_System.getAgenteLog());				
				cliente.setNome(nome);
				cliente.setCognome(cognome);
				cliente.setCodice_fiscale(codFiscale);
				cliente.setPartita_Iva(partitaIva);
				cliente.setIndirizzo(indirizzo);
				cliente.setEmail(email);
				cliente.setTelefono(telefono);
				cliente.setFax(fax);
				cliente.setCitta(citta);
				cliente.setCAP(cap);
				
				//mettere dopo, manca sul db
				cliente.setCellulare(cellulare);
				
				AgentTradePersistentManager.instance().getSession().save(cliente);
				
				// commit per il salvataggio
				t.commit();

				PrimaryView.getInstance().resetNuovoCliente();
				PrimaryView.getInstance().resetPannelloCentraleCliente();
				
				//Che fa?? secondo me ha un alto accoppiamento e una bassa coesione
				recuperaCliente(cognome);
				
				AlberoClienti.inserisciNodo(cliente.getCognome()+ " - " +cliente.getNome());
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
		//e se i campi non sono corretti???? che si fa???
	}
	
	
	public void modificaCliente(int id, String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
		
		//e il controllo con le espressioni regolari?
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
			PrimaryView.getInstance().setVisibleErroreRiepCliente(true);
			RiepilogoClienteView.getInstance().setErrore("inserisci tutti i campi");
		}
		else
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
				persistent.AgentTradePersistentManager.instance().disposePersistentManager();
			}
		
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_Iva(partitaIva);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setFax(fax);
			cliente.setAgenteAssociato(Ctrl_System.getAgenteLog());			
			cliente.setCitta(citta);
			cliente.setCAP(cap);
			//mettere dopo
			cliente.setCellulare(cellulare);
			
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
			AlberoClienti.updateNodo(cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
						
		}
	}
	
	//da cambiare quando avremo deciso definitivamente il db
	public void cancellaCliente(String c){
		
		confermaCancCliente.getInstance().setCliente(c);
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
			persistent.AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
		return listClienti;
	}

	public void apriViewCercaCliente() throws PersistentException
	{
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
		//rende il bottone INVIO POSTA INVISIBILE
		PrimaryView.getInstance().disattivaInviaPosta(false);
		PrimaryView.getInstance().disattivaSalvaModifiche(true);
		PrimaryView.getInstance().disattivaAnnullaModifiche(true);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryView.getInstance().setEnableNewCliente(false);
		PrimaryView.getInstance().setEnableCercaCliente(false);
		AlberoClienti.disabilitaAlbero();
	}
		
	public void annullaModificheCliente(String cognome) throws PersistentException
	{
		PrimaryView.getInstance().resetCliente();
		recuperaCliente(cognome);
		PrimaryView.getInstance().disattivaModifica(true);
		PrimaryView.getInstance().disattivaCancella(true);
		PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryView.getInstance().disattivaInviaPosta(true);
		PrimaryView.getInstance().setEnableTabCatalogo(true);
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		PrimaryView.getInstance().setEnableNewCliente(true);
		PrimaryView.getInstance().setEnableCercaCliente(true);
		AlberoClienti.abilitaAlbero();
	}
	
	public void postConfermaCancCliente(String c) throws PersistentException{
		
		M_Cliente cliente=null;
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();

		try{
			
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.cognome.eq(c);
			cliente = criteriaCliente.listCliente()[0];

			AgentTradePersistentManager.instance().getSession().delete(cliente);
			
			t.commit();
		}

		catch (Exception e) {
			t.rollback();
		}	
		finally {
			persistent.AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
		AlberoClienti.rimuoviNodo(cliente.getCognome()+ " - " +cliente.getNome());
		confermaCancCliente.getInstance().setVisible(false);		
		confermaCancCliente.cancInst();
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
	}
	
	public void notConfermaCancCliente(){
		confermaCancCliente.getInstance().setVisible(false);
		confermaCancCliente.cancInst();
	}
	
	//da modificare e fare per id (quando avremo un db)
	public void mostraCliente(Object obj) throws PersistentException {
		
		if(((DefaultMutableTreeNode)obj).isLeaf())
		{
			String c=obj.toString();
			int i=0;
			i = c.indexOf(" -");
			if(i!=-1){
				c = c.substring(0, i);
				PrimaryView.getInstance().resetPannelloCentraleCliente();
				recuperaCliente(c);
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
