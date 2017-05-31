package agent_trade.model;

import org.hibernate.criterion.Projections;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.AziendaCriteria;
import agent_trade.persistent.Rem_AziendaCriteria;




public class M_Azienda {

	private static agent_trade.model.M_Azienda instance;
	/*attributi di classe*/
	
	/*attributi privati*/
	private int idAzienda;
	private String ragioneSociale;
	private String codiceFiscale;
	private String partitaIva;
	private String citta;
	private String cap;
	private String Indirizzo;
	private String email;
	private String telefono;
	private String fax;
	private String url;
	private String tipoProdotto;

	/*costruttori*/
	
	public M_Azienda(){
	}
	
	public M_Azienda (String ragioneSociale, String citta, String CAP, String Indirizzo, String telefono, String fax, String email, String partita_iva, String codice_fiscale, String url, String tipo)
	{
		this.ragioneSociale=ragioneSociale;
		this.citta=citta;
		this.cap=CAP;
		this.Indirizzo=Indirizzo;
		this.telefono=telefono;
		this.fax=fax;
		this.email=email;
		this.partitaIva=partita_iva;
		this.codiceFiscale=codice_fiscale;
		this.url=url;
		this.tipoProdotto=tipo;
	}
	
	
	/*metodi di classe*/
	
	public static M_Azienda getInstance(){

		return ((instance == null) ? instance = new M_Azienda() : instance);	
	}
	
	public static M_Azienda[] caricaAziendeRemoto()throws PersistentException{
		
		Rem_AziendaCriteria criteriaAzienda;
		try {
			criteriaAzienda = new Rem_AziendaCriteria();
			//criteriaAzienda.attivo.eq(1);
			
			return criteriaAzienda.listM_Azienda();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static M_Azienda[] caricaAziendeRemotoParametri(String ragSoc, String pIva, String codFis, String citta) throws PersistentException{
		
		Rem_AziendaCriteria criteriaAzienda;
		try {
			criteriaAzienda = new Rem_AziendaCriteria();
			
			criteriaAzienda.ragioneSociale.like("%"+ragSoc+"%");
			criteriaAzienda.partitaIva.like("%"+pIva+"%");
			criteriaAzienda.codiceFiscale.like("%"+codFis+"%");
			criteriaAzienda.citta.like("%"+citta+"%");
			
			return criteriaAzienda.listM_Azienda();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static M_Azienda cercaAziendaRemoto(int idAzienda) throws PersistentException {
		try{
			
			Rem_AziendaCriteria criteriaAzienda = new Rem_AziendaCriteria();
			criteriaAzienda.IdAzienda.eq(idAzienda);
			//criteriaAzienda.attivo.eq(1);

			return criteriaAzienda.uniqueM_Azienda();
		}
		finally {	
		}
	}

	public static M_Azienda cercaAziendaNome(String nome) throws PersistentException {
		try{
			
			AziendaCriteria criteriaAzienda = new AziendaCriteria();
			criteriaAzienda.ragioneSociale.eq(nome);
			//criteriaAzienda.attivo.eq(1);
			return criteriaAzienda.uniqueM_Azienda();
		}
		finally {	
		}
	}
	
	
	public static M_Azienda caricaAziendaId (int id) throws PersistentException {
		try{
			
			AziendaCriteria criteriaAzienda = new AziendaCriteria();
			criteriaAzienda.IdAzienda.eq(id);
			//criteriaAzienda.attivo.eq(1);
			return criteriaAzienda.uniqueM_Azienda();
		}
		finally {	
		}
	}
	

	public static M_Azienda[] caricaAziende() throws PersistentException {
		try{
			
			AziendaCriteria criteriaAzienda = new AziendaCriteria();
			//criteriaAzienda.attivo.eq(1);
			criteriaAzienda.setMaxResults(1000);

			return criteriaAzienda.listM_Azienda();
		}
		finally {	
		}
	}
	
	public static void aggiornaAziendaRemoto(M_Azienda a) throws PersistentException{
		
		PersistentTransaction t =  AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {
			 AgentTradeMandantePersistentManager.instance().getSession().update(a);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {

		}
	}
	
	public static void salvaAziendaRemoto(M_Azienda a) throws PersistentException {

		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().save(a);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	
	public static void salvaAzienda(M_Azienda a) throws PersistentException {

		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().save(a);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	
	public static void cancellaAziendaRemoto(M_Azienda a) throws PersistentException {

		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().delete(a);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}

	public static int getMaxIdRemoto() throws PersistentException{
		
		try 
		{				
			Rem_AziendaCriteria criteriaAzienda = new Rem_AziendaCriteria();
			criteriaAzienda.setProjection(Projections.max("id"));
			int id =(int) criteriaAzienda.uniqueResult();
			return id;
		}
		finally {
		}
	}

	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	private void setIdAzienda(int value) {
		this.idAzienda = value;
	}
	
	public int getIdAzienda() {
		return idAzienda;
	}
	
	public int getORMID() {
		return getIdAzienda();
	}
	
	public void setRagioneSociale(String value) {
		this.ragioneSociale = value;
	}
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	
	public void setCitta(String value) {
		this.citta = value;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCap(String value) {
		this.cap = value;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setIndirizzo(String value) {
		this.Indirizzo = value;
	}
	
	public String getIndirizzo() {
		return Indirizzo;
	}
	
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setFax(String value) {
		this.fax = value;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPartitaIva(String value) {
		this.partitaIva = value;
	}
	
	public String getPartitaIva() {
		return partitaIva;
	}
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
	
	public String getTipoProdotto(){
		return tipoProdotto;
	}
	public void setTipoProdotto(String tipo){
		this.tipoProdotto = tipo;
	}
	
	public String toString() {
		return String.valueOf(getIdAzienda());
	}


}