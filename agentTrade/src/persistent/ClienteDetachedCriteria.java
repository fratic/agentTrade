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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

import agent_trade.model.M_Cliente;

public class ClienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idCliente;
	public final IntegerExpression agenteAssociatoId;
	public final AssociationExpression agenteAssociato;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codice_fiscale;
	public final StringExpression indirizzo;
	public final StringExpression email;
	public final StringExpression partita_iva;
	public final StringExpression telefono;
	public final StringExpression fax;
	public final StringExpression citta;
	public final StringExpression CAP;
	public final StringExpression cell;
	
	public ClienteDetachedCriteria() {
		super(agent_trade.model.M_Cliente.class, persistent.ClienteCriteria.class);
		idCliente = new IntegerExpression("idCliente", this.getDetachedCriteria());
		agenteAssociatoId = new IntegerExpression("agenteAssociato.IdAgente", this.getDetachedCriteria());
		agenteAssociato = new AssociationExpression("agenteAssociato", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codice_fiscale = new StringExpression("codice_fiscale", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		partita_iva = new StringExpression("partita_iva", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fax = new StringExpression("fax", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		CAP = new StringExpression("CAP", this.getDetachedCriteria());
		cell = new StringExpression("cell", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.ClienteCriteria.class);
		idCliente = new IntegerExpression("idCliente", this.getDetachedCriteria());
		agenteAssociatoId = new IntegerExpression("agenteAssociato.IdAgente", this.getDetachedCriteria());
		agenteAssociato = new AssociationExpression("agenteAssociato", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codice_fiscale = new StringExpression("codice_fiscale", this.getDetachedCriteria());
		indirizzo = new StringExpression("indirizzo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		partita_iva = new StringExpression("partita_iva", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		fax = new StringExpression("fax", this.getDetachedCriteria());
		citta = new StringExpression("citta", this.getDetachedCriteria());
		CAP = new StringExpression("CAP", this.getDetachedCriteria());
		cell = new StringExpression("cell", this.getDetachedCriteria());
	}
	
	public AgenteDetachedCriteria createAgenteAssociatoCriteria() {
		return new AgenteDetachedCriteria(createCriteria("agenteAssociato"));
	}
	
	public M_Cliente uniqueM_Cliente(PersistentSession session) {
		return (M_Cliente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public M_Cliente[] listM_Cliente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (M_Cliente[]) list.toArray(new M_Cliente[list.size()]);
	}
}

