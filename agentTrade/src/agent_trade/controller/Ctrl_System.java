package agent_trade.controller;

import agent_trade.model.M_Agente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.LoginView;
import agent_trade.ui.PrimaryView;

public class Ctrl_System {

	private static Ctrl_System instance;
	
	/*	la responsabilità di tenere l'istanza dell'agente loggato è stata assegnata ad crtl_system, in quanto è il creatore*/
	private static M_Agente instanceAgenteLog;

	public static Ctrl_System getInstance(){

		return ((instance == null) ? instance = new Ctrl_System() : instance);	
	}
	
	public static M_Agente getAgenteLog(){

		return ((instance == null) ? null : instanceAgenteLog);	
	}

	
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
	
	public void inizializzaSistema(){
		//qui andrebbero inizializzati tutti gli oggetti che vogliamo siano presenti all'avvio
		//PrimaryView.getInstance().initAlberoClienti();
	//	Ctrl_gestisciCliente.getInstance().caricaAlberoClienti();
	}
}