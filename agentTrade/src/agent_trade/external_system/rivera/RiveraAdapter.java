package agent_trade.external_system.rivera;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.orm.PersistentException;

import com.google.gson.Gson;

import agent_trade.external_system.AziendaViniAdapter;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;
import agent_trade.util.Costanti;

public class RiveraAdapter extends AziendaViniAdapter {

	private static RiveraAdapter instance;
	


	public RiveraAdapter() {
		nomeAzienda=Costanti.RIVERA;
		try {
			int id=M_Azienda.cercaAziendaNome(Costanti.RIVERA).getIdAzienda();
			idAzienda=id;

		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public static RiveraAdapter getInstance() {
		if (instance == null)
			instance = new RiveraAdapter();
		return instance;
	}


	@Override
	public String getUrlRicerca() {

		return Costanti.URL_RIVERA;
	}

	@SuppressWarnings("null")
	@Override
	public ArrayList<M_Prodotto> creaViniDaJSON(String jsonVINO) {
	
		Gson gson = new Gson();
		
		ProdottiRiveraJSON js = gson.fromJson(jsonVINO, ProdottiRiveraJSON.class);

		ProdottoRivera[] elencoVini=js.getProdotti();

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
			vino.setSconto((float) elencoVini[i].getSconto());	
			vino.setVersione(elencoVini[i].getVersione());
			vino.setIdAzienda(idAzienda);

			vini.add(vino);

		}

		return vini;
	}

	@Override
	public ArrayList<M_Prodotto> sincronizzaListino() throws IOException {
	
		HashMap<String, String> parametri= new HashMap<>();
		parametri.put("update", "true");
		
		return creaViniDaJSON(this.ricerca(parametri));
	}

}
