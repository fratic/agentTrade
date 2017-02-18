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

import agent_trade.model.M_Latticini;

public class LatticiniDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final IntegerExpression stagionatura;
	public final StringExpression tipo;
	
	public LatticiniDetachedCriteria() {
		super(agent_trade.model.M_Latticini.class, agent_trade.persistent.LatticiniCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		stagionatura = new IntegerExpression("stagionatura", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public LatticiniDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.LatticiniCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		stagionatura = new IntegerExpression("stagionatura", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public M_Latticini uniqueM_Latticini(PersistentSession session) {
		return (M_Latticini) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Latticini[] listM_Latticini(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Latticini[]) list.toArray(new M_Latticini[list.size()]);
	}
}

