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

import persistent.DolciCriteria;

public class DolciDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final BooleanExpression artigianale;
	public final BooleanExpression free_gluten;
	
	public DolciDetachedCriteria() {
		super(agent_trade.persistentTemp.Dolci.class, persistent.DolciCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		artigianale = new BooleanExpression("artigianale", this.getDetachedCriteria());
		free_gluten = new BooleanExpression("free_gluten", this.getDetachedCriteria());
	}
	
	public DolciDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.DolciCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		artigianale = new BooleanExpression("artigianale", this.getDetachedCriteria());
		free_gluten = new BooleanExpression("free_gluten", this.getDetachedCriteria());
	}
	
	public Dolci uniqueDolci(PersistentSession session) {
		return (Dolci) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Dolci[] listDolci(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Dolci[]) list.toArray(new Dolci[list.size()]);
	}
}

