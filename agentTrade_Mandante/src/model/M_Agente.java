package model;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

//import agent_trade.controller.Ctrl_System;
import model.M_Agente;
import persisten.AgentTradeMandantePersistentManager;
import persisten.M_AgenteCriteria;

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
public class M_Agente {
	public M_Agente() {
	}
	
	private int idAgente;
	
	private String nome;
	
	private String cognome;
	
	private String password;
	
	private String username;
	
	private String citta;
	
	private String indirizzo;
	
	private int livello;
	
	private String cell;
	
	private String email;
	
	private String cap;
	
	
		
	
	public M_Agente(String nome, String cognome, String password, String username, String citta, String indirizzo,
			int livello, String cell, String email, String cap) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.username = username;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.livello = livello;
		this.cell = cell;
		this.email = email;
		this.cap = cap;
	}

	
	public static M_Agente caricaAgente(String username) throws PersistentException{
		M_AgenteCriteria AgenteCriteria = new M_AgenteCriteria();
		AgenteCriteria.username.eq(username);
		return AgenteCriteria.uniqueM_Agente();
	}
	
	
	public static void salvaAgente(M_Agente a)throws PersistentException{
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
	
	public static M_Agente[] caricaAgenti() throws PersistentException {
		
		M_AgenteCriteria criteriaAgente;
		try {
			criteriaAgente = new M_AgenteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			//criteriaAgente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			
			return criteriaAgente.listM_Agente();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	public static M_Agente[] caricaAgentiParametri(String c, /*int lvl,*/ String email, String city)throws PersistentException{
		
		try{
			M_AgenteCriteria criteriaAgente= new M_AgenteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			//criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			//BISOGNA RIPORTARE LA STRINGA TUTTA IN MINUSCOLO PERCHE è CASE SENSITIVE				
			criteriaAgente.cognome.like("%"+c+"%");
			//criteriaAgente.livello.eq(lvl);
			criteriaAgente.email.like("%"+email+"%");
			criteriaAgente.citta.like("%"+city+"%");
			//criteriaCliente.attivo.eq(1);
			return criteriaAgente.listM_Agente();

		}
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	public static M_Agente cercaAgente(int id_agente) throws PersistentException{
		
		try{
			
			M_AgenteCriteria criteriaAgente = new M_AgenteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			//criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaAgente.idAgente.eq(id_agente);
			//criteriaAgente.attivo.eq(1);
			return criteriaAgente.uniqueM_Agente();
		}
		finally {
//			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	private void setIdAgente(int value) {
		this.idAgente = value;
	}
	
	public int getIdAgente() {
		return idAgente;
	}
	
	public int getORMID() {
		return getIdAgente();
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
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setCitta(String value) {
		this.citta = value;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setIndirizzo(String value) {
		this.indirizzo = value;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setLivello(int value) {
		this.livello = value;
	}
	
	public int getLivello() {
		return livello;
	}
	
	public void setCell(String value) {
		this.cell = value;
	}
	
	public String getCell() {
		return cell;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setCap(String value) {
		this.cap = value;
	}
	
	public String getCap() {
		return cap;
	}
	
	public String toString() {
		return String.valueOf(getIdAgente());
	}
	
}
