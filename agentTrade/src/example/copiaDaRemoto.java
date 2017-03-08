package example;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Agente;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.Rem_AgenteCriteria;

public class copiaDaRemoto {

	public static void main(String[] args) throws PersistentException {


		Rem_AgenteCriteria criteria;
		criteria= new Rem_AgenteCriteria();
		criteria.IdAgente.eq(10);
		M_Agente agente =criteria.uniqueM_Agente();
		
		System.out.println("Sto per salvare in locale l'Agente remoto:"+agente.getIdAgente()+" - "+agente.getNome());
		
		PersistentTransaction t_loc = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().save(agente);
			// commit per il salvataggio
			t_loc.commit();
		}
		catch (Exception e) {
			t_loc.rollback();
		}
		finally {
			System.out.println("Commit locale a buon fine? "+t_loc.wasCommitted());
		}
		
	}

}
