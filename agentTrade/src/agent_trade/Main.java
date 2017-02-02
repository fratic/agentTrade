package agent_trade;

import java.text.ParseException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import agent_trade.ui.LoginView;
import agent_trade.ui.SplashScreen;

/****NON TOCCARE***/
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;


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

				    LoginView.getInstance().setVisible(true);
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