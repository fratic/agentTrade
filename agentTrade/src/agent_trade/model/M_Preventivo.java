///**
// * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
// * 
// * This is an automatic generated file. It will be regenerated every time 
// * you generate persistence class.
// * 
// * Modifying its content may cause the program not work, or your work may lost.
// */
//
///**
// * Licensee: Universita degli Studi dell'Aquila
// * License Type: Academic
// */

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
import agent_trade.sconti.ClienteScontoStrategy;
import agent_trade.sconti.IScontoStrategy;
import agent_trade.sconti.ScontoStrategyFactory;
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
	
//	private XScontoStrategy strategiaCliente;

	
//	private float totale;
	private float parziale;
	
	
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

		//e se � stato aperto in modifica un preventivo e si clicca su annulla? cancella il prev? 
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
		
		/**
		 * l'item � stato creato. Di conseguenza posso chiedere alla factory se il prodotto associato all'item  
		 * ha un qualche tipo di sconto, e quindi posso salvarmi l'interfaccia per poi usarla a tempo debito
		 * */
		
		//quindi, recupero l'id dello sconto e quindi eventualmente la sua percentuale
		
		System.out.println("CREAZIONE ITEM"+it.getIdPreventivo_Item());
		
		System.out.println("Strategia aggiunta al prodotto: "+it.getIdProdotto());
		System.out.println("tipo strategia: "+it.getStrategiaProdotto());

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
	
	
	public float calcolaTotaleNonScontato(){
		
		float totaleNoScont=0;
		Iterator<?> iteraItem = null;
		
		iteraItem = this.getItem().iterator();
		M_Preventivo_Item item;
	
		while (iteraItem.hasNext()) 
		{
			item = (M_Preventivo_Item) iteraItem.next();
			totaleNoScont= totaleNoScont+(item.getQuantita()*item.getIdProdotto().getPrezzo());
			
		}
		totaleNoScont= (float) (Math.ceil(totaleNoScont * Math.pow(10, 2)) / Math.pow(10, 2));
		
		return totaleNoScont;
	}
	
	public float calcolaScontoTotale(){
		
//		float ScontoTot=0;
//		Iterator<?> iteraItem = null;
//		
//		iteraItem = this.getItem().iterator();
//		M_Preventivo_Item item;
//	
//		while (iteraItem.hasNext()) 
//		{
//			item = (M_Preventivo_Item) iteraItem.next();
//			ScontoTot= ScontoTot+(item.calcolaScontoxQuantita());		
//			
//		}
//		
//		
//		ScontoTot= (float) (Math.ceil(ScontoTot * Math.pow(10, 2)) / Math.pow(10, 2));
//		
//		return ScontoTot;
		
		
//		System.out.println("SONO IN setTOT. LO SCONTO CLIENTE (20%) �:"+ M_Preventivo.getInstance().getRif_Cliente().getStrategiaCliente().calcolaSconto(M_Preventivo.getInstance()));
		
		Iterator<?> iteraItem = null;
		iteraItem = this.getItem().iterator();
		M_Preventivo_Item item;
	
		float scontoTot=0;
		
		while (iteraItem.hasNext()) 
		{			
			item = (M_Preventivo_Item) iteraItem.next();
//				System.out.println("SONO IN setTOT. LO SCONTO Fisso qt �:"+ item.getStrategiaProdotto().calcolaSconto(M_Preventivo.getInstance()));

			
			System.out.println("This"+this);
			System.out.println("strategy"+item.getStrategiaProdotto());

			scontoTot = scontoTot + item.getStrategiaProdotto().calcolaSconto(this);
			
			
			
			
		}
		scontoTot=scontoTot+calcolaScontoCliente();

//		System.out.println("-------------------SET TOTALE-------"+scontoTot);

		return scontoTot;
		
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
//				System.out.println("SONO IN ADD ITEM. LO SCONTO Fisso qt �:"+ item.getStrategiaProdotto().calcolaSconto(M_Preventivo.getInstance()));

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
	
//	MODIFICA FUNZIONI AGGIUNTE PER IL TEST SCONTO
	
	
	
//	public void calcolaTotale() {
//		
//		List<M_Preventivo_Item> lista = this.getItem();
//		Iterator<M_Preventivo_Item> itera = lista.iterator();
//		this.totale = 0;
//		
//		while (itera.hasNext()){
//			M_Preventivo_Item item = (M_Preventivo_Item) itera.next();
//			totale = totale+ item.calcolaParziale(); 
// 		}
//	}
	
	
	public void calcolaParziale(int idProd){ //serve per calcolare il parziale di un prodotto
		
		List<M_Preventivo_Item> lista = this.getItem();
		Iterator<M_Preventivo_Item> itera = lista.iterator();
		
		while (itera.hasNext()){
			M_Preventivo_Item item = (M_Preventivo_Item) itera.next();
			if(item.getIdProdotto().getIdProdotto()== idProd){
				this.parziale = item.calcolaParziale();
			}
		}
	}

//	public float calcolaSconto(String Type) throws PersistentException{
//
//		IScontoStrategy strategy = ScontoStrategyFactory.getInstance(Type);
//		return strategy.calcolaSconto(this);
////		return ScontoStrategyFactory.getInstance().getClienteScontoStrategy().calcolaSconto(this);
//	}	
	
	public float getTotale() {
		
		//per problemi di inconsistenza dei dati forse � meglio calcolare il tot ogni volta
		
		List<M_Preventivo_Item> lista = this.getItem();
		Iterator<M_Preventivo_Item> itera = lista.iterator();
		float tot=0;
		while (itera.hasNext()){
			M_Preventivo_Item item = (M_Preventivo_Item) itera.next();
			tot = tot+item.calcolaParziale();
		}
		
		return tot;
	}

//	public void setTotale(float totale) {
//		this.totale = totale;
//	}

	public float getParziale() {
		return parziale;
	}

	public void setParziale(float parziale) {
		this.parziale = parziale;
	}

	public float calcolaScontoCliente() {
		
		return this.getRif_Cliente().getStrategiaCliente().calcolaSconto(this);		
		
	}

/*	secondo me usando la factory dovrebbe essere
	
	private IScontoStrategy strategy;
	
	public IScontoStrategy getStrategy(){
		return ScontoStrategyFactory.getInstance().getStrategy()
	}
 
 	il problema � capire come far creare la strategy giusta alla factory 
 	gli passiamo un parametro ogni volta che dice quale strategy creare? ma ha senso poi la factory?
 	oppure gli passiamo preventivo per� poi lui deve vedere ogni volta tutto il preventivo
 
	public float calcolaSconto(strategy){
	 	return strategy.calcolaSconto(this);	
	}
*/
	
/*
 	altra soluzione: facciamo come nell'esempio sul sito di dellabate (senza factory): 
 	usiamo il client che nel nostro caso potrebbe essere il controller che dice al 
 	preventivo "vedi che hai inserito un cliente/prodotto con questo tipo di sconto 
 	applica questa strategia" 
 	
 	private IScontoStrategy strategy;
	
	public setStrategy(IScontoStrategy strategy){
		this.strategy = strategy;
	}
 
	public float calcolaSconto(strategy){
	 	return strategy.calcolaSconto(this);	
	}
 	
 */
	

	
}
