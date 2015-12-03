package agent_trade.ui.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciCliente;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DropMode;

public class DettaglioClienteView extends JPanel {

	/*attributi di classe*/
	
	private static DettaglioClienteView instance;
	
	/*attributi privati*/
	
	private JLabel labelNome;
	private JLabel labelCognome;
	private JLabel labelIndirizzo;
	private JLabel labelCodiceFiscale;
	private JLabel labelPartitaIva;
	private JLabel labelEmail;
	private JLabel labelTelefono;
	private JLabel labelFax;
	private JLabel labelErrore;
	
	private JTextField TFnome;
	private JTextField TFcognome;
	private JTextField TFindirizzo;
	private JTextField TFcodicefiscale;
	private JTextField TFpartitaiva;
	private JTextField TFemail;
	private JTextField TFtelefono;
	private JTextField TFfax;
	
	private JButton bottoneSalvaCliente;
	private JButton bottoneAnnullaInserimento;
	
	/*costruttori*/
	
	public DettaglioClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuova scheda cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		
		setLayout(null);
		
		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome: ");
		labelNome.setBounds(43, 47, 69, 14);
		add(labelNome);
		 
		TFnome = new JTextField();
		TFnome.setBounds(178, 44, 261, 20);
		add(TFnome);
		 TFnome.setColumns(10);
		 
		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome: ");
		labelCognome.setBounds(43, 90, 69, 14);
		add(labelCognome);
		 
		TFcognome = new JTextField();
		TFcognome.setBounds(178, 87, 261, 20);
		add(TFcognome);
		TFcognome.setColumns(10);
		 
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale: ");
		labelCodiceFiscale.setBounds(43, 133, 111, 14);
		add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setBounds(178, 130, 261, 20);
		add(TFcodicefiscale);
		TFcodicefiscale.setColumns(10);
		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("Partita Iva: ");
		labelPartitaIva.setBounds(43, 176, 69, 14);
		add(labelPartitaIva);
		 
		TFpartitaiva = new JTextField();
		TFpartitaiva.setBounds(178, 173, 261, 20);
		add(TFpartitaiva);
		TFpartitaiva.setColumns(10);
		 
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo: ");
		labelIndirizzo.setBounds(44, 219, 69, 14);
		add(labelIndirizzo);
		 
		TFindirizzo = new JTextField();
		TFindirizzo.setBounds(178, 216, 261, 20);
		add(TFindirizzo);
		TFindirizzo.setColumns(10);
		 
		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		labelEmail.setBounds(43, 262, 69, 14);
		add(labelEmail);
		 
		TFemail = new JTextField();
		TFemail.setBounds(178, 259, 261, 20);
		add(TFemail);
		TFemail.setColumns(10);
		 
		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		labelTelefono.setBounds(43, 305, 69, 14);
		add(labelTelefono);
		 
		TFtelefono = new JTextField();
		TFtelefono.setBounds(178, 302, 261, 20);
		add(TFtelefono);
		TFtelefono.setColumns(10);
		 
		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		labelFax.setBounds(43, 348, 69, 14);
		add(labelFax);
		 
		TFfax = new JTextField();
		TFfax.setBounds(178, 345, 261, 20);
		add(TFfax);
		TFfax.setColumns(10);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setBounds(43, 376, 219, 20);
		add(labelErrore);
		
		bottoneSalvaCliente = new JButton("Salva");
		bottoneSalvaCliente.setBounds(41, 418, 113, 30);
		add(bottoneSalvaCliente);
		bottoneSalvaCliente.setToolTipText("Salva il cliente");
		bottoneSalvaCliente.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save-user.png")));
		
		bottoneAnnullaInserimento = new JButton("Annulla");
		bottoneAnnullaInserimento.setBounds(206, 418, 113, 30);
		add(bottoneAnnullaInserimento);
		bottoneAnnullaInserimento.setToolTipText("Pulisci form");
		bottoneAnnullaInserimento.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/close_icon.png")));
		
		bottoneSalvaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().inserisciNuovoCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFfax.getText());
			}	
		});
		
		bottoneAnnullaInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().annullaNewCliente();
			}
		});
		
	}
		
	/*metodi di classe*/
		
	public static DettaglioClienteView getInstance(){
		if (instance==null)
			instance = new DettaglioClienteView();
		return instance;	 
		}
	
	public void setErrore(String err) {
		labelErrore.setText(err);
    }
	
	public void setVisibleErroreNuovoCliente(boolean b){
		labelErrore.setVisible(b);
	}
		
	public void resetNewCliente(){
		TFcognome.setText(null);
		TFnome.setText(null);
		TFcodicefiscale.setText(null);
		TFpartitaiva.setText(null);
		TFindirizzo.setText(null);
		TFemail.setText(null);
		TFtelefono.setText(null);
		TFfax.setText(null);
	}
		
	/*metodi privati*/
	/*metodi pubblici*/

	
	
}