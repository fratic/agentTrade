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

public class windowsFist {

	private JFrame frame;

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
		
		Label label = new Label("New label");
		frame.getContentPane().add(label, BorderLayout.WEST);
		
		Checkbox checkbox = new Checkbox("New check box");
		frame.getContentPane().add(checkbox, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(checkbox, popupMenu);
		
		TextArea textArea = new TextArea();
		frame.getContentPane().add(textArea, BorderLayout.SOUTH);
		
		JTree tree = new JTree();
		frame.getContentPane().add(tree, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenu mnSottoFile = new JMenu("sotto file");
		mnFile.add(mnSottoFile);
		
		JMenuItem mntmKjdsnf = new JMenuItem("kjdsnf");
		mnSottoFile.add(mntmKjdsnf);
		
		JMenu mnModifica = new JMenu("modifica");
		menuBar.add(mnModifica);
		
		JMenuItem mntmDsgfsdfg = new JMenuItem("dsgfsdfg");
		mnModifica.add(mntmDsgfsdfg);
		
		JMenu mnBeatATe = new JMenu("beat a te");
		menuBar.add(mnBeatATe);
		
		JCheckBoxMenuItem chckbxmntmSdfgs = new JCheckBoxMenuItem("sdfgs");
		mnBeatATe.add(chckbxmntmSdfgs);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
