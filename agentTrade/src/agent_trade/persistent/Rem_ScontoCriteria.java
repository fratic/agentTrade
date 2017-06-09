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
package agent_trade.persistent;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.IntegerExpression;

import agent_trade.model.M_Sconto;

public class Rem_ScontoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	
	public Rem_ScontoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
	}
	
	public Rem_ScontoCriteria(PersistentSession session) {
		this(session.createCriteria(M_Sconto.class));
	}
	
	public Rem_ScontoCriteria() throws PersistentException {
		this(AgentTradeMandantePersistentManager.instance().getSession());
	}
	
	public M_Sconto uniqueSconto() {
		return (M_Sconto) super.uniqueResult();
	}
	
	public M_Sconto[] listSconto() {
		java.util.List list = super.list();
		return (M_Sconto[]) list.toArray(new M_Sconto[list.size()]);
	}
}

