package agent_trade.ui.content.prodotti.riepilogo;

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

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Prodotto;
import agent_trade.util.Costanti;

public class confermaCancProdotto extends JDialog{

/*attributi di classe*/
	
	//private static final long serialVersionUID = 1L;
	
	private static confermaCancProdotto instance;	

	
	/*attributi privati*/

	private JPanel contentPane;
	private JPanel panelloBottoni;
	
	private JLabel LabelTesto;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private M_Prodotto prodotto = null; 
	
	/*costruttori*/

	public confermaCancProdotto() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CANCELLA_PRODOTTO);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-Costanti.WIDTH_LOGIN)/2;
        int y = (screen.height-Costanti.HEIGHT_LOGIN)/2;
		setBounds(x, y, 340, 151);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 334, 65);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		LabelTesto = new JLabel(Costanti.MESSAGGIO_CANCELLA_PRODOTTO);
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
					Ctrl_gestisciListino.getInstance().postConfermaCancProdotto(prodotto);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciListino.getInstance().notConfermaCancProdotto();
			}
		});
		 
	}
	
	/*metodi di classe*/
	
	public static confermaCancProdotto getInstance(){
		if (instance == null)
			instance = new confermaCancProdotto();
		return instance;	 
	}
	
	
	public static void cancInst(){
		instance = null;	 
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public M_Prodotto getProdotto(){
		return prodotto;
	}
	
	public void setProdotto(M_Prodotto prod){
		prodotto = prod;
	}
}
