package agent_trade.ui.content.clienti;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;

import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.util.Costanti;

import org.orm.PersistentException;

public class confermaCancCliente extends JDialog {
	
	/*attributi di classe*/
	
	//private static final long serialVersionUID = 1L;
	
	private static confermaCancCliente instance;	

	
	/*attributi privati*/

	private JPanel contentPane;
	private JPanel panelloBottoni;
	
	private JLabel LabelTesto;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private String cliente = null; //per tenere traccia del cliente
	
	/*costruttori*/

	public confermaCancCliente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CANCELLA_CLIENTE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-Costanti.WIDTH_LOGIN)/2;
        int y = (screen.height-Costanti.HEIGHT_LOGIN)/2;
		setBounds(x, y, 340, 151);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 334, 65);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		LabelTesto = new JLabel(Costanti.MESSAGGIO_CANCELLA_CLIENTE);
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
					Ctrl_gestisciClienteFactory.getInstance().postConfermaCancCliente(cliente);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciClienteFactory.getInstance().notConfermaCancCliente();
			}
		});
		 
	}
	
	/*metodi di classe*/
	
	public static confermaCancCliente getInstance(){
		if (instance==null)
			instance = new confermaCancCliente();
		return instance;	 
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public static void cancInst(){
		instance=null;	 
	}
	
	public String getCliente(){
		return cliente;
	}
	
	public void setCliente(String id){
		 cliente=id;
	}
	
}
