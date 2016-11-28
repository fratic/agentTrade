package agent_trade.model;

import java.io.Serializable;

public class M_Carni extends M_Prodotto implements Serializable
{
	/*attributi di classe*/
	/*attributi privati*/
	
//	private String provenienza;
//	private String taglio;
//	private int qualita;
	
private String provenienza;
	
	private String taglio;
	
	private String tipo;

	/*costruttori*/
	
	public M_Carni(){
		super();
	}
	
	public M_Carni(int id, float prezzo, String nome, String categoria, String provenienza, String taglio, String tipo ) {
		super(id, prezzo, nome, categoria);
		this.provenienza=provenienza;
		this.taglio=taglio;
		this.tipo=tipo;
	}	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

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
}
