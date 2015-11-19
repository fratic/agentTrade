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

public class InserisciNuovoClienteView extends JPanel {
	
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
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuovo Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		
		 labelNome = DefaultComponentFactory.getInstance().createLabel("Nome: ");
		 labelNome.setBounds(75, 84, 69, 14);
		 add(labelNome);
		 
		 TFnome = new JTextField();
		 TFnome.setBounds(154, 81, 118, 20);
		 add(TFnome);
		 TFnome.setColumns(10);
		 
		 labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome: ");
		 labelCognome.setBounds(75, 50, 69, 14);
		 add(labelCognome);
		 
		 TFcognome = new JTextField();
		 TFcognome.setBounds(154, 47, 118, 20);
		 add(TFcognome);
		 TFcognome.setColumns(10);
		 
		 labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale: ");
		 labelCodiceFiscale.setBounds(75, 154, 69, 14);
		 add(labelCodiceFiscale);
		 
		 TFcodicefiscale = new JTextField();
		 TFcodicefiscale.setBounds(154, 151, 118, 20);
		 add(TFcodicefiscale);
		 TFcodicefiscale.setColumns(10);
		 
		 labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("PartitaIva: ");
		 labelPartitaIva.setBounds(75, 195, 69, 14);
		 add(labelPartitaIva);
		 
		 TFpartitaiva = new JTextField();
		 TFpartitaiva.setBounds(154, 192, 118, 20);
		 add(TFpartitaiva);
		 TFpartitaiva.setColumns(10);
		 
		 labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo: ");
		 labelIndirizzo.setBounds(75, 119, 69, 14);
		 add(labelIndirizzo);
		 
		 TFindirizzo = new JTextField();
		 TFindirizzo.setBounds(154, 116, 118, 20);
		 add(TFindirizzo);
		 TFindirizzo.setColumns(10);
		 
		 labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		 labelEmail.setBounds(75, 279, 69, 14);
		 add(labelEmail);
		 
		 TFemail = new JTextField();
		 TFemail.setBounds(154, 276, 118, 20);
		 add(TFemail);
		 TFemail.setColumns(10);
		 
		 labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		 labelTelefono.setBounds(75, 236, 69, 14);
		 add(labelTelefono);
		 
		 TFtelefono = new JTextField();
		 TFtelefono.setBounds(154, 233, 118, 20);
		 add(TFtelefono);
		 TFtelefono.setColumns(10);
		 
		 labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		 labelFax.setBounds(338, 236, 69, 14);
		 add(labelFax);
		 
		 TFfax = new JTextField();
		 TFfax.setBounds(386, 233, 118, 20);
		 add(TFfax);
		 TFfax.setColumns(10);
		 
		 
		 
		bottoneSalvaCliente = new JButton("Salva");
		bottoneSalvaCliente.setToolTipText("Salvataggio in corso");
		bottoneSalvaCliente.setIcon(new ImageIcon(InserisciNuovoClienteView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		bottoneSalvaCliente.setBounds(75, 337, 113, 30);
		add(bottoneSalvaCliente);
		 
		bottoneAnnullaInserimento = new JButton("Annulla");
		//bottoneAnnullaInserimento.setToolTipText("Annullamento in corso");
		bottoneAnnullaInserimento.setIcon(new ImageIcon(InserisciNuovoClienteView.class.getResource("/agent_trade/ui/img/close_icon.png")));
		bottoneAnnullaInserimento.setBounds(233, 337, 113, 30);
		add(bottoneAnnullaInserimento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 304, 735, 7);
		add(separator);
		
		
		
		
		/*bottoneAnnullaInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Ctrl_gestisciCliente.getInstance().annullaInserimentoCliente();
			}*/
		
		
	}
	
	
	public static InserisciNuovoClienteView getInstance(){
		if (instance==null)
			instance = new InserisciNuovoClienteView();
		return instance;	 
	}
}
