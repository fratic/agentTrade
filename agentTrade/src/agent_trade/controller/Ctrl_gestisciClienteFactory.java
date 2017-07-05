package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Cliente;
import agent_trade.util.Costanti;

public class Ctrl_gestisciClienteFactory {

/*attributi di classe*/
	
	private static Ctrl_gestisciClienteFactory instance;
	
	/*attributi privati*/

	
	/*costruttori*/
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciClienteFactory getInstance(){
		
		if(Costanti.version.equals(Costanti.agente)){
			instance = Ctrl_gestisciClienteAgente.getInstance();
		}
		else if(Costanti.version.equals(Costanti.mandante)){
			instance = Ctrl_gestisciClienteMandante.getInstance();
		}

		return instance;	
	}

	public String mostraScontoCliente(int sconto) throws PersistentException {
		// TODO Auto-generated method stub
		return null;
	}

	public void apriViewCercaCliente() throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void assegnaAgente(M_Cliente cliente, int idAgente) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void recuperaCliente(int idCliente) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void mostraCliente(Object obj) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void cercaCliente(String cognome) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void postConfermaCancCliente(String idCliente) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void notConfermaCancCliente() {
		// TODO Auto-generated method stub
		
	}

	public void inserisciNuovoCliente(M_Cliente cliente) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void esciNewCliente() {
		// TODO Auto-generated method stub
		
	}

	public void annullaRicercaCliente() {
		// TODO Auto-generated method stub
		
	}

	public void ricercaCliente(String c, String pi, String cf, String city) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void abilitaModifica() {
		// TODO Auto-generated method stub
		
	}

	public void cancellaCliente(String idCliente) {
		// TODO Auto-generated method stub
		
	}

	public void modificaCliente(M_Cliente cliente) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void annullaModificheCliente(String text) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void btnCercaSconto() throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void btnCercaAgente() throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void assegnaSconto(int idSconto) throws PersistentException {
		// TODO Auto-generated method stub
		
	}

	public void btnCerca() {
		// TODO Auto-generated method stub
		
	}

	public void newCliente() {
		// TODO Auto-generated method stub
		
	}
	
	
}
