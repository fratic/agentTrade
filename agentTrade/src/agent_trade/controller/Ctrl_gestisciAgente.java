package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Agente;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.agenti.Ricerca_agente;
import agent_trade.ui.content.clienti.AlberoClienti;
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
	
	
	/*metodi pubblici*/
	
//	uasta in example (test insert agente)
	public void nuovoAgente(String nome, String cognome, String username, String password, String citta, String cap, String indirizzo, String email, String cell, int livello) throws PersistentException
	{
		M_Agente agente = new M_Agente(nome, cognome, password, username, citta, indirizzo, livello, cell, email, cap);
		M_Agente.salvaAgenteRemoto(agente); 
		
	}
	
	public void inserisciNuovoAgente(String nome, String cognome, String livello, String citta, String cap, String indirizzo, String email, String cell, String user, String psw) throws PersistentException
	{
//		Manca il controllo dei campi
		int lvl = Integer.parseInt(livello);
		M_Agente agente = new M_Agente(nome, cognome, psw, user, citta, indirizzo, lvl, cell, email, cap);
		M_Agente.salvaAgenteRemoto(agente); 

		PrimaryView.getInstance().resetNuovoAgente();
		PrimaryView.getInstance().resetPannelloCentraleAgente();
				
		int id = M_Agente.getMaxIdRemoto();
		recuperaAgente(id);
				
//		AlberoAgenti.inserisciNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//		AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//		AlberoAgenti.abilitaAlbero();

		PrimaryView.getInstance().setEnableCercaAgente(true);
			
	}
	
	public void modificaAgente(int id, String nome, String cognome, int livello, String citta, String cap, String indirizzo, String email, String cellulare, String username, String password) throws PersistentException
	{
		M_Agente agente = M_Agente.cercaAgenteRemoto(id);
		
		agente.setNome(nome);
		agente.setCognome(cognome);
		agente.setLivello(livello);
		agente.setIndirizzo(indirizzo);
		agente.setEmail(email);
		agente.setCitta(citta);
		agente.setCap(cap);
		agente.setCell(cellulare);
		agente.setUsername(username);
		agente.setPassword(password);
		
		M_Agente.aggiornaAgenteRemoto(agente);
						
		PrimaryView.getInstance().resetAgente();
		PrimaryView.getInstance().disattivaModificaAgente(true);
		PrimaryView.getInstance().disattivaSalvaModificheAgente(false);
		PrimaryView.getInstance().disattivaCancellaAgente(true);
		PrimaryView.getInstance().disattivaAnnullaModificheAgente(false);
		PrimaryView.getInstance().setEnableTabPreventivo(true);
		PrimaryView.getInstance().setEnableTabCatalogo(true);
		PrimaryView.getInstance().setEnableNewAgente(true);
		PrimaryView.getInstance().setEnableCercaAgente(true);
		PrimaryView.getInstance().disattivaInviaPostaAgente(true);
		PrimaryView.getInstance().setInvisibleToolTipAgente();
//		AlberoAgenti.updateNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//		AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//		AlberoAgenti.abilitaAlbero();
	}
	

	public void cancellaAgente(String id){
		
	}



	public void btnCerca() throws PersistentException {

		PrimaryView.getInstance().resetPannelloCentraleAgente();
		PrimaryView.getInstance().setSfondoAgente();
		
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
		
		PrimaryView.getInstance().resetPannelloCentraleAgente();
		PrimaryView.initDettaglioAgente();
		//AlberoAgenti.disabilitaAlbero();
		PrimaryView.getInstance().setEnableCercaAgente(false);
	}
	
	
	public void esciNewAgente() {
		
		PrimaryView.getInstance().resetNuovoAgente();
		PrimaryView.getInstance().resetPannelloCentraleAgente();
		PrimaryView.getInstance().setSfondoAgente();
		PrimaryView.getInstance().setEnableCercaAgente(true);
		PrimaryView.getInstance().setVisibleErroreNuovoAgente(false);
//		AlberoAgenti.abilitaAlbero();
		}
	
	
	public void recuperaAgente(int idAgente)throws PersistentException{
		
		PrimaryView.getInstance().resetPannelloCentraleAgente();
		
		M_Agente agente = M_Agente.cercaAgenteRemoto(idAgente);
		
		Ricerca_agente.getInstance().dispose();
		Ricerca_agente.cancInstanza();
		
		PrimaryView.initRiepilogoAgenteView();
		PrimaryView.getInstance().setSchedaAgente(""+agente.getIdAgente(), agente.getCognome(), agente.getNome(), ""+agente.getLivello(), agente.getCitta(), agente.getCap(), agente.getIndirizzo(), agente.getEmail(), agente.getCell(), agente.getUsername(), agente.getPassword());
		PrimaryView.getInstance().disattivaSalvaModificheAgente(false);
		PrimaryView.getInstance().disattivaAnnullaModificheAgente(false);
		PrimaryView.getInstance().setVisibleErroreRiepAgente(false);
//		AlberoClienti.abilitaAlbero();
//		AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}
	
	public void abilitaModifica()
	{
		PrimaryView.getInstance().setModificheAgente(true);
		PrimaryView.getInstance().disattivaModificaAgente(false);
		PrimaryView.getInstance().disattivaCancellaAgente(false);
		PrimaryView.getInstance().disattivaInviaPostaAgente(false);
		PrimaryView.getInstance().disattivaSalvaModificheAgente(true);
		PrimaryView.getInstance().disattivaAnnullaModificheAgente(true);
		PrimaryView.getInstance().setEnableTabCatalogo(false);
		PrimaryView.getInstance().setEnableTabPreventivo(false);
		PrimaryView.getInstance().setVisibleErroreRiepAgente(false);
		PrimaryView.getInstance().setEnableNewAgente(false);
		PrimaryView.getInstance().setEnableCercaAgente(false);
		PrimaryView.getInstance().setVisibleToolTipAgente();
		//AlberoAgenti.disabilitaAlbero();
	}

	
}
