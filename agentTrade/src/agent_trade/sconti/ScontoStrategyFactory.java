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
		
			
			M_Sconto politicaSconto = M_Sconto.caricaSconto((int) ((M_Preventivo_Item) obj).getIdProdotto().getSconto());
			
			if (politicaSconto instanceof M_ScontoQuantita)
			{
				strategy=new ScontoAssolutoProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), ((M_ScontoQuantita) politicaSconto).getQuantita(), ((M_ScontoQuantita) politicaSconto).getScontoFisso());
			}
			else if (politicaSconto instanceof M_ScontoPercent)
			{
				strategy=new ScontoPercentProdottoStrategy(((M_Preventivo_Item) obj).getIdProdotto().getIdProdotto(), ((M_ScontoPercent) politicaSconto).getPercent() );
			}
		}
			
			return strategy;
	}

	
}