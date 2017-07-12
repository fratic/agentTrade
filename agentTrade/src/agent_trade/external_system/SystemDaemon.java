package agent_trade.external_system;

import java.awt.Cursor;
import java.io.IOException;
import java.util.ArrayList;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_System;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.persistent.AgentTradePersistentManager;
import agent_trade.ui.DialogAggiornamenti;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.listini.AlberoListini;
import agent_trade.ui.content.prodotti.AlberoProdotti;
import agent_trade.ui.content.sconti.AlberoSconti;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import example.DialogAggiornamenti_test;

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
	
		M_Prodotto.aggiornaProdottiRemoto(aziendaAdapter.sincListinoRemoto());

	}
	

	/**
	 * Metodo che permette di sincronizzare nel db remoto di agentTrade i prodotti di tutte le
	 * aziende che hanno un sistema esterno
	 **/
	public String sincronizzaListiniRemoti() throws IOException, PersistentException{
		
		String mex="";
		
		ArrayList<SistemaEsterno> ext_sistem = SistemaEsternoFactory.getInstance().getSistemiEsterni();		
		for (SistemaEsterno sistemaEsterno : ext_sistem) {
		
			mex= mex + ("\nSistema Esterno: "+sistemaEsterno.getNomeAzienda() + "\n\n");
			mex= mex + M_Prodotto.aggiornaProdottiRemoto(sistemaEsterno.sincListinoRemoto());
			
		} 
		return mex;
	}

	
	/**
	 * Metodo che permette di sincronizzare i prodotti presenti sul db remoto all'interno del db locale
	 **/
	public String sincronizzaListino() throws PersistentException{
		
		String aggiornamenti="";
		
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
					aggiornamenti=aggiornamenti+"Prodotto con ID="+locale.getIdProdotto()+" aggiornato\n";

				}
				else if(remoti[i].getVersione()==0 && locale.getVersione()!=0)
				{
					AgentTradePersistentManager.instance().disposePersistentManager();

					locale=remoti[i].clone();
					M_Prodotto.updateProdotto(locale);
					aggiornamenti=aggiornamenti+"Prodotto con ID="+locale.getIdProdotto()+" cancellato\n";
				}
			}
			
			else{
				M_Prodotto.salvaProdotto(remoti[i]);
				aggiornamenti=aggiornamenti+"Nuovo prodotto con ID="+remoti[i]+" inserito\n";

			}
		}
		
		if (aggiornamenti.equals("")){
			aggiornamenti="Nessun prodotto aggiornato\n";
		}
		
		return aggiornamenti;
		
	}
	
	
	public void sincListino() throws PersistentException, CloneNotSupportedException{
		String mex = this.sincronizzaAziende();
		mex = mex + this.sincronizzaSconti();
		mex = mex + this.sincronizzaListino();
		new DialogAggiornamenti(mex);
		Ctrl_System.getInstance().initProdotti();
		AlberoProdotti.refresh();

	}
	
	
	public void sincListinoRemoto() throws IOException, PersistentException{
		PrimaryMandanteView.getInstance().getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		String mex = sincronizzaListiniRemoti();
		PrimaryMandanteView.getInstance().resetPannelloCentraleListino();
		PrimaryMandanteView.getInstance().setSfondoListino();
		AlberoListini.refresh();
		AlberoSconti.refresh();
		new DialogAggiornamenti(mex);
		PrimaryMandanteView.getInstance().getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	}
	
	public void sincListinoRemoto(String azienda) throws IOException, PersistentException{
		PrimaryMandanteView.getInstance().getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		SistemaEsterno sistemaEsterno= SistemaEsternoFactory.getInstance().getAdapter(azienda);
		String mex= ("\nSistema Esterno: "+sistemaEsterno.getNomeAzienda()+"\n");
		mex = mex + M_Prodotto.aggiornaProdottiRemoto(sistemaEsterno.sincListinoRemoto());
		PrimaryMandanteView.getInstance().resetPannelloCentraleListino();
		PrimaryMandanteView.getInstance().setSfondoListino();
		AlberoListini.refresh();
		AlberoSconti.refresh();
		new DialogAggiornamenti(mex);
		PrimaryMandanteView.getInstance().getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	}
	
	
	public void sincClientiUpload() throws PersistentException, CloneNotSupportedException{
		String mex = this.sincronizzaClientiUpload();
		new DialogAggiornamenti(mex);
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.getInstance().setSfondoCliente();
		AlberoClienti.refresh();

	}
	
	public void sincClientiDonwload() throws PersistentException, CloneNotSupportedException{
		String mex = this.sincronizzaSconti();
		mex = mex + this.sincronizzaClientiDownload();
		new DialogAggiornamenti(mex);
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		PrimaryAgenteView.getInstance().setSfondoCliente();
		AlberoClienti.refresh();

	}
	
	/**
	 * Metodo che permette di sincronizzare le aziende presenti sul db remoto all'interno del db locale
	 **/
	public String sincronizzaAziende() throws PersistentException{
		
		String aggiornamenti="";
		
		M_Azienda [] aziende_remote = M_Azienda.caricaTutteAziendeRemoto();
		
		for (int i = 0; i < aziende_remote.length; i++) 
		{
			
			
			M_Azienda azienda_locale = M_Azienda.caricaAziendaId(aziende_remote[i].getIdAzienda());
			if(azienda_locale!=null){
				
				if(aziende_remote[i].getVersione()>azienda_locale.getVersione())
				{
					
					AgentTradePersistentManager.instance().disposePersistentManager();

					azienda_locale=aziende_remote[i].clone();
					M_Azienda.updateAzienda(azienda_locale);
					aggiornamenti=aggiornamenti+"Azienda con ID="+azienda_locale.getIdAzienda()+" aggiornata\n";

				}
				else if(aziende_remote[i].getVersione()==0){
					AgentTradePersistentManager.instance().disposePersistentManager();

					azienda_locale=aziende_remote[i].clone();
					M_Azienda.updateAzienda(azienda_locale);
					aggiornamenti=aggiornamenti+"Azienda con ID="+azienda_locale.getIdAzienda()+" cancellata\n";
				}
			}
			
			else
			{
				M_Azienda.salvaAzienda(aziende_remote[i]);
				aggiornamenti=aggiornamenti+"Nuova azienda con ID="+aziende_remote[i]+" inserita\n";

			}
				
			}
		
		if (aggiornamenti.equals("")){
			aggiornamenti="Nessuna azienda aggiornata\n";
		}
		
		return aggiornamenti;
	}
	
	/**
	 * Metodo che permette di sincronizzare gli sconti presenti sul db remoto all'interno del db locale
	 * @throws CloneNotSupportedException 
	 **/
	public String sincronizzaSconti() throws PersistentException, CloneNotSupportedException{
		
		String aggiornamenti="";
		
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
					aggiornamenti=aggiornamenti+"Sconto con ID="+sconto_locale.getId()+" aggiornato\n";
				}
			}
			
			else
			{
				//in tal caso, lo sconto in locale non esiste, quindi basta inserirlo
				M_Sconto.salvaSconto(sconti_remoti[i]);
				aggiornamenti=aggiornamenti+"Nuovo Sconto con ID="+sconti_remoti[i]+" inserito\n";
			}
		}
		
		if (aggiornamenti.equals("")){
			aggiornamenti="Nessuno sconto aggiornato\n";
		}
	
		return aggiornamenti;
	}
	
	
	/**
	 * Metodo che permette di sincronizzare i clienti di un certo agente presenti sul 
	 * suo db locale verso il db remoto
	 * @throws CloneNotSupportedException 
	 **/
	public String sincronizzaClientiUpload() throws PersistentException, CloneNotSupportedException{
		
		String aggiornamenti="";
		
		AgentTradePersistentManager.instance().disposePersistentManager();

		M_Cliente[] clienti_locali = M_Cliente.caricaTuttiClientiAgente();
		
		for (int i = 0; i < clienti_locali.length; i++) 
		{
			AgentTradeMandantePersistentManager.instance().disposePersistentManager();

			M_Cliente cliente_remoto = M_Cliente.cercaTuttiClienteRemoto(clienti_locali[i].getIdCliente());
			if(cliente_remoto!=null){
				
				if(clienti_locali[i].getVersione()>cliente_remoto.getVersione() /*&& clienti_locali[i].getVersione()!=0 */)
				{

					AgentTradeMandantePersistentManager.instance().disposePersistentManager();
					
					int id=cliente_remoto.getIdCliente();
					int sconto = cliente_remoto.getSconto();
					M_Agente a = cliente_remoto.getAgenteAssociato();
					int versionedownload = cliente_remoto.getVersione_download();
					int attivo = cliente_remoto.getAttivo();
					cliente_remoto=clienti_locali[i].clone();
					/**Questa operazione viene fatta per gli id del remoto e del locale differiscono*/
					cliente_remoto.setIdCliente(id);
					cliente_remoto.setIdclienteagente(clienti_locali[i].getIdCliente());
					cliente_remoto.setSconto(sconto);
					cliente_remoto.setAgenteAssociato(a);
					cliente_remoto.setVersione_download(versionedownload);
					if(clienti_locali[i].getAttivo()!=0){
						cliente_remoto.setAttivo(attivo);
					}
					
					M_Cliente.updateClienteRemoto(cliente_remoto);
					
					aggiornamenti=aggiornamenti+"UPLOAD del cliente con ID="+clienti_locali[i].getIdCliente()+"\n";

				}
			}
			
			else if (clienti_locali[i].getAttivo()!=0)
			{
				M_Cliente c= clienti_locali[i].clone();
				c.setIdclienteagente(clienti_locali[i].getIdCliente());
				c.setIdCliente(0);
				M_Cliente.salvaClienteRemoto(c);
				
				aggiornamenti=aggiornamenti+"UPLOAD Nuovo Cliente con ID="+clienti_locali[i].getIdCliente()+"\n";
				
			}
				
		}
		if (aggiornamenti.equals("")){
			aggiornamenti="Nessun Update cliente\n";
		}
	
		return aggiornamenti;
		
		
	}
	
	public String sincronizzaClientiDownload() throws PersistentException{
		
		String aggiornamenti="";
		
		AgentTradeMandantePersistentManager.instance().disposePersistentManager();

		M_Cliente[] clienti_remoti = M_Cliente.caricaClientiAgenteRemoto();
		
		for (int i = 0; i < clienti_remoti.length; i++) 
		{
			AgentTradePersistentManager.instance().disposePersistentManager();
			
			M_Cliente cliente_locale = M_Cliente.cercaCliente(clienti_remoti[i].getIdclienteagente());
			if(cliente_locale!=null){

				if(clienti_remoti[i].getVersione_download()>cliente_locale.getVersione_download() && cliente_locale.getAttivo()!=0)
				{
					AgentTradePersistentManager.instance().disposePersistentManager();
					
					cliente_locale.setAttivo(clienti_remoti[i].getAttivo());
					cliente_locale.setVersione_download(clienti_remoti[i].getVersione_download());
					cliente_locale.setSconto(clienti_remoti[i].getSconto());

					M_Cliente.aggiornaCliente(cliente_locale);
					aggiornamenti=aggiornamenti+"Cliente con ID="+cliente_locale.getIdCliente()+" aggiornato\n";
					
				}
			}
			else
			{

				M_Cliente c= new M_Cliente();
				c=clienti_remoti[i].clone();
				M_Cliente.salvaCliente(c);
				clienti_remoti[i].setIdclienteagente(c.getIdCliente());
				M_Cliente.updateClienteRemoto(clienti_remoti[i]);
				
				aggiornamenti=aggiornamenti+"Nuovo Cliente con ID="+clienti_remoti[i].getIdCliente()+" inserito\n";

			}
			
		}
		
		if (aggiornamenti.equals("")){
			aggiornamenti="Nessun cliente aggiornato\n";
		}
	
		return aggiornamenti;
		
	}
	
	
	public String sincronizzaClienti() throws PersistentException, CloneNotSupportedException{
		String mex="";
		mex=mex+sincronizzaClientiDownload();
		mex=mex+sincronizzaClientiUpload();
		return mex;
	}
	
	
	public void sincronizza() throws PersistentException, CloneNotSupportedException{
		String mex="";
		if (checkConnessione()){
			mex="Connessione verso il db remoto OK\n";
			
			mex= mex + sincronizzaSconti();
			mex= mex + sincronizzaAziende();
			mex= mex + sincronizzaListino();
			mex= mex + sincronizzaClienti();
			
			new DialogAggiornamenti_test(mex);
		}
		else{
			String m = "Connessione verso il db remoto assente.\n"
					+ "Non è possibile aggiornare i prodotti \n"
					+ "ma si può lavorare comunque offline";
			new DialogAggiornamenti_test(m);

		}
	}
	
	/***
	 * Funzione che carica un agente fittizio al fine di testare la connessione verso il db remoto 
	 * Va quindi inserito nel db remoto un agente disattivato con username "testconnessione"
	 **/
	public boolean checkConnessione() throws PersistentException{
		M_Agente agente = M_Agente.caricaAgenteRemotoDisattivo("testconnessione");
		boolean result = false;
		if (agente!=null){
			result= true;
		}
		return result;
	}

}
