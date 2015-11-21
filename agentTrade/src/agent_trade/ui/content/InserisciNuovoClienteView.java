package agent_trade.ui.content;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.ui.PrimaryView;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.GridLayout;

public class InserisciNuovoClienteView extends JPanel {
	
	private JPanel pannelloFormCliente;
	
	
	private JLabel labelNome;
	private JLabel labelCognome;
	private JLabel labelIndirizzo;
	private JLabel labelCodiceFiscale;
	private JLabel labelPartitaIva;
	private JLabel labelEmail;
	private JLabel labelTelefono;
	private JLabel labelFax;
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
	
	private static InserisciNuovoClienteView instance;
	

	public InserisciNuovoClienteView() {
		
		
		setLayout(null);
		
		
		pannelloFormCliente = new JPanel();
		pannelloFormCliente.setBounds(6, 16, 554, 374);
		pannelloFormCliente.setLayout(null);
		add(pannelloFormCliente);
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuovo Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		
		 labelNome = DefaultComponentFactory.getInstance().createLabel("Nome: ");
		 labelNome.setBounds(27, 31, 69, 14);
		 pannelloFormCliente.add(labelNome);
		 
		 TFnome = new JTextField();
		 TFnome.setBounds(145, 25, 118, 20);
		 pannelloFormCliente.add(TFnome);
		 TFnome.setColumns(10);
		 
		 labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome: ");
		 labelCognome.setBounds(27, 72, 69, 14);
		 pannelloFormCliente.add(labelCognome);
		 
		 TFcognome = new JTextField();
		 TFcognome.setBounds(145, 69, 118, 20);
		 pannelloFormCliente.add(TFcognome);
		 TFcognome.setColumns(10);
		 
		 labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale: ");
		 labelCodiceFiscale.setBounds(26, 112, 69, 14);
		 pannelloFormCliente.add(labelCodiceFiscale);
		 
		 TFcodicefiscale = new JTextField();
		 TFcodicefiscale.setBounds(145, 109, 118, 20);
		 pannelloFormCliente.add(TFcodicefiscale);
		 TFcodicefiscale.setColumns(10);
		 
		 labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("PartitaIva: ");
		 labelPartitaIva.setBounds(319, 115, 69, 14);
		 pannelloFormCliente.add(labelPartitaIva);
		 
		 TFpartitaiva = new JTextField();
		 TFpartitaiva.setBounds(393, 109, 118, 20);
		 pannelloFormCliente.add(TFpartitaiva);
		 TFpartitaiva.setColumns(10);
		 
		 labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo: ");
		 labelIndirizzo.setBounds(321, 72, 69, 14);
		 pannelloFormCliente.add(labelIndirizzo);
		 
		 TFindirizzo = new JTextField();
		 TFindirizzo.setBounds(393, 69, 118, 20);
		 pannelloFormCliente.add(TFindirizzo);
		 TFindirizzo.setColumns(10);
		 
		 labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		 labelEmail.setBounds(27, 154, 69, 14);
		 pannelloFormCliente.add(labelEmail);
		 
		 TFemail = new JTextField();
		 TFemail.setBounds(145, 151, 118, 20);
		 pannelloFormCliente.add(TFemail);
		 TFemail.setColumns(10);
		 
		 labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		 labelTelefono.setBounds(27, 200, 69, 14);
		 pannelloFormCliente.add(labelTelefono);
		 
		 TFtelefono = new JTextField();
		 TFtelefono.setBounds(145, 197, 118, 20);
		 pannelloFormCliente.add(TFtelefono);
		 TFtelefono.setColumns(10);
		 
		 labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		 labelFax.setBounds(319, 200, 69, 14);
		 pannelloFormCliente.add(labelFax);
		 
		 TFfax = new JTextField();
		 TFfax.setBounds(393, 197, 118, 20);
		 pannelloFormCliente.add(TFfax);
		 TFfax.setColumns(10);
		 
		 JSeparator separator = new JSeparator();
		 separator.setBounds(0, 257, 735, 7);
		 pannelloFormCliente.add(separator);
		
		
		
		bottoneSalvaCliente = new JButton("Salva");
		bottoneSalvaCliente.setBounds(28, 305, 113, 30);
		pannelloFormCliente.add(bottoneSalvaCliente);
		bottoneSalvaCliente.setToolTipText("Salva il cliente");
		bottoneSalvaCliente.setIcon(new ImageIcon(InserisciNuovoClienteView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		
		bottoneAnnullaInserimento = new JButton("Annulla");
		bottoneAnnullaInserimento.setBounds(199, 305, 113, 30);
		pannelloFormCliente.add(bottoneAnnullaInserimento);
		bottoneAnnullaInserimento.setToolTipText("Pulisci form");
		bottoneAnnullaInserimento.setIcon(new ImageIcon(InserisciNuovoClienteView.class.getResource("/agent_trade/ui/img/close_icon.png")));
		
		
		
		
		//bottoneAnnullaInserimento.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {
			//Ctrl_gestisciCliente.getInstance().annullaInserimentoCliente();
			
			//}
		
		}
	
	
	public static InserisciNuovoClienteView getInstance(){
		if (instance==null)
			instance = new InserisciNuovoClienteView();
		return instance;	 
	}
}
