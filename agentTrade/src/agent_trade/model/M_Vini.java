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

public class M_Vini extends M_Prodotto {
	
	/*
	 * attributi di classe
	 */
	
	
	/*
	 * attributi privati
	 */

	private String colore;
	private String indicazione_geografica;
	private String cantina;
	
	
	/*
	 * costruttori
	 */
	
	public M_Vini() {
	}
	
	
	public M_Vini(String colore, String indicazione_geografica, String cantina) {
		super();
		this.colore = colore;
		this.indicazione_geografica = indicazione_geografica;
		this.cantina = cantina;
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

	
	public void setColore(String value) {
		this.colore = value;
	}
	
	public String getColore() {
		return colore;
	}
	
	public void setIndicazione_geografica(String value) {
		this.indicazione_geografica = value;
	}
	
	public String getIndicazione_geografica() {
		return indicazione_geografica;
	}
	
	public void setCantina(String value) {
		this.cantina = value;
	}
	
	public String getCantina() {
		return cantina;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
