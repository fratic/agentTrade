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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import model.M_Mandante;

public class M_MandanteCriteria extends AbstractORMCriteria {
	public final IntegerExpression idMandante;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression username;
	public final StringExpression password;
	
	public M_MandanteCriteria(Criteria criteria) {
		super(criteria);
		idMandante = new IntegerExpression("idMandante", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
	}
	
	public M_MandanteCriteria(PersistentSession session) {
		this(session.createCriteria(M_Mandante.class));
	}
	
	public M_MandanteCriteria() throws PersistentException {
		this(AgentTradeMandantePersistentManager.instance().getSession());
	}
	
	public M_Mandante uniqueM_Mandante() {
		return (M_Mandante) super.uniqueResult();
	}
	
	public M_Mandante[] listM_Mandante() {
		java.util.List list = super.list();
		return (M_Mandante[]) list.toArray(new M_Mandante[list.size()]);
	}
}

