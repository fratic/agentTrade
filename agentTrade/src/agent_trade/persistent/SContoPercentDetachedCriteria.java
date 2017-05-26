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

import agent_trade.model.M_ScontoPercent;

public class SContoPercentDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression percent;
	
	public SContoPercentDetachedCriteria() {
		super(agent_trade.model.M_ScontoPercent.class, agent_trade.persistent.SContoPercentCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		percent = new FloatExpression("percent", this.getDetachedCriteria());
	}
	
	public SContoPercentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.SContoPercentCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		percent = new FloatExpression("percent", this.getDetachedCriteria());
	}
	
	public M_ScontoPercent uniqueSContoPercent(PersistentSession session) {
		return (M_ScontoPercent) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_ScontoPercent[] listSContoPercent(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_ScontoPercent[]) list.toArray(new M_ScontoPercent[list.size()]);
	}
}

