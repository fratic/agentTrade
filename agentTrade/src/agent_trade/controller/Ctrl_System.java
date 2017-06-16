
package agent_trade.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import org.orm.PersistentException;

import agent_trade.Main;
import agent_trade.external_system.SystemDaemon;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Mandante;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.prodotti.AlberoProdotti;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.ui.login.LoginViewFactory;
import agent_trade.ui.primaryView.PrimaryViewFactory;
import agent_trade.util.Costanti;
import example.Impostazioni;


public class Ctrl_System {

	/*
	 * Attributi di classe
	 */
	
	private static Ctrl_System instance;
	
	public static Calendar calendario = Calendar.getInstance();
	
	Impostazioni frame;
	
	/*	la responsabilità di tenere l'istanza dell'agente loggato è stata assegnata ad crtl_system, in quanto è il creatore*/
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
		//qui andrebbero inizializzati tutti gli oggetti che vogliamo siano presenti all'avvio

		//probabilmente queste cose non vanno fatte qui, oppure bisogna chiedere ad una factory
		

		initAlberoClienti();

		initProdotti();
		
		initAlberoPreventivi();	
		
		initAlberoProdotti();
		
	}
	
	private void inizializzaSistemaMandante() throws PersistentException, CloneNotSupportedException, IOException
	{

		initAlberoAgenti();

		
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
					LoginViewFactory.getInstance().setVisible(false);
					instanceAgenteLog=agLoad;
					
					inizializzaSistemaAgente();
					
				}
					else{
						LoginViewFactory.getInstance().setMex(Costanti.MESSAGGIO_NO_LOGIN);
						LoginViewFactory.getInstance().enableAccedi();
				}
			}
			else{
				LoginViewFactory.getInstance().setMex("Sincronizzazione database centrale");

				if (SystemDaemon.getInstance().sincronizzaAgente(username))
					loginAgente(username,psw);
				else{
					LoginViewFactory.getInstance().setMex(Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
					LoginViewFactory.getInstance().enableAccedi();
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
				LoginViewFactory.getInstance().setVisible(false);
				
				inizializzaSistemaMandante();
				
			}
				else{
					LoginViewFactory.getInstance().setMex(Costanti.MESSAGGIO_NO_LOGIN);
					LoginViewFactory.getInstance().enableAccedi();
			}
		}
		else{
				LoginViewFactory.getInstance().setMex(Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
				LoginViewFactory.getInstance().enableAccedi();
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

		//bisognerebbe inserire un controllo se listclienti è null
		//e se ognuno dei dati usati è null
		
		for (M_Agente aLoad : listAgenti) {

			System.out.println(aLoad.getIdAgente()+ " - " + aLoad.getCognome()+ " - " +aLoad.getNome());
			AlberoAgenti.inserisciNodo(aLoad.getIdAgente()+ " - " + aLoad.getCognome()+ " - " +aLoad.getNome());
		}
	
	}
	public void initAlberoProdotti() throws PersistentException{
		
		M_Azienda[] listAziende = M_Azienda.caricaAziende();

		//bisognerebbe inserire un controllo se listclienti è null
		//e se ognuno dei dati usati è null
		AlberoProdotti.inserisciNodo("Tutti i prodotti");

		for (M_Azienda azienda : listAziende) {
			AlberoProdotti.inserisciNodo(azienda.getRagioneSociale());
			
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
		
		LoginViewFactory.getInstance().setVisible(false);

		LoginViewFactory.getInstance().destroyInstanceLogin();

		
		
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