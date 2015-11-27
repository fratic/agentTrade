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
	//rendere questi due attributi privati. lasciati cosi solo perch� dao crea errore
	//cambiare prima o poi
	public M_Preventivo rifPreventivo;
	public M_Prodotto idProdotto;
	
	private ArrayList<Observer> observers;

	
	/*costruttori*/
	
	public M_Preventivo_Item(int idPrevItem, int quantita, M_Preventivo rifPreventivo, M_Prodotto idProdotto){
		
		super();
		observers =new ArrayList<Observer>();
		this.idPreventivo_Item=idPrevItem;
		this.quantita=quantita;
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
			System.out.println("sono in notify");
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

}