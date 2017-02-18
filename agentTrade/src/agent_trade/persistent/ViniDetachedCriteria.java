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

import agent_trade.model.M_Vini;

public class ViniDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final StringExpression colore;
	public final StringExpression indicazione_geografica;
	public final StringExpression cantina;
	
	public ViniDetachedCriteria() {
		super(agent_trade.model.M_Vini.class, agent_trade.persistent.ViniCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		colore = new StringExpression("colore", this.getDetachedCriteria());
		indicazione_geografica = new StringExpression("indicazione_geografica", this.getDetachedCriteria());
		cantina = new StringExpression("cantina", this.getDetachedCriteria());
	}
	
	public ViniDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.ViniCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		colore = new StringExpression("colore", this.getDetachedCriteria());
		indicazione_geografica = new StringExpression("indicazione_geografica", this.getDetachedCriteria());
		cantina = new StringExpression("cantina", this.getDetachedCriteria());
	}
	
	public M_Vini uniqueM_Vini(PersistentSession session) {
		return (M_Vini) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Vini[] listM_Vini(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Vini[]) list.toArray(new M_Vini[list.size()]);
	}
}

