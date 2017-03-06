package ui;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.Ctrl_gestisciAgente;
import model.M_Agente;
import ui.content.agenti.AlberoAgenti;
import ui.content.clienti.AlberoClienti;
import ui.content.clienti.DettaglioClienteView;
import ui.content.clienti.RiepilogoClienteView;
import ui.content.preventivi.IntestazioneNuovoPreventivoView;
import ui.content.preventivi.ItemNuovoPreventivoView;
import ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import ui.content.preventivi.RiepilogoItemPreventivoView;
import util.Costanti;
import util.Sfondo_Agente;
import util.Sfondo_Preventivo;

public class PrimaryView extends JFrame 
{
	
	/*attributi di classe*/
	
	private static PrimaryView instance;	
	
	private static JPanel intestazione;
	private static JPanel item;
	
	private static JPanel riep_intestazione;
	private static JPanel riep_item;
	
	private static JPanel pannello_centrale_preventivo;
	
//	private static JPanel dettaglioCliente;
//	private static JPanel riep_cliente;
//	
//	private static JPanel pannello_centrale_cliente;
		
	
	/*attributi privati*/
	
	
	private JButton bottoneCercaAgente;
	private JButton bottoneNuovoAgente;
	
	
	
	private JPanel Agente;
	private JPanel panello_menu_agente;
	private JPanel panello_sottomenu_agente;
	private JPanel panello_laterale_agente;
	private JPanel pannello_centrale_agente;
	
	
	private JPanel alberoAgenti;
	
	private JTabbedPane tabbedPrincipale;
		
	/*costruttori*/
	
	private PrimaryView() {
		
		super(Costanti.TITOLO_PRIMARY_VIEW);
		
		this.initComponents();
		
		
		initTabAgente();
		
		
	}
	
	
	/*metodi di classe*/
	
	public static PrimaryView getInstance(){
		if (instance==null)
			instance = new PrimaryView();
		return instance;	 
	}
	
	
	
//	public static void initDettaglioCliente() {
//		
//		dettaglioCliente= DettaglioClienteView.getInstance();
//		pannello_centrale_cliente.add(dettaglioCliente);
//		pannello_centrale_cliente.repaint();
//	}
//	
//	
//	public static void initRiepilogoClienteView() {
//		
//		riep_cliente= RiepilogoClienteView.getInstance();
//		pannello_centrale_cliente.add(riep_cliente);
//		pannello_centrale_cliente.repaint();
//		
//	}
	
	
	
	
		
	/*metodi privati*/
	
	

	private void initTabAgente(){
		
		Agente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AGENTE, new ImageIcon(PrimaryView.class.getResource(Costanti.CLIENTE_ICON)), Agente, Costanti.TIP_GESTISCI_AGENTE);
		Agente.setLayout(new BorderLayout());
		
		panello_menu_agente = new JPanel();
		panello_menu_agente.setPreferredSize(new Dimension(1013, 100));
		panello_menu_agente.setLayout(null);

		panello_menu_agente.setBackground(Color.WHITE);
		Agente.add(panello_menu_agente,BorderLayout.NORTH);
		
		bottoneNuovoAgente = new JButton();
		bottoneNuovoAgente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.NUOVO_CLIENTE_ICON)));
		bottoneNuovoAgente.setToolTipText(Costanti.TIP_NUOVO_AGENTE);
		bottoneNuovoAgente.setBounds(25, 25, 50, 50);
		panello_menu_agente.add(bottoneNuovoAgente);
		
		bottoneCercaAgente = new JButton("");
		bottoneCercaAgente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.CERCA_CLIENTE_ICON)));
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
				
				Ctrl_gestisciAgente.getInstance().btnCerca();
			
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
	
		
	public void setSfondoAgente() 
	{
		JPanel sfondoAgente=new Sfondo_Agente();
		pannello_centrale_agente.add(sfondoAgente);
		
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
		bottoneNuovoAgente.setEnabled(b);
	}
	
	public void setEnableCercaCliente(boolean b){
		bottoneCercaAgente.setEnabled(b);
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
	
//	public void setRiepIntestAgente(M_Preventivo p){
//		String a=p.getRif_Agente().getCognome()+" "+p.getRif_Agente().getNome();
//		((RiepilogoIntestazionePreventivoView) riep_intestazione).setAgente(a);
//	}
//	
//	public void setRiepIntestCliente(M_Preventivo p){
//	
//		String cognome =p.getRif_Cliente().getCognome();
//		String nome =p.getRif_Cliente().getNome();
//		String indirizzo =p.getRif_Cliente().getIndirizzo();
//		String email = p.getRif_Cliente().getEmail();
//		((RiepilogoIntestazionePreventivoView) riep_intestazione).setCliente(cognome, nome, indirizzo, email);
//	}
	
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
	
//	public void setVisibleErroreNuovoCliente(boolean b){
//		((DettaglioClienteView) dettaglioCliente).setVisibleErroreNuovoCliente(b);
//	}
//	
//	public void setVisibleErroreRiepCliente(boolean b){
//		((RiepilogoClienteView) riep_cliente).setVisibleErroreRiepCliente(b);
//	}
	
	
	public void resetPannelloCentralePreventivo(){
		
		pannello_centrale_preventivo.removeAll();
		pannello_centrale_preventivo.repaint();
	}
	
	public void resetPannelloCentraleAgente(){
		pannello_centrale_agente.removeAll();
		pannello_centrale_agente.repaint();
		
	}
	

	public void setEnableSalva(boolean b) {
		
		((ItemNuovoPreventivoView) item).enableSave(b);
	}	
}
