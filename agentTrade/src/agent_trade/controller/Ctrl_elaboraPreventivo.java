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

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import persistent.AgentTradePersistentManager;
import persistent.ClienteCriteria;
import persistent.PreventivoCriteria;
import persistent.ProdottoCriteria;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;

//import agent_trade.persistentTemp.Dao_System;

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
	private final double IVA=0.22; //sarebbe più indicato averlo in un file di configurazione
	
	/*costruttori*/
	
	/*metodi di classe*/
	
	public static Ctrl_elaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new Ctrl_elaboraPreventivo() : instance);	
	}


	/*metodi pubblici*/
		
	//CO1
	public void newPreventivo(M_Agente a) throws PersistentException {
	
		PrimaryView.getInstance().resetPannelloCentralePreventivo();

		M_Preventivo.getInstance().setIdPrev();
//		M_Preventivo.setNumprev(M_Preventivo.getNumprev());

		M_Preventivo.getInstance().setRif_Agente(a);
		System.out.println("in controller: "+M_Preventivo.getNumprev());
//		M_Preventivo.getInstance().setData((String)(cal.get(Calendar.DATE)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR)));	//la data andrà recuperata dal sistema e comprenderà anche l'orario
		M_Preventivo.getInstance().setData(cal.getTime());

		Ctrl_gestisciCliente.getInstance().apriViewCercaCliente();
	}

	//CO2 
	public void inserisciCliente(int id_cliente) throws PersistentException {
		
		M_Cliente cliente=null;
		try{
			
			ClienteCriteria criteriaCliente= new ClienteCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
			criteriaCliente.idCliente.eq(id_cliente);
			
			cliente = criteriaCliente.listCliente()[0];

		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
					
		M_Preventivo.getInstance().setRif_Cliente(cliente);	
		
		//init della view
		initNuovoPreventivo(cliente);
	}


	//CO3
	public void addItem(int IdProdotto, JButton jb) throws PersistentException {
				
//		M_Prodotto p=Dao_System.getInstance().loadProdotto(IdProdotto);
		
		
		ProdottoCriteria criteria= new ProdottoCriteria();
		
		criteria.IdProdotto.eq(IdProdotto);
		M_Prodotto p = criteria.listProdotto()[0];
	
		M_Preventivo.getInstance().addItem(p);
		
		if (!M_Preventivo.getInstance().getElencoItem().isEmpty()){
			PrimaryView.getInstance().setEnableSalva(true);
		}
		
		ItemNuovoPreventivoView.getInstance().updateTable(null,p.getIdProdotto(), p.getNome(), p.getCategoria(),1, Float.toString(p.getPrezzo()), Float.toString(p.getPrezzo()));
		
		elencoBottDisat.put(p.getIdProdotto(), jb);
		jb.setEnabled(false);
		
		float imp=M_Preventivo.getInstance().calcolaTotale();
		float iva=(float)(imp*IVA);
		float tot=imp+iva;
		ItemNuovoPreventivoView.getInstance().setTot(imp, iva, tot);

	}

	
	//CO4
	public void salvaPreventivo() throws PersistentException {
		
		M_Preventivo p= M_Preventivo.getInstance();
//		Dao_System.getInstance().salvaPreventivo(p);
	
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{
			AgentTradePersistentManager.instance().getSession().save(p);	
			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
	
		//inizializza view dopo il salvataggio del preventivo
		initPostSalvaPrev(p);	
	}
	
	
	//OK	
	public void annullaPreventivo()
	{		
		initAnnullaPrev();
		
//		int id=M_Preventivo.getNumprev();
//		id--;
//		M_Preventivo.setNumprev(id);
//		Dao_System.getInstance().salvaIdPrev(id);		
//		M_Preventivo.cancIstanza();
		elencoBottDisat.clear();		
	}
	

	public void riepilogoPreventivo(Object obj) throws PersistentException
	{
		if(((DefaultMutableTreeNode)obj).isLeaf())
		{
			String id=obj.toString();
			id= (id.substring(0,2));
			id=id.replaceAll("-","");
			id=id.replaceAll(" ","");

//			M_Preventivo m= Dao_System.getInstance().loadPreventivo(id);
			
			PreventivoCriteria criteria= new PreventivoCriteria();
			
			criteria.idPreventivo.eq(id);
			M_Preventivo m = criteria.listPreventivo()[0];
			
			//inizializza view di riepilogo preventivo
			if (m!=null){
			initRiepilogoPreventivo(m);
			
			float imp=m.calcolaTotale();
			float iva=(float)(imp*IVA);
			float tot=imp+iva;
			RiepilogoItemPreventivoView.getInstance().setTot(imp, iva, tot);
			}
		}
		else{
			
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
			PrimaryView.getInstance().setSfondoPrev();
		}
	}
	

	public void refresh(Observable obs, M_Preventivo p) throws PersistentException{
		
		M_Preventivo_Item pr_it=(M_Preventivo_Item)obs;
		
		float imp=M_Preventivo.getInstance().calcolaTotale();
		float iva=(float)(imp*IVA);
		float tot=imp+iva;
		ItemNuovoPreventivoView.getInstance().setTot(imp, iva, tot);
		
		M_Prodotto prod=pr_it.getIdProdotto();
		ItemNuovoPreventivoView.getInstance().updateRow(pr_it.getQuantita()*prod.getPrezzo());

	}


	public void addQuant(int id, int qt, int row) throws PersistentException {

		M_Preventivo p =M_Preventivo.getInstance();
		p.addQuant(id,qt);
		
		//SAREBBE OPPORTUNO PASSARE L'ID DELL'ITEM, E NON QUELLO DAL PRODOTTO, MA PER IL MOMENTO, 
		//NON AVENDO IL DB, SI PROSEGUE COSI 
	}

	
	public void rimuoviItem(final int id, final int row) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				M_Preventivo p = null;
				try {
					p = M_Preventivo.getInstance();
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p.removeItem(id);
				ItemNuovoPreventivoView.getInstance().deleteRow(row);
								
				JButton jb=elencoBottDisat.get(id);
				if (jb!=null){
				jb.setEnabled(true);
				elencoBottDisat.remove(id);
				}
				try {
					if (M_Preventivo.getInstance().getElencoItem().isEmpty()){
						PrimaryView.getInstance().setEnableSalva(false);
					}
					else{
						PrimaryView.getInstance().setEnableSalva(true);
					}
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
		});
	}


	public void modificaPreventivo(int id_Preventivo) throws PersistentException{

//		Bisogna controllare se il preventivo è ancora valido, ed in caso affermativo, 
//		bisogna mantentere i prezzi del preventivo originario
//		in caso negativo, comunicarlo oppure non attivare il bottone di modifica preventivamente
				
//		M_Preventivo.setNumprev(M_Preventivo.getNumprev()+1);
		
//		M_Preventivo prev=Dao_System.getInstance().loadPreventivo(Integer.toString(id_Preventivo));
//		M_Cliente cliente=Dao_System.getInstance().cercaCliente(prev.getRif_Cliente().getCognome(),Ctrl_System.getInstance().getIdAgente());//questo andrà cambiato
	
		
		PreventivoCriteria criteria= new PreventivoCriteria();
		criteria.idPreventivo.eq(Integer.toString(id_Preventivo));
		M_Preventivo prev = criteria.listPreventivo()[0];


		ClienteCriteria criteriaCliente= new ClienteCriteria();		
		//JOIN per recuperare solo i clienti dell'agente loggato
		criteriaCliente.createCriteria("agenteAssociato", "IdAgente", JoinType.INNER_JOIN,   Restrictions.eq("IdAgente", Ctrl_System.getAgenteLog().getIdAgente())); 
		criteriaCliente.idCliente.eq(prev.getRif_Cliente().getIdCliente());
		M_Cliente cliente = criteriaCliente.listCliente()[0];
		
		M_Preventivo prevMod= M_Preventivo.getInstance(prev);
		
		//inizializza view modificaPreventivo
		initModificaPrev(prevMod, cliente, prev);

		float imp=M_Preventivo.getInstance().calcolaTotale();
		float iva=(float)(imp*IVA);
		float tot=imp+iva;
		ItemNuovoPreventivoView.getInstance().setTot(imp, iva, tot);
	}



	public void cancellaPreventivo(int id_Preventivo) throws PersistentException {
		
		AlberoPreventivi.cancellaNodo();
//		Dao_System.getInstance().cancPreventivo(Integer.toString(id_Preventivo));

		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();

		try{			
			PreventivoCriteria criteria = new PreventivoCriteria();
			
			//JOIN per recuperare solo i clienti dell'agente loggato
			criteria.idPreventivo.eq(Integer.toString(id_Preventivo));
			M_Preventivo prev = criteria.listPreventivo()[0];

			AgentTradePersistentManager.instance().getSession().delete(prev);
			
			t.commit();
		}

		catch (Exception e) {
			t.rollback();
		}	
		finally {
			persistent.AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
		PrimaryView.getInstance().resetPannelloCentralePreventivo();
	}
	
	
/*metodi privati*/
	
	private void initNuovoPreventivo(M_Cliente cliente) throws PersistentException{
		
		CercaClienteView.getInstance().dispose();
		CercaClienteView.cancInst();				

		PrimaryView.initIntestazione();
		PrimaryView.initItem();

		PrimaryView.getInstance().setEnableNewPreventivo(false);
		PrimaryView.getInstance().setEnableTabCliente(false);
		PrimaryView.getInstance().setEnableSalva(false);
		
		AlberoPreventivi.disabilitaAlbero();
		
		PrimaryView.getInstance().setNewIntestAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		PrimaryView.getInstance().setNewIntestData(M_Preventivo.getInstance().getData());
		PrimaryView.getInstance().setNewIntestNumPrev(M_Preventivo.getInstance().getIdPreventivo());
		
		PrimaryView.getInstance().setNewIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail());
		ProdottiView.getInstance().enableBottoni();
	}
	
	
	private void initPostSalvaPrev(M_Preventivo p) {
		
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
		
//		Dao_System.getInstance().salvaIdPrev(M_Preventivo.getNumprev());

		AlberoPreventivi.abilitaAlbero();

		elencoBottDisat.clear();
		ProdottiView.getInstance().disableBottoni();
	}
	
	
	private void initAnnullaPrev() {
		
		PrimaryView.getInstance().setEnableNewPreventivo(true);
		PrimaryView.getInstance().setEnableTabCliente(true);
		PrimaryView.getInstance().setVisibleIntestazione(false);
		PrimaryView.getInstance().setVisibleItemPreventivi(false);
		
		PrimaryView.cancIntestazione();
		PrimaryView.cancItem();
		
		AlberoPreventivi.abilitaAlbero();
		ProdottiView.getInstance().disableBottoni();
		PrimaryView.getInstance().setSfondoPrev();
	}
	
	
private void initModificaPrev(M_Preventivo prevMod, M_Cliente cliente, M_Preventivo prev) {
		
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
	}
	

	private void initRiepilogoPreventivo(M_Preventivo m) {
	
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
	}
}