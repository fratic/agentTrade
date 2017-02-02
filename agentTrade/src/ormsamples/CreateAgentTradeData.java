/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateAgentTradeData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			agent_trade.model.M_Preventivo_Item lagent_trademodelM_Preventivo_Item = new agent_trade.model.M_Preventivo_Item();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : obs, sconto, quantità, idProdotto
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Preventivo_Item);
			
			agent_trade.model.M_Agente lagent_trademodelM_Agente = new agent_trade.model.M_Agente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : livello
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Agente);
			
			agent_trade.model.M_Cliente lagent_trademodelM_Cliente = new agent_trade.model.M_Cliente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : agenteAssociato
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Cliente);
			
			agent_trade.model.M_Latticini lagent_trademodelM_Latticini = new agent_trade.model.M_Latticini();			// Initialize the properties of the persistent object here
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Latticini);
			
			agent_trade.model.M_Carni lagent_trademodelM_Carni = new agent_trade.model.M_Carni();			// Initialize the properties of the persistent object here
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Carni);
			
			agent_trade.model.M_Vini lagent_trademodelM_Vini = new agent_trade.model.M_Vini();			// Initialize the properties of the persistent object here
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Vini);
			
			agent_trade.model.M_Dolci lagent_trademodelM_Dolci = new agent_trade.model.M_Dolci();			// Initialize the properties of the persistent object here
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Dolci);
			
			agent_trade.model.M_Preventivo lagent_trademodelM_Preventivo = new agent_trade.model.M_Preventivo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : item, rif_Agente, rif_Cliente
			persistent.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelM_Preventivo);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAgentTradeData createAgentTradeData = new CreateAgentTradeData();
			try {
				createAgentTradeData.createTestData();
			}
			finally {
				persistent.AgentTradePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
