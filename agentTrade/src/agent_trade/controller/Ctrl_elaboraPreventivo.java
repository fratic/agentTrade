package agent_trade.controller;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.CercaClienteView;


public class Ctrl_elaboraPreventivo {

	private static Ctrl_elaboraPreventivo instance;

	public static Ctrl_elaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new Ctrl_elaboraPreventivo() : instance);	
	}
		
	public void newPreventivo(M_Agente a) {
	
		M_Preventivo.getInstance().setRif_Agente(a);
		M_Preventivo.getInstance().setData("30/10/2015");	//la data andr� recuperata dal sistema e comprender� anche l'orario
		System.out.print("Prev fatto da: "+M_Preventivo.getInstance().getRif_Agente().getCognome()+" in data "+M_Preventivo.getInstance().getData());
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);
	}

	public void inserisciCliente(String c) {
		M_Preventivo.getInstance().setRif_Cliente(Dao_System.getInstance().cercaCliente(c));
		System.out.println("preventivo al cliente"+M_Preventivo.getInstance().getRif_Cliente().getCognome());
	}

	public void addItem(Object aIdProdotto, Object aIdDescrizione, Object aQuantit�) {
		throw new UnsupportedOperationException();
	}

	public void salvaPreventivo() {
		throw new UnsupportedOperationException();
	}
}