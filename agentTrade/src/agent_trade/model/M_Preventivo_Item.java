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
	//rendere questi due attributi privati. lasciati cosi solo perchè dao crea errore
	//cambiare prima o poi
	public M_Preventivo rifPreventivo;
	public M_Prodotto idProdotto;
	
	private ArrayList<Observer> observers;

	
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
			System.out.println("è cambiato qualcosa in prev item");
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
	
	public void cancellaItem(){
		NotifyObservers();
		//this.RemoveObserver(o);
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