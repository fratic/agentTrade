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
package agent_trade.persistentTemp;

import java.util.Observable;
import java.util.Observer;

import javax.xml.crypto.Data;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.Preventivo_Item;

public class Preventivo implements Observer {
	public Preventivo() {
	}
	
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
	
	private String idPreventivo;
	
	private agent_trade.model.M_Cliente rif_Cliente;
	
	private agent_trade.model.M_Agente rif_Agente;
	
	private java.util.Date data;
	
	private java.util.List elencoITem = new java.util.ArrayList();
	
	public void setIdPreventivo(String value) {
		this.idPreventivo = value;
	}
	
	public String getIdPreventivo() {
		return idPreventivo;
	}
	
	public String getORMID() {
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
	
	public void setElencoITem(java.util.List value) {
		this.elencoITem = value;
	}
	
	public java.util.List getElencoITem1() {
		return elencoITem;
	}
	
	
	private static agent_trade.persistentTemp.Preventivo instance;
	
	public Preventivo(agent_trade.persistentTemp.Preventivo p) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public static agent_trade.persistentTemp.Preventivo getInstance() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public static agent_trade.persistentTemp.Preventivo getInstance(agent_trade.persistentTemp.Preventivo prev) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public static void cancIstanza() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void getElencoITem() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setElencoITem( int elencoITem) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public agent_trade.model.Preventivo_Item addItem(agent_trade.persistentTemp.Prodotto prod) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void update(Observable o, Object arg) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public float calcolaTotale() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void addQuant(int id, int qt) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void removeItem(int id) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setData(Data data) {
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getIdPreventivo());
	}
	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}


	public void update1(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
