package agent_trade.model;

import java.io.Serializable;

public class M_Dolci extends M_Prodotto implements Serializable
{

	/*attributi di classe*/
	/*attributi privati*/

	private boolean artigianale;
	//qui andrebbero definiti gli attributi non comuni con prodotto. Bisogna quindi cercare dei prodotti che 
	//tra di loro hanno caratteristiche diverse, in modo da evidenziare la flessibilità e da giustificare il polimorfismo


	/*costruttori*/

	public M_Dolci(){
		super();
	}
	
	public M_Dolci(int id, float prezzo, String nome, String categoria, boolean art ) {
		super(id, prezzo, nome, categoria);
		this.artigianale=art;
	}
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/

}
