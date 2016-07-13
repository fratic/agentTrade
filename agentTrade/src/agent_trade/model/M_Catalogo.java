package agent_trade.model;

import java.util.ArrayList;

public class M_Catalogo {
	
	/*attributi di classe*/

	/*attributi privati*/
	private int idCatalogo;
	private M_Azienda rifAzienda;
	private ArrayList<M_Prodotto> prodotti;
	
	/*costruttori*/

	public M_Catalogo(){
		
	}
	
	public M_Catalogo(int idCatalogo, M_Azienda rifAzienda,
			ArrayList<M_Prodotto> prodotti) {
		super();
		this.idCatalogo = idCatalogo;
		this.rifAzienda = rifAzienda;
		this.prodotti = prodotti;
	}

	
	/*metodi di classe*/
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
	public int getIdCatalogo() {
		return idCatalogo;
	}
	public M_Azienda getRifAzienda() {
		return rifAzienda;
	}
	
	public ArrayList<M_Prodotto> getProdotti() {
		return prodotti;
	}
	
	public void setRifAzienda(M_Azienda rifAzienda) {
		this.rifAzienda = rifAzienda;
	}

	public void setProdotti(ArrayList<M_Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
}