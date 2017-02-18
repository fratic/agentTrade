package example;

import java.util.Date;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.persistent.AgenteCriteria;
import agent_trade.persistent.ClienteCriteria;
import agent_trade.persistent.Preventivo_ItemCriteria;

public class testCaricamentoPrev {

	public static void main(String[] args) throws PersistentException {

		Preventivo_ItemCriteria criteria= new Preventivo_ItemCriteria();
//		criteria.idPreventivo_Item.eq(60);
		M_Preventivo_Item[] prev = criteria.listM_Preventivo_Item();
		 
		AgenteCriteria AgenteCriteria = new AgenteCriteria();
		AgenteCriteria.IdAgente.eq(1);	
		M_Agente agente= AgenteCriteria.listAgente()[0];
		System.out.println("AGENTE "+agente.getCognome()+agente.getNome());
				
		
		
		ClienteCriteria ClienteCriteria = new ClienteCriteria();
		ClienteCriteria.idCliente.eq(2);	
		M_Cliente cliente = ClienteCriteria.listCliente()[0];
		System.out.println("Cliente "+cliente.getCognome()+cliente.getNome());
		
		M_Preventivo p = M_Preventivo.getInstance();
		p.setRif_Agente(agente);
		p.setRif_Cliente(cliente);
		p.setData(new Date(2017, 05, 12));
				
		for (M_Preventivo_Item pit : prev) {
//			System.out.println("id PREVENTIVO item CARICATO "+pit.getIdPreventivo_Item());
//			java.util.List<M_Preventivo> ob = pit.getObb();
//			System.out.println("SIZE : "+ob.size());
//			
			
			
			

			
			
//			p.addItem(pit.getIdProdotto());
			
			
			
			
			
			

		}
		
		
//		
//		
//		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
//		try {
//			
//
//			AgentTradePersistentManager.instance().getSession().save(p);
//
//
//			// commit per il salvataggio
//			t.commit();
//			System.out.println("commmit andato a buon fine? "+t.wasCommitted());
//
//		}
//		catch (Exception e) {
//			System.out.println("commmit andato a buon fine? "+t.wasCommitted());
//
//			System.out.println("Eccezione: "+e);
//			t.rollback();
//		}
		
		

		
//		ClienteCriteria criteriaCliente= new ClienteCriteria();		
//		//JOIN per recuperare solo i clienti dell'agente loggato
//		criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
//		criteriaCliente.idCliente.eq(prev.getRif_Cliente().getIdCliente());
//		M_Cliente cliente = criteriaCliente.listCliente()[0];
		
//		M_Preventivo prevMod= M_Preventivo.getInstance(prev);
//		
//		List<M_Preventivo_Item> prit = prev.getItem();
//		for (M_Preventivo_Item m_Preventivo_Item : prit) {
//			System.out.println("MODIFICA PREVENTIVO, id prodottto "+m_Preventivo_Item.getIdProdotto()+" observer associato "+m_Preventivo_Item.getObs());
//		}
//		
		
		
	}

}
