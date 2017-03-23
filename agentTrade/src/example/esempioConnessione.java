package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.orm.PersistentException;

import agent_trade.external_system.AziendaViniAdapter;
import agent_trade.external_system.SistemaEsternoFactory;
import agent_trade.external_system.beverage.BeverageAdapter;
import agent_trade.model.M_Prodotto;

public class esempioConnessione {

	
	public static void main(String[] args) throws IOException, PersistentException, CloneNotSupportedException {
	
//		ArrayList<AziendaViniAdapter> aziende_vino = SistemaEsternoFactory.getInstance().getAziendeVino();
//		
//		AziendaViniAdapter beverage=null;
//		
//		for (AziendaViniAdapter aziendaVino : aziende_vino) {
//			if (aziendaVino.getNomeAzienda().equals("Beverage"))
//				beverage=aziendaVino;
//
//		}
//		//forse serve un factory method
//		
//		BeverageAdapter a=(BeverageAdapter) beverage;
		
//		BeverageAdapter a=(BeverageAdapter) SistemaEsternoFactory.getInstance().getAdapter("Beverage");
		

		BeverageAdapter a=(BeverageAdapter) SistemaEsternoFactory.getInstance().getAdapter("Beverage");
		
		HashMap<String, String> parametri= new HashMap<>();
		parametri.put("update", "true");
		
		String response= a.ricerca(parametri);
		
//		ArrayList<M_Prodotto> pro =  a.creaViniDaJSON(response);
		
		M_Prodotto.aggiornaProdottiRemoto(a.creaViniDaJSON(response));
		
//		System.out.println(a.sendRequest(Costanti.URL_post_prod, ""));
		
//		String risposta = req.sendRequest(Costanti.URL_post_prod, "");
//		
//
//		Gson gson = new Gson();
//		
//			ProdottiJSON js = gson.fromJson(risposta, ProdottiJSON.class);
//
//			M_Vini[] prodotti=js.getProdotti();
//
//			int i=0;
//			for (M_Prodotto p : prodotti) {
//				i++;
//				System.out.println("prodottto "+i);
//				System.out.println("idprodotto: "+p.getIdProdotto()+" nome: "+p.getNome());
//			}
			
		}
		
	}
	
	
