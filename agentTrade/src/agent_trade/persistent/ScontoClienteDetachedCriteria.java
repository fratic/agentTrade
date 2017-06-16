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

import agent_trade.model.M_ScontoCliente;

public class ScontoClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression versione;
	public final FloatExpression percent;
	
	public ScontoClienteDetachedCriteria() {
		super(agent_trade.model.M_ScontoCliente.class, agent_trade.persistent.ScontoClienteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		versione = new IntegerExpression("versione", this.getDetachedCriteria());
		percent = new FloatExpression("percent", this.getDetachedCriteria());
	}
	
	public ScontoClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.ScontoClienteCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		versione = new IntegerExpression("versione", this.getDetachedCriteria());
		percent = new FloatExpression("percent", this.getDetachedCriteria());
	}
	
	public M_ScontoCliente uniqueScontoCliente(PersistentSession session) {
		return (M_ScontoCliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_ScontoCliente[] listScontoCliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_ScontoCliente[]) list.toArray(new M_ScontoCliente[list.size()]);
	}
}

