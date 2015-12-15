package agent_trade.controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoItemPreventivoView;
import agent_trade.ui.content.prodotti.ProdottiView;

public class Ctrl_elaboraPreventivo {

	/*attributi di classe*/
	private static Ctrl_elaboraPreventivo instance;
	private static Map<Integer, JButton> elencoBottDisat=new TreeMap<>();
	
	
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
		
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(c,Ctrl_System.getInstance().getIdAgente());
		M_Preventivo.getInstance().setRif_Cliente(cliente);
		
		CercaClienteView.getInstance().dispose();
		CercaClienteView.cancInst();				

		PrimaryView.initIntestazione();
		PrimaryView.initItem();

		PrimaryView.getInstance().setEnableNewPreventivo(false);
		PrimaryView.getInstance().setEnableTabCliente(false);
		PrimaryView.getInstance().setEnableSalva(false);
		
		AlberoPreventivi.disabilitaAlbero();
		
		//si può pensare di avere una funzione setIntestazione con tutti i relatvi parametri
		PrimaryView.getInstance().setNewIntestAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		PrimaryView.getInstance().setNewIntestData(M_Preventivo.getInstance().getData());
		PrimaryView.getInstance().setNewIntestNumPrev(M_Preventivo.getInstance().getIdPreventivo());
		
		PrimaryView.getInstance().setNewIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());
		ProdottiView.getInstance().enableBottoni();
	}


	//CO3
	public void addItem(int IdProdotto, JButton jb) {
		
		
		M_Prodotto p=Dao_System.getInstance().loadProdotto(IdProdotto);
		M_Preventivo.getInstance().addItem(p);
		
		if (!M_Preventivo.getInstance().getElencoItem().isEmpty()){
			PrimaryView.getInstance().setEnableSalva(true);
		}
		
		ItemNuovoPreventivoView.getInstance().updateTable(null,p.getIdProdotto(), p.getNome(), p.getCategoria(),1, Float.toString(p.getPrezzo()), Float.toString(p.getPrezzo()));
		
		elencoBottDisat.put(p.getIdProdotto(), jb);
		jb.setEnabled(false);
		
		//fare funzione
		float a=M_Preventivo.getInstance().calcolaTotale();
		ItemNuovoPreventivoView.getInstance().setImponibile(Float.toString(a));
		float c=(float) (a*0.22);
		ItemNuovoPreventivoView.getInstance().setIva(Float.toString(c));
		ItemNuovoPreventivoView.getInstance().setTotale(Float.toString(a+c));
	}

	
	//CO4
	public void salvaPreventivo() {
		
		M_Preventivo p= M_Preventivo.getInstance();
		Dao_System.getInstance().salvaPreventivo(p);
		String nodo=p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome();
	
		if (!AlberoPreventivi.controllaEsistenza(nodo)){
			AlberoPreventivi.inserisciNodo(nodo);
		}
		AlberoPreventivi.selezionaNodo(nodo);

		
		PrimaryView.getInstance().setEnableNewPreventivo(true);
		PrimaryView.getInstance().setEnableTabCliente(true);

		PrimaryView.getInstance().setVisibleIntestazione(false);
		PrimaryView.getInstance().setVisibleItemPreventivi(false);

		PrimaryView.cancIntestazione();
		PrimaryView.cancItem();
		
		M_Preventivo.cancIstanza();	
		
		Dao_System.getInstance().salvaIdPrev(M_Preventivo.getNumprev());

		AlberoPreventivi.abilitaAlbero();

		elencoBottDisat.clear();
		ProdottiView.getInstance().disableBottoni();
		
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
		
		int id=M_Preventivo.getNumprev();
		id--;
		M_Preventivo.setNumprev(id);
		Dao_System.getInstance().salvaIdPrev(id);		
		M_Preventivo.cancIstanza();
		AlberoPreventivi.abilitaAlbero();

		elencoBottDisat.clear();
		ProdottiView.getInstance().disableBottoni();

		
	}
	
	public void riepilogoPreventivo(Object obj)
	{
		String id=obj.toString();
		if(((DefaultMutableTreeNode)obj).isLeaf())
		{
			id= (id.substring(0,2));
			id=id.replaceAll("-","");
			id=id.replaceAll(" ","");

			M_Preventivo m= Dao_System.getInstance().loadPreventivo(id);

			PrimaryView.initRiepilogo();

			PrimaryView.getInstance().setRiepIntestAgente(m.getRif_Agente().getCognome()+" "+m.getRif_Agente().getNome());
			PrimaryView.getInstance().setRiepIntestData(m.getData());
			PrimaryView.getInstance().setRiepIntestNumPrev(m.getIdPreventivo());
			
			PrimaryView.getInstance().setRiepIntestCliente(m.getRif_Cliente().getCognome(),m.getRif_Cliente().getNome(), m.getRif_Cliente().getIndirizzo(), m.getRif_Cliente().getEmail());
			ArrayList<M_Preventivo_Item> elementi = m.getElencoItem();

			Iterator<M_Preventivo_Item> i = elementi.iterator();
			M_Preventivo_Item pr_it =null;
			while (i.hasNext()) {
				pr_it = (M_Preventivo_Item) i.next();
				PrimaryView.getInstance().updateTableRiepilogo(Integer.toString((pr_it.getIdProdotto().getIdProdotto())), pr_it.getIdProdotto().getNome(), pr_it.getIdProdotto().getCategoria(), Integer.toString(pr_it.getQuantita()), Float.toString(pr_it.getIdProdotto().getPrezzo()), Float.toString(pr_it.getQuantita()* pr_it.getIdProdotto().getPrezzo()));
			}
			
			RiepilogoIntestazionePreventivoView.getInstance().setId_Preventivo(Integer.parseInt(m.getIdPreventivo()));

			
			float importo=m.calcolaTotale();
			RiepilogoItemPreventivoView.getInstance().setImponibile(Float.toString(importo));
			float c=(float) (importo*0.22);
			RiepilogoItemPreventivoView.getInstance().setIva(Float.toString(c));
			RiepilogoItemPreventivoView.getInstance().setTotale(Float.toString(importo+c));

		}
		else{
			
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
			//volendo si può mettere un pannello con uno sfondo quando non c'è nulla visualizzato
		}
	}
	
	public void refresh(Observable obs, M_Preventivo p){
		M_Preventivo_Item pr_it=(M_Preventivo_Item)obs;
		
		//fare una funzione per questo, ovunque viene usato
		float importo=p.calcolaTotale();
		ItemNuovoPreventivoView.getInstance().setImponibile(Float.toString(importo));
		float c=(float) (importo*0.22);
		ItemNuovoPreventivoView.getInstance().setIva(Float.toString(c));
		ItemNuovoPreventivoView.getInstance().setTotale(Float.toString(importo+c));

		M_Prodotto prod=pr_it.getIdProdotto();
		ItemNuovoPreventivoView.getInstance().updateRow(pr_it.getQuantita()*prod.getPrezzo());

	}


	public void addQuant(int id, int qt, int row) {

		M_Preventivo p =M_Preventivo.getInstance();
		p.addQuant(id,qt);
		
		//SAREBBE OPPORTUNO PASSARE L'ID DELL'ITEM, E NON QUELLO DAL PRODOTTO, MA PER IL MOMENTO, 
		//NON AVENDO IL DB, SI PROSEGUE COSI 

	}

	
	public void rimuoviItem(final int id, final int row) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				M_Preventivo p =M_Preventivo.getInstance();
				p.removeItem(id);
				ItemNuovoPreventivoView.getInstance().deleteRow(row);
								
				JButton jb=elencoBottDisat.get(id);
				if (jb!=null){
				jb.setEnabled(true);
				elencoBottDisat.remove(id);
				}
				if (M_Preventivo.getInstance().getElencoItem().isEmpty()){
					PrimaryView.getInstance().setEnableSalva(false);
				}
				else{
					PrimaryView.getInstance().setEnableSalva(true);
				}
	
			}
		});
	}


	public void modificaPreventivo(int id_Preventivo){

		
//		Bisogna controllare se il preventivo è ancora valido, ed in caso affermativo, 
//		bisogna mantentere i prezzi del preventivo originario
//		in caso negativo, comunicarlo oppure non attivare il bottone di modifica preventivamente
				
		M_Preventivo.setNumprev(M_Preventivo.getNumprev()+1);
		
		M_Preventivo prev=Dao_System.getInstance().loadPreventivo(Integer.toString(id_Preventivo));
		M_Cliente cliente=Dao_System.getInstance().cercaCliente(prev.getRif_Cliente().getCognome(),Ctrl_System.getInstance().getIdAgente());//questo andrà cambiato
	
		M_Preventivo prevMod= M_Preventivo.getInstance(prev);
		
		PrimaryView.getInstance().resetPannelloCentralePreventivo();
		PrimaryView.initIntestazione();
		PrimaryView.initItem();

		PrimaryView.getInstance().setEnableNewPreventivo(false);
		PrimaryView.getInstance().setEnableTabCliente(false);
		PrimaryView.getInstance().setEnableSalva(true);

		AlberoPreventivi.disabilitaAlbero();
				
		PrimaryView.getInstance().setNewIntestAgente(prevMod.getRif_Agente().getCognome()+" "+prevMod.getRif_Agente().getNome());
		PrimaryView.getInstance().setNewIntestData(prevMod.getData());
		PrimaryView.getInstance().setNewIntestNumPrev(prevMod.getIdPreventivo());
		
		PrimaryView.getInstance().setNewIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());

		ProdottiView.getInstance().enableBottoni();
				
		ArrayList<M_Preventivo_Item> elencoItem = prev.getElencoItem();

		Iterator<M_Preventivo_Item> i = elencoItem.iterator();
		M_Preventivo_Item pr_it =null;
		M_Prodotto p=null;
		Map<Integer, JButton> elencoBott=null;
		JButton jb=null;
		while (i.hasNext()) {
			pr_it = (M_Preventivo_Item) i.next();
			p=pr_it.getIdProdotto();
			ItemNuovoPreventivoView.getInstance().updateTable(null,p.getIdProdotto(), p.getNome(), p.getCategoria(), pr_it.getQuantita(), Float.toString(p.getPrezzo()), Float.toString(p.getPrezzo()*pr_it.getQuantita()));

			elencoBott=ProdottiView.elencoBottoniProdotti();
			jb=elencoBott.get(p.getIdProdotto());
			elencoBottDisat.put(p.getIdProdotto(), jb);
			jb.setEnabled(false);
		}

		float importo=prevMod.calcolaTotale();
		ItemNuovoPreventivoView.getInstance().setImponibile(Float.toString(importo));
		float c=(float) (importo*0.22);
		ItemNuovoPreventivoView.getInstance().setIva(Float.toString(c));
		ItemNuovoPreventivoView.getInstance().setTotale(Float.toString(importo+c));

	}


	public void cancellaPreventivo(int id_Preventivo) {
		
		AlberoPreventivi.cancellaNodo();
		Dao_System.getInstance().cancPreventivo(Integer.toString(id_Preventivo));
		PrimaryView.getInstance().resetPannelloCentralePreventivo();
	}
	
}