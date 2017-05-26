/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package agent_trade.model;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.ScontoCriteria;

public class M_Sconto {
	public M_Sconto() {
	}
	
	private int id;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
	public static M_Sconto caricaSconto(int idSconto) throws PersistentException{
		
		ScontoCriteria criteria= new ScontoCriteria();
		criteria.id.eq(idSconto);
		return criteria.uniqueSconto();
	}
	
	
	public static void salvaSconto(M_Sconto s)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().save(s);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
//			System.out.println("commit a buon fine per id : "+s.getId()+" ? "+t.wasCommitted());
		}
	}
	
	
}
