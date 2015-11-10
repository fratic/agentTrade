package agent_trade.model;

import java.awt.List;
import java.util.ArrayList;


public class M_Preventivo {
	private String idPreventivo;
	private String data; //bisognerebbe creare un oggetto Data
	private float totale;
	private M_Agente rif_Agente;
	private M_Cliente rif_Cliente;
	private static M_Preventivo instance;
	private ArrayList<M_Preventivo_Item> elencoItem= new ArrayList<M_Preventivo_Item>();
	
	public M_Cliente getRif_Cliente() {
		return rif_Cliente;
	}

	public static M_Preventivo getInstance(){

		return ((instance == null) ? instance = new M_Preventivo() : instance);	
	}
	
	public M_Preventivo(String id, String data, float tot, M_Agente a){		
		this.idPreventivo=id;
		this.data=data;
		this.totale=tot;
		this.rif_Agente=a;
	}	
	
	public M_Preventivo() {
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

	public void setRif_Cliente(M_Cliente rif_Cliente) {
		this.rif_Cliente = rif_Cliente;
	}
	
	public void addItem(int idPrevItem, int quantita, M_Prodotto idProdotto ){
		M_Preventivo_Item it= new M_Preventivo_Item(idPrevItem, quantita, this.getInstance(), idProdotto);
		this.elencoItem.add(it);
	}
	
}