package agent_trade.model;

import java.util.Vector;

public class M_Preventivo {
	private String idPreventivo;
	private String data; //bisognerebbe creare un oggetto Data
	private float totale;
	//public M_Cliente appartiene;
	private M_Agente rif_Agente;
//	public Vector<Preventivo_Item> _contiene = new Vector<Preventivo_Item>();
	private static M_Preventivo instance;

		
	
	public M_Preventivo(String id, String data, float tot, M_Agente a){		
		this.idPreventivo=id;
		this.data=data;
		this.totale=tot;
		this.rif_Agente=a;
	}	
	
	public M_Preventivo() {
	}
	
	public static M_Preventivo getInstance(){

		return ((instance == null) ? instance = new M_Preventivo() : instance);	
	}
	
	
	public String getIdPreventivo() {
		return idPreventivo;
	}

	public void setIdPreventivo(String idPreventivo) {
		this.idPreventivo = idPreventivo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getTotale() {
		return totale;
	}

	public void setTotale(long totale) {
		this.totale = totale;
	}

	public M_Agente getRif_Agente() {
		return rif_Agente;
	}

	public void setRif_Agente(M_Agente rif_Agente) {
		this.rif_Agente = rif_Agente;
	}


	
	
}