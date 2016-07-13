package agent_trade.ui.content.clienti;

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
import agent_trade.model.M_Cliente;
import agent_trade.ui.PrimaryView;
import java.awt.Color;

public class RiepilogoClienteView extends JPanel {

	/*attributi di classe*/
	
	private static RiepilogoClienteView instance;
	
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
	
	private JTextField TFidCliente;
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
	
	private JButton bottoneModificaCliente;
	private JButton bottoneCancellaCliente;
	private JButton bottoneBackToRicerca;
	private JButton bottoneSalvaModifiche;
	private JButton bottoneAnnullaModifica;
	private JButton bottoneInviaComunicazione;
	
	/*costruttori*/
	
	public RiepilogoClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Scheda Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);
		
		
		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome o Ragione sociale");
		labelCognome.setBounds(149, 55, 155, 14);
		add(labelCognome);
		
		TFcognome = new JTextField();
		TFcognome.setBounds(336, 49, 261, 20);
		TFcognome.setEditable(false);
		add(TFcognome);
		TFcognome.setColumns(10);
		
		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome");
		labelNome.setBounds(149, 94, 69, 14);
		add(labelNome);
		 
		TFnome = new JTextField();
		TFnome.setBounds(336, 88, 261, 20);
		TFnome.setEditable(false);
		add(TFnome);
		TFnome.setColumns(10);
		 
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale");
		labelCodiceFiscale.setBounds(149, 133, 111, 14);
		add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setBounds(336, 127, 261, 20);
		TFcodicefiscale.setEditable(false);
		add(TFcodicefiscale);
		TFcodicefiscale.setColumns(10);
		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("Partita Iva");
		labelPartitaIva.setBounds(149, 172, 69, 14);
		add(labelPartitaIva);
		 
		TFpartitaiva = new JTextField();
		TFpartitaiva.setBounds(336, 166, 261, 20);
		TFpartitaiva.setEditable(false);
		add(TFpartitaiva);
		TFpartitaiva.setColumns(10);
		 
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo");
		labelIndirizzo.setBounds(149, 211, 69, 14);
		add(labelIndirizzo);
		 
		TFindirizzo = new JTextField();
		TFindirizzo.setBounds(336, 205, 261, 20);
		TFindirizzo.setEditable(false);
		TFindirizzo.setColumns(10);
		add(TFindirizzo);
		
		
		labelCitta = DefaultComponentFactory.getInstance().createLabel("Citt\u00E0");
		labelCitta.setBounds(149, 250, 46, 14);
		add(labelCitta);
		
		TFcitta = new JTextField();
		TFcitta.setColumns(10);
		TFcitta.setEditable(false);
		TFcitta.setBounds(336, 244, 261, 20);
		add(TFcitta);
		
		labelCAP = DefaultComponentFactory.getInstance().createLabel("CAP");
		labelCAP.setBounds(149, 289, 46, 14);
		add(labelCAP);
		
		TFcap = new JTextField();
		TFcap.setColumns(10);
		TFcap.setEditable(false);
		TFcap.setBounds(336, 283, 261, 20);
		add(TFcap);
		
		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		labelTelefono.setBounds(149, 328, 69, 14);
		add(labelTelefono);
		
		TFtelefono = new JTextField();
		TFtelefono.setBounds(336, 322, 261, 20);
		TFtelefono.setEditable(false);
		add(TFtelefono);
		TFtelefono.setColumns(10);
		
		labelCell = DefaultComponentFactory.getInstance().createLabel("Cellulare");
		labelCell.setBounds(149, 367, 46, 14);
		add(labelCell);
		
		TFcell = new JTextField();
		TFcell.setColumns(10);
		TFcell.setEditable(false);
		TFcell.setBounds(336, 361, 261, 20);
		add(TFcell);
		
		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		labelFax.setBounds(149, 406, 69, 14);
		add(labelFax);
		
		TFfax = new JTextField();
		TFfax.setBounds(336, 400, 261, 20);
		TFfax.setEditable(false);
		add(TFfax);
		TFfax.setColumns(10);
		 
		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		labelEmail.setBounds(149, 445, 69, 14);
		add(labelEmail);
		 
		TFemail = new JTextField();
		TFemail.setBounds(336, 439, 261, 20);
		TFemail.setEditable(false);
		add(TFemail);
		TFemail.setColumns(10);
		
		labelRifAgente = DefaultComponentFactory.getInstance().createLabel("Agente di riferimento");
		labelRifAgente.setBounds(149, 484, 111, 14);
		add(labelRifAgente);
		
		TFrifAgente = new JTextField();
		TFrifAgente.setEnabled(false);
		TFrifAgente.setEditable(false);
		TFrifAgente.setBounds(336, 478, 261, 20);
		TFrifAgente.setColumns(10);
		add(TFrifAgente);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setBounds(70, 520, 455, 25);
		add(labelErrore);
		
		bottoneModificaCliente = new JButton("");
		bottoneModificaCliente.setBounds(645, 151, 50, 50);
		add(bottoneModificaCliente);
		bottoneModificaCliente.setToolTipText("Modifica i dati del cliente");
		bottoneModificaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/settings_client.png")));
		
		bottoneCancellaCliente = new JButton("");
		bottoneCancellaCliente.setBounds(645, 250, 50, 50);
		add(bottoneCancellaCliente);
		bottoneCancellaCliente.setToolTipText("Cancella cliente");
		bottoneCancellaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/trash-icon.png")));
		
		bottoneSalvaModifiche = new JButton("");
		bottoneSalvaModifiche.setBounds(645, 448, 50, 50);
		add(bottoneSalvaModifiche);
		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save_32.png")));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setBounds(645, 349, 50, 50);
		add(bottoneAnnullaModifica);
		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/back-icon.png")));
		
		bottoneInviaComunicazione = new JButton("");
		bottoneInviaComunicazione.setBounds(645, 52, 50, 50);
		add(bottoneInviaComunicazione);
		bottoneInviaComunicazione.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/send-icon.png")));
		
		bottoneModificaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().abilitaModifica();
			}
		});
		
		bottoneCancellaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Ctrl_gestisciCliente.getInstance().cancellaCliente((String)TFcognome.getText());
			}
		});
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciCliente.getInstance().modificaCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFcell.getText(), (String)TFfax.getText());
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
				Ctrl_gestisciCliente.getInstance().annullaModificheCliente(TFcognome.getText());
			}
		});
		
		bottoneInviaComunicazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//da implementare invio documenti
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
		
		
		//questo metodo inserisce i dati recuperati nelle relative TF per consultare i dati cliente
		//manca id da recuperare dal db
		public void setRiepilogoCliente(String cognome, String nome, String codice_fiscale, String partita_iva, String indirizzo, String email, String telefono, String fax ) {
			
			//this.TFidCliente.setText(id);
			this.TFcognome.setText(cognome);
			this.TFnome.setText(nome);
			this.TFcodicefiscale.setText(codice_fiscale);
			this.TFpartitaiva.setText(partita_iva);
			this.TFindirizzo.setText(indirizzo);
			//this.TFcitta.setText(citta);
			//this.TFcap.setText(cap);
			this.TFtelefono.setText(telefono);
			//this.TFcell.setText(cellulare);
			this.TFfax.setText(fax);
			this.TFemail.setText(email);
			//this.TFrifAgente.setText(rifAgente);
		}
		
		//questo metodo rende le TF modificabili per effettuare update dei dati
		public void setTFeditable(boolean b) {
			TFcognome.setEditable(b);
			TFnome.setEditable(b);
			TFcodicefiscale.setEditable(b);
			TFpartitaiva.setEditable(b);
			TFindirizzo.setEditable(b);
			TFcitta.setEditable(b);
			TFcap.setEditable(b);
			TFtelefono.setEditable(b);
			TFcell.setEditable(b);
			TFfax.setEditable(b);
			TFemail.setEditable(b);
		}
		
		public void resetCampiModifica(){
//			TFcognome.setText(null);
//			TFnome.setText(null);
//			TFcodicefiscale.setText(null);
//			TFpartitaiva.setText(null);
//			TFindirizzo.setText(null);
//			TFemail.setText(null);
//			TFtelefono.setText(null);
//			TFfax.setText(null);
			setTFeditable(false);
		}
		
		public void setEnaBtnModifiche(boolean b){
		bottoneModificaCliente.setEnabled(b);
		}
		
		public void setEnaBtnSalvaModifiche(boolean b){
			bottoneSalvaModifiche.setEnabled(b);
		}
		
		public void setEnaBtnAnnullaModifiche(boolean b){
			bottoneAnnullaModifica.setEnabled(b);
		}
		
		public void setEnaBtnCancella(boolean b) {
			bottoneCancellaCliente.setEnabled(b);
		}
		
		public void setErrore(String err){
			labelErrore.setText(err);
		}
		
		public void setVisibleErroreRiepCliente(boolean b){
			labelErrore.setVisible(b);
		}
	}
		


