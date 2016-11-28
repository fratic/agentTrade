package ormsamples;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Azienda;



public class insertAzienda {

	public static void main(String[] args) throws PersistentException
	{
		M_Azienda az1 = new M_Azienda("MARR srl", "Roma", "02154", "via tevere 4", "08541234", "01896551", "marr@asd.it", "0123459678", "frtnwrenrgtnfrgn");
	
		PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{	
			persistent.AgentTradePersistentManager.instance().getSession().save(az1);	
			t.commit();
		}
	
		catch (Exception e) {
			t.rollback();
		}	
		finally {
			persistent.AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
}


