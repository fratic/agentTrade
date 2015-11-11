package agent_trade.model;

import java.io.Serializable;


public abstract class  M_Prodotto implements Serializable {
	protected int idProdotto;
	protected float prezzo;
	protected String nome;
	protected String categoria;
	protected String Azienda; //per il momemtno string
	protected M_DescrizioneProdotto idDescrizioneProdotto;
	
	public M_Prodotto() {
		
	}
	
	public M_Prodotto(int id, float prezzo, String nome, String categoria,M_DescrizioneProdotto idDes) {
		this.idProdotto=id;
		this.prezzo=prezzo;
		this.nome=nome;
		this.categoria=categoria;
		this.idDescrizioneProdotto=idDes;
	}
	
	public M_Prodotto(int id, float prezzo, String nome, String categoria) {
		this.idProdotto=id;
		this.prezzo=prezzo;
		this.nome=nome;
		this.categoria=categoria;
	}
	
	
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
	public M_DescrizioneProdotto getIdDescrizioneProdotto() {
		return idDescrizioneProdotto;
	}
	public void setIdDescrizioneProdotto(M_DescrizioneProdotto idDescrizioneProdotto) {
		this.idDescrizioneProdotto = idDescrizioneProdotto;
	}
	public int getIdProdotto() {
		return idProdotto;
	}
}

