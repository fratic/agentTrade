package agent_trade.ui.primaryView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.controller.Ctrl_gestisciAzienda;
import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.agenti.DettaglioAgenteView;
import agent_trade.ui.content.agenti.RiepilogoAgenteView;
import agent_trade.ui.content.aziende.AlberoAziende;
import agent_trade.ui.content.aziende.DettaglioAziendaView;
import agent_trade.ui.content.aziende.RiepilogoAziendaView;
import agent_trade.ui.content.listini.RiepilogoIntestazioneListinoView;
import agent_trade.ui.content.listini.RiepilogoListinoView;
import agent_trade.ui.content.prodotti.nuovo.NuovoProdottoFactoryView;
import agent_trade.ui.content.prodotti.riepilogo.RiepilogoProdottoFactoryView;
import agent_trade.ui.content.sconti.nuovo.NuovoScontoFactoryView;
import agent_trade.ui.content.sconti.nuovo.SelezionaScontoView;
import agent_trade.ui.content.sconti.riepilogo.RiepilogoScontoFactoryView;
import agent_trade.util.Costanti;
import agent_trade.util.Sfondo_Agente;
import agent_trade.util.Sfondo_Azienda;
import agent_trade.util.Sfondo_Listino;
import agent_trade.util.Sfondo_Sconto;

public class PrimaryMandanteView extends PrimaryViewFactory 
{
	
	/*attributi di classe*/
	
	private static PrimaryMandanteView instance;	

	private static RiepilogoAgenteView riep_agente;
	private static DettaglioAgenteView dettaglio_agente;
	private static JPanel pannello_centrale_agente;
	
	private static RiepilogoAziendaView riep_azienda;
	private static DettaglioAziendaView dettaglio_azienda;
	private static JPanel pannello_centrale_azienda;

	private static JPanel riep_listino;
	private static JPanel riep_intestaz_listino;	
	private static JPanel pannello_centrale_listino;

	private static JPanel dettaglio_sconto;
	private static JPanel riep_sconto;
	private static JPanel pannello_centrale_sconto;

	
	/*attributi privati*/
	
	private JButton bottoneCercaAgente;
	private JButton bottoneNuovoAgente;

	private JPanel Agente;
	private JPanel pannello_menu_agente;
	private JPanel pannello_sottomenu_agente;
	private JPanel pannello_laterale_agente;
	
	private JPanel alberoAgenti;

	private JPanel Azienda;
	private JPanel pannello_menu_azienda;
	private JPanel pannello_sottomenu_azienda;
	private JPanel pannello_laterale_azienda; 
	
	private JButton bottoneNuovaAzienda;
	private JButton bottoneCercaAzienda;
	
	private JPanel alberoAziende;
	
	private JPanel Listino;
	private JPanel pannello_menu_listino;
	private JPanel pannello_sottomenu_listino;
	private JPanel pannello_laterale_listino;
	
	private JButton bottoneNuovoListino;
	private JButton bottoneCercaListino;

	private JPanel Sconto;
	private JPanel pannello_menu_sconto;
	private JPanel pannello_sottomenu_sconto;
	private JPanel pannello_laterale_sconto;


	private JButton bottoneNuovoSconto;
	private JButton bottoneCercaSconto;

	
	/*costruttori*/
	
	private PrimaryMandanteView() {
		
		super(Costanti.TITOLO_MANDANTE_PRIMARY_VIEW);
		
		initTabAgente();
		initTabAzienda();
		initTabListino();
		initTabSconto();		
	}
	
	
	/*metodi di classe*/
	
	
	public static PrimaryMandanteView getInstance(){
		if (instance==null)
			instance = new PrimaryMandanteView();
		return instance;	 
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
	
	public static void initRiepilogoAziendaView() {
		
		riep_azienda = RiepilogoAziendaView.getInstance();
		pannello_centrale_azienda.add(riep_azienda);
		pannello_centrale_azienda.repaint();
	}
	
	public static void initDettaglioAzienda() {
		
		dettaglio_azienda = DettaglioAziendaView.getInstance();
		pannello_centrale_azienda.add(dettaglio_azienda);
		pannello_centrale_azienda.repaint();
	}
	
	
	public static void initRiepilogoIntestazListinoView(){
		
		riep_intestaz_listino = RiepilogoIntestazioneListinoView.getInstance();
		pannello_centrale_listino.add(riep_intestaz_listino, BorderLayout.NORTH);
		pannello_centrale_listino.repaint();
	}
	
	
	public static void initRiepilogoListinoView(){
		
		riep_listino = RiepilogoListinoView.getInstance();
		pannello_centrale_listino.add(riep_listino, BorderLayout.CENTER);
		pannello_centrale_listino.repaint();
	}
	
	
	public static void cancRiepilogoListinoView(){
		
		RiepilogoListinoView.cancRiepilogoListino();
		pannello_centrale_listino.remove(riep_listino);
		//pannello_centrale_listino.removeAll();
		riep_listino = null;
	}
	
	
	public static void initRiepilogoProdottoView(M_Prodotto prod){
		
		riep_listino = RiepilogoProdottoFactoryView.getInstance(prod);
		pannello_centrale_listino.add(riep_listino, BorderLayout.CENTER);
		pannello_centrale_listino.repaint();
	}
	
	
	public static void cancRiepilogoProdottoView(){
//		if(riep_listino != null){
			RiepilogoProdottoFactoryView.cancRiepilogoProdotto();
			pannello_centrale_listino.remove(riep_listino);
			//pannello_centrale_listino.removeAll();
			riep_listino = null;
//		}
	}
	
	
	public static void initNuovoProdottoView(M_Azienda azienda){
		
		riep_listino = NuovoProdottoFactoryView.getInstance(azienda);
		pannello_centrale_listino.add(riep_listino, BorderLayout.CENTER);
		pannello_centrale_listino.repaint();
	}
	
	
	public static void cancNuovoProdottoView(){
		
		NuovoProdottoFactoryView.cancNuovoProdotto();
		pannello_centrale_listino.remove(riep_listino);
		riep_listino = null;
	}
	
	
	public static void initSelezionaSconto() {
		
		dettaglio_sconto = SelezionaScontoView.getInstance();
		pannello_centrale_sconto.add(dettaglio_sconto);
		pannello_centrale_sconto.repaint();
	}
	
	
	public static void cancSelezionaScontoView(){
		
		SelezionaScontoView.cancSelezionaSconto();
		pannello_centrale_sconto.remove(dettaglio_sconto);
		dettaglio_sconto = null;
	}
	
	
	public static void initDettaglioScontoView(String tipoSconto){
		
		dettaglio_sconto = NuovoScontoFactoryView.getInstance(tipoSconto);
		pannello_centrale_sconto.add(dettaglio_sconto, BorderLayout.CENTER);
		pannello_centrale_sconto.repaint();
	}
	
	
	public static void cancDettaglioScontoView(){
		
		NuovoScontoFactoryView.cancNuovoSconto();
		pannello_centrale_sconto.remove(dettaglio_sconto);
		dettaglio_sconto = null;
	}
	
	
	public static void initRiepilogoScontoView(M_Sconto sconto) {
		
		riep_sconto = RiepilogoScontoFactoryView.getInstance(sconto);
		pannello_centrale_sconto.add(riep_sconto);
		pannello_centrale_sconto.repaint();
	}
	
	
	public static void cancRiepilogoScontoView(){
		if(riep_sconto != null){
			RiepilogoScontoFactoryView.cancRiepilogoSconto();
			pannello_centrale_sconto.remove(riep_sconto);
			riep_sconto = null;
		}
	}
		
	/*metodi privati*/
	
	
	
	private void initTabAgente(){
		
		Agente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AGENTE, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.AGENTE_ICON)), Agente, Costanti.TIP_GESTISCI_AGENTE);
		Agente.setLayout(new BorderLayout());
		
		pannello_menu_agente = new JPanel();
		pannello_menu_agente.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_agente.setLayout(null);

		pannello_menu_agente.setBackground(Color.WHITE);
		Agente.add(pannello_menu_agente,BorderLayout.NORTH);
		
		bottoneNuovoAgente = new JButton();
		bottoneNuovoAgente.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.NUOVO_AGENTE_ICON)));
		bottoneNuovoAgente.setToolTipText(Costanti.TIP_NUOVO_AGENTE);
		bottoneNuovoAgente.setBounds(25, 25, 50, 50);
		pannello_menu_agente.add(bottoneNuovoAgente);
		
		bottoneCercaAgente = new JButton("");
		bottoneCercaAgente.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_AGENTE_ICON)));
		bottoneCercaAgente.setToolTipText(Costanti.TIP_CERCA_AGENTE);
		bottoneCercaAgente.setBounds(103, 25, 50, 50);
		pannello_menu_agente.add(bottoneCercaAgente);
		
		pannello_sottomenu_agente= new JPanel();
		pannello_sottomenu_agente.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_agente.setLayout(new BorderLayout());
		Agente.add(pannello_sottomenu_agente, BorderLayout.CENTER);

		
		pannello_laterale_agente = new JPanel();
		pannello_laterale_agente.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_agente.add(pannello_laterale_agente, BorderLayout.WEST);
		pannello_laterale_agente.setLayout(null);

		
		alberoAgenti = new AlberoAgenti();
		alberoAgenti.setBounds(0, 0, 261, 617);
		pannello_laterale_agente.add(alberoAgenti);
		
		pannello_centrale_agente = new JPanel();
		pannello_centrale_agente.setBackground(SystemColor.control);

		pannello_centrale_agente.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_agente.add(pannello_centrale_agente, BorderLayout.CENTER);
		pannello_centrale_agente.setLayout(new GridLayout(1,1));
		pannello_centrale_agente.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoAgente();
		
		bottoneCercaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAgente.getInstance().btnCerca();
				} 
				catch (PersistentException e) {
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
	
	
	private void initTabAzienda(){
		
		Azienda = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AZIENDA, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.AZIENDA_ICON)), Azienda, Costanti.TIP_GESTISCI_AZIENDA);
		Azienda.setLayout(new BorderLayout());
		
		pannello_menu_azienda = new JPanel();
		pannello_menu_azienda.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_azienda.setLayout(null);
		
		pannello_menu_azienda.setBackground(Color.WHITE);
		Azienda.add(pannello_menu_azienda,BorderLayout.NORTH);
		
		bottoneNuovaAzienda = new JButton();
		bottoneNuovaAzienda.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.NUOVA_AZIENDA_ICON)));
		bottoneNuovaAzienda.setToolTipText(Costanti.TIP_NUOVA_AZIENDA);
		bottoneNuovaAzienda.setBounds(25, 25, 50, 50);
		pannello_menu_azienda.add(bottoneNuovaAzienda);
		
		bottoneCercaAzienda = new JButton("");
		bottoneCercaAzienda.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_AZIENDA_ICON)));
		bottoneCercaAzienda.setToolTipText(Costanti.TIP_CERCA_AZIENDA);
		bottoneCercaAzienda.setBounds(103, 25, 50, 50);
		pannello_menu_azienda.add(bottoneCercaAzienda);
		
		pannello_sottomenu_azienda= new JPanel();
		pannello_sottomenu_azienda.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_azienda.setLayout(new BorderLayout());
		Azienda.add(pannello_sottomenu_azienda, BorderLayout.CENTER);
		
		pannello_laterale_azienda = new JPanel();
		pannello_laterale_azienda.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_azienda.add(pannello_laterale_azienda, BorderLayout.WEST);
		pannello_laterale_azienda.setLayout(null);
		
		alberoAziende = new AlberoAziende();
		alberoAziende.setBounds(0, 0, 261, 617);
		pannello_laterale_azienda.add(alberoAziende);
		
		pannello_centrale_azienda = new JPanel();
		pannello_centrale_azienda.setBackground(SystemColor.control);
		
		pannello_centrale_azienda.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_azienda.add(pannello_centrale_azienda, BorderLayout.CENTER);
		pannello_centrale_azienda.setLayout(new GridLayout(1,1));
		pannello_centrale_azienda.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoAzienda();
		
		bottoneCercaAzienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAzienda.getInstance().btnCerca();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			
			}
		});
		
		bottoneNuovaAzienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciAzienda.getInstance().btnNewAzienda();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	private void initTabListino(){
		
		Listino = new JPanel();
		Listino.setBackground(Color.WHITE);
		tabbedPrincipale.addTab(Costanti.TAB_LISTINO, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.LISTINO_ICON)), Listino, Costanti.TIP_GESTISCI_LISTINO);
		Listino.setLayout(new BorderLayout());
		
		pannello_menu_listino = new JPanel();
		pannello_menu_listino.setBackground(Color.WHITE);
		pannello_menu_listino.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_listino.setLayout(null);
		Listino.add(pannello_menu_listino, BorderLayout.NORTH);
		
		bottoneCercaListino = new JButton();		
		bottoneCercaListino.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_LISTINO_ICON)));
		bottoneCercaListino.setToolTipText(Costanti.TIP_CERCA_LISTINO);
		bottoneCercaListino.setBounds(25, 25, 50, 50);
		pannello_menu_listino.add(bottoneCercaListino);
		
		pannello_sottomenu_listino = new JPanel();
		pannello_sottomenu_listino.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_listino.setLayout(new BorderLayout());
		Listino.add(pannello_sottomenu_listino, BorderLayout.CENTER);
		
		pannello_laterale_listino = new JPanel();
		pannello_laterale_listino.setPreferredSize(new Dimension(260, 617));
		pannello_laterale_listino.setLayout(null);
		pannello_sottomenu_listino.add(pannello_laterale_listino, BorderLayout.WEST);
		
//		alberoListini = new AlberoListini();
//		alberoListini.setBounds(0, 0, 261, 617);
//		pannello_laterale_listino.add(alberoListini);
		
		pannello_centrale_listino = new JPanel();
		pannello_centrale_listino.setBackground(SystemColor.control);
		
		pannello_centrale_listino.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_listino.add(pannello_centrale_listino, BorderLayout.CENTER);
		pannello_centrale_listino.setLayout(new BorderLayout());
		pannello_centrale_listino.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoListino();
		
		bottoneCercaListino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciListino.getInstance().btnCerca();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	
	private void initTabSconto(){
		
		Sconto = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_SCONTO, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.SCONTO_ICON)), Sconto, Costanti.TIP_GESTISCI_SCONTO);
		Sconto.setLayout(new BorderLayout());
		
		pannello_menu_sconto = new JPanel();
		pannello_menu_sconto.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_sconto.setLayout(null);

		pannello_menu_sconto.setBackground(Color.WHITE);
		Sconto.add(pannello_menu_sconto,BorderLayout.NORTH);
		
		bottoneNuovoSconto = new JButton();
		bottoneNuovoSconto.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.NUOVO_SCONTO_ICON)));
		bottoneNuovoSconto.setToolTipText(Costanti.TIP_NUOVO_SCONTO);
		bottoneNuovoSconto.setBounds(25, 25, 50, 50);
		pannello_menu_sconto.add(bottoneNuovoSconto);
		
		bottoneCercaSconto = new JButton("");
		bottoneCercaSconto.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_SCONTO_ICON)));
		bottoneCercaSconto.setToolTipText(Costanti.TIP_CERCA_SCONTO);
		bottoneCercaSconto.setBounds(103, 25, 50, 50);
		pannello_menu_sconto.add(bottoneCercaSconto);
		
		pannello_sottomenu_sconto = new JPanel();
		pannello_sottomenu_sconto.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_sconto.setLayout(new BorderLayout());
		Sconto.add(pannello_sottomenu_sconto, BorderLayout.CENTER);

		
		pannello_laterale_sconto = new JPanel();
		pannello_laterale_sconto.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_sconto.add(pannello_laterale_sconto, BorderLayout.WEST);
		pannello_laterale_sconto.setLayout(null);

		
//		alberoSconti = new AlberoAgenti();
//		alberoSconti.setBounds(0, 0, 261, 617);
//		pannello_laterale_sconto.add(alberoSconti);
		
		pannello_centrale_sconto = new JPanel();
		pannello_centrale_sconto.setBackground(SystemColor.control);

		pannello_centrale_sconto.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_sconto.add(pannello_centrale_sconto, BorderLayout.CENTER);
		pannello_centrale_sconto.setLayout(new GridLayout(1,1));
		pannello_centrale_sconto.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoSconto();
		
		bottoneCercaSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciSconto.getInstance().btnCerca();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		bottoneNuovoSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciSconto.getInstance().btnNewSconto();
				
			}
		});
	}
	
	/*metodi pubblici*/
	
	/****  FUNZIONI AGENTE ****/
	
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
	
	public void resetAgente() {
		((RiepilogoAgenteView) riep_agente).resetCampiModifica();
	}
	
	public void setEnableCercaAgente(boolean b){
		bottoneCercaAgente.setEnabled(b);
	}
	
	public void setEnableNewAgente(boolean b){
		bottoneNuovoAgente.setEnabled(b);
	}
	
	//sblocca i campi per la modifica agente
	public void setModificheAgente(boolean b) {
		((RiepilogoAgenteView) riep_agente).setTFeditable(b);	
	}
	
	//rende visibili i tooltip solo quando si modifica l'agente
	public void setVisibleToolTipAgente(){
		((RiepilogoAgenteView) riep_agente).abilitaToolTip();
	}
			
	//rende invisibili i tooltip solo quando si modifica l'agente
	public void setInvisibleToolTipAgente(){
		((RiepilogoAgenteView) riep_agente).disabilitaToolTip();
	}	
	
	//blocca e sblocca bottoni relativi al tab agente
	public void disattivaModificaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnModifiche(b);
	}
			
	public void disattivaSalvaModificheAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnSalvaModifiche(b);
	}
			
	public void disattivaAnnullaModificheAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnAnnullaModifiche(b);
	}
	
	public void disattivaCancellaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnCancella(b);
	}
	
	public void disattivaInviaPostaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnInviaPosta(b);
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
	
	public void setEnableTabAgente(boolean b ) {
		tabbedPrincipale.setEnabledAt(0, b);
	}
	
	public void nuovoAlberoAgente(){
		AlberoAgenti.getInstance().deselezionaNodo();
		alberoAgenti = new AlberoAgenti();
		alberoAgenti.setBounds(0, 0, 261, 617);
		pannello_laterale_agente.add(alberoAgenti);
		repaint();
		System.out.println("dopo il repaint");
	}
	
	/****  FUNZIONI AZIENDA ****/
	
	public void setSfondoAzienda() {
		JPanel sfondoAzienda = new Sfondo_Azienda();
		pannello_centrale_azienda.add(sfondoAzienda);
	}
	
	public void resetPannelloCentraleAzienda(){
		pannello_centrale_azienda.removeAll();
		pannello_centrale_azienda.repaint();		
	}
	
	public void setEnableNewAzienda(boolean b) {
		bottoneNuovaAzienda.setEnabled(b);		
	}

	public void setEnableCercaAzienda(boolean b) {
		bottoneCercaAzienda.setEnabled(b);
	}


	public void disattivaModificaAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnModifiche(b);
	}
	
	public void disattivaSalvaModificheAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnSalvaModifiche(b);
	}
	
	public void disattivaAnnullaModificheAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnAnnullaModifiche(b);
	}
	
	public void setSchedaAzienda(String idAzienda, String ragioneSociale, String codice_fiscale, String partita_iva, String citta, String cap, String indirizzo, String email, String telefono, String fax, String url, String tipo) {
		((RiepilogoAziendaView) riep_azienda).setRiepilogoAzienda(idAzienda, ragioneSociale, codice_fiscale, partita_iva, citta, cap, indirizzo, email, telefono, fax, url, tipo);
	}

	public void setVisibleErroreRiepAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleErroreRiepAzienda(b);
	}

	public void disattivaCancellaAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnCancella(b);
	}
	
	public void resetAzienda() {
		((RiepilogoAziendaView) riep_azienda).resetCampiModifica();
	}
	
	public void disattivaVisualizzaListinoAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnListino(b);
	}

	public void setInvisibleToolTipAzienda() {
		((RiepilogoAziendaView) riep_azienda).disabilitaToolTip();
	}

	public void setVisibleToolTipAzienda() {
		((RiepilogoAziendaView) riep_azienda).abilitaToolTip();
	}
	
	public void setModificheAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setTFeditable(b);
	}
	
	public void setVisibleErroreNuovaAzienda(boolean b){
		((DettaglioAziendaView) dettaglio_azienda).setVisibleErroreNuovaAzienda(b);
	}
	
	public void resetNuovaAzienda() {
		((DettaglioAziendaView) dettaglio_azienda).resetNewAzienda();
	}

	public void setEnableTabAzienda(boolean b ) {
		tabbedPrincipale.setEnabledAt(1, b);
	}
	
	
	/****  FUNZIONI LISTINO ****/
	
	public void setSfondoListino() {
		JPanel sfondoListino = new Sfondo_Listino();
		pannello_centrale_listino.add(sfondoListino);
	}
	
	
	public void resetPannelloCentraleListino(){
		pannello_centrale_listino.removeAll();
		pannello_centrale_listino.repaint();
	}
	
	
	public void setIntestazioneListino(String nomeAzienda, String idAzienda, String citta, String automatico){
		((RiepilogoIntestazioneListinoView) riep_intestaz_listino).setIntestazioneListino(nomeAzienda, idAzienda, citta, automatico);
	}
	
	
	public void setAbilitaAggiungi(boolean b){
		((RiepilogoIntestazioneListinoView) riep_intestaz_listino).setAbilitaAddProdotto(b);
	}
	
	
	public void initTable(M_Prodotto[] listaProdotti) throws PersistentException{
		((RiepilogoListinoView) riep_listino).initTable(listaProdotti);
	}
	
	
	public void setSchedaProdotto(M_Prodotto prod){
		((RiepilogoProdottoFactoryView) riep_listino).setSchedaProdotto(prod);
	}

	
	public void disattivaSalvaModificheProdotto(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setVisibleBtnSalvaModifiche(b);
	}


	public void disattivaAnnullaModificheProdotto(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setVisibleBtnAnnullaModifiche(b);
	}

	
	public void disattivaModificaProd(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setVisibleBtnModifica(b);
	}
	
	
	public void disattivaIndietro(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setVisibleBtnIndietro(b);
	}
	
	public void disattivaCancellaProd(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setVisibleBtnCancella(b);
	}
	
	
	public void setEnableTabListino(boolean b ) {
		tabbedPrincipale.setEnabledAt(2, b);
	}
	
	 public void selectTabListino(){
		 tabbedPrincipale.setSelectedIndex(2);
	 }
	
	public void resetNuovoProdotto() {
		((NuovoProdottoFactoryView) riep_listino).resetNewProdotto();
	}

	
	public void setEnableCercaListino(boolean b){
		bottoneCercaListino.setEnabled(b);
	}
	
	
	public void setModificheProdotto(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setTFeditable(b);
	}
	
	
	public void setVisibleErroreRiepProd(boolean b){
		((RiepilogoProdottoFactoryView) riep_listino).setVisibleErroreRiepProdotto(b);
	}
	
	
	public void setVisibleToolTipListino(){
		((RiepilogoProdottoFactoryView) riep_listino).abilitaToolTip();
	}
	
	
	public void setInvisibleToolTipListino(){
		((RiepilogoProdottoFactoryView) riep_listino).disabilitaToolTip();
	}
	
	
	/****  FUNZIONI SCONTO ****/
	
	public void setSfondoSconto() {
		JPanel sfondoSconto = new Sfondo_Sconto();
		pannello_centrale_sconto.add(sfondoSconto);
	}
	
	
	public void resetPannelloCentraleSconto(){
		pannello_centrale_sconto.removeAll();
		pannello_centrale_sconto.repaint();		
	}
	
	
	public void resetSelezioneSconto() {
		((SelezionaScontoView) dettaglio_sconto).resetSelezioneSconto();
	}
	
	
	public void resetNuovoSconto() {
		((NuovoScontoFactoryView) dettaglio_sconto).resetNuovoSconto();
	}
	
	
	public void setEnableCercaSconto(boolean b){
		bottoneCercaSconto.setEnabled(b);
	}
	
	public void setEnableNewSconto(boolean b) {
		bottoneNuovoSconto.setEnabled(b);		
	}
	
	
	public void setSchedaSconto(M_Sconto sconto) {
		((RiepilogoScontoFactoryView) riep_sconto).setSchedaSconto(sconto);
	}
	
	
	public void disattivaModificaSconto(boolean b) {
		((RiepilogoScontoFactoryView) riep_sconto).setVisibleBtnModifica(b);
	}
	
	public void disattivaSalvaModificheSconto(boolean b) {
		((RiepilogoScontoFactoryView) riep_sconto).setVisibleBtnSalvaModifiche(b);
	}
	
	
	public void disattivaAnnullaModificheSconto(boolean b) {
		((RiepilogoScontoFactoryView) riep_sconto).setVisibleBtnAnnullaModifiche(b);
	}
	
	
	public void setVisibleErroreRiepSconto(boolean b) {
		((RiepilogoScontoFactoryView) riep_sconto).setVisibleErroreRiepSconto(b);
	}
	
	
	public void setModificheSconto(boolean b) {
		((RiepilogoScontoFactoryView) riep_sconto).setTFeditable(b);
	}
	
	
	public void disattivaCancellaSconto(boolean b) {
		((RiepilogoScontoFactoryView) riep_sconto).setVisibleBtnCancella(b);
	}
	
	
	public void setVisibleToolTipSconto() {
		((RiepilogoScontoFactoryView) riep_sconto).abilitaToolTip();
	}
	
	
	public void setInvisibleToolTipSconto() {
		((RiepilogoScontoFactoryView) riep_sconto).disabilitaToolTip();
	}
	
	
	public void setEnableTabSconto(boolean b ) {
		tabbedPrincipale.setEnabledAt(3, b);
	}
	
}
