package agent_trade.controller;

import org.orm.PersistentException;

import agent_trade.model.M_Azienda;
import agent_trade.ui.content.aziende.DettaglioAziendaView;
import agent_trade.ui.content.aziende.Ricerca_azienda;
import agent_trade.ui.content.aziende.RiepilogoAziendaView;
import agent_trade.ui.content.aziende.confermaCancAzienda;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class Ctrl_gestisciAzienda {
	
	/*attributi di classe*/
	
	private static Ctrl_gestisciAzienda instance;
	
	
	/*attributi privati*/

	
	/*costruttori*/
	
	
	/*metodi di classe*/
	
	public static Ctrl_gestisciAzienda getInstance(){

		return ((instance == null) ? instance = new Ctrl_gestisciAzienda() : instance);	
	}

	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public void ricercaAzienda(String ragSoc, String pIva, String codFis, String citta) throws PersistentException {

		if ((ragSoc.equals("") || ragSoc==null) && (pIva.equals("") || pIva==null) && (codFis.equals("") || codFis==null) && (citta.equals("") || citta==null)){
			
			Ricerca_azienda.getInstance().popolaTab(M_Azienda.caricaAziendeRemoto());
		}
		else {
			
			M_Azienda [] listAziende = M_Azienda.caricaAziendeRemotoParametri(ragSoc, pIva, codFis, citta);
			
			if(listAziende.length==0) {
		
				Ricerca_azienda.getInstance().setErrore(Costanti.MESSAGGIO_AZIENDA_NON_TROVATA);
				Ricerca_azienda.getInstance().setVisibleErroreRicercaAzienda(true);
			}
			else{
				Ricerca_azienda.getInstance().svuotaTabella();
				for (M_Azienda cLoad : listAziende) {
					Ricerca_azienda.getInstance().updateTable(cLoad.getIdAzienda(), cLoad.getRagioneSociale(), cLoad.getPartitaIva(), cLoad.getCodiceFiscale(), cLoad.getCitta());
				}
			}
		}
		
	}

	public void recuperaAzienda(int idAzienda) throws PersistentException {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		
		M_Azienda azienda = M_Azienda.cercaAziendaRemoto(idAzienda);
		
		Ricerca_azienda.getInstance().dispose();
		Ricerca_azienda.cancInstanza();
		
		PrimaryMandanteView.initRiepilogoAziendaView();
		PrimaryMandanteView.getInstance().setSchedaAzienda(""+azienda.getIdAzienda(), azienda.getRagioneSociale(), azienda.getCodiceFiscale(), azienda.getPartitaIva(), azienda.getCitta(), azienda.getCap(), azienda.getIndirizzo(), azienda.getEmail(), azienda.getTelefono(), azienda.getFax(), azienda.getUrl());
		PrimaryMandanteView.getInstance().disattivaSalvaModificheAzienda(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheAzienda(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
//		AlberoAziende.abilitaAlbero();
//		AlberoAziende.selectNode(azienda.getIdAzienda()+ " - " +azienda.getCognome()+ " - " +azienda.getNome());
	}

	public void inserisciNuovaAzienda(String ragSoc, String pIva, String codFis, String citta, String cap, String indirizzo, String email, String tel, String fax, String url) throws PersistentException {
		
//		String errore = ControlloCampi(ragSoc, pIva, codFis, citta, cap, indirizzo, email, tel, fax, url);
//		if(errore==null){
			
			M_Azienda azienda = new M_Azienda( ragSoc, citta, cap, indirizzo, tel, fax, email, pIva, codFis, url);
			//azienda.setAttivo(1);
			M_Azienda.salvaAziendaRemoto(azienda); 

			PrimaryMandanteView.getInstance().resetNuovaAzienda();
			PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
					
			int id = M_Azienda.getMaxIdRemoto();
			recuperaAzienda(id);
					
//			AlberoAziende.inserisciNodo(azienda.getIdAzienda()+ " - " +azienda.getCognome()+ " - " +azienda.getNome());
//			AlberoAziende.selectNode(azienda.getIdAzienda()+ " - " +azienda.getCognome()+ " - " +azienda.getNome());
//			AlberoAziende.abilitaAlbero();

			PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
//		}
//		else{
//			PrimaryMandanteView.getInstance().setVisibleErroreNuovaAzienda(true);
//			DettaglioAziendaView.getInstance().setErrore(errore);
//		}	
	}
	
	public void modificaAzienda (int id, String ragSoc, String pIva, String codFis, String citta, String cap, String indirizzo,	String email, String tel, String fax, String url) throws PersistentException {
		
//		String errore = ControlloCampi(ragSoc, pIva, codFis, citta, cap, indirizzo, email, tel, fax, url);
//		if(errore==null){
			
			M_Azienda azienda = M_Azienda.cercaAziendaRemoto(id);
						
			azienda.setRagioneSociale(ragSoc);
			azienda.setPartitaIva(pIva);
			azienda.setCodiceFiscale(codFis);
			azienda.setIndirizzo(indirizzo);
			azienda.setEmail(email);
			azienda.setCitta(citta);
			azienda.setCap(cap);
			azienda.setTelefono(tel);;
			azienda.setFax(fax);
			azienda.setUrl(url);
			
			M_Azienda.aggiornaAziendaRemoto(azienda);
							
			PrimaryMandanteView.getInstance().resetAzienda();
			PrimaryMandanteView.getInstance().disattivaModificaAzienda(true);
			PrimaryMandanteView.getInstance().disattivaSalvaModificheAzienda(false);
			PrimaryMandanteView.getInstance().disattivaCancellaAzienda(true);
			PrimaryMandanteView.getInstance().disattivaAnnullaModificheAzienda(false);
		
//			PrimaryMandanteView.getInstance().setEnableTabPreventivo(true);
//			PrimaryMandanteView.getInstance().setEnableTabCatalogo(true);
			
			PrimaryMandanteView.getInstance().setEnableNewAzienda(true);
			PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
			PrimaryMandanteView.getInstance().disattivaInviaPostaAzienda(true);
			PrimaryMandanteView.getInstance().setInvisibleToolTipAzienda();
//			AlberoAziende.updateNodo(azienda.getIdAzienda()+ " - " +azienda.getCognome()+ " - " +azienda.getNome());
//			AlberoAziende.selectNode(azienda.getIdAzienda()+ " - " +azienda.getCognome()+ " - " +azienda.getNome());
//			AlberoAziende.abilitaAlbero();
//		}
//		else{
//			PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(true);
//			RiepilogoAziendaView.getInstance().setErrore(errore);
//		}
	}

	public void cancellaAzienda(String id) {
		
		confermaCancAzienda.getInstance().setAzienda(id);
		confermaCancAzienda.getInstance().setVisible(true);
	}

	public void btnCerca() throws PersistentException {

		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.getInstance().setSfondoAzienda();
		
		Ricerca_azienda.getInstance().popolaTab(M_Azienda.caricaAziendeRemoto());
		
		Ricerca_azienda.getInstance().setVisible(true);
	}
	
	public void btnNewAzienda() throws PersistentException {
		
		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.initDettaglioAzienda();
		//AlberoAziende.disabilitaAlbero();
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(false);
	}
	
	public void esciNewAzienda() {
		
		PrimaryMandanteView.getInstance().resetNuovaAzienda();
		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.getInstance().setSfondoAzienda();
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
		PrimaryMandanteView.getInstance().setVisibleErroreNuovaAzienda(false);
//		AlberoAziende.abilitaAlbero();
	}

	public void abilitaModifica() {
		
		PrimaryMandanteView.getInstance().setModificheAzienda(true);
		PrimaryMandanteView.getInstance().disattivaModificaAzienda(false);
		PrimaryMandanteView.getInstance().disattivaCancellaAzienda(false);
		PrimaryMandanteView.getInstance().disattivaInviaPostaAzienda(false);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheAzienda(true);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheAzienda(true);
//		PrimaryMandanteView.getInstance().setEnableTabCatalogo(false);
//		PrimaryMandanteView.getInstance().setEnableTabPreventivo(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
		PrimaryMandanteView.getInstance().setEnableNewAzienda(false);
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(false);
		PrimaryMandanteView.getInstance().setVisibleToolTipAzienda();
		//AlberoAziende.disabilitaAlbero();
	}

	public void annullaModificheAzienda (String id) throws PersistentException {

		PrimaryMandanteView.getInstance().resetAzienda();
		int idAzienda=Integer.parseInt(id);
		recuperaAzienda(idAzienda);
		PrimaryMandanteView.getInstance().disattivaModificaAzienda(true);
		PrimaryMandanteView.getInstance().disattivaCancellaAzienda(true);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
		PrimaryMandanteView.getInstance().disattivaInviaPostaAzienda(true);
//		PrimaryMandanteView.getInstance().setEnableTabCatalogo(true);
//		PrimaryMandanteView.getInstance().setEnableTabPreventivo(true);
		PrimaryMandanteView.getInstance().setEnableNewAzienda(true);
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
		PrimaryMandanteView.getInstance().setInvisibleToolTipAzienda();
		//AlberoAziende.abilitaAlbero();
	}
	
	public void postConfermaCancAzienda(String id) throws PersistentException{
		
		int idAzienda = Integer.parseInt(id);
		
		M_Azienda azienda = M_Azienda.cercaAziendaRemoto(idAzienda);
//		azienda.setAttivo(0);
		M_Azienda.cancellaAziendaRemoto(azienda);

//		AlberoAziende.rimuoviNodo(azienda.getIdAzienda()+ " - " +azienda.getCognome()+ " - " +azienda.getNome());
		confermaCancAzienda.getInstance().setVisible(false);		
		confermaCancAzienda.cancInst();
		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.getInstance().setSfondoAzienda();
	}
	
	public void notConfermaCancAzienda(){
		confermaCancAzienda.getInstance().setVisible(false);
		confermaCancAzienda.cancInst();
	}
	
}
