/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListAgentTradeData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing M_Preventivo_Item...");
		java.util.List lM_Preventivo_ItemList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo_Item").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Preventivo_Item[] lagent_trademodelM_Preventivo_Items = (agent_trade.model.M_Preventivo_Item[]) lM_Preventivo_ItemList.toArray(new agent_trade.model.M_Preventivo_Item[lM_Preventivo_ItemList.size()]);
		int length = Math.min(lagent_trademodelM_Preventivo_Items.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Preventivo_Items[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Agente...");
		java.util.List lM_AgenteList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Agente").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Agente[] lagent_trademodelM_Agentes = (agent_trade.model.M_Agente[]) lM_AgenteList.toArray(new agent_trade.model.M_Agente[lM_AgenteList.size()]);
		length = Math.min(lagent_trademodelM_Agentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Agentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Cliente...");
		java.util.List lM_ClienteList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Cliente").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Cliente[] lagent_trademodelM_Clientes = (agent_trade.model.M_Cliente[]) lM_ClienteList.toArray(new agent_trade.model.M_Cliente[lM_ClienteList.size()]);
		length = Math.min(lagent_trademodelM_Clientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Clientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Latticini...");
		java.util.List lM_LatticiniList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Latticini").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Latticini[] lagent_trademodelM_Latticinis = (agent_trade.model.M_Latticini[]) lM_LatticiniList.toArray(new agent_trade.model.M_Latticini[lM_LatticiniList.size()]);
		length = Math.min(lagent_trademodelM_Latticinis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Latticinis[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Carni...");
		java.util.List lM_CarniList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Carni").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Carni[] lagent_trademodelM_Carnis = (agent_trade.model.M_Carni[]) lM_CarniList.toArray(new agent_trade.model.M_Carni[lM_CarniList.size()]);
		length = Math.min(lagent_trademodelM_Carnis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Carnis[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Vini...");
		java.util.List lM_ViniList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Vini").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Vini[] lagent_trademodelM_Vinis = (agent_trade.model.M_Vini[]) lM_ViniList.toArray(new agent_trade.model.M_Vini[lM_ViniList.size()]);
		length = Math.min(lagent_trademodelM_Vinis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Vinis[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Dolci...");
		java.util.List lM_DolciList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Dolci").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Dolci[] lagent_trademodelM_Dolcis = (agent_trade.model.M_Dolci[]) lM_DolciList.toArray(new agent_trade.model.M_Dolci[lM_DolciList.size()]);
		length = Math.min(lagent_trademodelM_Dolcis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Dolcis[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Preventivo...");
		java.util.List lM_PreventivoList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.M_Preventivo").setMaxResults(ROW_COUNT).list();
		agent_trade.model.M_Preventivo[] lagent_trademodelM_Preventivos = (agent_trade.model.M_Preventivo[]) lM_PreventivoList.toArray(new agent_trade.model.M_Preventivo[lM_PreventivoList.size()]);
		length = Math.min(lagent_trademodelM_Preventivos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(lagent_trademodelM_Preventivos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing M_Preventivo_Item by Criteria...");
		persistent.Preventivo_ItemCriteria lagent_trademodelM_Preventivo_ItemCriteria = new persistent.Preventivo_ItemCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_Preventivo_ItemCriteria.idPreventivo_Item.eq();
		lagent_trademodelM_Preventivo_ItemCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Preventivo_Item[] agent_trademodelM_Preventivo_Items = lagent_trademodelM_Preventivo_ItemCriteria.listM_Preventivo_Item();
		int length =agent_trademodelM_Preventivo_Items== null ? 0 : Math.min(agent_trademodelM_Preventivo_Items.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Preventivo_Items[i]);
		}
		System.out.println(length + " M_Preventivo_Item record(s) retrieved."); 
		
		System.out.println("Listing M_Agente by Criteria...");
		persistent.AgenteCriteria lagent_trademodelM_AgenteCriteria = new persistent.AgenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_AgenteCriteria.IdAgente.eq();
		lagent_trademodelM_AgenteCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Agente[] agent_trademodelM_Agentes = lagent_trademodelM_AgenteCriteria.listAgente();
		length =agent_trademodelM_Agentes== null ? 0 : Math.min(agent_trademodelM_Agentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Agentes[i]);
		}
		System.out.println(length + " M_Agente record(s) retrieved."); 
		
		System.out.println("Listing M_Cliente by Criteria...");
		persistent.ClienteCriteria lagent_trademodelM_ClienteCriteria = new persistent.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_ClienteCriteria.idCliente.eq();
		lagent_trademodelM_ClienteCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Cliente[] agent_trademodelM_Clientes = lagent_trademodelM_ClienteCriteria.listCliente();
		length =agent_trademodelM_Clientes== null ? 0 : Math.min(agent_trademodelM_Clientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Clientes[i]);
		}
		System.out.println(length + " M_Cliente record(s) retrieved."); 
		
		System.out.println("Listing M_Latticini by Criteria...");
		persistent.LatticiniCriteria lagent_trademodelM_LatticiniCriteria = new persistent.LatticiniCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_LatticiniCriteria.IdProdotto.eq();
		lagent_trademodelM_LatticiniCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Latticini[] agent_trademodelM_Latticinis = lagent_trademodelM_LatticiniCriteria.listM_Latticini();
		length =agent_trademodelM_Latticinis== null ? 0 : Math.min(agent_trademodelM_Latticinis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Latticinis[i]);
		}
		System.out.println(length + " M_Latticini record(s) retrieved."); 
		
		System.out.println("Listing M_Carni by Criteria...");
		persistent.CarniCriteria lagent_trademodelM_CarniCriteria = new persistent.CarniCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_CarniCriteria.IdProdotto.eq();
		lagent_trademodelM_CarniCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Carni[] agent_trademodelM_Carnis = lagent_trademodelM_CarniCriteria.listM_Carni();
		length =agent_trademodelM_Carnis== null ? 0 : Math.min(agent_trademodelM_Carnis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Carnis[i]);
		}
		System.out.println(length + " M_Carni record(s) retrieved."); 
		
		System.out.println("Listing M_Vini by Criteria...");
		persistent.ViniCriteria lagent_trademodelM_ViniCriteria = new persistent.ViniCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_ViniCriteria.IdProdotto.eq();
		lagent_trademodelM_ViniCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Vini[] agent_trademodelM_Vinis = lagent_trademodelM_ViniCriteria.listM_Vini();
		length =agent_trademodelM_Vinis== null ? 0 : Math.min(agent_trademodelM_Vinis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Vinis[i]);
		}
		System.out.println(length + " M_Vini record(s) retrieved."); 
		
		System.out.println("Listing M_Dolci by Criteria...");
		persistent.DolciCriteria lagent_trademodelM_DolciCriteria = new persistent.DolciCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_DolciCriteria.IdProdotto.eq();
		lagent_trademodelM_DolciCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Dolci[] agent_trademodelM_Dolcis = lagent_trademodelM_DolciCriteria.listM_Dolci();
		length =agent_trademodelM_Dolcis== null ? 0 : Math.min(agent_trademodelM_Dolcis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Dolcis[i]);
		}
		System.out.println(length + " M_Dolci record(s) retrieved."); 
		
		System.out.println("Listing M_Preventivo by Criteria...");
		persistent.PreventivoCriteria lagent_trademodelM_PreventivoCriteria = new persistent.PreventivoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lagent_trademodelM_PreventivoCriteria.idPreventivo.eq();
		lagent_trademodelM_PreventivoCriteria.setMaxResults(ROW_COUNT);
		agent_trade.model.M_Preventivo[] agent_trademodelM_Preventivos = lagent_trademodelM_PreventivoCriteria.listPreventivo();
		length =agent_trademodelM_Preventivos== null ? 0 : Math.min(agent_trademodelM_Preventivos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(agent_trademodelM_Preventivos[i]);
		}
		System.out.println(length + " M_Preventivo record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListAgentTradeData listAgentTradeData = new ListAgentTradeData();
			try {
				listAgentTradeData.listTestData();
				//listAgentTradeData.listByCriteria();
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
