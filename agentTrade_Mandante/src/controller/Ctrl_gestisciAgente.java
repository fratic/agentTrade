package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.orm.PersistentException;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import util.Costanti;
import ui.PrimaryView;
import ui.content.agenti.AlberoAgenti;
import ui.content.agenti.Ricerca_agente;
import model.M_Agente;



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
		M_Agente.salvaAgente(agente); 
		
	}
	
	public void inserisciNuovoAgente(String nome, String cognome, String livello, String citta, String cap, String indirizzo, String email, String cell, String user, String psw) throws PersistentException
	{
//		Manca il controllo dei campi
		int lvl = Integer.parseInt(livello);
		M_Agente agente = new M_Agente(nome, cognome, psw, user, citta, indirizzo, lvl, cell, email, cap);
		M_Agente.salvaAgente(agente); 

		PrimaryView.getInstance().resetNuovoAgente();
		PrimaryView.getInstance().resetPannelloCentraleAgente();
				
		int id = M_Agente.getMaxId();
		recuperaAgente(id);
				
//		AlberoAgenti.inserisciNodo(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//		AlberoAgenti.selectNode(agente.getIdAgente()+ " - " +agente.getCognome()+ " - " +agente.getNome());
//		AlberoAgenti.abilitaAlbero();

		PrimaryView.getInstance().setEnableCercaAgente(true);
			
	}
	

	
	
	public void modificaCliente(int id, String nome, String cognome, String codFiscale, String partitaIva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax) throws PersistentException
	{
		
	}
	

	public void cancellaCliente(String id){
		
	}



	public void btnCerca() throws PersistentException {

		PrimaryView.getInstance().resetPannelloCentraleAgente();
		PrimaryView.getInstance().setSfondoAgente();
		
		Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgenti());
		
		Ricerca_agente.getInstance().setVisible(true);
	}

	
	public void ricercaAgente(String c, String lvl, String email, String city) throws PersistentException
	{
		if ((c.equals("") || c==null) && (lvl.equals("") || lvl==null) && (email.equals("") || email==null) && (city.equals("") || city==null)){
			
			Ricerca_agente.getInstance().popolaTab(M_Agente.caricaAgenti());
		}
		else {
			int livello =-1;

			if (!lvl.equals("") && lvl!=null){
				livello = Integer.parseInt(lvl);	
			}
			
			M_Agente [] listAgenti = M_Agente.caricaAgentiParametri(c, livello, email, city);
			
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
		
		M_Agente agente = M_Agente.cercaAgente(idAgente);
		
		Ricerca_agente.getInstance().dispose();
		Ricerca_agente.cancInstanza();
		
		PrimaryView.initRiepilogoAgenteView();
		PrimaryView.getInstance().setSchedaAgente(""+agente.getIdAgente(), agente.getCognome(), agente.getNome(), ""+agente.getLivello(), agente.getCitta(), agente.getCap(), agente.getIndirizzo(), agente.getEmail(), agente.getCell(), agente.getUsername(), agente.getPassword());
		PrimaryView.getInstance().disattivaSalvaModifiche(false);
		PrimaryView.getInstance().disattivaAnnullaModifiche(false);
		PrimaryView.getInstance().setVisibleErroreRiepAgente(false);
//		AlberoClienti.abilitaAlbero();
//		AlberoClienti.selectNode(cliente.getIdCliente()+ " - " +cliente.getCognome()+ " - " +cliente.getNome());
	}

	
}
