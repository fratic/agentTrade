
package agent_trade.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.orm.PersistentException;

import agent_trade.Main;
import agent_trade.external_system.SystemDaemon;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Mandante;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.ui.Impostazioni;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.aziende.AlberoAziende;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.AlberoClienti_Mandante;
import agent_trade.ui.content.listini.AlberoListini;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.prodotti.AlberoProdotti;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.ui.content.sconti.AlberoSconti;
import agent_trade.ui.login.LoginViewFactoryMethod;
import agent_trade.ui.primaryView.PrimaryViewFactory;
import agent_trade.util.Costanti;


public class Ctrl_System {

	/*
	 * Attributi di classe
	 */
	
	private static Ctrl_System instance;
	
	public static Calendar calendario = Calendar.getInstance();
	
	Impostazioni frame;
	
	/*la responsabilità di tenere l'istanza dell'agente loggato è stata assegnata ad crtl_system, in quanto è il creatore*/
	private static M_Agente instanceAgenteLog;

	/*
	 * Attributi privati
	 */

	
	/*
	 * costruttori
	 */
	
	
	/*
	 * metodi di classe
	 */
	
	public static Ctrl_System getInstance(){

		return ((instance == null) ? instance = new Ctrl_System() : instance);	
	}
	
	
	/**
	 * Restituisce l'istanza dell'agente che si è loggato
	 * @throws PersistentException
	 */
	public static M_Agente getAgenteLog(){

		return ((instance == null) ? null : instanceAgenteLog);	
	}
	
	
	/*
	 * metodi privati
	 */

	private void inizializzaSistemaAgente() throws PersistentException, CloneNotSupportedException, IOException
	{
		
		/*******AGGIORNAMENTO delle aziende, degli sconti, 
		 * dei prodotti e dei listini dal db 
		 * remoto e upload cliente
		 * ****/
		SystemDaemon.getInstance().sincronizza();
		
		initAlberoClienti();
		
		initAlberoPreventivi();	
		
		initProdotti();

		initAlberoProdotti();
		
	}
	
	private void inizializzaSistemaMandante() throws PersistentException, CloneNotSupportedException, IOException
	{

		initAlberoAgenti();
	
		initAlberoAziende();
		
		initAlberoListini();

		initAlberoSconti();
		
		initAlberoClienti_Mandante();

		
	}
	
	
	/*
	 * metodi pubblici
	 */
	

	public void loginAgente(String username, String psw) throws PersistentException, IOException, CloneNotSupportedException  
	{					

			M_Agente agLoad =null;
			try {
				agLoad = M_Agente.caricaAgente(username);
			} 
			catch (PersistentException e) {
				e.printStackTrace();
			}		

			
			//bisogna far si che lo username sia univoco all'interno del db
			if (agLoad!=null){
	
				if (agLoad.getUsername().equals(username) & agLoad.getPassword().equals(psw))
				{
					PrimaryViewFactory.getInstance().setVisible(true);
					LoginViewFactoryMethod.getInstance().setVisible(false);
					instanceAgenteLog=agLoad;
					
					inizializzaSistemaAgente();
					
				}
					else{
						LoginViewFactoryMethod.getInstance().setMex(Costanti.MESSAGGIO_NO_LOGIN);
						LoginViewFactoryMethod.getInstance().enableAccedi();
				}
			}
			else{
				LoginViewFactoryMethod.getInstance().setMex("Sincronizzazione database centrale");

				if (SystemDaemon.getInstance().sincronizzaAgente(username))
					loginAgente(username,psw);
				else{
					LoginViewFactoryMethod.getInstance().setMex(Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
					LoginViewFactoryMethod.getInstance().enableAccedi();
				}

			}	
	}
	
	
	public void loginMandante(String username, String psw) throws PersistentException, CloneNotSupportedException, IOException  {
	
		//prima di tutto va verificata la connesione. se ok si procede, altrimenti mex errore
		
		
		M_Mandante mandante = M_Mandante.caricaMandante(username);
			
		
		//bisogna far si che lo username sia univoco all'interno del db
		if (mandante!=null){

			if (mandante.getUsername().equals(username) & mandante.getPassword().equals(psw))
			{
				PrimaryViewFactory.getInstance().setVisible(true);
				LoginViewFactoryMethod.getInstance().setVisible(false);
				
				inizializzaSistemaMandante();
				
			}
				else{
					LoginViewFactoryMethod.getInstance().setMex(Costanti.MESSAGGIO_NO_LOGIN);
					LoginViewFactoryMethod.getInstance().enableAccedi();
			}
		}
		else{
				LoginViewFactoryMethod.getInstance().setMex(Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
				LoginViewFactoryMethod.getInstance().enableAccedi();
			}

		}	

	
	
	public void initAlberoClienti() throws PersistentException{
					
		M_Cliente [] listClienti = M_Cliente.caricaClientiAgente();

		//bisognerebbe inserire un controllo se listclienti è null
		//e se ognuno dei dati usati è null
		for (M_Cliente cLoad : listClienti) {
			AlberoClienti.inserisciNodo(cLoad.getIdCliente()+ " - " + cLoad.getCognome()+ " - " +cLoad.getNome());
		}
	
	}
	
	public void initAlberoAgenti() throws PersistentException{
		
		M_Agente [] listAgenti = M_Agente.caricaAgentiRemoto();

		for (M_Agente aLoad : listAgenti) {

			AlberoAgenti.inserisciNodo(aLoad.getIdAgente()+ " - " + aLoad.getCognome()+ " - " +aLoad.getNome());
		}
	
	}
	
	
	public void initAlberoAziende() throws PersistentException{
		
		M_Azienda[] listAziende = M_Azienda.caricaAziendeRemoto();

		
		for (M_Azienda aLoad : listAziende) {

			AlberoAziende.inserisciNodo(aLoad.getIdAzienda()+ " - " + aLoad.getRagioneSociale());
		}
	
	}
	
	
	public void initAlberoListini() throws PersistentException{
		
		M_Azienda[] listAziende = M_Azienda.caricaAziendeRemoto();

		
		for (M_Azienda aLoad : listAziende) {

			AlberoListini.inserisciNodo(aLoad.getIdAzienda()+ " - " + aLoad.getRagioneSociale());
		}
	
	}
	
	
	public void initAlberoSconti() throws PersistentException{
		
		M_Sconto[] listSconti = M_Sconto.caricaScontiRemoto();
		
		for (M_Sconto sLoad : listSconti) {
				AlberoSconti.inserisciNodo(M_Sconto.getStringaSconto(sLoad)[0], M_Sconto.getStringaSconto(sLoad)[1]);

		}
	
	}


	public void initAlberoClienti_Mandante() throws PersistentException{
		
		try {
			Set<M_Agente> agenti = new HashSet<M_Agente>();
			M_Cliente[] listclienti = M_Cliente.caricaClientiRemoto();
			for (M_Cliente cLoad : listclienti) {
				agenti.add(cLoad.getAgenteAssociato());
			}
			
			for (M_Agente aLoad : agenti) {
				AlberoClienti_Mandante.inserisciNodo("Agente: "+ aLoad.getCognome()+ " " +aLoad.getNome());
			}
		} 
		catch (PersistentException e1) {
			e1.printStackTrace();
		}
		
		
		M_Cliente [] listClienti = M_Cliente.caricaClientiRemoto();

		for (M_Cliente cLoad : listClienti) {

			AlberoClienti_Mandante.inserisciNodo(cLoad.getIdCliente()+ " - " + cLoad.getCognome()+ " - " +cLoad.getNome(), 
					"Agente: "+cLoad.getAgenteAssociato().getCognome()+" "+cLoad.getAgenteAssociato().getNome());
		}
	
	}


	public void initAlberoProdotti() throws PersistentException{
		
		M_Azienda[] listAziende = M_Azienda.caricaAziende();

		//bisognerebbe inserire un controllo se listclienti è null
		//e se ognuno dei dati usati è null
		AlberoProdotti.inserisciNodo("Tutti i prodotti");

		for (M_Azienda azienda : listAziende) {
			AlberoProdotti.inserisciNodo(azienda.getRagioneSociale());
			System.out.println("sono qui");
		}
	
	}
	
	public void initProdotti() throws PersistentException{
		
//		M_Prodotto [] prodotti = M_Prodotto.caricaProdotti();
		Ctrl_gestisciListino.setProdottiListino(M_Prodotto.caricaProdotti());
		M_Prodotto [] prodotti = Ctrl_gestisciListino.getProdottiListino();
		ProdottiView.getInstance().inserisciTabella(prodotti, "Tutti i prodotti");
	}
	
	
	public void initAlberoPreventivi() throws PersistentException{
		
		M_Preventivo [] preventivi = M_Preventivo.caricaPreventiviAgente(); 
		//controllare se non null
		for (M_Preventivo p : preventivi) {
				if(p.getRif_Cliente()!=null){
					AlberoPreventivi.inserisciNodo(p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome());	
				}
			}
	}
	
	public int getIdAgente(){
				
		return instanceAgenteLog.getIdAgente();
	}

	
	public static String readVersion() {
        
		
		//a questo punto bisognerebbe vedere se il fil esiste.
    	//qualora non dovesse esistere bisogna crearne uno di default

	    char[] in = new char[50];
	    int size = 0;
	    String versione="";
	    
	    try {
	    	
	        File file = new File(Costanti.pathVersion);
	        FileReader fr = new FileReader(file);
	        size = fr.read(in);
	         
	        for(int i=0; i<size; i++)
	        	versione=versione+in[i];
	        fr.close();
	         
	    } 
	    catch(IOException e) { 
	        e.printStackTrace();
	    }
	 

        Costanti.version=versione;
		return versione;
	}

	public static void writeVersione(String versione) {
		     
		    try {
		        File file = new File(Costanti.pathVersion);
		        FileWriter fw = new FileWriter(file);
		        fw.write(versione);
		        fw.flush();
		        fw.close();
		    }
		    catch(IOException e) {
		        e.printStackTrace();
		    }
	}
	
	
	public static int readLook() {

	    char[] in = new char[50];
	    int size = 0;
		int look = 0;
		
	    try {
	    	
	    	
	        //a questo punto bisognerebbe vedere se il fil esiste.
	    	//qualora non dovesse esistere bisogna crearne uno di default

	    	
	        File file = new File(Costanti.pathLook);
	        FileReader fr = new FileReader(file);
	        size = fr.read(in);

	        for(int i=0; i<size; i++){
	        	look=java.lang.Character.getNumericValue(in[i]);
	        }
	        	fr.close();
	         
	    } 
	    catch(IOException e) { 
	        e.printStackTrace();
	    }
	 
        Costanti.Look_Feel=look;
		return look;
	}

	public static void writeLook(String look) {
		     
		    try {
		        File file = new File(Costanti.pathLook);
		        FileWriter fw = new FileWriter(file);
		        fw.write(look);
		        fw.flush();
		        fw.close();
		    }
		    catch(IOException e) {
		        e.printStackTrace();
		    }
	}


	public void settingWindows() {
		//centrare al centro dello schermo
		
		LoginViewFactoryMethod.getInstance().setVisible(false);

		LoginViewFactoryMethod.getInstance().destroyInstanceLogin();

		
		
		frame = new Impostazioni();
		frame.setVisible(true);

	}
	
	public void salvaSetting(String versione, String look){
	

		writeVersione(versione);
		writeLook(look);

		readVersion();
		readLook();
		
		String[] args = null;
		Main.main(args);
		
	    frame.setVisible(false);
		frame.dispose();
		
	}
	
	
	
}