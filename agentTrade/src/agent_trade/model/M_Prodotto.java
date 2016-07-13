package agent_trade.model;

import java.io.Serializable;

public abstract class  M_Prodotto implements Serializable {
	
	/*attributi di classe*/
	
	/*attributi privati*/
	
	/*attributi protected*/
	
	protected int idProdotto;
	protected float prezzo;
	protected String nome;
	protected String categoria;
	protected String Azienda; //per il momento string
	protected String idDescrizioneProdotto;
	protected int idCatalogo;
	
	/*costruttori*/
	
	public M_Prodotto() {
	}
	
	public M_Prodotto(int id, float prezzo, String nome, String categoria, String azienda, String idDes, int idCat) {
		this.idProdotto=id;
		this.prezzo=prezzo;
		this.nome=nome;
		this.categoria=categoria;
		this.Azienda=azienda;
		this.idDescrizioneProdotto=idDes;
		this.idCatalogo=idCat;
	}
	
//	public M_Prodotto(int id, float prezzo, String nome, String categoria) {
//		this.idProdotto=id;
//		this.prezzo=prezzo;
//		this.nome=nome;
//		this.categoria=categoria;
//	}
	
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/
		
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getIdDescrizioneProdotto() {
		return idDescrizioneProdotto;
	}
	
	public void setIdDescrizioneProdotto(String idDescrizioneProdotto) {
		this.idDescrizioneProdotto = idDescrizioneProdotto;
	}
	
	public int getIdProdotto() {
		return idProdotto;
	}

	public String getAzienda() {
		return Azienda;
	}
	
	public void setAzienda(String azienda) {
		Azienda = azienda;
	}

	public int getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}	

}

