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

import agent_trade.model.M_ScontoCliente;

public class ScontoClienteCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression versione;
	public final FloatExpression percent;
	
	public ScontoClienteCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		versione = new IntegerExpression("versione", this);
		percent = new FloatExpression("percent", this);
	}
	
	public ScontoClienteCriteria(PersistentSession session) {
		this(session.createCriteria(M_ScontoCliente.class));
	}
	
	public ScontoClienteCriteria() throws PersistentException {
		this(AgentTradePersistentManager.instance().getSession());
	}
	
	public M_ScontoCliente uniqueScontoCliente() {
		return (M_ScontoCliente) super.uniqueResult();
	}
	
	public M_ScontoCliente[] listScontoCliente() {
		java.util.List list = super.list();
		return (M_ScontoCliente[]) list.toArray(new M_ScontoCliente[list.size()]);
	}
}

