package agent_trade.ui.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciCliente;

public class DettaglioCercaCliente extends JPanel {

	/*attributi di classe*/
	
	private static DettaglioCercaCliente instance;
	
	/*attributi privati*/
	
	private JLabel labelCercaCliente;
	private JLabel labelError;
	
	private JTextField TFcerca;
	private JButton bottoneCerca;
	
	/*costruttori*/
	
	public DettaglioCercaCliente() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cerca Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		
		setLayout(null);
		
		labelCercaCliente = new JLabel("Inserisci il nome del cliente: ");
		labelCercaCliente.setBounds(22, 32, 145, 40);
		add(labelCercaCliente);
		
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setBounds(10, 67, 219, 20);
		add(labelError);
		
		TFcerca = new JTextField();
		TFcerca.setBounds(165, 42, 219, 20);
		add(TFcerca);
		
		bottoneCerca = new JButton();
		bottoneCerca.setBounds(412, 21, 83, 51);
		add(bottoneCerca);
		bottoneCerca.setToolTipText("Cerca");
		bottoneCerca.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/search-icon.png")));
		
		bottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ctrl_gestisciCliente.getInstance().function();
				
			}
			
		});

	}
	
	/*metodi di classe*/
	
	public static DettaglioCercaCliente getInstance(){
		if (instance==null)
			instance = new DettaglioCercaCliente();
		return instance;	 
		}
	
	public void setErrore(String err) {
		labelError.setText(err);
    }
	
	//public void setDettaglio()      da finire!
	
	/*metodi privati*/
	/*metodi pubblici*/

	//qui metteremo i metodi set e get per recupero, salvataggio, modifice ecc

}