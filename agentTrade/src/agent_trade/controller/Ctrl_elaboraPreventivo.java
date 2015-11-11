package agent_trade.controller;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Iterator;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.ItemPreventivoView;


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
		
		//si pu� pensare di avere una funzione setIntestazione con tutti i relatvi parametri
		PrimaryView.getInstance().setIntestAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		PrimaryView.getInstance().setIntestData(M_Preventivo.getInstance().getData());
		PrimaryView.getInstance().setIntestNumPrev(/*M_Preventivo.getInstance().getNumPreventivo()*/"3");
		//fare un metodo di classe per il numero di preventivi 
		
		PrimaryView.getInstance().setIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());
		
	}

	public void addItem(int IdProdotto) {
		M_Prodotto p=Dao_System.getInstance().loadProdotto(IdProdotto);
		//M_Preventivo_Item = new M_Preventivo_Item(1, 1, rifPreventivo, idProdotto)
		M_Preventivo.getInstance().addItem(1,1,p);
		ItemPreventivoView.getInstance().updateTable("rim",Integer.toString(p.getIdProdotto()), p.getNome(), p.getCategoria(), "1", Float.toString(p.getPrezzo()), "1");
		
		float a=M_Preventivo.calcolaTotale();
		System.out.println("Totale fattura: "+a);
		ItemPreventivoView.getInstance().setImponibile(Float.toString(a));
		float c=(float) (a*0.22);
		ItemPreventivoView.getInstance().setIva(Float.toString(c));
		ItemPreventivoView.getInstance().setTotale(Float.toString(a+c));

		
		
	}

	public void salvaPreventivo() {
		
		
		M_Preventivo.getInstance();
		Dao_System.getInstance().salvaPreventivo(M_Preventivo.getInstance());
		
		
		//da cancellare, fatto solo per prova
		ArrayList a = Dao_System.loadPreventivi();
		
		Iterator iteraPreventivi = a.iterator();
		while (iteraPreventivi.hasNext()) {				

		M_Preventivo prev= (M_Preventivo) iteraPreventivi.next();
		System.out.println("LOAD: id:"+prev.getIdPreventivo()+" data: "+prev.getData()+" totale: "+prev.calcolaTotale()+
				"cognome agente: "+prev.getRif_Agente().getCognome()+" cliente: "+prev.getRif_Cliente().getCognome()+
				" "+prev.getRif_Cliente().getNome());
		
		ArrayList<M_Preventivo_Item> a_pr_it= prev.getElencoItem();
		Iterator iteraPrevItem = null;
		iteraPrevItem = (Iterator) a_pr_it.iterator();
		M_Preventivo_Item pr_it;
		while (iteraPrevItem.hasNext()) {				
			pr_it = (M_Preventivo_Item) iteraPrevItem.next();
			System.out.println("Prev item: idprod"+pr_it.getIdProdotto().getIdProdotto()+" quantita "+pr_it.getQuantita()+
					" nome prodotto "+pr_it.idProdotto.getNome()+" prezzo "+pr_it.getIdProdotto().getPrezzo());
		
		}
		}

		
		
	}
	
	public void annullaPreventivo(){
		//andrebbe annullato il preventivo in corso, nel senso cancellato dal db
		
		//si pu� pensare di avere una funzione in primary view che fa tutte queste cose e da qui si richiama con i parametri
		PrimaryView.getInstance().setEnableNewPreventivo(true);
		PrimaryView.getInstance().setEnableTabCliente(true);
		PrimaryView.getInstance().setVisibleIntestazione(false);
		PrimaryView.getInstance().setVisibleItemPreventivi(false);

	}
	
}