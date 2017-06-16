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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import agent_trade.model.M_Sconto;

public class ScontoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression versione;

	public ScontoDetachedCriteria() {
		super(agent_trade.model.M_Sconto.class, agent_trade.persistent.ScontoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		versione = new IntegerExpression("versione", this.getDetachedCriteria());

	}
	
	public ScontoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.ScontoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		versione = new IntegerExpression("versione", this.getDetachedCriteria());

	}
	
	public M_Sconto uniqueSconto(PersistentSession session) {
		return (M_Sconto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Sconto[] listSconto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Sconto[]) list.toArray(new M_Sconto[list.size()]);
	}
}

