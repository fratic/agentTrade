package agent_trade.external_system;

import java.io.IOException;
import java.util.ArrayList;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;

public class SystemDaemon {

//	private static final Class<? extends M_Vini> M_Vini = null;
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
	
	/**
	 * Metodo che permette di caricare un certo agente dal db remoto e salvarlo nel db locale  
	 **/
	public boolean sincronizzaAgente(String username) throws PersistentException{
		
		M_Agente agente = M_Agente.caricaAgenteRemoto(username);

		if (agente!=null){

			M_Agente.salvaAgente(agente); 
			return true;
		}
		else
			return false;
	}
	
	
	/**
	 * Metodo che permette di sincronizzare nel db remoto di agentTrade i prodotti (di una certa azienda 
	 * passata come parametro) presenti nel db dell'azienda
	 **/
	public void sincronizzaListinoRemoto(String azienda) throws IOException, PersistentException{
		
		SistemaEsterno aziendaAdapter = SistemaEsternoFactory.getInstance().getAdapter(azienda);
	
		M_Prodotto.aggiornaProdottiRemoto(aziendaAdapter.sincronizzaListino());

	}
	

	/**
	 * Metodo che permette di sincronizzare nel db remoto di agentTrade i prodotti di tutte le
	 * aziende che hanno un sistema esterno
	 **/
	public void sincronizzaListiniRemoti() throws IOException, PersistentException{
		
		ArrayList<SistemaEsterno> ext_sistem = SistemaEsternoFactory.getInstance().getSistemiEsterni();		
		for (SistemaEsterno sistemaEsterno : ext_sistem) {
		
			M_Prodotto.aggiornaProdottiRemoto(sistemaEsterno.sincronizzaListino());

		} 
		
	}

	
	
	
	/**
	 * Metodo che permette di sincronizzare i prodotti presenti sul db remoto all'interno del db locale
	 **/
	public void sincronizzaListino() throws PersistentException{
		
		/**aggiustare */
		
		M_Prodotto[] remoti = M_Prodotto.caricaProdottiRemoto();
		
		
		for (int i = 0; i < remoti.length; i++) {
			
			int id=remoti[i].getIdProdotto();
			
			M_Prodotto locale=M_Prodotto.caricaProdotto(id);
			
//			M_Vini rem=(M_Vini) remoti[i];
			

			if(locale!=null){
				System.out.println("locale id "+locale.getIdProdotto()+" versione "+locale.getVersione());

				System.out.println("remoti id "+remoti[i].getIdProdotto()+" versione "+remoti[i].getVersione());

				
				if(remoti[i].getVersione()>locale.getVersione() && locale.getVersione()!=0 ){
					
					
//					locale.setCategoria(remoti[i].getCategoria());
//					locale.setIdDescrizioneProdotto(remoti[i].getIdDescrizioneProdotto());
//					locale.setIdProdottoAzienda(remoti[i].getIdProdottoAzienda());
//					locale.setNome(remoti[i].getNome());
//					locale.setPrezzo(remoti[i].getPrezzo());
//					locale.setSconto(remoti[i].getSconto());
//					locale.setVersione(remoti[i].getVersione());
//					locale.setCantina(rem.getCantina());
//					locale.setColore(rem.getColore());
//					locale.setIndicazione_geografica(rem.getIndicazione_geografica());
					
					locale.setVersione(0);
					
					M_Prodotto.salvaProdotto(locale);
					M_Prodotto.salvaProdotto(remoti[i]);
					
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
	
	
	
	/**
	 * Metodo che permette di sincronizzare le aziende presenti sul db remoto all'interno del db locale
	 **/
	public void sincronizzaAziende() throws PersistentException{
		
		
		M_Azienda[] aziende_remote = M_Azienda.caricaAziendeRemoto();
		
		
		for (int i = 0; i < aziende_remote.length; i++) {
			
			
			/**implementare la versione, quindi controllare se esiste, ecc*/

//			int id=aziende_remote[i].getIdAzienda();
			
			/**implementare la versione, quindi controllare se esiste, ecc*/

			
//			M_Azienda azienda_locale=M_Azienda.caricaAziendaId(id);
			

//			if(azienda_locale!=null){
				
				
			//	if(remoti[i].getVersione()>locale.getVersione() && locale.getVersione()!=0 ){
					
				
					
					M_Azienda.salvaAzienda(aziende_remote[i]);
					
				}
//			}
			
//			else{
//				
//			}
		}
	
	
	
}
