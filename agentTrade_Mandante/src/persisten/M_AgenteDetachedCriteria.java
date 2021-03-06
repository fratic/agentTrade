package persisten;
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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import model.M_Agente;

public class M_AgenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idAgente;
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
	
	public M_AgenteDetachedCriteria() {
		super(M_Agente.class, M_AgenteCriteria.class);
		idAgente = new IntegerExpression("idAgente", this.getDetachedCriteria());
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
	}
	
	public M_AgenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, M_AgenteCriteria.class);
		idAgente = new IntegerExpression("idAgente", this.getDetachedCriteria());
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
	}
	
	public M_Agente uniqueM_Agente(PersistentSession session) {
		return (M_Agente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Agente[] listM_Agente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Agente[]) list.toArray(new M_Agente[list.size()]);
	}
}

