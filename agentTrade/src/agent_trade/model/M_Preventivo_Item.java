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
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.orm.PersistentException;

import agent_trade.sconti.IScontoStrategy;
import agent_trade.sconti.ScontoStrategyFactory;

public class M_Preventivo_Item extends Observable{
	
	
	/*
	 * attributi di classe
	 */
	
	
	/*
	 * attributi privati
	 */

	private int idPreventivo_Item;
	private M_Prodotto idProdotto;
	private int quantita;
	private List<Observer> observer = new ArrayList<Observer>();
	
//	private IScontoStrategy strategiaProdotto;

	
	/*
	 * costruttori
	 */

	public M_Preventivo_Item() {
	}
	
	public M_Preventivo_Item(M_Preventivo rifPreventivo, M_Prodotto idProdotto) throws PersistentException{
		
		this.idProdotto=idProdotto;		
		this.AddObserver(rifPreventivo);
		this.quantita=1;

//		IScontoStrategy strategiaProdotto= (IScontoStrategy) ScontoStrategyFactory.getStrategy(this);
//		this.setStrategiaProdotto(strategiaProdotto);

	}
	
	
	/*
	 * metodi di classe
	 */
	
	
	/*
	 * metodi privati
	 */
	
	
	/*
	 * metodi pubblici
	 */
	
	
	public int getORMID() {
		return getIdPreventivo_Item();
	}
		
	
	public List<Observer> getObserver() {
		return observer;
	}

	public void setObserver(List<Observer> observer) {
		this.observer = observer;
	}

	public void NotifyObservers() {

		for(int i=0;i<observer.size();i++){
			observer.get(i).update(this, null);
		}
	}
	
	public void AddObserver(Observer o) {
		observer.add(o);
	}

	public void RemoveObserver(Observer o) {
		observer.remove(o);
	}	
	
	public int getIdPreventivo_Item() {
		return idPreventivo_Item;
	}

	public void setIdPreventivo_Item(int idPreventivo_Item) {
		this.idPreventivo_Item = idPreventivo_Item;
	}

	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
		NotifyObservers();
	}

	public void cancellaItem(Observer prev){
		NotifyObservers();
		RemoveObserver(prev);
	}

	public M_Prodotto getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(M_Prodotto idProdotto) {
		this.idProdotto = idProdotto;
	}

	

	public IScontoStrategy getStrategiaProdotto() throws PersistentException {
		IScontoStrategy strategiaProdotto= (IScontoStrategy) ScontoStrategyFactory.getStrategy(this);
//		this.setStrategiaProdotto(strategiaProdotto);

		return strategiaProdotto;
	}

//	public void setStrategiaProdotto(IScontoStrategy strategiaProdotto) {
//		this.strategiaProdotto = strategiaProdotto;
//	}

	public String toString() {
		return String.valueOf(getIdPreventivo_Item());
	}

	public float calcolaParziale() {
		
		float parziale=(this.getIdProdotto().getPrezzo()*this.getQuantita());
		parziale= (float) (Math.ceil(parziale * Math.pow(10, 2)) / Math.pow(10, 2));
		return parziale;
	}
	
//	public void setStrategiaCliente(IScontoStrategy strategiaProdotto2) {
//		
//	}

}
