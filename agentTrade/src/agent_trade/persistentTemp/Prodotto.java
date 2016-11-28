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

public abstract class Prodotto {
	public Prodotto() {
	}
	
	protected int IdProdotto;
	
	protected String nome;
	
	protected float prezzo;
	
	protected String categoria;
	
	protected String idDescrizioneProdotto;
	
	private void setIdProdotto(int value) {
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
	
	public String toString() {
		return String.valueOf(getIdProdotto());
	}
	
}
