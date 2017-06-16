package agent_trade.external_system;

import java.io.IOException;
import java.util.ArrayList;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.persistent.AgentTradePersistentManager;

public class SystemDaemon {

	/*attributi di classe*/
	private static SystemDaemon instance;

	/*attributi privati*/

	/*costruttori*/
	
	
	public SystemDaemon() {

	}
	
	/***c'� un problema nel caricamento di costanti ed in particolare di dei sistemi esterni.getInstance() 
	 * quando non esiste nessuna azienda
	 * ***/
	
	/*metodi di classe*/
	
	public static SystemDaemon getInstance(){

		return ((instance == null) ? instance = new SystemDaemon() : instance);	
	}


	
	/*metodi privati*/
	
	
	
	/*metodi pubblici*/
	
	
	
	/**Probabilmente bisogna implementare qualcosa che scarica tutto.. es, se scarico un agente, devo portarmi dietro i suoi 
	 * clienti e quindi i suoi preventivi, quindi prev_item e quindi prodotti, sconti**/
	
	
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
	 * passata come parametro) presenti nel db dell'azienda (SISTEMA ESTERNO)
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
		
		
		M_Prodotto[] remoti = M_Prodotto.caricaProdottiRemoto();
		
		for (int i = 0; i < remoti.length; i++) {
			
			int id=remoti[i].getIdProdotto();
			
			M_Prodotto locale=M_Prodotto.caricaProdotto(id);
			
			if(locale!=null){


				if(remoti[i].getVersione()>locale.getVersione() && locale.getVersione()!=0 )
				{
					AgentTradePersistentManager.instance().disposePersistentManager();

					locale=remoti[i].clone();
					M_Prodotto.salvaProdotto(locale);
				}
			}
			
			else{
				M_Prodotto.salvaProdotto(remoti[i]);
			}
		}
		
	}
	
	
	
	/**
	 * Metodo che permette di sincronizzare le aziende presenti sul db remoto all'interno del db locale
	 **/
	public void sincronizzaAziende() throws PersistentException{
		
		
		M_Azienda [] aziende_remote = M_Azienda.caricaAziendeRemoto();
		
		for (int i = 0; i < aziende_remote.length; i++) 
		{
			
			
			M_Azienda azienda_locale = M_Azienda.caricaAziendaId(aziende_remote[i].getIdAzienda());
			if(azienda_locale!=null){
				
				if(aziende_remote[i].getVersione()>azienda_locale.getVersione() && azienda_locale.getVersione()!=0 )
				{
					
					AgentTradePersistentManager.instance().disposePersistentManager();

					azienda_locale=aziende_remote[i].clone();
					M_Azienda.salvaAzienda(azienda_locale);
					
				}
			}
			
			else
			{
				//in tal caso, lo sconto in locale non esiste, quindi basta inserirlo
				M_Azienda.salvaAzienda(aziende_remote[i]);

			}
				
			}
		}
	
	/**
	 * Metodo che permette di sincronizzare gli sconti presenti sul db remoto all'interno del db locale
	 * @throws CloneNotSupportedException 
	 **/
	public void sincronizzaSconti() throws PersistentException, CloneNotSupportedException{
		
		
		M_Sconto[] sconti_remoti = M_Sconto.caricaScontiRemoto();
		
		for (int i = 0; i < sconti_remoti.length; i++) 
		{
			
			
			M_Sconto sconto_locale = M_Sconto.caricaSconto(sconti_remoti[i].getId());
			if(sconto_locale!=null){
				
				if(sconti_remoti[i].getVersione()>sconto_locale.getVersione() && sconto_locale.getVersione()!=0 )
				{
					
					AgentTradePersistentManager.instance().disposePersistentManager();

					sconto_locale=sconti_remoti[i].clone();
					M_Sconto.salvaSconto(sconto_locale);
					
				}
			}
			
			else
			{
				//in tal caso, lo sconto in locale non esiste, quindi basta inserirlo
				M_Sconto.salvaSconto(sconti_remoti[i]);

			}
				
			}
		}
	
	
}
