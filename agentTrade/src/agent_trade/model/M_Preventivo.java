/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package agent_trade.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.PreventivoCriteria;
import agent_trade.util.Costanti;

public class M_Preventivo implements Observer {

	
	/*
	 * attributi di classe
	 */
	
	private static agent_trade.model.M_Preventivo instance;

	
	/*
	 * attributi privati
	 */


	private int idPreventivo;
	private M_Cliente rif_Cliente;
	private M_Agente rif_Agente;
	private Date data;
	private List<M_Preventivo_Item> item = new ArrayList<M_Preventivo_Item>();
	
	private boolean modificato=false;

	
	
	/*
	 * costruttori
	 */
	
	private M_Preventivo(M_Preventivo prev) throws PersistentException{		
		
		this.idPreventivo=prev.idPreventivo;
//		this.data=prev.getData();
		this.data=Ctrl_System.calendario.getTime();
		this.rif_Agente=prev.getRif_Agente();
		this.rif_Cliente=prev.getRif_Cliente();
		this.item=prev.getItem();
		this.modificato=true;
		
		for (int i=0; i<item.size(); i++){
			((M_Preventivo_Item)item.get(i)).AddObserver(prev);			
		}
		
	}
	
	public M_Preventivo()   {
		
	}
	
	
	/*
	 * metodi di classe
	 */
	
	public static M_Preventivo getInstance() throws PersistentException{
		return ((instance == null) ? instance = new M_Preventivo() : instance);	
	}
	
	public static M_Preventivo getInstance(M_Preventivo prev) throws PersistentException{
		return (instance= new M_Preventivo(prev));	

	}

	public static void cancIstanza() {
		instance=null;
	}
	
	public static M_Preventivo caricaPreventivo(int idPreventivo) throws PersistentException{
		PreventivoCriteria criteria= new PreventivoCriteria();
		criteria.idPreventivo.eq(idPreventivo);
		return criteria.uniquePreventivo();
		
	}
	
	public static M_Preventivo[] caricaPreventiviAgente() throws PersistentException{
	
		try{

			PreventivoCriteria criteriaPreventivi= new PreventivoCriteria();
			criteriaPreventivi.createCriteria("rif_Agente", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaPreventivi.setMaxResults(10000);
			return criteriaPreventivi.listPreventivo();
		}
		
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	

	/*
	 * metodi privati
	 */
	
	
	/*
	 * metodi pubblici
	 */
	
		
	public int getIdPreventivo() {
		return idPreventivo;
	}
	
	public int getORMID() {
		return getIdPreventivo();
	}
	
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		return data;
	}
	
	public void setRif_Agente(agent_trade.model.M_Agente value) {
		this.rif_Agente = value;
	}
	
	public agent_trade.model.M_Agente getRif_Agente() {
		return rif_Agente;
	}
	
	public void setRif_Cliente(agent_trade.model.M_Cliente value) {
		this.rif_Cliente = value;
	}
	
	public agent_trade.model.M_Cliente getRif_Cliente() {
		return rif_Cliente;
	}
	
	
	public void setItem(java.util.List<agent_trade.model.M_Preventivo_Item> item) {
		this.item = item;
	}
	
	
	public List<M_Preventivo_Item> getItem() {
		return item;
	}
	
	
	public void setIdPreventivo(int idPreventivo) {
		this.idPreventivo = idPreventivo;
	}
	
	
	public String toString() {
		return String.valueOf(getIdPreventivo());
	}
		
	
	public void setIdPrev() throws PersistentException
	{

		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try{
			AgentTradePersistentManager.instance().getSession().save(this);	
			// commit per il salvataggio
			t.commit();

		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void annullaPrev() throws PersistentException
	{

		//e se è stato aperto in modifica un preventivo e si clicca su annulla? cancella il prev? 
		//sbagliatissimo
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try{
			if (!modificato){
				AgentTradePersistentManager.instance().getSession().delete(this);	
				// commit per il salvataggio
				t.commit();
			}
		}
		catch (Exception e) {
			t.rollback();
		}
		finally{
			
			AgentTradePersistentManager.instance().disposePersistentManager();
			cancIstanza();
		}
		
	}
	
	
	

	public M_Preventivo_Item addItem(M_Prodotto Prodotto ) throws PersistentException{
		
		M_Preventivo_Item it= new M_Preventivo_Item(M_Preventivo.getInstance(), Prodotto);
		this.item.add(it);

		return it;
	}
	
	
	public void update(Observable observer, Object obj) {
		
		try {
			
//			alto accoppiamento
			
			Ctrl_elaboraPreventivo.getInstance().refresh(observer, this);
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public float calcolaImponibile(){
		float totale=0;
		Iterator<?> iteraItem = null;
		
		iteraItem = this.getItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) 
		{
			item = (M_Preventivo_Item) iteraItem.next();
			totale= totale+((item.getQuantita()*item.getIdProdotto().getPrezzo())*(1-item.getIdProdotto().getSconto()));
		}
		totale= (float) (Math.ceil(totale * Math.pow(10, 2)) / Math.pow(10, 2));
		
		return totale;
	}
	
	public float calcolaIva(float imponibile){
		float iva=(float)(imponibile*Costanti.IVA);
		iva= (float) (Math.ceil(iva* Math.pow(10, 2)) / Math.pow(10, 2));
		return iva;
	}
	
	

	public void addQuant(int id, int qt) throws PersistentException {
		
		Iterator<?> iteraItem = null;
		iteraItem = this.getItem().iterator();
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
		iteraItem = this.getItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) {
			item = (M_Preventivo_Item) iteraItem.next();
			if (item.getIdProdotto().getIdProdotto()==id)
			{
				this.item.remove(item);
				item.cancellaItem((Observer) this);
				break;
			}
		}
	}
	
	public boolean salvaPreventivo() throws PersistentException{
		
		M_Preventivo p= M_Preventivo.getInstance();		
		
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{
			AgentTradePersistentManager.instance().getSession().saveOrUpdate(p);	

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		return t.wasCommitted();

	}

	public void delete() throws PersistentException {

		PersistentTransaction t;
		try {
			t = AgentTradePersistentManager.instance().getSession().beginTransaction();
			AgentTradePersistentManager.instance().getSession().delete(this);
			t.commit();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
				
	}
	
	
	

	
}
