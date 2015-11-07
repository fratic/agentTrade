package coedil99.application.controller;

import java.util.ArrayList;

import coedil99.model.MFornitore;
import coedil99.model.MOrdine;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.FornitoreDAO;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.Ordine;
import coedil99.persistentmodel.OrdineDAO;
import coedil99.ui.Coedil99View;
import coedil99.ui.OrdiniView;
import coedil99.ui.content.RdaView;


public class CtrlGestisciRDA implements CtrlFornitore{
	

	private MOrdine newOrdine;
	
	private static CtrlGestisciRDA instance;
	
	public static CtrlGestisciRDA getInstance(){
		if(instance == null)
			instance = new CtrlGestisciRDA();
		
		return instance;
	}
	
	private CtrlGestisciRDA(){}
	
	
	public Item[] loadItems() {
		return ItemDAO.listItemByQuery(null, "discriminator");
		
	}
	
	public void createLineRDA(String id, String tipoElemento, String diametro, String materiale, String lunghezza, int quantita) {
		Object[] obj = {id, tipoElemento,diametro,materiale,lunghezza,quantita};
		RdaView.getInstance().aggiungiRiga(obj);
		RdaView.getInstance().hideMakeNewLineRda();
	}
	
	public void popupNewLineRda() {
		RdaView.getInstance().showMakeNewLineRda(this.loadItems());
	}


	public void apriNuovaRDADirettore() {
		RdaView.getInstance().nuovaSchedaRda();
		RdaView.getInstance().setVisible(true);
	}
	
	/*
	 * SEZIONE ORDINI
	 */
	public void apriOrdini() {

		OrdiniView.getInstance().setOrdini(OrdineDAO.listOrdineByQuery(null, null));
		OrdiniView.getInstance().setElements(MRaccoglitoreRDA.getInstance().getRDAArray());
		this.createOrdine();
		OrdiniView.getInstance().reset();
		OrdiniView.getInstance().setVisible(true);
	}
	
	public void removeElementoRDA(int index){
		MRaccoglitoreRDA.getInstance().removeElementoRDA(index);
		OrdiniView.getInstance().removeElementRDA(index);
	}
	
	public void createOrdine(){
		this.newOrdine = new MOrdine();
	}
	
	public void listaFornitori(){
		OrdiniView.getInstance().showFornitori(FornitoreDAO.listFornitoreByQuery(null, null));
	}
	
	public void apriFornitore(Fornitore f){
		this.newOrdine.setFornitore(f);
		OrdiniView.getInstance().getNewOrdine().setFornitore(f);
		OrdiniView.getInstance().hideFornitori();
	}
	
	public void inviaRda(ArrayList<Object[]> tableData) {
		MRaccoglitoreRDA.getInstance().creaPrincipaleRDA(tableData);
		this.salvataRda();
	}

	public void salvataRda() {
		RdaView.getInstance().setButtonSalvaInvisible();
		RdaView.getInstance().dispose();
		RdaView.getInstance().revalidate();
		RdaView.getInstance().repaint();
	}

	public void salvaOrdine(String consegnaPrevista) {
		this.newOrdine.salva(consegnaPrevista);
		MRaccoglitoreRDA.getInstance().salva();
		OrdiniView.getInstance().reset();
		OrdiniView.getInstance().updateOrdini((Ordine)this.newOrdine.getPersistentModel());
		this.createOrdine();
	}

	public void addElementoRDAtoOrdine(int index) {
		ElementoRDA e = MRaccoglitoreRDA.getInstance().getElementAt(index);
		this.newOrdine.aggiungiElemento( e);
		OrdiniView.getInstance().getNewOrdine().addElement(e);
	}

	@Override
	public void nuovoFornitore(String codice, String telefono, String ditta) {
		MFornitore f = new MFornitore();
		f.salvaNuovoFornitore(codice, telefono, ditta);	
		Coedil99View.getInstance().hideNewFornitori();
		this.apriFornitore((Fornitore)f.getPersistentModel());	
		
	}
}