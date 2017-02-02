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

import agent_trade.model.M_Preventivo_Item;

public class Preventivo_ItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPreventivo_Item;
	public final IntegerExpression idProdottoId;
	public final AssociationExpression idProdotto;
	public final IntegerExpression quantita;
	public final FloatExpression sconto;
	
	public Preventivo_ItemCriteria(Criteria criteria) {
		super(criteria);
		idPreventivo_Item = new IntegerExpression("idPreventivo_Item", this);
		idProdottoId = new IntegerExpression("idProdotto.IdProdotto", this);
		idProdotto = new AssociationExpression("idProdotto", this);
		quantita = new IntegerExpression("quantita", this);
		sconto = new FloatExpression("sconto", this);
		
	}
	
	public Preventivo_ItemCriteria(PersistentSession session) {
		this(session.createCriteria(M_Preventivo_Item.class));
	}
	
	public Preventivo_ItemCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public ProdottoCriteria createIdProdottoCriteria() {
		return new ProdottoCriteria(createCriteria("idProdotto"));
	}
	
	public PreventivoCriteria createObsCriteria() {
		return new PreventivoCriteria(createCriteria("observer"));
	}
	
	public M_Preventivo_Item uniqueM_Preventivo_Item() {
		return (M_Preventivo_Item) super.uniqueResult();
	}
	
	public M_Preventivo_Item[] listM_Preventivo_Item() {
		java.util.List list = super.list();
		return (M_Preventivo_Item[]) list.toArray(new M_Preventivo_Item[list.size()]);
	}
}

