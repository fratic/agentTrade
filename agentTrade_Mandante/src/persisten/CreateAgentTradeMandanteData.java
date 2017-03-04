package persisten;
/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
import org.orm.*;

import model.M_Agente;
import model.M_Mandante;
public class CreateAgentTradeMandanteData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {
			M_Mandante m_Mandante = new M_Mandante();			// Initialize the properties of the persistent object here
			AgentTradeMandantePersistentManager.instance().getSession().save(m_Mandante);
			
			M_Agente m_Agente = new M_Agente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : livello
			AgentTradeMandantePersistentManager.instance().getSession().save(m_Agente);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAgentTradeMandanteData createAgentTradeMandanteData = new CreateAgentTradeMandanteData();
			try {
				createAgentTradeMandanteData.createTestData();
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
