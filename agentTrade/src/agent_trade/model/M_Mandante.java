package agent_trade.model;
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
public class M_Mandante {
	public M_Mandante() {
	}
	
	private int idMandante;
	
	private String nome;
	
	private String cognome;
	
	private String username;
	
	private String password;
	
	private void setIdMandante(int value) {
		this.idMandante = value;
	}
	
	public int getIdMandante() {
		return idMandante;
	}
	
	public int getORMID() {
		return getIdMandante();
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
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return String.valueOf(getIdMandante());
	}
	
}
