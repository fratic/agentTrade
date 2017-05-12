package agent_trade.sconti;

import agent_trade.model.M_Preventivo;

public interface IScontoStrategy {

	public float calcolaSconto(M_Preventivo prev);
}
