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

public class Catalogo {
	public Catalogo() {
	}
	
	private int idCatalogo;
	
	private agent_trade.persistentTemp.Azienda rifAzienda;
	
	private java.util.List prodotti = new java.util.ArrayList();
	
	private void setIdCatalogo(int value) {
		this.idCatalogo = value;
	}
	
	public int getIdCatalogo() {
		return idCatalogo;
	}
	
	public int getORMID() {
		return getIdCatalogo();
	}
	
	public void setProdotti(java.util.List value) {
		this.prodotti = value;
	}
	
	public java.util.List getProdotti() {
		return prodotti;
	}
	
	
	public void setRifAzienda(agent_trade.persistentTemp.Azienda value) {
		this.rifAzienda = value;
	}
	
	public agent_trade.persistentTemp.Azienda getRifAzienda() {
		return rifAzienda;
	}
	
	public String toString() {
		return String.valueOf(getIdCatalogo());
	}
	
}
