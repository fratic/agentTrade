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

import persistent.CatalogoCriteria;

public class CatalogoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idCatalogo;
	public final IntegerExpression rifAziendaId;
	public final AssociationExpression rifAzienda;
	public final CollectionExpression prodotti;
	
	public CatalogoDetachedCriteria() {
		super(agent_trade.persistentTemp.Catalogo.class, persistent.CatalogoCriteria.class);
		idCatalogo = new IntegerExpression("idCatalogo", this.getDetachedCriteria());
		rifAziendaId = new IntegerExpression("rifAzienda.idAzienda", this.getDetachedCriteria());
		rifAzienda = new AssociationExpression("rifAzienda", this.getDetachedCriteria());
		prodotti = new CollectionExpression("prodotti", this.getDetachedCriteria());
	}
	
	public CatalogoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, persistent.CatalogoCriteria.class);
		idCatalogo = new IntegerExpression("idCatalogo", this.getDetachedCriteria());
		rifAziendaId = new IntegerExpression("rifAzienda.idAzienda", this.getDetachedCriteria());
		rifAzienda = new AssociationExpression("rifAzienda", this.getDetachedCriteria());
		prodotti = new CollectionExpression("prodotti", this.getDetachedCriteria());
	}
	
	public AziendaDetachedCriteria createRifAziendaCriteria() {
		return new AziendaDetachedCriteria(createCriteria("rifAzienda"));
	}
	
	public ProdottoDetachedCriteria createProdottiCriteria() {
		return new ProdottoDetachedCriteria(createCriteria("prodotti"));
	}
	
	public Catalogo uniqueCatalogo(PersistentSession session) {
		return (Catalogo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Catalogo[] listCatalogo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Catalogo[]) list.toArray(new Catalogo[list.size()]);
	}
}

