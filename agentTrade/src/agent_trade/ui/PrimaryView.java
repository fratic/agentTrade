package agent_trade.ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;
import agent_trade.ui.content.CercaClienteView;
import agent_trade.ui.content.NuovoPreventivoView;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class PrimaryView extends JFrame {
	
	private static PrimaryView instance;	
	private JButton nuovo_preventivo;
	private JPanel pannello_centrale_preventivo;
	private JPanel prin;
	private JButton bottoneCercaCliente;
	private JTree albero;
	private JTextField textField;
	
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
		
		JTabbedPane tabbedPrincipale = new JTabbedPane(JTabbedPane.TOP);
		tabbedPrincipale.setBounds(0, 0, 1097, 865);
		getContentPane().add(tabbedPrincipale);
		
		JPanel preventivo = new JPanel();
		tabbedPrincipale.addTab("Preventivo", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/preventivo.png")), preventivo, "Gestisci i preventivi");
		preventivo.setLayout(null);
				
		JPanel panello_menu_preventivo = new JPanel();
		panello_menu_preventivo.setBackground(Color.WHITE);
		panello_menu_preventivo.setBounds(0, 0, 1003, 124);
		preventivo.add(panello_menu_preventivo);
		panello_menu_preventivo.setLayout(null);
		
		nuovo_preventivo = new JButton("");
		nuovo_preventivo.setToolTipText("Crea un nuovo preventivo");
		nuovo_preventivo.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/nuovo_icon.png")));
		nuovo_preventivo.setBounds(20, 20, 50, 50);
		panello_menu_preventivo.add(nuovo_preventivo);
		
		nuovo_preventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_elaboraPreventivo.getInstance().newPreventivo(Ctrl_System.getAgenteLog());				
			}

		});
		
		
			
		JPanel panello_sottomenu_preventivo = new JPanel();
		panello_sottomenu_preventivo.setBounds(0, 123, 1003, 551);
		preventivo.add(panello_sottomenu_preventivo);
		panello_sottomenu_preventivo.setLayout(null);
		
		JPanel panello_laterale_preventivo = new JPanel();
		panello_laterale_preventivo.setBounds(0, 0, 250, 551);
		panello_sottomenu_preventivo.add(panello_laterale_preventivo);
		panello_laterale_preventivo.setLayout(null);
		
		
		pannello_centrale_preventivo = new JPanel();
		pannello_centrale_preventivo.setBackground(Color.LIGHT_GRAY);
		pannello_centrale_preventivo.setBounds(260, 0, 755, 551);
		panello_sottomenu_preventivo.add(pannello_centrale_preventivo);
		pannello_centrale_preventivo.setLayout(null);

		
		prin= new NuovoPreventivoView();
		prin.setBounds(0, 1, 755, 97);
		//JPanel prin= new asd();

		pannello_centrale_preventivo.add(prin);
		prin.setVisible(false);

		//JLabel(prin.labelCliente).setText("sdf");

		
		JPanel Cliente = new JPanel();
		tabbedPrincipale.addTab("Cliente", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/cliente.png")), Cliente, "Gestisci i clienti");
		Cliente.setLayout(null);
		
		JPanel panello_menu_cliente = new JPanel();
		panello_menu_cliente.setBounds(0, 0, 1003, 124);
		panello_menu_cliente.setLayout(null);
		panello_menu_cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		panello_menu_cliente.setBackground(Color.WHITE);
		Cliente.add(panello_menu_cliente);
		
		JButton bottoneNuovoCliente = new JButton("Nuovo Cliente");
		bottoneNuovoCliente.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/add_cliente.png")));
		bottoneNuovoCliente.setBounds(27, 23, 140, 23);
		panello_menu_cliente.add(bottoneNuovoCliente);
		
		bottoneCercaCliente = new JButton("Cerca Cliente");
		bottoneCercaCliente.setBounds(177, 23, 120, 23);
		panello_menu_cliente.add(bottoneCercaCliente);
		
		JPanel panello_sottomenu_cliente = new JPanel();
		panello_sottomenu_cliente.setBounds(0, 123, 1003, 551);
		panello_sottomenu_cliente.setLayout(null);
		Cliente.add(panello_sottomenu_cliente);
		
		JPanel panello_laterale_cliente = new JPanel();
		panello_laterale_cliente.setBounds(0, 0, 250, 551);
		panello_sottomenu_cliente.add(panello_laterale_cliente);
		panello_laterale_cliente.setLayout(null);
		
		albero = new JTree();
		albero.setBounds(10, 11, 230, 443);
		panello_laterale_cliente.add(albero);
		
		JPanel pannello_centrale_cliente = new JPanel();
		pannello_centrale_cliente.setBackground(Color.LIGHT_GRAY);
		pannello_centrale_cliente.setBounds(248, 0, 755, 551);
		panello_sottomenu_cliente.add(pannello_centrale_cliente);
		
		JPanel Catalogo = new JPanel();
		tabbedPrincipale.addTab("Catalogo", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/magazzino_icon.png")), Catalogo, null);
		Catalogo.setLayout(null);
		
		JPanel panello_menu_catalogo = new JPanel();
		panello_menu_catalogo.setBounds(0, 0, 1003, 124);
		panello_menu_catalogo.setLayout(null);
		panello_menu_catalogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panello_menu_catalogo.setBackground(Color.WHITE);
		Catalogo.add(panello_menu_catalogo);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(27, 23, 89, 23);
		panello_menu_catalogo.add(button_1);
		
		JPanel panello_sottomenu_catalogo = new JPanel();
		panello_sottomenu_catalogo.setBounds(0, 123, 1003, 551);
		panello_sottomenu_catalogo.setLayout(null);
		Catalogo.add(panello_sottomenu_catalogo);
		
		JPanel panello_laterale_catalogo = new JPanel();
		panello_laterale_catalogo.setBounds(0, 0, 250, 551);
		panello_sottomenu_catalogo.add(panello_laterale_catalogo);
		
		JPanel panello_centrale_catalogo = new JPanel();
		panello_centrale_catalogo.setBackground(Color.LIGHT_GRAY);
		panello_centrale_catalogo.setBounds(248, 0, 755, 551);
		panello_sottomenu_catalogo.add(panello_centrale_catalogo);
		panello_centrale_catalogo.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 526, 166);
		panello_centrale_catalogo.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(86, 37, 46, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(155, 34, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton bottonrAzione = new JButton("azione");
		bottonrAzione.setToolTipText("rthf");
		bottonrAzione.setIcon(new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/Bullet-red_50.png")));
		bottonrAzione.setBounds(284, 33, 172, 42);
		panel.add(bottonrAzione);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(102, 88, 97, 23);
		panel.add(chckbxNewCheckBox);
		this.init();
		this.initComponents();
		
		
		bottoneCercaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CercaClienteView.getInstance().getJTableModel();

				DefaultTableModel dm =((DefaultTableModel) CercaClienteView.getInstance().getJTableModel());

				int k=dm.getRowCount();
				
				//System.out.println("FUORI CICLO, K VALE: "+k);
						for (int i=k-1; i>=0;i--){
							dm.removeRow(i);
						}
				
				Ctrl_gestisciCliente.getInstance().apriViewCercaCliente();	
				
			}

		});

		
		bottoneNuovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dao_System.getInstance().nuovoCliente(new M_Cliente(12, "beato", "mirco", "sdffgs", "va pescara", "ciccio@samri.it"));	
				Dao_System.getInstance().caricaClienti();
			}

		});
		
	}
	
	public static PrimaryView getInstance(){
		if (instance==null)
			instance = new PrimaryView();
		return instance;	 
	}
	
	public void init(){
		
	}
	
	public void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 748);

	}
	
	public void setEnableNewPreventivo(boolean b){
		nuovo_preventivo.setEnabled(b);
	}
	
	public void setVisibleIntestazione(boolean b){
		prin.setVisible(b);
	}
	
	public JPanel getInstanceIntestazione(){
		return prin;
	}
	
	public void initAlberoClienti(DefaultTreeModel modello){
		//ArrayList c= Ctrl_gestisciCliente.getInstance().caricaAlberoClienti();
		/*albero.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Elenco Clienti") {
					{
						DefaultMutableTreeNode node_1;
						node_1 = new DefaultMutableTreeNode("cliente 1");
							node_1.add(new DefaultMutableTreeNode("blfdfue"));
							node_1.add(new DefaultMutableTreeNode("viodflet"));
							node_1.add(new DefaultMutableTreeNode("rdfded"));
							node_1.add(new DefaultMutableTreeNode("yfdfdfellow"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("cliente 2");
							node_1.add(new DefaultMutableTreeNode("baskedfdftball"));
							node_1.add(new DefaultMutableTreeNode("socdfdfcer"));
							node_1.add(new DefaultMutableTreeNode("foodftball"));
							node_1.add(new DefaultMutableTreeNode("hodfckey"));
						add(node_1);
						node_1 = new DefaultMutableTreeNode("cliente 3");
							node_1.add(new DefaultMutableTreeNode("hotvbxb dogs"));
							node_1.add(new DefaultMutableTreeNode("pibrbzza"));
							node_1.add(new DefaultMutableTreeNode("rfgbavioli"));
							node_1.add(new DefaultMutableTreeNode("banfbanas"));
						add(node_1);
					}
				}
			));*/
		
		albero.setModel(modello);
		
	}
}
