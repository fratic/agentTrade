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

import agent_trade.persistentTemp.Catalogo;

public class CatalogoCriteria extends AbstractORMCriteria {
	public final IntegerExpression idCatalogo;
	public final IntegerExpression rifAziendaId;
	public final AssociationExpression rifAzienda;
	public final CollectionExpression prodotti;
	
	public CatalogoCriteria(Criteria criteria) {
		super(criteria);
		idCatalogo = new IntegerExpression("idCatalogo", this);
		rifAziendaId = new IntegerExpression("rifAzienda.idAzienda", this);
		rifAzienda = new AssociationExpression("rifAzienda", this);
		prodotti = new CollectionExpression("prodotti", this);
	}
	
	public CatalogoCriteria(PersistentSession session) {
		this(session.createCriteria(Catalogo.class));
	}
	
	public CatalogoCriteria() throws PersistentException {
		this(persistent.AgentTradePersistentManager.instance().getSession());
	}
	
	public AziendaCriteria createRifAziendaCriteria() {
		return new AziendaCriteria(createCriteria("rifAzienda"));
	}
	
	public ProdottoCriteria createProdottiCriteria() {
		return new ProdottoCriteria(createCriteria("prodotti"));
	}
	
	public Catalogo uniqueCatalogo() {
		return (Catalogo) super.uniqueResult();
	}
	
	public Catalogo[] listCatalogo() {
		java.util.List list = super.list();
		return (Catalogo[]) list.toArray(new Catalogo[list.size()]);
	}
}

