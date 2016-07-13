package agent_trade.model;

import java.io.Serializable;

public class M_Carni extends M_Prodotto implements Serializable
{
	/*attributi di classe*/
	/*attributi privati*/
	
	private String provenienza;
	private String taglio;
	private String tipo;//di animale
	

	/*costruttori*/
	
	public M_Carni(){
		super();
	}
	
	public M_Carni(int id, float prezzo, String nome, String categoria, String azienda, String idDes, int idCat, String provenienza, String taglio, String tipo ) {
		super(id, prezzo, nome, categoria, azienda, idDes, idCat);
		this.provenienza=provenienza;
		this.taglio=taglio;
		this.tipo=tipo;
	}
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

	public String getProvenienza() {
		return provenienza;
	}

	public String getTaglio() {
		return taglio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public void setTaglio(String taglio) {
		this.taglio = taglio;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

}
