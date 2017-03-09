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

import agent_trade.model.M_Agente;

public class AgenteCriteria extends AbstractORMCriteria {
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
	
	public AgenteCriteria(Criteria criteria) {
		super(criteria);
		IdAgente = new IntegerExpression("IdAgente", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		password = new StringExpression("password", this);
		username = new StringExpression("username", this);
		citta = new StringExpression("citta", this);
		indirizzo = new StringExpression("indirizzo", this);
		livello = new IntegerExpression("livello", this);
		cell = new StringExpression("cell", this);
		email = new StringExpression("email", this);
		cap = new StringExpression("cap", this);
		attivo = new IntegerExpression("attivo", this);
	}
	
	public AgenteCriteria(PersistentSession session) {
		this(session.createCriteria(M_Agente.class));
	}
	
	public AgenteCriteria() throws PersistentException {
		this(agent_trade.persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public M_Agente uniqueAgente() {
		return (M_Agente) super.uniqueResult();
	}
	
	public M_Agente[] listAgente() {
		java.util.List list = super.list();
		return (M_Agente[]) list.toArray(new M_Agente[list.size()]);
	}
}

