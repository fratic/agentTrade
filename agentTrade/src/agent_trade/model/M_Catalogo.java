package agent_trade.model;

import java.util.ArrayList;

public class M_Catalogo {
	
	/*attributi di classe*/

	/*attributi privati*/
	private int idCatalogo;
	private M_Azienda rifAzienda;
	private ArrayList<M_Prodotto> prodotti;
	
	/*costruttori*/

	/*metodi di classe*/
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
	public int getIdCatalogo() {
		return idCatalogo;
	}

	public M_Azienda getRifAzienda() {
		return rifAzienda;
	}
	
	public void setRifAzienda(M_Azienda rifAzienda) {
		this.rifAzienda = rifAzienda;
	}
}