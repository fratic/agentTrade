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

import agent_trade.model.M_ScontoQuantita;

public class ScontoQuantitaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression quantita;
	public final FloatExpression scontoFisso;
	
	public ScontoQuantitaDetachedCriteria() {
		super(agent_trade.model.M_ScontoQuantita.class, agent_trade.persistent.ScontoQuantitaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
		scontoFisso = new FloatExpression("scontoFisso", this.getDetachedCriteria());
	}
	
	public ScontoQuantitaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.ScontoQuantitaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
		scontoFisso = new FloatExpression("scontoFisso", this.getDetachedCriteria());
	}
	
	public M_ScontoQuantita uniqueScontoQuantita(PersistentSession session) {
		return (M_ScontoQuantita) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_ScontoQuantita[] listScontoQuantita(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_ScontoQuantita[]) list.toArray(new M_ScontoQuantita[list.size()]);
	}
}

