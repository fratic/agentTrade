package example;

import org.orm.PersistentException;

import model.M_Agente;
import persisten.M_AgenteCriteria;


public class testLetturaAgente {


		public static void main(String[] args) throws PersistentException {

			M_AgenteCriteria criteria;
				criteria= new M_AgenteCriteria();
				M_Agente[] agenti =criteria.listM_Agente();
				for (M_Agente agente : agenti) {
					System.out.println("Agente :"+agente.getIdAgente()+" - "+agente.getNome());
				}
				
		}
}
