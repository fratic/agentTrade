package example;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import persistent.AgenteCriteria;
import persistent.ClienteCriteria;

public class testAgente {

	public static void main(String[] args) throws PersistentException {
					

//		AgenteCriteria AgenteCriteria = new AgenteCriteria();
//		AgenteCriteria.IdAgente.eq(1);
//		
//		M_Agente agente= AgenteCriteria.listAgente()[0];
//
//		System.out.println("agente : "+agente);
//		
		
		ClienteCriteria ag_crit = new ClienteCriteria();
		ag_crit.idCliente.eq(1);
		
		M_Cliente cliente = ag_crit.uniqueM_Cliente();

		System.out.println("cliente: "+cliente);
		
		
		
		}
}
