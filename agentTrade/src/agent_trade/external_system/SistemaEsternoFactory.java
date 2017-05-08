package agent_trade.external_system;

import java.util.ArrayList;

import agent_trade.util.Costanti;


/**
 * Factory dei Sistemi Esterni
 */
public class SistemaEsternoFactory {
	/**
	 * Unica istanza della Classe
	 */
	private static SistemaEsternoFactory instance;

	
	/**
	 * Restituisce la singola istanza della Classe
	 * 
	 * @return SistemaEsternoFactory
	 */
	public static SistemaEsternoFactory getInstance() {
		if (instance == null)
			instance = new SistemaEsternoFactory();
		return instance;
	}

	/**
	 * Costruttore di default
	 */
	private SistemaEsternoFactory() {
	}

	/**
	 * Restituisce tutti i Sistemi Esterni supportati dal Software
	 * 
	 * @return ArrayList<SistemaEsterno>
	 */
	public ArrayList<SistemaEsterno> getSistemiEsterni() {
		ArrayList<SistemaEsterno> sistemi_esterni = new ArrayList<SistemaEsterno>();
		sistemi_esterni.addAll(this.getAziendeVino());
//		sistemi_esterni.addAll(this.getAziendeCarne());
		return sistemi_esterni;
	}

	/**
	 * Restituisce le Aziende di Vino supportate dal Software
	 * 
	 * @return ArrayList<AziendaViniAdapter>
	 */
	public ArrayList<AziendaViniAdapter> getAziendeVino() {
		ArrayList<AziendaViniAdapter> aziende_vino = new ArrayList<AziendaViniAdapter>();
		for (AziendaViniAdapter azienda_vino : Costanti.SISTEMI_ESTERNI_AZIENDE_VINI) {
			aziende_vino.add(azienda_vino);
		}
		return aziende_vino;
	}


	public SistemaEsterno getAdapter(String azienda) {
		
		ArrayList<SistemaEsterno> sistemi_ext = this.getSistemiEsterni();
		
		SistemaEsterno azienda_result=null;
		
		for (SistemaEsterno azienda_ext : sistemi_ext) {
			if (azienda_ext.getNomeAzienda().equals(azienda))
				azienda_result=azienda_ext;
		}
		return azienda_result;
	}




}
