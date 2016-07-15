package agent_trade.ui;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.preventivi.IntestazioneNuovoPreventivoView;
import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoItemPreventivoView;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.util.Sfondo_Cliente;
import agent_trade.util.Sfondo_Preventivo;

public class PrimaryView extends JFrame 
{
	
	/*attributi di classe*/
	
	private static PrimaryView instance;	
	
	private static JPanel intestazione;
	private static JPanel item;
	
	private static JPanel riep_intestazione;
	private static JPanel riep_item;
	
	private static JPanel pannello_centrale_preventivo;
	
	private static JPanel dettaglioCliente;
	private static JPanel riep_cliente;
	
	private static JPanel pannello_centrale_cliente;
	
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 784;


	/*attributi privati*/
	
	private JButton nuovo_preventivo;
	private JButton bottoneCercaCliente;
	private JButton bottoneNuovoCliente;
	
	private JPanel preventivo;
	private JPanel panello_menu_preventivo;
	private JPanel panello_sottomenu_preventivo;
	private JPanel panello_laterale_preventivo;
	
	
	private JPanel Cliente;
	private JPanel panello_menu_cliente;
	private JPanel panello_sottomenu_cliente;
	private JPanel panello_laterale_cliente;
	
	
	private JPanel Catalogo;
	private JPanel panello_menu_catalogo;
	private JPanel panello_sottomenu_catalogo;
	private JPanel panello_laterale_catalogo;
	private JPanel panello_centrale_catalogo;
	private JPanel pannelloProdotti;
	
	private JPanel alberoPreventivi;
	
	private JPanel alberoClienti;
	
	private JTabbedPane tabbedPrincipale;
		
	/*costruttori*/
	
	private PrimaryView() {
		
		super("Agent Trade");
		
		this.initComponents();
		
		initTabPreventivo();
		
		initTabCliente();
		
		initTabCatalogo();
		
	}
	
	
	/*metodi di classe*/
	
	public static PrimaryView getInstance(){
		if (instance==null)
			instance = new PrimaryView();
		return instance;	 
	}
	
	public static void initIntestazione(){

		intestazione= IntestazioneNuovoPreventivoView.getInstance();
//		intestazione.setBounds(0, 1, 755, 136);
		intestazione.setBounds(10, 10, 733, 140);

		pannello_centrale_preventivo.add(intestazione);
		pannello_centrale_preventivo.repaint();

	}
		
	public static void initItem(){

		item= ItemNuovoPreventivoView.getInstance();
		item.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		item.setBounds(10, 150, 733, 457);
		
		pannello_centrale_preventivo.add(item);
		pannello_centrale_preventivo.repaint();
		
	}
	
	public static void initDettaglioCliente() {
		
		dettaglioCliente= DettaglioClienteView.getInstance();
		dettaglioCliente.setBounds(7, 7, 740, 604);
		pannello_centrale_cliente.add(dettaglioCliente);
		pannello_centrale_cliente.repaint();
	}
	
	
	public static void initRiepilogoClienteView() {
		
		riep_cliente= RiepilogoClienteView.getInstance();
		riep_cliente.setBounds(7, 7, 740, 604);
		pannello_centrale_cliente.add(riep_cliente);
		pannello_centrale_cliente.repaint();
		
	}
	
	
	public static void initRiepilogo(){
		
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
		
			riep_intestazione =RiepilogoIntestazionePreventivoView.getInstance();
			riep_intestazione.setBounds(10, 10, 733, 140);
			pannello_centrale_preventivo.add(riep_intestazione);
			pannello_centrale_preventivo.repaint();

			RiepilogoItemPreventivoView.getInstance().resetTable();
			
			riep_item = RiepilogoItemPreventivoView.getInstance();
			//riep_item.setBounds(0, 141, 745, 585);
			riep_item.setBounds(10, 150, 733, 457);

			pannello_centrale_preventivo.add(riep_item);
			pannello_centrale_preventivo.repaint();
			
	}
		
	public static void cancIntestazione(){
		IntestazioneNuovoPreventivoView.cancIntestazione();
		intestazione=null;
	}
	
	public static void cancItem(){
		ItemNuovoPreventivoView.cancItem();
		item=null;
	}
	
		
	/*metodi privati*/
	
	private void initTabPreventivo(){
		
		
		preventivo = new JPanel();
		preventivo.setBackground(Color.WHITE);
		tabbedPrincipale.addTab("Preventivo", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/preventivo.png")), preventivo, "Gestisci i preventivi");
		tabbedPrincipale.setBackgroundAt(0, Color.WHITE);
		preventivo.setLayout(null);
				
		panello_menu_preventivo = new JPanel();
		panello_menu_preventivo.setBackground(Color.WHITE);
		panello_menu_preventivo.setBounds(0, 0, 1013, 100);
		preventivo.add(panello_menu_preventivo);
		panello_menu_preventivo.setLayout(null);
		
		nuovo_preventivo = new JButton("");
		nuovo_preventivo.setBounds(30, 25, 50, 50);
		nuovo_preventivo.setToolTipText("Crea un nuovo preventivo");
		nuovo_preventivo.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/nuovo_icon.png")));
		panello_menu_preventivo.add(nuovo_preventivo);
		
		/*JButton button = new JButton("");
		button.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		button.setBounds(94, 20, 50, 50);
		panello_menu_preventivo.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/delete.png")));
		button_1.setBounds(168, 20, 50, 50);
		panello_menu_preventivo.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/Settings-icon.png")));
		button_2.setBounds(246, 20, 50, 50);
		panello_menu_preventivo.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/search-icon.png")));
		button_3.setBounds(323, 20, 50, 50);
		panello_menu_preventivo.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/carrelloOrdine.png")));
		button_4.setBounds(394, 20, 50, 50);
		panello_menu_preventivo.add(button_4);*/
		
		panello_sottomenu_preventivo = new JPanel();
		panello_sottomenu_preventivo.setBounds(0, 100, 1013, 617);
		preventivo.add(panello_sottomenu_preventivo);
		panello_sottomenu_preventivo.setLayout(null);
		
		panello_laterale_preventivo = new JPanel();
		panello_laterale_preventivo.setBackground(UIManager.getColor("ToggleButton.background"));
		panello_laterale_preventivo.setBounds(0, 0, 260, 617);
		panello_sottomenu_preventivo.add(panello_laterale_preventivo);
		panello_laterale_preventivo.setLayout(null);
		
		
		alberoPreventivi = AlberoPreventivi.getInstance();
		alberoPreventivi.setBounds(0, 0, 260, 617);
		panello_laterale_preventivo.add(alberoPreventivi);

		
		pannello_centrale_preventivo = new JPanel();
		pannello_centrale_preventivo.setBackground(SystemColor.control);
		pannello_centrale_preventivo.setBounds(260, 0, 753, 617);
		panello_sottomenu_preventivo.add(pannello_centrale_preventivo);
		pannello_centrale_preventivo.setLayout(null);

		setSfondoPrev();
				
		
		nuovo_preventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_elaboraPreventivo.getInstance().newPreventivo(Ctrl_System.getAgenteLog());				
			}
		});
		
	}
	
	

	private void initTabCliente(){
		
		Cliente = new JPanel();
		tabbedPrincipale.addTab("Cliente", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/cliente.png")), Cliente, "Gestisci i clienti");
		Cliente.setLayout(null);
		
		panello_menu_cliente = new JPanel();
		panello_menu_cliente.setBounds(0, 0, 1013, 100);
		panello_menu_cliente.setLayout(null);
		panello_menu_cliente.setBackground(Color.WHITE);
		Cliente.add(panello_menu_cliente);
		
		bottoneNuovoCliente = new JButton();
		bottoneNuovoCliente.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/new_user.png")));
		bottoneNuovoCliente.setToolTipText("Inserisci un nuovo cliente");
		bottoneNuovoCliente.setBounds(25, 25, 50, 50);
		panello_menu_cliente.add(bottoneNuovoCliente);
		
		bottoneCercaCliente = new JButton("");
		bottoneCercaCliente.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/search.png")));
		bottoneCercaCliente.setToolTipText("Cerca il cliente");
		bottoneCercaCliente.setBounds(103, 25, 50, 50);
		panello_menu_cliente.add(bottoneCercaCliente);
		
		panello_sottomenu_cliente = new JPanel();
		panello_sottomenu_cliente.setBounds(0, 100, 1013, 617);
		panello_sottomenu_cliente.setLayout(null);
		Cliente.add(panello_sottomenu_cliente);
		
		panello_laterale_cliente = new JPanel();
		panello_laterale_cliente.setBounds(0, 0, 260, 617);
		panello_sottomenu_cliente.add(panello_laterale_cliente);
		panello_laterale_cliente.setLayout(null);
		
		alberoClienti = new AlberoClienti();
		alberoClienti.setBounds(0, 0, 261, 617);
		panello_laterale_cliente.add(alberoClienti);
		
		pannello_centrale_cliente = new JPanel();
		pannello_centrale_cliente.setBackground(SystemColor.control);
		pannello_centrale_cliente.setBounds(260, 0, 753, 617);
		panello_sottomenu_cliente.add(pannello_centrale_cliente);
		pannello_centrale_cliente.setLayout(null);
		
		setSfondoCliente();
		
		bottoneCercaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciCliente.getInstance().btnCerca();
			
			}
		});
		
		bottoneNuovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciCliente.getInstance().newCliente();
				
			}
		});
			
	}
	
	private void initTabCatalogo(){
		
		Catalogo = new JPanel();
		tabbedPrincipale.addTab("Catalogo", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/magazzino_icon.png")), Catalogo, null);
		Catalogo.setLayout(null);
		
		panello_menu_catalogo = new JPanel();
		panello_menu_catalogo.setBounds(0, 0, 1013, 100);
		panello_menu_catalogo.setLayout(null);
		panello_menu_catalogo.setBackground(Color.WHITE);
		Catalogo.add(panello_menu_catalogo);
		
		panello_sottomenu_catalogo = new JPanel();
		panello_sottomenu_catalogo.setBounds(0, 100, 1013, 617);
		panello_sottomenu_catalogo.setLayout(null);
		Catalogo.add(panello_sottomenu_catalogo);
		
		panello_laterale_catalogo = new JPanel();
		panello_laterale_catalogo.setBounds(0, 0, 260, 617);
		panello_sottomenu_catalogo.add(panello_laterale_catalogo);
		
		panello_centrale_catalogo = new JPanel();
		panello_centrale_catalogo.setBackground(Color.LIGHT_GRAY);
		panello_centrale_catalogo.setBounds(260, 0, 753, 617);
		panello_sottomenu_catalogo.add(panello_centrale_catalogo);
		panello_centrale_catalogo.setLayout(null);
		
		
		pannelloProdotti = ProdottiView.getInstance();
		pannelloProdotti.setBounds(0, 0, 753, 617);
		panello_centrale_catalogo.add(pannelloProdotti);
	}
	
	private void initComponents()
	{
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                askClosure();
            }
        });
		

        
		getContentPane().setLayout(null);
		tabbedPrincipale = new JTabbedPane(JTabbedPane.TOP);
		tabbedPrincipale.setBounds(0, 0, 1018, 755);

		getContentPane().add(tabbedPrincipale);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setBounds(150, 210, 1024, 748);
		//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		// int x = screen.width;
		// int y = screen.height;
		this.setBounds(150,50,WIDTH,HEIGHT);
		//sarebbe carino dimensionare TUTTE le finestre in base alla dimensione dello schermo
		
		this.setResizable(false);
	}
	
	
	private void askClosure() {
	        int choice = JOptionPane.showConfirmDialog(this,
	                "Chiudere l'applicazione?",
	                "Agent trade",
	                JOptionPane.YES_NO_OPTION);
	        if (choice == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        }
	    }
	
	public void setSfondoPrev() 
	{
		JPanel sfondoPrev=new Sfondo_Preventivo();
		sfondoPrev.setBounds(200, 200, 753, 617);
		pannello_centrale_preventivo.add(sfondoPrev);
		
	}
	
	public void setSfondoCliente() 
	{
		JPanel sfondoCliente=new Sfondo_Cliente();
		sfondoCliente.setBounds(200, 200, 753, 617);
		pannello_centrale_cliente.add(sfondoCliente);
		
	}
	
	
	/*metodi pubblici*/
	
	
	public void setSchedaCliente(String cognome, String nome, String codice_fiscale, String partita_iva,String indirizzo, String citta,  String cap, String email, String telefono,String cellulare,  String fax) {
		
		((RiepilogoClienteView) riep_cliente).setRiepilogoCliente(cognome, nome, codice_fiscale, partita_iva, citta, cap, indirizzo, email, telefono, cellulare, fax);

	}

	//sblocca i campi per la modifica cliente
	public void setModifiche(boolean b) {
		((RiepilogoClienteView) riep_cliente).setTFeditable(b);
		
	}
	
	//blocca e sblocca bottoni relativi al tab cliente
	public void disattivaModifica(boolean b){
		((RiepilogoClienteView) riep_cliente).setEnaBtnModifiche(b);
	}
	
	public void disattivaSalvaModifiche(boolean b){
		((RiepilogoClienteView) riep_cliente).setEnaBtnSalvaModifiche(b);
	}
	
	public void disattivaAnnullaModifiche(boolean b){
		((RiepilogoClienteView) riep_cliente).setEnaBtnAnnullaModifiche(b);
	}
	
	public void disattivaCancella(boolean b){
		((RiepilogoClienteView) riep_cliente).setEnaBtnCancella(b);
	}
	
	public void resetNuovoCliente() {
		((DettaglioClienteView) dettaglioCliente).resetNewCliente();
	}
	
	public void resetCliente() {
		((RiepilogoClienteView) riep_cliente).resetCampiModifica();
		
	}
	
	public void setEnableNewCliente(boolean b){
		bottoneNuovoCliente.setEnabled(b);
	}
	
	public void setEnableCercaCliente(boolean b){
		bottoneCercaCliente.setEnabled(b);
	}
	
	public void setEnableNewPreventivo(boolean b){
		nuovo_preventivo.setEnabled(b);
	}
	
	public void setVisibleIntestazione(boolean b){
		intestazione.setVisible(b);
	}
	
	public void setVisibleItemPreventivi(boolean b){
		item.setVisible(b);
	}

	public JPanel getInstanceIntestazione(){
		return intestazione;
	}
	
	public void setNewIntestAgente(String a){
		((IntestazioneNuovoPreventivoView) intestazione).setAgente(a);
	}
	
	public void setNewIntestCliente(String cognome, String nome, String indirizzo, String email){
		((IntestazioneNuovoPreventivoView) intestazione).setCliente(cognome, nome, indirizzo, email);
	}
	
	public void setNewIntestData (String data){//cambiare in oggetto data
		((IntestazioneNuovoPreventivoView) intestazione).setData(data);
	}
	
	public void setNewIntestNumPrev(String n){
		((IntestazioneNuovoPreventivoView) intestazione).setNumPrev(n);
	}
	
	public void setRiepIntestAgente(String a){
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setAgente(a);
	}
	
	public void setRiepIntestCliente(String cognome, String nome, String indirizzo, String email){
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setCliente(cognome, nome, indirizzo, email);
	}
	
	public void setRiepIntestData (String data){//cambiare in oggetto data
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setData(data);
	}
	
	public void setRiepIntestNumPrev(String n){
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setNumPrev(n);
	}

	public void selectTabCatalogo() {
		tabbedPrincipale.setSelectedIndex(2);
	}

	public void setEnableTabCliente(boolean b ) {
		tabbedPrincipale.setEnabledAt(1, b);
	}
	
	public void setEnableTabPreventivo(boolean b ) {
		tabbedPrincipale.setEnabledAt(2, b);
	}
	
	public void setEnableTabCatalogo(boolean b ) {
		tabbedPrincipale.setEnabledAt(0, b);
	}
	
	public void setVisibleErroreNuovoCliente(boolean b){
		((DettaglioClienteView) dettaglioCliente).setVisibleErroreNuovoCliente(b);
	}
	
	public void setVisibleErroreRiepCliente(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleErroreRiepCliente(b);
	}
	
	
	public void resetPannelloCentralePreventivo(){
		
		pannello_centrale_preventivo.removeAll();
		//pannello_centrale_preventivo.setBackground(Color.BLUE);
		pannello_centrale_preventivo.setBounds(260, 0, 753, 617);
		pannello_centrale_preventivo.setLayout(null);
		pannello_centrale_preventivo.repaint();
	}
	
	public void resetPannelloCentraleCliente(){
		pannello_centrale_cliente.removeAll();
		pannello_centrale_cliente.setBackground(SystemColor.control);
		pannello_centrale_cliente.setBounds(260, 0, 753, 617);
		pannello_centrale_cliente.setLayout(null);
		pannello_centrale_cliente.repaint();
		
	}
	
	public void updateTableRiepilogo(String id, String nome, String categoria, String quantita, String prezzo, String parziale){
		((RiepilogoItemPreventivoView) riep_item).updateTable(id, nome, categoria, quantita, prezzo, parziale);	
	}
		
	public void disabilitaAlbero(){
		alberoPreventivi.disable();
	}

	public void abilitaAlbero(){
		alberoPreventivi.enable();
	}

	public void setEnableSalva(boolean b) {
		
		((ItemNuovoPreventivoView) item).enableSave(b);
	}	
}
