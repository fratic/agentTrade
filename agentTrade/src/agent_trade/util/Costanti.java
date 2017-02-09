package agent_trade.util;


/**
 * Classe usata per aumentare la flessibilità che contiene tutte le costanti usate in agentTrade
 */

public final class Costanti {
	
	/**
	 * Formato della Data
	 */
//	public final static SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd-MM-yyyy");
	
	
	public final static double  IVA= (float) 0.22;

	
	
	/**
	 * Titoli delle Schermate
	 */
	public final static String TITOLO_LOGIN = "Agent Trade | Login ";
	public final static String TITOLO_PRIMARY_VIEW = "Agent Trade";
	public final static String TITOLO_DIALOG_CLOSE = "Agent Trade | Exit  ";


	/**
	 * Messaggi dei Dialog
	 */
//	public final static String MESSAGGIO_UTENTE_NON_TROVATO = "Utente non trovato, ricontrollare le credenziali di accesso.";
	public final static String MESSAGGIO_INSERISCI_CREDENZIALI= "Inserisci le tue credenziali per accedere ad Agent Trade";
	public final static String MESSAGGIO_CLOSE_APP= "Chiudere l'applicazione?";
	public final static String MESSAGGIO_COPYRIGHT= "Copyright \u00A9 2017 Agent Trade";
	/**
	 * Icone e immagini
	 */
	public static final String SPLASH_AGENTTRADE = "/agent_trade/ui/img/splash.png";
	public static final String AGENTTRADE_ICON = "/agent_trade/ui/img/icon.png";
	public static final String IMG_SFONDO_CLIENTE = "/agent_trade/ui/img/sfondoAgentTradeCliente.png";
	public static final String IMG_SFONDO_PREVENTIVO= "/agent_trade/ui/img/sfondoAgentTrade2.png";
	public static final String CLOSE_ICON= "/agent_trade/ui/img/close_icon.png";
	public static final String PLUS_ICON= "/agent_trade/ui/img/plus.png";
	public static final String PREVENTIVO_ICON= "/agent_trade/ui/img/preventivo.png";
	public static final String NUOVO_PREVENTIVO_ICON= "/agent_trade/ui/img/nuovo_icon.png";
	public static final String CLIENTE_ICON= "/agent_trade/ui/img/cliente.png";	
	public static final String NUOVO_CLIENTE_ICON= "/agent_trade/ui/img/new_user.png";
	public static final String CERCA_CLIENTE_ICON= "/agent_trade/ui/img/search.png";
	public static final String PRODOTTI_ICON= "/agent_trade/ui/img/magazzino_icon.png";
	public static final String ALBERO_PREVENTIVI_ICON= "/agent_trade/ui/img/prev.png";
	public static final String ADD_ITEM_ICON= "/agent_trade/ui/img/add-item.png";
	public static final String SAVE_ICON= "/agent_trade/ui/img/save-icon.png";
	public static final String SETTING_ICON= "/agent_trade/ui/img/setting.png";
	public static final String CONFERMA_ORDINE_ICON= "/agent_trade/ui/img/carrelloOrdine.png";
	public static final String CANCELLA_PREV_ICON= "/agent_trade/ui/img/delete.png";
	
	
	/**
	 * URL dei Sistemi Esterni
	 */
//	public final static String URL_blabla= "http://www.boh.com/";

	
	
	/**
	 * Espressioni regolari 
	 */
	public final static String REG_EX_FLOAT = "(\\d*[.,])?\\d+";

	
	
	
	/**
	 * Dimensioni finestre
	 */
	public final static int WIDTH_LOGIN = 370;
	public final static int HEIGHT_LOGIN = 240;
	
	public final static int WIDTH_PRIMARY = 1024;
	public final static int HEIGHT_PRIMARY = 784;
	public final static int MIN_WIDTH_PRIMARY = 784;
	public final static int MIN_HEIGHT_PRIMARY = 512;

	
	
	/**
	 * Label e Stringhe generiche
	 */
	public final static String LABEL_USERNAME = "Username";
	public final static String LABEL_PASSWORD= "Password";
	
	public final static String TAB_PREVENTIVO= "Preventivo";
	public final static String TAB_CATALOGO= "Catalogo";
	public final static String TAB_CLIENTE= "Cliente";
	
	public final static String ROOT_PREVENTIVI= "Preventivi";

	public final static String LABEL_INTESTAZIONE= "Intestazione";
	public final static String LABEL_NPREV= "Preventivo n\u00B0";
	public final static String LABEL_DEL= "del";
	public final static String LABEL_EFFETTUATO_AG= "effettuato dall'agente: ";
	public final static String LABEL_Cliente= "Cliente: ";
	
	public final static String LABEL_IMPONIBILE= "Imponibile";
	public final static String LABEL_IVA= "IVA "+java.lang.Math.ceil(IVA*100)+"%";
	public final static String LABEL_TOTALE= "Totale";

	

	/**
	 * Tip
	 */
	public final static String TIP_GESTISCI_PREVENTIVO= "Gestisci i preventivi";
	public final static String TIP_NUOVO_PREVENTIVO= "Crea un nuovo preventivo";
	public final static String TIP_GESTISCI_CLIENTE= "Gestisci i clienti";
	public final static String TIP_INSERISCI_CLIENTE= "Inserisci un nuovo cliente";
	public final static String TIP_CERCA_CLIENTE= "Cerca il cliente";
	public final static String TIP_ANNULLA_PREV= "Annulla il preventivo in corso";
	public final static String TIP_ADD_ITEM= "Aggiungi prodotti a questo preventivo";
	public final static String TIP_SALVA_PREV= "Salva preventivo";
	public final static String TIP_MODIFICA_PREV= "Modifica Preventivo";
	public final static String TIP_CONFERMA_ORDINE= "Conferma ordine";
	public final static String TIP_CANCELLA_PREV= "Cancella Preventivo";

	
	
	/**
	 * Bottoni
	 */
	public final static String BOTTONE_ACCEDI = "Accedi";

	
	
	/**
	 * Intestazioni tabelle
	 */
//	public final static String[] LISTA_RUOLI = { "Commesso", "Responsabile Offerte", "Direttore" };

	
	public final static String[] INTESTAZIONE_TABELLA_PREVENTIVI = {"Rimuovi", "ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo Unitario", "Sconto", "Parziale" };
	public final static String[] INTESTAZIONE_TABELLA_RIEPILOGO_ITEM= {"ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo Unitario", "Sconto", "Parziale" };
	public final static String[] INTESTAZIONE_TABELLA_PRODOTTI = {"ID prodotto", "Nome", "Categoria", "Sconto", "Prezzo", "Aggiungi" };

	
	/**
	 * Costanti colonne
	 */
	public final static int  COLONNA_ID_DISABLE_BUTTON = 0;
	public final static int  COLONNA_BOTTONE_DISABLE_BUTTON = 5;
	
	public final static int  COLONNA_ADD_ITEM= 5;
	
	public final static int  COLONNA_ID_REMOVE_ITEM= 1;
	
	public final static int  COLONNA_QUANTITA_TAB_PROD= 4;
	public final static int  COLONNA_REMOVE_TAB_PROD= 0;

	public final static int  COLONNA_PARZIALE_TAB_PREV= 7;

	
	
	
	
	
	
}
