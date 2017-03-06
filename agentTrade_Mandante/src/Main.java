

import java.text.ParseException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ui.PrimaryView;
import ui.SplashScreen;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
/****NON TOCCARE***/


public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
								
				try {
					Thread.sleep(1500);
										
					/***non toccare***/
					/*******Per ora lasciare*********/
					
//					UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

//				    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
//	    		    UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
				    UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
//					UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
//					splash.setVisible(false);
					/****************/

				    PrimaryView.getInstance().setVisible(true);
					splash.dispose();
					
			    } 
				catch (InterruptedException e) {
					e.printStackTrace();
				} 
				catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				} 
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
	}
}