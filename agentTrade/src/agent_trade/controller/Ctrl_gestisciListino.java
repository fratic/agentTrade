package agent_trade.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JButton;

import org.hibernate.type.YesNoType;
import org.orm.PersistentException;

import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;
import agent_trade.ui.content.aziende.Ricerca_azienda;
import agent_trade.ui.content.listini.Ricerca_listino;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciListino {

	/*attributi di classe*/
	
	private static Ctrl_gestisciListino instance;
	private static M_Azienda azienda;
	private static M_Prodotto[] elencoProd;
	private static  String listino;
	private static boolean abilitaAggiungi;
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
	
	
	public void btnAggiungiProdotto(){
		
		PrimaryMandanteView.cancRiepilogoListinoView();
		PrimaryMandanteView.initNuovoProdottoView(azienda);
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableCercaListino(false);
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
		
		if (azienda.getUrl()== null || azienda.getUrl()=="" ){
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
		
//		fare un	controllo per vedere se la lista � vuota in caso affermativo comunicarlo al mandante
			PrimaryMandanteView.getInstance().initTable(elencoProd);
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
		PrimaryMandanteView.initRiepilogoProdottoView(prod);
		
		if(listino=="presente"){
			PrimaryMandanteView.getInstance().disattivaModificaProd(false);
			PrimaryMandanteView.getInstance().disattivaCancellaProd(false);
		}
		
		PrimaryMandanteView.getInstance().disattivaSalvaModificheProdotto(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheProdotto(false);
		PrimaryMandanteView.getInstance().setSchedaProdotto(prod);
	}
	
	public void mostraCatalogo() throws PersistentException{
		
		PrimaryMandanteView.cancRiepilogoProdottoView();
		PrimaryMandanteView.initRiepilogoListinoView();
		
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableCercaListino(true);
		
//		fare un	controllo per vedere se la lista non � vuota
		PrimaryMandanteView.getInstance().initTable(elencoProd);
	}

	public void SalvaProdotto(M_Prodotto prod) throws PersistentException {
		
		M_Prodotto.salvaProdottoRemoto(prod);
		
		PrimaryMandanteView.getInstance().resetNuovoProdotto();
		PrimaryMandanteView.cancNuovoProdottoView();
		
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableCercaListino(true);
		
		updateElencoProdotti();		
		
		PrimaryMandanteView.initRiepilogoListinoView();
		
		PrimaryMandanteView.getInstance().initTable(elencoProd);
		
	}
	
		
}