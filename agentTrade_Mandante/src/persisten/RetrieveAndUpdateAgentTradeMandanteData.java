package persisten;
/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
import org.orm.*;

import model.M_Agente;
import model.M_Mandante;
public class RetrieveAndUpdateAgentTradeMandanteData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {
			M_Mandante m_Mandante= (M_Mandante)AgentTradeMandantePersistentManager.instance().getSession().createQuery("From M_Mandante").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			AgentTradeMandantePersistentManager.instance().getSession().update(m_Mandante);
			
			M_Agente m_Agente= (M_Agente)AgentTradeMandantePersistentManager.instance().getSession().createQuery("From M_Agente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			AgentTradeMandantePersistentManager.instance().getSession().update(m_Agente);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving M_Mandante by M_MandanteCriteria");
		M_MandanteCriteria m_MandanteCriteria = new M_MandanteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//m_MandanteCriteria.idMandante.eq();
		System.out.println(m_MandanteCriteria.uniqueM_Mandante());
		
		System.out.println("Retrieving M_Agente by M_AgenteCriteria");
		M_AgenteCriteria m_AgenteCriteria = new M_AgenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//m_AgenteCriteria.idAgente.eq();
		System.out.println(m_AgenteCriteria.uniqueM_Agente());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateAgentTradeMandanteData retrieveAndUpdateAgentTradeMandanteData = new RetrieveAndUpdateAgentTradeMandanteData();
			try {
				retrieveAndUpdateAgentTradeMandanteData.retrieveAndUpdateTestData();
				//retrieveAndUpdateAgentTradeMandanteData.retrieveByCriteria();
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
