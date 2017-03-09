package example;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Agente;
import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;

public class testInsertRemLoc {

	public static void main(String[] args) throws PersistentException {

		
		M_Agente a= new M_Agente("marcell", "one", "asd", "marcel", "sgr", "via foggia 217", 5, "3214565789", "fratic@asd.it", "74152");

		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().save(a);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
			System.out.println("Commit remoto a buon fine? "+t.wasCommitted());
		}
		
		
//		PersistentTransaction t_loc = AgentTradePersistentManager.instance().getSession().beginTransaction();
//		try 
//		{				
//			AgentTradePersistentManager.instance().getSession().save(a);
//			// commit per il salvataggio
//			t_loc.commit();
//		}
//		catch (Exception e) {
//			t_loc.rollback();
//		}
//		finally {
//			System.out.println("Commit locale a buon fine? "+t_loc.wasCommitted());
//		}
		
		
		
	}

}
