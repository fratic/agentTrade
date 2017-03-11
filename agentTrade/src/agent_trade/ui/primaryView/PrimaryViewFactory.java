package agent_trade.ui.primaryView;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import agent_trade.ui.SplashScreen;
import agent_trade.util.Costanti;

public class PrimaryViewFactory extends JFrame 
{
	
	/*attributi di classe*/
	
	protected static PrimaryViewFactory instance;	

	
	/*attributi privati*/
	
	protected JTabbedPane tabbedPrincipale;
	
	
	/*costruttori*/
	
	protected PrimaryViewFactory(String titolo) {
		
		super(titolo);
		
		this.initComponents();

		
	}
	
	
	/*metodi di classe*/
	
	public static PrimaryViewFactory getInstance(){
		if(instance == null){
			if(Costanti.version.equals(Costanti.agente))
				instance = PrimaryAgenteView.getInstance();
			else if(Costanti.version.equals(Costanti.mandante))
				instance = PrimaryMandanteView.getInstance();
		}
		
		return instance;	 
	}
	
	
	
		
	/*metodi privati*/
	
	
	private void askClosure() {
	        int choice = JOptionPane.showConfirmDialog(this,
	                Costanti.MESSAGGIO_CLOSE_APP,
	                Costanti.TITOLO_DIALOG_CLOSE, 
	                JOptionPane.YES_NO_OPTION);
	        if (choice == JOptionPane.YES_OPTION) {
	            System.exit(0);
	        }
	    }
	
	
	/*metodi pubblici*/
	
	
	public void initComponents()
	{
		ImageIcon img = new ImageIcon(SplashScreen.class.getResource(Costanti.AGENTTRADE_ICON));

		this.setIconImage(img.getImage());

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                askClosure();
            }
        });
		

        
		getContentPane().setLayout(new GridLayout(1, 1));
		tabbedPrincipale = new JTabbedPane(JTabbedPane.TOP);

		getContentPane().add(tabbedPrincipale);
		
		this.setBounds(150,50,Costanti.WIDTH_PRIMARY,Costanti.HEIGHT_PRIMARY);
		this.setMinimumSize(new Dimension(Costanti.MIN_WIDTH_PRIMARY, Costanti.MIN_HEIGHT_PRIMARY));

	}
	
	
}
