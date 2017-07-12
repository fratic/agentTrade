package agent_trade.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.tree.DefaultMutableTreeNode;

import org.hibernate.type.YesNoType;
import org.orm.PersistentException;

import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.model.M_Vini;
import agent_trade.persistent.AgentTradeMandantePersistentManager;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.aziende.Ricerca_azienda;
import agent_trade.ui.content.listini.AlberoListini;
import agent_trade.ui.content.listini.Ricerca_listino;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.ui.content.prodotti.riepilogo.confermaCancProdotto;
import agent_trade.ui.content.sconti.riepilogo.Ricerca_scontoProdotto;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciListino {

	/*attributi di classe*/
	
	private static Ctrl_gestisciListino instance;
	
	//a che servono?
	private static M_Azienda azienda;
	private static M_Prodotto[] elencoProd;
	
	
	private static  String listino;
	private static boolean abilitaAggiungi;
	
	private static M_Prodotto[] prodottiListino;
	/*attributi privati*/
	
	

	/* costruttori*/
	
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciListino getInstance(){
		
		return ((instance == null) ? instance = new Ctrl_gestisciListino() :instance);
	}
	
	/*metodi privati*/
	
	private void updateElencoProdotti() throws PersistentException{
		elencoProd = M_Prodotto.caricaProdottiRemotoAzienda(azienda.getIdAzienda());
	}
	
	
	/*metodi pubblici*/
	
	
	
	public void btnCerca() throws PersistentException {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleListino();
		PrimaryMandanteView.getInstance().setSfondoListino();
		
		Ricerca_listino.getInstance().popolaTab(M_Azienda.caricaAziendeRemoto());
		Ricerca_listino.getInstance().setVisible(true);
	}
	
	

	public static M_Prodotto[] getProdottiListino() {
		return prodottiListino;
	}

	public static void setProdottiListino(M_Prodotto[] prodottiListino) {
		Ctrl_gestisciListino.prodottiListino = prodottiListino;
	}

	public void btnAggiungiProdotto(){
		
		AlberoListini.disabilitaAlbero();
		
		PrimaryMandanteView.cancRiepilogoListinoView();
		PrimaryMandanteView.cancRiepilogoProdottoView();
		PrimaryMandanteView.initNuovoProdottoView(azienda);
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabSconto(false);
		PrimaryMandanteView.getInstance().setEnableTabCliente(false);
		PrimaryMandanteView.getInstance().setEnableCercaListino(false);
		PrimaryMandanteView.getInstance().setEnableSincListino(false);
	}
	
	
	public void ricercaAzienda(String ragSoc, String pIva, String codFis, String citta) throws PersistentException {
		
		if ((ragSoc.equals("") || ragSoc==null) && (pIva.equals("") || pIva==null) && (codFis.equals("") || codFis==null) && (citta.equals("") || citta==null)){
			
			Ricerca_azienda.getInstance().popolaTab(M_Azienda.caricaAziendeRemoto());
		}
		else {
			
			M_Azienda [] listAziende = M_Azienda.caricaAziendeRemotoParametri(ragSoc, pIva, codFis, citta);
			
			if(listAziende.length==0) {
				
				Ricerca_listino.getInstance().setErrore(Costanti.MESSAGGIO_AZIENDA_NON_TROVATA);
				Ricerca_listino.getInstance().setVisibleErroreRicercaAzienda(true);
			}
			else{
				
				Ricerca_listino.getInstance().svuotaTabella();
				for (M_Azienda a : listAziende) {
					Ricerca_listino.getInstance().updateTable(a.getIdAzienda(), a.getRagioneSociale(), a.getPartitaIva(), a.getCodiceFiscale(), a.getCitta());
				}
			}
		}
	}
	
	
	public void recuperaListino(int idAzienda) throws PersistentException {

		PrimaryMandanteView.getInstance().resetPannelloCentraleListino();
		
		azienda = M_Azienda.cercaAziendaRemoto(idAzienda);
		
		Ricerca_listino.getInstance().dispose();
		Ricerca_listino.cancInstanza();
		
		PrimaryMandanteView.initRiepilogoIntestazListinoView();
		PrimaryMandanteView.initRiepilogoListinoView();
		
//		se l'azienda ha un'api i bottoni per la modifica del listino devono essere disabilitati
		
		if (azienda.getUrl()== null || azienda.getUrl().equals("")){
			listino = "assente";
			abilitaAggiungi = true;
		}
		else{
			listino = "presente";
			abilitaAggiungi = false;
		}
		
		PrimaryMandanteView.getInstance().setIntestazioneListino(azienda.getRagioneSociale(), ""+azienda.getIdAzienda(), azienda.getCitta(), listino);
		PrimaryMandanteView.getInstance().setAbilitaAggiungi(abilitaAggiungi);
		
		elencoProd = M_Prodotto.caricaProdottiRemotoAzienda(azienda.getIdAzienda());		
		
			
//			AgentTradeMandantePersistentManager.instance().disposePersistentManager();
			PrimaryMandanteView.getInstance().initTable(elencoProd);
			AlberoListini.abilitaAlbero();
			AlberoListini.selectNode(azienda.getIdAzienda()+ " - " +azienda.getRagioneSociale());

	}
	
	
	public void mostraProdotto (int idProd) throws PersistentException{
		
		M_Prodotto prod = null;
		
		for(M_Prodotto p : elencoProd){
			if (p.getIdProdotto()== idProd)
			{
				prod = p;
			}
		}
				
		PrimaryMandanteView.cancRiepilogoListinoView();
		PrimaryMandanteView.cancRiepilogoProdottoView();
		PrimaryMandanteView.initRiepilogoProdottoView(prod);
		
		if(listino=="presente"){
			PrimaryMandanteView.getInstance().disattivaModificaProd(false);
			PrimaryMandanteView.getInstance().disattivaCancellaProd(false);
		}
		
		PrimaryMandanteView.getInstance().disattivaSalvaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaModificaScontoProdotto(false);
		
		int idSconto = (int) prod.getSconto();
		System.out.println(idSconto);
				
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(idSconto);
		
		PrimaryMandanteView.getInstance().setSchedaProdotto(prod);
		PrimaryMandanteView.getInstance().setScontoProdotto(sconto);
	}
	
	
	public void mostraCatalogo() throws PersistentException{
		
		AlberoListini.abilitaAlbero();
		
		PrimaryMandanteView.cancRiepilogoProdottoView();
		PrimaryMandanteView.cancNuovoProdottoView();
		PrimaryMandanteView.initRiepilogoListinoView();
		
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setEnableCercaListino(true);
		PrimaryMandanteView.getInstance().setEnableSincListino(true);
		
//		fare un	controllo per vedere se la lista non è vuota
		PrimaryMandanteView.getInstance().initTable(elencoProd);
	}

	
	public void salvaProdotto(M_Prodotto prod) throws PersistentException {
		
		AlberoListini.abilitaAlbero();
		
		M_ScontoPercent scontoBase = M_ScontoPercent.caricaScontoBase();
		prod.setSconto(scontoBase.getId());
		
		M_Prodotto.salvaProdottoRemoto(prod);
		
		PrimaryMandanteView.getInstance().resetNuovoProdotto();
		PrimaryMandanteView.cancNuovoProdottoView();
		
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setEnableCercaListino(true);
		PrimaryMandanteView.getInstance().setEnableSincListino(true);
		updateElencoProdotti();		
		
		PrimaryMandanteView.initRiepilogoListinoView();
		
		PrimaryMandanteView.getInstance().initTable(elencoProd);
		
	}
	
	
	public void abilitaModifica(){
		
		AlberoListini.disabilitaAlbero();
		
		PrimaryMandanteView.getInstance().setAbilitaAggiungi(false);
		
		PrimaryMandanteView.getInstance().setModificheProdotto(true);
		PrimaryMandanteView.getInstance().disattivaModificaProd(false);
		PrimaryMandanteView.getInstance().disattivaCancellaProd(false);
		PrimaryMandanteView.getInstance().disattivaIndietro(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepProd(false);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheProdotto(true);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheProdotto(true);
		PrimaryMandanteView.getInstance().disattivaModificaScontoProdotto(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabSconto(false);
		PrimaryMandanteView.getInstance().setEnableTabCliente(false);
		PrimaryMandanteView.getInstance().setEnableCercaListino(false);
		PrimaryMandanteView.getInstance().setEnableSincListino(false);
		PrimaryMandanteView.getInstance().setVisibleToolTipListino();
	}
	
	
	public void annullaModifica(M_Prodotto prod) throws PersistentException{
		
		mostraProdotto(prod.getIdProdotto());
		
		AlberoListini.abilitaAlbero();
		
		PrimaryMandanteView.getInstance().setModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaModificaProd(true);
		PrimaryMandanteView.getInstance().disattivaCancellaProd(true);
		PrimaryMandanteView.getInstance().disattivaIndietro(true);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaModificaScontoProdotto(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepProd(false);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setEnableCercaListino(true);
		PrimaryMandanteView.getInstance().setEnableSincListino(true);
		PrimaryMandanteView.getInstance().setInvisibleToolTipListino();
		
		if (azienda.getUrl()== null || azienda.getUrl().equals("") ){
			listino = "assente";
			abilitaAggiungi = true;
		}
		else{
			listino = "presente";
			abilitaAggiungi = false;
		}
		PrimaryMandanteView.getInstance().setAbilitaAggiungi(abilitaAggiungi);
	}
	
	
	public void modificaProdotto(M_Prodotto prod) throws PersistentException{
		
		prod.setVersione(prod.getVersione()+ 1);
		
		
		M_Prodotto.aggiornaProdottoRemoto(prod);
		
		updateElencoProdotti();
		
		mostraProdotto(prod.getIdProdotto());
		
		PrimaryMandanteView.getInstance().setModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaModificaProd(true);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaCancellaProd(true);
		PrimaryMandanteView.getInstance().disattivaIndietro(true);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaModificaScontoProdotto(false);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setEnableCercaListino(true);
		PrimaryMandanteView.getInstance().setEnableSincListino(true);
		PrimaryMandanteView.getInstance().setInvisibleToolTipListino();
		AlberoListini.abilitaAlbero();
		
		if (azienda.getUrl()== null || azienda.getUrl()== "" ){
			listino = "assente";
			abilitaAggiungi = true;
		}
		else{
			listino = "presente";
			abilitaAggiungi = false;
		}
		PrimaryMandanteView.getInstance().setAbilitaAggiungi(abilitaAggiungi);		
	}
	
	
	public void cancellaProdotto(M_Prodotto prod){
		
		confermaCancProdotto.getInstance().setProdotto(prod);
		confermaCancProdotto.getInstance().setVisible(true);
	}
	
	
	public void postConfermaCancProdotto(M_Prodotto prod) throws PersistentException{
		
		prod.setVersione(0);
		
		M_Prodotto.aggiornaProdottoRemoto(prod);
		
		confermaCancProdotto.getInstance().setVisible(false);
		confermaCancProdotto.cancInst();
		
		updateElencoProdotti();
		mostraCatalogo();
	}
	
	
	public void notConfermaCancProdotto(){
		
		confermaCancProdotto.getInstance().setVisible(false);
		confermaCancProdotto.cancInst();
	}
	
	
	public void inserisciProdottoInTabella(String azienda) throws PersistentException {
		
		ProdottiView.getInstance().inserisciTabella(Ctrl_gestisciListino.getProdottiListino(), azienda);
	}

	
	public void btnCercaSconto() throws PersistentException{
		
		Ricerca_scontoProdotto.getInstance().popolaTab(M_Sconto.caricaScontiRemoto());
		Ricerca_scontoProdotto.getInstance().setVisible(true);	
	}


	public void assegnaSconto(int idSconto) throws PersistentException{
			
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(idSconto);

		Ricerca_scontoProdotto.getInstance().dispose();
		Ricerca_scontoProdotto.cancInstanza();
		PrimaryMandanteView.getInstance().setScontoProdotto(sconto);
				
	}
	
	

}
