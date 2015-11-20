package agent_trade.model;

import java.io.Serializable;

public class M_Latticini extends M_Prodotto implements Serializable
{
	/*attributi di classe*/
	/*attributi privati*/
	
	private int stagionatura;
	//qui andrebbero definiti gli attributi non comuni con prodotto. Bisogna quindi cercare dei prodotti che 
	//tra di loro hanno caratteristiche diverse, in modo da evidenziare la flessibilità e da giustificare il polimorfismo


	/*costruttori*/
	
	public M_Latticini(){
		super();
	}
	
	public M_Latticini(int id, float prezzo, String nome, String categoria, int stagionatura ) {
		super(id, prezzo, nome, categoria);
		this.stagionatura=stagionatura;
	}	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

}
