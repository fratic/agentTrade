package agent_trade.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JLabel;


import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frmAgentTrade;
	private JTextField username;
	private JPasswordField password;
	private final Action action = new SwingAction();
	private static LoginView instance;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
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
		frmAgentTrade.setBounds(100, 100, 360, 220);
		frmAgentTrade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgentTrade.getContentPane().setLayout(new BoxLayout(frmAgentTrade.getContentPane(), BoxLayout.X_AXIS));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		frmAgentTrade.getContentPane().add(layeredPane);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(35, 47, 74, 37);
		layeredPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(161, 55, 130, 20);
		layeredPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 99, 74, 14);
		layeredPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(161, 96, 130, 20);
		layeredPane.add(password);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=(String)username.getText();
				//if((user.equals("antonio")))	{			
					if (true){
					new windowsFist();
					frmAgentTrade.setVisible(false);
					//LoginView.getInstance().setVisible(false);

					}
				else
				{
					username.setText("");
				 //	password.setPassword("");
				}
			}

		});
		btnAccedi.setAction(action);
		btnAccedi.setBounds(201, 136, 89, 23);
		layeredPane.add(btnAccedi);
		
		JLabel lblInserisciLeTue = new JLabel("Inserisci le tue credenziali per accedere ad Agent Trade");
		lblInserisciLeTue.setBounds(10, 11, 334, 20);
		layeredPane.add(lblInserisciLeTue);
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Accedi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public static LoginView getInstance(){
		if(instance == null)
			instance = new LoginView();
		
		return instance;
	}
}
