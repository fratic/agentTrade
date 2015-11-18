package coedil99.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import coedil99.application.controller.CtrlGestisciMagazzino;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.BulloneDAO;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.ElementoDistintaListCollection;
import coedil99.persistentmodel.ElementoMagazzino;
import coedil99.persistentmodel.ElementoMagazzinoDAO;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.FornitoreDAO;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.LastraDAO;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.MagazzinoDAO;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.Trave;
import coedil99.persistentmodel.TraveDAO;

public class MMagazzino implements AModel,Observer {
	
	private APersistentModel model;
	private ElementoMagazzino em;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	public MMagazzino(int index){
		this.model = MagazzinoDAO.loadMagazzinoByQuery("id = " + index, "ID");
	}
	
	public ArrayList<Object[]> getElementiMagazzino() {
		ArrayList<Object[]> dati = new ArrayList<Object[]>();		
		Magazzino magazzino = (Magazzino)this.model;
		Iterator i = magazzino.elementoMagazzino__List_.getIterator();
		while(i.hasNext()){
			ElementoMagazzino e = (ElementoMagazzino)i.next();
			if(e!=null){
			Object [] objD = new Object[10];
			objD[0] = (Object) e.getItem().getClass().getName().split("\\.")[2]; //prendo solo l'ultima parte del nome
			objD[1] = (Object) e.getItem().getDescrizione();
			if (((Item) (e).getItem()).getClass().getName().split("\\.")[2].equals("Lastra")) {
				objD[2] = (Object) ((Lastra) (e).getItem()).getMateriale();
			} else {
				objD[2] = "/";
			}
			objD[3] = (Object) e.getItem().getPeso();
			if (((Item) (e).getItem()).getClass().getName().split("\\.")[2].equals("Bullone")) {
				objD[4] = (Object) ((Bullone) (e).getItem()).getDiametro();
			} else {
				objD[4] = "/";
			}
			if (((Item) (e).getItem()).getClass().getName().split("\\.")[2].equals("Trave")) {
				objD[5] = (Object) ((Trave) (e).getItem()).getLunghezza();
			} else {
				objD[5] = "/";
			}
			objD[6] = (Object) e.getItem().getTipoSagoma();
			objD[7] = (Object) e.getItem().getPrezzo();
			objD[8] = (Object) e.getQuantita();
			if((e.get_fornitore()) == null){
				objD[9] = "/";
				}
			else{
				objD[9] = (Object) e.get_fornitore().getDitta();
			}
			dati.add(objD);
			}
		}
		return dati;
	}

	
	@Override
	public void update(Observable arg0, Object arg1) {
		ArrayList<ElementoDistinta> distinta = ((MPreventivo)arg1).getDistinta();
		coedil99.persistentmodel.ElementoMagazzinoListCollection magazzino = ((Magazzino)this.getPersistentModel()).elementoMagazzino__List_;
		ArrayList<ElementoRDA> rda = new ArrayList<ElementoRDA>();
		boolean evaso = true;
		Boolean trovato = false;
		
		if(((Preventivo)((MPreventivo)arg1).getPersistentModel()).getFirmato()){	
			for (int i = 0; i < distinta.size(); i++) {
				for (int j = 0; j < magazzino.size(); j++) {
					if (distinta.get(i).getItem().getID() == magazzino.get(j).getItem().getID()){    // Cerca l'item dell'ElementoDistinta tra item degli ElemetoMagazzino (aggiungere controllo: se l'item nella distinta non si trova nel magazzino?)
						trovato = true;
						if (distinta.get(i).getNPezzi() <= magazzino.get(j).getQuantita()){          // Sei il numero di pezzi richiesto nel preventivo lo riesco a coprire con quello che già ho, allora decremento la quantità in magazzino
							if(MRaccoglitoreRDA.getInstance().checkElemento(distinta.get(i).getItem())){//controlla se è già presente un'rda per lo stesso item (se si decremento x dal magazzino e aggiungo x alla quantità dell'elementoRDA)
								ElementoRDA elemento = new ElementoRDA();
								elemento.setItem(distinta.get(i).getItem());
								elemento.setQuantita(distinta.get(i).getNPezzi());
								rda.add(elemento);
							}
							int quantita = magazzino.get(j).getQuantita() - distinta.get(i).getNPezzi();
							if (quantita != 0){				//se la quantità e maggiore di zero allora aggiorno l'elemento magazzino, se è uguale a zero elimino l'elemento magazzino
								magazzino.get(j).setQuantita(quantita);
							}
							else{
								magazzino.remove(j);
							}
							distinta.get(i).setEvaso(true);
						}	
						else{ //Se la quantità richiesta è superiore alla giacenza in magazzino, aggiungi alla lista della RDA
							ElementoRDA elemento = new ElementoRDA();
							elemento.setItem(distinta.get(i).getItem());
							if(MRaccoglitoreRDA.getInstance().checkElemento(elemento.getItem())){
								elemento.setQuantita(distinta.get(i).getNPezzi());
							}
							else{
								elemento.setQuantita(distinta.get(i).getNPezzi() - magazzino.get(j).getQuantita());
								// la quantità in  magazzino va sottratta solo se non esiste una rda per quell'elemento magazzino
							}
							rda.add(elemento);
							evaso = false;
						}
					}
				}
				if(!trovato) { //se l'elemento non è presente nel magazzino, dopo che ho scorso tutto il magazzino creo direttamente una RDA
					ElementoRDA elemento = new ElementoRDA();
					elemento.setItem(distinta.get(i).getItem());
					elemento.setQuantita(distinta.get(i).getNPezzi());
					rda.add(elemento);
				}
			}	
			//setta lo stato di evasione di un preventivo firmato
			((MPreventivo)arg1).statoEvasione(evaso);
			if(!rda.isEmpty()) MRaccoglitoreRDA.getInstance().insertRDA(rda);
			CtrlGestisciMagazzino.getInstance().aggiornaMagazzino();
		} 	
	}
	
	
	//salva o aggiorna un elemento del magazzino (e nel caso crea un nuovo item)
	public void salvaElementoMagazzino(String tipoElemento, Integer tipoSagoma, String descrizione, Float diametro, String materiale, Float lunghezza, Double peso, Double prezzo, int quantita, int idFornitore){
		 //Prova, nel caso verrà fatto nel controller e passato come paramentro (se la creazione di em spetta al controller)
		if  ( tipoElemento.equals("Bullone") ) {
			Bullone b = BulloneDAO.loadBulloneByQuery("diametro = " + diametro, "ID");
			if(b != null){
				this.em = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b, "ID");
				if(em == null){ //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					this.createElementoMagazzino();
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					quantita+=em.getQuantita();
				}
			}
			else{
				b = new Bullone(); 
				b.setDescrizione(descrizione);
				b.setPeso(peso);
				b.setPrezzo(prezzo);
				b.setDiametro(diametro);
				BulloneDAO.save(b);
				this.createElementoMagazzino();
			}	
			setEMProperty(quantita, idFornitore, b);
		}
		
		else if  ( tipoElemento.equals("Lastra") ) {
			Lastra l = LastraDAO.loadLastraByQuery("materiale = '" + materiale+"'", "ID");
			if(l != null){
				this.em = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + l, "ID");
				if(em == null){ //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					this.createElementoMagazzino();
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					quantita+=em.getQuantita();
				}
			}
			else{	
				l = new Lastra();
				l.setDescrizione(descrizione);
				l.setPeso(peso);
				l.setPrezzo(prezzo);
				l.setTipoSagoma(tipoSagoma);
				l.setMateriale(materiale);
				LastraDAO.save(l);	
				this.createElementoMagazzino();
			}
			setEMProperty(quantita, idFornitore, l);
		}
		else if  ( tipoElemento.equals("Trave") ){
			Trave t = TraveDAO.loadTraveByQuery("lunghezza = " + lunghezza, "ID");
			if(t != null){
				this.em = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + t, "ID");
				if(em == null){ //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					this.createElementoMagazzino();		
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					quantita+=em.getQuantita();
				}
			}
			else{	
				t = new Trave();
				t.setDescrizione(descrizione);
				t.setPeso(peso);
				t.setPrezzo(prezzo);
				t.setLunghezza(lunghezza);
				t.setTipoSagoma(tipoSagoma);
				TraveDAO.save(t);	
				this.createElementoMagazzino();
				
			}
			setEMProperty(quantita, idFornitore, t);
		}
		this.checkPreventiviNonEvasi(em);
		if(em.getQuantita() == 0) ((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.remove(em);
		MagazzinoDAO.save((Magazzino)this.getPersistentModel());
	}

	private void setEMProperty(int quantita, int idFornitore, Item i) {
		em.set_fornitore(FornitoreDAO.loadFornitoreByQuery("ID =" + idFornitore, "ID"));
		em.setQuantita(quantita);
		em.setItem(i);
	}

	public void createElementoMagazzino() {
		this.em = ElementoMagazzinoDAO.createElementoMagazzino();
		((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
	}

	
	//controlla se l'elemento magazzino inserito può riuscire a soddisfare un preventivo non evaso.
	public void checkPreventiviNonEvasi(ElementoMagazzino elemento){
		MPreventivo[] mp = MPreventivo.getPreventiviNonEvasi();
		if (mp != null){
			ElementoDistintaListCollection list;
			boolean evaso= true;
			for (int i = 0; i < mp.length; i++) {	
				list = ((Preventivo)mp[i].getPersistentModel()).getDistinta().elemento__List_;
				for( int j = 0 ; j< list.size(); j++){
					if ( list.get(j).getItem().equals(elemento.getItem()) && list.get(j).getNPezzi() <= elemento.getQuantita() ){
						list.get(j).setEvaso(true);
						elemento.setQuantita(elemento.getQuantita() - list.get(j).getNPezzi());
					}
					else
						evaso &=list.get(i).getEvaso();
				}
				if(evaso) mp[i].statoEvasione(true);	
			}
		}
	}
}
