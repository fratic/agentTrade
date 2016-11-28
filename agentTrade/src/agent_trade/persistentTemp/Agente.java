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

public class Agente {
	public Agente() {
	}
	
	private int IdAgente;
	
	private String nome;
	
	private String cognome;
	
	private String password;
	
	
	private void setIdAgente(int value) {
		this.IdAgente = value;
	}
	
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
	
	private static agent_trade.persistentTemp.Agente instance;
	
	
	public Agente(String id, String cognome, String nome, String psw) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public static agent_trade.persistentTemp.Agente getInstance() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getIdAgente());
	}
	
}
