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

import java.util.Observable;
import java.util.Observer;

public class Preventivo_Item extends Observable implements Observer {
	public Preventivo_Item() {
	}
	
	private int idPreventivo_Item;
	
	private agent_trade.persistentTemp.Prodotto idProdotto;
	
	private int quantita;
	
	private int ArrayList_observer;
	
	private int observers;
	
	private void setIdPreventivo_Item(int value) {
		this.idPreventivo_Item = value;
	}
	
	public int getIdPreventivo_Item() {
		return idPreventivo_Item;
	}
	
	public int getORMID() {
		return getIdPreventivo_Item();
	}
	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public void setArrayList_observer(int value) {
		this.ArrayList_observer = value;
	}
	
	public int getArrayList_observer() {
		return ArrayList_observer;
	}
	
	public void setObservers(int value) {
		this.observers = value;
	}
	
	public int getObservers() {
		return observers;
	}
	
	public void setIdProdotto(agent_trade.persistentTemp.Prodotto value) {
		this.idProdotto = value;
	}
	
	public agent_trade.persistentTemp.Prodotto getIdProdotto() {
		return idProdotto;
	}
	
	public void addObserver(Observer O) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void removeObserver() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void notifyObserver() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public Preventivo_Item(agent_trade.persistentTemp.Preventivo rifPrev, agent_trade.persistentTemp.Prodotto idProd) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void cancellaItem(Observer prev) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getIdPreventivo_Item());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
