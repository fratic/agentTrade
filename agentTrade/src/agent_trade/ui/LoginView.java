package agent_trade.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_System;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LoginView extends JFrame {

	/*attributi di classe*/
	
	private static LoginView instance;

	
	/*attributi privati*/

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	private JTextField username;
	private JPasswordField password; 
	
	private JLabel mex;
	private JLabel labelUser;
	private JLabel labelPass;
	private JLabel labelInfo;

	private JButton buttoneAccedi;
	
	/*costruttori*/
	
	private LoginView() {
		
		setResizable(false);
		
		ImageIcon img = new ImageIcon(SplashScreen.class.getResource(Costanti.AGENTTRADE_ICON));
		this.setIconImage(img.getImage());


		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-Costanti.WIDTH_LOGIN)/2;
        int y = (screen.height-Costanti.HEIGHT_LOGIN)/2;
        setBounds(x,y,Costanti.WIDTH_LOGIN,Costanti.HEIGHT_LOGIN);
        
		setTitle(Costanti.TITOLO_LOGIN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		labelUser = new JLabel(Costanti.LABEL_USERNAME);
		labelUser.setBounds(35, 47, 74, 37);
		layeredPane.add(labelUser);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(161, 55, 130, 20);
		layeredPane.add(username);
		
		labelPass = new JLabel(Costanti.LABEL_PASSWORD);
		labelPass.setBounds(35, 99, 74, 14);
		layeredPane.add(labelPass);
		
		password = new JPasswordField();
		password.setBounds(161, 96, 130, 20);
		layeredPane.add(password);
		
		buttoneAccedi = new JButton(Costanti.BOTTONE_ACCEDI);
		buttoneAccedi.setBounds(201, 136, 89, 23);
		layeredPane.add(buttoneAccedi);
		
		labelInfo = new JLabel(Costanti.MESSAGGIO_INSERISCI_CREDENZIALI);
		labelInfo.setBounds(10, 11, 334, 20);
		layeredPane.add(labelInfo);
		
		mex = DefaultComponentFactory.getInstance().createLabel("");
		mex.setBounds(35, 140, 156, 14);
		layeredPane.add(mex);
		
		buttoneAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_System.getInstance().login((String)username.getText(), (String)password.getText());
			}
		});	
	}


	/*metodi di classe*/
	
	public static LoginView getInstance(){
		if(instance == null)
			instance = new LoginView();
		
		return instance;
	}

	/*metodi privati*/
	/*metodi pubblici*/
	
	public JTextField getUsername() {
		return username;
	}
	public void setUsername(String user) {
		username.setText(user);
	}
	public void setMex(String m){
		mex.setText(m);
	}
}
