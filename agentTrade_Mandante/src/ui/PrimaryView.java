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

import model.M_Agente;
import ui.content.clienti.AlberoClienti;
import ui.content.clienti.DettaglioClienteView;
import ui.content.clienti.RiepilogoClienteView;
import ui.content.preventivi.IntestazioneNuovoPreventivoView;
import ui.content.preventivi.ItemNuovoPreventivoView;
import ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import ui.content.preventivi.RiepilogoItemPreventivoView;
import util.Costanti;
import util.Sfondo_Cliente;
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
	
	private static JPanel dettaglioCliente;
	private static JPanel riep_cliente;
	
	private static JPanel pannello_centrale_cliente;
		
	
	/*attributi privati*/
	
	
	private JButton bottoneCercaAgente;
	private JButton bottoneNuovoAgente;
	
	
	
	private JPanel Agente;
	private JPanel panello_menu_agente;
	private JPanel panello_sottomenu_agente;
	private JPanel panello_laterale_agente;
	
	
	private JPanel alberoClienti;
	
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
	
		
	/*metodi privati*/
	
	

	private void initTabAgente(){
		
		Agente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_CLIENTE, new ImageIcon(PrimaryView.class.getResource(Costanti.CLIENTE_ICON)), Agente, Costanti.TIP_GESTISCI_CLIENTE);
		Agente.setLayout(new BorderLayout());
		
		panello_menu_agente = new JPanel();
		panello_menu_agente.setPreferredSize(new Dimension(1013, 100));
		panello_menu_agente.setLayout(null);

		panello_menu_agente.setBackground(Color.WHITE);
		Agente.add(panello_menu_agente,BorderLayout.NORTH);
		
		bottoneNuovoAgente = new JButton();
		bottoneNuovoAgente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.NUOVO_CLIENTE_ICON)));
		bottoneNuovoAgente.setToolTipText(Costanti.TIP_NUOVO_PREVENTIVO);
		bottoneNuovoAgente.setBounds(25, 25, 50, 50);
		panello_menu_agente.add(bottoneNuovoAgente);
		
		bottoneCercaAgente = new JButton("");
		bottoneCercaAgente.setIcon(new ImageIcon(PrimaryView.class.getResource(Costanti.CERCA_CLIENTE_ICON)));
		bottoneCercaAgente.setToolTipText(Costanti.TIP_CERCA_CLIENTE);
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

		
		alberoClienti = new AlberoClienti();
		alberoClienti.setBounds(0, 0, 261, 617);
		panello_laterale_agente.add(alberoClienti);
		
		pannello_centrale_cliente = new JPanel();
		pannello_centrale_cliente.setBackground(SystemColor.control);

		pannello_centrale_cliente.setPreferredSize(new Dimension(753, 617));
		panello_sottomenu_agente.add(pannello_centrale_cliente, BorderLayout.CENTER);
		pannello_centrale_cliente.setLayout(new GridLayout(1,1));
		pannello_centrale_cliente.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoCliente();
		
		bottoneCercaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				Ctrl_gestisciCliente.getInstance().btnCerca();
			
			}
		});
		
		bottoneNuovoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				Ctrl_gestisciCliente.getInstance().newCliente();
				
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
	

	public void setEnableSalva(boolean b) {
		
		((ItemNuovoPreventivoView) item).enableSave(b);
	}	
}
