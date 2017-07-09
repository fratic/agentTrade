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

import java.util.ArrayList;

import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import agent_trade.controller.Ctrl_System;
import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.ProdottoCriteria;
import agent_trade.persistent.Rem_ProdottoCriteria;

public abstract class M_Prodotto implements Cloneable{

	
	/*
	 * attributi di classe
	 */
	
	
	/*
	 * attributi privati
	 */

	
	/*
	 * attributi protected
	 */
	
	protected int IdProdotto;
	protected int idProdottoAzienda;
	protected String nome;
	protected float prezzo;
	protected String categoria;
	protected String idDescrizioneProdotto;
	protected float sconto;
	protected int versione;
	protected int idAzienda;
	

	
	/*
	 * costruttori
	 */
	
	public M_Prodotto() {
	}
	
	public M_Prodotto(int id, float prezzo, String nome, String categoria,String idDes) {
		this.IdProdotto=id;
		this.prezzo=prezzo;
		this.nome=nome;
		this.categoria=categoria;
		this.idDescrizioneProdotto=idDes;
	}
	
	public M_Prodotto(int id, float prezzo, String nome, String categoria) {
		this.IdProdotto=id;
		this.prezzo=prezzo;
		this.nome=nome;
		this.categoria=categoria;
	}
	
	public M_Prodotto(int id, float prezzo, String nome, String categoria,String idDes, float sconto) {
		this.IdProdotto=id;
		this.prezzo=prezzo;
		this.nome=nome;
		this.categoria=categoria;
		this.idDescrizioneProdotto=idDes;
		this.sconto=sconto;
	}
	
	/*
	 * metodi di classe
	 */

	public static M_Prodotto caricaProdotto(int idProdotto) throws PersistentException{
		
		ProdottoCriteria criteria= new ProdottoCriteria();
		criteria.IdProdotto.eq(idProdotto);
		return criteria.uniqueProdotto();
	}

	
	public static M_Prodotto[] caricaProdotti() throws PersistentException{
		
		try{
			
			ProdottoCriteria criteriaProdotto= new ProdottoCriteria();
			criteriaProdotto.setMaxResults(1000);
			criteriaProdotto.versione.ne(0);
			criteriaProdotto.addOrder(Property.forName("id").asc());
			return criteriaProdotto.listProdotto();

		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static M_Prodotto[] caricaProdottiRemoto() throws PersistentException{
		
		try{
			
			Rem_ProdottoCriteria criteriaProdotto= new Rem_ProdottoCriteria();
			criteriaProdotto.versione.ne(0);
			criteriaProdotto.setMaxResults(10000);
			return criteriaProdotto.listProdotto();

		}
		finally {
			AgentTradeMandantePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static M_Prodotto[] caricaProdottiRemotoAzienda(int idAzienda) throws PersistentException{
		
		try{
			
			Rem_ProdottoCriteria criteriaProdotto= new Rem_ProdottoCriteria();
			criteriaProdotto.idAzienda.eq(idAzienda);
			criteriaProdotto.versione.ne(0);
			criteriaProdotto.setMaxResults(10000);
			return criteriaProdotto.listProdotto();

		}
		finally {
			//AgentTradeMandantePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static M_Prodotto caricaProdottoRemoto(int idProdotto) throws PersistentException{
		
		Rem_ProdottoCriteria criteria= new Rem_ProdottoCriteria();
		criteria.versione.ne(0);
		criteria.IdProdotto.eq(idProdotto);
		return criteria.uniqueProdotto();
	}
	
	
	public static void salvaProdotto(M_Prodotto p)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().save(p);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		finally {
//			System.out.println("commit a buon fine per id : "+p.getIdProdotto()+" ? "+t.wasCommitted());
		}
	}
	
	public static void updateProdotto(M_Prodotto p)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradePersistentManager.instance().getSession().update(p);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		finally {
//			System.out.println("commit a buon fine per id : "+p.getIdProdotto()+" ? "+t.wasCommitted());
		}
	}
	
	public static void salvaProdottoRemoto(M_Prodotto p)throws PersistentException{
		
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
			AgentTradeMandantePersistentManager.instance().getSession().save(p);
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		finally {
//			System.out.println("commit a buon fine per id : "+p.getIdProdotto()+" ? "+t.wasCommitted());
		}
	}
	
	
	
	public static String aggiornaProdottiRemoto(ArrayList<M_Prodotto> prodotti)throws PersistentException{

		String mex="";
		
		for (M_Prodotto remoto : prodotti) {
			
			Rem_ProdottoCriteria criteria= new Rem_ProdottoCriteria();
			criteria.idProdottoAzienda.eq(remoto.getIdProdottoAzienda());
			M_Prodotto locale=criteria.uniqueProdotto();
			
			AgentTradeMandantePersistentManager.instance().disposePersistentManager();	

			if(locale!=null){
		
				if(remoto.getVersione()>locale.getVersione() || (remoto.getVersione()==0 && locale.getVersione()!=0) ){
					
			
					int idlocale=locale.getIdProdotto();
					locale=remoto.clone();
					locale.setIdProdotto(idlocale);
					
					aggiornaProdottoRemoto(locale);
					mex= mex+"Prodotto locale con ID: "+locale.getIdProdotto()+" obsoleto. AGGIORNAMENTO\n";
//					System.out.println("prodotto locale con id: "+locale.getIdProdotto()+" obsoleto. AGGIORNAMENTO");
//					AgentTradePersistentManager.instance().getSession().update(locale);
//					t.commit();
				}
			}
			else{
				mex= mex+"Nuovo prodotto: "+ remoto.getNome()+". INSERIMENTO\n";
				salvaProdottoRemoto(remoto);
//				sessione.save(remoto);
//				t.commit();

			}
		}
		
		if (mex.equals("")){
			mex="Nessun prodotto da aggiornare\n";
		}
	
//		t.commit();
		return mex;

	}
	
	
	public static void aggiornaProdottoRemoto(M_Prodotto prod) throws PersistentException{
		
		AgentTradeMandantePersistentManager.instance().disposePersistentManager();

		PersistentTransaction t =  AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		try {
			 AgentTradeMandantePersistentManager.instance().getSession().update(prod);
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		finally {
//			System.out.println("SONO QUI: aggiornamento prodotto a buon fine? "+t.wasCommitted());
		}
	}

	
	
	/*
	 * metodi privati
	 */
	
	
	/*
	 * metodi pubblici
	 */
	
	public void setIdProdotto(int value) {
		this.IdProdotto = value;
	}

	public int getIdProdotto() {
		return IdProdotto;
	}
	
	public int getORMID() {
		return getIdProdotto();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPrezzo(float value) {
		this.prezzo = value;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setCategoria(String value) {
		this.categoria = value;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setIdDescrizioneProdotto(String value) {
		this.idDescrizioneProdotto = value;
	}
	
	public String getIdDescrizioneProdotto() {
		return idDescrizioneProdotto;
	}
	
	public float getSconto() {
		return sconto;
	}

	public void setSconto(float sconto) {
		this.sconto = sconto;
	}

	
	public int getVersione() {
		return versione;
	}

	public void setVersione(int versione) {
		this.versione = versione;
	}
	

	public int getIdProdottoAzienda() {
		return idProdottoAzienda;
	}

	public void setIdProdottoAzienda(int dProdottoAzienda) {
		this.idProdottoAzienda = dProdottoAzienda;
	}
	
	public int getIdAzienda(){
		return idAzienda;
	}
	
	public void setIdAzienda(int id){
		this.idAzienda = id;
	}

	public String toString() {
		return String.valueOf(getIdProdotto());
	}
	
	public M_Prodotto clone() {
		try {
			return (M_Prodotto) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}
