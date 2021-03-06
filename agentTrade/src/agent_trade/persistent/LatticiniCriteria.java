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

import agent_trade.model.M_Latticini;

public class LatticiniCriteria extends AbstractORMCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final IntegerExpression stagionatura;
	public final StringExpression tipo;
	
	public LatticiniCriteria(Criteria criteria) {
		super(criteria);
		IdProdotto = new IntegerExpression("IdProdotto", this);
		nome = new StringExpression("nome", this);
		prezzo = new FloatExpression("prezzo", this);
		categoria = new StringExpression("categoria", this);
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this);
		stagionatura = new IntegerExpression("stagionatura", this);
		tipo = new StringExpression("tipo", this);
	}
	
	public LatticiniCriteria(PersistentSession session) {
		this(session.createCriteria(M_Latticini.class));
	}
	
	public LatticiniCriteria() throws PersistentException {
		this(agent_trade.persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public M_Latticini uniqueM_Latticini() {
		return (M_Latticini) super.uniqueResult();
	}
	
	public M_Latticini[] listM_Latticini() {
		java.util.List list = super.list();
		return (M_Latticini[]) list.toArray(new M_Latticini[list.size()]);
	}
}

