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
	
	public M_Latticini(int id, float prezzo, String nome, String categoria, String azienda, String idDes, int idCat, int stagionatura, String tipo ) {
		super(id, prezzo, nome, categoria, azienda, idDes, idCat);
		this.stagionatura=stagionatura;
		this.tipo=tipo;
	}

	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/	
	
	public int getStagionatura() {
		return stagionatura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setStagionatura(int stagionatura) {
		this.stagionatura = stagionatura;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	

}
