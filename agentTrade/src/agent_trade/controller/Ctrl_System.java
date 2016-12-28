package agent_trade.controller;

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;

import persistent.AgentTradePersistentManager;
import persistent.AgenteCriteria;
import persistent.ClienteCriteria;
import persistent.PreventivoCriteria;
import persistent.ProdottoCriteria;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.ui.LoginView;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.prodotti.ProdottiView;


public class Ctrl_System {

	/*Attributi di classe*/
	
	private static Ctrl_System instance;
	
	/*	la responsabilità di tenere l'istanza dell'agente loggato è stata assegnata ad crtl_system, in quanto è il creatore*/
	private static M_Agente instanceAgenteLog;

	/*Attributi privati*/

	
	/*costruttori*/
	
	
	/*metodi di classe*/
	
	public static Ctrl_System getInstance(){

		return ((instance == null) ? instance = new Ctrl_System() : instance);	
	}
	
	public static M_Agente getAgenteLog(){

		return ((instance == null) ? null : instanceAgenteLog);	
	}
	
	/*metodi privati*/
	
	public void initAlberoClienti() throws PersistentException{
	
		try{
			
		ClienteCriteria criteriaCliente= new ClienteCriteria();
		
		//JOIN per recuperare solo i clienti dell'agente loggato
		criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
		
		M_Cliente [] listClienti = criteriaCliente.listCliente();

		for (M_Cliente cLoad : listClienti) {
			AlberoClienti.inserisciNodo(cLoad.getIdCliente()+ " - " + cLoad.getCognome()+ " - " +cLoad.getNome());
		}
	}
		finally {
			persistent.AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	private void inizializzaSistema() throws PersistentException
	{
		//qui andrebbero inizializzati tutti gli oggetti che vogliamo siano presenti all'avvio

		initAlberoClienti();

		
		initProdotti();
		
		initAlberoPreventivi();	
		
		
	}
	
	private void initProdotti() throws PersistentException{
		
		M_Prodotto [] prodotti=null;
		try{
			
			ProdottoCriteria criteriaProdotto= new ProdottoCriteria();
			criteriaProdotto.setMaxResults(1000);
			prodotti = criteriaProdotto.listProdotto();
			ProdottiView.getInstance().initTable(prodotti);

		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	
	
	/*metodi pubblici*/
	
	public void initAlberoPreventivi() throws PersistentException{
		
		//ArrayList<M_Preventivo> preventivi= Dao_System.getInstance().loadPreventivi(getIdAgente());
	
		M_Preventivo [] preventivi=null;
		try{
			
			PreventivoCriteria criteriaPreventivi= new PreventivoCriteria();
			//criteriaPreventivi.rif_Agente.equals(getAgenteLog().);
			criteriaPreventivi.createCriteria("rif_Agente", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 

			criteriaPreventivi.setMaxResults(1000);
			preventivi = criteriaPreventivi.listPreventivo();

		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
		for (M_Preventivo p : preventivi) {

				AlberoPreventivi.inserisciNodo(p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome());	
		}
	}

	public void login(String user, String psw) throws PersistentException 
	{					
		try {

	
		AgenteCriteria AgenteCriteria = new AgenteCriteria();
		AgenteCriteria.nome.eq(user);
		
		M_Agente[] listAgenti= AgenteCriteria.listAgente();
		
		System.out.println("user e psw: ");

		//bisogna usare lo username e far si che questo sia univoco all'interno del db
		if (listAgenti.length==1)
		{
			M_Agente agLoad=(M_Agente)listAgenti[0];		

			if (agLoad.getNome().equals(user) & agLoad.getPassword().equals(psw))
			{
				
				PrimaryView.getInstance().setVisible(true);
				LoginView.getInstance().setVisible(false);
				instanceAgenteLog=agLoad;
				
				inizializzaSistema();
				
				}
				else{
				LoginView.getInstance().setMex("Login errato");
			}
		}
		else
		{
			LoginView.getInstance().setMex("Utente sconosciuto");
		}	
		}
		finally {
			//AgentTradePersistentManager.instance().disposePersistentManager();
		}
	}
	
	public int getIdAgente(){
				
		return instanceAgenteLog.getIdAgente();
	}
	
}