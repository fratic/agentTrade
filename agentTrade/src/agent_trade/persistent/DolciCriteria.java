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
import org.orm.criteria.*;

import agent_trade.model.M_Dolci;

public class DolciCriteria extends AbstractORMCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final BooleanExpression artigianale;
	public final BooleanExpression free_gluten;
	
	public DolciCriteria(Criteria criteria) {
		super(criteria);
		IdProdotto = new IntegerExpression("IdProdotto", this);
		nome = new StringExpression("nome", this);
		prezzo = new FloatExpression("prezzo", this);
		categoria = new StringExpression("categoria", this);
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this);
		artigianale = new BooleanExpression("artigianale", this);
		free_gluten = new BooleanExpression("free_gluten", this);
	}
	
	public DolciCriteria(PersistentSession session) {
		this(session.createCriteria(M_Dolci.class));
	}
	
	public DolciCriteria() throws PersistentException {
		this(agent_trade.persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public M_Dolci uniqueM_Dolci() {
		return (M_Dolci) super.uniqueResult();
	}
	
	public M_Dolci[] listM_Dolci() {
		java.util.List list = super.list();
		return (M_Dolci[]) list.toArray(new M_Dolci[list.size()]);
	}
}

