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
package persistent;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import agent_trade.persistentTemp.Dolci;

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
		this(session.createCriteria(Dolci.class));
	}
	
	public DolciCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public Dolci uniqueDolci() {
		return (Dolci) super.uniqueResult();
	}
	
	public Dolci[] listDolci() {
		java.util.List list = super.list();
		return (Dolci[]) list.toArray(new Dolci[list.size()]);
	}
}

