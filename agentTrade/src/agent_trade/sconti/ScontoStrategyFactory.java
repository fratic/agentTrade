package agent_trade.sconti;

import java.util.HashMap;
import java.util.Map;

import org.orm.PersistentException;

import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.model.M_ScontoQuantita;

public class ScontoStrategyFactory {

	private static ScontoStrategyFactory instance;
	
	//immagino sia per prova
	private static float percentuale = (float) 0.10;
//	private static float percentualeProd;
//	private static M_Prodotto prodotto;
//	private static M_Cliente cliente;
	
	
	//immagino sia per prova
	public static Map<String,IScontoStrategy> sconti = new HashMap<>();	
	static {
		sconti.put("cliente", new ClienteScontoStrategy(percentuale)); //qui nei costruttori delle varie strategie dobbiamo passare i parametri necessari per calcolare lo sconto
//		sconti.put("percentProd1", new ScontoPercentProdottoStrategy(78)); 
//		sconti.put("percentProd2", new ScontoPercentProdottoStrategy(79));
//		sconti.put("percentProd3", new ScontoPercentProdottoStrategy(80));
//		sconti.put("assolutoProd1", new ScontoAssolutoProdottoStrategy(78,0,0));
//		sconti.put("assolutoProd2", new ScontoAssolutoProdottoStrategy(79,0,0));
//		sconti.put("assolutoProd3", new ScontoAssolutoProdottoStrategy(80,10,15));
	}
	
	public static ScontoStrategyFactory getInstance(){
		if(instance==null)
			instance = new ScontoStrategyFactory();

		
		
			return instance;
	}
	
	
	public static IScontoStrategy getStrategy(Object obj) throws PersistentException{
		
		IScontoStrategy strategy = null;
			
		if(obj instanceof M_Cliente){
					
			M_Sconto politicaSconto = M_Sconto.caricaSconto((int) ((M_Cliente) obj).getSconto());
			if (politicaSconto instanceof M_ScontoCliente)
			{
				strategy=new ClienteScontoStrategy(((M_ScontoCliente) politicaSconto).getPercent());
			}


		}

		else if(obj instanceof M_Preventivo_Item){
		
			
			//recupero l'idSconto associato al prodotto 
			M_Sconto politicaSconto = M_Sconto.caricaSconto((int) ((M_Preventivo_Item) obj).getIdProdotto().getSconto());
			
//			fare il controllo se non ha nessun sconto. in tal caso impostare uno sconto percentuale a zero
			
			if (politicaSconto instanceof M_ScontoQuantita)
			{
				strategy=new ScontoAssolutoProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), ((M_ScontoQuantita) politicaSconto).getQuantita(), ((M_ScontoQuantita) politicaSconto).getScontoFisso());
			}
			else if (politicaSconto instanceof M_ScontoPercent)
			{

				strategy=new ScontoPercentProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), ((M_ScontoPercent) politicaSconto).getPercent() );

			}
		}
//		else{
//			strategy=new ScontoPercentProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), 0);
//
//		}
			
			return strategy;
	}

/*
 * quando si chiama ScontoStrategyFactory questo a seconda del valore passato deve 
 * richiamare la strategia giusta con i parametri giusti per effettuare lo sconto
 * (secondo me dobbiamo vedere meglio dove prendere questi valori qui uso una map e 
 * per ogni prodotto devo inserire uno/due elementi ma forse è meglio recuperare i dati
 * da un db e lasciare nella map solo i tipi di sconto
 * 
 * PS: i tre algoritmi nelle implementazioni della strategia sono da rivedere
 */
//	public static IScontoStrategy getInstance(String type){
//		return sconti.get(type);
//	}

//	public static IScontoStrategy getInstance(String type, int id) throws PersistentException{
//		if(type=="cliente"){
//			percentuale = 5;
//			return sconti.get(type);
//		}
//		else {
//			prodotto = M_Prodotto.caricaProdotto(id);
//			percentualeProd = prodotto.getSconto();
//			return sconti.get(type);
//		}
//	}

	
	
//	public IScontoStrategy getClienteScontoStrategy(){
//		strategy = new ClienteScontoStrategy(percentuale);
//		return strategy;
//	}
//	
//	public IScontoStrategy getScontoPercentProdottoStrategy(){
//		strategy = new ScontoPercentProdottoStrategy(prodotto);
//		return strategy;
//	}

	
}