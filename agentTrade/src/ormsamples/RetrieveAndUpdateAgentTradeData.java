/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateAgentTradeData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
			agent_trade.model.M_Preventivo_Item lagent_trademodelM_Preventivo_Item= (agent_trade.model.M_Preventivo_Item)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo_Item").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Preventivo_Item);
			
			agent_trade.model.M_Agente lagent_trademodelM_Agente= (agent_trade.model.M_Agente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Agente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Agente);
			
			agent_trade.model.M_Cliente lagent_trademodelM_Cliente= (agent_trade.model.M_Cliente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Cliente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Cliente);
			
			agent_trade.model.M_Latticini lagent_trademodelM_Latticini= (agent_trade.model.M_Latticini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Latticini").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Latticini);
			
			agent_trade.model.M_Carni lagent_trademodelM_Carni= (agent_trade.model.M_Carni)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Carni").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Carni);
			
			agent_trade.model.M_Vini lagent_trademodelM_Vini= (agent_trade.model.M_Vini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Vini").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Vini);
			
			agent_trade.model.M_Dolci lagent_trademodelM_Dolci= (agent_trade.model.M_Dolci)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Dolci").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Dolci);
			
			agent_trade.model.M_Preventivo lagent_trademodelM_Preventivo= (agent_trade.model.M_Preventivo)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelM_Preventivo);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving M_Preventivo_Item by M_Preventivo_ItemCriteria");
		persistent.Preventivo_ItemCriteria lagent_trademodelM_Preventivo_ItemCriteria = new persistent.Preventivo_ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_Preventivo_ItemCriteria.idPreventivo_Item.eq();
		System.out.println(lagent_trademodelM_Preventivo_ItemCriteria.uniqueM_Preventivo_Item());
		
		System.out.println("Retrieving M_Agente by M_AgenteCriteria");
		persistent.AgenteCriteria lagent_trademodelM_AgenteCriteria = new persistent.AgenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_AgenteCriteria.IdAgente.eq();
		System.out.println(lagent_trademodelM_AgenteCriteria.uniqueAgente());
		
		System.out.println("Retrieving M_Cliente by M_ClienteCriteria");
		persistent.ClienteCriteria lagent_trademodelM_ClienteCriteria = new persistent.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_ClienteCriteria.idCliente.eq();
		System.out.println(lagent_trademodelM_ClienteCriteria.uniqueM_Cliente());
		
		System.out.println("Retrieving M_Latticini by M_LatticiniCriteria");
		persistent.LatticiniCriteria lagent_trademodelM_LatticiniCriteria = new persistent.LatticiniCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_LatticiniCriteria.IdProdotto.eq();
		System.out.println(lagent_trademodelM_LatticiniCriteria.uniqueM_Latticini());
		
		System.out.println("Retrieving M_Carni by M_CarniCriteria");
		persistent.CarniCriteria lagent_trademodelM_CarniCriteria = new persistent.CarniCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_CarniCriteria.IdProdotto.eq();
		System.out.println(lagent_trademodelM_CarniCriteria.uniqueM_Carni());
		
		System.out.println("Retrieving M_Vini by M_ViniCriteria");
		persistent.ViniCriteria lagent_trademodelM_ViniCriteria = new persistent.ViniCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_ViniCriteria.IdProdotto.eq();
		System.out.println(lagent_trademodelM_ViniCriteria.uniqueM_Vini());
		
		System.out.println("Retrieving M_Dolci by M_DolciCriteria");
		persistent.DolciCriteria lagent_trademodelM_DolciCriteria = new persistent.DolciCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_DolciCriteria.IdProdotto.eq();
		System.out.println(lagent_trademodelM_DolciCriteria.uniqueM_Dolci());
		
		System.out.println("Retrieving M_Preventivo by M_PreventivoCriteria");
		persistent.PreventivoCriteria lagent_trademodelM_PreventivoCriteria = new persistent.PreventivoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelM_PreventivoCriteria.idPreventivo.eq();
		System.out.println(lagent_trademodelM_PreventivoCriteria.uniquePreventivo());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAgentTradeData retrieveAndUpdateAgentTradeData = new RetrieveAndUpdateAgentTradeData();
			try {
				retrieveAndUpdateAgentTradeData.retrieveAndUpdateTestData();
				//retrieveAndUpdateAgentTradeData.retrieveByCriteria();
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
