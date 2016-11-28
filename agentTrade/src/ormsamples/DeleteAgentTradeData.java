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
			agent_trade.persistentTemp.Preventivo lagent_trademodelPreventivo= (agent_trade.persistentTemp.Preventivo)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Preventivo").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelPreventivo);
			
			agent_trade.model.Preventivo_Item lagent_trademodelPreventivo_Item= (agent_trade.model.Preventivo_Item)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Preventivo_Item").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelPreventivo_Item);
			
			agent_trade.persistentTemp.Agente lagent_trademodelAgente= (agent_trade.persistentTemp.Agente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Agente").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelAgente);
			
			agent_trade.persistentTemp.Cliente lagent_trademodelCliente= (agent_trade.persistentTemp.Cliente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Cliente").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelCliente);
			
			agent_trade.persistentTemp.Catalogo lagent_trademodelCatalogo= (agent_trade.persistentTemp.Catalogo)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Catalogo").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelCatalogo);
			
			agent_trade.persistentTemp.Azienda lagent_trademodelAzienda= (agent_trade.persistentTemp.Azienda)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Azienda").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelAzienda);
			
			agent_trade.persistentTemp.Latticini lagent_trademodelLatticini= (agent_trade.persistentTemp.Latticini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Latticini").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelLatticini);
			
			agent_trade.persistentTemp.Carni lagent_trademodelCarni= (agent_trade.persistentTemp.Carni)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Carni").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelCarni);
			
			agent_trade.persistentTemp.Vini lagent_trademodelVini= (agent_trade.persistentTemp.Vini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Vini").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelVini);
			
			agent_trade.persistentTemp.Dolci lagent_trademodelDolci= (agent_trade.persistentTemp.Dolci)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Dolci").setMaxResults(1).uniqueResult();
			persistent.AgentTradePersistentManager.instance().getSession().delete(lagent_trademodelDolci);
			
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
