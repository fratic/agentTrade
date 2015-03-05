package agentTrade;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.TextArea;
import javax.swing.JTree;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class windowsFist {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowsFist window = new windowsFist();
					window.frame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.light"));
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Azienda1") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Pasta");
						node_1.add(new DefaultMutableTreeNode("Rigatoni"));
						node_1.add(new DefaultMutableTreeNode("Tagliatelle"));
						node_1.add(new DefaultMutableTreeNode("Linguine"));
						node_1.add(new DefaultMutableTreeNode("Spaghetti"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Carne");
						node_1.add(new DefaultMutableTreeNode("Maiale"));
						node_1.add(new DefaultMutableTreeNode("Pollo"));
						node_1.add(new DefaultMutableTreeNode("Manzo"));
						node_1.add(new DefaultMutableTreeNode("Tacchino"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Ortaggi");
						node_1.add(new DefaultMutableTreeNode("Zucchine"));
						node_1.add(new DefaultMutableTreeNode("Pomodori"));
						node_1.add(new DefaultMutableTreeNode("Melanzane"));
						node_1.add(new DefaultMutableTreeNode("Sedano"));
					add(node_1);
				}
			}
		));
		
		
		
		tree.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), null));
		frame.getContentPane().add(tree, BorderLayout.WEST);
		
		JList list = new JList();
		frame.getContentPane().add(list, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenu mnSottoFile = new JMenu("sotto file");
		mnSottoFile.setIcon(new ImageIcon(windowsFist.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		mnFile.add(mnSottoFile);
		
		JMenuItem mntmKjdsnf = new JMenuItem("kjdsnf");
		mntmKjdsnf.setAction(action);
		mnSottoFile.add(mntmKjdsnf);
		
		JMenu mnModifica = new JMenu("modifica");
		menuBar.add(mnModifica);
		
		JMenuItem mntmDsgfsdfg = new JMenuItem("boh");
		mnModifica.add(mntmDsgfsdfg);
		
		JMenu mnBeatATe = new JMenu("beat a te");
		menuBar.add(mnBeatATe);
		
		JCheckBoxMenuItem chckbxmntmSdfgs = new JCheckBoxMenuItem("a");
		mnBeatATe.add(chckbxmntmSdfgs);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public JTree getTree() {
		return tree;
	}
}
