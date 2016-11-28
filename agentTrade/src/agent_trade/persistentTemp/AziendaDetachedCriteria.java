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

import persistent.AziendaCriteria;

public class AziendaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public AziendaDetachedCriteria() {
		super(agent_trade.persistentTemp.Azienda.class, persistent.AziendaCriteria.class);
		idAzienda = new IntegerExpression("idAzienda", this.getDetachedCriteria());
		ragioneSociale = new StringExpression("ragioneSociale", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		CAP = new StringExpression("CAP", this.getDetachedCriteria());
		Indirizzo = new StringExpression("Indirizzo", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fax = new StringExpression("fax", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		partita_iva = new StringExpression("partita_iva", this.getDetachedCriteria());
		codice_fiscale = new StringExpression("codice_fiscale", this.getDetachedCriteria());
	}
	
	public AziendaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.AziendaCriteria.class);
		idAzienda = new IntegerExpression("idAzienda", this.getDetachedCriteria());
		ragioneSociale = new StringExpression("ragioneSociale", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		CAP = new StringExpression("CAP", this.getDetachedCriteria());
		Indirizzo = new StringExpression("Indirizzo", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fax = new StringExpression("fax", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		partita_iva = new StringExpression("partita_iva", this.getDetachedCriteria());
		codice_fiscale = new StringExpression("codice_fiscale", this.getDetachedCriteria());
	}
	
	public Azienda uniqueAzienda(PersistentSession session) {
		return (Azienda) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Azienda[] listAzienda(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Azienda[]) list.toArray(new Azienda[list.size()]);
	}
}

