package agent_trade.ui.content.aziende;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciAzienda;
import agent_trade.util.Costanti;

public class confermaCancAzienda extends JDialog {

	/*attributi di classe*/
	
	private static confermaCancAzienda instance;
	
	/*attributi privati*/

	private JPanel contentPane;
	private JPanel panelloBottoni;
	
	private JLabel LabelTesto;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private String azienda = null;
	
	/*costruttori*/
	
	public confermaCancAzienda(){
		
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		setTitle(Costanti.TITOLO_CANCELLA_AZIENDA);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-Costanti.WIDTH_LOGIN)/2;
        int y = (screen.height-Costanti.HEIGHT_LOGIN)/2;
		setBounds(x, y, 340, 151);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 334, 65);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		LabelTesto = new JLabel(Costanti.MESSAGGIO_CANCELLA_AZIENDA);
		LabelTesto.setBounds(43, 11, 241, 40);
		contentPane.add(LabelTesto);
		
		panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 65, 334, 53);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		okButton = new JButton(Costanti.BOTTONE_CONFERMA);
		okButton.setBounds(91, 11, 62, 23);
		panelloBottoni.add(okButton);
		
		cancelButton = new JButton(Costanti.BOTTONE_ANNULLA);
		cancelButton.setBounds(175, 11, 82, 23);
		panelloBottoni.add(cancelButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciAzienda.getInstance().postConfermaCancAzienda(azienda);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciAzienda.getInstance().notConfermaCancAzienda();
			}
		});
	}
	
	/*metodi di classe*/
	
	public static confermaCancAzienda getInstance(){
		if (instance==null)
			instance = new confermaCancAzienda();
		return instance;	 
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public static void cancInst(){
		instance=null;	 
	}
	
	public String getAzienda(){
		return azienda;
	}
	
	public void setAzienda(String id){
		 azienda = id;
	}
	
}
