package agent_trade.model;

import java.io.Serializable;


public class M_Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String nome;
	private String cognome;
	private String codice_fiscale;
	private String indirizzo;
	private String email;
	
	
	private static M_Cliente instance;

	public static M_Cliente getInstance(){

		return ((instance == null) ? instance = new M_Cliente() : instance);	
	}
	
	public M_Cliente(){		
		//super();
	}
	
	
	public M_Cliente(int id, String cognome, String nome, String cf, String ind, String em){
		//super();
		this.idCliente=id;
		this.cognome=cognome;
		this.nome=nome;	
		this.codice_fiscale=cf;
		this.email=em;
		this.indirizzo=ind;
		
	}

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

	
	
}