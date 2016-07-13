package agent_trade.ui.content.clienti;

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
import agent_trade.ui.PrimaryView;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;

public class DettaglioClienteView extends JPanel {

	/*attributi di classe*/
	
	private static DettaglioClienteView instance;
	
	/*attributi privati*/
	
	private JLabel labelIdCliente;
	private JLabel labelCognome;
	private JLabel labelNome;
	private JLabel labelCodiceFiscale;
	private JLabel labelPartitaIva;
	private JLabel labelCitta;
	private JLabel labelIndirizzo;
	private JLabel labelCAP;
	private JLabel labelEmail;
	private JLabel labelTelefono;
	private JLabel labelCell;
	private JLabel labelFax;
	private JLabel labelRifAgente;
	private JLabel labelErrore;
	
	//private JTextField TFidCliente;
	private JTextField TFcognome;
	private JTextField TFnome;
	private JTextField TFcodicefiscale;
	private JTextField TFpartitaiva;
	private JTextField TFcitta;
	private JTextField TFindirizzo;
	private JTextField TFcap;
	private JTextField TFemail;
	private JTextField TFtelefono;
	private JTextField TFcell;
	private JTextField TFfax;
	private JTextField TFrifAgente;
	
	private JButton bottoneSalvaCliente;
	private JButton bottoneAnnullaInserimento;
	private JButton bottoneEsci;
	
	/*costruttori*/
	
	public DettaglioClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuova scheda cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		
		setLayout(null);
		
		/*labelIdCliente = DefaultComponentFactory.getInstance().createLabel("Codice Cliente");
		labelIdCliente.setBounds(125, 35, 105, 14);
		add(labelIdCliente);
		
		TFidCliente = new JTextField();
		TFidCliente.setColumns(10);
		TFidCliente.setBounds(312, 29, 261, 20);
		add(TFidCliente);*/
		
		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome o Ragione sociale");
		labelCognome.setBounds(149, 59, 155, 14);
		add(labelCognome);
		
		TFcognome = new JTextField();
		TFcognome.setBounds(336, 53, 261, 20);
		add(TFcognome);
		TFcognome.setColumns(10);
		
		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome");
		labelNome.setBounds(149, 98, 69, 14);
		add(labelNome);
		 
		TFnome = new JTextField();
		TFnome.setBounds(336, 92, 261, 20);
		add(TFnome);
		TFnome.setColumns(10);
		 
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale");
		labelCodiceFiscale.setBounds(149, 137, 111, 14);
		add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setBounds(336, 131, 261, 20);
		add(TFcodicefiscale);
		TFcodicefiscale.setColumns(10);
		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("Partita Iva");
		labelPartitaIva.setBounds(149, 176, 69, 14);
		add(labelPartitaIva);
		 
		TFpartitaiva = new JTextField();
		TFpartitaiva.setBounds(336, 170, 261, 20);
		add(TFpartitaiva);
		TFpartitaiva.setColumns(10);
		 
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo");
		labelIndirizzo.setBounds(149, 215, 69, 14);
		add(labelIndirizzo);
		 
		TFindirizzo = new JTextField();
		TFindirizzo.setBounds(336, 209, 261, 20);
		TFindirizzo.setColumns(10);
		add(TFindirizzo);
		
		
		labelCitta = DefaultComponentFactory.getInstance().createLabel("Citt\u00E0");
		labelCitta.setBounds(149, 254, 46, 14);
		add(labelCitta);
		
		TFcitta = new JTextField();
		TFcitta.setColumns(10);
		TFcitta.setBounds(336, 248, 261, 20);
		add(TFcitta);
		
		labelCAP = DefaultComponentFactory.getInstance().createLabel("CAP");
		labelCAP.setBounds(149, 293, 46, 14);
		add(labelCAP);
		
		TFcap = new JTextField();
		TFcap.setColumns(10);
		TFcap.setBounds(336, 287, 261, 20);
		add(TFcap);
		
		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		labelTelefono.setBounds(149, 332, 69, 14);
		add(labelTelefono);
		
		TFtelefono = new JTextField();
		TFtelefono.setBounds(336, 326, 261, 20);
		add(TFtelefono);
		TFtelefono.setColumns(10);
		
		labelCell = DefaultComponentFactory.getInstance().createLabel("Cellulare");
		labelCell.setBounds(149, 371, 46, 14);
		add(labelCell);
		
		TFcell = new JTextField();
		TFcell.setColumns(10);
		TFcell.setBounds(336, 365, 261, 20);
		add(TFcell);
		
		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		labelFax.setBounds(149, 410, 69, 14);
		add(labelFax);
		
		TFfax = new JTextField();
		TFfax.setBounds(336, 404, 261, 20);
		add(TFfax);
		TFfax.setColumns(10);
		 
		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		labelEmail.setBounds(149, 449, 69, 14);
		add(labelEmail);
		 
		TFemail = new JTextField();
		TFemail.setBounds(336, 443, 261, 20);
		add(TFemail);
		TFemail.setColumns(10);
		
		labelRifAgente = DefaultComponentFactory.getInstance().createLabel("Agente di riferimento");
		labelRifAgente.setBounds(149, 488, 111, 14);
		add(labelRifAgente);
		
		TFrifAgente = new JTextField();
		TFrifAgente.setEnabled(false);
		TFrifAgente.setEditable(false);
		TFrifAgente.setBounds(336, 482, 261, 20);
		TFrifAgente.setColumns(10);
		add(TFrifAgente);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setBounds(77, 507, 448, 20);
		add(labelErrore);
		
		bottoneSalvaCliente = new JButton("");
		bottoneSalvaCliente.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save_32.png")));
		bottoneSalvaCliente.setToolTipText("Salva il cliente");
		bottoneSalvaCliente.setBounds(655, 77, 50, 50);
		add(bottoneSalvaCliente);
		
		bottoneAnnullaInserimento = new JButton("");
		bottoneAnnullaInserimento.setBounds(655, 174, 50, 50);
		bottoneAnnullaInserimento.setToolTipText("Pulisci form");
		bottoneAnnullaInserimento.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/clean-form.png")));
		add(bottoneAnnullaInserimento);
		
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(655, 272, 50, 50);
		bottoneEsci.setToolTipText("Torna indietro");
		bottoneEsci.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/sign-out.png")));
		add(bottoneEsci);
		
		
		bottoneSalvaCliente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Ctrl_gestisciCliente.getInstance().inserisciNuovoCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFcell.getText(), (String)TFfax.getText());
			}	
		});
	
		bottoneAnnullaInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().annullaNewCliente();
			}
		});
		
		bottoneEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().esciNewCliente();
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
		TFcitta.setText(null);
		TFindirizzo.setText(null);
		TFcap.setText(null);
		TFemail.setText(null);
		TFtelefono.setText(null);
		TFcell.setText(null);
		TFfax.setText(null);
	}
}