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

import agent_trade.model.M_Prodotto;

public class ProdottoCriteria extends AbstractORMCriteria {
	public final IntegerExpression IdProdotto;
	public final IntegerExpression idProdottoAzienda;

	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final FloatExpression sconto;
	public final IntegerExpression versione;
    public final IntegerExpression idAzienda;
	
	public ProdottoCriteria(Criteria criteria) {
		super(criteria);
		IdProdotto = new IntegerExpression("IdProdotto", this);
		idProdottoAzienda = new IntegerExpression("idProdottoAzienda", this);
		nome = new StringExpression("nome", this);
		prezzo = new FloatExpression("prezzo", this);
		categoria = new StringExpression("categoria", this);
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this);
		sconto = new FloatExpression("sconto", this);
		versione = new IntegerExpression("versione", this);
		idAzienda = new IntegerExpression("idAzienda", this);
		
	}
	
	public ProdottoCriteria(PersistentSession session) {
		this(session.createCriteria(M_Prodotto.class));
	}
	
	public ProdottoCriteria() throws PersistentException {
		this(agent_trade.persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public M_Prodotto uniqueProdotto() {
		return (M_Prodotto) super.uniqueResult();
	}
	
	public M_Prodotto[] listProdotto() {
		java.util.List list = super.list();
		return (M_Prodotto[]) list.toArray(new M_Prodotto[list.size()]);
	}
}

