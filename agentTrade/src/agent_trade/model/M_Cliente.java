/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package agent_trade.model;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.controller.Ctrl_System;
import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.ClienteCriteria;
import agent_trade.persistent.Rem_ClienteCriteria;
import agent_trade.sconti.ClienteScontoStrategy;
import agent_trade.sconti.IScontoStrategy;
import agent_trade.sconti.ScontoStrategyFactory;

public class M_Cliente implements Cloneable{

	/*
	 * attributi di classe
	 */
	
	private static M_Cliente instance;

	
	/*
	 * attributi privati
	 */
	
	private int idCliente;
	private M_Agente agenteAssociato;
	private String nome;
	private String cognome;
	private String codice_fiscale;
	private String indirizzo;
	private String email;
	private String partita_iva;
	private String telefono;
	private String fax;
	private String citta;
	private String CAP;
	private String cell;
	private int attivo;
	private int sconto;
	private int versione;
	private int versione_download;
	private int idclienteagente;



//	private IScontoStrategy strategiaCliente;
	
	/*
	 * costruttori
	 */
	

	public M_Cliente(){	
		this.agenteAssociato = Ctrl_System.getAgenteLog();
	}
	
	public M_Cliente(int id, String cognome, String nome, String cf, String pi, String ind, String em, String tel, String cel, String fax){
		this.idCliente=id;
		this.cognome=cognome;
		this.nome=nome;	
		this.codice_fiscale=cf;
		this.partita_iva=pi;
		this.email=em;
		this.indirizzo=ind;
		this.telefono=tel;
		this.cell=cel;
		this.fax=fax;
		this.agenteAssociato = Ctrl_System.getAgenteLog();
		this.idclienteagente=id;
		this.versione=1;
	}
	
	
	/*
	 * metodi di classe
	 */
	
	public static M_Cliente getInstance(){

		return ((instance == null) ? instance = new M_Cliente() : instance);	
	}
	
	
	public static M_Cliente cercaCliente(int id_cliente) throws PersistentException{
		
		try{
			
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.idCliente.eq(id_cliente);
//			criteriaCliente.attivo.eq(1);
			return criteriaCliente.uniqueM_Cliente();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	public static M_Cliente cercaClienteRemoto(int id_cliente) throws PersistentException{
		
		try{
			
			Rem_ClienteCriteria criteriaCliente= new Rem_ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.idclienteagente.eq(id_cliente);
			criteriaCliente.attivo.eq(1);
			return criteriaCliente.uniqueM_Cliente();
		}
		finally {
		}
	}
	
	public static M_Cliente cercaTuttiClienteRemoto(int id_cliente) throws PersistentException{
		
		try{
			
			Rem_ClienteCriteria criteriaCliente= new Rem_ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.idclienteagente.eq(id_cliente);
//			criteriaCliente.attivo.eq(1);
			return criteriaCliente.uniqueM_Cliente();
		}
		finally {
		}
	} 
	public static M_Cliente[] caricaClientiAgente() throws PersistentException {
		
		ClienteCriteria criteriaCliente;
		try {
			criteriaCliente = new ClienteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.attivo.eq(1);
			criteriaCliente.addOrder(Property.forName("cognome").asc());

			return criteriaCliente.listCliente();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
		}
		return null;
	}
	
	//carica tutti i clienti, anche quelli non attivi
	public static M_Cliente[] caricaTuttiClientiAgente() throws PersistentException {
		
		ClienteCriteria criteriaCliente;
		try {
			criteriaCliente = new ClienteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.addOrder(Property.forName("cognome").asc());

			return criteriaCliente.listCliente();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
		}
		return null;
	}
	
	public static M_Cliente cercaClienteRemotoMandante(int id_cliente) throws PersistentException{
		
		try{
			
			Rem_ClienteCriteria criteriaCliente= new Rem_ClienteCriteria();
			
			criteriaCliente.idCliente.eq(id_cliente);
			criteriaCliente.attivo.eq(1);
			return criteriaCliente.uniqueM_Cliente();
		}
		finally {
//			AgentTradeMandantePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static M_Cliente[] caricaClientiRemoto() throws PersistentException {
		
		Rem_ClienteCriteria criteriaCliente;
		try {
			criteriaCliente = new Rem_ClienteCriteria();
			criteriaCliente.attivo.eq(1);
			criteriaCliente.addOrder(Property.forName("cognome").asc());

			return criteriaCliente.listCliente();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradeMandantePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	
	public static M_Cliente[] caricaClientiAgenteRemoto() throws PersistentException {
		
		Rem_ClienteCriteria criteriaCliente;
		try {
			criteriaCliente = new Rem_ClienteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
//			criteriaCliente.attivo.eq(1);
			criteriaCliente.addOrder(Property.forName("cognome").asc());

			return criteriaCliente.listCliente();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	
	public static M_Cliente[] caricaClientiCognome(String c)throws PersistentException{
		
		try{
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 	
			//BISOGNA RIPORTARE LA STRINGA TUTTA IN MINUSCOLO PERCHE è CASE SENSITIVE				
			criteriaCliente.cognome.like("%"+c+"%");
			criteriaCliente.attivo.eq(1);
			return criteriaCliente.listCliente();

		}
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	//è cosi complicato mettere un cazzo di nome normale per i parametri? in modo che quando uno lo usa sa chi sono i parametri?
	public static M_Cliente[] caricaClientiParametri(String c, String pi, String cf, String city)throws PersistentException{
		
		try{
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			//BISOGNA RIPORTARE LA STRINGA TUTTA IN MINUSCOLO PERCHE è CASE SENSITIVE				
			criteriaCliente.cognome.like("%"+c+"%");
			criteriaCliente.partita_iva.like("%"+pi+"%");
			criteriaCliente.codice_fiscale.like("%"+cf+"%");
			criteriaCliente.citta.like("%"+city+"%");
			criteriaCliente.attivo.eq(1);
			return criteriaCliente.listCliente();

		}
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	
	public static M_Cliente[] caricaClientiParametriRemoto(String cognome, String piva, String codfis, String city)throws PersistentException{
		
		try{
			Rem_ClienteCriteria criteriaCliente= new Rem_ClienteCriteria();
			//BISOGNA RIPORTARE LA STRINGA TUTTA IN MINUSCOLO PERCHE ? CASE SENSITIVE				
			criteriaCliente.cognome.like("%"+cognome+"%");
			criteriaCliente.partita_iva.like("%"+piva+"%");
			criteriaCliente.codice_fiscale.like("%"+codfis+"%");
			criteriaCliente.citta.like("%"+city+"%");
			criteriaCliente.attivo.eq(1);
			return criteriaCliente.listCliente();
		}
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradeMandantePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	

	public static void salvaCliente(M_Cliente c)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().save(c);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static void salvaClienteRemoto(M_Cliente c)throws PersistentException{
		AgentTradePersistentManager.instance().disposePersistentManager();

		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().save(c);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			System.out.println("ECCEZIONE "+e);

		}
		finally {
			System.out.println("commit a buon fine? "+t.wasCommitted());
		}
	} 
	
	
	public static void updateClienteRemoto(M_Cliente c)throws PersistentException{
		
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().update(c);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
		}
	}
	
	public static void aggiornaCliente(M_Cliente c)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			AgentTradePersistentManager.instance().getSession().update(c);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	public static int getMaxId()throws PersistentException{
		
		try 
		{				
			ClienteCriteria criteria= new ClienteCriteria();
			criteria.setProjection(Projections.max("id"));
			int id=(int) criteria.uniqueResult();
			return id;
		}
		
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
	}
	
	/*
	 * metodi privati
	 */
	


	
	/*
	 * metodi pubblici
	 */
	

	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int value) {
		this.idCliente = value;
	}
	
	public void setIdCliente() {
		this.idCliente = (Integer) null;
	}
	
	public int getORMID() {
		return getIdCliente();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCodice_fiscale(String value) {
		this.codice_fiscale = value;
	}
	
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	
	public void setIndirizzo(String value) {
		this.indirizzo = value;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPartita_iva(String value) {
		this.partita_iva = value;
	}
	
	public String getPartita_iva() {
		return partita_iva;
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
	
	public void setCitta(String value) {
		this.citta = value;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCAP(String value) {
		this.CAP = value;
	}
	
	public String getCAP() {
		return CAP;
	}
	
	public void setCell(String value) {
		this.cell = value;
	}
	
	public String getCell() {
		return cell;
	}
	
	public void setAgenteAssociato(M_Agente value) {
		this.agenteAssociato = value;
	}
	
	public M_Agente getAgenteAssociato() {
		return agenteAssociato;
	}
	
	public int getAttivo() {
		return attivo;
	}

	public void setAttivo(int attivo) {
		this.attivo = attivo;
	}
	
	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public String toString() {
		return String.valueOf(getIdCliente());
	}

	
	public int getVersione() {
		return versione;
	}

	public void setVersione(int versione) {
		this.versione = versione;
	}

	public int getIdclienteagente() {
		return idclienteagente;
	}

	public void setIdclienteagente(int idclienteagente) {
		this.idclienteagente = idclienteagente;
	}
	
	public int getVersione_download() {
		return versione_download;
	}

	public void setVersione_download(int versione_download) {
		this.versione_download = versione_download;
	}

	public IScontoStrategy getStrategiaCliente() throws PersistentException {
		
		IScontoStrategy strategiaCliente= (IScontoStrategy) ScontoStrategyFactory.getStrategy(this);
		return strategiaCliente;
	}

	
	public M_Cliente clone() {
		try {
			return (M_Cliente) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
