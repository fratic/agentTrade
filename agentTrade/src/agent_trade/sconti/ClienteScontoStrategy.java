package agent_trade.sconti;

import java.util.Iterator;

import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;

public class ClienteScontoStrategy implements IScontoStrategy {

	/**
	 * Questo sconto è relativo al cliente ed è una percentuale fissa sul totale. 
	 * Non è in conflitto con altri sconti. 
	 **/
	private float percentuale;
	

	public ClienteScontoStrategy(float percent) {
		this.percentuale = percent;
	}


	@Override
	public float calcolaSconto(M_Preventivo prev) {

		float scontoCliente=prev.getTotale()*percentuale;
		
		return scontoCliente;
	}
	
}
