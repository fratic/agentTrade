package agent_trade.ui.login;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import agent_trade.controller.Ctrl_System;
import agent_trade.util.Costanti;

public class LoginViewFactoryMethod extends JFrame {

	/*attributi di classe*/
	
	/**
	 * 
	 */

	protected static LoginViewFactoryMethod instance;

	
	/*attributi privati*/


	/*attributi protected*/

	protected JPanel contentPane;
	protected JLayeredPane layeredPane;
	
	protected JTextField username;
	protected JPasswordField password; 
	
	protected JLabel mex;
	protected JLabel labelUser;
	protected JLabel labelPass;
	protected JLabel labelInfo;

	protected JButton buttoneAccedi;
	
	protected JButton buttoneSetting;

	/*costruttori*/
	
	public LoginViewFactoryMethod() {
		
	}


	/*metodi di classe*/

	//questo è il nostro FactoryMethod
	public static LoginViewFactoryMethod getInstance(){
		
		if(instance == null){
			if(Costanti.version.equals(Costanti.agente))
				instance = LoginAgenteView.getInstance();
			else if(Costanti.version.equals(Costanti.mandante))
				instance = LoginMandanteView.getInstance();
		}
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
	
	public void disableAccedi(){
		buttoneAccedi.setEnabled(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	}
	
	public void enableAccedi(){
		buttoneAccedi.setEnabled(true);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
	
	public void destroyInstanceLogin(){
		instance=null;
	}
}
