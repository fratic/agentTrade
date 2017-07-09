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
		return null;
	}

	public void apriViewCercaCliente() throws PersistentException {
		
	}

	public void assegnaAgente(M_Cliente cliente, int idAgente) throws PersistentException {
		
	}

	public void recuperaCliente(int idCliente) throws PersistentException {
		
	}

	public void mostraCliente(Object obj) throws PersistentException {
		
	}

	public void cercaCliente(String cognome) throws PersistentException {
		
	}

	public void postConfermaCancCliente(String idCliente) throws PersistentException {
		
	}

	public void notConfermaCancCliente() {
		
	}

	public void inserisciNuovoCliente(M_Cliente cliente) throws PersistentException {
		
	}

	public void esciNewCliente() {
		
	}

	public void annullaRicercaCliente() {
		
	}

	public void ricercaCliente(String c, String pi, String cf, String city) throws PersistentException {
		
	}

	public void abilitaModifica() {
		
	}

	public void cancellaCliente(String idCliente) {
		
	}

	public void modificaCliente(M_Cliente cliente) throws PersistentException {
		
	}

	public void annullaModificheCliente(String text) throws PersistentException {
		
	}

	public void btnCercaSconto() throws PersistentException {
		
	}

	public void btnCercaAgente() throws PersistentException {
		
	}

	public void assegnaSconto(int idSconto) throws PersistentException {
		
	}

	public void btnCerca() {
		
	}

	public void newCliente() {
		
	}
	
}
