package agent_trade.sconti;

import java.util.Iterator;


import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;

public class ScontoPercentProdottoStrategy implements IScontoStrategy{

	/**
	 * Questo sconto � relativo al singolo prodotto ed � una percentuale fissa sul totale. 
	 * Non � in conflitto con altri sconti. 
	 **/

	
	private float percent;
	private int id_item;
	
	
//	public ScontoPercentProdottoStrategy(float percent){
//		this.percent = percent;
//	}
	
	public ScontoPercentProdottoStrategy(int id_item, float percent){
		this.id_item = id_item;
		this.percent = percent;
		
		System.out.println("ITEM ////////"+id_item);
	}
	
	
	
	@Override
	public float calcolaSconto(M_Preventivo prev) {
		
		Iterator iteraItem = null;
		iteraItem = prev.getItem().iterator();
		M_Preventivo_Item item;
		float sconto=0;
	
		System.out.println("SONO IN CALCOLCAscONTO DI SCONTO %%%.ID ITEM STRATEGY"+id_item);

		while (iteraItem.hasNext()) {
			item = (M_Preventivo_Item) iteraItem.next();
			if (item.getIdProdotto().getIdProdotto()==this.id_item)
			{

			System.out.println("id prodotto "+item.getIdProdotto()+" applicato sconto di tipo"+this);

//			if (item.getIdProdotto().getIdProdotto()==IdProdotto)
//			{
				sconto = sconto + (item.calcolaParziale()*percent);

				
			}
		}
		return sconto;
	}

}
