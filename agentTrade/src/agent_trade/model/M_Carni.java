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

public class M_Carni extends M_Prodotto {
	
	/*
	 * attributi di classe
	 */
	
	
	/*
	 * attributi privati
	 */

	private String provenienza;
	private String taglio;
	private String tipo;
	private float peso;
	
	/*
	 * costruttori
	 */
	


	public M_Carni() {
	}
	
	
	public M_Carni(String provenienza, String taglio, String tipo) {
		super();
		this.provenienza = provenienza;
		this.taglio = taglio;
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
	

	public void setProvenienza(String value) {
		this.provenienza = value;
	}
	
	public String getProvenienza() {
		return provenienza;
	}
	
	public void setTaglio(String value) {
		this.taglio = value;
	}
	
	public String getTaglio() {
		return taglio;
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
	
	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}
}
