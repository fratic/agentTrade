package persisten;
/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
import org.orm.*;

import model.M_Agente;
import model.M_Mandante;
public class DeleteAgentTradeMandanteData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {
			M_Mandante m_Mandante= (M_Mandante)AgentTradeMandantePersistentManager.instance().getSession().createQuery("From M_Mandante").setMaxResults(1).uniqueResult();
			AgentTradeMandantePersistentManager.instance().getSession().delete(m_Mandante);
			
			M_Agente m_Agente= (M_Agente)AgentTradeMandantePersistentManager.instance().getSession().createQuery("From M_Agente").setMaxResults(1).uniqueResult();
			AgentTradeMandantePersistentManager.instance().getSession().delete(m_Agente);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			DeleteAgentTradeMandanteData deleteAgentTradeMandanteData = new DeleteAgentTradeMandanteData();
			try {
				deleteAgentTradeMandanteData.deleteTestData();
			}
			finally {
				AgentTradeMandantePersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
