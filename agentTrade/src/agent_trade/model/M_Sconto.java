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
package agent_trade.model;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.Rem_ScontoCriteria;
import agent_trade.persistent.ScontoCriteria;
import agent_trade.ui.content.sconti.AlberoSconti;

public class M_Sconto implements Cloneable{
	public M_Sconto() {
	}
	
	private int id;
	private int versione;
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setVersione(int versione) {
		this.versione = versione;
	}
	
	public int getVersione() {
		return versione;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
	public M_Sconto clone() {
		try {
			return (M_Sconto) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static M_Sconto caricaSconto(int idSconto) throws PersistentException{
		ScontoCriteria criteria= new ScontoCriteria();
		criteria.id.eq(idSconto);
		criteria.versione.ne(0);
		return criteria.uniqueSconto();

	}
	
	
	public static void salvaSconto(M_Sconto s)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().save(s);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione : "+e);
			t.rollback();
		}
		finally {
			
//			System.out.println("commit a buon fine per id : "+s.getId()+" ? "+t.wasCommitted());
		}
	}
	
	public static void updateSconto(M_Sconto s)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().update(s);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione : "+e);
			t.rollback();
		}
		finally {
			
//			System.out.println("commit a buon fine per id : "+s.getId()+" ? "+t.wasCommitted());
		}
	}
	
	public static void salvaScontoRemoto(M_Sconto s)throws PersistentException{
		
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().save(s);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
//			System.out.println("commit a buon fine per id : "+s.getId()+" ? "+t.wasCommitted());
		}
	}

	
	public static M_Sconto caricaScontoRemoto(int idSconto) throws PersistentException{
		try
		{		

			Rem_ScontoCriteria criteriaSconto = new Rem_ScontoCriteria();
			criteriaSconto.id.eq(idSconto);
			criteriaSconto.versione.ne(0);

			return criteriaSconto.uniqueSconto();
		}
		finally {	
		}
	}
	
	
	public static M_Sconto[] caricaScontiRemoto()throws PersistentException{

		Rem_ScontoCriteria criteriaSconto;
		try {
			criteriaSconto = new Rem_ScontoCriteria();
			criteriaSconto.addOrder(Property.forName("id").asc());
			criteriaSconto.versione.ne(0);
			return criteriaSconto.listSconto();
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int getMaxIdRemoto() throws PersistentException{
		try{
			Rem_ScontoCriteria criteriaSconto = new Rem_ScontoCriteria();
			criteriaSconto.setProjection(Projections.max("id"));
			int id =(int)criteriaSconto.uniqueResult();
			return id;
		}
		finally {
		}
	}
	
	public static String[] getStringaSconto(M_Sconto sLoad) {
		String figlio=null;
		String parent=null;
		String ris[]= new String[2];

		if (sLoad instanceof M_ScontoCliente)
		{
			figlio=sLoad.getId()+" - "+((M_ScontoCliente)sLoad).getPercent()*100+" %";
			parent="Sconto Cliente";
		}
		else if (sLoad instanceof M_ScontoPercent)
		{
			figlio=sLoad.getId()+" - "+((M_ScontoPercent)sLoad).getPercent()*100+" %";
			parent="Sconto Percentuale";


		}
		else if (sLoad instanceof M_ScontoQuantita)
		{
			figlio=sLoad.getId()+" - "+((M_ScontoQuantita)sLoad).getScontoFisso()+" € - q.ta > "+((M_ScontoQuantita)sLoad).getQuantita();
			parent="Sconto Quantità";

		}
		ris[0]=figlio;
		ris[1]=parent;
		return ris;
	}
	
	public static void cancellaScontoRemoto(M_Sconto s) throws PersistentException {

		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {			
			s.setVersione(0);
			AgentTradeMandantePersistentManager.instance().getSession().delete(s);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	
	public static void aggiornaScontoRemoto(M_Sconto sconto) throws PersistentException{
		
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {
			
			if(sconto instanceof M_ScontoCliente ){
				M_ScontoCliente sc = (M_ScontoCliente) sconto;
			}
			else if(sconto instanceof M_ScontoPercent ){
				M_ScontoPercent sc = (M_ScontoPercent) sconto;
			}
			else if(sconto instanceof M_ScontoQuantita ){
				M_ScontoQuantita sc = (M_ScontoQuantita) sconto;
			}
			AgentTradeMandantePersistentManager.instance().getSession().update(sconto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			System.out.println(e);
		}
		finally {
//			System.out.println("commit a buon fine per id : "+sconto.getId()+" ? "+t.wasCommitted());
		}
	}
	
}
