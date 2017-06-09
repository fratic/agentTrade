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

import agent_trade.model.M_ScontoQuantita;

public class Rem_ScontoQuantitaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression quantita;
	public final FloatExpression scontoFisso;
	
	public Rem_ScontoQuantitaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		quantita = new IntegerExpression("quantita", this);
		scontoFisso = new FloatExpression("scontoFisso", this);
	}
	
	public Rem_ScontoQuantitaCriteria(PersistentSession session) {
		this(session.createCriteria(M_ScontoQuantita.class));
	}
	
	public Rem_ScontoQuantitaCriteria() throws PersistentException {
		this(AgentTradeMandantePersistentManager.instance().getSession());
	}
	
	public M_ScontoQuantita uniqueScontoQuantita() {
		return (M_ScontoQuantita) super.uniqueResult();
	}
	
	public M_ScontoQuantita[] listScontoQuantita() {
		java.util.List list = super.list();
		return (M_ScontoQuantita[]) list.toArray(new M_ScontoQuantita[list.size()]);
	}
}

