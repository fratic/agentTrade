package example;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Agente;
import agent_trade.persistent.AgentTradePersistentManager;

public class insert {
	public static void main(String[] args) throws PersistentException {
		dio();
	}


public static void dio() throws PersistentException
{
//AgentTradePersistentManager.instance().disposePersistentManager();
	
	
	M_Agente agente = new M_Agente();
	
	agente.setNome("marcello");
	agente.setCognome("Fraticelli");
	agente.setUsername("antofrat");
	agente.setPassword("asd");
	agente.setCitta("San Giovanni Rotondo");
	agente.setCap("71013");
	agente.setIndirizzo("via Foggia 271/c");
	agente.setCell("3207239078");
	agente.setEmail("fraticelli.antonio@gmail.com");
	agente.setLivello(3);
	
	
	/*--------------------------------------*/
	
	
//	M_Cliente cliente = new M_Cliente();
//	
//
//	AgenteCriteria AgenteCriteria = new AgenteCriteria();
//	AgenteCriteria.IdAgente.eq(1);
//	
//	M_Agente agente= AgenteCriteria.listAgente()[0];
//		
//	AgentTradePersistentManager.instance().disposePersistentManager();
//
//	System.out.println("ID ag: "+agente.getIdAgente());
//
//	
//	cliente.setAgenteAssociato(agente);
//	cliente.setCAP("71013");
//	cliente.setCitta("roma");
//	cliente.setCodice_fiscale("frtntn89e26h926n");
//	cliente.setCognome("con agente");
//	cliente.setNome("sono io");
//	cliente.setEmail("fratic@maile.ir");
//	cliente.setIndirizzo("corso emanuele II");
//	cliente.setPartita_iva("2345245234523452");
//	cliente.setTelefono("32072365412");
//	cliente.setFax("9283791461928374");
//	//System.out.println("ID AGENTE ASSOCIATO: "+cliente.getAgenteAssociato().getIdAgente());


	
	PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
	try {
		

		
		AgentTradePersistentManager.instance().getSession().save(agente);
		
//		// commit per il salvataggio
		t.commit();

	}
	catch (Exception e) {
		System.out.println("Eccezione: "+e);
		t.rollback();
	}
}
}