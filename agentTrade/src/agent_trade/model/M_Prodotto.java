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

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.ProdottoCriteria;
import agent_trade.persistent.Rem_ProdottoCriteria;

public abstract class M_Prodotto {

	
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
			return criteriaProdotto.listProdotto();

		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static M_Prodotto[] caricaProdottiRemoto() throws PersistentException{
		
		try{
			
			Rem_ProdottoCriteria criteriaProdotto= new Rem_ProdottoCriteria();
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
			criteriaProdotto.setMaxResults(10000);
			return criteriaProdotto.listProdotto();

		}
		finally {
			AgentTradeMandantePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	public static M_Prodotto caricaProdottoRemoto(int idProdotto) throws PersistentException{
		
		Rem_ProdottoCriteria criteria= new Rem_ProdottoCriteria();
		criteria.IdProdotto.eq(idProdotto);
		return criteria.uniqueProdotto();
	}
	
	
	public static void salvaProdotto(M_Prodotto p)throws PersistentException{
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{				
//			AgentTradePersistentManager.instance().getSession().saveOrUpdate(p);
			AgentTradePersistentManager.instance().getSession().save(p);

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			System.out.println("Eccezione: "+e);
			t.rollback();
		}
		finally {
			System.out.println("commit a buon fine per id : "+p.getIdProdotto()+" ? "+t.wasCommitted());
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
			System.out.println("commit a buon fine per id : "+p.getIdProdotto()+" ? "+t.wasCommitted());
		}
	}
	
	
	/**funziona per il db locale, ma questa op va fatta nel remoto**/
//	public static void aggiornaProdotti(ArrayList<M_Prodotto> prodotti)throws PersistentException{
//
//		
//		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
//		
//		for (M_Prodotto remoto : prodotti) {
//			
//			ProdottoCriteria criteria= new ProdottoCriteria();
//			criteria.idProdottoAzienda.eq(remoto.getIdProdottoAzienda());
//			M_Vini locale=(M_Vini) criteria.uniqueProdotto();
//			M_Vini rem=(M_Vini)remoto;
//			
//			if(locale!=null){
//		
//				if(remoto.getVersione()>locale.getVersione()){
//					/**PROCATA, TROVARE SOLUZIONE**/
//					/**
//					 *una probabile soluzione è che quando si ha un aggiornamento, 
//					 *questo viene visto come un nuovo prodotto. Quindi potremmo
//					 *continuare a tenere il vecchio impostando versione a 0.
//					 *cosi facendo, avremmo uno storico coerente. 
//					 *Ovviamente quando si mostrano i prodotti, si prenderanno 
//					 *solo quelli con versione maggiore di 0 mentre non cambierà nulla 
//					 *per il caricamento dei prodotti nei preventivi   
//					 *
//					 */
//					
//					locale.setCategoria(remoto.getCategoria());
//					locale.setIdDescrizioneProdotto(remoto.getIdDescrizioneProdotto());
//					locale.setIdProdottoAzienda(remoto.getIdProdottoAzienda());
//					locale.setNome(remoto.getNome());
//					locale.setPrezzo(remoto.getPrezzo());
//					locale.setSconto(remoto.getSconto());
//					locale.setVersione(remoto.getVersione());
//					locale.setCantina(rem.getCantina());
//					locale.setColore(rem.getColore());
//					locale.setIndicazione_geografica(rem.getIndicazione_geografica());
//
//					
//					/***/
//					System.out.println("prodotto locale con id: "+locale.getIdProdottoAzienda()+" obsoleto. AGGIORNAMENTO");
//						AgentTradePersistentManager.instance().getSession().saveOrUpdate(locale);
//					
//					
//										
//					/**ALTERNATIVA**/
////					System.out.println("prodotto locale con id: "+locale.getIdProdottoAzienda()+" obsoleto. AGGIORNAMENTO");
////				
////					locale.setVersione(0);
////					AgentTradePersistentManager.instance().getSession().update(locale);
////					AgentTradePersistentManager.instance().getSession().save(remoto);
//
//					
//					/***/
//					
//				}
//			}
//			
//			else{
//				
//				System.out.println("prodotto remoto nuovo. id: "+remoto.getIdProdottoAzienda()+" new insert");
//				
//				AgentTradePersistentManager.instance().getSession().save(remoto);
//
//			}
//		}
//		t.commit();
//
//	}
	
	
	
	public static void aggiornaProdottiRemoto(ArrayList<M_Prodotto> prodotti)throws PersistentException{

		
		PersistentTransaction t = AgentTradeMandantePersistentManager.instance().getSession().beginTransaction();
		PersistentSession sessione = AgentTradeMandantePersistentManager.instance().getSession();
		
		for (M_Prodotto remoto : prodotti) {
			
			Rem_ProdottoCriteria criteria= new Rem_ProdottoCriteria();
			criteria.idProdottoAzienda.eq(remoto.getIdProdottoAzienda());
			M_Vini locale=(M_Vini) criteria.uniqueProdotto();
			M_Vini rem=(M_Vini)remoto;
			
			if(locale!=null){
		
				if(remoto.getVersione()>locale.getVersione()){
					/**PORCATA, TROVARE SOLUZIONE**/
					/**
					 *una probabile soluzione è che quando si ha un aggiornamento, 
					 *questo viene visto come un nuovo prodotto. Quindi potremmo
					 *continuare a tenere il vecchio impostando versione a 0.
					 *cosi facendo, avremmo uno storico coerente. 
					 *Ovviamente quando si mostrano i prodotti, si prenderanno 
					 *solo quelli con versione maggiore di 0 mentre non cambierà nulla 
					 *per il caricamento dei prodotti nei preventivi   
					 *
					 *
					 *ALTRIMENTI
					 *implementare qui e in ogni classe derivata il metodo
					 *clone() e quindi applicare il polimorfismo
					 */
					
					locale.setCategoria(remoto.getCategoria());
					locale.setIdDescrizioneProdotto(remoto.getIdDescrizioneProdotto());
					locale.setIdProdottoAzienda(remoto.getIdProdottoAzienda());
					locale.setNome(remoto.getNome());
					locale.setPrezzo(remoto.getPrezzo());
					locale.setSconto(remoto.getSconto());
					locale.setVersione(remoto.getVersione());
					locale.setCantina(rem.getCantina());
					locale.setColore(rem.getColore());
					locale.setIndicazione_geografica(rem.getIndicazione_geografica());

					
					/***/
					System.out.println("prodotto locale con id: "+locale.getIdProdottoAzienda()+" obsoleto. AGGIORNAMENTO");
					sessione.saveOrUpdate(locale);
					
					
										
					/**ALTERNATIVA**/
//					System.out.println("prodotto locale con id: "+locale.getIdProdottoAzienda()+" obsoleto. AGGIORNAMENTO");
//				
//					locale.setVersione(0);
//					AgentTradeMandantePersistentManager.instance().getSession().update(locale);
//					AgentTradeMandantePersistentManager.instance().getSession().save(remoto);

					
					/***/
					
				}
			}
			
			else{
				
				System.out.println("prodotto remoto nuovo. id: "+remoto.getIdProdottoAzienda()+" new insert");
				
				sessione.save(remoto);

			}
		}
		t.commit();

	}

	
	
	/*
	 * metodi privati
	 */
	

	private void setIdProdotto(int value) {
		this.IdProdotto = value;
	}
	
	
	/*
	 * metodi pubblici
	 */
	

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
	
}
