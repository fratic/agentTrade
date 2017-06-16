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
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;

import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import agent_trade.model.M_Azienda;


public class AziendaDetachedCriteria extends AbstractORMDetachedCriteria {
	
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
	public final IntegerExpression versione;

	
	public AziendaDetachedCriteria() {
		
		super(M_Azienda.class, AziendaCriteria.class);
		
		IdAzienda  = new IntegerExpression("IdAzienda", this.getDetachedCriteria());
		ragioneSociale = new StringExpression("ragioneSociale", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		partitaIva = new StringExpression("partitaIva", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		cap = new StringExpression("cap", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fax = new StringExpression("fax", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		tipoProdotto = new StringExpression("tipoProdotto", this.getDetachedCriteria());
		versione  = new IntegerExpression("versione", this.getDetachedCriteria());

	}
	
	public AziendaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		
		super(aDetachedCriteria, AziendaCriteria.class);
		
		IdAzienda  = new IntegerExpression("IdAzienda", this.getDetachedCriteria());
		ragioneSociale = new StringExpression("ragioneSociale", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		partitaIva = new StringExpression("partitaIva", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		cap = new StringExpression("cap", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fax = new StringExpression("fax", this.getDetachedCriteria());
		url = new StringExpression("url", this.getDetachedCriteria());
		tipoProdotto = new StringExpression("tipoProdotto", this.getDetachedCriteria());
		versione  = new IntegerExpression("versione", this.getDetachedCriteria());

	}
	
	public M_Azienda uniqueM_Azienda(PersistentSession session) {
		return (M_Azienda) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Azienda[] listM_Agente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Azienda[]) list.toArray(new M_Azienda[list.size()]);
	}

}
