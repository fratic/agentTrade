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
	
	public M_Vini(int id, float prezzo, String nome, String categoria, String azienda, String idDes, int idCat, String colore, String indicazione_geo, String cantina ) {
		super(id, prezzo, nome, categoria, azienda, idDes, idCat);
		this.colore=colore;
		this.indicazione_geo=indicazione_geo;
		this.cantina= cantina;	
	}
	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	


	public String getColore() {
		return colore;
	}

	public String getIndicazione_geo() {
		return indicazione_geo;
	}

	public String getCantina() {
		return cantina;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public void setIndicazione_geo(String indicazione_geo) {
		this.indicazione_geo = indicazione_geo;
	}

	public void setCantina(String cantina) {
		this.cantina = cantina;
	}
	
}
