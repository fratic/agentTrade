package agent_trade.model;

public class M_Azienda {

	/*attributi di classe*/
	
	/*attributi privati*/
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

	/*costruttori*/
	
	public M_Azienda (String ragioneSociale, String citta, String CAP, String Indirizzo, String telefono, String fax, String email, String partita_iva, String codice_fiscale)
	{
		this.ragioneSociale=ragioneSociale;
		this.citta=citta;
		this.CAP=CAP;
		this.Indirizzo=Indirizzo;
		this.telefono=telefono;
		this.fax=fax;
		this.email=email;
		this.partita_iva=partita_iva;
		this.codice_fiscale=codice_fiscale;
	}
	
	/*metodi di classe*/
	
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