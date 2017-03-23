package agent_trade.external_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;

public class SystemDaemon {

	private static final Class<? extends M_Vini> M_Vini = null;
	/*attributi di classe*/
	private static SystemDaemon instance;

	/*attributi privati*/

	/*costruttori*/
	
	
	public SystemDaemon() {

	}
	
	
	/*metodi di classe*/
	
	public static SystemDaemon getInstance(){

		return ((instance == null) ? instance = new SystemDaemon() : instance);	
	}


	
	/*metodi privati*/
	
	
	
	/*metodi pubblici*/
	
	
	public boolean sincronizzaAgente(String username) throws PersistentException{
		
		M_Agente agente = M_Agente.caricaAgenteRemoto(username);

		if (agente!=null){

			M_Agente.salvaAgente(agente); 
			return true;
		}
		else
			return false;
	}
	
	
	
	public void sincronizzaListinoRemoto(String azienda) throws IOException, PersistentException{
		
		SistemaEsterno aziendaAdapter = SistemaEsternoFactory.getInstance().getAdapter(azienda);
	
		M_Prodotto.aggiornaProdottiRemoto(aziendaAdapter.sincronizzaListino());

	}
	
	
	public void sincronizzaListiniRemoti() throws IOException, PersistentException{
		
		ArrayList<SistemaEsterno> ext_sistem = SistemaEsternoFactory.getInstance().getSistemiEsterni();		
		for (SistemaEsterno sistemaEsterno : ext_sistem) {
		
			M_Prodotto.aggiornaProdottiRemoto(sistemaEsterno.sincronizzaListino());

		} 
		
	}

	
	
	
	
	public void sincronizzaListino() throws PersistentException{
		
		M_Prodotto[] remoti = M_Prodotto.caricaProdottiRemoto();
		
//		M_Vini[] locali= (M_Vini[]) M_Prodotto.caricaProdotti();
		
		
		for (int i = 0; i < remoti.length; i++) {
			int id=remoti[i].getIdProdotto();
			M_Prodotto locale=M_Prodotto.caricaProdotto(id);
			
			M_Vini rem=(M_Vini) remoti[i];
			

			
			
			if(locale!=null){
				System.out.println("locale id "+locale.getIdProdotto()+" versione "+locale.getVersione());

				System.out.println("remoti id "+remoti[i].getIdProdotto()+" versione "+remoti[i].getVersione());

				
				if(remoti[i].getVersione()>locale.getVersione()&& locale.getClass()==M_Vini){
					
					
					locale.setCategoria(remoti[i].getCategoria());
					locale.setIdDescrizioneProdotto(remoti[i].getIdDescrizioneProdotto());
					locale.setIdProdottoAzienda(remoti[i].getIdProdottoAzienda());
					locale.setNome(remoti[i].getNome());
					locale.setPrezzo(remoti[i].getPrezzo());
					locale.setSconto(remoti[i].getSconto());
					locale.setVersione(remoti[i].getVersione());
//					locale.setCantina(rem.getCantina());
//					locale.setColore(rem.getColore());
//					locale.setIndicazione_geografica(rem.getIndicazione_geografica());
					M_Prodotto.salvaProdotto(locale);
					
					System.out.println("prodotto con id "+locale.getIdProdotto()+" obsoleto. Aggiornamento");
				}
			}
			else{
				M_Prodotto.salvaProdotto(remoti[i]);
				System.out.println("Nuovo prodotto. Inserimento");
				System.out.println("prod remoto "+remoti[i].toString());
			}
		}
		
	}
	
	
}
