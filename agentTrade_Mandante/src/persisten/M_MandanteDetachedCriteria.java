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

import model.M_Mandante;

public class M_MandanteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idMandante;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression username;
	public final StringExpression password;
	
	public M_MandanteDetachedCriteria() {
		super(M_Mandante.class, M_MandanteCriteria.class);
		idMandante = new IntegerExpression("idMandante", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public M_MandanteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, M_MandanteCriteria.class);
		idMandante = new IntegerExpression("idMandante", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public M_Mandante uniqueM_Mandante(PersistentSession session) {
		return (M_Mandante) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Mandante[] listM_Mandante(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Mandante[]) list.toArray(new M_Mandante[list.size()]);
	}
}

