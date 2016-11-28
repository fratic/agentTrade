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

public class Azienda {
	public Azienda() {
	}
	
	private int idAzienda;
	
	private String ragioneSociale;
	
	private String citta;
	
	private String CAP;
	
	private String Indirizzo;
	
	private String telefono;
	
	private String fax;
	
	private String email;
	
	private String partita_iva;
	
	private String codice_fiscale;
	
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
	
	public void setCAP(String value) {
		this.CAP = value;
	}
	
	public String getCAP() {
		return CAP;
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
	
	public void setPartita_iva(String value) {
		this.partita_iva = value;
	}
	
	public String getPartita_iva() {
		return partita_iva;
	}
	
	public void setCodice_fiscale(String value) {
		this.codice_fiscale = value;
	}
	
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	
	public String toString() {
		return String.valueOf(getIdAzienda());
	}
	
}
