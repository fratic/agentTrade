package agent_trade.model;

import java.util.ArrayList;
import java.util.List;

public class M_Catalogo {
	
	/*attributi di classe*/

	/*attributi privati*/
	private int idCatalogo;
	private M_Azienda rifAzienda;
	private List prodotti = new ArrayList();
	
	
	/*costruttori*/

	/*metodi di classe*/
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	

	
	private void setIdCatalogo(int value) {
		this.idCatalogo = value;
	}
	
	public int getIdCatalogo() {
		return idCatalogo;
	}
	
	public int getORMID() {
		return getIdCatalogo();
	}
	
	public void setProdotti(List value) {
		this.prodotti = value;
	}
	
	public List getProdotti() {
		return prodotti;
	}
	
	
	public void setRifAzienda(M_Azienda value) {
		this.rifAzienda = value;
	}
	
	public M_Azienda getRifAzienda() {
		return rifAzienda;
	}
	
	public String toString() {
		return String.valueOf(getIdCatalogo());
	}
	
	
}