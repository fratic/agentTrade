package agent_trade.controller;

import java.util.ArrayList;
import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.content.CercaClienteView;

public class Ctrl_gestisciCliente {

	
	/*attributi di classe*/
	
	private static Ctrl_gestisciCliente instance;
	
	/*attributi privati*/

	
	/*costruttori*/
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciCliente getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciCliente() : instance);	
	}

	/*metodi privati*/

	/*metodi pubblici*/
	
	public void cercaCliente(String c)//qui andrebbe cambiato il modo di ricerca
	{
		if (c.equals("") || c==null){
			CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		else
		{
			M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
			
			if (cliente!=null )
			{
				CercaClienteView.getInstance().updateTable(cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getIndirizzo(),cliente.getEmail());
			}
			else{		
				CercaClienteView.getInstance().setErrore("Cliente non trovato");
			}
		}
	}
	
	public void ricercaCliente(String c)//qui andrebbe cambiato il modo di ricerca
	{	
		if (c.equals("") || c==null)
		{
			//DettaglioClienteView.getInstance().setErrore("Inserire cognome cliente");			
		}
		else
		{
			M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
			
			if (cliente!=null)
			{
				//DettaglioClienteView.getIstance().setDettaglio(cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getIndirizzo(),cliente.getEmail());
			}
			else
			{
				//DettaglioClienteView.getInstance().setErrore("cliente non trovato");
			}
		}
	}
	
	//bisogna decidere il criterio di caricamento. Decidere se è adeguata questa struttura dati
	public ArrayList caricaClienti() 
	{
		ArrayList clienti=Dao_System.getInstance().caricaClienti();
		return clienti;
	}

	public void apriViewCercaCliente()
	{
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);
		//qui bisogna portare la view cerca cliente in primo piano e disattivare tutto il resto
	} 
	
	public void caricaAlberoClienti()
	{
		
	}	
	
}
