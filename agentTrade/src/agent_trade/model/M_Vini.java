package agent_trade.model;

import java.io.Serializable;

public class M_Vini extends M_Prodotto implements Serializable
{
	/*attributi di classe*/
	/*attributi privati*/
	
	private String colore;
	private String indicazione_geo;
	private String cantina;


	/*costruttori*/
	
	public M_Vini(){
		super();
	}
	
	public M_Vini(int id, float prezzo, String nome, String categoria, String colore, String indicazione_geo, String cantina ) {
		super(id, prezzo, nome, categoria);
		this.colore=colore;
		this.indicazione_geo=indicazione_geo;
		this.cantina= cantina;	
	}	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

}
