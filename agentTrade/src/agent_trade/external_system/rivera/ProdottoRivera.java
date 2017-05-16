package agent_trade.external_system.rivera;


public class ProdottoRivera {
	
	//questa classe deve essere fatta esattamente come sul db dell azienda
	
	private int idprodotto;
	private String nome;
	private float prezzo;
	private String categoria;
	private String iddescrizioneprodotto;
	private String colore;
	private String indicazione_geografica;
	private String cantina;
	private double sconto;
	private int versione;
	
	
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
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getIndicazione_geografica() {
		return indicazione_geografica;
	}
	public void setIndicazione_geografica(String indicazione_geografica) {
		this.indicazione_geografica = indicazione_geografica;
	}
	public String getCantina() {
		return cantina;
	}
	public void setCantina(String cantina) {
		this.cantina = cantina;
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
	
	public void prova(){
		this.indicazione_geografica=this.indicazione_geografica+"mapuzza";
	}
		
	
}




