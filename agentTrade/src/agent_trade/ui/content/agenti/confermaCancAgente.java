package agent_trade.ui.content.agenti;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.util.Costanti;

public class confermaCancAgente extends JDialog{
	
/*attributi di classe*/
	
	//private static final long serialVersionUID = 1L;
	
	private static confermaCancAgente instance;	

	
	/*attributi privati*/

	private JPanel contentPane;
	private JPanel panelloBottoni;
	
	private JLabel LabelTesto;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private String agente = null; //per tenere traccia dell'agente
	
	/*costruttori*/

	public confermaCancAgente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CANCELLA_AGENTE);
		setBounds(350, 200, 340, 151);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 334, 65);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		LabelTesto = new JLabel(Costanti.MESSAGGIO_CANCELLA_AGENTE);
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
					Ctrl_gestisciAgente.getInstance().postConfermaCancAgente(agente);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciAgente.getInstance().notConfermaCancAgente();
			}
		});
		 
	}
	
	/*metodi di classe*/
	
	public static confermaCancAgente getInstance(){
		if (instance==null)
			instance = new confermaCancAgente();
		return instance;	 
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public static void cancInst(){
		instance=null;	 
	}
	
	public String getAgente(){
		return agente;
	}
	
	public void setAgente(String id){
		 agente=id;
	}

}
