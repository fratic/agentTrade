package agent_trade.controller;

import java.util.ArrayList;
import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.DettaglioCercaCliente;
import agent_trade.ui.content.DettaglioClienteView;

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
			DettaglioCercaCliente.getInstance().setErrore("Inserire cognome cliente");			
		}
		else
		{
			M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
			
			if (cliente!=null)
			{
				//DettaglioCercaCliente.getIstance().setDettaglio(cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getEmail(),cliente.getTelefono(),cliente.getFax());
			}
			else
			{
				DettaglioCercaCliente.getInstance().setErrore("cliente non trovato");
			}
		}
	}
	
	//da rivedere COME CREO GLI ID? COME CONTROLLO I CAMPI?
	public void inserisciNuovoCliente(String nome, String cognome, String codFiscale, String partitaIva, String indirizzo, String email, String telefono, String fax){
		
		if(nome==null || cognome==null ||codFiscale==null || partitaIva==null || indirizzo==null || email==null || telefono==null || fax==null){
			DettaglioClienteView.getInstance().setErrore("inserisci tutti i campi");
		}
		else{
			M_Cliente cliente=new M_Cliente();
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_Iva(partitaIva);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setFax(fax);
			
			Dao_System.getInstance().nuovoCliente(cliente);
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
	
	public void newCliente()
	{
		PrimaryView.initDettaglioCliente();
		//PrimaryView.getInstance().setEnableNewCliente(false);
	}
	
	public void btnCerca()
	{
		PrimaryView.initCerca();
		//PrimaryView.getInstance().setEnableCercaBtn(false);
	}
	
	
	
	public void caricaAlberoClienti()
	{
		
	}	
	
}
