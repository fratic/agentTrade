package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Sconto;
import agent_trade.ui.content.sconti.riepilogo.ConfermaCancSconto;
import agent_trade.ui.content.sconti.riepilogo.Ricerca_sconto;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciSconto {

	/*attributi di classe*/
	
	private static Ctrl_gestisciSconto instance;
	
	/*attributi privati*/
	
	
	/* costruttori*/
	
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciSconto getInstance(){
		
		return ((instance == null) ? instance = new Ctrl_gestisciSconto() : instance);
	}
	
	/*metodi pubblici*/
	
	public void btnNewSconto() {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		PrimaryMandanteView.initSelezionaSconto();
		//AlberoSconti.disabilitaAlbero();
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabListino(false);
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableCercaSconto(false);
	}
	
	
	public void btnCerca() throws PersistentException {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		PrimaryMandanteView.getInstance().setSfondoSconto();
		
		Ricerca_sconto.getInstance().popolaTab(M_Sconto.caricaScontiRemoto());
		Ricerca_sconto.getInstance().setVisible(true);
	}
	
	
	public void ricercaSconto(String id) throws PersistentException {

		if ((id.equals("") || id==null)){
			
			Ricerca_sconto.getInstance().popolaTab(M_Sconto.caricaScontiRemoto());
		}
		else {
			
			M_Sconto [] listSconti = M_Sconto.caricaScontoRemotoParametri(id);
			
			if(listSconti.length==0) {
		
				Ricerca_sconto.getInstance().setErrore(Costanti.MESSAGGIO_SCONTO_NON_TROVATO);
				Ricerca_sconto.getInstance().setVisibleErroreRicercaSconto(true);
			}
			else{
				Ricerca_sconto.getInstance().svuotaTabella();
				for (M_Sconto sconto : listSconti) {
					Ricerca_sconto.getInstance().updateTable(sconto);
				}
			}
		}
		
	}
	
	
	public void esciSelezioneSconto() {
		
		PrimaryMandanteView.getInstance().resetSelezioneSconto();
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		PrimaryMandanteView.getInstance().setSfondoSconto();
		PrimaryMandanteView.getInstance().setEnableCercaSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
//		AlberoSconti.abilitaAlbero();
	}
	
	
	public void esciNewSconto() {
		
		PrimaryMandanteView.getInstance().resetNuovoSconto();
		PrimaryMandanteView.cancDettaglioScontoView();
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		PrimaryMandanteView.getInstance().setSfondoSconto();
		PrimaryMandanteView.getInstance().setEnableCercaSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
//		AlberoSconti.abilitaAlbero();
	}

	
	public void ConfermaSelezione(String selectedItem) {
		
		PrimaryMandanteView.cancSelezionaScontoView();
		PrimaryMandanteView.initDettaglioScontoView(selectedItem);
	}
	
	
	public void inserisciNuovoSconto(M_Sconto sconto) throws PersistentException {
		
		M_Sconto.salvaScontoRemoto(sconto);
		
		PrimaryMandanteView.getInstance().resetNuovoSconto();
		PrimaryMandanteView.cancDettaglioScontoView();
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		
		int id = M_Sconto.getMaxIdRemoto();
		recuperaSconto(id);
		
//		AlberoSconti.inserisciNodo();
//		AlberoSconti.selectNode();
//		AlberoSconti.abilitaAlbero();
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableCercaSconto(true);
	}
	
	
	public void recuperaSconto(int id)throws PersistentException {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(id);

		Ricerca_sconto.getInstance().dispose();
		Ricerca_sconto.cancInstanza();
		
		PrimaryMandanteView.cancRiepilogoScontoView();
		PrimaryMandanteView.initRiepilogoScontoView(sconto);
		PrimaryMandanteView.getInstance().setSchedaSconto(sconto);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheSconto(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheSconto(false);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepSconto(false);
//		AlberoSconti.abilitaAlbero();
//		AlberoSconti.selectNode();
	}
	
	
	public void abilitaModifica() {
		
		PrimaryMandanteView.getInstance().setModificheSconto(true);
		PrimaryMandanteView.getInstance().disattivaModificaSconto(false);
		PrimaryMandanteView.getInstance().disattivaCancellaSconto(false);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheSconto(true);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabListino(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepSconto(false);
		PrimaryMandanteView.getInstance().setEnableNewSconto(false);
		PrimaryMandanteView.getInstance().setEnableCercaSconto(false);
		PrimaryMandanteView.getInstance().setVisibleToolTipSconto();
		//AlberoSconti.disabilitaAlbero();
	}
	
	
	public void annullaModificheSconto (int id) throws PersistentException {

		PrimaryMandanteView.getInstance().setModificheSconto(false);
		int idSconto = id;
		recuperaSconto(idSconto);
		PrimaryMandanteView.getInstance().disattivaModificaSconto(true);
		PrimaryMandanteView.getInstance().disattivaCancellaSconto(true);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepSconto(false);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableNewSconto(true);
		PrimaryMandanteView.getInstance().setEnableCercaSconto(true);
		PrimaryMandanteView.getInstance().setInvisibleToolTipSconto();
		//AlberoSconti.abilitaAlbero();
	}
	
	
	public void modificaSconto (M_Sconto sconto) throws PersistentException {
		
//		String errore = ControlloCampi(sconto);
//		if(errore==null)
//		{
			
			M_Sconto.aggiornaScontoRemoto(sconto);
							
			PrimaryMandanteView.getInstance().setModificheSconto(false);
			PrimaryMandanteView.getInstance().disattivaModificaSconto(true);
			PrimaryMandanteView.getInstance().disattivaSalvaModificheSconto(false);
			PrimaryMandanteView.getInstance().disattivaCancellaSconto(true);
			PrimaryMandanteView.getInstance().disattivaAnnullaModificheSconto(false);
		
			PrimaryMandanteView.getInstance().setEnableTabAgente(true);
			PrimaryMandanteView.getInstance().setEnableTabAzienda(true);
			PrimaryMandanteView.getInstance().setEnableTabListino(true);
			
			PrimaryMandanteView.getInstance().setEnableNewSconto(true);
			PrimaryMandanteView.getInstance().setEnableCercaSconto(true);
			PrimaryMandanteView.getInstance().setVisibleErroreRiepSconto(false);
			PrimaryMandanteView.getInstance().setInvisibleToolTipSconto();
//			AlberoSconti.updateNodo();
//			AlberoSconti.selectNode();
//			AlberoSconti.abilitaAlbero();
//		}
//		else{
//			PrimaryMandanteView.getInstance().setVisibleErroreRiepSconto(true);
//			RiepilogoScontoView.getInstance().setErrore(errore);
//		}
	}
	
	
	public void cancellaSconto(int id) {
		
		ConfermaCancSconto.getInstance().setSconto(id);
		ConfermaCancSconto.getInstance().setVisible(true);
	}
	
	
	public void notConfermaCancSconto(){
		ConfermaCancSconto.getInstance().setVisible(false);
		ConfermaCancSconto.cancInst();
	}
	
	
	public void postConfermaCancSconto(int idSconto) throws PersistentException{		
		
		M_Sconto sconto = M_Sconto.caricaScontoRemoto(idSconto);
		M_Sconto.cancellaScontoRemoto(sconto);

//		AlberoSconti.rimuoviNodo();
		ConfermaCancSconto.getInstance().setVisible(false);		
		ConfermaCancSconto.cancInst();
		PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
		PrimaryMandanteView.getInstance().setSfondoSconto();
	}
	
	
}
