package agent_trade.ui.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_System;
import agent_trade.ui.SplashScreen;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.util.Costanti;

public class LoginAgenteView extends LoginViewFactoryMethod {

	/*attributi di classe*/
	

	
	/*attributi privati*/

	
	/*costruttori*/
	
	private LoginAgenteView() {
		
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
		buttoneAccedi.setBounds(201, 165, 89, 23);
		layeredPane.add(buttoneAccedi);
		

		buttoneSetting = new JButton();
		buttoneSetting.setIcon(new ImageIcon(PrimaryAgenteView.class.getResource(Costanti.SETTING_ICON)));
		buttoneSetting.setBounds(35, 160, 32, 32);
		layeredPane.add(buttoneSetting);

		
		labelInfo = new JLabel(Costanti.MESSAGGIO_INSERISCI_CREDENZIALI);
		labelInfo.setBounds(10, 11, 334, 20);
		layeredPane.add(labelInfo);
		
		mex = DefaultComponentFactory.getInstance().createLabel("");
		mex.setBounds(35, 135, 156, 14);
		layeredPane.add(mex);
				

		buttoneAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				disableAccedi();
				try {
					Ctrl_System.getInstance().loginAgente((String)username.getText(), (String)password.getText());
				}
				catch (PersistentException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});	
		
		
		buttoneSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Ctrl_System.getInstance().settingWindows();


			}
		});	
		
		
	}


	/*metodi di classe*/
	
	public static LoginViewFactoryMethod getInstance(){
		if(instance == null)
			instance = new LoginAgenteView();
		
		return instance;
	}

	/*metodi privati*/
	/*metodi pubblici*/
	
}