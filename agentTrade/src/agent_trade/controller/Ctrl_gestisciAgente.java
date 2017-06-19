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
import agent_trade.ui.primaryView.PrimaryMandanteView;
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
			campoErrato = campoErrato +"città ";
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

			PrimaryMandanteView.getInstance().resetNuovoAgente();
			PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
					
			int id = M_Agente.getMaxIdRemoto();
			recuperaAgente(id);
					
//			AlberoAgenti.inserisciNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
			AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
			AlberoAgenti.abilitaAlbero();
			PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
			PrimaryMandanteView.getInstance().setEnableTabListino(true);
			PrimaryMandanteView.getInstance().setEnableTabSconto(true);
			PrimaryMandanteView.getInstance().setEnableCercaAgente(true);
			AlberoAgenti.refresh();

		}
		else{
			PrimaryMandanteView.getInstance().setVisibleErroreNuovoAgente(true);
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
							
			PrimaryMandanteView.getInstance().resetAgente();
			PrimaryMandanteView.getInstance().disattivaModificaAgente(true);
			PrimaryMandanteView.getInstance().disattivaSalvaModificheAgente(false);
			PrimaryMandanteView.getInstance().disattivaCancellaAgente(true);
			PrimaryMandanteView.getInstance().disattivaAnnullaModificheAgente(false);
		
			PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
			PrimaryMandanteView.getInstance().setEnableTabListino(true);
			PrimaryMandanteView.getInstance().setEnableTabSconto(true);
			
			PrimaryMandanteView.getInstance().setEnableNewAgente(true);
			PrimaryMandanteView.getInstance().setEnableCercaAgente(true);
			PrimaryMandanteView.getInstance().disattivaInviaPostaAgente(true);
			PrimaryMandanteView.getInstance().setInvisibleToolTipAgente();
//			AlberoAgenti.updateNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
			AlberoAgenti.abilitaAlbero();
			AlberoAgenti.refresh();
			AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());

		}
		else{
			PrimaryMandanteView.getInstance().setVisibleErroreRiepAgente(true);
			RiepilogoAgenteView.getInstance().setErrore(errore);
		}
	}
	

	public void cancellaAgente(String id){
		
		confermaCancAgente.getInstance().setAgente(id);
		confermaCancAgente.getInstance().setVisible(true);
	}


	public void btnCerca() throws PersistentException {

		PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
		PrimaryMandanteView.getInstance().setSfondoAgente();
		
		Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgentiRemoto());
		Ricerca_agente.getInstance().setVisibleBtnVisualizza(true);
		Ricerca_agente.getInstance().setVisibleBtnModifica(false);
		
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
		
		AlberoAgenti.deselezionaNodo();
		AlberoAgenti.disabilitaAlbero();

		PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
		PrimaryMandanteView.initDettaglioAgente();
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabListino(false);
		PrimaryMandanteView.getInstance().setEnableTabSconto(false);
		PrimaryMandanteView.getInstance().setEnableCercaAgente(false);
	}
	
	
	public void esciNewAgente() {
		
		PrimaryMandanteView.getInstance().resetNuovoAgente();
		PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
		PrimaryMandanteView.getInstance().setSfondoAgente();
		PrimaryMandanteView.getInstance().setEnableCercaAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setVisibleErroreNuovoAgente(false);
		AlberoAgenti.abilitaAlbero();
		}
	
	
	public void recuperaAgente(int idAgente)throws PersistentException{
		

			PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
			
			M_Agente agente = M_Agente.cercaAgenteRemoto(idAgente);
			
			Ricerca_agente.getInstance().dispose();
			Ricerca_agente.cancInstanza();
			
			PrimaryMandanteView.initRiepilogoAgenteView();
			PrimaryMandanteView.getInstance().setSchedaAgente(""+agente.getIdAgente(), agente.getCognome(), agente.getNome(), ""+agente.getLivello(), agente.getCitta(), agente.getCap(), agente.getIndirizzo(), agente.getEmail(), agente.getCell(), agente.getUsername(), agente.getPassword());
			PrimaryMandanteView.getInstance().disattivaSalvaModificheAgente(false);
			PrimaryMandanteView.getInstance().disattivaAnnullaModificheAgente(false);
			PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
			PrimaryMandanteView.getInstance().setEnableTabListino(true);
			PrimaryMandanteView.getInstance().setEnableTabSconto(true);
			PrimaryMandanteView.getInstance().setVisibleErroreRiepAgente(false);
			AlberoAgenti.abilitaAlbero();
			AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
			
	}
	
	public void abilitaModifica()
	{
		PrimaryMandanteView.getInstance().setModificheAgente(true);
		PrimaryMandanteView.getInstance().disattivaModificaAgente(false);
		PrimaryMandanteView.getInstance().disattivaCancellaAgente(false);
		PrimaryMandanteView.getInstance().disattivaInviaPostaAgente(false);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheAgente(true);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabListino(false);
		PrimaryMandanteView.getInstance().setEnableTabSconto(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAgente(false);
		PrimaryMandanteView.getInstance().setEnableNewAgente(false);
		PrimaryMandanteView.getInstance().setEnableCercaAgente(false);
		PrimaryMandanteView.getInstance().setVisibleToolTipAgente();
		AlberoAgenti.disabilitaAlbero();
	}
	
	public void annullaModificheAgente(String id) throws PersistentException
	{
		PrimaryMandanteView.getInstance().resetAgente();
		int idAgente=Integer.parseInt(id);
		recuperaAgente(idAgente);
		PrimaryMandanteView.getInstance().disattivaModificaAgente(true);
		PrimaryMandanteView.getInstance().disattivaCancellaAgente(true);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAgente(false);
		PrimaryMandanteView.getInstance().disattivaInviaPostaAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableNewAgente(true);
		PrimaryMandanteView.getInstance().setEnableCercaAgente(true);
		PrimaryMandanteView.getInstance().setInvisibleToolTipAgente();
		AlberoAgenti.abilitaAlbero();
	}
	
	public void postConfermaCancAgente(String id) throws PersistentException{
		
		System.out.println("sono in post conferma");
		int idAgente=Integer.parseInt(id);
		
		M_Agente agente=M_Agente.cercaAgenteRemoto(idAgente);
		agente.setAttivo(0);
		M_Agente.aggiornaAgenteRemoto(agente);

		//AlberoAgenti.rimuoviNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
		confermaCancAgente.getInstance().setVisible(false);		
		confermaCancAgente.cancInst();
		PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
		PrimaryMandanteView.getInstance().setSfondoAgente();
		AlberoAgenti.refresh();
	}
	
	public void notConfermaCancAgente(){
		confermaCancAgente.getInstance().setVisible(false);
		confermaCancAgente.cancInst();
	}

	
}
