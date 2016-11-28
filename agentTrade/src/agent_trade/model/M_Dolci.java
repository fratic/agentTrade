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
	
	public M_Dolci(int id, float prezzo, String nome, String categoria, boolean art, boolean fg) {
		super(id, prezzo, nome, categoria);
		this.artigianale=art;
		this.free_gluten=fg;
	}
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/
	
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
