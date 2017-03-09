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
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import agent_trade.model.M_Agente;

public class AgenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdAgente;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression password;
	public final StringExpression username;
	public final StringExpression citta;
	public final StringExpression indirizzo;
	public final IntegerExpression livello;
	public final StringExpression cell;
	public final StringExpression email;
	public final StringExpression cap;
	public final IntegerExpression attivo;
	
	public AgenteDetachedCriteria() {
		super(agent_trade.model.M_Agente.class, AgenteCriteria.class);
		IdAgente = new IntegerExpression("IdAgente", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
		livello = new IntegerExpression("livello", this.getDetachedCriteria());
		cell = new StringExpression("cell", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		cap = new StringExpression("cap", this.getDetachedCriteria());
		attivo = new IntegerExpression("attivo", this.getDetachedCriteria());
	}
	
	public AgenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, AgenteCriteria.class);
		IdAgente = new IntegerExpression("IdAgente", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
		livello = new IntegerExpression("livello", this.getDetachedCriteria());
		cell = new StringExpression("cell", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		cap = new StringExpression("cap", this.getDetachedCriteria());
		attivo = new IntegerExpression("attivo", this.getDetachedCriteria());
	}
	
	public M_Agente uniqueM_Agente(PersistentSession session) {
		return (M_Agente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Agente[] listM_Agente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Agente[]) list.toArray(new M_Agente[list.size()]);
	}
}

