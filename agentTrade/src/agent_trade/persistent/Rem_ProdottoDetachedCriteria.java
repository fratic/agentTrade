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
import org.orm.criteria.*;

import agent_trade.model.M_Prodotto;

public class Rem_ProdottoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdProdotto;
	public final IntegerExpression idProdottoAzienda;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final FloatExpression sconto;
	public final IntegerExpression versione;

	
	public Rem_ProdottoDetachedCriteria() {
		super(agent_trade.model.M_Prodotto.class, agent_trade.persistent.ProdottoCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		idProdottoAzienda = new IntegerExpression("idProdottoAzienda", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		sconto = new FloatExpression("sconto", this.getDetachedCriteria());
		versione = new IntegerExpression("versione", this.getDetachedCriteria());

	}
	
	public Rem_ProdottoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, agent_trade.persistent.ProdottoCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		idProdottoAzienda = new IntegerExpression("idProdottoAzienda", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		sconto = new FloatExpression("sconto", this.getDetachedCriteria());
		versione = new IntegerExpression("versione", this.getDetachedCriteria());


	}
	
	public M_Prodotto uniqueM_Prodotto(PersistentSession session) {
		return (M_Prodotto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Prodotto[] listM_Prodotto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Prodotto[]) list.toArray(new M_Prodotto[list.size()]);
	}
}

