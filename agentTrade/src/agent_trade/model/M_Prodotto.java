package agent_trade.model;


public abstract class  M_Prodotto {
	protected int idProdotto;
	protected float prezzo;
	protected String nome;
	protected String categoria;
	protected M_DescrizioneProdotto idDescrizioneProdotto;
	
	public M_Prodotto() {
		
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

