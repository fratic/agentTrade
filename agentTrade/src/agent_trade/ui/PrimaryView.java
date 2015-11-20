package agent_trade.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_elaboraPreventivo;




import agent_trade.model.M_Prodotto;
import agent_trade.ui.content.AlberoPreventivi;
import agent_trade.ui.content.IntestazioneNuovoPreventivoView;
import agent_trade.ui.content.ItemPreventivoView;
import agent_trade.ui.content.ProdottiView;
import agent_trade.ui.content.RiepilogoIntestazionePreventivoView;
import agent_trade.ui.content.RiepilogoItemPreventivoView;

import javax.swing.border.TitledBorder;


public class PrimaryView extends JFrame {
	
	private static PrimaryView instance;	
	private static JPanel intestazione;
	private static JPanel item;

	private static  JPanel riep_intestazione;
	private static JPanel riep_item;

	private JButton nuovo_preventivo;
	private JButton bottoneCercaCliente;
	private JButton bottoneNuovoCliente;
	
	private static JPanel pannello_centrale_preventivo;
	private JPanel preventivo;
	private JPanel panello_menu_preventivo;
	private JPanel panello_sottomenu_preventivo;
	private JPanel panello_laterale_preventivo;
	private JPanel Cliente;
	private JPanel panello_menu_cliente;
	private JPanel panello_sottomenu_cliente;
	private JPanel panello_laterale_cliente;
	private JPanel pannello_centrale_cliente;
	private JPanel Catalogo;
	private JPanel panello_menu_catalogo;
	private JPanel panello_sottomenu_catalogo;
	private JPanel panello_laterale_catalogo;
	private JPanel panello_centrale_catalogo;
	
	private JPanel pannelloProdotti;

	private JPanel alberoPreventivi;
	
	private static JPanel riepilogoPreventivo;
 
	
	private JTabbedPane tabbedPrincipale;
	
	private JTree albero;
	
	private static final int WIDTH = 1024;
	private static final int HEIGHT = 784;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimaryView frame = new PrimaryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	
	public PrimaryView() {
		
		getContentPane().setLayout(null);
		
		tabbedPrincipale = new JTabbedPane(JTabbedPane.TOP);
		tabbedPrincipale.setBounds(0, 0, 1097, 865);

		getContentPane().add(tabbedPrincipale);
		
		preventivo = new JPanel();
		tabbedPrincipale.addTab("Preventivo", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/preventivo.png")), preventivo, "Gestisci i preventivi");
		preventivo.setLayout(null);
				
		panello_menu_preventivo = new JPanel();
		panello_menu_preventivo.setBackground(Color.WHITE);
		panello_menu_preventivo.setBounds(0, 0, 1003, 124);
		preventivo.add(panello_menu_preventivo);
		panello_menu_preventivo.setLayout(null);
		
		nuovo_preventivo = new JButton("");
		nuovo_preventivo.setToolTipText("Crea un nuovo preventivo");
		nuovo_preventivo.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/nuovo_icon.png")));
		nuovo_preventivo.setBounds(20, 20, 50, 50);
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
		panello_sottomenu_preventivo.setBounds(0, 123, 1003, 586);
		preventivo.add(panello_sottomenu_preventivo);
		panello_sottomenu_preventivo.setLayout(null);
		
		panello_laterale_preventivo = new JPanel();
		panello_laterale_preventivo.setBounds(0, 0, 261, 585);
		panello_sottomenu_preventivo.add(panello_laterale_preventivo);
		panello_laterale_preventivo.setLayout(null);
		
		
		alberoPreventivi = new AlberoPreventivi();
		alberoPreventivi.setBounds(0, 0, 250, 585);
		panello_laterale_preventivo.add(alberoPreventivi);

		
		
		pannello_centrale_preventivo = new JPanel();
		pannello_centrale_preventivo.setBackground(Color.LIGHT_GRAY);
		pannello_centrale_preventivo.setBounds(260, 0, 743, 585);
		panello_sottomenu_preventivo.add(pannello_centrale_preventivo);
		pannello_centrale_preventivo.setLayout(null);


		/*intestazione= IntestazioneNuovoPreventivoView.getInstance();
		intestazione.setBounds(0, 1, 755, 136);

		pannello_centrale_preventivo.add(intestazione);
		*/
		
		/*item= ItemPreventivoView.getInstance();
		item.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		item.setBounds(0, 138, 745, 449);
		
		pannello_centrale_preventivo.add(item);
		
		item.setVisible(false);
		*/
		//intestazione.setVisible(false);

		
		/*riepilogoPreventivo =new RiepilogoPreventivoView();
		riepilogoPreventivo.setBounds(0, 1, 745, 584);
		pannello_centrale_preventivo.add(riepilogoPreventivo);
*/
		
		
		
		Cliente = new JPanel();
		tabbedPrincipale.addTab("Cliente", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/cliente.png")), Cliente, "Gestisci i clienti");
		Cliente.setLayout(null);
		
		panello_menu_cliente = new JPanel();
		panello_menu_cliente.setBounds(0, 0, 1003, 124);
		panello_menu_cliente.setLayout(null);
		panello_menu_cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		panello_menu_cliente.setBackground(Color.WHITE);
		Cliente.add(panello_menu_cliente);
		
		bottoneNuovoCliente = new JButton("Nuovo Cliente");
		bottoneNuovoCliente.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/add_cliente.png")));
		bottoneNuovoCliente.setBounds(27, 23, 140, 23);
		panello_menu_cliente.add(bottoneNuovoCliente);
		
		bottoneCercaCliente = new JButton("Cerca Cliente");
		bottoneCercaCliente.setBounds(177, 23, 120, 23);
		panello_menu_cliente.add(bottoneCercaCliente);
		
		panello_sottomenu_cliente = new JPanel();
		panello_sottomenu_cliente.setBounds(0, 123, 1003, 551);
		panello_sottomenu_cliente.setLayout(null);
		Cliente.add(panello_sottomenu_cliente);
		
		panello_laterale_cliente = new JPanel();
		panello_laterale_cliente.setBounds(0, 0, 250, 551);
		panello_sottomenu_cliente.add(panello_laterale_cliente);
		panello_laterale_cliente.setLayout(null);
		
		albero = new JTree();
		albero.setBounds(10, 11, 230, 443);
		panello_laterale_cliente.add(albero);
		
		pannello_centrale_cliente = new JPanel();
		pannello_centrale_cliente.setBackground(Color.LIGHT_GRAY);
		pannello_centrale_cliente.setBounds(248, 0, 755, 551);
		panello_sottomenu_cliente.add(pannello_centrale_cliente);
		
		Catalogo = new JPanel();
		tabbedPrincipale.addTab("Catalogo", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/magazzino_icon.png")), Catalogo, null);
		Catalogo.setLayout(null);
		
		panello_menu_catalogo = new JPanel();
		panello_menu_catalogo.setBounds(0, 0, 1003, 124);
		panello_menu_catalogo.setLayout(null);
		panello_menu_catalogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panello_menu_catalogo.setBackground(Color.WHITE);
		Catalogo.add(panello_menu_catalogo);
		
		panello_sottomenu_catalogo = new JPanel();
		panello_sottomenu_catalogo.setBounds(0, 123, 1003, 551);
		panello_sottomenu_catalogo.setLayout(null);
		Catalogo.add(panello_sottomenu_catalogo);
		
		panello_laterale_catalogo = new JPanel();
		panello_laterale_catalogo.setBounds(0, 0, 250, 551);
		panello_sottomenu_catalogo.add(panello_laterale_catalogo);
		
		panello_centrale_catalogo = new JPanel();
		panello_centrale_catalogo.setBackground(Color.LIGHT_GRAY);
		panello_centrale_catalogo.setBounds(248, 0, 755, 551);
		panello_sottomenu_catalogo.add(panello_centrale_catalogo);
		panello_centrale_catalogo.setLayout(null);
		
		
		pannelloProdotti = ProdottiView.getInstance();
		pannelloProdotti.setBounds(0, 0, 745, 449);
		panello_centrale_catalogo.add(pannelloProdotti);
		
		

		
		
		//this.init();
		this.initComponents();
		
	//	initRiepilogo();

		
		
		bottoneCercaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				/*
				//tutto da rifare
				CercaClienteView.getInstance().getJTableModel();

				DefaultTableModel dm =((DefaultTableModel) CercaClienteView.getInstance().getJTableModel());

				int k=dm.getRowCount();
				for (int i=k-1; i>=0;i--){
					dm.removeRow(i);
				}
				
				Ctrl_gestisciCliente.getInstance().apriViewCercaCliente();	
			*/
			}
			
		});

		
		bottoneNuovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		nuovo_preventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_elaboraPreventivo.getInstance().newPreventivo(Ctrl_System.getAgenteLog());				
			}
		});
				
	}
	
	public static PrimaryView getInstance(){
		if (instance==null)
			instance = new PrimaryView();
		return instance;	 
	}
	
	public static void initIntestazione(){
		
		intestazione= IntestazioneNuovoPreventivoView.getInstance();
		intestazione.setBounds(0, 1, 755, 136);
		pannello_centrale_preventivo.add(intestazione);
		pannello_centrale_preventivo.repaint();

	}
	

	
	public static void initItem(){
		item= ItemPreventivoView.getInstance();
		item.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		item.setBounds(0, 138, 745, 449);
		
		pannello_centrale_preventivo.add(item);
		pannello_centrale_preventivo.repaint();
		
		//item.setVisible(false);
	}
	
	
	public static void initRiepilogo(){
		
			RiepilogoIntestazionePreventivoView.cancellaIstanzaRiepilogoIntestazione();
			pannello_centrale_preventivo.repaint();

			riep_intestazione =RiepilogoIntestazionePreventivoView.getInstance();
			riep_intestazione.setBounds(0, 1, 745, 140);
			pannello_centrale_preventivo.add(riep_intestazione);
			pannello_centrale_preventivo.repaint();

			RiepilogoItemPreventivoView.cancellaIstanzaRiepilogoItem();
			pannello_centrale_preventivo.repaint();

			riep_item = RiepilogoItemPreventivoView.getInstance();
			riep_item.setBounds(0, 141, 745, 585);
			pannello_centrale_preventivo.add(riep_item);
			pannello_centrale_preventivo.repaint();


			
	}
	


	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setBounds(150, 210, 1024, 748);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screen.width;
        int y = screen.height;
        this.setBounds(100,100,WIDTH,HEIGHT);
        //sarebbe carino dimensionare TUTTE le finestre in base alla dimensione dello schermo

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
	
	
	
	public void initAlberoClienti(DefaultTreeModel modello){
		
		albero.setModel(modello);
		
	}

	public void selectTabCatalogo() {
		tabbedPrincipale.setSelectedIndex(2);
		//tabbedPrincipale.setEnabledAt(1, false);
	}

	public void setEnableTabCliente(boolean b ) {
		tabbedPrincipale.setEnabledAt(1, b);
	}
	
	public static void cancIntestazione(){
		IntestazioneNuovoPreventivoView.cancIntestazione();
		intestazione=null;
	//	init();
	}
	
	public static void cancItem(){
		ItemPreventivoView.cancItem();
		item=null;
		//init();

	}

	public void updateTableRiepilogo(String rem, String id, String nome, String categoria, String quantita, String prezzo, String parziale){
		((RiepilogoItemPreventivoView) riep_item).updateTable(rem, id, nome, categoria, quantita, prezzo, parziale);
	
	}

	
	
	
}
