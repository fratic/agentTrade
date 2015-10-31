package agent_trade;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
				
				try {
					Thread.sleep(1500);
					LoginView.getInstance().setVisible(true);
				    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					/*LoginView window = new LoginView();
					window.setVisible(true);*/
					splash.setVisible(false);

				//} catch (InterruptedException | ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			      } catch (InterruptedException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//qui bisogna caricare gli oggetti di cui abbiamo bisogno, naturalmente con criterio 
	}
}