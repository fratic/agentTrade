package agent_trade.model;

public class M_Preventivo_Item {
	private int idPreventivo_Item;
	private int quantita;
	public M_Preventivo rifPreventivo;
	public M_Prodotto idProdotto;

	public M_Preventivo_Item(int idPrevItem, int quantita, M_Preventivo rifPreventivo, M_Prodotto idProdotto){
		
		this.idPreventivo_Item=idPrevItem;
		this.quantita=quantita;
		this.rifPreventivo=rifPreventivo;
		this.idProdotto=idProdotto;
		 		
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