package agent_trade.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.criterion.Projections;
import org.orm.PersistentException;

import persistent.PreventivoCriteria;
import agent_trade.controller.Ctrl_elaboraPreventivo;
//import agent_trade.persistentTemp.Dao_System;
import agent_trade.persistentTemp.Preventivo;


public class M_Preventivo implements /*Serializable, */Observer{
	
	/*attributi di classe*/
	
	private static M_Preventivo instance;

	private static int newId;//Dao_System.getInstance().loadIdPrev();


	/*attributi privati*/
	private String idPreventivo;
	private M_Agente rif_Agente;
	private M_Cliente rif_Cliente;
	private Date data;

	//BIG PROBLEM NEL DB
	private ArrayList<M_Preventivo_Item> elencoItem= new ArrayList<M_Preventivo_Item>();

	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Preventivo))
			return false;
		Preventivo preventivo = (Preventivo)aObj;
		if ((getIdPreventivo() != null && !getIdPreventivo().equals(preventivo.getIdPreventivo())) || (getIdPreventivo() == null && preventivo.getIdPreventivo() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getIdPreventivo() == null ? 0 : getIdPreventivo().hashCode());
		return hashcode;
	}
		
	
	private List elencoITem = new ArrayList();
	

	/*costruttori*/
	
	private M_Preventivo(M_Preventivo prev){		
		
		this.idPreventivo=prev.idPreventivo;
		this.data=prev.getData();
		//this.totale=prev.totale;
		this.rif_Agente=prev.getRif_Agente();
		this.rif_Cliente=prev.getRif_Cliente();
		this.elencoItem=prev.getElencoItem();
	}
	
	public M_Preventivo()  {
		
		//newId++;
//		this.idPreventivo=Integer.toString(newId);
	}
	
	public void setIdPrev() throws PersistentException
	{
		PreventivoCriteria criteria= new PreventivoCriteria();
		criteria.setProjection(Projections.max("id"));
		newId=Integer.parseInt((String) criteria.uniqueResult());
		newId++;
		this.idPreventivo=Integer.toString(newId);
		System.out.println("ID PREV: "+newId);
	}
	
	/*metodi di classe*/
	
	public static M_Preventivo getInstance() throws PersistentException{
		return ((instance == null) ? instance = new M_Preventivo() : instance);	
	}
	
	public static M_Preventivo getInstance(M_Preventivo prev){
		//return ((instance == null) ? instance= new M_Preventivo(prev) : instance);	
		return (instance= new M_Preventivo(prev));	

	}
	
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	public static int getNumprev(){
		return (newId);	
	}
	
//	public static void setNumprev(int id){
//		newId=id;	
//	}
			
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

	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		return data;
	}

	
	public void setElencoITem(List value) {
		this.elencoITem = value;
	}
	
	public List getElencoITem() {
		return elencoITem;
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
	
	public M_Preventivo_Item addItem(M_Prodotto Prodotto ) throws PersistentException{
		
		M_Preventivo_Item it= new M_Preventivo_Item(M_Preventivo.getInstance(), Prodotto);
		this.elencoItem.add(it);
		this.elencoITem.add(it);
		return it;
	}
	
	public void update(Observable observer, Object obj) {

		try {
			Ctrl_elaboraPreventivo.getInstance().refresh(observer, this);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public float calcolaTotale(){
		float totale=0;
		Iterator iteraItem = null;
		
		iteraItem = this.getElencoItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) 
		{
			item = (M_Preventivo_Item) iteraItem.next();
			totale= totale+(item.getQuantita()*item.getIdProdotto().getPrezzo());
//			System.out.println("Quantità: "+item.getQuantita()+" prezzo: "+item.getIdProdotto().getPrezzo());
		}
		return totale;
	}

	public void addQuant(int id, int qt) {
		
		Iterator iteraItem = null;
		iteraItem = this.getElencoItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) 
		{			
			item = (M_Preventivo_Item) iteraItem.next();
			if (item.getIdProdotto().getIdProdotto()==id)
			{
				item.setQuantita(qt);
			}
		}
	}

	public void removeItem(int id) {

		Iterator<?> iteraItem = null;
		iteraItem = this.getElencoItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) {
			item = (M_Preventivo_Item) iteraItem.next();
			if (item.getIdProdotto().getIdProdotto()==id)
			{
				this.elencoItem.remove(item);
				item.cancellaItem(this);
				break;
			}
		}
	}
}