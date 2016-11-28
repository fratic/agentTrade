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

public class AgenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdAgente;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression password;
	
	public AgenteDetachedCriteria() {
		super(agent_trade.persistentTemp.Agente.class, persistent.AgenteCriteria.class);
		IdAgente = new IntegerExpression("IdAgente", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public AgenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.AgenteCriteria.class);
		IdAgente = new IntegerExpression("IdAgente", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public Agente uniqueAgente(PersistentSession session) {
		return (Agente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Agente[] listAgente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Agente[]) list.toArray(new Agente[list.size()]);
	}
}

