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

import org.orm.PersistentException;

import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.persistent.ProdottoCriteria;
import agent_trade.ui.content.prodotti.ProdottiView;

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
	protected String nome;
	protected float prezzo;
	protected String categoria;
	protected String idDescrizioneProdotto;
	protected float sconto;

	
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

	public String toString() {
		return String.valueOf(getIdProdotto());
	}
	
}
