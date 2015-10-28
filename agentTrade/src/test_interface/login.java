package test_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import javax.swing.Box;
import java.awt.Component;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class login {

	private JFrame frmAgentTrade;
	private JTextField textField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgentTrade = new JFrame();
		frmAgentTrade.setTitle("Agent Trade | Login ");
		frmAgentTrade.setForeground(Color.WHITE);
		frmAgentTrade.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		frmAgentTrade.setAlwaysOnTop(true);
		frmAgentTrade.setBackground(Color.WHITE);
		frmAgentTrade.setBounds(100, 100, 304, 200);
		frmAgentTrade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgentTrade.getContentPane().setLayout(new BoxLayout(frmAgentTrade.getContentPane(), BoxLayout.X_AXIS));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		frmAgentTrade.getContentPane().add(layeredPane);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(35, 47, 59, 37);
		layeredPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(119, 55, 130, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 99, 46, 14);
		layeredPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 96, 130, 20);
		layeredPane.add(passwordField);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new windowsFist();

			}
		});
		btnAccedi.setAction(action);
		btnAccedi.setBounds(160, 127, 89, 23);
		layeredPane.add(btnAccedi);
		
		JLabel lblInserisciLeTue = new JLabel("Inserisci le tue credenziali per accedere ad Agent Trade");
		lblInserisciLeTue.setBounds(10, 11, 284, 14);
		layeredPane.add(lblInserisciLeTue);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Accedi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
