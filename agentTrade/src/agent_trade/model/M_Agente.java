package agent_trade.model;

import java.io.Serializable;


public class M_Agente implements Serializable{
	
	private String idAgente;
	private String nome;
	private String cognome;
	private String password;//per il momento la lascio in chiaro cosi, poi decidpo
	
	private static M_Agente instance;

	public static M_Agente getInstance(){

		return ((instance == null) ? instance = new M_Agente() : instance);	
	}
	
	public M_Agente(){		
	}
	
	
	public M_Agente(String id, String cognome, String nome, String psw){
		super();
		this.idAgente=id;
		this.cognome=cognome;
		this.nome=nome;	
		this.password=psw;
	}
	
	
	public String getIdAgente() {
		return idAgente;
	}


	public String getPassword() {
		return password;
	}

	
	public String getNome(){
		return this.nome;
	}

	
	public String getCognome() {
		return cognome;
	}

	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	} 
}
