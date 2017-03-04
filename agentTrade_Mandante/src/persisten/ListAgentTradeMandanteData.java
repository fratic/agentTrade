package persisten;
/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
import org.orm.*;

import model.M_Agente;
import model.M_Mandante;
public class ListAgentTradeMandanteData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing M_Mandante...");
		java.util.List lM_MandanteList = AgentTradeMandantePersistentManager.instance().getSession().createQuery("From M_Mandante").setMaxResults(ROW_COUNT).list();
		M_Mandante[] m_Mandantes = (M_Mandante[]) lM_MandanteList.toArray(new M_Mandante[lM_MandanteList.size()]);
		int length = Math.min(m_Mandantes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(m_Mandantes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing M_Agente...");
		java.util.List lM_AgenteList = AgentTradeMandantePersistentManager.instance().getSession().createQuery("From M_Agente").setMaxResults(ROW_COUNT).list();
		M_Agente[] m_Agentes = (M_Agente[]) lM_AgenteList.toArray(new M_Agente[lM_AgenteList.size()]);
		length = Math.min(m_Agentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(m_Agentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing M_Mandante by Criteria...");
		M_MandanteCriteria m_MandanteCriteria = new M_MandanteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//m_MandanteCriteria.idMandante.eq();
		m_MandanteCriteria.setMaxResults(ROW_COUNT);
		M_Mandante[] m_Mandantes = m_MandanteCriteria.listM_Mandante();
		int length =m_Mandantes== null ? 0 : Math.min(m_Mandantes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(m_Mandantes[i]);
		}
		System.out.println(length + " M_Mandante record(s) retrieved."); 
		
		System.out.println("Listing M_Agente by Criteria...");
		M_AgenteCriteria m_AgenteCriteria = new M_AgenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//m_AgenteCriteria.idAgente.eq();
		m_AgenteCriteria.setMaxResults(ROW_COUNT);
		M_Agente[] m_Agentes = m_AgenteCriteria.listM_Agente();
		length =m_Agentes== null ? 0 : Math.min(m_Agentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(m_Agentes[i]);
		}
		System.out.println(length + " M_Agente record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListAgentTradeMandanteData listAgentTradeMandanteData = new ListAgentTradeMandanteData();
			try {
				listAgentTradeMandanteData.listTestData();
				//listAgentTradeMandanteData.listByCriteria();
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
