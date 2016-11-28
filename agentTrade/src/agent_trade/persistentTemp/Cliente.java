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
package agent_trade.persistentTemp;

public class Cliente {
	public Cliente() {
	}
	
	private int idCliente;
	
	private agent_trade.persistentTemp.Agente agenteAssociato;
	
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
	
	private void setIdCliente(int value) {
		this.idCliente = value;
	}
	
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
	
	public void setAgenteAssociato(agent_trade.persistentTemp.Agente value) {
		this.agenteAssociato = value;
	}
	
	public agent_trade.persistentTemp.Agente getAgenteAssociato() {
		return agenteAssociato;
	}
	
	private static agent_trade.persistentTemp.Cliente instance;
	
	public static agent_trade.persistentTemp.Cliente getInstance() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Cliente(int idCliente, String nome, String cognome, String codice_fiscale, String indirizzo, String email, String partita_iva, String telefono, String fax, String citta, String CAP) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getIdCliente());
	}
	
}
