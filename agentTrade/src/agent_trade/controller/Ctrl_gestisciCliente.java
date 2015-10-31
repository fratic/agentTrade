package agent_trade.controller;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.CercaClienteView;
import agent_trade.ui.LoginView;
import agent_trade.ui.PrimaryView;


public class Ctrl_gestisciCliente {

	private static Ctrl_gestisciCliente instance;

	public static Ctrl_gestisciCliente getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciCliente() : instance);	
	}
	
	public void cercaCliente(String c) {

		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		

		if (cliente!=null )//&& cliente.getCognome().equals(c))
			{
				//CercaClienteView.getInstance().setVisible(true);
			//secondo me andrebbe fatta una funzione in view a cui si passa un container
			//JTable t =  CercaClienteView.getInstance().getTableInstance();
			/*t.setValueAt(cliente.getCognome(), 0, 0);   
			t.setValueAt(cliente.getNome(), 0, 1);  
			t.setValueAt(cliente.getCodice_fiscale(), 0, 2);  
			t.setValueAt(cliente.getIndirizzo(), 0, 3);  
			t.setValueAt(cliente.getEmail(), 0, 4);  */
			
            ((DefaultTableModel) CercaClienteView.getInstance().JTableModel).addRow(new Object[]{cliente.getCognome(),cliente.getNome(),cliente.getCodice_fiscale(),cliente.getIndirizzo(),cliente.getEmail()});
			
			//System.out.println("cliente trovato: "+cliente.getCognome()+" "+cliente.getNome()+" "+cliente.getIndirizzo());

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

	/*
		if (cliente!=null && cliente.getCognome().equals(c))
			{
				//CercaClienteView.getInstance().setVisible(true);
			JTable t =  CercaClienteView.getInstance().getTableInstance();
			t.setValueAt(cliente.getCognome(), 0, 0);   
			t.setValueAt(cliente.getNome(), 0, 1);  
			t.setValueAt(cliente.getCodice_fiscale(), 0, 2);  
			t.setValueAt(cliente.getIndirizzo(), 0, 3);  
			t.setValueAt(cliente.getEmail(), 0, 4);  

			System.out.println("cliente trovato: "+cliente.getCognome()+" "+cliente.getNome()+" "+cliente.getIndirizzo());

			}
			else{
				System.out.println("cliente non trovato");
			}*/
			
	
	}
