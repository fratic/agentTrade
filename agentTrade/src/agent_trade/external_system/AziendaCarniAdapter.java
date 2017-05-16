package agent_trade.external_system;

import java.util.ArrayList;

import agent_trade.model.M_Prodotto;

public abstract class AziendaCarniAdapter extends SistemaEsterno{

	protected abstract ArrayList<M_Prodotto> creaCarniDaJSON(String jsonCARNE);
	/**forse è possibile usare M_Carni al posto di M_Prodotti*/
	
}
