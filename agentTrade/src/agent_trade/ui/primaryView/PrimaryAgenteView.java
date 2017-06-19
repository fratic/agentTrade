package agent_trade.ui.primaryView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.TreePath;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.external_system.SystemDaemon;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.ui.content.clienti.AlberoClienti;
import agent_trade.ui.content.clienti.DettaglioClienteView;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;
import agent_trade.ui.content.preventivi.IntestazioneNuovoPreventivoView;
import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.preventivi.RiepilogoItemPreventivoView;
import agent_trade.ui.content.prodotti.AlberoProdotti;
import agent_trade.ui.content.prodotti.ProdottiView;
import agent_trade.util.Costanti;
import agent_trade.util.Sfondo_Cliente;
import agent_trade.util.Sfondo_Preventivo;

public class PrimaryAgenteView extends PrimaryViewFactory 
{
	
	/*attributi di classe*/
	
	private static PrimaryAgenteView instance;	
	
	private static JPanel intestazione;
	private static JPanel item;
	
	private static JPanel riep_intestazione;
	private static JPanel riep_item;
	
	private static JPanel pannello_centrale_preventivo;
	
	private static JPanel dettaglioCliente;
	private static JPanel riep_cliente;
	
	private static JPanel pannello_centrale_cliente;


	/*attributi privati*/
	
	private JButton nuovo_preventivo;
	private JButton cerca_preventivo;
	private JButton bottoneCercaCliente;
	private JButton bottoneNuovoCliente;
	private JButton bottoneUpdateCliente;


	private JPanel preventivo;
	private JPanel pannello_menu_preventivo;
	private JPanel pannello_sottomenu_preventivo;
	private JPanel pannello_laterale_preventivo;
	
	
	private JPanel Cliente;
	private JPanel pannello_menu_cliente;
	private JPanel pannello_sottomenu_cliente;
	private JPanel pannello_laterale_cliente;
	
	
	private JPanel Catalogo;
	private JPanel pannello_menu_catalogo;
	private JPanel pannello_sottomenu_catalogo;
	private JPanel pannello_laterale_catalogo;
	private JPanel pannello_centrale_catalogo;
	private JPanel pannelloProdotti;
	
	
	private JPanel alberoPreventivi;
	private JPanel alberoClienti;
	private JPanel alberoProdotti;

	
	/*costruttori*/
	
	private PrimaryAgenteView() {

		super(Costanti.TITOLO_PRIMARY_VIEW);
		tabbedPrincipale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tabbedPrincipale.getSelectedIndex()==2){
					TreePath[] path=AlberoProdotti.albero.getSelectionPaths();
					if (path!=null){
						String azienda = (String) path[0].getLastPathComponent().toString();
						if(azienda==null){
							azienda = "Tutti i prodotti";
						}
						try {
							ProdottiView.getInstance().inserisciTabella(Ctrl_gestisciListino.getProdottiListino(), azienda);
						} 
						catch (PersistentException e1) {
							e1.printStackTrace();
						}
					}
					else{
						try {
							ProdottiView.getInstance().inserisciTabella(Ctrl_gestisciListino.getProdottiListino(), "Tutti i prodotti");
						} catch (PersistentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		initTabPreventivo();
		
		initTabCliente();
		
		initTabCatalogo();

	}
	
	
	/*metodi di classe*/
	
	public static PrimaryAgenteView getInstance(){
		if (instance==null)
			instance = new PrimaryAgenteView();
		return instance;	 
	}
	
	public static void initIntestazione(){

		intestazione= IntestazioneNuovoPreventivoView.getInstance();
		intestazione.setPreferredSize(new Dimension(733,150));
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
		
		PrimaryAgenteView.getInstance().resetPannelloCentralePreventivo();
	
		riep_intestazione =RiepilogoIntestazionePreventivoView.getInstance();
		riep_intestazione.setPreferredSize(new Dimension(733,150));
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
	
	public void initTabPreventivo(){
		
		
		preventivo = new JPanel();
		preventivo.setBackground(Color.WHITE);
		tabbedPrincipale.addTab(Costanti.TAB_PREVENTIVO, new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.PREVENTIVO_ICON)), preventivo, Costanti.TIP_GESTISCI_PREVENTIVO);
		tabbedPrincipale.setBackgroundAt(0, Color.WHITE);
		preventivo.setLayout(new BorderLayout());
				
		pannello_menu_preventivo = new JPanel();
		pannello_menu_preventivo.setBackground(Color.WHITE);
	
		pannello_menu_preventivo.setPreferredSize(new Dimension(1013, 100));
		preventivo.add(pannello_menu_preventivo, BorderLayout.NORTH);
		pannello_menu_preventivo.setLayout(null);
		
		nuovo_preventivo = new JButton("");
		nuovo_preventivo.setBounds(30, 25, 50, 50);
		nuovo_preventivo.setToolTipText(Costanti.TIP_NUOVO_PREVENTIVO);
		nuovo_preventivo.setIcon(new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.NUOVO_PREVENTIVO_ICON)));
		pannello_menu_preventivo.add(nuovo_preventivo);
		
		cerca_preventivo = new JButton("");
		cerca_preventivo.setToolTipText(Costanti.TIP_CERCA_PREVENTIVO);
		cerca_preventivo.setIcon(new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.CERCA_PREVENTIVO_ICON)));
		cerca_preventivo.setBounds(103, 25, 50, 50);
		pannello_menu_preventivo.add(cerca_preventivo);
		
		/*JButton button = new JButton("");
		button.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		button.setBounds(94, 20, 50, 50);
		pannello_menu_preventivo.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/delete.png")));
		button_1.setBounds(168, 20, 50, 50);
		pannello_menu_preventivo.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/Settings-icon.png")));
		button_2.setBounds(246, 20, 50, 50);
		pannello_menu_preventivo.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/search-icon.png")));
		button_3.setBounds(323, 20, 50, 50);
		pannello_menu_preventivo.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/carrelloOrdine.png")));
		button_4.setBounds(394, 20, 50, 50);
		pannello_menu_preventivo.add(button_4);*/
		
		pannello_sottomenu_preventivo = new JPanel();
		pannello_sottomenu_preventivo.setPreferredSize(new Dimension(1013, 617));
		preventivo.add(pannello_sottomenu_preventivo, BorderLayout.CENTER);
		pannello_sottomenu_preventivo.setLayout(new BorderLayout());

		
		pannello_laterale_preventivo = new JPanel();
		pannello_laterale_preventivo.setBackground(UIManager.getColor("ToggleButton.background"));
		pannello_laterale_preventivo.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_preventivo.add(pannello_laterale_preventivo, BorderLayout.WEST);
		pannello_laterale_preventivo.setLayout(null);
		
		
		alberoPreventivi = AlberoPreventivi.getInstance();
		alberoPreventivi.setBounds(0, 0, 260, 617);
		pannello_laterale_preventivo.add(alberoPreventivi);

		
		pannello_centrale_preventivo = new JPanel();
		pannello_centrale_preventivo.setBackground(SystemColor.control);
		pannello_centrale_preventivo.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_preventivo.add(pannello_centrale_preventivo, BorderLayout.CENTER);
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
		
		cerca_preventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

					Ctrl_elaboraPreventivo.getInstance().btnCerca();			
			}
		});
		
	}
	
	

	public void initTabCliente(){
		
		Cliente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_CLIENTE, new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.CLIENTE_ICON)), Cliente, Costanti.TIP_GESTISCI_CLIENTE);
		Cliente.setLayout(new BorderLayout());
		
		pannello_menu_cliente = new JPanel();
		pannello_menu_cliente.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_cliente.setLayout(null);

		pannello_menu_cliente.setBackground(Color.WHITE);
		Cliente.add(pannello_menu_cliente,BorderLayout.NORTH);
		
		bottoneNuovoCliente = new JButton();
		bottoneNuovoCliente.setIcon(new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.NUOVO_CLIENTE_ICON)));
		bottoneNuovoCliente.setToolTipText(Costanti.TIP_NUOVO_CLIENTE);
		bottoneNuovoCliente.setBounds(25, 25, 50, 50);
		pannello_menu_cliente.add(bottoneNuovoCliente);
		
		bottoneCercaCliente = new JButton("");
		bottoneCercaCliente.setIcon(new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.CERCA_CLIENTE_ICON)));
		bottoneCercaCliente.setToolTipText(Costanti.TIP_CERCA_CLIENTE);
		bottoneCercaCliente.setBounds(103, 25, 50, 50);
		pannello_menu_cliente.add(bottoneCercaCliente);
		
		bottoneUpdateCliente = new JButton("");
		bottoneUpdateCliente.setIcon(new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.UPDATE_CLIENTE_ICON)));
		bottoneUpdateCliente.setToolTipText(Costanti.TIP_UPDATE_CLIENTE);
		bottoneUpdateCliente.setBounds(181, 25, 50, 50);
		pannello_menu_cliente.add(bottoneUpdateCliente);
		
		pannello_sottomenu_cliente = new JPanel();
		pannello_sottomenu_cliente.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_cliente.setLayout(new BorderLayout());
		Cliente.add(pannello_sottomenu_cliente, BorderLayout.CENTER);

		
		pannello_laterale_cliente = new JPanel();
		pannello_laterale_cliente.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_cliente.add(pannello_laterale_cliente, BorderLayout.WEST);
		pannello_laterale_cliente.setLayout(null);

		
		alberoClienti = new AlberoClienti();
		alberoClienti.setBounds(0, 0, 261, 617);
		pannello_laterale_cliente.add(alberoClienti);
		
		pannello_centrale_cliente = new JPanel();
		pannello_centrale_cliente.setBackground(SystemColor.control);

		pannello_centrale_cliente.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_cliente.add(pannello_centrale_cliente, BorderLayout.CENTER);
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
		
		bottoneUpdateCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					SystemDaemon.getInstance().sincronizzaClienti();
				} 
				catch (PersistentException | CloneNotSupportedException e) 
				{
					e.printStackTrace();
				}
				
			}
		});
			
	}
	
	public void initTabCatalogo(){
		
		
		Catalogo = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_CATALOGO, new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.PRODOTTI_ICON)), Catalogo, null);
		Catalogo.setLayout(new BorderLayout());
		
		pannello_menu_catalogo = new JPanel();
		pannello_menu_catalogo.setPreferredSize(new Dimension(1013,100));
		pannello_menu_catalogo.setLayout(null);
		pannello_menu_catalogo.setBackground(Color.WHITE);
		Catalogo.add(pannello_menu_catalogo, BorderLayout.NORTH);

		pannello_sottomenu_catalogo = new JPanel();
		pannello_sottomenu_catalogo.setPreferredSize(new Dimension(1013,617));
		pannello_sottomenu_catalogo.setLayout(new BorderLayout());
		Catalogo.add(pannello_sottomenu_catalogo,BorderLayout.CENTER);
		
		pannello_laterale_catalogo = new JPanel();
		pannello_laterale_catalogo.setBackground(UIManager.getColor("ToggleButton.background"));
		pannello_laterale_catalogo.setPreferredSize(new Dimension(260,617));
		pannello_sottomenu_catalogo.add(pannello_laterale_catalogo,BorderLayout.WEST);
		pannello_laterale_catalogo.setLayout(null);

		
		pannello_centrale_catalogo = new JPanel();
		pannello_centrale_catalogo.setBorder(new EmptyBorder(12, 12, 12, 12));
		pannello_centrale_catalogo.setPreferredSize(new Dimension(753,617));
		pannello_centrale_catalogo.setBackground(SystemColor.control);
		pannello_sottomenu_catalogo.add(pannello_centrale_catalogo,BorderLayout.CENTER);
		pannello_centrale_catalogo.setLayout(new GridLayout(1,1));
		
		pannelloProdotti = ProdottiView.getInstance();
		pannello_centrale_catalogo.add(pannelloProdotti);
		
		alberoProdotti = AlberoProdotti.getInstance();
		alberoProdotti.setBounds(0, 0, 260, 617);
		pannello_laterale_catalogo.add(alberoProdotti);
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
	
	
	public void setSchedaCliente(M_Cliente cliente) {
		
		((RiepilogoClienteView) riep_cliente).setRiepilogoCliente(cliente);
	}
	
//	public void setScontoCliente(String sconto){
//		((RiepilogoClienteView) riep_cliente).setScontoCliente(sconto);
//	}
	
	public void setScontoCliente(M_Sconto sconto) throws PersistentException{
		((RiepilogoClienteView) riep_cliente).setScontoCliente(sconto);
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
	
	//modificato il nome della funzione interna - - relativo al cliente
	public void disattivaSalvaModifiche(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnSalvaModifiche(b);
	}
	
	//modificato il nome della funzione interna - relativo al cliente
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
	
	public void disattivaModSconto(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnModSconto(b);
	}


	public void disattivaModAgente(boolean b){
		((RiepilogoClienteView) riep_cliente).setVisibleBtnModAgente(b);
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
	
	public void setEnableUpdateCliente(boolean b){
		bottoneUpdateCliente.setEnabled(b);
	}
	
	public void setEnableNewPreventivo(boolean b){
		nuovo_preventivo.setEnabled(b);
	}
	
	public void setEnableCercaPreventivo(boolean b){
		cerca_preventivo.setEnabled(b);
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
	
	public void setNewIntestCliente(String cognome, String nome, String indirizzo, String email, String sconto){
		((IntestazioneNuovoPreventivoView) intestazione).setCliente(cognome, nome, indirizzo, email, sconto);
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
	
	public void setRiepIntestCliente(M_Preventivo p) throws PersistentException{
	
		String cognome =p.getRif_Cliente().getCognome();
		String nome =p.getRif_Cliente().getNome();
		String indirizzo =p.getRif_Cliente().getIndirizzo();
		String email = p.getRif_Cliente().getEmail();
		String sconto = Ctrl_gestisciCliente.getInstance().mostraScontoCliente(p.getRif_Cliente().getSconto());
		((RiepilogoIntestazionePreventivoView) riep_intestazione).setCliente(cognome, nome, indirizzo, email, sconto);
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
	
	
	public void resetPannelloCentraleCatalogo(){
		pannello_centrale_catalogo.removeAll();
		pannello_centrale_catalogo.repaint();
		
	}
	
	public void updateTableRiepilogo(M_Preventivo prev, M_Preventivo_Item pr_it) throws PersistentException{
		String id = Integer.toString((pr_it.getIdProdotto().getIdProdotto()));
		String nome = pr_it.getIdProdotto().getNome();
		String categoria = pr_it.getIdProdotto().getCategoria();
		String quantita = Integer.toString(pr_it.getQuantita());
		String prezzo = Float.toString(pr_it.getIdProdotto().getPrezzo());
		String sconto = setTipoScontoTabella(pr_it);
		
		String parziale = Float.toString(pr_it.calcolaParziale());
		String parziale_scontato = Float.toString(pr_it.calcolaParziale()-pr_it.getStrategiaProdotto().calcolaSconto(prev));
		((RiepilogoItemPreventivoView) riep_item).updateTable(id, nome, categoria, quantita, prezzo, sconto, parziale, parziale_scontato);	
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
	
	public String setTipoScontoTabella(M_Preventivo_Item item) throws PersistentException{
		
		String tipoSconto="";
		
		M_Sconto politicaSconto = M_Sconto.caricaSconto((int) ((M_Preventivo_Item) item).getIdProdotto().getSconto());
					
		if (politicaSconto instanceof M_ScontoQuantita)
		{
			if (((M_ScontoQuantita) politicaSconto).getScontoFisso()!=0) {
				tipoSconto="Sconto di "+((M_ScontoQuantita) politicaSconto).getScontoFisso()+" euro per q.tà superiori a "+((M_ScontoQuantita) politicaSconto).getQuantita();
			}
		}
		else if (politicaSconto instanceof M_ScontoPercent)
		{
			if(((M_ScontoPercent) politicaSconto).getPercent()!=0)
			{
				tipoSconto=((M_ScontoPercent) politicaSconto).getPercent()*100+" %";
			}
		}
		
		return tipoSconto;
}
}
