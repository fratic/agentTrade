package agent_trade.external_system.beverage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.orm.PersistentException;

import com.google.gson.Gson;

import agent_trade.external_system.AziendaViniAdapter;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_Vini;
import agent_trade.util.Costanti;

public class BeverageAdapter extends AziendaViniAdapter {

	private static BeverageAdapter instance;
	


	public BeverageAdapter() {
		nomeAzienda=Costanti.BEVERAGE;
		try {
			int id=M_Azienda.cercaAziendaNome(Costanti.BEVERAGE).getIdAzienda();
			idAzienda=id;
			System.out.println("Azienda appena caricata BEVERAGE: "+idAzienda);

		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}

	public static BeverageAdapter getInstance() {
		if (instance == null)
			instance = new BeverageAdapter();
		return instance;
	}


	@Override
	public String getUrlRicerca() {

		return Costanti.URL_BEVERAGE;
	}

	@SuppressWarnings("null")
	@Override
	public ArrayList<M_Prodotto> creaViniDaJSON(String jsonVINO) {
		
		Gson gson = new Gson();
		
		ProdottiBeverageJSON js = gson.fromJson(jsonVINO, ProdottiBeverageJSON.class);

		ProdottoBeverage[] elencoVini=js.getProdotti();

		ArrayList<M_Prodotto> vini = new ArrayList<M_Prodotto>();
		
		for (int i = 0; i < elencoVini.length; i++) {


			M_Vini vino = new M_Vini();
			vino.setIdProdottoAzienda(elencoVini[i].getIdprodotto());
			vino.setCantina(elencoVini[i].getCantina());
			vino.setCategoria(elencoVini[i].getCategoria());
			vino.setColore(elencoVini[i].getColore());
			vino.setIdDescrizioneProdotto(elencoVini[i].getIddescrizioneprodotto());
			vino.setIndicazione_geografica(elencoVini[i].getIndicazione_geografica());
			vino.setNome(elencoVini[i].getNome());
			vino.setPrezzo(elencoVini[i].getPrezzo());
			vino.setVersione(elencoVini[i].getVersione());
			vino.setIdAzienda(idAzienda);
			try {
				vino.setSconto(determinaSconto((float) elencoVini[i].getSconto()));
			} 
			catch (PersistentException e) {
				e.printStackTrace();
			}	
			vini.add(vino);
			

		}

		return vini;
	}

	@Override
	public ArrayList<M_Prodotto> sincListinoRemoto() throws IOException {
	
		HashMap<String, String> parametri= new HashMap<>();
		parametri.put("update", "true");
		
		return creaViniDaJSON(this.ricerca(parametri));
	}

	public int determinaSconto(float sconto) throws PersistentException{
		
		int idSconto=0;
		M_ScontoPercent Sc = M_ScontoPercent.caricaSconto(sconto);
		if (Sc!=null){
			idSconto=Sc.getId();

		}
		else{
			M_ScontoPercent nuovo = new M_ScontoPercent();
			nuovo.setPercent(sconto);
			nuovo.setVersione(1);
			M_Sconto.salvaScontoRemoto(nuovo);
			idSconto=nuovo.getId();

		}
		return idSconto;
	}
	
}
