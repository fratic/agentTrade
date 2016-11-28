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

public class PreventivoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression idPreventivo;
	public final IntegerExpression rif_ClienteId;
	public final AssociationExpression rif_Cliente;
	public final IntegerExpression rif_AgenteId;
	public final AssociationExpression rif_Agente;
	public final DateExpression data;
	public final CollectionExpression elencoITem;
	
	public PreventivoDetachedCriteria() {
		super(agent_trade.persistentTemp.Preventivo.class, persistent.PreventivoCriteria.class);
		idPreventivo = new StringExpression("idPreventivo", this.getDetachedCriteria());
		rif_ClienteId = new IntegerExpression("rif_Cliente.idCliente", this.getDetachedCriteria());
		rif_Cliente = new AssociationExpression("rif_Cliente", this.getDetachedCriteria());
		rif_AgenteId = new IntegerExpression("rif_Agente.IdAgente", this.getDetachedCriteria());
		rif_Agente = new AssociationExpression("rif_Agente", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		elencoITem = new CollectionExpression("elencoITem", this.getDetachedCriteria());
	}
	
	public PreventivoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.PreventivoCriteria.class);
		idPreventivo = new StringExpression("idPreventivo", this.getDetachedCriteria());
		rif_ClienteId = new IntegerExpression("rif_Cliente.idCliente", this.getDetachedCriteria());
		rif_Cliente = new AssociationExpression("rif_Cliente", this.getDetachedCriteria());
		rif_AgenteId = new IntegerExpression("rif_Agente.IdAgente", this.getDetachedCriteria());
		rif_Agente = new AssociationExpression("rif_Agente", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		elencoITem = new CollectionExpression("elencoITem", this.getDetachedCriteria());
	}
	
	public ClienteDetachedCriteria createRif_ClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("rif_Cliente"));
	}
	
	public AgenteDetachedCriteria createRif_AgenteCriteria() {
		return new AgenteDetachedCriteria(createCriteria("rif_Agente"));
	}
	
	public Preventivo_ItemDetachedCriteria createElencoITemCriteria() {
		return new Preventivo_ItemDetachedCriteria(createCriteria("elencoITem"));
	}
	
	public Preventivo uniquePreventivo(PersistentSession session) {
		return (Preventivo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Preventivo[] listPreventivo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
	}
}

