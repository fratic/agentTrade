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

import agent_trade.model.M_Preventivo;

public class PreventivoCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPreventivo;
	public final IntegerExpression rif_ClienteId;
	public final AssociationExpression rif_Cliente;
	public final IntegerExpression rif_AgenteId;
	public final AssociationExpression rif_Agente;
	public final DateExpression data;
	public final CollectionExpression item;
	
	public PreventivoCriteria(Criteria criteria) {
		super(criteria);
		idPreventivo = new IntegerExpression("idPreventivo", this);
		rif_ClienteId = new IntegerExpression("rif_Cliente.idCliente", this);
		rif_Cliente = new AssociationExpression("rif_Cliente", this);
		rif_AgenteId = new IntegerExpression("rif_Agente.IdAgente", this);
		rif_Agente = new AssociationExpression("rif_Agente", this);
		data = new DateExpression("data", this);
		item = new CollectionExpression("item", this);
		
	}
	
	public PreventivoCriteria(PersistentSession session) {
		this(session.createCriteria(M_Preventivo.class));
	}
	
	public PreventivoCriteria() throws PersistentException {
		this(agent_trade.persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public ClienteCriteria createRif_ClienteCriteria() {
		return new ClienteCriteria(createCriteria("rif_Cliente"));
	}
	
	public AgenteCriteria createRif_AgenteCriteria() {
		return new AgenteCriteria(createCriteria("rif_Agente"));
	}
	
	public Preventivo_ItemCriteria createItemCriteria() {
		return new Preventivo_ItemCriteria(createCriteria("item"));
	}
	
	public M_Preventivo uniquePreventivo() {
		return (M_Preventivo) super.uniqueResult();
	}
	
	public M_Preventivo[] listPreventivo() {
		java.util.List list = super.list();
		return (M_Preventivo[]) list.toArray(new M_Preventivo[list.size()]);
	}
}

