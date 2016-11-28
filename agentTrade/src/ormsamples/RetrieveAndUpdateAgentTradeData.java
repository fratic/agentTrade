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
			agent_trade.persistentTemp.Preventivo lagent_trademodelPreventivo= (agent_trade.persistentTemp.Preventivo)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Preventivo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelPreventivo);
			
			agent_trade.model.Preventivo_Item lagent_trademodelPreventivo_Item= (agent_trade.model.Preventivo_Item)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Preventivo_Item").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelPreventivo_Item);
			
			agent_trade.persistentTemp.Agente lagent_trademodelAgente= (agent_trade.persistentTemp.Agente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Agente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelAgente);
			
			agent_trade.persistentTemp.Cliente lagent_trademodelCliente= (agent_trade.persistentTemp.Cliente)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Cliente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelCliente);
			
			agent_trade.persistentTemp.Catalogo lagent_trademodelCatalogo= (agent_trade.persistentTemp.Catalogo)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Catalogo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelCatalogo);
			
			agent_trade.persistentTemp.Azienda lagent_trademodelAzienda= (agent_trade.persistentTemp.Azienda)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Azienda").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelAzienda);
			
			agent_trade.persistentTemp.Latticini lagent_trademodelLatticini= (agent_trade.persistentTemp.Latticini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Latticini").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelLatticini);
			
			agent_trade.persistentTemp.Carni lagent_trademodelCarni= (agent_trade.persistentTemp.Carni)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Carni").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelCarni);
			
			agent_trade.persistentTemp.Vini lagent_trademodelVini= (agent_trade.persistentTemp.Vini)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Vini").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelVini);
			
			agent_trade.persistentTemp.Dolci lagent_trademodelDolci= (agent_trade.persistentTemp.Dolci)persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Dolci").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			persistent.AgentTradePersistentManager.instance().getSession().update(lagent_trademodelDolci);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public void retrieveByCriteria() throws PersistentException {
//		System.out.println("Retrieving Preventivo by PreventivoCriteria");
//		agent_trade.model.PreventivoCriteria lagent_trademodelPreventivoCriteria = new agent_trade.model.PreventivoCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelPreventivoCriteria.idPreventivo.eq();
//		System.out.println(lagent_trademodelPreventivoCriteria.uniquePreventivo());
//		
//		System.out.println("Retrieving Preventivo_Item by Preventivo_ItemCriteria");
//		agent_trade.model.Preventivo_ItemCriteria lagent_trademodelPreventivo_ItemCriteria = new agent_trade.model.Preventivo_ItemCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelPreventivo_ItemCriteria.idPreventivo_Item.eq();
//		System.out.println(lagent_trademodelPreventivo_ItemCriteria.uniquePreventivo_Item());
		
		System.out.println("Retrieving Agente by AgenteCriteria");
		persistent.AgenteCriteria lagent_trademodelAgenteCriteria = new persistent.AgenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lagent_trademodelAgenteCriteria.IdAgente.eq();
		
		lagent_trademodelAgenteCriteria.nome.eq("Antonio");

		System.out.println(lagent_trademodelAgenteCriteria.uniqueAgente());
		
//		System.out.println("Retrieving Cliente by ClienteCriteria");
//		agent_trade.model.ClienteCriteria lagent_trademodelClienteCriteria = new agent_trade.model.ClienteCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelClienteCriteria.idCliente.eq();
//		System.out.println(lagent_trademodelClienteCriteria.uniqueCliente());
//		
//		System.out.println("Retrieving Catalogo by CatalogoCriteria");
//		agent_trade.model.CatalogoCriteria lagent_trademodelCatalogoCriteria = new agent_trade.model.CatalogoCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelCatalogoCriteria.idCatalogo.eq();
//		System.out.println(lagent_trademodelCatalogoCriteria.uniqueCatalogo());
//		
//		System.out.println("Retrieving Azienda by AziendaCriteria");
//		agent_trade.model.AziendaCriteria lagent_trademodelAziendaCriteria = new agent_trade.model.AziendaCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelAziendaCriteria.idAzienda.eq();
//		System.out.println(lagent_trademodelAziendaCriteria.uniqueAzienda());
//		
//		System.out.println("Retrieving Latticini by LatticiniCriteria");
//		agent_trade.model.LatticiniCriteria lagent_trademodelLatticiniCriteria = new agent_trade.model.LatticiniCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelLatticiniCriteria.IdProdotto.eq();
//		System.out.println(lagent_trademodelLatticiniCriteria.uniqueLatticini());
//		
//		System.out.println("Retrieving Carni by CarniCriteria");
//		agent_trade.model.CarniCriteria lagent_trademodelCarniCriteria = new agent_trade.model.CarniCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelCarniCriteria.IdProdotto.eq();
//		System.out.println(lagent_trademodelCarniCriteria.uniqueCarni());
//		
//		System.out.println("Retrieving Vini by ViniCriteria");
//		agent_trade.model.ViniCriteria lagent_trademodelViniCriteria = new agent_trade.model.ViniCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelViniCriteria.IdProdotto.eq();
//		System.out.println(lagent_trademodelViniCriteria.uniqueVini());
//		
//		System.out.println("Retrieving Dolci by DolciCriteria");
//		agent_trade.model.DolciCriteria lagent_trademodelDolciCriteria = new agent_trade.model.DolciCriteria();
//		// Please uncomment the follow line and fill in parameter(s)
//		//lagent_trademodelDolciCriteria.IdProdotto.eq();
//		System.out.println(lagent_trademodelDolciCriteria.uniqueDolci());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAgentTradeData retrieveAndUpdateAgentTradeData = new RetrieveAndUpdateAgentTradeData();
			try {
				retrieveAndUpdateAgentTradeData.retrieveAndUpdateTestData();
				retrieveAndUpdateAgentTradeData.retrieveByCriteria();
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
