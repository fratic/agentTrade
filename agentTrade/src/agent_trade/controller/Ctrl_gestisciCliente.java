package agent_trade.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.Ricerca_cliente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.clienti.confermaCancCliente;

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

	private boolean check(String regex, String input){
		
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(input);

		  if (matcher.matches())
		    return true;
		  else
		    return false;
		}
	
	private boolean ControlloCampi(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax){
		
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
			DettaglioClienteView.getInstance().setErrore("inserisci tutti i campi");
			return false;
		}
//		if(!check("[a-zA-Z]", nome)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("nome errato");
//			return false;
//		}
//		if(!check("[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]", codFiscale)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("codice fiscale errato");
//			return false;
//		}
//		if(!check("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("emali non corretta");
//			return false;
//		}
		
		
		
		return true;
	}
	
	/*metodi pubblici*/
	
	
	public void cercaCliente(String c)//qui andrebbe cambiato il modo di ricerca
	{
		if (c.equals("") || c==null){
			CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		else
		{
			M_Cliente cliente=Dao_System.getInstance().cercaCliente(c,Ctrl_System.getInstance().getIdAgente());
			
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
			
			Ricerca_cliente.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		else {
			
			ArrayList clienti=Dao_System.getInstance().cercaClienti(c,Ctrl_System.getInstance().getIdAgente());
			if(clienti.isEmpty()) {
				
				Ricerca_cliente.getInstance().setErrore("Cliente non trovato");
			}
			else{
				
				Iterator iteraClienti = clienti.iterator();
				M_Cliente cliente = new M_Cliente();
				Ricerca_cliente.getInstance().svuotaTabella();
				while(iteraClienti.hasNext()){

					cliente = (M_Cliente) iteraClienti.next();
					Ricerca_cliente.getInstance().updateTable(cliente.getCognome(), cliente.getNome(), cliente.getCodice_fiscale(), cliente.getPartita_iva());
					
				}
			}
		}
	}
	
	public void recuperaCliente(String cognome)
	{	
		
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			M_Cliente cliente=Dao_System.getInstance().cercaCliente(cognome,Ctrl_System.getInstance().getIdAgente());
			Ricerca_cliente.getInstance().dispose();
			Ricerca_cliente.cancInstanza();
			PrimaryView.initRiepilogoClienteView();
			PrimaryView.getInstance().setSchedaCliente(cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getPartita_iva(),cliente.getIndirizzo(),cliente.getEmail(),cliente.getTelefono(),cliente.getFax());
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
			AlberoClienti.abilitaAlbero();
	}
	
	//da rivedere COME CREO GLI ID? COME CONTROLLO I CAMPI?
	public void inserisciNuovoCliente(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax){
		
//		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("inserisci tutti i campi");
//			
//		}
//		if(!check("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", email)){
//			PrimaryView.getInstance().setVisibleErroreNuovoCliente(true);
//			DettaglioClienteView.getInstance().setErrore("emali non corretta");
//		}
//		else{
		if(ControlloCampi(nome, cognome, codFiscale, partitaIva, citta, cap, indirizzo, email, telefono, cellulare, fax))
		{
			M_Cliente cliente=new M_Cliente();
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_iva(partitaIva);
			cliente.setCitta(citta);
			cliente.setCap(cap);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setCellulare(cellulare);
			cliente.setFax(fax);
			
			Dao_System.getInstance().nuovoCliente(cliente);
			
			PrimaryView.getInstance().resetNuovoCliente();
			PrimaryView.getInstance().resetPannelloCentraleCliente();
			recuperaCliente(cognome);
			AlberoClienti.inserisciNodo(cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
		}
//		}
	}
	
	//da cambiare quando avremo deciso definitivamente il db
	public void modificaCliente(String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax){
		
		if(nome.equals("") || cognome.equals("") || codFiscale.equals("") || partitaIva.equals("") || indirizzo.equals("") || email.equals("") || telefono.equals("") || fax.equals("")){
			PrimaryView.getInstance().setVisibleErroreRiepCliente(true);
			RiepilogoClienteView.getInstance().setErrore("inserisci tutti i campi");
		}
		else{
			M_Cliente cliente=new M_Cliente();
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setCodice_fiscale(codFiscale);
			cliente.setPartita_iva(partitaIva);
			cliente.setCitta(citta);
			cliente.setCap(cap);
			cliente.setIndirizzo(indirizzo);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setCellulare(cellulare);
			cliente.setFax(fax);
			
			Dao_System.getInstance().modificaCliente(cliente);
			
			PrimaryView.getInstance().resetCliente();
			PrimaryView.getInstance().disattivaModifica(true);
			PrimaryView.getInstance().disattivaSalvaModifiche(false);
			PrimaryView.getInstance().disattivaCancella(true);
			PrimaryView.getInstance().disattivaAnnullaModifiche(false);
			PrimaryView.getInstance().setEnableTabPreventivo(true);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setEnableNewCliente(true);
			PrimaryView.getInstance().setEnableCercaCliente(true);
			AlberoClienti.updateNodo(cliente.getCognome()+ " - " +cliente.getNome());
			AlberoClienti.abilitaAlbero();
			
		}
	}
	
	//da cambiare quando avremo deciso definitivamente il db
	public void cancellaCliente(String c){
		
		confermaCancCliente.getInstance().setCliente(c);
		confermaCancCliente.getInstance().setVisible(true);
	}
	
	//bisogna decidere il criterio di caricamento. Decidere se è adeguata questa struttura dati
	public ArrayList caricaClienti() 
	{
		ArrayList clienti=Dao_System.getInstance().caricaClienti(Ctrl_System.getInstance().getIdAgente());
		return clienti;
	}

	public void apriViewCercaCliente()
	{
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);
	} 
	
	public void newCliente()
	{	
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.initDettaglioCliente();
		AlberoClienti.disabilitaAlbero();
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
	}
	
	public void annullaNewCliente()
	{
		PrimaryView.getInstance().resetNuovoCliente();
		PrimaryView.getInstance().setVisibleErroreNuovoCliente(false);
	}
	
	public void esciNewCliente() {
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
		PrimaryView.getInstance().setEnableTabCatalogo(true);
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		PrimaryView.getInstance().setVisibleErroreNuovoCliente(false);
		AlberoClienti.abilitaAlbero();
	}
	
	public void btnCerca()
	{	
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
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
		PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
		PrimaryView.getInstance().setEnableNewCliente(false);
		PrimaryView.getInstance().setEnableCercaCliente(false);
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
		PrimaryView.getInstance().setEnableNewCliente(true);
		PrimaryView.getInstance().setEnableCercaCliente(true);
		AlberoClienti.abilitaAlbero();
	}
	
	public void postConfermaCancCliente(String c){
		
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c,Ctrl_System.getInstance().getIdAgente());
		Dao_System.getInstance().cancellaCliente(cliente);
		confermaCancCliente.getInstance().setVisible(false);		
		confermaCancCliente.cancInst();
		PrimaryView.getInstance().resetPannelloCentraleCliente();
		PrimaryView.getInstance().setSfondoCliente();
		AlberoClienti.rimuoviNodo(cliente.getCognome()+ " - " +cliente.getNome());
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
			PrimaryView.getInstance().setVisibleErroreRiepCliente(false);
			PrimaryView.getInstance().setEnableTabCatalogo(true);
			PrimaryView.getInstance().setEnableTabPreventivo(true);

		}
	}
	
}
