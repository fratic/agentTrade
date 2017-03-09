package agent_trade.external_system;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.ui.LoginView;

public class SystemDaemon {

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
	
	
}
