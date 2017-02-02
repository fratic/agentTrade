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

public class M_Latticini extends M_Prodotto {
	
	/*
	 * attributi di classe
	 */
	
	
	/*
	 * attributi privati
	 */

	private int stagionatura;
	private String tipo;
	
	
	/*
	 * costruttori
	 */
	
	public M_Latticini() {
		super();
	}

	public M_Latticini(int stagionatura, String tipo) {
		super();
		this.stagionatura = stagionatura;
		this.tipo = tipo;
	}
	
	
	/*
	 * metodi di classe
	 */
	
	
	/*
	 * metodi privati
	 */
	
	
	/*
	 * metodi pubblici
	 */
	
	
	

	public void setStagionatura(int value) {
		this.stagionatura = value;
	}
	

	public int getStagionatura() {
		return stagionatura;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
