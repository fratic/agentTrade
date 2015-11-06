package agent_trade.controller;

import java.util.ArrayList;
import java.util.Iterator;

import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.content.CercaClienteView;

public class Ctrl_gestisciCliente {

	private static Ctrl_gestisciCliente instance;

	public static Ctrl_gestisciCliente getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciCliente() : instance);	
	}
	
	public void cercaCliente(String c) {

		apriViewCercaCliente();
		
		if (c== "" || c==null){
			CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		}
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		
		if (cliente!=null )
		{
			CercaClienteView.getInstance().updateTable(cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getIndirizzo(),cliente.getEmail());
	
		}
		else{		
				CercaClienteView.getInstance().setErrore("Cliente non trovato");
		}
	}
	
	//bisogna decidere il criterio di caricamento. Decidere se è adeguata questa struttura dati
	public ArrayList caricaClienti() {

		ArrayList clienti=Dao_System.getInstance().caricaClienti();

		return clienti;
	}
	

	public void apriViewCercaCliente(){
		
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);
	} 
	
	public void caricaAlberoClienti(){
		
	//	PrimaryView.getInstance().initAlberoClienti();
		ArrayList clienti = caricaClienti();
		Iterator iteraClienti = null;
		iteraClienti = clienti.iterator();
		M_Cliente c = new M_Cliente();

		/*while (iteraClienti.hasNext()) {
			c = (M_Cliente) iteraClienti.next();
			System.out.println ("in carica albero clienti"+c.getCognome()+" "+c.getNome());	
			
		*/			
							/*DefaultMutableTreeNode node_1;
							node_1 = new DefaultMutableTreeNode((String)(c.getCognome()+" "+c.getNome()));
								*/
								/*node_1.add(new DefaultMutableTreeNode("blfdfue"));
								node_1.add(new DefaultMutableTreeNode("viodflet"));
								node_1.add(new DefaultMutableTreeNode("rdfded"));
								node_1.add(new DefaultMutableTreeNode("yfdfdfellow"));*/
							
						//	PrimaryView.getInstance().initAlberoClienti(node_1);
				
		//////
						/*	DefaultTreeModel modello=	new DefaultTreeModel(
									new DefaultMutableTreeNode("Elenco Clienti") 
										{
											while (iteraClienti.hasNext()) {
												c = (M_Cliente) iteraClienti.next();
												//System.out.println ("in carica albero clienti"+c.getCognome()+" "+c.getNome());	
												
														
																DefaultMutableTreeNode node_1;
																node_1 = new DefaultMutableTreeNode((String)(c.getCognome()+" "+c.getNome()));
																	
											DefaultMutableTreeNode node_1;
											node_1 = new DefaultMutableTreeNode(""+c.getCognome()+" "+c.getNome());
												node_1.add(new DefaultMutableTreeNode("blfdfue"));
												node_1.add(new DefaultMutableTreeNode("viodflet"));
												node_1.add(new DefaultMutableTreeNode("rdfded"));
												node_1.add(new DefaultMutableTreeNode("yfdfdfellow"));
											add(node_1);
										}
									}
								);			*/		
							
							//PrimaryView.getInstance().initAlberoClienti(modello);
							
	}	
}
