package agent_trade.external_system.lem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.orm.PersistentException;

import com.google.gson.Gson;

import agent_trade.external_system.AziendaCarniAdapter;
import agent_trade.external_system.beverage.ProdottiBeverageJSON;
import agent_trade.external_system.beverage.ProdottoBeverage;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Carni;
import agent_trade.model.M_Prodotto;
import agent_trade.util.Costanti;

public class LemAdapter extends AziendaCarniAdapter {

	private static LemAdapter instance;
	


	public LemAdapter() {
		nomeAzienda=Costanti.LEM;
		try {
			int id=M_Azienda.cercaAziendaNome(Costanti.LEM).getIdAzienda();
			idAzienda=id;

		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public static LemAdapter getInstance() {
		if (instance == null)
			instance = new LemAdapter();
		return instance;
	}


	@Override
	public String getUrlRicerca() {

		return Costanti.URL_LEM;
	}

	@SuppressWarnings("null")
	@Override
	public ArrayList<M_Prodotto> creaCarniDaJSON(String jsonCARNE) {
	
		Gson gson = new Gson();
		
		ProdottiLemJSON js = gson.fromJson(jsonCARNE, ProdottiLemJSON.class);

		ProdottoLem[] elencoCarni=js.getProdotti();
		//controllare se nullo altrimenti da errore
		ArrayList<M_Prodotto> carni = new ArrayList<M_Prodotto>();
		
		for (int i = 0; i < elencoCarni.length; i++) {

			M_Carni carne = new M_Carni();
			
			carne.setIdProdottoAzienda(elencoCarni[i].getIdprodotto());
			carne.setCategoria(elencoCarni[i].getCategoria());
			carne.setIdDescrizioneProdotto(elencoCarni[i].getIddescrizioneprodotto());
			carne.setNome(elencoCarni[i].getNome());
			carne.setPrezzo(elencoCarni[i].getPrezzo());
			carne.setSconto((float) elencoCarni[i].getSconto());	
			carne.setVersione(elencoCarni[i].getVersione());
			carne.setProvenienza(elencoCarni[i].getProvenienza());
			carne.setTaglio(elencoCarni[i].getTaglio());
			carne.setTipo(elencoCarni[i].getAnimale());
			carne.setPeso(elencoCarni[i].getPeso());
			carne.setIdAzienda(idAzienda);

			
			carni.add(carne);

		}

		return carni;
	}

	@Override
	public ArrayList<M_Prodotto> sincronizzaListino() throws IOException {
	
		HashMap<String, String> parametri= new HashMap<>();
		parametri.put("update", "true");
		
		return creaCarniDaJSON(this.ricerca(parametri));
	}



}
