package agent_trade.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import agent_trade.controller.Ctrl_System;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static LoginView instance;
	private JTextField username;
	private JLabel mex;
	
	public JTextField getUsername() {
		return username;
	}
	public void setUsername(String user) {
		username.setText(user);
	}
	public void setMex(String m){
		mex.setText(m);
	}
	private JTextField password; //DA SISTEMARE. FATTO SOLO PER PROVA


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Login frame = new Login();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("Agent Trade | Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Username");
		label.setBounds(35, 47, 74, 37);
		layeredPane.add(label);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(161, 55, 130, 20);
		layeredPane.add(username);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(35, 99, 74, 14);
		layeredPane.add(label_1);
		
		password = new JTextField();
		password.setBounds(161, 96, 130, 20);
		layeredPane.add(password);
		
		JButton button = new JButton("Accedi");
		button.setBounds(201, 136, 89, 23);
		layeredPane.add(button);
		
		JLabel label_2 = new JLabel("Inserisci le tue credenziali per accedere ad Agent Trade");
		label_2.setBounds(10, 11, 334, 20);
		layeredPane.add(label_2);
		
		mex = DefaultComponentFactory.getInstance().createLabel("");
		mex.setBounds(35, 140, 156, 14);
		layeredPane.add(mex);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String user=(String)username.getText();
				//String psw=(String)password.getText();
				Ctrl_System.getInstance().login((String)username.getText(), (String)password.getText());
				//username.setText("recuperato-"+(String)username.getText());
				//password.setText("recuperato-"+(String)password.getText());

				
				
				/*
				if((user.equals("antonio"))||true)	{			
					//if (true){
					//new windowsFist();
					//frmAgentTrade.setVisible(false);
					PrimaryView.getInstance().setVisible(true);
					LoginView.getInstance().setVisible(false);

					}
				else
				{
					username.setText("");
				 //	password.setPassword("");
				}*/
			}

		});
		
	}
	public static LoginView getInstance(){
		if(instance == null)
			instance = new LoginView();
		
		return instance;
	}
}