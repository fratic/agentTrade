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
package agent_trade.persistentTemp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import persistent.CarniCriteria;

public class CarniDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IdProdotto;
	public final StringExpression nome;
	public final FloatExpression prezzo;
	public final StringExpression categoria;
	public final StringExpression idDescrizioneProdotto;
	public final StringExpression provenienza;
	public final StringExpression taglio;
	public final StringExpression tipo;
	
	public CarniDetachedCriteria() {
		super(agent_trade.persistentTemp.Carni.class, persistent.CarniCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		provenienza = new StringExpression("provenienza", this.getDetachedCriteria());
		taglio = new StringExpression("taglio", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public CarniDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.CarniCriteria.class);
		IdProdotto = new IntegerExpression("IdProdotto", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		prezzo = new FloatExpression("prezzo", this.getDetachedCriteria());
		categoria = new StringExpression("categoria", this.getDetachedCriteria());
		idDescrizioneProdotto = new StringExpression("idDescrizioneProdotto", this.getDetachedCriteria());
		provenienza = new StringExpression("provenienza", this.getDetachedCriteria());
		taglio = new StringExpression("taglio", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public Carni uniqueCarni(PersistentSession session) {
		return (Carni) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Carni[] listCarni(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Carni[]) list.toArray(new Carni[list.size()]);
	}
}

