package agent_trade.util;

import agent_trade.external_system.AziendaCarniAdapter;
import agent_trade.external_system.AziendaViniAdapter;
import agent_trade.external_system.beverage.BeverageAdapter;
import agent_trade.external_system.lem.LemAdapter;
import agent_trade.external_system.rivera.RiveraAdapter;

/**
 * Classe usata per aumentare la flessibilità che contiene tutte le costanti usate in agentTrade
 */

public final class Costanti {
	
	
	
	/**
	 * Versione software
	 */
	
	public static String  version = "agente";
//	public final static String  version = "mandante";

	public final static String  pathVersion = "C:/Users/Antonio/Documents/versione.txt";
//	public final static String  pathVersion = "C:/Users/pc/Desktop/versione.txt";

	public final static String  agente = "agente";
	public final static String  mandante = "mandante";


	/**
	 * Look & Feel
	 */
	
	
	public static int  Look_Feel = 0;
//	public final static int  Look_Feel = 1;
//	public final static int  Look_Feel = 2;
//	public final static int  Look_Feel = 3;
//	public final static int  Look_Feel = 4;
//	public final static int  Look_Feel = 5;
//	public final static int  Look_Feel = 6;

	
	public final static String  pathLook = "C:/Users/Antonio/Documents/look.txt";
//	public final static String  pathLook = "C:/Users/pc/Desktop/look.txt";


	
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
	
	public final static String TITOLO_CERCA_PREVENTIVO = "Cerca Preventivo";
	
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

	public final static String TITOLO_CERCA_LISTINO = "Cerca l'azienda di cui si vuole visualizzare il listino";
	public final static String TITOLO_SCHEDA_LISTINO = "Catalogo Prodotti";
	public final static String TITOLO_INTESTAZIONE_LISTINO = "Riepilogo Azienda";
	public final static String TITOLO_SCHEDA_PRODOTTO = "Dettaglio Prodotto";
	public final static String TITOLO_NUOVO_PRODOTTO = "Nuovo Prodotto";	
	public final static String TITOLO_CANCELLA_PRODOTTO = "Attenzione!";
	
	public final static String TITOLO_NUOVO_SCONTO = "Nuova scheda sconto";
	public final static String TITOLO_SELEZIONA_SCONTO = "Seleziona sconto";
	public final static String TITOLO_SCHEDA_SCONTO = "Scheda sconto";
	public final static String TITOLO_CANCELLA_SCONTO = "Attenzione!";
	public final static String TITOLO_CERCA_SCONTO = "Cerca Sconto";
	
	/**
	 * Messaggi dei Dialog
	 */
	public final static String MESSAGGIO_UTENTE_NON_TROVATO = "Username non trovato";
	public final static String MESSAGGIO_NO_LOGIN= "Login fallito";
	public final static String MESSAGGIO_INSERISCI_CREDENZIALI= "Inserisci le tue credenziali per accedere ad Agent Trade";
	public final static String MESSAGGIO_CLOSE_APP= "Chiudere l'applicazione?";
	public final static String MESSAGGIO_COPYRIGHT= "Copyright \u00A9 2017 Agent Trade";
	public final static String MESSAGGIO_CAMPI_VUOTI = "Inserisci tutti i campi";
	public final static String MESSAGGIO_CAMPI_VUOTI_CLIENTE = "I campi con * sono obbligatori";
	public final static String MESSAGGIO_CAMPI_ERRATI = "I seguenti campi sono errati: ";
	public final static String MESSAGGIO_CLIENTE_NON_TROVATO = "Cliente non trovato";
	public final static String MESSAGGIO_CANCELLA_CLIENTE = "Sei sicuro di voler cancellare il cliente corrente?";
	public final static String MESSAGGIO_AGENTE_NON_TROVATO = "Agente non trovato";
	public final static String MESSAGGIO_CANCELLA_AGENTE = "Sei sicuro di voler cancellare l'agente corrente?";
	public final static String MESSAGGIO_AZIENDA_NON_TROVATA = "Azienda non trovata";
	public final static String MESSAGGIO_CANCELLA_AZIENDA = "Sei sicuro di voler cancellare l'azienda corrente?";
	public final static String MESSAGGIO_CANCELLA_PRODOTTO = "Sei sicuro di voler cancellare il prodotto corrente?";
	public final static String MESSAGGIO_PREVENTIVO_NON_TROVATO = "Preventivo non trovato";
	public final static String MESSAGGIO_CANCELLA_SCONTO = "Sei sicuro di voler cancellare lo sconto corrente?";
	public final static String MESSAGGIO_SCONTO_NON_TROVATO = "Sconto non trovato";
	public final static String MESSAGGIO_SCONTO_CLIENTE_ERRATO = "Si possono assegnare solo sconti di tipo cliente";
	public final static String MESSAGGIO_SCONTO_PRODOTTO_ERRATO = "Si possono assegnare solo sconti di tipo prodotto";
	
	
	/**
	 * Icone e immagini
	 */
	public static final String SPLASH_AGENTTRADE = "/agent_trade/ui/img/splash.png";
	public static final String AGENTTRADE_ICON = "/agent_trade/ui/img/icon.png";
	public static final String IMG_SFONDO_CLIENTE = "/agent_trade/ui/img/sfondoAgentTradeCliente.png";
	public static final String IMG_SFONDO_PREVENTIVO= "/agent_trade/ui/img/sfondoAgentTradePreventivo.png";
	public static final String IMG_SFONDO_AGENTE = "/agent_trade/ui/img/sfondoAgentTradeAgente.png";	
	public static final String CLOSE_ICON= "/agent_trade/ui/img/close_icon.png";
	public static final String MINUS_ICON= "/agent_trade/ui/img/minus.png";
	public static final String PLUS_ICON= "/agent_trade/ui/img/plus.png";
	public static final String PREVENTIVO_ICON= "/agent_trade/ui/img/preventivo.png";
	public static final String NUOVO_PREVENTIVO_ICON= "/agent_trade/ui/img/nuovo_icon.png";
	public static final String CERCA_PREVENTIVO_ICON= "/agent_trade/ui/img/cercaPreventivo.png";
	public static final String CLIENTE_ICON= "/agent_trade/ui/img/cliente.png";	
	public static final String NUOVO_CLIENTE_ICON= "/agent_trade/ui/img/new_user.png";
	public static final String CERCA_CLIENTE_ICON= "/agent_trade/ui/img/search.png";
	public static final String UPLOAD_CLIENTE_ICON= "/agent_trade/ui/img/upload-clienti.png";
	public static final String DOWNLOAD_CLIENTE_ICON= "/agent_trade/ui/img/download-clienti.png";
	public static final String PRODOTTI_ICON= "/agent_trade/ui/img/magazzino_icon.png";
	public static final String ALBERO_PREVENTIVI_ICON= "/agent_trade/ui/img/prev.png";
	public static final String ALBERO_PRODOTTI_ICON= "/agent_trade/ui/img/prev.png";
	public static final String ADD_ITEM_ICON= "/agent_trade/ui/img/add-item.png";
	public static final String SAVE_ICON= "/agent_trade/ui/img/save-icon.png";
	public static final String SETTING_ICON= "/agent_trade/ui/img/setting.png";
	public static final String CONFERMA_ORDINE_ICON= "/agent_trade/ui/img/carrelloOrdine.png";
	public static final String CANCELLA_PREV_ICON= "/agent_trade/ui/img/delete.png";
	public static final String ALBERO_CLIENTI_ICON = "/agent_trade/ui/img/ico-cliente1.png";
	public static final String SALVA_CLIENTI_ICON ="/agent_trade/ui/img/save-icon.png";
	public static final String INDIETRO_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String COMUNICAZIONE_CLIENTE_ICON = "/agent_trade/ui/img/send-icon.png";
	public static final String MOD_CLIENTE_ICON = "/agent_trade/ui/img/setting.png";
	public static final String CANC_CLIENTE_ICON = "/agent_trade/ui/img/delete.png";
	public static final String SALVA_MOD_CLIENTE_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String ANNULLA_MOD_CLIENTE_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String MOD_SCONTO_CLIENTE_ICON = "/agent_trade/ui/img/replace-sconto.png";
	public static final String MOD_AGENTE_CLIENTE_ICON = "/agent_trade/ui/img/replace-agente.png";
	public static final String RIEPILOGO_CLIENTE_ICON = "/agent_trade/ui/img/Img_cliente_riepilogo.png";
	public static final String DETTAGLIO_CLIENTE_ICON = "/agent_trade/ui/img/Img_cliente_dettaglio.png";
	
	public static final String AGENTE_ICON= "/agent_trade/ui/img/agente.png";
	public static final String NUOVO_AGENTE_ICON= "/agent_trade/ui/img/new_agente.png";
	public static final String CERCA_AGENTE_ICON= "/agent_trade/ui/img/cerca_agente.png";
	public static final String SALVA_AGENTI_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String COMUNICAZIONE_AGENTE_ICON = "/agent_trade/ui/img/send-icon.png";
	public static final String MOD_AGENTE_ICON = "/agent_trade/ui/img/setting.png";
	public static final String CANC_AGENTE_ICON = "/agent_trade/ui/img/delete.png";
	public static final String SALVA_MOD_AGENTE_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String ANNULLA_MOD_AGENTE_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String RIEPILOGO_AGENTE_ICON = "/agent_trade/ui/img/Img_cliente_riepilogo.png";
	public static final String DETTAGLIO_AGENTE_ICON = "/agent_trade/ui/img/Img_cliente_dettaglio.png";
	public static final String ALBERO_AGENTI_ICON = "/agent_trade/ui/img/ico-agente.png";
	
	public static final String AZIENDA_ICON = "/agent_trade/ui/img/azienda.png";
//	CAMBIARE ICONE
	public static final String NUOVA_AZIENDA_ICON = "/agent_trade/ui/img/add_azienda.png";
	public static final String CERCA_AZIENDA_ICON = "/agent_trade/ui/img/cerca_azienda.png";
	public static final String SALVA_AZIENDA_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String IMG_SFONDO_AZIENDA = "/agent_trade/ui/img/sfondoAzienda.png";
	public static final String RIEPILOGO_AZIENDA_ICON = "/agent_trade/ui/img/Img_cliente_riepilogo.png";
	public static final String COMUNICAZIONE_AZIENDA_ICON = "/agent_trade/ui/img/send-icon.png";
	public static final String MOD_AZIENDA_ICON = "/agent_trade/ui/img/setting.png";
	public static final String CANC_AZIENDA_ICON = "/agent_trade/ui/img/delete.png";
	public static final String SALVA_MOD_AZIENDA_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String ANNULLA_MOD_AZIENDA_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String DETTAGLIO_AZIENDA_ICON = "/agent_trade/ui/img/Img_cliente_dettaglio.png";
	public static final String ALBERO_AZIENDE_ICON = "/agent_trade/ui/img/ico-azienda.png";
//	CAMBIARE ICONE
	public static final String LISTINO_ICON = "/agent_trade/ui/img/listino.png";
	public static final String NUOVO_LISTINO_ICON = "/agent_trade/ui/img/listino.png";
	public static final String CERCA_LISTINO_ICON = "/agent_trade/ui/img/cerca_listino.png";
	public static final String UPDATE_LISTINO_ICON = "/agent_trade/ui/img/sinc-listino.png";
	public static final String IMG_SFONDO_LISTINO = "/agent_trade/ui/img/sfondoListino.png";
	public static final String SHOW_ICON =  "/agent_trade/ui/img/arrow_icon.png";
	public static final String MOD_PRODOTTO_ICON = "/agent_trade/ui/img/setting.png";
	public static final String CANC_PRODOTTO_ICON = "/agent_trade/ui/img/delete.png";
	public static final String SALVA_MOD_PRODOTTO_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String ANNULLA_MOD_PRODOTTO_ICON = "/agent_trade/ui/img/back-icon.png";
	public static final String ALBERO_LISTINO_ICON = "/agent_trade/ui/img/ico-listino.png";
	public static final String ALBERO_SCONTO_ICON = "/agent_trade/ui/img/ico-sconto.png";
	public static final String SINC_LISTINO_ICON = "/agent_trade/ui/img/sinc-listino.png";

//CAMBIARE ICONE
	public static final String SCONTO_ICON= "/agent_trade/ui/img/sconto.png";
	public static final String NUOVO_SCONTO_ICON= "/agent_trade/ui/img/add_sconto.png";
	public static final String CERCA_SCONTO_ICON= "/agent_trade/ui/img/cerca_sconto.png";
	public static final String IMG_SFONDO_SCONTO = "/agent_trade/ui/img/sfondoSconto.png";
	public static final String MOD_SCONTO_ICON = "/agent_trade/ui/img/setting.png";
	public static final String CANC_SCONTO_ICON = "/agent_trade/ui/img/delete.png";
	public static final String SALVA_MOD_SCONTO_ICON = "/agent_trade/ui/img/save-icon.png";
	public static final String ANNULLA_MOD_SCONTO_ICON = "/agent_trade/ui/img/back-icon.png";

	
	/**
	 * URL dei Sistemi Esterni
	 */
	
	public final static String URL_BEVERAGE= "http://fratic.altervista.org/beverage.php";

	public final static String URL_LEM = "http://pianetaverdesgr.altervista.org/lem.php";
	
	public final static String URL_RIVERA = "http://pianetaverdesgr.altervista.org/rivera.php";
	
	
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
	public final static String REG_EX_RAGIONE_SOCIALE = "[a-zA-Z0-9'._%-& \\s]+";
	public final static String REG_EX_COD_FISC_AZIENDA = "[0-9]{11}";
	
	/**
	 * Dimensioni finestre
	 */
	public final static int WIDTH_LOGIN = 370;
	public final static int HEIGHT_LOGIN = 250;
	
	public final static int WIDTH_PRIMARY = 1024;
	public final static int HEIGHT_PRIMARY = 784;
	public final static int MIN_WIDTH_PRIMARY = 900;
	public final static int MIN_HEIGHT_PRIMARY = 530;

	/**
	 * Dimensioni contenitori, label e TF nelle view dettaglio/riepilogo cliente/agente/azienda
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
	 * Dimensioni contenitori, label e TF nelle view nuovo/riepilogo intestazione preventivo
	 */
	public final static int WIDTH_PANN_NORD = 733;
	public final static int HEIGHT_PANN_NORD = 80;
	public final static int WIDTH_PANN_DESTRA = 280;
	public final static int HEIGHT_PANN_DESTRA = 60;
	public final static int WIDTH_PANN_DESTRA_MIN = 200;
	public final static int HEIGHT_PANN_DESTRA_MIN = 50;
	public final static int WIDTH_LABEL_PREV_INT = 96;
	public final static int HEIGHT_LABEL_PREV_INT = 14;
	public final static int WIDTH_LABEL_NUM_PREV = 27;
	public final static int HEIGHT_LABEL_NUM_PREV = 14;
	public final static int WIDTH_LABEL_DEL = 45;
	public final static int HEIGHT_LABEL_DEL = 14;
	public final static int WIDTH_LABEL_DATA = 79;
	public final static int HEIGHT_LABEL_DATA = 14;
	public final static int WIDTH_LABEL_EFFETTUATO = 128;
	public final static int HEIGHT_LABEL_EFFETTUATO = 14;
	public final static int WIDTH_LABEL_AG = 128;
	public final static int HEIGHT_LABEL_AG = 14;
	public final static int WIDTH_LABEL_VUOTA_1 = 230;
	public final static int HEIGHT_LABEL_VUOTA_1 = 5;
	public final static int WIDTH_LABEL_VUOTA_4 = 230;
	public final static int HEIGHT_LABEL_VUOTA_4 = 14;
	public final static int WIDTH_BOTTONE_ANNULLA_PREV = 20;
	public final static int HEIGHT_BOTTONE_ANNULLA_PREV = 20;
	public final static int WIDTH_PANN_SINISTRA = 280;
	public final static int HEIGHT_PANN_SINISTRA = 60;
	public final static int WIDTH_LABEL_CL_PREV = 50;
	public final static int HEIGHT_LABEL_CL_PREV = 14;
	public final static int WIDTH_LABEL_CLIENTE_PREV = 206;
	public final static int HEIGHT_LABEL_CLIENTE_PREV = 14;
	public final static int WIDTH_LABEL_VUOTA_2 = 50;
	public final static int HEIGHT_LABEL_VUOTA_2 = 14;
	public final static int WIDTH_LABEL_CLIENTE_IND = 206;
	public final static int HEIGHT_LABEL_CLIENTE_IND = 14;
	public final static int WIDTH_LABEL_VUOTA_3 = 50;
	public final static int HEIGHT_LABEL_VUOTA_3 = 14;
	public final static int WIDTH_LABEL_ALTRE_INFO = 206;
	public final static int HEIGHT_LABEL_ALTRE_INFO = 14;
	public final static int WIDTH_LABEL_SCONTO_PREV = 80;
	public final static int HEIGHT_LABEL_SCONTO_PREV = 14;
	public final static int WIDTH_LABEL_SCONTO_CL_PREV = 186;
	public final static int HEIGHT_LABEL_SCONTO_CL_PREV = 14;
	public final static int WIDTH_PANN_SUD = 733;
	public final static int HEIGHT_PANN_SUD = 45;
	public final static int WIDTH_BOTTONE_PREV = 40;
	public final static int HEIGHT_BOTTONE_PREV = 40;
	
	/**
	 * Dimensioni contenitori, label e TF nelle view nuovo/riepilogo item preventivo
	 */
	public final static int WIDTH_PANN_TAB = 733;
	public final static int HEIGHT_PANN_TAB = 360;
	public final static int WIDTH_PANN_RIEPILOGO = 733;
	public final static int HEIGHT_PANN_RIEPILOGO = 85;
	public final static int WIDTH_SOTTO_PANN_RIEPILOGO1 = 95;
	public final static int HEIGHT_SOTTO_PANN_RIEPILOGO1 = 85;
	public final static int WIDTH_BUTTON_SALVA = 50;
	public final static int HEIGHT_BUTTON_SALVA = 50;
	public final static int WIDTH_SOTTO_PANN_RIEP_CAMPI = 400;
	public final static int HEIGHT_SOTTO_PANN_RIEP_CAMPI = 40;
	public final static int WIDTH_SOTTO_PANN = 400;
	public final static int HEIGHT_SOTTO_PANN = 80;
	public final static int WIDTH_PANN_LABEL_PREV = 190;
	public final static int HEIGHT_PANN_LABEL_PREV = 20;
	public final static int WIDTH_LABEL_PREV = 100;
	public final static int HEIGHT_LABEL_PREV = 14;
	public final static int WIDTH_TEXT_FIELD_PREV = 94;
	public final static int HEIGHT_TEXT_FIELD_PREV = 20;
	
	/**
	 * Dimensioni contenitori, label e TF nelle view nuovo/riepilogo sconto
	 */
	public final static int WIDTH_BOTTONE_SELEZ_SCONTO = 150;
	public final static int HEIGHT_BOTTONE_SELEZ_SCONTO = 20;
	
	
	/**
	 * Dimensioni contenitori, label e TF nelle view nuovo/riepilogo prodotto
	 */
	public final static int WIDTH_PANN_CAMPI_PROD = 485;
	public final static int HEIGHT_PANN_CAMPI_PROD = 427;
	public final static int WIDTH_PANN_LABEL_DESCRIZIONE = 421;
	public final static int HEIGHT_PANN_LABEL_DESCRIZIONE = 60;
	public final static int WIDTH_TEXT_AREA_DESCRIZIONE = 261;
	public final static int HEIGHT_TEXT_AREA_DESCRIZIONE = 60;
	
	
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
	public final static String TAB_LISTINO= "Listino";
	public final static String TAB_SCONTO= "Sconto";

	public final static String ROOT_PREVENTIVI= "Preventivi";
	public final static String ROOT_CLIENTI= "Clienti";
	public final static String ROOT_PRODOTTI= "Prodotti";

	

	public final static String LABEL_INTESTAZIONE= "Intestazione";
	public final static String LABEL_NPREV= "Preventivo n\u00B0";
	public final static String LABEL_DEL= "del";
	public final static String LABEL_EFFETTUATO_AG= "effettuato dall'agente: ";
	public final static String LABEL_Cliente= "Cliente: ";
	public final static String LABEL_SCONTO_INTESTAZ = "Sconto Cliente: ";
	
	public final static String LABEL_IMPONIBILE= "Imponibile";
	public final static String LABEL_IVA= "IVA "+java.lang.Math.ceil(IVA*100)+"%";
	public final static String LABEL_TOTALE= "Totale";
	public final static String LABEL_TOTALE_NON_SCONTATO = "Tot. non scontato";
	public final static String LABEL_SCONTO_TOTALE = "Sconto Totale";
	public final static String LABEL_SCONTO_CLIENTE = "Sconto Cliente";
	
	public final static String LABEL_COGNOME_CLIENTE = "Cognome Cliente";
	public final static String LABEL_ID_PREV = "ID Preventivo";

	public final static String LABEL_CERCA_CLIENTE = "Cerca Cliente";
	
	public final static String LABEL_ID = "Codice cliente";
	public final static String LABEL_COGNOME = "Cognome o Rag. sociale";
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
	public final static String LABEL_SCONTO = "Sconto";
	public final static String LABEL_AGENTE_RIF = "Agente di riferimento";
	public final static String LABEL_ERRORE_CAMPI = "";
	
	public final static String LABEL_COGNOME_OBB = "Cognome o Rag. sociale*";
	public final static String LABEL_NOME_CLIENTE_OBB = "Nome*";
	public final static String LABEL_COD_FISC_OBB = "Codice Fiscale*";
	public final static String LABEL_PARTITA_IVA_OBB = "Partita Iva*";
	public final static String LABEL_INDIRIZZO_OBB = "Indirizzo*";
	public final static String LABEL_CITTA_OBB = "Citt\u00E0*";
	public final static String LABEL_CAP_OBB = "CAP*";
	public final static String LABEL_CELLULARE_OBB = "Cellulare*";
	
	public final static String LABEL_CERCA_AGENTE = "Cerca Agente";

	public final static String LABEL_ID_AGENTE = "Codice agente";
	public final static String LABEL_NOME = "Nome";
	public final static String LABEL_COGNOME_AGENTE = "Cognome";
	public final static String LABEL_LVL ="Livello";
	
	public final static String ROOT_AGENTI= "Agenti";

	public final static String LABEL_NOME_AZIENDA = "Ragione sociale";
	public final static String LABEL_ID_AZIENDA = "Cod. azienda";
	public final static String LABEL_URL_AZIENDA = "Url";
	public final static String LABEL_TIPO_AZIENDA = "Produce";
	
	public final static String ROOT_AZIENDE = "Aziende";
	public final static String ROOT_LISTINI_AZIENDE = "Listini Aziende";

	public final static String ROOT_SCONTI = "Sconti";

	
	public final static String LABEL_AZIENDA = "Azienda: ";
	public final static String LABEL_AGGIORNAMENTO_AUTO = "Aggiornamento automatico: ";
	
	public final static String LABEL_ID_PROD = "ID prodotto";
	public final static String LABEL_NOME_PROD = "Nome";
	public final static String LABEL_CATEGORIA_PROD = "Categoria";
	public final static String LABEL_PREZZO_PROD = "Prezzo";
	public final static String LABEL_SCONTO_PROD = "Sconto";
	public final static String LABEL_VERSIONE_PROD = "Versione aggiornamento";
	public final static String LABEL_DESCRIZIONE_PROD = "Descrizione";
	
	public final static String LABEL_COLORE = "Colore";
	public final static String LABEL_IND_GEOG = "Ind. Geografica";
	public final static String LABEL_CANTINA = "Cantina";
	public final static String LABEL_ARTIGIANALE = "Artigianale";
	public final static String LABEL_FREE_GLUTEN = "Senza Glutine";
	public final static String LABEL_PROVENIENZA = "Provenienza";
	public final static String LABEL_TAGLIO = "Taglio";
	public final static String LABEL_TIPO = "Tipo";
	public final static String LABEL_STAGIONATURA = "Stagionatura";
	
	public final static String LABEL_TIPO_SCONTO = "Tipo di sconto";
	public final static String LABEL_ID_SCONTO = "ID sconto";
	public final static String LABEL_PERCENTUALE_SCONTO = "Percentuale";
	public final static String LABEL_QUANTITA_SCONTO = "Quantit\u00E0 prodotti";
	public final static String LABEL_FISSO_SCONTO = "Valore sconto fisso";

	/**
	 * Tip
	 */
	public final static String TIP_GESTISCI_PREVENTIVO= "Gestisci i preventivi";
	public final static String TIP_NUOVO_PREVENTIVO= "Crea un nuovo preventivo";
	public final static String TIP_CERCA_PREVENTIVO= "Cerca un preventivo";
	public final static String TIP_GESTISCI_CLIENTE= "Gestisci i clienti";
	public final static String TIP_INSERISCI_CLIENTE= "Inserisci un nuovo cliente";
	public final static String TIP_CERCA_CLIENTE= "Cerca il cliente";
	public final static String TIP_UPDATE_CLIENTE= "Carica i clienti sul database centrale";
	public final static String TIP_DOWNLOAD_CLIENTE= "Scarica i clienti dal database centrale";
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
	public final static String TIP_NUOVO_CLIENTE= "Inserisci un nuovo cliente";
	public final static String TIP_MOD_SCONTO_CLIENTE = "Assegna un nuovo sconto";
	public final static String TIP_MOD_AGENTE_CLIENTE = "Assegna ad un altro agente";

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
	public final static String TIP_USERNAME = "Inserire un username di almeno 3 caratteri";
	public final static String TIP_PASSWORD = "Inserire un password di almeno 3 caratteri";
	
	public final static String TIP_GESTISCI_AZIENDA = "Gestisci le aziende";
	public final static String TIP_NUOVA_AZIENDA = "Inserisci una nuova azienda";
	public final static String TIP_CERCA_AZIENDA = "Cerca un'azienda";
	public final static String TIP_NOME_AZIENDA = "Inserire la ragione sociale dell'azienda";
	public final static String TIP_URL_AZIENDA = "Inserire l'url del DB dell'azienda se disponibile";
	public final static String TIP_COD_FIS_AZIENDA = "Codice di undici cifre Es: '12345678901'";
	public final static String TIP_TIPO_AZIENDA = "Selezionare il genere di prodotto fornito";
	
	public final static String TIP_SALVA_AZIENDA = "Salva l'azienda";
	public final static String TIP_MODIFICA_AZIENDA = "Modifica i dati dell'azienda";
	public final static String TIP_CANCELLA_AZIENDA = "Cancella azienda";
	public final static String TIP_SALVA_MOD_AZIENDA = "Salva modifiche";
	public final static String TIP_ANNULLA_MOD_AZIENDA = "Annulla modifiche";
	public final static String TIP_SINC_LISTINO_AZIENDA = "Sincronizza il listino di questa azienda";


	public final static String TIP_VISUALIZZA_LISTINO = "Visualizza listino";
	public final static String TIP_GESTISCI_LISTINO = "Gestisci i listini";
	public final static String TIP_NUOVO_LISTINO = "Crea un nuovo listino";
	public final static String TIP_CERCA_LISTINO = "Cerca un listino";
	public final static String TIP_UPDATE_LISTINO = "Scarica gli aggiornamenti di tutte le aziende";
	public static final String TIP_AGGIUNGI_PRODOTTO = "aggiungi un prodotto al catalogo (possibile solo se l'azienda non possiede un aggiornamento automatico del catalogo)";
	public static final String TIP_DETTAGLIO_PRODOTTO = "Visualizza il prodotto nel dettaglio (consente la modifica e la cancellazione del prodotto)";
	public static final String TIP_MODIFICA_PRODOTTO = "Modifica il prodotto (possibile solo se l'azienda non possiede un aggiornamento automatico del catalogo)";
	public static final String TIP_CANCELLA_PRODOTTO = "Elimina il prodotto (possibile solo se l'azienda non possiede un aggiornamento automatico del catalogo)";
	public final static String TIP_SALVA_MOD_PRODOTTO = "Salva modifiche";
	public final static String TIP_ANNULLA_MOD_PRODOTTO = "Annulla modifiche";
	public final static String TIP_TORNA_ELENCO = "Ritorna al catalogo";
	public final static String TIP_SINC_LISTINO = "Scarica i prodotti dal database centrale";

	public final static String TIP_NOME_PRODOTTO = "Nome prodotto";
	public final static String TIP_CATEGORIA_PRODOTTO = "Categoria prodotto";
	public final static String TIP_PREZZO_PRODOTTO = "Prezzo prodotto";	
	public final static String TIP_SCONTO_PRODOTTO = "Sconto prodotto";	
	public final static String TIP_DESCRIZIONE_PRODOTTO = "Prezzo prodotto";
	public final static String TIP_SALVA_NUOVO_PRODOTTO = "Salva il prodotto";	
	public final static String TIP_ANNULLA_NUOVO_PRODOTTO = "Annulla inserimento";	
	
	public final static String TIP_COLORE_VINO = "Colore vino";
	public final static String TIP_IND_GEOG_VINO = "Indicazione geografica";
	public final static String TIP_CANTINA_VINO = "Cantina vino";
	
	public final static String TIP_PROV_CARNE = "Provenienza";
	public final static String TIP_TAGLIO_CARNE = "Selezionare il taglio";
	public final static String TIP_TIPO_CARNE = "Selezionare il tipo";
		
	public final static String TIP_TIPO_LATT = "Tipo";
	public final static String TIP_STAGIONATURA_LATT = "Inserire il numero di mesi della stagionatura";
	
	public final static String TIP_GESTISCI_SCONTO = "Gestisci gli sconti";
	public final static String TIP_NUOVO_SCONTO = "Inserisci un nuovo sconto";
	public final static String TIP_CERCA_SCONTO = "Cerca uno sconto";
	public final static String TIP_TIPO_SCONTO = "Selezionare il tipo di sconto";
	public final static String TIP_CONFERMA_SEL = "Conferma il tipo di sconto";
	public final static String TIP_PERCENTUALE_SCONTO = "Inserire la percentuale di sconto (ES. 0.1 = 10%)";
	public final static String TIP_QUANTITA_SCONTO = "Inserire la quantit\u00E0 di prodotti necessari affinch\u00E8 sia valido lo sconto";
	public final static String TIP_FISSO_SCONTO = "Inserire il valore dello sconto fisso superata una certa quantit\u00E0";
	public final static String TIP_SALVA_SCONTO = "Salva sconto";
	public static final String TIP_MODIFICA_SCONTO = "Modifica sconto";
	public static final String TIP_CANCELLA_SCONTO = "Elimina sconto";
	public final static String TIP_SALVA_MOD_SCONTO = "Salva modifiche";
	public final static String TIP_ANNULLA_MOD_SCONTO = "Annulla modifiche";
	public final static String TIP_MOD_SCONTO_PRODOTTO = "Assegna un nuovo sconto";
	
	/**
	 * Bottoni
	 */
	public final static String BOTTONE_ACCEDI = "Accedi";

	public final static String BOTTONE_CERCA = "Cerca";
	public final static String BOTTONE_INSERISCI = "Inserisci";
	public final static String BOTTONE_CONFERMA = "Ok";
	public final static String BOTTONE_ANNULLA = "Annulla";
	public final static String BOTTONE_VISUALIZZA = "Visualizza";
	public final static String BOTTONE_MODIFICA = "Modifica";
	public final static String BOTTONE_VISUALIZZA_LISTINO = "Mostra Listino";
	public final static String BOTTONE_AGIIUNGI_PRODOTTO = "Aggiungi prodotto";
	
	
	/**
	 * Intestazioni tabelle
	 */

	
	public final static String[] INTESTAZIONE_TABELLA_PREVENTIVI = {"Rimuovi", "ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo Unitario", "Sconto", "Parziale", "Parziale scontato" };
	public final static String[] INTESTAZIONE_TABELLA_RIEPILOGO_ITEM= {"ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo Unitario", "Sconto", "Parziale", "Parziale scontato" };
	
	public final static String[] INTESTAZIONE_TABELLA_PRODOTTI = {"ID prodotto", "Nome", "Categoria", "Sconto", "Prezzo", "Aggiungi" };
	
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_PREVENTIVI = {"ID", "Cliente", "Data" };
	
	public final static String[] INTESTAZIONE_TABELLA_CERCA_CLIENTI = {"ID", "Cognome", "Nome", "Codice Fiscale", "P.IVA"};
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_CLIENTI = {"ID", "Cognome", "Nome","Codice Fiscale", "Partita iva", "Citt\u00E0" };
	
	public final static String[] INTESTAZIONE_TABELLA_CERCA_AGENTI = {"ID", "Cognome", "Nome", "Codice Fiscale", "P.IVA"};
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_AGENTI = {"ID", "Cognome", "Nome", "Livello", "Email", "Citt\u00E0"};
	
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_AZIENDE = {"ID", "Nome o Ragione Sociale", "Codice Fiscale", "P.IVA", "Citt\u00E0"};
	
	public final static String[] INTESTAZIONE_LISTINO_PRODOTTI = {"ID prodotto", "Nome", "Categoria", "Sconto", "Prezzo", "Visualizza" };
	
	public final static String[] INTESTAZIONE_TABELLA_RICERCA_SCONTI = {"ID", "Tipo", "Percentuale", "Quantit\u00E0", "Fisso"};
	
	public final static String[] LISTA_PRODOTTI = {"Seleziona un tipo", "vini", "dolci", "carni", "latticini"};
	
	public final static String[] LISTA_TAGLIO_CARNE = {"Seleziona un taglio", "Cat1", "Cat2", "Cat3"};
		
	public final static String[] LISTA_TIPO_CARNE = {"Seleziona un tipo", "Tipo1", "Tipo2", "Tipo3"};
	
	public final static String[] LISTA_TIPO_SCONTI = {"Seleziona sconto", "Cliente - Percentuale", "Prodotto - Quantit\u00E0", "Prodotto - Percentuale" };
	
	public final static String[] LISTA_CERCA_SCONTI = {"Tutti gli sconti", "Tutti gli sconti cliente", "Tutti gli sconti prodotto", "Cliente - Percentuale", "Prodotto - Quantit\u00E0", "Prodotto - Percentuale"};
	
public final static String[] LISTA_CERCA_SCONTI_CLIENTE = {"Tutti gli sconti cliente", "Cliente - Percentuale"};
	
	public final static String[] LISTA_CERCA_SCONTI_PRODOTTO = {"Tutti gli sconti prodotto", "Prodotto - Quantit\u00E0", "Prodotto - Percentuale"};
	
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
	public final static int  COLONNA_PARZIALE_SCONTATO_TAB_PREV= 8;	

	public static final int COLONNA_ID_SHOW_ITEM_BUTTON = 0;
	public final static int  COLONNA_SHOW_ITEM_BUTTON = 5;
	
	/**
	 * Sistemi Esterni: Aziende di Vino
	 */
	public final static AziendaViniAdapter[] SISTEMI_ESTERNI_AZIENDE_VINI = { BeverageAdapter.getInstance(), RiveraAdapter.getInstance()};

	
	/**
	 * Sistemi Esterni: Aziende di Carne
	 */
	public final static AziendaCarniAdapter[] SISTEMI_ESTERNI_AZIENDE_CARNI = { LemAdapter.getInstance() };

	/**
	 * Nomi Aziende con Sistemi Esterni: Aziende di Vino
	 */
	public final static String BEVERAGE = "Beverage";
	public final static String RIVERA = "Rivera";


	/**
	 * Nomi Aziende con Sistemi Esterni: Aziende di Carne
	 */
	public final static String LEM = "Lem";

	
}
