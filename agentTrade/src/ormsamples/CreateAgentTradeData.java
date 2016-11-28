/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;

import agent_trade.persistentTemp.Cliente;
public class CreateAgentTradeData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
		try {
//			agent_trade.model.Preventivo lagent_trademodelPreventivo = new agent_trade.model.Preventivo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rif_Agente, rif_Cliente, idPreventivo
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelPreventivo);
//			
//			agent_trade.model.Preventivo_Item lagent_trademodelPreventivo_Item = new agent_trade.model.Preventivo_Item();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : quantità, idProdotto
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelPreventivo_Item);
//			
//			agent_trade.model.Agente lagent_trademodelAgente = new agent_trade.model.Agente();			// Initialize the properties of the persistent object here
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelAgente);
//			
//			agent_trade.model.Cliente lagent_trademodelCliente = new agent_trade.model.Cliente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : agenteAssociato
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelCliente);
//			
//			agent_trade.model.Catalogo lagent_trademodelCatalogo = new agent_trade.model.Catalogo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rifAzienda
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelCatalogo);
//			
//			agent_trade.model.Azienda lagent_trademodelAzienda = new agent_trade.model.Azienda();			// Initialize the properties of the persistent object here
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelAzienda);
//			
//			agent_trade.model.Latticini lagent_trademodelLatticini = new agent_trade.model.Latticini();			// Initialize the properties of the persistent object here
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelLatticini);
//			
//			agent_trade.model.Carni lagent_trademodelCarni = new agent_trade.model.Carni();			// Initialize the properties of the persistent object here
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelCarni);
//			
//			agent_trade.model.Vini lagent_trademodelVini = new agent_trade.model.Vini();			// Initialize the properties of the persistent object here
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelVini);
//			
//			agent_trade.model.Dolci lagent_trademodelDolci = new agent_trade.model.Dolci();			// Initialize the properties of the persistent object here
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().save(lagent_trademodelDolci);
			
			
			
			agent_trade.persistentTemp.Agente agente = new agent_trade.persistentTemp.Agente();			// Initialize the properties of the persistent object here
		
			agente.setNome("Antonio");
			agente.setCognome("Fratic");
			agente.setPassword("dio");
			persistent.AgentTradePersistentManager.instance().getSession().save(agente);

			Cliente cliente = new Cliente();
			
			cliente.setAgenteAssociato(agente);
			cliente.setCAP("71013");
			cliente.setCitta("roma");
			cliente.setCodice_fiscale("frtntn89e26h926n");
			cliente.setCognome("diosanto");
			cliente.setNome("sono io");
			cliente.setEmail("fratic@maile.ir");
			cliente.setIndirizzo("corso emanuele II");
			cliente.setPartita_iva("2345245234523452");
			cliente.setTelefono("32072365412");
			cliente.setFax("928379128347461928374");
			
			persistent.AgentTradePersistentManager.instance().getSession().save(cliente);

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
