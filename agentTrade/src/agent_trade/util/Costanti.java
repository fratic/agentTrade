package agent_trade.util;


/**
 * Classe usata per aumentare la flessibilità che contiene tutte le costanti usate in agentTrade
 */

public final class Costanti {
	
	
	
	/**
	 * Versione software
	 */
	
//	public final static String  version = "agente";
	public final static String  version = "mandante";

	
	public final static String  agente = "agente";
	public final static String  mandante = "mandante";


	/**
	 * Look & Feel
	 */
	
//	public final static int  Look_Feel = 1;
//	public final static int  Look_Feel = 2;
//	public final static int  Look_Feel = 3;
//	public final static int  Look_Feel = 4;
	public final static int  Look_Feel = 5;
//	public final static int  Look_Feel = 6;
	
	
	/**
	 * Formato della Data
	 */
//	public final static SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd-MM-yyyy");
	
	
	public final static double  IVA= (float) 0.22;

	
	
	/**
	 * Titoli delle Schermate
	 */
	public final static String TITOLO_LOGIN = "Agent Trade | Login ";
	public final static String TITOLO_MANDANTE_LOGIN = "Agent Trade - Versione Mandante| Login ";

	
	public final static String TITOLO_PRIMARY_VIEW = "Agent Trade";
	public final static String TITOLO_MANDANTE_PRIMARY_VIEW = "Agent Trade - Versione Mandante";

	
	public final static String TITOLO_DIALOG_CLOSE = "Agent Trade | Exit  ";
	
	public final static String TITOLO_CERCA_CLIENTE = "Cerca Cliente";
	public final static String TITOLO_CANCELLA_CLIENTE = "Attenzione!";
	public final static String TITOLO_NUOVO_CLIENTE = "Nuova scheda cliente";
	public final static String TITOLO_SCHEDA_CLIENTE = "Scheda Cliente";
	
	public final static String TITOLO_NUOVO_AGENTE = "Nuova scheda agente";
	public final static String TITOLO_SCHEDA_AGENTE = "Scheda Agente";
	public final static String TITOLO_CERCA_AGENTE = "Cerca Agente ";
	public final static String TITOLO_CANCELLA_AGENTE = "Attenzione!";
	
	public final static String TITOLO_CERCA_AZIENDA = "Cerca Azienda ";
	public final static String TITOLO_SCHEDA_AZIENDA = "Scheda Azienda";
	public final static String TITOLO_NUOVA_AZIENDA = "Nuova scheda Azienda";
	public final static String TITOLO_CANCELLA_AZIENDA = "Attenzione!";


	/**
	 * Messaggi dei Dialog
	 */
	public final static String MESSAGGIO_UTENTE_NON_TROVATO = "Username non trovato";
	public final static String MESSAGGIO_NO_LOGIN= "Login fallito";
	public final static String MESSAGGIO_INSERISCI_CREDENZIALI= "Inserisci le tue credenziali per accedere ad Agent Trade";
	public final static String MESSAGGIO_CLOSE_APP= "Chiudere l'applicazione?";
	public final static String MESSAGGIO_COPYRIGHT= "Copyright \u00A9 2017 Agent Trade";
	public final static String MESSAGGIO_CAMPI_VUOTI = "Inserisci tutti i campi";
	public final static String MESSAGGIO_CAMPI_ERRATI = "I seguenti campi sono errati: ";
	public final static String MESSAGGIO_CLIENTE_NON_TROVATO = "Cliente non trovato";
	public final static String MESSAGGIO_CANCELLA_CLIENTE = "Sei sicuro di voler cancellare il cliente corrente?";
	public final static String MESSAGGIO_AGENTE_NON_TROVATO = "Agente non trovato";
	public final static String MESSAGGIO_CANCELLA_AGENTE = "Sei sicuro di voler cancellare l'agente corrente?";
	public final static String MESSAGGIO_AZIENDA_NON_TROVATA = "Azienda non trovata";
	public final static String MESSAGGIO_CANCELLA_AZIENDA = "Sei sicuro di voler cancellare l'azienda corrente?";
	
	
	
	/**
	 * Icone e immagini
	 */
	public static final String SPLASH_AGENTTRADE = "/agent_trade/ui/img/splash.png";
	public static final String AGENTTRADE_ICON = "/agent_trade/ui/img/icon.png";
	public static final String IMG_SFONDO_CLIENTE = "/agent_trade/ui/img/sfondoAgentTradeCliente.png";
	public static final String IMG_SFONDO_PREVENTIVO= "/agent_trade/ui/img/sfondoAgentTradePreventivo.png";
	public static final String IMG_SFONDO_AGENTE = "/agent_trade/ui/img/sfondoAgentTradeAgente.png";	
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
	public static final String ALBERO_CLIENTI_ICON = "/agent_trade/ui/img/ico-cliente1.png";
	public static final String SALVA_CLIENTI_ICON = "/agent_trade/ui/img/save_32.png";
	public static final String INDIETRO_ICON = "/agent_trade/ui/img/sign-out.png";
	public static final String COMUNICAZIONE_CLIENTE_ICON = "/agent_trade/ui/img/send-icon.png";
	public static final String MOD_CLIENTE_ICON = "/agent_trade/ui/img/settings_client.png";
	public static final String CANC_CLIENTE_ICON = "/agent_trade/ui/img/trash-icon.png";
	public static final String SALVA_MOD_CLIENTE_ICON = "/agent_trade/ui/img/save_32.png";
	public static final String ANNULLA_MOD_CLIENTE_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String RIEPILOGO_CLIENTE_ICON = "/agent_trade/ui/img/Img_cliente_riepilogo.png";
	public static final String DETTAGLIO_CLIENTE_ICON = "/agent_trade/ui/img/Img_cliente_dettaglio.png";
	
	public static final String AGENTE_ICON= "/agent_trade/ui/img/cliente.png";
	public static final String NUOVO_AGENTE_ICON= "/agent_trade/ui/img/new_user.png";
	public static final String CERCA_AGENTE_ICON= "/agent_trade/ui/img/search.png";
	public static final String SALVA_AGENTI_ICON = "/agent_trade/ui/img/save_32.png";
	public static final String COMUNICAZIONE_AGENTE_ICON = "/agent_trade/ui/img/send-icon.png";
	public static final String MOD_AGENTE_ICON = "/agent_trade/ui/img/settings_client.png";
	public static final String CANC_AGENTE_ICON = "/agent_trade/ui/img/trash-icon.png";
	public static final String SALVA_MOD_AGENTE_ICON = "/agent_trade/ui/img/save_32.png";
	public static final String ANNULLA_MOD_AGENTE_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String RIEPILOGO_AGENTE_ICON = "/agent_trade/ui/img/Img_cliente_riepilogo.png";
	public static final String DETTAGLIO_AGENTE_ICON = "/agent_trade/ui/img/Img_cliente_dettaglio.png";
	public static final String ALBERO_AGENTI_ICON = "/agent_trade/ui/img/ico-cliente1.png";

	public static final String AZIENDA_ICON = "/agent_trade/ui/img/azienda.png";
//	CAMBIARE ICONE
	public static final String NUOVA_AZIENDA_ICON = "/agent_trade/ui/img/azienda.png";
	public static final String CERCA_AZIENDA_ICON = "/agent_trade/ui/img/azienda.png";
	public static final String SALVA_AZIENDA_ICON = "/agent_trade/ui/img/save_32.png";
	public static final String IMG_SFONDO_AZIENDA = "/agent_trade/ui/img/sfondoAgentTradeAgente.png";
	public static final String RIEPILOGO_AZIENDA_ICON = "/agent_trade/ui/img/Img_cliente_riepilogo.png";
	public static final String COMUNICAZIONE_AZIENDA_ICON = "/agent_trade/ui/img/send-icon.png";
	public static final String MOD_AZIENDA_ICON = "/agent_trade/ui/img/settings_client.png";
	public static final String CANC_AZIENDA_ICON = "/agent_trade/ui/img/trash-icon.png";
	public static final String SALVA_MOD_AZIENDA_ICON = "/agent_trade/ui/img/save_32.png";
	public static final String ANNULLA_MOD_AZIENDA_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String DETTAGLIO_AZIENDA_ICON = "/agent_trade/ui/img/Img_cliente_dettaglio.png";
	public static final String ALBERO_AZIENDE_ICON = "/agent_trade/ui/img/ico-cliente1.png";
		
	/**
	 * URL dei Sistemi Esterni
	 */
//	public final static String URL_blabla= "http://www.boh.com/";

	
	
	/**
	 * Espressioni regolari 
	 */
	public final static String REG_EX_FLOAT = "(\\d*[.,])?\\d+";
	public final static String REG_EX_COGNOME = "[a-zA-Z0-9'._%-& \\s]+";
	public final static String REG_EX_NOME = "[a-zA-Z'\\s]+";
	public final static String REG_EX_COD_FISC = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
	public final static String REG_EX_PART_IVA = "[0-9]{11}";
	public final static String REG_EX_INDIRIZZO = "[a-zA-Z'. \\s]+[0-9]{0,4}";
	public final static String REG_EX_CITTA = "[a-zA-Z'\\s]+";
	public final static String REG_EX_CAP = "[0-9]{5}";
	public final static String REG_EX_TELEFONO = "[0-9]{10}";
	public final static String REG_EX_CELLULARE = "[0-9]{10}";
	public final static String REG_EX_FAX = "[0-9]{10}";
	public final static String REG_EX_EMAIL = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
	public final static String REG_EX_LIVELLO = "[1-5]{1}";
	public final static String REG_EX_COGNOME_AGENTE = "[a-zA-Z'\\s]+";
	public final static String REG_EX_USERNAME = "[a-zA-Z0-9'\\s]{3,10}";
	public final static String REG_EX_PASSWORD = "[a-zA-Z0-9'\\s]{3,10}";
	
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
	 * Dimensioni contenitori, label e TF nelle view dettaglio/riepilogo cliente/agente
	 */
	public final static int WIDTH_PANN_CENTRO = 485;
	public final static int HEIGHT_PANN_CENTRO = 610;
	public final static int WIDTH_PANN_CONTENITORE = 485;
	public final static int HEIGHT_PANN_CONTENITORE = 500;
	public final static int WIDTH_PANN_ICONA = 50;
	public final static int HEIGHT_PANN_ICONA = 601;
	public final static int WIDTH_PANN_LABEL = 421;
	public final static int HEIGHT_PANN_LABEL = 20;
	public final static int WIDTH_PANN_LABEL_ERRORE = 435;
	public final static int HEIGHT_PANN_LABEL_ERRORE = 20;
	public final static int WIDTH_PANN_EAST = 70;
	public final static int HEIGHT_PANN_EAST = 601;
	public final static int WIDTH_PANN_BOTTONI = 70;
	public final static int HEIGHT_PANN_BOTTONI = 500;
	public final static int WIDTH_LABEL = 160;
	public final static int HEIGHT_LABEL = 15;
	public final static int WIDTH_LABEL_ERRORE = 435;
	public final static int HEIGHT_LABEL_ERRORE = 15;
	public final static int WIDTH_TEXT_FIELD= 261;
	public final static int HEIGHT_TEXT_FIELD = 20;
	public final static int WIDTH_BUTTON = 50;
	public final static int HEIGHT_BUTTON = 50;
	public final static int FONT = 13;
	public final static int WIDTH_ICON = 50;
	public final static int HEIGHT_ICON = 50;
	
	
	/**
	 * Label e Stringhe generiche
	 */
	public final static String LABEL_USERNAME = "Username";
	public final static String LABEL_PASSWORD= "Password";
	
	public final static String TAB_PREVENTIVO= "Preventivo";
	public final static String TAB_CATALOGO= "Catalogo";
	public final static String TAB_CLIENTE= "Cliente";
	public final static String TAB_AGENTE= "Agente";
	public final static String TAB_AZIENDA= "Azienda";

	public final static String ROOT_PREVENTIVI= "Preventivi";
	public final static String ROOT_CLIENTI= "Clienti";

	public final static String LABEL_INTESTAZIONE= "Intestazione";
	public final static String LABEL_NPREV= "Preventivo n\u00B0";
	public final static String LABEL_DEL= "del";
	public final static String LABEL_EFFETTUATO_AG= "effettuato dall'agente: ";
	public final static String LABEL_Cliente= "Cliente: ";
	
	public final static String LABEL_IMPONIBILE= "Imponibile";
	public final static String LABEL_IVA= "IVA "+java.lang.Math.ceil(IVA*100)+"%";
	public final static String LABEL_TOTALE= "Totale";

	public final static String LABEL_CERCA_CLIENTE = "Cerca Cliente";
	
	public final static String LABEL_ID = "Codice cliente";
	public final static String LABEL_COGNOME = "Cognome o Ragione sociale";
	public final static String LABEL_NOME_CLIENTE = "Nome";
	public final static String LABEL_COD_FISC = "Codice Fiscale";
	public final static String LABEL_PARTITA_IVA = "Partita Iva";
	public final static String LABEL_INDIRIZZO = "Indirizzo";
	public final static String LABEL_CITTA = "Citt\u00E0";
	public final static String LABEL_CAP = "CAP";
	public final static String LABEL_TELEFONO = "Telefono";
	public final static String LABEL_CELLULARE = "Cellulare";
	public final static String LABEL_FAX = "Fax";
	public final static String LABEL_EMAIL = "Email";
	public final static String LABEL_AGENTE_RIF = "Agente di riferimento";
	public final static String LABEL_ERRORE_CAMPI = "";
	
	public final static String LABEL_CERCA_AGENTE = "Cerca Agente";

	public final static String LABEL_ID_AGENTE = "Codice agente";
	public final static String LABEL_NOME = "Nome";
	public final static String LABEL_COGNOME_AGENTE = "Cognome";
	public final static String LABEL_LVL ="Livello";
	
	public final static String ROOT_AGENTI= "Agenti";

	public final static String LABEL_NOME_AZIENDA = "Ragione sociale";
	public final static String LABEL_ID_AZIENDA = "Codice azienda";
	public final static String LABEL_URL_AZIENDA = "Url";
	
	public final static String ROOT_AZIENDE = "Aziende";
	

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

	public final static String TIP_COGNOME = "Sono ammessi i caratteri '-_.&' Es: 'Rossi', 'Ciccio & co.'";
	public final static String TIP_NOME_CLIENTE = "Non sono ammessi caratteri numerici";
	public final static String TIP_COD_FIS = "Es: 'aaabbb11c23d456e'";
	public final static String TIP_PARTITA_IVA = "Codice di undici cifre Es: '12345678901'";
	public final static String TIP_INDIRIZZO = "Es: 'Via Roma 100'";
	public final static String TIP_CITTA = "Non sono ammessi caratteri numerici";
	public final static String TIP_CAP = "Codice di cinque Cifre";
	public final static String TIP_TELEFONO = "Numero di dieci cifre";
	public final static String TIP_CELLULARE = "Numero di dieci cifre";
	public final static String TIP_FAX = "Numero di dieci cifre";
	public final static String TIP_EMAIL = "ES: esempio_12@esempio.com";
	public final static String TIP_SALVA_CLIENTE = "Salva il cliente";
	public final static String TIP_TORNA_INDIETRO = "Torna indietro";
	public final static String TIP_COMUNICAZIONE_CLIENTE = "Invia comunicazione";
	public final static String TIP_MODIFICA_CLIENTE = "Modifica i dati del cliente";
	public final static String TIP_CANCELLA_CLIENTE = "Cancella cliente";
	public final static String TIP_SALVA_MOD_CLIENTE = "Salva modifiche";
	public final static String TIP_ANNULLA_MOD_CLIENTE = "Annulla modifiche";
	
	public final static String TIP_NUOVO_AGENTE= "Inserisci un nuovo agente";
	public final static String TIP_CERCA_AGENTE= "Cerca un agente";
	public final static String TIP_GESTISCI_AGENTE= "Gestisci gli agenti";

	public final static String TIP_SALVA_AGENTE = "Salva l'agente";
	public final static String TIP_COMUNICAZIONE_AGENTE = "Invia comunicazione";
	public final static String TIP_MODIFICA_AGENTE = "Modifica i dati dell'agente";
	public final static String TIP_CANCELLA_AGENTE = "Cancella agente";
	public final static String TIP_SALVA_MOD_AGENTE = "Salva modifiche";
	public final static String TIP_ANNULLA_MOD_AGENTE = "Annulla modifiche";
	
	
	public final static String TIP_NOME = "Non sono ammessi caratteri numerici";
	public final static String TIP_LIVELLO = "Inserire il livello dell'agente (da 1 a 5)";	
	public final static String TIP_USERNAME = "Inserire un username di almeno 4 caratteri";
	public final static String TIP_PASSWORD = "Inserire un password di almeno 4 caratteri";
	
	public final static String TIP_GESTISCI_AZIENDA = "Gestisci le aziende";
	public final static String TIP_NUOVA_AZIENDA = "Inserisci una nuova azienda";
	public final static String TIP_CERCA_AZIENDA = "Cerca un'azienda";
	//MODIFICARE TIP NOME AZIENDA
	public final static String TIP_NOME_AZIENDA = "Non sono ammessi caratteri numerici";
	public final static String TIP_URL_AZIENDA = "Inserire l'url del DB dell'azienda se disponibile";
	
	public final static String TIP_SALVA_AZIENDA = "Salva l'azienda";
	public final static String TIP_COMUNICAZIONE_AZIENDA = "Invia comunicazione";
	public final static String TIP_MODIFICA_AZIENDA = "Modifica i dati dell'azienda";
	public final static String TIP_CANCELLA_AZIENDA = "Cancella azienda";
	public final static String TIP_SALVA_MOD_AZIENDA = "Salva modifiche";
	public final static String TIP_ANNULLA_MOD_AZIENDA = "Annulla modifiche";
	
	
	/**
	 * Bottoni
	 */
	public final static String BOTTONE_ACCEDI = "Accedi";

	public final static String BOTTONE_CERCA = "Cerca";
	public final static String BOTTONE_INSERISCI = "Inserisci";
	public final static String BOTTONE_CONFERMA = "Ok";
	public final static String BOTTONE_ANNULLA = "Annulla";
	public final static String BOTTONE_VISUALIZZA = "Visualizza";
	
	
	/**
	 * Intestazioni tabelle
	 */

	
	public final static String[] INTESTAZIONE_TABELLA_PREVENTIVI = {"Rimuovi", "ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo Unitario", "Sconto", "Parziale" };
	public final static String[] INTESTAZIONE_TABELLA_RIEPILOGO_ITEM= {"ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo Unitario", "Sconto", "Parziale" };
	public final static String[] INTESTAZIONE_TABELLA_PRODOTTI = {"ID prodotto", "Nome", "Categoria", "Sconto", "Prezzo", "Aggiungi" };
	public final static String[] INTESTAZIONE_TABELLA_CERCA_CLIENTI = {"ID", "Cognome", "Nome", "Codice Fiscale", "P.IVA"};
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_CLIENTI = {"ID", "Cognome", "Nome","Codice Fiscale", "Partita iva", "Citt\u00E0" };
	
	public final static String[] INTESTAZIONE_TABELLA_CERCA_AGENTI = {"ID", "Cognome", "Nome", "Codice Fiscale", "P.IVA"};
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_AGENTI = {"ID", "Cognome", "Nome", "Livello", "Email", "Citt\u00E0"};
	
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_AZIENDE = {"ID", "Nome o Ragione Sociale", "Codice Fiscale", "P.IVA", "Citt\u00E0"};
	
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
