package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;

import org.orm.PersistentException;







//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import util.Costanti;
import ui.PrimaryView;
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
	
	
	public void nuovoAgente(String nome, String cognome, String username, String password, String citta, String cap, String indirizzo, String email, String cell, int livello) throws PersistentException
	{
		M_Agente agente = new M_Agente(nome, cognome, password, username, citta, indirizzo, livello, cell, email, cap);
		M_Agente.salvaAgente(agente); 
		
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
		
	}
	

	
}
