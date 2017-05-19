package agent_trade.persistent;
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
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import agent_trade.model.M_Azienda;


public class AziendaCriteria extends AbstractORMCriteria {

	public final IntegerExpression IdAzienda;
	public final StringExpression ragioneSociale;
	public final StringExpression codiceFiscale;
	public final StringExpression partitaIva;
	public final StringExpression citta;
	public final StringExpression cap;
	public final StringExpression indirizzo;
	public final StringExpression email;
	public final StringExpression telefono;
	public final StringExpression fax;
	public final StringExpression url;
	public final StringExpression tipoProdotto;
	
	public AziendaCriteria(Criteria criteria) {
		
		super(criteria);
		
		IdAzienda  = new IntegerExpression("IdAzienda", this);
		ragioneSociale = new StringExpression("ragioneSociale", this);
		codiceFiscale = new StringExpression("codiceFiscale", this);
		partitaIva = new StringExpression("partitaIva", this);
		citta = new StringExpression("citta", this);
		cap = new StringExpression("cap", this);
		indirizzo = new StringExpression("indirizzo", this);
		email = new StringExpression("email", this);
		telefono = new StringExpression("telefono", this);
		fax = new StringExpression("fax", this);
		url = new StringExpression("url", this);
		tipoProdotto = new StringExpression("tipoProdotto", this);
	}
	
	public AziendaCriteria(PersistentSession session) {
		this(session.createCriteria(M_Azienda.class));
	}
	
	public AziendaCriteria() throws PersistentException {
		this(AgentTradePersistentManager.instance().getSession());
	}
	
	public M_Azienda uniqueM_Azienda() {
		return (M_Azienda) super.uniqueResult();
	}
	
	public M_Azienda[] listM_Azienda() {
		java.util.List list = super.list();
		return (M_Azienda[]) list.toArray(new M_Azienda[list.size()]);
	}
	
}
