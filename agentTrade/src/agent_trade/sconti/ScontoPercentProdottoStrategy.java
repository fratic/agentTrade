package agent_trade.sconti;

import java.util.Iterator;


import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;

public class ScontoPercentProdottoStrategy implements IScontoStrategy{

	private float sconto;
	private float prezzo;
	private int IdProdotto;
	
	
	public ScontoPercentProdottoStrategy(int idProd){
		this.IdProdotto = idProd;
	}
	
	
	
	@Override
	public float calcolaSconto(M_Preventivo prev) {
		
		Iterator iteraItem = null;
		iteraItem = prev.getItem().iterator();
		M_Preventivo_Item item;
		
		while (iteraItem.hasNext()) {
			item = (M_Preventivo_Item) iteraItem.next();
			if (item.getIdProdotto().getIdProdotto()==IdProdotto)
			{
				prezzo = item.getIdProdotto().getPrezzo();
				sconto = item.getIdProdotto().getSconto();
				prezzo = prezzo - (prezzo * sconto);
				
			}
		}
		return prezzo;
	}

}
