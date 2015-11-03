package agent_trade.controller;

import java.util.Calendar;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.NuovoPreventivoView;


public class Ctrl_elaboraPreventivo {

	private static Ctrl_elaboraPreventivo instance;
	private Calendar cal = Calendar.getInstance();

	public static Ctrl_elaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new Ctrl_elaboraPreventivo() : instance);	
	}
		
	public void newPreventivo(M_Agente a) {
	
		M_Preventivo.getInstance().setRif_Agente(a);
		M_Preventivo.getInstance().setData((String)(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)));	//la data andr� recuperata dal sistema e comprender� anche l'orario
		System.out.print("Prev fatto da: "+M_Preventivo.getInstance().getRif_Agente().getCognome()+" in data "+M_Preventivo.getInstance().getData());

		
		
		//andrebbe richamato il caso d'uso cerca cliente
		/*
		CercaClienteView.getInstance().popolaTab(Ctrl_gestisciCliente.getInstance().caricaClienti());
		CercaClienteView.getInstance().setVisible(true);*/
		
		Ctrl_gestisciCliente.getInstance().apriViewCliente();
	}

	public void inserisciCliente(String c) {
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		M_Preventivo.getInstance().setRif_Cliente(cliente);
		System.out.println("preventivo al cliente"+M_Preventivo.getInstance().getRif_Cliente().getCognome());
		CercaClienteView.getInstance().setVisible(false);
		PrimaryView.getInstance().setEnableNewPreventivo(false);
		PrimaryView.getInstance().setVisibleIntestazione(true);
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setData(M_Preventivo.getInstance().getData());
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setNumPrev(/*M_Preventivo.getInstance().getNumPreventivo()*/"3");
		//fare un metodo di classe per il numero di preventivi 
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());


		
	}

	public void addItem(Object aIdProdotto, Object aIdDescrizione, Object aQuantit�) {
		throw new UnsupportedOperationException();
	}

	public void salvaPreventivo() {
		throw new UnsupportedOperationException();
	}
}