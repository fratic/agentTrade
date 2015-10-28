package agent_trade;

import javax.swing.SwingUtilities;

import agent_trade.ui.SplashScreen;
import agent_trade.ui.login;

public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			
				
				login window = new login();
				window.frmAgentTrade.setVisible(true);
				splash.setVisible(false);
			}
		});
	}
}