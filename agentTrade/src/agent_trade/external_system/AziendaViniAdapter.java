package agent_trade.external_system;

import java.util.ArrayList;

import agent_trade.model.M_Prodotto;

public abstract class AziendaViniAdapter extends SistemaEsterno{

	protected abstract ArrayList<M_Prodotto> creaViniDaJSON(String jsonVINO);
	
}
