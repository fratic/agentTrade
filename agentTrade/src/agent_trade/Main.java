package agent_trade;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import agent_trade.ui.LoginView;
import agent_trade.ui.SplashScreen;

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
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					splash.setVisible(false);

			    } 
				catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}