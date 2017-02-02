/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteAgentTradeData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			agent_trade.model.M_Preventivo_Item lagent_trademodelM_Preventivo_Item= (agent_trade.model.M_Preventivo_Item)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo_Item").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Preventivo_Item);
			
			agent_trade.model.M_Agente lagent_trademodelM_Agente= (agent_trade.model.M_Agente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Agente").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Agente);
			
			agent_trade.model.M_Cliente lagent_trademodelM_Cliente= (agent_trade.model.M_Cliente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Cliente").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Cliente);
			
			agent_trade.model.M_Latticini lagent_trademodelM_Latticini= (agent_trade.model.M_Latticini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Latticini").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Latticini);
			
			agent_trade.model.M_Carni lagent_trademodelM_Carni= (agent_trade.model.M_Carni)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Carni").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Carni);
			
			agent_trade.model.M_Vini lagent_trademodelM_Vini= (agent_trade.model.M_Vini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Vini").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Vini);
			
			agent_trade.model.M_Dolci lagent_trademodelM_Dolci= (agent_trade.model.M_Dolci)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Dolci").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Dolci);
			
			agent_trade.model.M_Preventivo lagent_trademodelM_Preventivo= (agent_trade.model.M_Preventivo)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelM_Preventivo);
			
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
				persistent.AgentTradePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
