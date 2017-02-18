/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteAgentTradeData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = agent_trade.persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			agent_trade.model.M_Preventivo_Item lagent_trademodelM_Preventivo_Item= (agent_trade.model.M_Preventivo_Item)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo_Item").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Preventivo_Item);
			
			agent_trade.model.M_Agente lagent_trademodelM_Agente= (agent_trade.model.M_Agente)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Agente").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Agente);
			
			agent_trade.model.M_Cliente lagent_trademodelM_Cliente= (agent_trade.model.M_Cliente)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Cliente").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Cliente);
			
			agent_trade.model.M_Latticini lagent_trademodelM_Latticini= (agent_trade.model.M_Latticini)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Latticini").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Latticini);
			
			agent_trade.model.M_Carni lagent_trademodelM_Carni= (agent_trade.model.M_Carni)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Carni").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Carni);
			
			agent_trade.model.M_Vini lagent_trademodelM_Vini= (agent_trade.model.M_Vini)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Vini").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Vini);
			
			agent_trade.model.M_Dolci lagent_trademodelM_Dolci= (agent_trade.model.M_Dolci)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Dolci").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Dolci);
			
			agent_trade.model.M_Preventivo lagent_trademodelM_Preventivo= (agent_trade.model.M_Preventivo)agent_trade.persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo").setMaxResults(1).uniqueResult();
			agent_trade.persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Preventivo);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			DeleteAgentTradeData deleteAgentTradeData = new DeleteAgentTradeData();
			try {
				deleteAgentTradeData.deleteTestData();
			}
			finally {
				agent_trade.persistent.AgentTradePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
