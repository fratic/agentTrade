package agent_trade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.content.RiepilogoItemPreventivoView;


public class M_Preventivo implements Serializable, Observer{
	
	/*attributi di classe*/
	
	private static M_Preventivo instance;
	private static int newId;

	/*attributi privati*/
	private String idPreventivo;
	private String data; //bisognerebbe creare un oggetto Data
	private float totale;
	private M_Agente rif_Agente;
	private M_Cliente rif_Cliente;
	private ArrayList<M_Preventivo_Item> elencoItem= new ArrayList<M_Preventivo_Item>();


	/*costruttori*/
	
	//bisogna aggiustare il caricamento dell'id in tutti i costruttori 
	public M_Preventivo(String id, String data, float tot, M_Agente a){		
		
		Dao_System.getInstance();
		this.idPreventivo=Integer.toString(newId);
		this.data=data;
		this.totale=tot;
		this.rif_Agente=a;
	}	
	
	public M_Preventivo() {
		newId=Dao_System.loadIdPrev();
		newId++;
		System.out.println("nuovo id: "+newId);
		this.idPreventivo=Integer.toString(newId);
	}
	/*metodi di classe*/
	
	public static M_Preventivo getInstance(){
		return ((instance == null) ? instance = new M_Preventivo() : instance);	
	}
	
	/*metodi privati*/
	/*metodi pubblici*/
			
	public ArrayList<M_Preventivo_Item> getElencoItem() {
		return elencoItem;
	}

	public  void setElencoItem(ArrayList<M_Preventivo_Item> elencoItem) {
		this.elencoItem = elencoItem;
	}

	public static void cancIstanza(){
		instance=null;
	}
	
	public M_Cliente getRif_Cliente() {
		return rif_Cliente;
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
	
	public M_Preventivo_Item addItem(M_Prodotto Prodotto ){
		M_Preventivo_Item it= new M_Preventivo_Item(M_Preventivo.getInstance(), Prodotto);
		this.elencoItem.add(it);
		return it;
	}
	
	public void update(Observable observer, Object obj) {
		float c = calcolaTotale();		
		System.out.println("In update, nuova quantità= "+c);

		//aggiornare le quantita
		
	}
	
	
	public float calcolaTotale(){
		float totale=0;
		Iterator iteraItem = null;
		
		iteraItem = this.getElencoItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) {
			
			item = (M_Preventivo_Item) iteraItem.next();
			totale= totale+(item.getQuantita()*item.getIdProdotto().getPrezzo());
			System.out.println("Quantità: "+item.getQuantita()+" prezzo: "+item.getIdProdotto().getPrezzo());
						
		}
		return totale;

	}
	
	
}