package agent_trade.controller;

import java.util.Calendar;

import javax.swing.JDialog;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.IntestazioneNuovoPreventivoView;


public class Ctrl_elaboraPreventivo {

	private static Ctrl_elaboraPreventivo instance;
	private Calendar cal = Calendar.getInstance();

	public static Ctrl_elaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new Ctrl_elaboraPreventivo() : instance);	
	}
		
	//CO1
	public void newPreventivo(M_Agente a) {
	
		M_Preventivo.getInstance().setRif_Agente(a);
		M_Preventivo.getInstance().setData((String)(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)));	//la data andr� recuperata dal sistema e comprender� anche l'orario
		Ctrl_gestisciCliente.getInstance().apriViewCercaCliente();
	}

	//CO2
	public void inserisciCliente(String c) {//in futuro, sarebbe pi� utile passare un oggetto cliente c e non una string con il cognome
		
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		M_Preventivo.getInstance().setRif_Cliente(cliente);
		CercaClienteView.getInstance().setVisible(false);
		PrimaryView.getInstance().setEnableNewPreventivo(false);
		PrimaryView.getInstance().setEnableTabCliente(false);

		PrimaryView.getInstance().setVisibleIntestazione(true);
		PrimaryView.getInstance().setVisibleItemPreventivi(true);
		
		//decidere se far fare quanto segue al controller o se dare da responsabilit� a qualcun altro 
		//(es, uno strato di indirezione) altrimenti si pu� pensare di avere una funzione che setta tutto ci�, ma forse
		//aumenterebbe l'accoppiamentotra il controller e la view
		//sarebbe una buona idea fare una funzione in primary view per settare nel pannello intestazione i parametri necessari 
		
		/*
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setData(M_Preventivo.getInstance().getData());
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setNumPrev(/*M_Preventivo.getInstance().getNumPreventivo()//"3");
		//fare un metodo di classe per il numero di preventivi 
		
		((NuovoPreventivoView) PrimaryView.getInstance().getInstanceIntestazione()).setCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());
		*/
		PrimaryView.getInstance().setIntestAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		PrimaryView.getInstance().setIntestData(M_Preventivo.getInstance().getData());
		PrimaryView.getInstance().setIntestNumPrev(/*M_Preventivo.getInstance().getNumPreventivo()*/"3");
		//fare un metodo di classe per il numero di preventivi 
		
		PrimaryView.getInstance().setIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());
		
	}

	public void addItem(String IdProdotto) {
		System.out.println("idprodotto "+IdProdotto);
	//	M_Prodotto p=Dao_System.getInstance().loadProdotto(IdProdotto);
		
		
	}

	public void salvaPreventivo() {
		throw new UnsupportedOperationException();
	}
	
	public void annullaPreventivo(){
		//andrebbe annullato il preventivo in corso, nel senso cancellato dal db
		
		PrimaryView.getInstance().setEnableNewPreventivo(true);
		PrimaryView.getInstance().setEnableTabCliente(true);
		PrimaryView.getInstance().setVisibleIntestazione(false);
		PrimaryView.getInstance().setVisibleItemPreventivi(false);

	}
	
}