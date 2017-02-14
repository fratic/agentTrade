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

import agent_trade.model.M_Cliente;

public class ClienteCriteria extends AbstractORMCriteria {
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
	public final IntegerExpression attivo;

	
	public ClienteCriteria(Criteria criteria) {
		super(criteria);
		idCliente = new IntegerExpression("idCliente", this);
		agenteAssociatoId = new IntegerExpression("agenteAssociato.IdAgente", this);
		agenteAssociato = new AssociationExpression("agenteAssociato", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		codice_fiscale = new StringExpression("codice_fiscale", this);
		indirizzo = new StringExpression("indirizzo", this);
		email = new StringExpression("email", this);
		partita_iva = new StringExpression("partita_iva", this);
		telefono = new StringExpression("telefono", this);
		fax = new StringExpression("fax", this);
		citta = new StringExpression("citta", this);
		CAP = new StringExpression("CAP", this);
		cell = new StringExpression("cell", this);
		attivo = new IntegerExpression("attivo", this);

	}
	
	public ClienteCriteria(PersistentSession session) {
		this(session.createCriteria(M_Cliente.class));
	}
	
	public ClienteCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public AgenteCriteria createAgenteAssociatoCriteria() {
		return new AgenteCriteria(createCriteria("agenteAssociato"));
	}
	
	public M_Cliente uniqueM_Cliente() {
		return (M_Cliente) super.uniqueResult();
	}
	
	public M_Cliente[] listCliente() {
		java.util.List list = super.list();
		return (M_Cliente[]) list.toArray(new M_Cliente[list.size()]);
	}
}

