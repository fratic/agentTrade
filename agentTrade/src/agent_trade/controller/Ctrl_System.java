package agent_trade.controller;

import java.util.ArrayList;
import java.util.Iterator;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.LoginView;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.AlberoClienti;
import agent_trade.ui.content.AlberoPreventivi;
import agent_trade.ui.content.ProdottiView;

public class Ctrl_System {

	/*Attributi di classe*/
	
	private static Ctrl_System instance;
	/*	la responsabilità di tenere l'istanza dell'agente loggato è stata assegnata ad crtl_system, in quanto è il creatore*/
	private static M_Agente instanceAgenteLog;

	/*Attributi privati*/

	
	/*costruttori*/
	
	
	/*metodi di classe*/
	
	public static Ctrl_System getInstance(){

		return ((instance == null) ? instance = new Ctrl_System() : instance);	
	}
	
	public static M_Agente getAgenteLog(){

		return ((instance == null) ? null : instanceAgenteLog);	
	}
	
	/*metodi privati*/
	
	private void initAlberoPreventivi(){
	
		ArrayList<M_Preventivo> preventivi= Dao_System.loadPreventivi();
		Iterator iteraPreventivi = preventivi.iterator();
		M_Preventivo p;
		int i=0;
		while (iteraPreventivi.hasNext()) {				
			p = (M_Preventivo) iteraPreventivi.next();
				AlberoPreventivi.inserisciNodo(p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome());	
				i++;
				System.out.println (i);
		}
	}
	
	private void initAlberoClienti(){
		
		ArrayList<M_Cliente> clienti = Dao_System.getInstance().caricaClienti();
		Iterator iteraClienti = clienti.iterator();
		M_Cliente c;
		int i=0;
		while (iteraClienti.hasNext()){
			c = (M_Cliente) iteraClienti.next();
			//System.out.println(c.getCognome()+ "-" +c.getNome());
			AlberoClienti.inserisciNodo(c.getCognome()+ " - " +c.getNome());
			i++;
			
		}
	}
	
	private void inizializzaSistema()
	{
		//qui andrebbero inizializzati tutti gli oggetti che vogliamo siano presenti all'avvio

		initProdotti();
		
		initAlberoPreventivi();	
		
		initAlberoClienti();

	}
	
	private void initProdotti(){

		ProdottiView.getInstance().initTable(Dao_System.getInstance().caricaProdotti());
	}
	
	/*metodi pubblici*/

	public void login(String user, String psw) 
	{
		M_Agente a=Dao_System.getInstance().loadAgente(user);

		if (a!=null)
		{
			if (a.getCognome().equals(user) && a.getPassword().equals(psw))
			{
				//l'istanza di agente è già creata
				
				PrimaryView.getInstance().setVisible(true);
				LoginView.getInstance().setVisible(false);
				instanceAgenteLog=a;
				
				inizializzaSistema();
				
				}
				else{
				LoginView.getInstance().setMex("Login errato");
				//l'istanza di agente creata in precedenza, andrebbe distrutta in quanto non valida
			}
		}
		else
		{
			LoginView.getInstance().setMex("Utente sconosciuto");
			//anche qui andrebbe distrutta 
		}		
	}
	
	
	
}