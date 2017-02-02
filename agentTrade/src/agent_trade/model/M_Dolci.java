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

public class M_Dolci extends M_Prodotto {
	
	/*
	 * attributi di classe
	 */
	
	
	/*
	 * attributi privati
	 */

	private boolean artigianale;
	private boolean free_gluten;
	
	
	/*
	 * costruttori
	 */
	
	public M_Dolci() {
	}
	
	
	public M_Dolci(boolean artigianale, boolean free_gluten) {
		super();
		this.artigianale = artigianale;
		this.free_gluten = free_gluten;
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
		
	
	public void setArtigianale(boolean value) {
		this.artigianale = value;
	}
	
	public boolean getArtigianale() {
		return artigianale;
	}
	
	public void setFree_gluten(boolean value) {
		this.free_gluten = value;
	}
	
	public boolean getFree_gluten() {
		return free_gluten;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
