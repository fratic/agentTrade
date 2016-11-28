///**
// * Licensee: Universita degli Studi dell'Aquila
// * License Type: Academic
// */
//package ormsamples;
//
//import org.orm.*;
//
//import agent_trade.model.M_Cliente;
//public class ListAgentTradeData {
//	private static final int ROW_COUNT = 100;
//	
//	public void listTestData() throws PersistentException {
//		System.out.println("Listing Preventivo...");
//		java.util.List lPreventivoList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Preventivo").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Preventivo[] lagent_trademodelPreventivos = (agent_trade.persistentTemp.Preventivo[]) lPreventivoList.toArray(new agent_trade.persistentTemp.Preventivo[lPreventivoList.size()]);
//		int length = Math.min(lagent_trademodelPreventivos.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelPreventivos[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Preventivo_Item...");
//		java.util.List lPreventivo_ItemList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Preventivo_Item").setMaxResults(ROW_COUNT).list();
//		agent_trade.model.Preventivo_Item[] lagent_trademodelPreventivo_Items = (agent_trade.model.Preventivo_Item[]) lPreventivo_ItemList.toArray(new agent_trade.model.Preventivo_Item[lPreventivo_ItemList.size()]);
//		length = Math.min(lagent_trademodelPreventivo_Items.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelPreventivo_Items[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Agente...");
//		java.util.List lAgenteList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Agente").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Agente[] lagent_trademodelAgentes = (agent_trade.persistentTemp.Agente[]) lAgenteList.toArray(new agent_trade.persistentTemp.Agente[lAgenteList.size()]);
//		length = Math.min(lagent_trademodelAgentes.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelAgentes[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Cliente...");
//		java.util.List lClienteList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Cliente").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Cliente[] lagent_trademodelClientes = (agent_trade.persistentTemp.Cliente[]) lClienteList.toArray(new agent_trade.persistentTemp.Cliente[lClienteList.size()]);
//		length = Math.min(lagent_trademodelClientes.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelClientes[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Catalogo...");
//		java.util.List lCatalogoList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Catalogo").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Catalogo[] lagent_trademodelCatalogos = (agent_trade.persistentTemp.Catalogo[]) lCatalogoList.toArray(new agent_trade.persistentTemp.Catalogo[lCatalogoList.size()]);
//		length = Math.min(lagent_trademodelCatalogos.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelCatalogos[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Azienda...");
//		java.util.List lAziendaList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Azienda").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Azienda[] lagent_trademodelAziendas = (agent_trade.persistentTemp.Azienda[]) lAziendaList.toArray(new agent_trade.persistentTemp.Azienda[lAziendaList.size()]);
//		length = Math.min(lagent_trademodelAziendas.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelAziendas[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Latticini...");
//		java.util.List lLatticiniList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Latticini").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Latticini[] lagent_trademodelLatticinis = (agent_trade.persistentTemp.Latticini[]) lLatticiniList.toArray(new agent_trade.persistentTemp.Latticini[lLatticiniList.size()]);
//		length = Math.min(lagent_trademodelLatticinis.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelLatticinis[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Carni...");
//		java.util.List lCarniList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Carni").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Carni[] lagent_trademodelCarnis = (agent_trade.persistentTemp.Carni[]) lCarniList.toArray(new agent_trade.persistentTemp.Carni[lCarniList.size()]);
//		length = Math.min(lagent_trademodelCarnis.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelCarnis[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Vini...");
//		java.util.List lViniList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Vini").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Vini[] lagent_trademodelVinis = (agent_trade.persistentTemp.Vini[]) lViniList.toArray(new agent_trade.persistentTemp.Vini[lViniList.size()]);
//		length = Math.min(lagent_trademodelVinis.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelVinis[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//		System.out.println("Listing Dolci...");
//		java.util.List lDolciList = persistent.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Dolci").setMaxResults(ROW_COUNT).list();
//		agent_trade.persistentTemp.Dolci[] lagent_trademodelDolcis = (agent_trade.persistentTemp.Dolci[]) lDolciList.toArray(new agent_trade.persistentTemp.Dolci[lDolciList.size()]);
//		length = Math.min(lagent_trademodelDolcis.length, ROW_COUNT);
//		for (int i = 0; i < length; i++) {
//			System.out.println(lagent_trademodelDolcis[i]);
//		}
//		System.out.println(length + " record(s) retrieved.");
//		
//	}
//	
//	public void listByCriteria() throws PersistentException {
//		System.out.println("Listing Preventivo by Criteria...");
//		persistent.PreventivoCriteria lagent_trademodelPreventivoCriteria = new persistent.PreventivoCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelPreventivoCriteria.idPreventivo.eq();
//		lagent_trademodelPreventivoCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Preventivo[] agent_trademodelPreventivos = lagent_trademodelPreventivoCriteria.listPreventivo();
//		int length =agent_trademodelPreventivos== null ? 0 : Math.min(agent_trademodelPreventivos.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelPreventivos[i]);
//		}
//		System.out.println(length + " Preventivo record(s) retrieved."); 
//		
//		System.out.println("Listing Preventivo_Item by Criteria...");
//		persistent.Preventivo_ItemCriteria lagent_trademodelPreventivo_ItemCriteria = new persistent.Preventivo_ItemCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelPreventivo_ItemCriteria.idPreventivo_Item.eq();
//		lagent_trademodelPreventivo_ItemCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.model.Preventivo_Item[] agent_trademodelPreventivo_Items = lagent_trademodelPreventivo_ItemCriteria.listPreventivo_Item();
//		length =agent_trademodelPreventivo_Items== null ? 0 : Math.min(agent_trademodelPreventivo_Items.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelPreventivo_Items[i]);
//		}
//		System.out.println(length + " Preventivo_Item record(s) retrieved."); 
//		
//		System.out.println("Listing Agente by Criteria...");
//		persistent.AgenteCriteria lagent_trademodelAgenteCriteria = new persistent.AgenteCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelAgenteCriteria.IdAgente.eq();
//		lagent_trademodelAgenteCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.model.M_Agente[] agent_trademodelAgentes = lagent_trademodelAgenteCriteria.listAgente();
//		length =agent_trademodelAgentes== null ? 0 : Math.min(agent_trademodelAgentes.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelAgentes[i]);
//		}
//		System.out.println(length + " Agente record(s) retrieved."); 
//		
//		System.out.println("Listing Cliente by Criteria...");
//		persistent.ClienteCriteria lagent_trademodelClienteCriteria = new persistent.ClienteCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelClienteCriteria.idCliente.eq();
//		lagent_trademodelClienteCriteria.setMaxResults(ROW_COUNT);
//		M_Cliente[] listCliente = lagent_trademodelClienteCriteria.listCliente();
//		agent_trade.model.M_Cliente[] agent_trademodelClientes = listCliente;
//		length =agent_trademodelClientes== null ? 0 : Math.min(agent_trademodelClientes.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelClientes[i]);
//		}
//		System.out.println(length + " Cliente record(s) retrieved."); 
//		
//		System.out.println("Listing Catalogo by Criteria...");
//		persistent.CatalogoCriteria lagent_trademodelCatalogoCriteria = new persistent.CatalogoCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelCatalogoCriteria.idCatalogo.eq();
//		lagent_trademodelCatalogoCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Catalogo[] agent_trademodelCatalogos = lagent_trademodelCatalogoCriteria.listCatalogo();
//		length =agent_trademodelCatalogos== null ? 0 : Math.min(agent_trademodelCatalogos.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelCatalogos[i]);
//		}
//		System.out.println(length + " Catalogo record(s) retrieved."); 
//		
//		System.out.println("Listing Azienda by Criteria...");
//		persistent.AziendaCriteria lagent_trademodelAziendaCriteria = new persistent.AziendaCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelAziendaCriteria.idAzienda.eq();
//		lagent_trademodelAziendaCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Azienda[] agent_trademodelAziendas = lagent_trademodelAziendaCriteria.listAzienda();
//		length =agent_trademodelAziendas== null ? 0 : Math.min(agent_trademodelAziendas.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelAziendas[i]);
//		}
//		System.out.println(length + " Azienda record(s) retrieved."); 
//		
//		System.out.println("Listing Latticini by Criteria...");
//		persistent.LatticiniCriteria lagent_trademodelLatticiniCriteria = new persistent.LatticiniCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelLatticiniCriteria.IdProdotto.eq();
//		lagent_trademodelLatticiniCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Latticini[] agent_trademodelLatticinis = lagent_trademodelLatticiniCriteria.listLatticini();
//		length =agent_trademodelLatticinis== null ? 0 : Math.min(agent_trademodelLatticinis.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelLatticinis[i]);
//		}
//		System.out.println(length + " Latticini record(s) retrieved."); 
//		
//		System.out.println("Listing Carni by Criteria...");
//		persistent.CarniCriteria lagent_trademodelCarniCriteria = new persistent.CarniCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelCarniCriteria.IdProdotto.eq();
//		lagent_trademodelCarniCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Carni[] agent_trademodelCarnis = lagent_trademodelCarniCriteria.listCarni();
//		length =agent_trademodelCarnis== null ? 0 : Math.min(agent_trademodelCarnis.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelCarnis[i]);
//		}
//		System.out.println(length + " Carni record(s) retrieved."); 
//		
//		System.out.println("Listing Vini by Criteria...");
//		persistent.ViniCriteria lagent_trademodelViniCriteria = new persistent.ViniCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelViniCriteria.IdProdotto.eq();
//		lagent_trademodelViniCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Vini[] agent_trademodelVinis = lagent_trademodelViniCriteria.listVini();
//		length =agent_trademodelVinis== null ? 0 : Math.min(agent_trademodelVinis.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelVinis[i]);
//		}
//		System.out.println(length + " Vini record(s) retrieved."); 
//		
//		System.out.println("Listing Dolci by Criteria...");
//		persistent.DolciCriteria lagent_trademodelDolciCriteria = new persistent.DolciCriteria();
//		// Please uncomment the follow line and fill in parameter(s) 
//		//lagent_trademodelDolciCriteria.IdProdotto.eq();
//		lagent_trademodelDolciCriteria.setMaxResults(ROW_COUNT);
//		agent_trade.persistentTemp.Dolci[] agent_trademodelDolcis = lagent_trademodelDolciCriteria.listDolci();
//		length =agent_trademodelDolcis== null ? 0 : Math.min(agent_trademodelDolcis.length, ROW_COUNT); 
//		for (int i = 0; i < length; i++) {
//			 System.out.println(agent_trademodelDolcis[i]);
//		}
//		System.out.println(length + " Dolci record(s) retrieved."); 
//		
//	}
//	
//	public static void main(String[] args) {
//		try {
//			ListAgentTradeData listAgentTradeData = new ListAgentTradeData();
//			try {
//				listAgentTradeData.listTestData();
//				//listAgentTradeData.listByCriteria();
//			}
//			finally {
//				persistent.AgentTradePersistentManager.instance().disposePersistentManager();
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
