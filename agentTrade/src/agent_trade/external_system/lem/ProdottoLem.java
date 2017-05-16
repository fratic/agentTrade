package agent_trade.external_system.lem;


public class ProdottoLem {
	
	//questa classe deve essere fatta esattamente come sul db dell azienda
	
	private int idprodotto;
	private String nome;
	private float prezzo;
	private String categoria;
	private String iddescrizioneprodotto;
	private String provenienza;
	private String taglio;
	private String animale;
	private double sconto;
	private int versione;
	private float peso;
	
	
	public int getIdprodotto() {
		return idprodotto;
	}
	public void setIdprodotto(int idprodotto) {
		this.idprodotto = idprodotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getIddescrizioneprodotto() {
		return iddescrizioneprodotto;
	}
	public void setIddescrizioneprodotto(String iddescrizioneprodotto) {
		this.iddescrizioneprodotto = iddescrizioneprodotto;
	}
	public String getProvenienza() {
		return provenienza;
	}
	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}
	public String getTaglio() {
		return taglio;
	}
	public void setTaglio(String taglio) {
		this.taglio = taglio;
	}
	public String getAnimale() {
		return animale;
	}
	public void setAnimale(String animale) {
		this.animale = animale;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public double getSconto() {
		return sconto;
	}
	public void setSconto(double sconto) {
		this.sconto = sconto;
	}
	public int getVersione() {
		return versione;
	}
	public void setVersione(int versione) {
		this.versione = versione;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
		
	
}




