package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.agenti.DettaglioAgenteView;
import agent_trade.ui.content.agenti.Ricerca_agente;
import agent_trade.ui.content.agenti.RiepilogoAgenteView;
import agent_trade.ui.content.agenti.confermaCancAgente;
import agent_trade.ui.primaryView.PrimaryViewFactory;
import agent_trade.util.Costanti;



public class Ctrl_gestisciAgente {

	
/*attributi di classe*/
	
	private static Ctrl_gestisciAgente instance;
	
	/*attributi privati*/

	
	/*costruttori*/
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciAgente getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciAgente() : instance);	
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
	
	private String ControlloCampi(String nome, String cognome, String livello, String citta, String cap, String indirizzo, String email, String cellulare, String username, String password){
		
		String errore= null;
		String campoErrato = "";
		
		if(nome.equals("") || cognome.equals("") || livello.equals("") || citta.equals("") || cap.equals("") || indirizzo.equals("") || email.equals("") || cellulare.equals("") || username.equals("") || password.equals("")){
			return errore = Costanti.MESSAGGIO_CAMPI_VUOTI;
		}
		if(!check(Costanti.REG_EX_COGNOME_AGENTE, cognome)){
			campoErrato = campoErrato + "cognome ";
		}
		if(!check(Costanti.REG_EX_NOME, nome)){
			campoErrato = campoErrato + "nome ";
		}
		if(!check(Costanti.REG_EX_LIVELLO, livello)){
			campoErrato = campoErrato + "livello ";
		}
		if(!check(Costanti.REG_EX_INDIRIZZO, indirizzo)){
			campoErrato = campoErrato +"indirizzo ";
		}
		if(!check(Costanti.REG_EX_CITTA, citta)){
			campoErrato = campoErrato +"citt� ";
		}
		if(!check(Costanti.REG_EX_CAP, cap)){
			campoErrato = campoErrato +"cap ";
		}
		if(!check(Costanti.REG_EX_CELLULARE, cellulare)){
			campoErrato = campoErrato +"cellulare ";
		}
		if(!check(Costanti.REG_EX_EMAIL, email)){
			campoErrato = campoErrato +"email ";
		}
		if(!check(Costanti.REG_EX_USERNAME, username)){
			campoErrato = campoErrato +"username ";
		}
		if(!check(Costanti.REG_EX_PASSWORD, password)){
			campoErrato = campoErrato +"password ";
		}
		if (errore == null && campoErrato != "")
		{
			errore = Costanti.MESSAGGIO_CAMPI_ERRATI + campoErrato;
		}
		return errore;
	}
	
	
	/*metodi pubblici*/
	
//	uasta in example (test insert agente)
	public void nuovoAgente(String nome, String cognome, String username, String password, String citta, String cap, String indirizzo, String email, String cell, int livello) throws PersistentException
	{
		M_Agente agente = new M_Agente(nome, cognome, password, username, citta, indirizzo, livello, cell, email, cap);
		M_Agente.salvaAgenteRemoto(agente); 
		
	}
	
	public void inserisciNuovoAgente(String nome, String cognome, String livello, String citta, String cap, String indirizzo, String email, String cell, String user, String psw) throws PersistentException
	{
		String errore = ControlloCampi(nome, cognome, livello, citta, cap, indirizzo, email, cell, user, psw);
		if(errore==null){
			
			int lvl = Integer.parseInt(livello);
			M_Agente agente = new M_Agente(nome, cognome, psw, user, citta, indirizzo, lvl, cell, email, cap);
			agente.setAttivo(1);
			M_Agente.salvaAgenteRemoto(agente); 

			PrimaryViewFactory.getInstance().resetNuovoAgente();
			PrimaryViewFactory.getInstance().resetPannelloCentraleAgente();
					
			int id = M_Agente.getMaxIdRemoto();
			recuperaAgente(id);
					
//			AlberoAgenti.inserisciNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//			AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//			AlberoAgenti.abilitaAlbero();

			PrimaryViewFactory.getInstance().setEnableCercaAgente(true);
		}
		else{
			PrimaryViewFactory.getInstance().setVisibleErroreNuovoAgente(true);
			DettaglioAgenteView.getInstance().setErrore(errore);
		}		
	}
	
	public void modificaAgente(int id, String nome, String cognome, String livello, String citta, String cap, String indirizzo, String email, String cellulare, String username, String password) throws PersistentException
	{
		String errore = ControlloCampi(nome, cognome, livello, citta, cap, indirizzo, email, cellulare, username, password);
		if(errore==null){
			
			M_Agente agente = M_Agente.cercaAgenteRemoto(id);
			
			int lvl = Integer.parseInt(livello);
			
			agente.setNome(nome);
			agente.setCognome(cognome);
			agente.setLivello(lvl);
			agente.setIndirizzo(indirizzo);
			agente.setEmail(email);
			agente.setCitta(citta);
			agente.setCap(cap);
			agente.setCell(cellulare);
			agente.setUsername(username);
			agente.setPassword(password);
			
			M_Agente.aggiornaAgenteRemoto(agente);
							
			PrimaryViewFactory.getInstance().resetAgente();
			PrimaryViewFactory.getInstance().disattivaModificaAgente(true);
			PrimaryViewFactory.getInstance().disattivaSalvaModificheAgente(false);
			PrimaryViewFactory.getInstance().disattivaCancellaAgente(true);
			PrimaryViewFactory.getInstance().disattivaAnnullaModificheAgente(false);
			PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
			PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
			PrimaryViewFactory.getInstance().setEnableNewAgente(true);
			PrimaryViewFactory.getInstance().setEnableCercaAgente(true);
			PrimaryViewFactory.getInstance().disattivaInviaPostaAgente(true);
			PrimaryViewFactory.getInstance().setInvisibleToolTipAgente();
//			AlberoAgenti.updateNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//			AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//			AlberoAgenti.abilitaAlbero();
		}
		else{
			PrimaryViewFactory.getInstance().setVisibleErroreRiepAgente(true);
			RiepilogoAgenteView.getInstance().setErrore(errore);
		}
	}
	

	public void cancellaAgente(String id){
		
		confermaCancAgente.getInstance().setAgente(id);
		confermaCancAgente.getInstance().setVisible(true);
	}


	public void btnCerca() throws PersistentException {

		PrimaryViewFactory.getInstance().resetPannelloCentraleAgente();
		PrimaryViewFactory.getInstance().setSfondoAgente();
		
		Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgentiRemoto());
		
		Ricerca_agente.getInstance().setVisible(true);
	}

	
	public void ricercaAgente(String c, String lvl, String email, String city) throws PersistentException
	{
		if ((c.equals("") || c==null) && (lvl.equals("") || lvl==null) && (email.equals("") || email==null) && (city.equals("") || city==null)){
			
			Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgentiRemoto());
		}
		else {
			int livello =-1;

			if (!lvl.equals("") && lvl!=null){
				livello = Integer.parseInt(lvl);	
			}
			
			M_Agente [] listAgenti = M_Agente.caricaAgentiRemotoParametri(c, livello, email, city);
			
			if(listAgenti.length==0) {
		
				Ricerca_agente.getInstance().setErrore(Costanti.MESSAGGIO_AGENTE_NON_TROVATO);
				Ricerca_agente.getInstance().setVisibleErroreRicercaAgente(true);
			}
			else{
				Ricerca_agente.getInstance().svuotaTabella();
				for (M_Agente cLoad : listAgenti) {
					Ricerca_agente.getInstance().updateTable(cLoad.getIdAgente(), cLoad.getCognome(), cLoad.getNome(), cLoad.getLivello(), cLoad.getEmail(), cLoad.getCitta());
				}
			}
		}
	}
	

	public void btnNewAgente() {
		
		PrimaryViewFactory.getInstance().resetPannelloCentraleAgente();
		PrimaryViewFactory.initDettaglioAgente();
		//AlberoAgenti.disabilitaAlbero();
		PrimaryViewFactory.getInstance().setEnableCercaAgente(false);
	}
	
	
	public void esciNewAgente() {
		
		PrimaryViewFactory.getInstance().resetNuovoAgente();
		PrimaryViewFactory.getInstance().resetPannelloCentraleAgente();
		PrimaryViewFactory.getInstance().setSfondoAgente();
		PrimaryViewFactory.getInstance().setEnableCercaAgente(true);
		PrimaryViewFactory.getInstance().setVisibleErroreNuovoAgente(false);
//		AlberoAgenti.abilitaAlbero();
		}
	
	
	public void recuperaAgente(int idAgente)throws PersistentException{
		
		PrimaryViewFactory.getInstance().resetPannelloCentraleAgente();
		
		M_Agente agente = M_Agente.cercaAgenteRemoto(idAgente);
		
		Ricerca_agente.getInstance().dispose();
		Ricerca_agente.cancInstanza();
		
		PrimaryViewFactory.initRiepilogoAgenteView();
		PrimaryViewFactory.getInstance().setSchedaAgente(""+agente.getIdAgente(), agente.getCognome(), agente.getNome(), ""+agente.getLivello(), agente.getCitta(), agente.getCap(), agente.getIndirizzo(), agente.getEmail(), agente.getCell(), agente.getUsername(), agente.getPassword());
		PrimaryViewFactory.getInstance().disattivaSalvaModificheAgente(false);
		PrimaryViewFactory.getInstance().disattivaAnnullaModificheAgente(false);
		PrimaryViewFactory.getInstance().setVisibleErroreRiepAgente(false);
//		AlberoClienti.abilitaAlbero();
//		AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}
	
	public void abilitaModifica()
	{
		PrimaryViewFactory.getInstance().setModificheAgente(true);
		PrimaryViewFactory.getInstance().disattivaModificaAgente(false);
		PrimaryViewFactory.getInstance().disattivaCancellaAgente(false);
		PrimaryViewFactory.getInstance().disattivaInviaPostaAgente(false);
		PrimaryViewFactory.getInstance().disattivaSalvaModificheAgente(true);
		PrimaryViewFactory.getInstance().disattivaAnnullaModificheAgente(true);
		PrimaryViewFactory.getInstance().setEnableTabCatalogo(false);
		PrimaryViewFactory.getInstance().setEnableTabPreventivo(false);
		PrimaryViewFactory.getInstance().setVisibleErroreRiepAgente(false);
		PrimaryViewFactory.getInstance().setEnableNewAgente(false);
		PrimaryViewFactory.getInstance().setEnableCercaAgente(false);
		PrimaryViewFactory.getInstance().setVisibleToolTipAgente();
		//AlberoAgenti.disabilitaAlbero();
	}
	
	public void annullaModificheAgente(String id) throws PersistentException
	{
		PrimaryViewFactory.getInstance().resetAgente();
		int idAgente=Integer.parseInt(id);
		recuperaAgente(idAgente);
		PrimaryViewFactory.getInstance().disattivaModificaAgente(true);
		PrimaryViewFactory.getInstance().disattivaCancellaAgente(true);
		PrimaryViewFactory.getInstance().setVisibleErroreRiepAgente(false);
		PrimaryViewFactory.getInstance().disattivaInviaPostaAgente(true);
		PrimaryViewFactory.getInstance().setEnableTabCatalogo(true);
		PrimaryViewFactory.getInstance().setEnableTabPreventivo(true);
		PrimaryViewFactory.getInstance().setEnableNewAgente(true);
		PrimaryViewFactory.getInstance().setEnableCercaAgente(true);
		PrimaryViewFactory.getInstance().setInvisibleToolTipAgente();
		//AlberoClienti.abilitaAlbero();
	}
	
	public void postConfermaCancAgente(String id) throws PersistentException{
		
		int idAgente=Integer.parseInt(id);
		
		M_Agente agente=M_Agente.cercaAgenteRemoto(idAgente);
		agente.setAttivo(0);
		M_Agente.aggiornaAgenteRemoto(agente);

		AlberoAgenti.rimuoviNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
		confermaCancAgente.getInstance().setVisible(false);		
		confermaCancAgente.cancInst();
		PrimaryViewFactory.getInstance().resetPannelloCentraleAgente();
		PrimaryViewFactory.getInstance().setSfondoAgente();
	}
	
	public void notConfermaCancAgente(){
		confermaCancAgente.getInstance().setVisible(false);
		confermaCancAgente.cancInst();
	}

	
}
