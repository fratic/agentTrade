package agent_trade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class M_Preventivo_Item extends Observable implements Serializable {
	
	/*attributi di classe*/
	/*attributi privati*/
	
	private int idPreventivo_Item;
	private int quantita;
	private M_Preventivo rifPreventivo;
	private M_Prodotto idProdotto;
	
	private ArrayList<Observer> observers;

	//????????
//	private int ArrayList_observer;
	private int ArrayList_observer;

	
	/*costruttori*/
	


	public M_Preventivo_Item(M_Preventivo rifPreventivo, M_Prodotto idProdotto){
		
		super();
		observers =new ArrayList<Observer>();
		this.idPreventivo_Item=1;//DA DETERMINARE UNIVOCAMENTE OPPURE ASSOCIARLO IN QUALCHE MODO A ID_PRODOTTO
		this.quantita=1;
		this.rifPreventivo=rifPreventivo;
		this.idProdotto=idProdotto;		
		this.AddObserver(rifPreventivo);
	
	}

	
	/*metodi di classe*/
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
	public void NotifyObservers() {

		for(int i=0;i<observers.size();i++){
			observers.get(i).update(this, null);
		}
	}
	
	public void AddObserver(Observer o) {
		observers.add(o);
	}

	public void RemoveObserver(Observer o) {
		observers.remove(o);
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

	public M_Preventivo getRifPreventivo() {
		return rifPreventivo;
	}

	public void setRifPreventivo(M_Preventivo rifPreventivo) {
		this.rifPreventivo = rifPreventivo;
	}

	public M_Prodotto getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(M_Prodotto idProdotto) {
		this.idProdotto = idProdotto;
	}
	
	////////////////////
	
	
	
	
	public int getORMID() {
		return getIdPreventivo_Item();
	}
	

//	public void setArrayList_observer(int value) {
//		this.ArrayList_observer = value;
//	}
//	
//	public int getArrayList_observer() {
//		return ArrayList_observer;
//	}
	

	public ArrayList<Observer> getObservers() {
		return observers;
	}


	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}


	public String toString() {
		return String.valueOf(getIdPreventivo_Item());
	}


	public int getArrayList_observer() {
		return ArrayList_observer;
	}


	public void setArrayList_observer(int arrayList_observer) {
		ArrayList_observer = arrayList_observer;
	}

	
	
	
	
	

}