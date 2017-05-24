package agent_trade.sconti;

import java.util.HashMap;
import java.util.Map;

import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo_Item;

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
	
	
	public static IScontoStrategy getStrategy(Object obj){
		
		IScontoStrategy strategy = null;
			
		if(obj instanceof M_Cliente){
			
			//recupero l'idSconto associato al cliente e quindi la percentuale. supponiamo sia perc

//			float perc=M_Cliente.getSconto.getPercent();
			float perc=(float)0.2;
			strategy=new ClienteScontoStrategy(perc);
//			System.out.println("sono dentro strategycliente "+strategy);


		}

		if(obj instanceof M_Preventivo_Item){
		
			
			//recupero l'idSconto associato al prodotto 

			
			if (((M_Preventivo_Item) obj).getIdProdotto().getSconto()>5)
			{
			
				float sconto=(float)5;
				int quantita= 10;
				
	//			strategy=new scontoassolutoprodottostrategy(quantita, sconto);
	//			System.out.println("sono dentro strategycliente "+strategy);
				strategy=new ScontoAssolutoProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), quantita, sconto);
			}
			else
			{
			 float percent=(float)0.15;

			 System.out.println("FACTORY: ID ITEM"+((M_Preventivo_Item) obj).getIdPreventivo_Item());
			 strategy=new ScontoPercentProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), percent);

			}
		}
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