package agent_trade.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.agenti.DettaglioAgenteView;
import agent_trade.ui.content.agenti.RiepilogoAgenteView;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.preventivi.IntestazioneNuovoPreventivoView;
import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoItemPreventivoView;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.util.Costanti;
import agent_trade.util.Sfondo_Agente;
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
		
	private static RiepilogoAgenteView riep_agente;
	private static DettaglioAgenteView dettaglio_agente;
	
	private static JPanel pannello_centrale_agente;

	
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
		
	private JButton bottoneCercaAgente;
	private JButton bottoneNuovoAgente;
	
	
	
	private JPanel Agente;
	private JPanel panello_menu_agente;
	private JPanel panello_sottomenu_agente;
	private JPanel panello_laterale_agente;
	
	private JPanel alberoAgenti;

	
	
	
	/*costruttori*/
	
	private PrimaryView() {
		
		super(Costanti.TITOLO_PRIMARY_VIEW);
		
		this.initComponents();
		
		initTabPreventivo();
		
		initTabCliente();
		
		initTabCatalogo();

		//ovviamente adesso è abilitata, ma poi dovrà esserlo solo se
		//si è loggato un mandante
		initTabAgente();

		
	}
	
	
	/*metodi di classe*/
	
	public static PrimaryView getInstance(){
		if (instance==null)
			instance = new PrimaryView();
		return instance;	 
	}
	
	public static void initIntestazione(){

		intestazione= IntestazioneNuovoPreventivoView.getInstance();
		intestazione.setPreferredSize(new Dimension(733,140));
		pannello_centrale_preventivo.add(intestazione, BorderLayout.NORTH);
		pannello_centrale_preventivo.repaint();

	}
		
	public static void initItem(){


		item= ItemNuovoPreventivoView.getInstance();
		item.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		item.setPreferredSize(new Dimension(733,457));
		pannello_centrale_preventivo.add(item,BorderLayout.CENTER);
		pannello_centrale_preventivo.repaint();
				
	}
	
	public static void initDettaglioCliente() {
		
		dettaglioCliente= DettaglioClienteView.getInstance();
		pannello_centrale_cliente.add(dettaglioCliente);
		pannello_centrale_cliente.repaint();
	}
	
	
	public static void initRiepilogoClienteView() {
		
		riep_cliente= RiepilogoClienteView.getInstance();
		pannello_centrale_cliente.add(riep_cliente);
		pannello_centrale_cliente.repaint();
		
	}
	
	
	public static void initRiepilogo(){
		
			PrimaryView.getInstance().resetPannelloCentralePreventivo();
		
			riep_intestazione =RiepilogoIntestazionePreventivoView.getInstance();
			riep_intestazione.setPreferredSize(new Dimension(733,140));
			pannello_centrale_preventivo.add(riep_intestazione,BorderLayout.NORTH);
			pannello_centrale_preventivo.repaint();

			RiepilogoItemPreventivoView.getInstance().resetTable();
			
			riep_item = RiepilogoItemPreventivoView.getInstance();

			riep_item.setPreferredSize(new Dimension(733,457));
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
	
	
	public static void initDettaglioAgente() {
		
		dettaglio_agente = DettaglioAgenteView.getInstance();
		pannello_centrale_agente.add(dettaglio_agente);
		pannello_centrale_agente.repaint();
	}
	
	
	public static void initRiepilogoAgenteView() {
		
		riep_agente = RiepilogoAgenteView.getInstance();
		pannello_centrale_agente.add(riep_agente);
		pannello_centrale_agente.repaint();
		
	}
	
	
	
		
	/*metodi privati*/
	
	private void initTabPreventivo(){
		
		
		preventivo = new JPanel();
		preventivo.setBackground(Color.WHITE);
		tabbedPrincipale.addTab(Costanti.TAB_PREVENTIVO, new ImageIcon(PrimaryView.class.getResource(Costanti.PREVENTIVO_ICON)), preventivo, Costanti.TIP_GESTISCI_PREVENTIVO);
		tabbedPrincipale.setBackgroundAt(0, Color.WHITE);
		preventivo.setLayout(new BorderLayout());
				
		panello_menu_preventivo = new JPanel();
		panello_menu_preventivo.setBackground(Color.WHITE);
	
		panello_menu_preventivo.setPreferredSize(new Dimension(1013, 100));
		preventivo.add(panello_menu_preventivo, BorderLayout.NORTH);
		panello_menu_preventivo.setLayout(null);
		
		nuovo_preventivo = new JButton("");
		nuovo_preventivo.setBounds(30, 25, 50, 50);
		nuovo_preventivo.setToolTipText(Costanti.TIP_NUOVO_PREVENTIVO);
		nuovo_preventivo.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.NUOVO_PREVENTIVO_ICON)));
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
		panello_sottomenu_preventivo.setPreferredSize(new Dimension(1013, 617));
		preventivo.add(panello_sottomenu_preventivo, BorderLayout.CENTER);
		panello_sottomenu_preventivo.setLayout(new BorderLayout());

		
		panello_laterale_preventivo = new JPanel();
		panello_laterale_preventivo.setBackground(UIManager.getColor("ToggleButton.background"));
		panello_laterale_preventivo.setPreferredSize(new Dimension(260, 617));
		panello_sottomenu_preventivo.add(panello_laterale_preventivo, BorderLayout.WEST);
		panello_laterale_preventivo.setLayout(null);
		
		
		alberoPreventivi = AlberoPreventivi.getInstance();
		alberoPreventivi.setBounds(0, 0, 260, 617);
		panello_laterale_preventivo.add(alberoPreventivi);

		
		pannello_centrale_preventivo = new JPanel();
		pannello_centrale_preventivo.setBackground(SystemColor.control);
		pannello_centrale_preventivo.setPreferredSize(new Dimension(753, 617));
		panello_sottomenu_preventivo.add(pannello_centrale_preventivo, BorderLayout.CENTER);
		pannello_centrale_preventivo.setLayout(new BorderLayout());
		pannello_centrale_preventivo.setBorder(new EmptyBorder(7, 7, 0, 7));

		setSfondoPrev();
				
		
		nuovo_preventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_elaboraPreventivo.getInstance().newPreventivo();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}				
			}
		});
		
	}
	
	

	private void initTabCliente(){
		
		Cliente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_CLIENTE, new ImageIcon(PrimaryView.class.getResource(Costanti.CLIENTE_ICON)), Cliente, Costanti.TIP_GESTISCI_CLIENTE);
		Cliente.setLayout(new BorderLayout());
		
		panello_menu_cliente = new JPanel();
		panello_menu_cliente.setPreferredSize(new Dimension(1013, 100));
		panello_menu_cliente.setLayout(null);

		panello_menu_cliente.setBackground(Color.WHITE);
		Cliente.add(panello_menu_cliente,BorderLayout.NORTH);
		
		bottoneNuovoCliente = new JButton();
		bottoneNuovoCliente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.NUOVO_CLIENTE_ICON)));
		bottoneNuovoCliente.setToolTipText(Costanti.TIP_NUOVO_PREVENTIVO);
		bottoneNuovoCliente.setBounds(25, 25, 50, 50);
		panello_menu_cliente.add(bottoneNuovoCliente);
		
		bottoneCercaCliente = new JButton("");
		bottoneCercaCliente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.CERCA_CLIENTE_ICON)));
		bottoneCercaCliente.setToolTipText(Costanti.TIP_CERCA_CLIENTE);
		bottoneCercaCliente.setBounds(103, 25, 50, 50);
		panello_menu_cliente.add(bottoneCercaCliente);
		
		panello_sottomenu_cliente = new JPanel();
		panello_sottomenu_cliente.setPreferredSize(new Dimension(1013, 617));
		panello_sottomenu_cliente.setLayout(new BorderLayout());
		Cliente.add(panello_sottomenu_cliente, BorderLayout.CENTER);

		
		panello_laterale_cliente = new JPanel();
		panello_laterale_cliente.setPreferredSize(new Dimension(260, 617));
		panello_sottomenu_cliente.add(panello_laterale_cliente, BorderLayout.WEST);
		panello_laterale_cliente.setLayout(null);

		
		alberoClienti = new AlberoClienti();
		alberoClienti.setBounds(0, 0, 261, 617);
		panello_laterale_cliente.add(alberoClienti);
		
		pannello_centrale_cliente = new JPanel();
		pannello_centrale_cliente.setBackground(SystemColor.control);

		pannello_centrale_cliente.setPreferredSize(new Dimension(753, 617));
		panello_sottomenu_cliente.add(pannello_centrale_cliente, BorderLayout.CENTER);
		pannello_centrale_cliente.setLayout(new GridLayout(1,1));
		pannello_centrale_cliente.setBorder(new EmptyBorder(7, 7, 0, 7));
		
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
		tabbedPrincipale.addTab(Costanti.TAB_CATALOGO, new ImageIcon(PrimaryView.class.getResource(Costanti.PRODOTTI_ICON)), Catalogo, null);
		Catalogo.setLayout(new BorderLayout());
		
		panello_menu_catalogo = new JPanel();
		panello_menu_catalogo.setPreferredSize(new Dimension(1013,100));
		panello_menu_catalogo.setLayout(null);
		panello_menu_catalogo.setBackground(Color.WHITE);
		Catalogo.add(panello_menu_catalogo, BorderLayout.NORTH);

		panello_sottomenu_catalogo = new JPanel();
		panello_sottomenu_catalogo.setPreferredSize(new Dimension(1013,617));
		panello_sottomenu_catalogo.setLayout(new BorderLayout());
		Catalogo.add(panello_sottomenu_catalogo,BorderLayout.CENTER);
		
		panello_laterale_catalogo = new JPanel();
		panello_laterale_catalogo.setPreferredSize(new Dimension(260,617));
		panello_sottomenu_catalogo.add(panello_laterale_catalogo,BorderLayout.WEST);
		
		panello_centrale_catalogo = new JPanel();
		panello_centrale_catalogo.setPreferredSize(new Dimension(753,617));
		panello_centrale_catalogo.setBackground(SystemColor.control);
		panello_sottomenu_catalogo.add(panello_centrale_catalogo,BorderLayout.CENTER);
		panello_centrale_catalogo.setLayout(new GridLayout(1,1));
		
		pannelloProdotti = ProdottiView.getInstance();
		panello_centrale_catalogo.add(pannelloProdotti);
	}
	
	
	private void initTabAgente(){
		
		Agente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AGENTE, new ImageIcon(PrimaryView.class.getResource(Costanti.AGENTE_ICON)), Agente, Costanti.TIP_GESTISCI_AGENTE);
		Agente.setLayout(new BorderLayout());
		
		panello_menu_agente = new JPanel();
		panello_menu_agente.setPreferredSize(new Dimension(1013, 100));
		panello_menu_agente.setLayout(null);

		panello_menu_agente.setBackground(Color.WHITE);
		Agente.add(panello_menu_agente,BorderLayout.NORTH);
		
		bottoneNuovoAgente = new JButton();
		bottoneNuovoAgente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.NUOVO_AGENTE_ICON)));
		bottoneNuovoAgente.setToolTipText(Costanti.TIP_NUOVO_AGENTE);
		bottoneNuovoAgente.setBounds(25, 25, 50, 50);
		panello_menu_agente.add(bottoneNuovoAgente);
		
		bottoneCercaAgente = new JButton("");
		bottoneCercaAgente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.CERCA_AGENTE_ICON)));
		bottoneCercaAgente.setToolTipText(Costanti.TIP_CERCA_AGENTE);
		bottoneCercaAgente.setBounds(103, 25, 50, 50);
		panello_menu_agente.add(bottoneCercaAgente);
		
		panello_sottomenu_agente= new JPanel();
		panello_sottomenu_agente.setPreferredSize(new Dimension(1013, 617));
		panello_sottomenu_agente.setLayout(new BorderLayout());
		Agente.add(panello_sottomenu_agente, BorderLayout.CENTER);

		
		panello_laterale_agente = new JPanel();
		panello_laterale_agente.setPreferredSize(new Dimension(260, 617));
		panello_sottomenu_agente.add(panello_laterale_agente, BorderLayout.WEST);
		panello_laterale_agente.setLayout(null);

		
		alberoAgenti = new AlberoAgenti();
		alberoAgenti.setBounds(0, 0, 261, 617);
		panello_laterale_agente.add(alberoAgenti);
		
		pannello_centrale_agente = new JPanel();
		pannello_centrale_agente.setBackground(SystemColor.control);

		pannello_centrale_agente.setPreferredSize(new Dimension(753, 617));
		panello_sottomenu_agente.add(pannello_centrale_agente, BorderLayout.CENTER);
		pannello_centrale_agente.setLayout(new GridLayout(1,1));
		pannello_centrale_agente.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoAgente();
		
		bottoneCercaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAgente.getInstance().btnCerca();
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		bottoneNuovoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciAgente.getInstance().btnNewAgente();
				
			}
		});
			
	}
	
	
	private void initComponents()
	{
		ImageIcon img = new ImageIcon(SplashScreen.class.getResource(Costanti.AGENTTRADE_ICON));

		this.setIconImage(img.getImage());

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                askClosure();
            }
        });
		

        
		getContentPane().setLayout(new GridLayout(1, 1));
		tabbedPrincipale = new JTabbedPane(JTabbedPane.TOP);

		getContentPane().add(tabbedPrincipale);
		
		this.setBounds(150,50,Costanti.WIDTH_PRIMARY,Costanti.HEIGHT_PRIMARY);
//		MODIFICA DA VEDERE DI QUANTO SI PUò RIDURRE E CHE FARE CON I PANNELLI INTERNI
		this.setMinimumSize(new Dimension(Costanti.MIN_WIDTH_PRIMARY, Costanti.MIN_HEIGHT_PRIMARY));

	}
	
	
	private void askClosure() {
	        int choice = JOptionPane.showConfirmDialog(this,
	                Costanti.MESSAGGIO_CLOSE_APP,
	                Costanti.TITOLO_DIALOG_CLOSE, 
	                JOptionPane.YES_NO_OPTION);
	        if (choice == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        }
	    }
	
	public void setSfondoPrev() 
	{
		JPanel sfondoPrev=new Sfondo_Preventivo();
		pannello_centrale_preventivo.add(sfondoPrev, BorderLayout.CENTER);
		
	}
	
	public void setSfondoCliente() 
	{
		JPanel sfondoCliente=new Sfondo_Cliente();
		pannello_centrale_cliente.add(sfondoCliente);
		
	}
	
	
	/*metodi pubblici*/
	
	
	public void setSchedaCliente(String id, String cognome, String nome, String codice_fiscale, String partita_iva,String indirizzo, String citta,  String cap, String email, String telefono,String cellulare,  String fax, M_Agente rifAgente) {
		
		((RiepilogoClienteView) riep_cliente).setRiepilogoCliente(id, cognome, nome, codice_fiscale, partita_iva, citta, cap, indirizzo, email, telefono, cellulare, fax, (rifAgente.getCognome()+" "+rifAgente.getNome()));

	}

	//sblocca i campi per la modifica cliente
	public void setModifiche(boolean b) {
		((RiepilogoClienteView) riep_cliente).setTFeditable(b);
		
	}
	
	//rende visibili i tooltip solo quando si modifica il cliente
	public void setVisibleToolTip(){
		((RiepilogoClienteView) riep_cliente).abilitaToolTip();
	}
		
	//rende invisibili i tooltip solo quando si modifica il cliente
	public void setInvisibleToolTip(){
		((RiepilogoClienteView) riep_cliente).disabilitaToolTip();
	}	
	
	//blocca e sblocca bottoni relativi al tab cliente
	//modificato il nome della funzione interna
	public void disattivaModifica(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnModifiche(b);
	}
	
	//modificato il nome della funzione interna
	public void disattivaSalvaModifiche(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnSalvaModifiche(b);
	}
	
	//modificato il nome della funzione interna
	public void disattivaAnnullaModifiche(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnAnnullaModifiche(b);
	}
	
	public void disattivaInviaPosta(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnInviaPosta(b);
	}
	
	//cambiato il nome
	public void disattivaCancella(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnCancella(b);
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
	
	public void setNewIntestData (Date data){
		((IntestazioneNuovoPreventivoView) intestazione).setData(data);
	}
	
	public void setNewIntestNumPrev(int i){
		((IntestazioneNuovoPreventivoView) intestazione).setNumPrev(i);
	}
	
	public void setRiepIntestAgente(M_Preventivo p){
		String a=p.getRif_Agente().getCognome()+" "+p.getRif_Agente().getNome();
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setAgente(a);
	}
	
	public void setRiepIntestCliente(M_Preventivo p){
	
		String cognome =p.getRif_Cliente().getCognome();
		String nome =p.getRif_Cliente().getNome();
		String indirizzo =p.getRif_Cliente().getIndirizzo();
		String email = p.getRif_Cliente().getEmail();
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setCliente(cognome, nome, indirizzo, email);
	}
	
	public void setRiepIntestData (Date data){
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setData(data);
	}
	
	public void setRiepIntestNumPrev(int i){
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setNumPrev(i);
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
		pannello_centrale_preventivo.repaint();
	}
	
	public void resetPannelloCentraleCliente(){
		pannello_centrale_cliente.removeAll();
		pannello_centrale_cliente.repaint();
		
	}
	
	public void updateTableRiepilogo(M_Preventivo_Item pr_it){
		String id = Integer.toString((pr_it.getIdProdotto().getIdProdotto()));
		String nome = pr_it.getIdProdotto().getNome();
		String categoria = pr_it.getIdProdotto().getCategoria();
		String quantita = Integer.toString(pr_it.getQuantita());
		String prezzo = Float.toString(pr_it.getIdProdotto().getPrezzo());
		String sconto = "";
		String parziale = Float.toString((pr_it.calcolaParziale()));
		if (pr_it.getIdProdotto().getSconto()!=0){
			sconto=(java.lang.Math.ceil(pr_it.getIdProdotto().getSconto()*100))+"%";
		}
		
		((RiepilogoItemPreventivoView) riep_item).updateTable(id, nome, categoria, quantita, prezzo, sconto, parziale);	
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
	
	
	public void setSfondoAgente() 
	{
		JPanel sfondoAgente=new Sfondo_Agente();
		pannello_centrale_agente.add(sfondoAgente);
		
	}
	
	public void resetPannelloCentraleAgente(){
		pannello_centrale_agente.removeAll();
		pannello_centrale_agente.repaint();		
	}
	
	public void resetNuovoAgente() {
		((DettaglioAgenteView) dettaglio_agente).resetNewAgente();
	}
	
	public void setEnableCercaAgente(boolean b){
		bottoneCercaAgente.setEnabled(b);
	}
	
	public void setVisibleErroreRiepAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleErroreRiepAgente(b);
	}
	
	public void setSchedaAgente(String id, String cognome, String nome, String livello, String citta, String cap, String indirizzo, String email, String cellulare,  String username, String password) {
		
		((RiepilogoAgenteView) riep_agente).setRiepilogoAgente(id, cognome, nome, livello, citta, cap, indirizzo, email, cellulare, username, password);
	}
	
	public void setVisibleErroreNuovoAgente(boolean b){
		((DettaglioAgenteView) dettaglio_agente).setVisibleErroreNuovoAgente(b);
	}
	
	
}
