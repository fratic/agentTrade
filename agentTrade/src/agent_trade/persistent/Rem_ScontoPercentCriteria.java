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
import org.orm.criteria.FloatExpression;
import org.orm.criteria.IntegerExpression;

import agent_trade.model.M_ScontoPercent;

public class Rem_ScontoPercentCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression percent;
	
	public Rem_ScontoPercentCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		percent = new FloatExpression("percent", this);
	}
	
	public Rem_ScontoPercentCriteria(PersistentSession session) {
		this(session.createCriteria(M_ScontoPercent.class));
	}
	
	public Rem_ScontoPercentCriteria() throws PersistentException {
		this(AgentTradeMandantePersistentManager.instance().getSession());
	}
	
	public M_ScontoPercent uniqueSContoPercent() {
		return (M_ScontoPercent) super.uniqueResult();
	}
	
	public M_ScontoPercent[] listSContoPercent() {
		java.util.List list = super.list();
		return (M_ScontoPercent[]) list.toArray(new M_ScontoPercent[list.size()]);
	}
}

