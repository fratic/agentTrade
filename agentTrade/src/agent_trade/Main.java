package agent_trade;

import javax.swing.SwingUtilities;

import agent_trade.ui.Login;
import agent_trade.ui.SplashScreen;
import agent_trade.ui.LoginView;

public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			

				//Login.getInstance().setVisible(true);
				LoginView window = new LoginView();
				window.frmAgentTrade.setVisible(true);
				splash.setVisible(false);
			}
		});
		//qui bisogna caricare gli oggetti di cui abbiamo bisogno, naturalmente con criterio 
	}
}