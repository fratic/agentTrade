package ormsamples;

import java.sql.ClientInfoStatus;

import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import persistent.AgentTradePersistentManager;
import persistent.ClienteCriteria;
import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Cliente;

public class provaDB {

	private static final int ROW_COUNT = 100;

	public static void main(String[] args) throws PersistentException {
		
	PersistentTransaction t = persistent.AgentTradePersistentManager.instance().getSession().beginTransaction();
	try {
		
//		// creo un nuovo agente e lo carico nel db
//		agent_trade.model.Agente agente = new agent_trade.model.Agente();			
//		agente.setNome("Antonio");
//		agente.setCognome("Fratic");
//		agente.setPassword("dio");
//		agent_trade.model.AgentTradePersistentManager.instance().getSession().save(agente);

		
		
//		// creo un nuovo agente e lo carico nel db
//		agent_trade.model.M_Agente agente = new agent_trade.model.M_Agente();			
//		agente.setNome("fdfgsdfgdf");
//		agente.setCognome("Fragsdfgsdfgsdfgstic");
//		agente.setPassword("dfgsdfgsdfgsdfgsdfgsdfgdio");
//		AgentTradePersistentManager.instance().getSession().save(agente);

//		
//		// creo un nuovo cliente e lo carico nel db
//		Cliente cliente = new Cliente();
//		cliente.setAgenteAssociato(agente);
//		cliente.setCAP("71013");
//		cliente.setCitta("roma");
//		cliente.setCodice_fiscale("frtntn89e26h926n");
//		cliente.setCognome("diosanto");
//		cliente.setNome("sono io");
//		cliente.setEmail("fratic@maile.ir");
//		cliente.setIndirizzo("corso emanuele II");
//		cliente.setPartita_iva("2345245234523452");
//		cliente.setTelefono("32072365412");
//		cliente.setFax("928379128347461928374");
//		agent_trade.model.AgentTradePersistentManager.instance().getSession().save(cliente);

	
		// creo un nuovo M_cliente e lo carico nel db
		
//		M_Cliente cliente = new M_Cliente();
//	//	cliente.setAgenteAssociato(agente);
//		cliente.setCAP("71013");
//		cliente.setCitta("roma");
//		cliente.setCodice_fiscale("frtntn89e26h926n");
//		cliente.setCognome("io sono bruce onnipotente");
//		cliente.setNome("sono io");
//		cliente.setEmail("fratic@maile.ir");
//		cliente.setIndirizzo("corso emanuele II");
//		cliente.setPartita_iva("2345245234523452");
//		cliente.setTelefono("32072365412");
//		cliente.setFax("928379128347461928374");
//
//		
//		persistent.AgentTradePersistentManager.instance().getSession().save(cliente);

		
//		// commit per il salvataggio
		t.commit();

	}
	catch (Exception e) {
		System.out.println("in catch");

		t.rollback();
	}
		
	
		//cerca dei clienti con determinati parametri e li stampa

//		ClienteCriteria criteria= new ClienteCriteria();
//		criteria.cognome.like("%br%");
//		criteria.nome.like("%io%");
//		criteria.agenteAssociatoId.eq(5);
//
//		M_Cliente [] listClienti = criteria.listCliente();
//		for (M_Cliente cliente : listClienti) {
//			System.out.println(cliente.getCognome()+" "+cliente.getNome());
//		}
		
		//update di qualcosa
			
//		PersistentTransaction tr = agent_trade.model.AgentTradePersistentManager.instance().getSession().beginTransaction();
//
//		try{
//				//si carica un certo cliente-- OSS: con altissima probabilità l'oggetto deve essere unico 
//				Cliente cl= (Cliente)agent_trade.model.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Cliente").setMaxResults(1).uniqueResult();
//				
//				// Update della proprietà che si vuole rendere persistente
//				cl.setCAP("0123456789"+Math.random());
//				agent_trade.model.AgentTradePersistentManager.instance().getSession().update(cl);
//				
//				tr.commit();
//		}
//		catch (Exception e) {
//			tr.rollback();
//		}		

	

	//cerca un clienti con determinati parametri e aggiorna il cognome
//
//	ClienteCriteria criteria= new ClienteCriteria();
//	criteria.cognome.like("%br%");
//	criteria.nome.like("%io%");
//	criteria.agenteAssociatoId.eq(5);
//
//	M_Cliente [] listClienti = criteria.listCliente();
//	for (M_Cliente cliente : listClienti) {
//		System.out.println(cliente.getCognome()+" "+cliente.getNome());
//		PersistentTransaction tr = agent_trade.model.AgentTradePersistentManager.instance().getSession().beginTransaction();
//
//		try{
//				//si carica un certo cliente-- OSS: con altissima probabilità l'oggetto deve essere unico 
//				//Cliente cl= (Cliente)agent_trade.model.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Cliente").setMaxResults(1).uniqueResult();
//				
//				// Update della proprietà che si vuole rendere persistente
//			cliente.setCognome(cliente.getCognome()+Math.random());
//				agent_trade.model.AgentTradePersistentManager.instance().getSession().update(cliente);
//				
//				tr.commit();
//		}
//		catch (Exception e) {
//			tr.rollback();
//		}	
//	}
	
		
	
	// cerca un determinato cliente e lo cancella
	
	
//	ClienteCriteria criteria= new ClienteCriteria();
////	criteria.cognome.like("%br%");
////	criteria.nome.like("%io%");
//	criteria.agenteAssociatoId.eq(9);
//
//	M_Cliente [] listClienti = criteria.listCliente();
//	for (M_Cliente cliente : listClienti) {
//		System.out.println(cliente.getCognome()+" "+cliente.getNome());
//		PersistentTransaction tr = agent_trade.model.AgentTradePersistentManager.instance().getSession().beginTransaction();
//
//		try{
//				//si carica un certo cliente-- OSS: con altissima probabilità l'oggetto deve essere unico 
//				//Cliente cl= (Cliente)agent_trade.model.AgentTradePersistentManager.instance().getSession().createQuery("From agent_trade.model.Cliente").setMaxResults(1).uniqueResult();
//				
//				// Update della proprietà che si vuole rendere persistente
//			cliente.setCognome(cliente.getCognome()+Math.random());
//
//			agent_trade.model.AgentTradePersistentManager.instance().getSession().delete(cliente);
//
//				tr.commit();
//		}
//		catch (Exception e) {
//			tr.rollback();
//		}	
//	}
	
	
	}
}
