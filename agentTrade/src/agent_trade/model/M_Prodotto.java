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
	
	/*
	 * metodi di classe
	 */
	
	
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
	
	public String toString() {
		return String.valueOf(getIdProdotto());
	}
	
}
