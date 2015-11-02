package agent_trade;

import javax.swing.SwingUtilities;

import agent_trade.ui.SplashScreen;
import agent_trade.ui.LoginView;

public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
								
				try {
					Thread.sleep(1500);
					LoginView.getInstance().setVisible(true);
				    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					splash.setVisible(false);

			    } 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		//qui bisogna caricare gli oggetti di cui abbiamo bisogno, naturalmente con criterio 
	}
}