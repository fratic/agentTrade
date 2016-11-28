package agent_trade.model;

import java.io.Serializable;

public class M_Latticini extends M_Prodotto implements Serializable
{
	/*attributi di classe*/
	/*attributi privati*/
	
	private int stagionatura;
	
	private String tipo;

	/*costruttori*/
	
	public M_Latticini(){
		super();
	}
	
	public M_Latticini(int id, float prezzo, String nome, String categoria, int stagionatura, String  tipo) {
		super(id, prezzo, nome, categoria);
		this.stagionatura=stagionatura;
		this.tipo=tipo;
	}	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	

	public void setStagionatura(int value) {
		this.stagionatura = value;
	}
	
	public int getStagionatura() {
		return stagionatura;
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
