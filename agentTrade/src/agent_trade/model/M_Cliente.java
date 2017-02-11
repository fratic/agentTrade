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

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;

import agent_trade.controller.Ctrl_System;
import persistent.AgentTradePersistentManager;
import persistent.ClienteCriteria;

public class M_Cliente {

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
			return criteriaCliente.uniqueM_Cliente();
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	public static M_Cliente[] caricaClientiAgente() throws PersistentException {
		
		ClienteCriteria criteriaCliente;
		try {
			criteriaCliente = new ClienteCriteria();
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			return criteriaCliente.listCliente();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return null;
	}
	
	
	/*
	 * metodi privati
	 */
	
	private void setIdCliente(int value) {
		this.idCliente = value;
	}

	
	/*
	 * metodi pubblici
	 */
	

	public int getIdCliente() {
		return idCliente;
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
	public String toString() {
		return String.valueOf(getIdCliente());
	}
	
}
