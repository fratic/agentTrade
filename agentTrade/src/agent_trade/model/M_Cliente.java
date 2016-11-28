package agent_trade.model;

import agent_trade.controller.Ctrl_System;


public class M_Cliente //implements Serializable
{	
	/*attributi di classe*/
	
	private static M_Cliente instance;

	/*attributi privati*/
	
	private int idCliente;
	private String nome;
	private String cognome;
	private String codice_fiscale;
	private String partita_iva;
	private String indirizzo;
	private String email;
	private String telefono;
	private String cellulare;
	private String fax;
	private String citta;
	private String CAP;
	private M_Agente agenteAssociato;
	
	
	/*costruttori*/
	
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
		this.cellulare=cel;
		this.fax=fax;
		this.agenteAssociato = Ctrl_System.getAgenteLog();
	}
	
	/*metodi di classe*/
	
	public static M_Cliente getInstance(){

		return ((instance == null) ? instance = new M_Cliente() : instance);	
	}
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	
	public String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_Iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax=fax;
	}

	public M_Agente getAgenteAssociato() {
		return agenteAssociato;
	}

	public void setAgenteAssociato(M_Agente agenteAssociato) {
		this.agenteAssociato = agenteAssociato;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCAP() {
		return CAP;
	}

	public void setCAP(String cAP) {
		CAP = cAP;
	}

	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}	
}