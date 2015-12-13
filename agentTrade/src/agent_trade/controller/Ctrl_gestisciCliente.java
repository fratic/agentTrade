package agent_trade.controller;

import java.util.ArrayList;
import java.util.Iterator;

import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.AlberoClienti;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.DettaglioClienteView;
import agent_trade.ui.content.Ricerca_cliente;
import agent_trade.ui.content.RiepilogoClienteView;
import agent_trade.ui.content.confermaCancCliente;

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
	
	//per la tabella cerca cliente in gestione cliente
	public void ricercaCliente(String c)
	{
		if (c.equals("") || c==null){
			//DettaglioCercaCliente.getInstance().setErrore("Inserire cognome cliente");
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		else{
			ArrayList clienti=Dao_System.getInstance().cercaClienti(c);
			if(clienti.isEmpty()){
				Ricerca_cliente.getInstance().setErrore("Cliente non trovato");
			}
			else{
				Iterator iteraClienti = clienti.iterator();
				M_Cliente cliente = new M_Cliente();
				Ricerca_cliente.getInstance().svuotaTabella();
				while(iteraClienti.hasNext()){
//					System.out.println("ciao");
					cliente = (M_Cliente) iteraClienti.next();
					Ricerca_cliente.getInstance().updateTable(cliente.getCognome(), cliente.getNome(), cliente.getCodice_fiscale(), cliente.getPartita_iva());
					//System.out.println(cliente.getCognome());
					
				}
			}
		}
	}
	
	public void recuperaCliente(String cognome)
	{	
		
			M_Cliente cliente=Dao_System.getInstance().cercaCliente(cognome);
			Ricerca_cliente.getInstance().dispose();
			Ricerca_cliente.cancInstanza();
			PrimaryView.initRiepilogoClienteView();
			PrimaryView.getInstance().setSchedaCliente(cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getEmail(),cliente.getTelefono(),cliente.getFax());
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
	}
	
	//da rivedere COME CREO GLI ID? COME CONTROLLO I CAMPI?
	public void inserisciNuovoCliente(String nome, String cognome, String codFiscale, String partitaIva, String indirizzo, String email, String telefono, String fax){
		
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
			DettaglioClienteView.getInstance().setErrore("inserisci tutti i campi");
			//System.out.println("non lo salvo");
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
			//System.out.println("lo salvo");
			PrimaryView.getInstance().resetNuovoCliente();
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			recuperaCliente(cognome);
			AlberoClienti.inserisciNodo(cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);

		}
	}
	
	//da cambiare quando avremo deciso definitivamente il db
	public void modificaCliente(String nome, String cognome, String codFiscale, String partitaIva, String indirizzo, String email, String telefono, String fax){
		
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
			PrimaryView.getInstance().setVisibleErroreRiepCliente(true);
			RiepilogoClienteView.getInstance().setErrore("inserisci tutti i campi");
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
			
			Dao_System.getInstance().modificaCliente(cliente);
			
			PrimaryView.getInstance().resetCliente();
			//recuperaCliente(cognome);
			PrimaryView.getInstance().disattivaModifica(true);
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaCancella(true);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			AlberoClienti.abilitaAlbero();
			
		}
	}
	
	//PROBLEMA ADESSO ESSENDO LA RICERCA FATTA SOLO PER COGNOME POTREBBERO ESSERCI PEOBLEMI NEL CASO DI DUE COGNOMI UGUALI
	//da cambiare quando avremo deciso definitivamente il db
	public void cancellaCliente(String c){
		
		confermaCancCliente.getInstance().setCliente(c);
		confermaCancCliente.getInstance().setVisible(true);
		
//		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
//		Dao_System.getInstance().cancellaCliente(cliente);
//
//		AlberoClienti.rimuoviNodo(cliente.getCognome()+ " - " +cliente.getNome());
	
	}
	
	//bisogna decidere il criterio di caricamento. Decidere se � adeguata questa struttura dati
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
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.initDettaglioCliente();
		AlberoClienti.disabilitaAlbero();
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
		//PrimaryView.getInstance().setEnableNewCliente(false);
	}
	
	public void annullaNewCliente()
	{
		PrimaryView.getInstance().resetNuovoCliente();
		PrimaryView.getInstance().setVisibleErroreNuovoCliente(false);

	}
	
	public void btnCerca()
	{	
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		Ricerca_cliente.getInstance().setVisible(true);
	}
	
	public void abilitaModifica()
	{
		PrimaryView.getInstance().setModifiche(true);
		PrimaryView.getInstance().disattivaModifica(false);
		PrimaryView.getInstance().disattivaCancella(false);
		PrimaryView.getInstance().disattivaSalvaModifiche(true);
		PrimaryView.getInstance().disattivaAnnullaModifiche(true);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		AlberoClienti.disabilitaAlbero();
	}
		
	public void annullaModificheCliente(String cognome)
	{
		PrimaryView.getInstance().resetCliente();
		recuperaCliente(cognome);
		PrimaryView.getInstance().disattivaModifica(true);
		PrimaryView.getInstance().disattivaCancella(true);
		PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryView.getInstance().setEnableTabCatalogo(true);
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		AlberoClienti.abilitaAlbero();
	}
	
	public void postConfermaCancCliente(String c){

		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		Dao_System.getInstance().cancellaCliente(cliente);
		confermaCancCliente.getInstance().setVisible(false);		
		confermaCancCliente.cancInst();		
		AlberoClienti.rimuoviNodo(cliente.getCognome()+ " - " +cliente.getNome());
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		PrimaryView.getInstance().setEnableTabCatalogo(true);
	}
	
	public void notConfermaCancCliente(){
		confermaCancCliente.getInstance().setVisible(false);
		confermaCancCliente.cancInst();
	}
	
	//da modificare e fare per id (quando avremo un db)
	public void mostraCliente(Object obj){
		String c=obj.toString();
		int i=0;
		i = c.indexOf(" -");
		if(i!=-1){
			c = c.substring(0, i);
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			recuperaCliente(c);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			//System.out.print(c);
		}
	}
	
}
