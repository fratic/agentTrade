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

import agent_trade.persistentTemp.Carni;

public class CarniCriteria extends AbstractORMCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final StringExpression provenienza;
	public final StringExpression taglio;
	public final StringExpression tipo;
	
	public CarniCriteria(Criteria criteria) {
		super(criteria);
		IdProdotto = new IntegerExpression("IdProdotto", this);
		nome = new StringExpression("nome", this);
		prezzo = new FloatExpression("prezzo", this);
		categoria = new StringExpression("categoria", this);
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this);
		provenienza = new StringExpression("provenienza", this);
		taglio = new StringExpression("taglio", this);
		tipo = new StringExpression("tipo", this);
	}
	
	public CarniCriteria(PersistentSession session) {
		this(session.createCriteria(Carni.class));
	}
	
	public CarniCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public Carni uniqueCarni() {
		return (Carni) super.uniqueResult();
	}
	
	public Carni[] listCarni() {
		java.util.List list = super.list();
		return (Carni[]) list.toArray(new Carni[list.size()]);
	}
}

