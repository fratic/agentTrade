package agent_trade.model;

public class M_Azienda {

	/*attributi di classe*/
	
	/*attributi privati*/
	private int idAzienda;
	private String nome;
	private String regioneSociale;
	private String citta;
	private String cap;
	private String indirizzo;
	private String telefono;
	private String fax;
	private String email;
	private String partita_iva;
	private String codice_fiscale;





	/*costruttori*/
	
	public M_Azienda(){
		
	}
	
	public M_Azienda(int idAzienda, String nome, String regioneSociale,
			String citta, String cap, String indirizzo, String telefono,
			String fax, String email, String partita_iva, String codice_fiscale) {
		//super();
		this.idAzienda = idAzienda;
		this.nome = nome;
		this.regioneSociale = regioneSociale;
		this.citta = citta;
		this.cap = cap;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.fax = fax;
		this.email = email;
		this.partita_iva = partita_iva;
		this.codice_fiscale = codice_fiscale;
	}
	
	/*metodi di classe*/
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
	public String getNome() {
		return nome;
	}

	public int getIdAzienda() {
		return idAzienda;
	}
	public String getRegioneSociale() {
		return regioneSociale;
	}
	public String getCitta() {
		return citta;
	}
	public String getCap() {
		return cap;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getFax() {
		return fax;
	}
	public String getEmail() {
		return email;
	}
	public String getPartita_iva() {
		return partita_iva;
	}
	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setRegioneSociale(String regioneSociale) {
		this.regioneSociale = regioneSociale;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
}