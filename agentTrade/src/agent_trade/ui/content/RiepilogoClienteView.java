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
import agent_trade.ui.PrimaryView;

public class RiepilogoClienteView extends JPanel {

	/*attributi di classe*/
	
	private static RiepilogoClienteView instance;
	
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
	
	private JButton bottoneModificaCliente;
	private JButton bottoneCancellaCliente;
	private JButton bottoneBackToRicerca;
	
	/*costruttori*/
	
	public RiepilogoClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Scheda Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		
		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome: ");
		labelNome.setBounds(43, 47, 69, 14);
		add(labelNome);
		 
		TFnome = new JTextField();
		TFnome.setEditable(false);
		TFnome.setBounds(178, 44, 261, 20);
		add(TFnome);
		 TFnome.setColumns(10);
		 
		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome: ");
		labelCognome.setBounds(43, 90, 69, 14);
		add(labelCognome);
		 
		TFcognome = new JTextField();
		TFcognome.setEditable(false);
		TFcognome.setBounds(178, 87, 261, 20);
		add(TFcognome);
		TFcognome.setColumns(10);
		 
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale: ");
		labelCodiceFiscale.setBounds(43, 169, 97, 14);
		add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setEditable(false);
		TFcodicefiscale.setBounds(178, 166, 261, 20);
		add(TFcodicefiscale);
		TFcodicefiscale.setColumns(10);
		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("PartitaIva: ");
		labelPartitaIva.setBounds(44, 210, 69, 14);
		add(labelPartitaIva);
		 
		TFpartitaiva = new JTextField();
		TFpartitaiva.setEditable(false);
		TFpartitaiva.setBounds(178, 207, 261, 20);
		add(TFpartitaiva);
		TFpartitaiva.setColumns(10);
		 
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo: ");
		labelIndirizzo.setBounds(44, 131, 69, 14);
		add(labelIndirizzo);
		 
		TFindirizzo = new JTextField();
		TFindirizzo.setEditable(false);
		TFindirizzo.setBounds(178, 128, 261, 20);
		add(TFindirizzo);
		TFindirizzo.setColumns(10);
		 
		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		labelEmail.setBounds(44, 251, 69, 14);
		add(labelEmail);
		 
		TFemail = new JTextField();
		TFemail.setEditable(false);
		TFemail.setBounds(178, 248, 261, 20);
		add(TFemail);
		TFemail.setColumns(10);
		 
		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		labelTelefono.setBounds(44, 297, 69, 14);
		add(labelTelefono);
		 
		TFtelefono = new JTextField();
		TFtelefono.setEditable(false);
		TFtelefono.setBounds(178, 294, 261, 20);
		add(TFtelefono);
		TFtelefono.setColumns(10);
		 
		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		labelFax.setBounds(44, 342, 69, 14);
		add(labelFax);
		 
		TFfax = new JTextField();
		TFfax.setEditable(false);
		TFfax.setText("prova");
		TFfax.setBounds(177, 339, 262, 20);
		add(TFfax);
		TFfax.setColumns(10);
		
//		JSeparator separator = new JSeparator();
//		separator.setBounds(0, 384, 554, 8);
//		add(separator);
		
		bottoneModificaCliente = new JButton("Modifica");
		bottoneModificaCliente.setBounds(178, 403, 136, 30);
		add(bottoneModificaCliente);
		bottoneModificaCliente.setToolTipText("Modifica i dati del cliente");
		bottoneModificaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/setting.png")));
		
		bottoneCancellaCliente = new JButton("Cancella");
		bottoneCancellaCliente.setBounds(27, 403, 120, 30);
		add(bottoneCancellaCliente);
		bottoneCancellaCliente.setToolTipText("Cancella cliente");
		bottoneCancellaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/close_icon.png")));
		
		bottoneBackToRicerca = new JButton("Effettua una nuova ricerca");
		bottoneBackToRicerca.setBounds(345, 403, 207, 30);
		add(bottoneBackToRicerca);
		bottoneBackToRicerca.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/arrow_icon.png")));
		
		bottoneModificaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ctrl_gestisciCliente.getInstance().ModificaCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFfax.getText());
			}
		});
		
		bottoneCancellaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Ctrl_gestisciCliente.getInstance().CancellaCliente();
			}
		});
		
		bottoneBackToRicerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//PrimaryView.getInstance();
			}
		});
		
	}
		
		/*metodi di classe*/
		
		public static RiepilogoClienteView getInstance(){
			if (instance==null)
				instance = new RiepilogoClienteView();
			return instance;	 
			}
		
		/*metodi privati*/
		
		/*metodi pubblici*/
		
		public void setRiepilogoCliente(String nome, String cognome, String codice_fiscale, String partita_iva, String indirizzo, String email, String telefono, String fax ) {
			this.TFnome.setText(nome);
			this.TFcognome.setText(cognome);
			this.TFcodicefiscale.setText(codice_fiscale);
			this.TFpartitaiva.setText(partita_iva);
			this.TFindirizzo.setText(indirizzo);
			this.TFemail.setText(email);
			this.TFtelefono.setText(telefono);
			this.TFfax.setText(fax);	
		}
		
		
		
	
		
		

	}
		


