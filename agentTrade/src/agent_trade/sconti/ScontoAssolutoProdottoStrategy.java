package agent_trade.sconti;

import java.util.Iterator;

import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;

public class ScontoAssolutoProdottoStrategy implements IScontoStrategy {

	private int IdProdotto;
	private int quantita;
	private float sconto;
	private float parziale;
	
	public ScontoAssolutoProdottoStrategy(int idProd, int quantita, float sconto){
		this.IdProdotto = idProd;
		this.quantita = quantita;
		this.sconto = sconto;
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
				if(item.getQuantita() > quantita){
					item.calcolaParziale();
					parziale = item.calcolaParziale() - sconto;
				}
				else parziale = item.calcolaParziale();
			}
		}
		return parziale;
	}

}
