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
package persistent;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import agent_trade.persistentTemp.Azienda;

public class AziendaCriteria extends AbstractORMCriteria {
	public final IntegerExpression idAzienda;
	public final StringExpression ragioneSociale;
	public final StringExpression citta;
	public final StringExpression CAP;
	public final StringExpression Indirizzo;
	public final StringExpression telefono;
	public final StringExpression fax;
	public final StringExpression email;
	public final StringExpression partita_iva;
	public final StringExpression codice_fiscale;
	
	public AziendaCriteria(Criteria criteria) {
		super(criteria);
		idAzienda = new IntegerExpression("idAzienda", this);
		ragioneSociale = new StringExpression("ragioneSociale", this);
		citta = new StringExpression("citta", this);
		CAP = new StringExpression("CAP", this);
		Indirizzo = new StringExpression("Indirizzo", this);
		telefono = new StringExpression("telefono", this);
		fax = new StringExpression("fax", this);
		email = new StringExpression("email", this);
		partita_iva = new StringExpression("partita_iva", this);
		codice_fiscale = new StringExpression("codice_fiscale", this);
	}
	
	public AziendaCriteria(PersistentSession session) {
		this(session.createCriteria(Azienda.class));
	}
	
	public AziendaCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public Azienda uniqueAzienda() {
		return (Azienda) super.uniqueResult();
	}
	
	public Azienda[] listAzienda() {
		java.util.List list = super.list();
		return (Azienda[]) list.toArray(new Azienda[list.size()]);
	}
}

