

package example;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.persistent.AgenteCriteria;
import agent_trade.persistent.Rem_AgenteCriteria;



public class testRemotoLocale {


		public static void main(String[] args) throws PersistentException {

			
			AgenteCriteria criteriaLoc;
			criteriaLoc= new AgenteCriteria();
			M_Agente[] agentiLoc =criteriaLoc.listAgente();
			for (M_Agente agente : agentiLoc) {
				System.out.println("Agente locale:"+agente.getIdAgente()+" - "+agente.getNome());
			}
			
			
		Rem_AgenteCriteria criteria;
				criteria= new Rem_AgenteCriteria();
				M_Agente[] agenti =criteria.listM_Agente();
				for (M_Agente agente : agenti) {
					System.out.println("Agente remoto:"+agente.getIdAgente()+" - "+agente.getNome());
				}
				
				
				
		}
}
