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

import agent_trade.persistentTemp.Vini;

public class ViniCriteria extends AbstractORMCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final StringExpression colore;
	public final StringExpression indicazione_geografica;
	public final StringExpression cantina;
	
	public ViniCriteria(Criteria criteria) {
		super(criteria);
		IdProdotto = new IntegerExpression("IdProdotto", this);
		nome = new StringExpression("nome", this);
		prezzo = new FloatExpression("prezzo", this);
		categoria = new StringExpression("categoria", this);
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this);
		colore = new StringExpression("colore", this);
		indicazione_geografica = new StringExpression("indicazione_geografica", this);
		cantina = new StringExpression("cantina", this);
	}
	
	public ViniCriteria(PersistentSession session) {
		this(session.createCriteria(Vini.class));
	}
	
	public ViniCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public Vini uniqueVini() {
		return (Vini) super.uniqueResult();
	}
	
	public Vini[] listVini() {
		java.util.List list = super.list();
		return (Vini[]) list.toArray(new Vini[list.size()]);
	}
}
