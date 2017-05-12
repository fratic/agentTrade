package agent_trade.sconti;

import java.util.Iterator;

import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;

public class ClienteScontoStrategy implements IScontoStrategy {

	private float percentuale;
	private float totScontato;
	
	
	
	
	public ClienteScontoStrategy(float percent) {
		this.percentuale = percent;
	}


	@Override
	public float calcolaSconto(M_Preventivo prev) {
//		NON SO SE VA BENE
		totScontato = prev.getTotale();
//		Iterator<?> iteraItem = null;
//		
//		iteraItem = prev.getItem().iterator();
//		M_Preventivo_Item item;
//		
//		while (iteraItem.hasNext()) 
//		{
//			item = (M_Preventivo_Item) iteraItem.next();
//			totScontato= totScontato+((item.getQuantita()*item.getIdProdotto().getPrezzo())/**(1-item.getIdProdotto().getSconto())*/);
//				}
		
		if(prev.getRif_Cliente().getIdCliente()== 6){ // in realtà questa if non serve (è stata messa solo per fare una prova con un cliente diverso)
			
			totScontato = totScontato - (totScontato * percentuale);
		}
		return totScontato;
	}
	

}
