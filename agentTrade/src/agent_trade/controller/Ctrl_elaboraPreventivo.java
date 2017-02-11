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

import org.orm.PersistentException;

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

import persistent.AgentTradePersistentManager;

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
			
			ItemNuovoPreventivoView.getInstance().updateTable(p, pr_it);

			elencoBott=ProdottiView.elencoBottoniProdotti();
			jb=elencoBott.get(p.getIdProdotto());
			elencoBottDisat.put(p.getIdProdotto(), jb);
			jb.setEnabled(false);
		}
	}
	

	private void initRiepilogoPreventivo(M_Preventivo p) {
	
		PrimaryView.initRiepilogo();
	
		PrimaryView.getInstance().setRiepIntestAgente(p);
		PrimaryView.getInstance().setRiepIntestData(p.getData());
		PrimaryView.getInstance().setRiepIntestNumPrev(p.getIdPreventivo());
		
		PrimaryView.getInstance().setRiepIntestCliente(p);
		List<M_Preventivo_Item> elementi = (List<M_Preventivo_Item>) p.getItem();
	
		Iterator<M_Preventivo_Item> i = elementi.iterator();
		M_Preventivo_Item pr_it =null;
		
		while (i.hasNext()) {
		
			pr_it = (M_Preventivo_Item) i.next();
			PrimaryView.getInstance().updateTableRiepilogo(pr_it);
			
		}
		
		RiepilogoIntestazionePreventivoView.getInstance().setId_Preventivo(p.getIdPreventivo());
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
		
		M_Cliente cliente= M_Cliente.cercaCliente(id_cliente);
					
		M_Preventivo.getInstance().setRif_Cliente(cliente);	
		
		//init della view
		initNuovoPreventivo(cliente);
	}


	//CO3
	public void addItem(int idProdotto, JButton jb) throws PersistentException {
				
		
		M_Prodotto p = M_Prodotto.caricaProdotto(idProdotto);
		
		M_Preventivo_Item prev_item= M_Preventivo.getInstance().addItem(p);
		
		if (!M_Preventivo.getInstance().getItem().isEmpty()){
			PrimaryView.getInstance().setEnableSalva(true);
		}
		
		ItemNuovoPreventivoView.getInstance().updateTable(p, prev_item);
		
		elencoBottDisat.put(p.getIdProdotto(), jb);
		jb.setEnabled(false);
		
		ItemNuovoPreventivoView.getInstance().setTot();

	}

	
	//CO4
	public void salvaPreventivo() throws PersistentException {
		
		if (M_Preventivo.getInstance().salvaPreventivo())
		{
			initPostSalvaPrev(M_Preventivo.getInstance());	
		}
//		else 
//			System.out.println("Salvataggio non a buon fine");
//			//qui andrebbe fatto qualcosa, cio�, una dialog che dice che non � stato salvato ed
//			//eventualmente fare altro tipo recuperare il preventivo 	
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

			M_Preventivo m =  M_Preventivo.caricaPreventivo(Integer.parseInt(id));
			

			//inizializza view di riepilogo preventivo
			if (m!=null){
			initRiepilogoPreventivo(m);
			
			RiepilogoItemPreventivoView.getInstance().setTot();
			}
		}
		else{
			
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
			PrimaryView.getInstance().setSfondoPrev();
		}
	}
	

	public void refresh(Observable obs, M_Preventivo p) throws PersistentException{
		
		M_Preventivo_Item pr_it=(M_Preventivo_Item)obs;
		
		ItemNuovoPreventivoView.getInstance().setTot();
		
		ItemNuovoPreventivoView.getInstance().updateRow((pr_it.calcolaParziale()));

	}


	public void addQuant(int id_prod, int qt, int row) throws PersistentException {

		M_Preventivo.getInstance().addQuant(id_prod,qt);
	}

	
	public void rimuoviItem(final int id_item, final int row) {
		//controllare se l'id � dell'item o del prodotto
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				M_Preventivo p = null;
				try {
					p = M_Preventivo.getInstance();
				} 
				catch (PersistentException e) {

					e.printStackTrace();
				}
				p.removeItem(id_item);
				ItemNuovoPreventivoView.getInstance().deleteRow(row);
								
				JButton jb=elencoBottDisat.get(id_item);
				if (jb!=null){
				jb.setEnabled(true);
				elencoBottDisat.remove(id_item);
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

//		Bisogna controllare se il preventivo � ancora valido, ed in caso affermativo, 
//		bisogna mantentere i prezzi del preventivo originario
//		in caso negativo, comunicarlo oppure non attivare il bottone di modifica preventivamente
				
			
		M_Preventivo prev = M_Preventivo.caricaPreventivo(id_Preventivo);

		/**
		 * AgentTradePersistentManager qui?????
		 */
		 
		AgentTradePersistentManager.instance().disposePersistentManager();

		M_Preventivo prevMod= M_Preventivo.getInstance(prev);
		
		initModificaPrev(prevMod);

		ItemNuovoPreventivoView.getInstance().setTot();
	}



	public void cancellaPreventivo(int id_Preventivo) throws PersistentException {
	
			M_Preventivo prev = M_Preventivo.caricaPreventivo(id_Preventivo);

			/**
			*non va bene. se lo faccio a transazione completa non funziona 
			*l'albero, cosi invece potrebbe capitare che non si cancella sul db 
			* e si cancella apparentemente nel software
			*una possibile soluzione potrebbe essere quella di fare un refesh completo 
			*dell'albero ogni qual volta c'� una modifica
			*/
			AlberoPreventivi.cancellaNodo();
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
			
			prev.delete();
	
	}
	
	
}