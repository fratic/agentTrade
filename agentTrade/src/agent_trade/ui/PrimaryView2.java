package agent_trade.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JRadioButtonMenuItem;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


////Bisogna cambiarla

public class PrimaryView2 {

	private JFrame frmAgentTrade;

	private static PrimaryView2 instance;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimaryView2 window = new PrimaryView2();
					window.frmAgentTrade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrimaryView2() {
		initialize();
		frmAgentTrade.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgentTrade = new JFrame();
		frmAgentTrade.setTitle("Agent Trade");
		frmAgentTrade.getContentPane().setBackground(UIManager.getColor("Button.light"));
		frmAgentTrade.setBounds(100, 100, 1024, 768);
		frmAgentTrade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgentTrade.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		frmAgentTrade.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane asd = new JTabbedPane(JTabbedPane.TOP);
		asd.setBackground(Color.WHITE);
		panel.add(asd);
		asd.setToolTipText("");
		
		JPanel file = new JPanel();
		asd.addTab("File\r\n", new ImageIcon(PrimaryView2.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")), file, null);
		GroupLayout gl_file = new GroupLayout(file);
		gl_file.setHorizontalGroup(
			gl_file.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1010, Short.MAX_VALUE)
		);
		gl_file.setVerticalGroup(
			gl_file.createParallelGroup(Alignment.LEADING)
				.addGap(0, 686, Short.MAX_VALUE)
		);
		file.setLayout(gl_file);
		
		JPanel Preventivo = new JPanel();
		Preventivo.setBackground(Color.WHITE);
		asd.addTab("Preventivo", new ImageIcon("C:\\Users\\Fratic\\Desktop\\preventivo.png"), Preventivo, null);
		Preventivo.setLayout(null);
		
		JPanel pan_sup = new JPanel();
		pan_sup.setBorder(null);
		pan_sup.setBounds(0, 0, 1000, 110);
		pan_sup.setBackground(Color.WHITE);
		Preventivo.add(pan_sup);
		pan_sup.setLayout(null);
		
		JButton nuovoPreventivo = new JButton("Nuovo preventivo");
		nuovoPreventivo.setToolTipText("Crea un nuovo preventivo");
		nuovoPreventivo.setHorizontalAlignment(SwingConstants.LEFT);
		nuovoPreventivo.setVerticalAlignment(SwingConstants.TOP);
		nuovoPreventivo.setBounds(24, 24, 155, 41);
		pan_sup.add(nuovoPreventivo);
		nuovoPreventivo.setIcon(new ImageIcon("C:\\Users\\Fratic\\Desktop\\nuovo_icon.png"));
		nuovoPreventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel pan_centro = new JPanel();
		pan_centro.setBounds(1, 111, 999, 575);
		Preventivo.add(pan_centro);
		pan_centro.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 222, 576);
		pan_centro.add(tree);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Dicembre") {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Cliente 1");
						node_1.add(new DefaultMutableTreeNode("Fattura 1"));
						node_1.add(new DefaultMutableTreeNode("Fattura 2"));
						node_1.add(new DefaultMutableTreeNode("Fattura 3"));
						node_1.add(new DefaultMutableTreeNode("Fattura 4"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cliente 2");
						node_1.add(new DefaultMutableTreeNode("Fattura 1"));
						node_1.add(new DefaultMutableTreeNode("Fattura 2"));
						node_1.add(new DefaultMutableTreeNode("Fattura 3"));
						node_1.add(new DefaultMutableTreeNode("Fattura 4"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Cliente 3");
						node_1.add(new DefaultMutableTreeNode("Fattura 1 "));
						node_1.add(new DefaultMutableTreeNode("Fattura 2"));
						node_1.add(new DefaultMutableTreeNode("Fattura 3"));
						node_1.add(new DefaultMutableTreeNode("Fattura 4"));
					add(node_1);
				}
			}
		));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 999, 9);
		pan_centro.add(separator);
		
		JPanel Cliente = new JPanel();
		asd.addTab("Cliente", new ImageIcon("C:\\Users\\Fratic\\Desktop\\cliente.png"), Cliente, null);
		
		
	}
	public static PrimaryView2 getInstance(){
		if(instance == null)
			instance = new PrimaryView2();
		
		return instance;
	}
	
}
