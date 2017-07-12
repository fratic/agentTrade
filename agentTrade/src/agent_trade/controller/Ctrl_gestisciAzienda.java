package agent_trade.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.orm.PersistentException;

import agent_trade.model.M_Azienda;
import agent_trade.ui.content.aziende.AlberoAziende;
import agent_trade.ui.content.aziende.DettaglioAziendaView;
import agent_trade.ui.content.aziende.Ricerca_azienda;
import agent_trade.ui.content.aziende.RiepilogoAziendaView;
import agent_trade.ui.content.aziende.confermaCancAzienda;
import agent_trade.ui.content.listini.AlberoListini;
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
	
	private boolean check(String regex, String input){
		
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(input);

		  if (matcher.matches())
		    return true;
		  else
		    return false;
		}
	
	private String ControlloCampi(String ragSoc, String pIva, String codFis, String citta, String cap, String indirizzo, String email, String tel, String fax, String url, String tipo){
		
		String errore= null;
		String campoErrato = "";
		
		if(ragSoc.equals("") || pIva.equals("") || codFis.equals("") || citta.equals("") || cap.equals("") || indirizzo.equals("") || email.equals("") || tel.equals("") || fax.equals("") /*|| url.equals("")*/ || tipo.equals("Seleziona un tipo")){
			return errore = Costanti.MESSAGGIO_CAMPI_VUOTI;
		}
		if(!check(Costanti.REG_EX_RAGIONE_SOCIALE, ragSoc)){
			campoErrato = campoErrato + "ragione sociale ";
		}
		if(!check(Costanti.REG_EX_PART_IVA, pIva)){
			campoErrato = campoErrato + "partita iva ";
		}
		if(!check(Costanti.REG_EX_COD_FISC_AZIENDA, codFis)){
			campoErrato = campoErrato + "codice fiscale ";
		}
		if(!check(Costanti.REG_EX_INDIRIZZO, indirizzo)){
			campoErrato = campoErrato +"indirizzo ";
		}
		if(!check(Costanti.REG_EX_CITTA, citta)){
			campoErrato = campoErrato +"città ";
		}
		if(!check(Costanti.REG_EX_CAP, cap)){
			campoErrato = campoErrato +"cap ";
		}
		if(!check(Costanti.REG_EX_TELEFONO, tel)){
			campoErrato = campoErrato +"telefono ";
		}
		if(!check(Costanti.REG_EX_EMAIL, email)){
			campoErrato = campoErrato +"email ";
		}
		if(!check(Costanti.REG_EX_FAX, fax)){
			campoErrato = campoErrato +"fax ";
		}
//		if(!check(Costanti.REG_EX_URL, url)){	//definire l'espressione regolare per l'url
//			campoErrato = campoErrato +"url ";
//		}
		if (errore == null && campoErrato != "")
		{
			errore = Costanti.MESSAGGIO_CAMPI_ERRATI + campoErrato;
		}
		return errore;
	}
	
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
		PrimaryMandanteView.getInstance().setSchedaAzienda(""+azienda.getIdAzienda(), azienda.getRagioneSociale(), azienda.getCodiceFiscale(), azienda.getPartitaIva(), azienda.getCitta(), azienda.getCap(), azienda.getIndirizzo(), azienda.getEmail(), azienda.getTelefono(), azienda.getFax(), azienda.getUrl(), azienda.getTipoProdotto());
		PrimaryMandanteView.getInstance().disattivaSalvaModificheAzienda(false);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheAzienda(false);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
		AlberoAziende.abilitaAlbero();
		AlberoAziende.selectNode(azienda.getIdAzienda()+ " - " +azienda.getRagioneSociale());
	}

	public void inserisciNuovaAzienda(String ragSoc, String pIva, String codFis, String citta, String cap, String indirizzo, String email, String tel, String fax, String url, String tipo) throws PersistentException {
		
		String errore = ControlloCampi(ragSoc, pIva, codFis, citta, cap, indirizzo, email, tel, fax, url, tipo);
		
		if(errore == null){

			M_Azienda azienda = new M_Azienda( ragSoc, citta, cap, indirizzo, tel, fax, email, pIva, codFis, url, tipo, 1);
			M_Azienda.salvaAziendaRemoto(azienda); 

			PrimaryMandanteView.getInstance().resetNuovaAzienda();
			PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
			PrimaryMandanteView.getInstance().setVisibleErroreNuovaAzienda(false);
					
			int id = M_Azienda.getMaxIdRemoto();
			recuperaAzienda(id);
					
			AlberoAziende.abilitaAlbero();
			PrimaryMandanteView.getInstance().setEnableTabAgente(true);
			PrimaryMandanteView.getInstance().setEnableTabListino(true);
			PrimaryMandanteView.getInstance().setEnableTabSconto(true);
			PrimaryMandanteView.getInstance().setEnableTabCliente(true);
			PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
			AlberoAziende.refresh();
			AlberoListini.refresh();

			AlberoAziende.selectNode(azienda.getIdAzienda()+ " - " +azienda.getRagioneSociale());

		}
		else{
			PrimaryMandanteView.getInstance().setVisibleErroreNuovaAzienda(true);
			PrimaryMandanteView.getInstance().setErroreNuovaAzienda(errore);
		}	
	}
	
	public void modificaAzienda (int id, String ragSoc, String pIva, String codFis, String citta, String cap, String indirizzo,	String email, String tel, String fax, String url, String tipo) throws PersistentException {
		
		String errore = ControlloCampi(ragSoc, pIva, codFis, citta, cap, indirizzo, email, tel, fax, url, tipo);
		if(errore==null){
			
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
			azienda.setVersione(azienda.getVersione()+1);
			
			M_Azienda.aggiornaAziendaRemoto(azienda);
							
			PrimaryMandanteView.getInstance().resetAzienda();
			PrimaryMandanteView.getInstance().disattivaModificaAzienda(true);
			PrimaryMandanteView.getInstance().disattivaSalvaModificheAzienda(false);
			PrimaryMandanteView.getInstance().disattivaCancellaAzienda(true);
			PrimaryMandanteView.getInstance().disattivaAnnullaModificheAzienda(false);
		
			PrimaryMandanteView.getInstance().setEnableTabAgente(true);
			PrimaryMandanteView.getInstance().setEnableTabListino(true);
			PrimaryMandanteView.getInstance().setEnableTabSconto(true);
			PrimaryMandanteView.getInstance().setEnableTabCliente(true);
			
			PrimaryMandanteView.getInstance().setEnableNewAzienda(true);
			PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
			PrimaryMandanteView.getInstance().disattivaVisualizzaListinoAzienda(true);
			PrimaryMandanteView.getInstance().disattivaSincListinoAzienda(true);
			PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
			PrimaryMandanteView.getInstance().setInvisibleToolTipAzienda();

			AlberoAziende.abilitaAlbero();
			AlberoAziende.refresh();
			AlberoListini.refresh();
			AlberoAziende.selectNode(azienda.getIdAzienda()+ " - " +azienda.getRagioneSociale());


		}
		else{
			PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(true);
			PrimaryMandanteView.getInstance().setErroreRiepAzienda(errore);
		}
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
		AlberoAziende.deselezionaNodo();
		AlberoAziende.disabilitaAlbero();

		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.initDettaglioAzienda();
		
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableTabListino(false);
		PrimaryMandanteView.getInstance().setEnableTabSconto(false);
		PrimaryMandanteView.getInstance().setEnableTabCliente(false);
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(false);
	}
	
	public void esciNewAzienda() {
		
		PrimaryMandanteView.getInstance().resetNuovaAzienda();
		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.getInstance().setSfondoAzienda();
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setVisibleErroreNuovaAzienda(false);
		AlberoAziende.abilitaAlbero();
	}

	public void abilitaModifica() {
		
		PrimaryMandanteView.getInstance().setModificheAzienda(true);
		PrimaryMandanteView.getInstance().disattivaModificaAzienda(false);
		PrimaryMandanteView.getInstance().disattivaCancellaAzienda(false);
		PrimaryMandanteView.getInstance().disattivaVisualizzaListinoAzienda(false);
		PrimaryMandanteView.getInstance().disattivaSincListinoAzienda(false);
		PrimaryMandanteView.getInstance().disattivaSalvaModificheAzienda(true);
		PrimaryMandanteView.getInstance().disattivaAnnullaModificheAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(false);
		PrimaryMandanteView.getInstance().setEnableTabListino(false);
		PrimaryMandanteView.getInstance().setEnableTabSconto(false);
		PrimaryMandanteView.getInstance().setEnableTabCliente(false);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
		PrimaryMandanteView.getInstance().setEnableNewAzienda(false);
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(false);
		PrimaryMandanteView.getInstance().setVisibleToolTipAzienda();
		AlberoAziende.disabilitaAlbero();
	}

	public void annullaModificheAzienda (String id) throws PersistentException {

		PrimaryMandanteView.getInstance().resetAzienda();
		int idAzienda=Integer.parseInt(id);
		recuperaAzienda(idAzienda);
		PrimaryMandanteView.getInstance().disattivaModificaAzienda(true);
		PrimaryMandanteView.getInstance().disattivaCancellaAzienda(true);
		PrimaryMandanteView.getInstance().setVisibleErroreRiepAzienda(false);
		PrimaryMandanteView.getInstance().disattivaVisualizzaListinoAzienda(true);
		PrimaryMandanteView.getInstance().disattivaSincListinoAzienda(true);
		PrimaryMandanteView.getInstance().setEnableTabAgente(true);
		PrimaryMandanteView.getInstance().setEnableTabListino(true);
		PrimaryMandanteView.getInstance().setEnableTabSconto(true);
		PrimaryMandanteView.getInstance().setEnableTabCliente(true);
		PrimaryMandanteView.getInstance().setEnableNewAzienda(true);
		PrimaryMandanteView.getInstance().setEnableCercaAzienda(true);
		PrimaryMandanteView.getInstance().setInvisibleToolTipAzienda();
		AlberoAziende.abilitaAlbero();
	}
	
	public void postConfermaCancAzienda(String id) throws PersistentException{
		
		int idAzienda = Integer.parseInt(id);
		
		M_Azienda azienda = M_Azienda.cercaAziendaRemoto(idAzienda);
		azienda.setVersione(0);
		M_Azienda.aggiornaAziendaRemoto(azienda);

		confermaCancAzienda.getInstance().setVisible(false);		
		confermaCancAzienda.cancInst();
		PrimaryMandanteView.getInstance().resetPannelloCentraleAzienda();
		PrimaryMandanteView.getInstance().setSfondoAzienda();
		AlberoAziende.refresh();
		AlberoListini.refresh();
	}
	
	public void notConfermaCancAzienda(){
		confermaCancAzienda.getInstance().setVisible(false);
		confermaCancAzienda.cancInst();
	}
	
	public void visualizzaListino(int idAzienda){
		try {
			Ctrl_gestisciListino.getInstance().recuperaListino(idAzienda);
		} 
		catch (PersistentException e) {
			e.printStackTrace();
		}
		PrimaryMandanteView.getInstance().selectTabListino();
	}
	
}
