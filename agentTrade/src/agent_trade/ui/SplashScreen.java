package agent_trade.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import agent_trade.util.Costanti;

public class SplashScreen extends JWindow {

	/*attributi di classe*/
	
	 private static final int WIDTH = 450;
	 private static final int HEIGHT = 250;
	
	/*attributi privati*/

	/*costruttori*/
	 
	 public SplashScreen() {

	        JPanel content = (JPanel)getContentPane();
	        
	        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	        int x = (screen.width-WIDTH)/2;
	        int y = (screen.height-HEIGHT)/2;
	        setBounds(x,y,WIDTH,HEIGHT);
	        
	        JPanel panel = new JPanel();
	        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	        content.add(panel, BorderLayout.CENTER);
	        panel.setLayout(new BorderLayout(0, 0));
	        JLabel label = new JLabel(new ImageIcon(SplashScreen.class.getResource(Costanti.SPLASH_AGENTTRADE)));
	        panel.add(label, BorderLayout.CENTER);
	        JLabel copyrt = new JLabel(Costanti.MESSAGGIO_COPYRIGHT, JLabel.CENTER);
	        panel.add(copyrt, BorderLayout.SOUTH);
	        
	        setOpacity(0.9f);
	 }
	 
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/
	
	 

	
}
