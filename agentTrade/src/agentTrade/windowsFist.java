package agentTrade;

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


public class windowsFist {

	private JFrame frmAgentTrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowsFist window = new windowsFist();
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
	public windowsFist() {
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
		
		JPanel fino = new JPanel();
		asd.addTab("File\r\n", new ImageIcon(windowsFist.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")), fino, null);
		
		JButton btnNewButton = new JButton("New button");
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		
		JSplitPane splitPane = new JSplitPane();
		
		JButton btnNewButton_1 = new JButton("New button");
		
		JSplitPane splitPane_1 = new JSplitPane();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_fino = new GroupLayout(fino);
		gl_fino.setHorizontalGroup(
			gl_fino.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(51)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(859))
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(36)
					.addComponent(radioButton))
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(208)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(598, Short.MAX_VALUE))
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(291)
					.addComponent(btnNewButton_1)
					.addContainerGap(619, Short.MAX_VALUE))
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(158)
					.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(648, Short.MAX_VALUE))
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(226)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(763, Short.MAX_VALUE))
		);
		gl_fino.setVerticalGroup(
			gl_fino.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fino.createSequentialGroup()
					.addGap(23)
					.addComponent(btnNewButton)
					.addGap(27)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_fino.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fino.createSequentialGroup()
							.addGap(11)
							.addComponent(radioButton))
						.addGroup(gl_fino.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)))
					.addGap(69)
					.addComponent(splitPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(380, Short.MAX_VALUE))
		);
		fino.setLayout(gl_fino);
		
		JPanel preventivo = new JPanel();
		preventivo.setBackground(Color.WHITE);
		asd.addTab("Preventivo", new ImageIcon("C:\\Users\\Fratic\\Desktop\\preventivo.png"), preventivo, null);
		preventivo.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 999, 109);
		panel_2.setBackground(Color.WHITE);
		preventivo.add(panel_2);
		panel_2.setLayout(null);
		
		JButton nuovoPreventivo = new JButton("Nuovo preventivo");
		nuovoPreventivo.setBounds(22, 27, 143, 29);
		panel_2.add(nuovoPreventivo);
		nuovoPreventivo.setIcon(new ImageIcon(windowsFist.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMuteDisabled.png")));
		nuovoPreventivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 110, 999, 9);
		preventivo.add(separator);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 110, 999, 576);
		preventivo.add(panel_3);
		panel_3.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 0, 222, 576);
		panel_3.add(tree);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Dicembre") {
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
		
		JPanel Cliente = new JPanel();
		asd.addTab("Cliente", new ImageIcon("C:\\Users\\Fratic\\Desktop\\cliente.png"), Cliente, null);
		
	}
}
