
package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.ui.LoginView;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.util.Costanti;


public class Ctrl_System {

	/*
	 * Attributi di classe
	 */
	
	private static Ctrl_System instance;
	
	
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
	
	public static M_Agente getAgenteLog(){

		return ((instance == null) ? null : instanceAgenteLog);	
	}
	
	/*
	 * metodi privati
	 */

	private void inizializzaSistema() throws PersistentException
	{
		//qui andrebbero inizializzati tutti gli oggetti che vogliamo siano presenti all'avvio

		initAlberoClienti();

		initProdotti();
		
		initAlberoPreventivi();	
		
	}
	
	
	
	/*
	 * metodi pubblici
	 */
	

	public void login(String username, String psw) throws PersistentException  
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
					PrimaryView.getInstance().setVisible(true);
					LoginView.getInstance().setVisible(false);
					instanceAgenteLog=agLoad;
					
					inizializzaSistema();
					
				}
					else{
					LoginView.getInstance().setMex(Costanti.MESSAGGIO_NO_LOGIN);
					LoginView.getInstance().enableAccedi();
				}
			}
			else{
				LoginView.getInstance().setMex(Costanti.MESSAGGIO_UTENTE_NON_TROVATO);
				LoginView.getInstance().enableAccedi();
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
	

	public void initProdotti() throws PersistentException{
		
		M_Prodotto [] prodotti = M_Prodotto.caricaProdotti();
		ProdottiView.getInstance().initTable(prodotti);
	}
	
	
	public void initAlberoPreventivi() throws PersistentException{
		
		M_Preventivo [] preventivi = M_Preventivo.caricaPreventiviAgente(); 
		
		//controllare se non null
		for (M_Preventivo p : preventivi) {
			
				AlberoPreventivi.inserisciNodo(p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome());	
		}
	}
	
	public int getIdAgente(){
				
		return instanceAgenteLog.getIdAgente();
	}
	
}