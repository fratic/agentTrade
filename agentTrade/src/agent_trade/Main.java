package agent_trade;

import java.text.ParseException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import agent_trade.controller.Ctrl_System;
import agent_trade.ui.SplashScreen;
import agent_trade.ui.login.LoginViewFactoryMethod;
import agent_trade.util.Costanti;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
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
					setLook();
					setVersione();
				    LoginViewFactoryMethod.getInstance().setVisible(true);
					splash.dispose();
					
			    } 
				catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
	
	
	
	public static void setLook() throws UnsupportedLookAndFeelException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Ctrl_System.readLook();						

		switch (Costanti.Look_Feel) {
		
			case 0:{
				break;
			}
		
			case 1:{
				UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
				break;
			}
			case 2:{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;
			}
			case 3:{
			    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
				break;
			}
			case 4:{
			    UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
				break;
			}
			case 5:{
			    UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
				break;
			}
			case 6:{
				UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
				break;
			}

		}
		
	}
	
	
	public static void setVersione(){
		
		Ctrl_System.readVersion();						

	}
	
	
}