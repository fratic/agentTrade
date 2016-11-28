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
package agent_trade.persistentTemp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import agent_trade.model.Preventivo_Item;

public class Preventivo_ItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idPreventivo_Item;
	public final IntegerExpression idProdottoId;
	public final AssociationExpression idProdotto;
	public final IntegerExpression quantita;
	public final IntegerExpression ArrayList_observer;
	public final IntegerExpression observers;
	
	public Preventivo_ItemDetachedCriteria() {
		super(agent_trade.model.Preventivo_Item.class, persistent.Preventivo_ItemCriteria.class);
		idPreventivo_Item = new IntegerExpression("idPreventivo_Item", this.getDetachedCriteria());
		idProdottoId = new IntegerExpression("idProdotto.IdProdotto", this.getDetachedCriteria());
		idProdotto = new AssociationExpression("idProdotto", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
		ArrayList_observer = new IntegerExpression("ArrayList_observer", this.getDetachedCriteria());
		observers = new IntegerExpression("observers", this.getDetachedCriteria());
	}
	
	public Preventivo_ItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.Preventivo_ItemCriteria.class);
		idPreventivo_Item = new IntegerExpression("idPreventivo_Item", this.getDetachedCriteria());
		idProdottoId = new IntegerExpression("idProdotto.IdProdotto", this.getDetachedCriteria());
		idProdotto = new AssociationExpression("idProdotto", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
		ArrayList_observer = new IntegerExpression("ArrayList_observer", this.getDetachedCriteria());
		observers = new IntegerExpression("observers", this.getDetachedCriteria());
	}
	
	public ProdottoDetachedCriteria createIdProdottoCriteria() {
		return new ProdottoDetachedCriteria(createCriteria("idProdotto"));
	}
	
	public Preventivo_Item uniquePreventivo_Item(PersistentSession session) {
		return (Preventivo_Item) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Preventivo_Item[] listPreventivo_Item(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Preventivo_Item[]) list.toArray(new Preventivo_Item[list.size()]);
	}
}

