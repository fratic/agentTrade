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

import org.orm.PersistentException;

import persistent.AgenteCriteria;

public class M_Agente {
	
	/*
	 * attributi di classe
	 */
	
	private static agent_trade.model.M_Agente instance;

	
	/*
	 * attributi privati
	 */

	private int IdAgente;
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
	
	
	
	/*
	 * costruttori
	 */
	
	public M_Agente(){		
	}
	
	public M_Agente(int idAgente, String nome, String cognome, String password, String username, String citta,
			String indirizzo, int livello, String cell, String email, String cap) {
		super();
		IdAgente = idAgente;
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
	
	
	
	/*
	 * metodi di classe
	 */
	
	public static M_Agente getInstance(){

		return ((instance == null) ? instance = new M_Agente() : instance);	
	}
	
	public static M_Agente caricaAgente(String username) throws PersistentException{
		AgenteCriteria AgenteCriteria = new AgenteCriteria();
		AgenteCriteria.username.eq(username);
		return AgenteCriteria.uniqueAgente();
	}
	
	
	
	/*
	 * metodi privati
	 */
	
	private void setIdAgente(int value) {
		this.IdAgente = value;
	}
		
	
	/*
	 * metodi pubblici
	 */
	
	
	public int getIdAgente() {
		return IdAgente;
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
