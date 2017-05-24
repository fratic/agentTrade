package agent_trade.sconti;

import java.util.Iterator;

import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;

public class ScontoAssolutoProdottoStrategy implements IScontoStrategy {

	/**
	 * Questo sconto è relativo al singolo prodotto ed è un sconto fisso quando si supera una certa
	 * quantità di prodotti acquistati. Esempio: se il prodotto p ha uno sconto di 10 euro se si 
	 * superano le 15 unità acquistate, allora fino a 14 qt il prezzo sarà prezzo*14 altrimenti, 
	 * superati i 15, e suoi multipli, si avrà uno sconto pari a qt(>15)*prezzo-10(* multipli)
	 * Non è in conflitto con altri sconti. 
	 **/
	
	
	//id serve solo per prova? se cosi non fosse, a che serve?
	//parziale a che serve?
	private int quantita;
	private float sconto;
	private int id_item;
	
	public ScontoAssolutoProdottoStrategy(int quantita, float sconto){
		this.quantita = quantita;
		this.sconto = sconto;
	}
	
	public ScontoAssolutoProdottoStrategy(int id_item, int quantita, float sconto){
		this.id_item = id_item;
		this.quantita = quantita;
		this.sconto = sconto;
	}

	@Override
	public float calcolaSconto(M_Preventivo prev) {
		
		Iterator<M_Preventivo_Item> iteraItem = prev.getItem().iterator();
		M_Preventivo_Item item;
		float scontoQt=0;
		
		System.out.println("SONO IN CALCOLCAscONTO DI SCONTOASSOLUTO.ID ITEM STRATEGY"+id_item);

		while (iteraItem.hasNext()) {
			item = (M_Preventivo_Item) iteraItem.next();
			if (item.getIdProdotto().getIdProdotto()==this.id_item)
			{
			
			System.out.println("id prodotto "+item.getIdProdotto()+" applicato sconto di tipo"+this);

				if(item.getQuantita() >= quantita){
					int multiplo= (int) item.getQuantita()/quantita;
//					item.calcolaParziale();
//					System.out.println("id prodotto dentro il id"+item.getIdProdotto());
					scontoQt = scontoQt+sconto*multiplo;
				}
//				else parziale = item.calcolaParziale();
			}
		}
		return scontoQt;
	}

}
