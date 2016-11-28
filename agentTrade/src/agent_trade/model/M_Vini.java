package agent_trade.model;

import java.io.Serializable;

public class M_Vini extends M_Prodotto implements Serializable
{
	/*attributi di classe*/
	/*attributi privati*/
	
	private String colore;
	private String cantina;

	
	private String indicazione_geografica;

	
	/*costruttori*/
	
	public M_Vini(){
		super();
	}
	
	public M_Vini(int id, float prezzo, String nome, String categoria, String colore, String indicazione_geo, String cantina ) {
		super(id, prezzo, nome, categoria);
		this.colore=colore;
		this.indicazione_geografica=indicazione_geo;
		this.cantina= cantina;	
	}	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

	
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
