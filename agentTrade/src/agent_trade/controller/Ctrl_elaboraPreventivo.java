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
import agent_trade.ui.content.AlberoPreventivi;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.ItemPreventivoView;
import agent_trade.ui.content.RiepilogoItemPreventivoView;

public class Ctrl_elaboraPreventivo {

	/*attributi di classe*/
	private static Ctrl_elaboraPreventivo instance;

	/*attributi privati*/
	private Calendar cal = Calendar.getInstance();

	
	/*costruttori*/
	
	/*metodi di classe*/
	
	public static Ctrl_elaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new Ctrl_elaboraPreventivo() : instance);	
	}
	
	
	/*metodi privati*/
	
	/*metodi pubblici*/
		
	//CO1
	public void newPreventivo(M_Agente a) {
	
		PrimaryView.getInstance().resetPannelloCentralePreventivo();
		
		M_Preventivo.getInstance().setRif_Agente(a);
		M_Preventivo.getInstance().setData((String)(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)));	//la data andrà recuperata dal sistema e comprenderà anche l'orario
		Ctrl_gestisciCliente.getInstance().apriViewCercaCliente();
	}

	//CO2
	public void inserisciCliente(String c) {
		//in futuro, sarebbe più utile passare un oggetto cliente c 
		//e non una string con il cognome oppure l'id del cliente
		
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c);
		M_Preventivo.getInstance().setRif_Cliente(cliente);
		
		CercaClienteView.getInstance().dispose();
		CercaClienteView.cancInst();				

		PrimaryView.initIntestazione();
		PrimaryView.initItem();

		PrimaryView.getInstance().setEnableNewPreventivo(false);
		PrimaryView.getInstance().setEnableTabCliente(false);
		
		AlberoPreventivi.disabilitaAlbero();
				
		//decidere se far fare quanto segue al controller o se dare da responsabilità a qualcun altro 
		//(es, uno strato di indirezione) altrimenti si può pensare di avere una funzione che setta tutto ciò, ma forse
		//aumenterebbe l'accoppiamentotra il controller e la view
		//sarebbe una buona idea fare una funzione in primary view per settare nel pannello intestazione i parametri necessari 
		
		
		//si può pensare di avere una funzione setIntestazione con tutti i relatvi parametri
		PrimaryView.getInstance().setNewIntestAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		PrimaryView.getInstance().setNewIntestData(M_Preventivo.getInstance().getData());
		PrimaryView.getInstance().setNewIntestNumPrev(M_Preventivo.getInstance().getIdPreventivo());
		//fare un metodo di classe per il numero di preventivi 
		
		PrimaryView.getInstance().setNewIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());
	}

	
	public void addItem(int IdProdotto) {
		
		
		M_Prodotto p=Dao_System.getInstance().loadProdotto(IdProdotto);
		M_Preventivo.getInstance().addItem(1,1,p);
		ItemPreventivoView.getInstance().updateTable("rim",Integer.toString(p.getIdProdotto()), p.getNome(), p.getCategoria(), "1", Float.toString(p.getPrezzo()), "1");
		
		float a=M_Preventivo.getInstance().calcolaTotale();
		System.out.println("Totale fattura: "+a);
		ItemPreventivoView.getInstance().setImponibile(Float.toString(a));
		float c=(float) (a*0.22);
		ItemPreventivoView.getInstance().setIva(Float.toString(c));
		ItemPreventivoView.getInstance().setTotale(Float.toString(a+c));
	}

	
	public void salvaPreventivo() {
		
		M_Preventivo p= M_Preventivo.getInstance();
		Dao_System.salvaPreventivo(p);
		
		AlberoPreventivi.inserisciNodo(p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome());
		
		PrimaryView.getInstance().setEnableNewPreventivo(true);
		PrimaryView.getInstance().setEnableTabCliente(true);

		PrimaryView.getInstance().setVisibleIntestazione(false);
		PrimaryView.getInstance().setVisibleItemPreventivi(false);

		PrimaryView.cancIntestazione();
		PrimaryView.cancItem();
		
		M_Preventivo.cancIstanza();	
		
		Dao_System.salvaIdPrev(Integer.parseInt(p.getIdPreventivo()));
		AlberoPreventivi.abilitaAlbero();

	}
	
	public void annullaPreventivo()
	{		
		//si può pensare di avere una funzione in primary view che fa tutte queste cose e da qui si richiama con i parametri
		PrimaryView.getInstance().setEnableNewPreventivo(true);
		PrimaryView.getInstance().setEnableTabCliente(true);
		PrimaryView.getInstance().setVisibleIntestazione(false);
		PrimaryView.getInstance().setVisibleItemPreventivi(false);
		
		PrimaryView.cancIntestazione();
		PrimaryView.cancItem();
		
		M_Preventivo p =M_Preventivo.getInstance();
		int id=Integer.parseInt(p.getIdPreventivo());
		id--;
		Dao_System.salvaIdPrev(id);		
		M_Preventivo.cancIstanza();
		AlberoPreventivi.abilitaAlbero();
	}
	
	public void riepilogoPreventivo(Object obj)
	{
		String id=obj.toString();
		if (!id.substring(0,1).equals("*"))
		{
			id= (id.substring(0,2));
			id=id.replaceAll("-","");
			id=id.replaceAll(" ","");

			M_Preventivo m= Dao_System.loadPreventivo(id);

			PrimaryView.initRiepilogo();

			PrimaryView.getInstance().setRiepIntestAgente(m.getRif_Agente().getCognome()+" "+m.getRif_Agente().getNome());
			PrimaryView.getInstance().setRiepIntestData(m.getData());
			PrimaryView.getInstance().setRiepIntestNumPrev(m.getIdPreventivo());
			//fare un metodo di classe per il numero di preventivi 
			
			PrimaryView.getInstance().setRiepIntestCliente(m.getRif_Cliente().getCognome(),m.getRif_Cliente().getNome(), m.getRif_Cliente().getIndirizzo(), m.getRif_Cliente().getEmail());
			ArrayList<M_Preventivo_Item> elementi = m.getElencoItem();

			Iterator<M_Preventivo_Item> i = elementi.iterator();
			M_Preventivo_Item pr_it =null;
			while (i.hasNext()) {
				pr_it = (M_Preventivo_Item) i.next();
				PrimaryView.getInstance().updateTableRiepilogo("rem",Integer.toString((pr_it.getIdProdotto().getIdProdotto())), pr_it.getIdProdotto().getNome(), pr_it.getIdProdotto().getCategoria(), Integer.toString(pr_it.getQuantita()), Float.toString(pr_it.getIdProdotto().getPrezzo()), Float.toString(pr_it.getQuantita()* pr_it.getIdProdotto().getPrezzo()));
		
			}
			
			float importo=m.calcolaTotale();
			RiepilogoItemPreventivoView.getInstance().setImponibile(Float.toString(importo));
			float c=(float) (importo*0.22);
			RiepilogoItemPreventivoView.getInstance().setIva(Float.toString(c));
			RiepilogoItemPreventivoView.getInstance().setTotale(Float.toString(importo+c));

		}
		else{
			
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
			//volendo si può mettere uno sfondo quando non c'è nulla visualizzato
		}
	}
	
}