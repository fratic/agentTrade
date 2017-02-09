package agent_trade.controller;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;

import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;

import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoItemPreventivoView;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.util.Costanti;
import persistent.AgentTradePersistentManager;
import persistent.ClienteCriteria;
import persistent.PreventivoCriteria;
import persistent.ProdottoCriteria;

public class Ctrl_elaboraPreventivo {

	/*
	 * attributi di classe
	 */
	
	private static Ctrl_elaboraPreventivo instance;
	private static Map<Integer, JButton> elencoBottDisat=new TreeMap<>();
	
	
	/*
	 * attributi privati
	 */
	
	private Calendar cal = Calendar.getInstance();

	/*
	 * costruttori
	 */
	
	
	/*
	 * metodi di classe
	 */
	
	public static Ctrl_elaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new Ctrl_elaboraPreventivo() : instance);	
	}


	/*
	 * metodi privati
	 */
	
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
	
	
	
	private void initModificaPrev(M_Preventivo prevMod) {

		M_Cliente cliente=prevMod.getRif_Cliente();
		
		
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
						
		List<M_Preventivo_Item> elencoItem = (List<M_Preventivo_Item>) prevMod.getItem();

		Iterator<M_Preventivo_Item> i = elencoItem.iterator();
		M_Preventivo_Item pr_it =null;
		M_Prodotto p=null;
		Map<Integer, JButton> elencoBott=null;
		JButton jb=null;
		while (i.hasNext()) {
			pr_it = (M_Preventivo_Item) i.next();
			p=pr_it.getIdProdotto();
			
			String sconto="";
			if (pr_it.getIdProdotto().getSconto()!=0){
				sconto=(java.lang.Math.ceil(pr_it.getIdProdotto().getSconto()*100))+"%";
			}
			
			float parziale=(p.getPrezzo()*pr_it.getQuantita())*(1-p.getSconto());
			parziale= (float) (Math.ceil(parziale * Math.pow(10, 2)) / Math.pow(10, 2));

			
			ItemNuovoPreventivoView.getInstance().updateTable(null,p.getIdProdotto(), p.getNome(), p.getCategoria(), pr_it.getQuantita(), Float.toString(p.getPrezzo()), sconto, Float.toString(parziale*pr_it.getQuantita()));

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
		List<M_Preventivo_Item> elementi = (List<M_Preventivo_Item>) m.getItem();
	
		Iterator<M_Preventivo_Item> i = elementi.iterator();
		M_Preventivo_Item pr_it =null;
		
		while (i.hasNext()) {
			pr_it = (M_Preventivo_Item) i.next();
			String sconto="";
			if (pr_it.getIdProdotto().getSconto()!=0){
				sconto=(java.lang.Math.ceil(pr_it.getIdProdotto().getSconto()*100))+"%";
			}
			
			float parziale=(pr_it.getIdProdotto().getPrezzo()*(1-pr_it.getIdProdotto().getSconto())*pr_it.getQuantita());
			parziale= (float) (Math.ceil(parziale * Math.pow(10, 2)) / Math.pow(10, 2));

			PrimaryView.getInstance().updateTableRiepilogo(Integer.toString((pr_it.getIdProdotto().getIdProdotto())), pr_it.getIdProdotto().getNome(), pr_it.getIdProdotto().getCategoria(), Integer.toString(pr_it.getQuantita()), Float.toString(pr_it.getIdProdotto().getPrezzo()), sconto , Float.toString((parziale)));
		}
		
		RiepilogoIntestazionePreventivoView.getInstance().setId_Preventivo(m.getIdPreventivo());
	}
	
	/*metodi pubblici*/
		
	//CO1
	public void newPreventivo(M_Agente a) throws PersistentException {
	
		PrimaryView.getInstance().resetPannelloCentralePreventivo();
		M_Preventivo.getInstance().setRif_Agente(a);
		
		M_Preventivo.getInstance().setIdPrev();
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
			
//			cliente = criteriaCliente.listCliente()[0];

			cliente = criteriaCliente.uniqueM_Cliente();

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
				
		
		ProdottoCriteria criteria= new ProdottoCriteria();
		String sconto="";
		criteria.IdProdotto.eq(IdProdotto);
		M_Prodotto p = criteria.listProdotto()[0];
	
		
		M_Preventivo.getInstance().addItem(p);
		
		if (!M_Preventivo.getInstance().getItem().isEmpty()){
			PrimaryView.getInstance().setEnableSalva(true);
		}
		
		if (p.getSconto()!=0){
			sconto=(java.lang.Math.ceil(p.getSconto()*100))+"%";
		}
		float parziale=p.getPrezzo()*(1-p.getSconto());
		parziale= (float) (Math.ceil(parziale * Math.pow(10, 2)) / Math.pow(10, 2));
		ItemNuovoPreventivoView.getInstance().updateTable(null,p.getIdProdotto(), p.getNome(), p.getCategoria(),1, Float.toString(p.getPrezzo()), sconto, Float.toString(parziale));
		
		elencoBottDisat.put(p.getIdProdotto(), jb);
		jb.setEnabled(false);
		
		float imp= M_Preventivo.getInstance().calcolaTotale();
		imp= (float) (Math.ceil(imp * Math.pow(10, 2)) / Math.pow(10, 2));

		float iva=(float)(imp*Costanti.IVA);
		iva= (float) (Math.ceil(iva* Math.pow(10, 2)) / Math.pow(10, 2));
		
		float tot=imp+iva;
		tot= (float) (Math.ceil(tot * Math.pow(10, 2)) / Math.pow(10, 2));

		ItemNuovoPreventivoView.getInstance().setTot(imp, iva, tot);

	}

	
	//CO4
	public void salvaPreventivo() throws PersistentException {
		
		M_Preventivo p= M_Preventivo.getInstance();		
		
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();
		try 
		{
			AgentTradePersistentManager.instance().getSession().saveOrUpdate(p);	

			// commit per il salvataggio
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();

			//inizializza view dopo il salvataggio del preventivo
			initPostSalvaPrev(p);	
			
		}
	
	}
	
	
	//OK	
	public void annullaPreventivo() throws PersistentException
	{		
		initAnnullaPrev();
		elencoBottDisat.clear();
		M_Preventivo.getInstance().annullaPrev();
		
	}
	

	//non mi piace, trovare un alternativa
	public void riepilogoPreventivo(Object obj) throws PersistentException
	{
		if(((DefaultMutableTreeNode)obj).isLeaf())
		{
			String id=obj.toString();
			id= (id.substring(0,2));
			id=id.replaceAll("-","");
			id=id.replaceAll(" ","");

			PreventivoCriteria criteria= new PreventivoCriteria();
			
			criteria.idPreventivo.eq(Integer.parseInt(id));
			M_Preventivo m = criteria.listPreventivo()[0];
			

			//inizializza view di riepilogo preventivo
			if (m!=null){
			initRiepilogoPreventivo(m);
			
			float imp=m.calcolaTotale();
			imp= (float) (Math.ceil(imp * Math.pow(10, 2)) / Math.pow(10, 2));

			float iva=(float)(imp*Costanti.IVA);
			iva= (float) (Math.ceil(iva* Math.pow(10, 2)) / Math.pow(10, 2));

			
			float tot=imp+iva;
			tot= (float) (Math.ceil(tot * Math.pow(10, 2)) / Math.pow(10, 2));

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
		imp= (float) (Math.ceil(imp * Math.pow(10, 2)) / Math.pow(10, 2));

		float iva=(float)(imp*Costanti.IVA);
		iva= (float) (Math.ceil(iva* Math.pow(10, 2)) / Math.pow(10, 2));

		
		float tot=imp+iva;
		tot= (float) (Math.ceil(tot * Math.pow(10, 2)) / Math.pow(10, 2));

		ItemNuovoPreventivoView.getInstance().setTot(imp, iva, tot);
		
		M_Prodotto prod=pr_it.getIdProdotto();
		ItemNuovoPreventivoView.getInstance().updateRow((pr_it.getQuantita()*prod.getPrezzo())*(1-prod.getSconto()));

	}


	public void addQuant(int id_prod, int qt, int row) throws PersistentException {

		M_Preventivo p =M_Preventivo.getInstance();
		p.addQuant(id_prod,qt);
	}

	
	public void rimuoviItem(final int id, final int row) {
		//controllare se l'id è dell'item o del prodotto
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				M_Preventivo p = null;
				try {
					p = M_Preventivo.getInstance();
				} 
				catch (PersistentException e) {

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
					if (M_Preventivo.getInstance().getItem().isEmpty()){
						PrimaryView.getInstance().setEnableSalva(false);
					}
					else{
						PrimaryView.getInstance().setEnableSalva(true);
					}
				}
				catch (PersistentException e) {

					e.printStackTrace();
				}
	
			}
		});
	}


	public void modificaPreventivo(int id_Preventivo) throws PersistentException{

//		Bisogna controllare se il preventivo è ancora valido, ed in caso affermativo, 
//		bisogna mantentere i prezzi del preventivo originario
//		in caso negativo, comunicarlo oppure non attivare il bottone di modifica preventivamente
				
			
		PreventivoCriteria criteria= new PreventivoCriteria();
		criteria.idPreventivo.eq(id_Preventivo);
		M_Preventivo prev = criteria.listPreventivo()[0];

		AgentTradePersistentManager.instance().disposePersistentManager();

		M_Preventivo prevMod= M_Preventivo.getInstance(prev);
		
		initModificaPrev(prevMod);

		//è compito del ctrl farlo? vedere meglio
//		float imp=M_Preventivo.getInstance().calcolaTotale();
//		float iva=(float)(imp*Costanti.IVA);
//		float tot=imp+iva;
		
		float imp= M_Preventivo.getInstance().calcolaTotale();
		imp= (float) (Math.ceil(imp * Math.pow(10, 2)) / Math.pow(10, 2));

		float iva=(float)(imp*Costanti.IVA);
		iva= (float) (Math.ceil(iva* Math.pow(10, 2)) / Math.pow(10, 2));
		
		float tot=imp+iva;
		tot= (float) (Math.ceil(tot * Math.pow(10, 2)) / Math.pow(10, 2));

		
		
		ItemNuovoPreventivoView.getInstance().setTot(imp, iva, tot);
	}



	public void cancellaPreventivo(int id_Preventivo) throws PersistentException {
		
		PersistentTransaction t = AgentTradePersistentManager.instance().getSession().beginTransaction();

		try{			
			PreventivoCriteria criteria = new PreventivoCriteria();
			
			criteria.idPreventivo.eq(id_Preventivo);
			M_Preventivo prev = criteria.listPreventivo()[0];

			/**
			*non va bene. se lo faccio a transazione completa non funziona 
			*l'albero, cosi invece potrebbe capitare che non si cancella sul db 
			* e si cancella apparentemente nel software
			*una possibile soluzione potrebbe essere quella di fare un refesh completo 
			*dell'albero ogni qual volta c'è una modifica
			*/
			AlberoPreventivi.cancellaNodo();
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
			
			AgentTradePersistentManager.instance().getSession().delete(prev);
			
			t.commit();
			
		}

		catch (Exception e) {
			t.rollback();
		}	
		finally {
			AgentTradePersistentManager.instance().disposePersistentManager();
		}
		
	}
	
	
}