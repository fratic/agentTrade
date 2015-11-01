package agent_trade.controller;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.CercaClienteView;


public class Ctrl_gestisciCliente {

	private static Ctrl_gestisciCliente instance;

	public static Ctrl_gestisciCliente getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciCliente() : instance);	
	}
	
	public void cercaCliente(String c) {

		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		
		if (cliente!=null )
		{
			((DefaultTableModel) CercaClienteView.getInstance().JTableModel).addRow(new Object[]{cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getIndirizzo(),cliente.getEmail()});
		}
		else{		
				CercaClienteView.getInstance().setErrore("Cliente non trovato");
				System.out.println("cliente non trovato");
		}
	}
	
	//bisogna decidere il criterio di caricamento
	public ArrayList caricaClienti() {

		ArrayList clienti=Dao_System.getInstance().caricaClienti();
		Iterator iteraClienti = null;
		
		iteraClienti = clienti.iterator();
		M_Cliente c = new M_Cliente();
		while (iteraClienti.hasNext()) {
			c = (M_Cliente) iteraClienti.next();
			System.out.println (c.getCognome());	
			}
		return clienti;
	}			
	
}
