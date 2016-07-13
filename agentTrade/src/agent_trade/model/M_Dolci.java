package agent_trade.model;

import java.io.Serializable;

public class M_Dolci extends M_Prodotto implements Serializable
{

	/*attributi di classe*/
	/*attributi privati*/

	private boolean artigianale;
	private boolean free_gluten;


	/*costruttori*/

	public M_Dolci(){
		super();
	}
	
	public M_Dolci(int id, float prezzo, String nome, String categoria, String azienda, String idDes, int idCat, boolean art, boolean fg) {
		super(id, prezzo, nome, categoria, azienda, idDes, idCat);
		this.artigianale=art;
		this.free_gluten=fg;
	}

	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/

	public boolean isArtigianale() {
		return artigianale;
	}

	public boolean isFree_gluten() {
		return free_gluten;
	}

	public void setArtigianale(boolean artigianale) {
		this.artigianale = artigianale;
	}

	public void setFree_gluten(boolean free_gluten) {
		this.free_gluten = free_gluten;
	}
}
