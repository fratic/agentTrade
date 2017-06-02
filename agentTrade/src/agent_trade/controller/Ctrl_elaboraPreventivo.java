package agent_trade.controller;

import java.awt.EventQueue;
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
import agent_trade.sconti.ClienteScontoStrategy;
import agent_trade.sconti.IScontoStrategy;
import agent_trade.sconti.ScontoStrategyFactory;
import agent_trade.ui.content.clienti.CercaClienteView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;
import agent_trade.ui.content.preventivi.Ricerca_preventivo;
import agent_trade.ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoItemPreventivoView;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.util.Costanti;

public class Ctrl_elaboraPreventivo {

	/*
	 * attributi di classe
	 */
	
	private static Ctrl_elaboraPreventivo instance;
	
	public static boolean prevInCorso=false;
	//probabilmente non è compito suo tenere questa struttura dati
	private static Map<Integer, JButton> elencoBottDisat=new TreeMap<>();
	
	
	/*
	 * attributi privati
	 */
	

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

		PrimaryAgenteView.initIntestazione();
		PrimaryAgenteView.initItem();
		
		
		PrimaryAgenteView.getInstance().setEnableNewPreventivo(false);
		
		PrimaryAgenteView.getInstance().setEnableCercaPreventivo(false);
		PrimaryAgenteView.getInstance().setEnableTabCliente(false);
		PrimaryAgenteView.getInstance().setEnableSalva(false);
		
		AlberoPreventivi.disabilitaAlbero();
		
		PrimaryAgenteView.getInstance().setNewIntestAgente(Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome());
		PrimaryAgenteView.getInstance().setNewIntestData(M_Preventivo.getInstance().getData());
		PrimaryAgenteView.getInstance().setNewIntestNumPrev(M_Preventivo.getInstance().getIdPreventivo());
		String sconto = Ctrl_gestisciCliente.getInstance().mostraScontoCliente(cliente.getSconto());
		PrimaryAgenteView.getInstance().setNewIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail(), sconto);
		
		ProdottiView.getInstance().enableBottoni();
	}
	
	
	private void initPostSalvaPrev(M_Preventivo p) {
		
		String nodo=p.getIdPreventivo()+" - "+p.getRif_Cliente().getCognome()+" "+p.getRif_Cliente().getNome();
		
		if (!AlberoPreventivi.controllaEsistenza(nodo)){
			AlberoPreventivi.inserisciNodo(nodo);

		}
		AlberoPreventivi.selezionaNodo(nodo);

		PrimaryAgenteView.getInstance().setEnableNewPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableCercaPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableTabCliente(true);

		PrimaryAgenteView.getInstance().setVisibleIntestazione(false);
		PrimaryAgenteView.getInstance().setVisibleItemPreventivi(false);
		
		PrimaryAgenteView.cancIntestazione();
		PrimaryAgenteView.cancItem();
		
		M_Preventivo.cancIstanza();	
		
		AlberoPreventivi.abilitaAlbero();

		elencoBottDisat.clear();
		ProdottiView.getInstance().disableBottoni();
	}
	
	
	private void initAnnullaPrev() {
		
		PrimaryAgenteView.getInstance().setEnableNewPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableCercaPreventivo(true);
		PrimaryAgenteView.getInstance().setEnableTabCliente(true);
		PrimaryAgenteView.getInstance().setVisibleIntestazione(false);
		PrimaryAgenteView.getInstance().setVisibleItemPreventivi(false);
		
		PrimaryAgenteView.cancIntestazione();
		PrimaryAgenteView.cancItem();
		
		AlberoPreventivi.abilitaAlbero();
		AlberoPreventivi.selezionaRadice();
		ProdottiView.getInstance().disableBottoni();
		PrimaryAgenteView.getInstance().setSfondoPrev();
	}
	
	
	
	private void initModificaPrev(M_Preventivo prevMod) throws PersistentException {

		M_Cliente cliente=prevMod.getRif_Cliente();
		
		
		PrimaryAgenteView.getInstance().resetPannelloCentralePreventivo();
		PrimaryAgenteView.initIntestazione();
		PrimaryAgenteView.initItem();

		PrimaryAgenteView.getInstance().setEnableNewPreventivo(false);
		PrimaryAgenteView.getInstance().setEnableCercaPreventivo(false);
		PrimaryAgenteView.getInstance().setEnableTabCliente(false);
		PrimaryAgenteView.getInstance().setEnableSalva(true);

		AlberoPreventivi.disabilitaAlbero();
				
		PrimaryAgenteView.getInstance().setNewIntestAgente(prevMod.getRif_Agente().getCognome()+" "+prevMod.getRif_Agente().getNome());
		PrimaryAgenteView.getInstance().setNewIntestData(prevMod.getData());
		PrimaryAgenteView.getInstance().setNewIntestNumPrev(prevMod.getIdPreventivo());
		String sconto = Ctrl_gestisciCliente.getInstance().mostraScontoCliente(cliente.getSconto());
		PrimaryAgenteView.getInstance().setNewIntestCliente(cliente.getCognome(),cliente.getNome(), cliente.getIndirizzo(), cliente.getEmail(), sconto);

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
			//jb.setEnabled(false);
		}
	}
	

	private void initRiepilogoPreventivo(M_Preventivo p) throws PersistentException {
	
		PrimaryAgenteView.initRiepilogo();
	
		PrimaryAgenteView.getInstance().setRiepIntestAgente(p);
		PrimaryAgenteView.getInstance().setRiepIntestData(p.getData());
		PrimaryAgenteView.getInstance().setRiepIntestNumPrev(p.getIdPreventivo());
		
		PrimaryAgenteView.getInstance().setRiepIntestCliente(p);
		List<M_Preventivo_Item> elementi = (List<M_Preventivo_Item>) p.getItem();
	
		Iterator<M_Preventivo_Item> i = elementi.iterator();
		M_Preventivo_Item pr_it =null;
		
		while (i.hasNext()) {
		
			pr_it = (M_Preventivo_Item) i.next();
			PrimaryAgenteView.getInstance().updateTableRiepilogo(p, pr_it);
			
		}
		
		RiepilogoIntestazionePreventivoView.getInstance().setId_Preventivo(p.getIdPreventivo());
	}
	
	/*metodi pubblici*/
		
	//CO1
	public void newPreventivo() throws PersistentException {
	
		PrimaryAgenteView.getInstance().resetPannelloCentralePreventivo();
		
		M_Agente a = Ctrl_System.getAgenteLog();
		
		M_Preventivo p= M_Preventivo.getInstance();
		
		p.setRif_Agente(a);
		p.setIdPrev();
		p.setData(Ctrl_System.calendario.getTime());
	
		Ctrl_elaboraPreventivo.prevInCorso=true;

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
			PrimaryAgenteView.getInstance().setEnableSalva(true);
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
			Ctrl_elaboraPreventivo.prevInCorso=false;

		}
	}
	
	
	//OK	
	public void annullaPreventivo() throws PersistentException
	{		
		initAnnullaPrev();
		elencoBottDisat.clear();
		M_Preventivo.getInstance().annullaPrev();
		Ctrl_elaboraPreventivo.prevInCorso=false;

		
	}
	

	//non mi piace, trovare un alternativa
	public void riepilogoPreventivo(int id) throws PersistentException
	{
		if(id !=0)
		{
			M_Preventivo m =  M_Preventivo.caricaPreventivo(id);

			if (m!=null){
				initRiepilogoPreventivo(m);
			
				RiepilogoItemPreventivoView.getInstance().setTot(m);
			}
		}
		else{
			
			PrimaryAgenteView.getInstance().resetPannelloCentralePreventivo();
			PrimaryAgenteView.getInstance().setSfondoPrev();
		}
	}
	

	public void refresh(Observable obs, M_Preventivo p) throws PersistentException{
		
		M_Preventivo_Item pr_it=(M_Preventivo_Item)obs;
		
		ItemNuovoPreventivoView.getInstance().setTot();
		
		ItemNuovoPreventivoView.getInstance().updateRow(pr_it.calcolaParziale(),pr_it.calcolaParziale()-pr_it.getStrategiaProdotto().calcolaSconto((p)));

	}


	public void addQuant(int id_prod, int qt) throws PersistentException {

		M_Preventivo.getInstance().addQuant(id_prod,qt);
		
	}

	
	public void rimuoviItem(final int id_item, final int row) {
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
				p.removeItem(id_item);
				ItemNuovoPreventivoView.getInstance().deleteRow(row);
				JButton jb=elencoBottDisat.get(id_item);
//				if (jb!=null){
//					jb.setEnabled(true);
					elencoBottDisat.remove(id_item);
//				}

				try {
					if (M_Preventivo.getInstance().getItem().isEmpty()){
						PrimaryAgenteView.getInstance().setEnableSalva(false);
					}
					else{
						PrimaryAgenteView.getInstance().setEnableSalva(true);
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
				
			
		M_Preventivo prev = M_Preventivo.caricaPreventivo(id_Preventivo);

		/**
		 * AgentTradePersistentManager qui?????
		 */
		 
//		AgentTradePersistentManager.instance().disposePersistentManager();

		M_Preventivo prevMod= M_Preventivo.getInstance(prev);
		
		initModificaPrev(prevMod);
		Ctrl_elaboraPreventivo.prevInCorso=true;

		ItemNuovoPreventivoView.getInstance().setTot();
	}



	public void cancellaPreventivo(int id_Preventivo) throws PersistentException {
	
			M_Preventivo prev = M_Preventivo.caricaPreventivo(id_Preventivo);

			/**
			*non va bene. se lo faccio a transazione completa non funziona 
			*l'albero, cosi invece potrebbe capitare che non si cancella sul db 
			* e si cancella apparentemente nel software
			*una possibile soluzione potrebbe essere quella di fare un refesh completo 
			*dell'albero ogni qual volta c'è una modifica
			*/
			AlberoPreventivi.cancellaNodo();
			PrimaryAgenteView.getInstance().resetPannelloCentralePreventivo();
			AlberoPreventivi.selezionaRadice();
			prev.delete();
	}
	
	
public void btnCerca() {
		
		PrimaryAgenteView.getInstance().resetPannelloCentralePreventivo();
		PrimaryAgenteView.getInstance().setSfondoPrev();
		try {
			Ricerca_preventivo.getInstance().popolaTab(Ctrl_elaboraPreventivo.getInstance().caricaPreventivi());
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		Ricerca_preventivo.getInstance().setVisible(true);
		
	}
	
	
	public M_Preventivo[] caricaPreventivi() throws PersistentException{
		
		M_Preventivo[] listaPrev = M_Preventivo.caricaPreventiviAgente();
		return listaPrev;
	}
	
	
	public void annullaRicercaPreventivo(){
		
		Ricerca_preventivo.getInstance().svuotaTabella();
		Ricerca_preventivo.getInstance().resetRicerca();
		Ricerca_preventivo.getInstance().setVisibleErroreRicercaPreventivo(false);
	}
	
	
	public void ricercaPreventivo(String id, String codFis, String cognome, String nome) throws PersistentException{
		
		System.out.println("ID----"+id+"-----");
		if ((id.equals("")||id.equals(null)) && (cognome.equals("")||cognome.equals(null)) && (nome.equals("")||nome.equals(null)) && (codFis.equals("")||codFis.equals(null))){
			
			Ricerca_preventivo.getInstance().popolaTab(Ctrl_elaboraPreventivo.getInstance().caricaPreventivi());
		}
		else{
			
			M_Preventivo[] listaPrev = M_Preventivo.caricaPreventiviParametri(id, codFis, cognome, nome );
			
			if(listaPrev.length == 0){
				
				Ricerca_preventivo.getInstance().setErrore(Costanti.MESSAGGIO_PREVENTIVO_NON_TROVATO);
				Ricerca_preventivo.getInstance().setVisibleErroreRicercaPreventivo(true);
			}
			else{
				
				Ricerca_preventivo.getInstance().svuotaTabella();
				
				for(M_Preventivo pLoad : listaPrev){
					Ricerca_preventivo.getInstance().updateTable(pLoad.getIdPreventivo(), pLoad.getRif_Cliente(), pLoad.getData());
				}
			}
		}
	}
	
	
	public void recuperaPreventivo(int idPrev) throws PersistentException{
		
		PrimaryAgenteView.getInstance().resetPannelloCentraleCliente();
		
		M_Preventivo prev = M_Preventivo.caricaPreventivo(idPrev);
		
		Ricerca_preventivo.getInstance().dispose();
		Ricerca_preventivo.cancInstanza();
		
		initRiepilogoPreventivo(prev);
	}


	public static Map<Integer, JButton> getElencoBottDisat() {
		return elencoBottDisat;
	}


	public static void setElencoBottDisat(Map<Integer, JButton> elencoBottDisat) {
		Ctrl_elaboraPreventivo.elencoBottDisat = elencoBottDisat;
	}

	
	
	
	
}