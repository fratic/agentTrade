package agent_trade.external_system;

import java.io.IOException;
import java.util.ArrayList;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;

public class SystemDaemon {

	/*attributi di classe*/
	private static SystemDaemon instance;

	/*attributi privati*/

	/*costruttori*/
	
	
	public SystemDaemon() {

	}
	
	/***c'è un problema nel caricamento di costanti ed in particolare di dei sistemi esterni.getInstance() 
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
		boolean ok = false;
		if (agente!=null){
			M_Agente.salvaAgente(agente); 
			ok = true;
		}
		return ok;
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
					M_Prodotto.updateProdotto(locale);
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
					M_Azienda.updateAzienda(azienda_locale);
					
				}
			}
			
			else
			{
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
					M_Sconto.updateSconto(sconto_locale);
					
				}
			}
			
			else
			{
				//in tal caso, lo sconto in locale non esiste, quindi basta inserirlo
				M_Sconto.salvaSconto(sconti_remoti[i]);

			}
				
			}
		}
	
	
	/**
	 * Metodo che permette di sincronizzare i clienti di un certo agente presenti sul 
	 * suo db locale verso il db remoto
	 * @throws CloneNotSupportedException 
	 **/
	public void sincronizzaClientiUpload() throws PersistentException, CloneNotSupportedException{
		
		M_Cliente[] clienti_locali = M_Cliente.caricaTuttiClientiAgente();
		
		for (int i = 0; i < clienti_locali.length; i++) 
		{
						
			M_Cliente cliente_remoto = M_Cliente.cercaClienteRemoto(clienti_locali[i].getIdCliente());
			if(cliente_remoto!=null){
				
				if(clienti_locali[i].getVersione()>cliente_remoto.getVersione() /*&& clienti_locali[i].getVersione()!=0 */)
				{
					System.out.println("Sono in SINC CLIENTI UPLOAD: AGGIORNAMENTO CLIENTE:"+clienti_locali[i]);

					AgentTradeMandantePersistentManager.instance().disposePersistentManager();
					
					int id=cliente_remoto.getIdCliente();
					cliente_remoto=clienti_locali[i].clone();
					/**Questa operazione viene fatta per gli id del remoto e del locale differiscono*/
					cliente_remoto.setIdCliente(id);
					cliente_remoto.setIdclienteagente(clienti_locali[i].getIdCliente());
					System.out.println("aggiornamento del cliente: "+cliente_remoto.getCognome());
					M_Cliente.updateClienteRemoto(cliente_remoto);
					System.out.println("ID "+clienti_locali[i].getIdCliente());
				}
			}
			
			else if (clienti_locali[i].getAttivo()!=0)
			{
				System.out.println("Inserimento nuovo cliente: "+clienti_locali[i].getIdCliente()+clienti_locali[i].getCognome());
				M_Cliente c= clienti_locali[i].clone();
				c.setIdclienteagente(clienti_locali[i].getIdCliente());
				c.setIdCliente(0);
				M_Cliente.salvaClienteRemoto(c);
				System.out.println("ID nuovo insert "+clienti_locali[i].getIdCliente());
				
			}
				
		}
	}
	
	public void sincronizzaClientiDownload() throws PersistentException{
		
		M_Cliente[] clienti_remoti = M_Cliente.caricaClientiAgenteRemoto();
		
		for (int i = 0; i < clienti_remoti.length; i++) 
		{
			
			M_Cliente cliente_locale = M_Cliente.cercaCliente(clienti_remoti[i].getIdclienteagente());
			if(cliente_locale!=null){
				
				if(clienti_remoti[i].getVersione_download()>cliente_locale.getVersione_download())
				{
					System.out.println("Sono in SINC CLIENTI DOWNLOAD: AGGIORNAMENTO CLIENTE:"+cliente_locale);
					AgentTradePersistentManager.instance().disposePersistentManager();
					
					cliente_locale.setAttivo(clienti_remoti[i].getAttivo());
					//cliente_locale.setAgenteAssociato(clienti_remoti[i].getAgenteAssociato());
					cliente_locale.setSconto(clienti_remoti[i].getSconto());

					M_Cliente.aggiornaCliente(cliente_locale);
					
				}
			}
			else
			{

				//fatto per recuperare l'id nel db locale per poi aggiornarlo nel remoto
				M_Cliente c= new M_Cliente();
				c=clienti_remoti[i].clone();
				M_Cliente.salvaCliente(c);
				System.out.println("Sono in SINC CLIENTI DOWNLOAD: NUOVO CLIENTE:"+c);

//				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    l'IDagentecliente è: "+ c.getIdCliente());
//				M_Cliente.aggiornaCliente(c);
				clienti_remoti[i].setIdclienteagente(c.getIdCliente());
				//M_Cliente.salvaCliente(clienti_remoti[i]);
//				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    l'IDagentecliente è: "+ clienti_remoti[i].getIdclienteagente());
				M_Cliente.updateClienteRemoto(clienti_remoti[i]);
				System.out.println("Sono in SINC CLIENTI DOWNLOAD: AGGIORNAMENTO REMOTO CLIENTE:"+clienti_remoti[i]);

			}
			
		}
	}
	
	
	public void sincronizzaClienti() throws PersistentException, CloneNotSupportedException{
		sincronizzaClientiDownload();
		sincronizzaClientiUpload();
	}
	
	
	public void sincronizza() throws PersistentException, CloneNotSupportedException{
		
		sincronizzaSconti();
		sincronizzaAziende();
		sincronizzaListino();
		sincronizzaClienti();

	}
	
}
