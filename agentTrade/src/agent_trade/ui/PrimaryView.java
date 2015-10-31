package agent_trade.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Button;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Agente;
import agent_trade.persistentTemp.Dao_System;

public class PrimaryView extends JFrame {
	
	public static PrimaryView instance;	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

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
		panello_menu_preventivo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panello_menu_preventivo.setBackground(Color.WHITE);
		panello_menu_preventivo.setBounds(0, 0, 1003, 124);
		preventivo.add(panello_menu_preventivo);
		panello_menu_preventivo.setLayout(null);
		
		JButton nuovo_preventivo = new JButton("");
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
		
		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Dicembre 2015");
						node_1.add(new DefaultMutableTreeNode("Preventivo 1"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 2"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 3"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 4"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Novembre 2015");
						node_1.add(new DefaultMutableTreeNode("Preventivo 1"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 2"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 3"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 4"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Ottobre 2015");
						node_1.add(new DefaultMutableTreeNode("Preventivo 1 "));
						node_1.add(new DefaultMutableTreeNode("Preventivo 2"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 3"));
						node_1.add(new DefaultMutableTreeNode("Preventivo 4"));
					add(node_1);
				}
			}
		));
		tree.setBounds(10, 11, 230, 529);
		panello_laterale_preventivo.add(tree);
		
		JPanel panello_centrale_preventivo = new JPanel();
		panello_centrale_preventivo.setBackground(Color.LIGHT_GRAY);
		panello_centrale_preventivo.setBounds(248, 0, 755, 551);
		panello_sottomenu_preventivo.add(panello_centrale_preventivo);
		
		JPanel Cliente = new JPanel();
		tabbedPrincipale.addTab("Cliente", new ImageIcon(PrimaryView.class.getResource("/agent_trade/ui/img/cliente.png")), Cliente, "Gestisci i clienti");
		Cliente.setLayout(null);
		
		JPanel panello_menu_cliente = new JPanel();
		panello_menu_cliente.setBounds(0, 0, 1003, 124);
		panello_menu_cliente.setLayout(null);
		panello_menu_cliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		panello_menu_cliente.setBackground(Color.WHITE);
		Cliente.add(panello_menu_cliente);
		
		JButton button = new JButton("New button");
		button.setBounds(27, 23, 89, 23);
		panello_menu_cliente.add(button);
		
		JPanel panello_sottomenu_cliente = new JPanel();
		panello_sottomenu_cliente.setBounds(0, 123, 1003, 551);
		panello_sottomenu_cliente.setLayout(null);
		Cliente.add(panello_sottomenu_cliente);
		
		JPanel panello_laterale_cliente = new JPanel();
		panello_laterale_cliente.setBounds(0, 0, 250, 551);
		panello_sottomenu_cliente.add(panello_laterale_cliente);
		
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
		this.init();
		this.initComponents();
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
}
