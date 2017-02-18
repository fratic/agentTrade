//package agent_trade.ui.content.clienti;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JSeparator;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.border.TitledBorder;
//
//import org.orm.PersistentException;
//
//import com.jgoodies.forms.factories.DefaultComponentFactory;
//
//import agent_trade.controller.Ctrl_gestisciCliente;
//import agent_trade.model.M_Cliente;
//import agent_trade.ui.PrimaryView;
//
//public class RiepilogoClienteView extends JPanel {
//
//	/*attributi di classe*/
//	
//	private static RiepilogoClienteView instance;
//	
//	/*attributi privati*/
//	
//	private JLabel labelNome;
//	private JLabel labelCognome;
//	private JLabel labelIndirizzo;
//	private JLabel labelCodiceFiscale;
//	private JLabel labelPartitaIva;
//	private JLabel labelEmail;
//	private JLabel labelTelefono;
//	private JLabel labelFax;
//	private JLabel labelErrore;
//	
//	private JTextField TFnome;
//	private JTextField TFcognome;
//	private JTextField TFindirizzo;
//	private JTextField TFcodicefiscale;
//	private JTextField TFpartitaiva;
//	private JTextField TFemail;
//	private JTextField TFtelefono;
//	private JTextField TFfax;
//	
//	private JButton bottoneModificaCliente;
//	private JButton bottoneCancellaCliente;
//	private JButton bottoneBackToRicerca;
//	private JButton bottoneSalvaModifiche;
//	private JButton bottoneAnnullaModifica;
//	
//	/*costruttori*/
//	
//	public RiepilogoClienteView() {
//		
//		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Scheda Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
//		setBackground(UIManager.getColor("CheckBox.background"));
//		setLayout(null);
//		
//		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome: ");
//		labelNome.setBounds(43, 47, 69, 14);
//		add(labelNome);
//		 
//		TFnome = new JTextField();
//		TFnome.setEditable(false);
//		TFnome.setBounds(178, 44, 261, 20);
//		add(TFnome);
//		 TFnome.setColumns(10);
//		 
//		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome: ");
//		labelCognome.setBounds(43, 90, 69, 14);
//		add(labelCognome);
//		 
//		TFcognome = new JTextField();
//		TFcognome.setEditable(false);
//		TFcognome.setBounds(178, 87, 261, 20);
//		add(TFcognome);
//		TFcognome.setColumns(10);
//		 
//		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale: ");
//		labelCodiceFiscale.setBounds(43, 169, 97, 14);
//		add(labelCodiceFiscale);
//		 
//		TFcodicefiscale = new JTextField();
//		TFcodicefiscale.setEditable(false);
//		TFcodicefiscale.setBounds(178, 166, 261, 20);
//		add(TFcodicefiscale);
//		TFcodicefiscale.setColumns(10);
//		 
//		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("PartitaIva: ");
//		labelPartitaIva.setBounds(44, 210, 69, 14);
//		add(labelPartitaIva);
//		
//		TFpartitaiva = new JTextField();
//		TFpartitaiva.setEditable(false);
//		TFpartitaiva.setBounds(178, 207, 261, 20);
//		add(TFpartitaiva);
//		TFpartitaiva.setColumns(10);
//		 
//		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo: ");
//		labelIndirizzo.setBounds(44, 131, 69, 14);
//		add(labelIndirizzo);
//		 
//		TFindirizzo = new JTextField();
//		TFindirizzo.setEditable(false);
//		TFindirizzo.setBounds(178, 128, 261, 20);
//		add(TFindirizzo);
//		TFindirizzo.setColumns(10);
//		 
//		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
//		labelEmail.setBounds(44, 251, 69, 14);
//		add(labelEmail);
//		 
//		TFemail = new JTextField();
//		TFemail.setEditable(false);
//		TFemail.setBounds(178, 248, 261, 20);
//		add(TFemail);
//		TFemail.setColumns(10);
//		 
//		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
//		labelTelefono.setBounds(44, 297, 69, 14);
//		add(labelTelefono);
//		 
//		TFtelefono = new JTextField();
//		TFtelefono.setEditable(false);
//		TFtelefono.setBounds(178, 294, 261, 20);
//		add(TFtelefono);
//		TFtelefono.setColumns(10);
//		 
//		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
//		labelFax.setBounds(43, 342, 69, 14);
//		add(labelFax);
//		 
//		TFfax = new JTextField();
//		TFfax.setEditable(false);
//		TFfax.setBounds(177, 339, 262, 20);
//		add(TFfax);
//		TFfax.setColumns(10);
//		
//		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
//		labelErrore.setBounds(43, 367, 210, 25);
//		add(labelErrore);
//		
////		JSeparator separator = new JSeparator();
////		separator.setBounds(0, 384, 554, 8);
////		add(separator);
//		
//		bottoneModificaCliente = new JButton("Modifica");
//		bottoneModificaCliente.setBounds(157, 394, 127, 33);
//		add(bottoneModificaCliente);
//		bottoneModificaCliente.setToolTipText("Modifica i dati del cliente");
//		bottoneModificaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/setting.png")));
//		
//		bottoneCancellaCliente = new JButton("Cancella");
//		bottoneCancellaCliente.setBounds(27, 394, 120, 33);
//		add(bottoneCancellaCliente);
//		bottoneCancellaCliente.setToolTipText("Cancella cliente");
//		bottoneCancellaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/remove-user.png")));
//		
//		bottoneSalvaModifiche = new JButton("Salva");
//		bottoneSalvaModifiche.setBounds(294, 394, 120, 33);
//		add(bottoneSalvaModifiche);
//		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save-user.png")));
//		
//		bottoneAnnullaModifica = new JButton("Annulla");
//		bottoneAnnullaModifica.setBounds(424, 394, 120, 33);
//		add(bottoneAnnullaModifica);
//		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/close_icon.png")));
//		
//		bottoneModificaCliente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Ctrl_gestisciCliente.getInstance().abilitaModifica();
//			}
//		});
//		
//		bottoneCancellaCliente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//	
//				Ctrl_gestisciCliente.getInstance().cancellaCliente((String)TFcognome.getText());
//			}
//		});
//		
//		bottoneSalvaModifiche.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				try {
////					Ctrl_gestisciCliente.getInstance().modificaCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFfax.getText());
//					Ctrl_gestisciCliente.getInstance().modificaCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFfax.getText());
//
//				} catch (PersistentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		
//		bottoneAnnullaModifica.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//	
//				
//				try {
//					Ctrl_gestisciCliente.getInstance().annullaModificheCliente(TFcognome.getText());
//				} catch (PersistentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//		
//		/*metodi di classe*/
//		
//		public static RiepilogoClienteView getInstance(){
//			if (instance==null)
//				instance = new RiepilogoClienteView();
//			return instance;	 
//			}
//		
//		/*metodi privati*/
//		
//		/*metodi pubblici*/
//		
//		
//		//questo metodo inserisce i dati recuperati nelle relative TF per consultare i dati cliente
//		public void setRiepilogoCliente(String cognome, String nome, String codice_fiscale, String partita_iva, String indirizzo, String email, String telefono, String fax ) {
//			
//			this.TFcognome.setText(cognome);
//			this.TFnome.setText(nome);
//			this.TFcodicefiscale.setText(codice_fiscale);
//			this.TFpartitaiva.setText(partita_iva);
//			this.TFindirizzo.setText(indirizzo);
//			this.TFemail.setText(email);
//			this.TFtelefono.setText(telefono);
//			this.TFfax.setText(fax);	
//		}
//		
//		//questo metodo rende le TF modificabili per effettuare update dei dati
//		public void setTFeditable(boolean b) {
//			TFcognome.setEditable(b);
//			TFnome.setEditable(b);
//			TFcodicefiscale.setEditable(b);
//			TFpartitaiva.setEditable(b);
//			TFindirizzo.setEditable(b);
//			TFemail.setEditable(b);
//			TFtelefono.setEditable(b);
//			TFfax.setEditable(b);
//		}
//		
//		public void resetCampiModifica(){
////			TFcognome.setText(null);
////			TFnome.setText(null);
////			TFcodicefiscale.setText(null);
////			TFpartitaiva.setText(null);
////			TFindirizzo.setText(null);
////			TFemail.setText(null);
////			TFtelefono.setText(null);
////			TFfax.setText(null);
//			setTFeditable(false);
//		}
//		
//		public void setEnaBtnModifiche(boolean b){
//		bottoneModificaCliente.setEnabled(b);
//		}
//		
//		public void setEnaBtnSalvaModifiche(boolean b){
//			bottoneSalvaModifiche.setEnabled(b);
//		}
//		
//		public void setEnaBtnAnnullaModifiche(boolean b){
//			bottoneAnnullaModifica.setEnabled(b);
//		}
//		
//		public void setEnaBtnCancella(boolean b) {
//			bottoneCancellaCliente.setEnabled(b);
//		}
//		
//		public void setErrore(String err){
//			labelErrore.setText(err);
//		}
//		
//		public void setVisibleErroreRiepCliente(boolean b){
//			labelErrore.setVisible(b);
//		}
//	}
//		
//
//


package agent_trade.ui.content.clienti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;
import agent_trade.ui.PrimaryView;
import agent_trade.util.Costanti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

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
	
	private JPanel pannelloCampi;

	private JPanel pannelloBottoni;

	private JPanel pannelloCentro;

	private JPanel pannelloOvest;

	private JScrollPane scrollPane;

	private JPanel pannelloContenitore;

	private JPanel pannelloIcona;

	private JPanel contenitoreCampi;

	private JPanel pannIdCliente;

	private JPanel pannCognome;

	private JPanel pannNome;

	private JPanel pannCodFis;

	private JPanel pannPartitaIva;

	private JPanel pannIndirizzo;

	private JPanel pannCitta;

	private JPanel pannCap;

	private JPanel pannTelefono;

	private JPanel pannCellulare;

	private JPanel pannFax;

	private JPanel pannEmail;

	private JPanel pannRifAgente;

	private JPanel pannErrore;

	private JPanel pannelloEast;
	
	
	/*costruttori*/
	
	public RiepilogoClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_SCHEDA_CLIENTE, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(new BorderLayout());
		
		
		pannelloCentro = new JPanel();
		pannelloCentro.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCentro.setLayout(new GridLayout(1,1));
		this.add(pannelloCentro, BorderLayout.CENTER);
		
		pannelloContenitore = new JPanel();
		pannelloContenitore.setLayout(new BorderLayout());
		pannelloContenitore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CONTENITORE, Costanti.HEIGHT_PANN_CONTENITORE));
		
		scrollPane = new JScrollPane(pannelloContenitore);
		scrollPane.setBorder(null);
		pannelloCentro.add(scrollPane);
		
		pannelloIcona = new JPanel();
		pannelloIcona.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_ICONA,Costanti.HEIGHT_PANN_ICONA));
		pannelloContenitore.add(pannelloIcona, BorderLayout.WEST);
		
		JLabel label_IMG = new JLabel("");
		label_IMG.setHorizontalAlignment(SwingConstants.CENTER);
//		label_IMG.setBounds(24, 24, 163, 179);;
		label_IMG.setPreferredSize(new Dimension(Costanti.WIDTH_ICON, Costanti.HEIGHT_ICON));
		label_IMG.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.RIEPILOGO_CLIENTE_ICON)));
		pannelloIcona.add(label_IMG);
		
		pannelloCampi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pannelloCampi.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		pannelloCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloContenitore.add(pannelloCampi, BorderLayout.CENTER);
		
		contenitoreCampi = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) contenitoreCampi.getLayout();
		flowLayout1.setVgap(15);
		flowLayout1.setHgap(0);
		flowLayout1.setAlignment(FlowLayout.CENTER);
		contenitoreCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCampi.add(contenitoreCampi);
		
		
		/**************/

		
		pannIdCliente = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannIdCliente.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannIdCliente.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannIdCliente);
		
		labelIdCliente = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID);
		labelIdCliente.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelIdCliente.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannIdCliente.add(labelIdCliente);

		
		TFidCliente = new JTextField();
		TFidCliente.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFidCliente.setEditable(false);
		pannIdCliente.add(TFidCliente);

		pannCognome = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannCognome.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannCognome.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCognome);
		
		labelCognome = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_COGNOME);
		labelCognome.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCognome.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCognome.add(labelCognome);
				
		TFcognome = new JTextField();
		TFcognome.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFcognome.setEditable(false);
		pannCognome.add(TFcognome);

		pannNome = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) pannNome.getLayout();
		flowLayout4.setHgap(0);
		flowLayout4.setVgap(0);
		pannNome.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannNome);
		
		labelNome = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NOME_CLIENTE);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelNome.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannNome.add(labelNome);

		TFnome = new JTextField();
		TFnome.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFnome.setEditable(false);
		pannNome.add(TFnome);

		pannCodFis = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) pannCodFis.getLayout();
		flowLayout5.setHgap(0);
		flowLayout5.setVgap(0);
		pannCodFis.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCodFis);
		
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_COD_FISC);
		labelCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCodiceFiscale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCodFis.add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFcodicefiscale.setEditable(false);
		pannCodFis.add(TFcodicefiscale);

		pannPartitaIva= new JPanel();
		FlowLayout flowLayout6 = (FlowLayout) pannPartitaIva.getLayout();
		flowLayout6.setHgap(0);
		flowLayout6.setVgap(0);
		pannPartitaIva.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannPartitaIva);
		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PARTITA_IVA);
		labelPartitaIva.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelPartitaIva.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannPartitaIva.add(labelPartitaIva);
		 
		TFpartitaiva = new JTextField();
		TFpartitaiva.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFpartitaiva.setEditable(false);
		pannPartitaIva.add(TFpartitaiva);
		 
		pannIndirizzo= new JPanel();
		FlowLayout flowLayout7 = (FlowLayout) pannIndirizzo.getLayout();
		flowLayout7.setHgap(0);
		flowLayout7.setVgap(0);
		pannIndirizzo.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannIndirizzo);
		
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_INDIRIZZO);
		labelIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelIndirizzo.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannIndirizzo.add(labelIndirizzo);
		 
		TFindirizzo = new JTextField();
		TFindirizzo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFindirizzo.setEditable(false);
		pannIndirizzo.add(TFindirizzo);
		
		pannCitta= new JPanel();
		FlowLayout flowLayout8 = (FlowLayout) pannCitta.getLayout();
		flowLayout8.setHgap(0);
		flowLayout8.setVgap(0);
		pannCitta.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCitta);
		
		labelCitta = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_CITTA);
		labelCitta.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCitta.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCitta.add(labelCitta);
		
		TFcitta = new JTextField();
		TFcitta.setEditable(false);
		TFcitta.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		pannCitta.add(TFcitta);	
		
		pannCap= new JPanel();
		FlowLayout flowLayout9 = (FlowLayout) pannCap.getLayout();
		flowLayout9.setHgap(0);
		flowLayout9.setVgap(0);
		pannCap.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCap);
		
		labelCAP = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_CAP);
		labelCAP.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCAP.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCap.add(labelCAP);
		
		TFcap = new JTextField();
		TFcap.setEditable(false);
		TFcap.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		pannCap.add(TFcap);
		
		pannTelefono= new JPanel();
		FlowLayout flowLayout10 = (FlowLayout) pannTelefono.getLayout();
		flowLayout10.setHgap(0);
		flowLayout10.setVgap(0);
		pannTelefono.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannTelefono);
		
		labelTelefono = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TELEFONO);
		labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelTelefono.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannTelefono.add(labelTelefono);
		
		TFtelefono = new JTextField();
		TFtelefono.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFtelefono.setEditable(false);
		pannTelefono.add(TFtelefono);
	
		pannCellulare = new JPanel();
		FlowLayout flowLayout11 = (FlowLayout) pannCellulare.getLayout();
		flowLayout11.setHgap(0);
		flowLayout11.setVgap(0);
		pannCellulare.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCellulare);
		
		labelCell = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_CELLULARE);
		labelCell.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCell.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCellulare.add(labelCell);
		
		TFcell = new JTextField();
		TFcell.setEditable(false);
		TFcell.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		pannCellulare.add(TFcell);
	
		pannFax = new JPanel();
		FlowLayout flowLayout12 = (FlowLayout) pannFax.getLayout();
		flowLayout12.setHgap(0);
		flowLayout12.setVgap(0);
		pannFax.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannFax);		
		
		labelFax = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_FAX);
		labelFax.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelFax.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannFax.add(labelFax);
				
		TFfax = new JTextField();
		TFfax.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFfax.setEditable(false);
		pannFax.add(TFfax);
		 
		pannEmail= new JPanel();
		FlowLayout flowLayout13 = (FlowLayout) pannEmail.getLayout();
		flowLayout13.setHgap(0);
		flowLayout13.setVgap(0);
		pannEmail.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannEmail);
		
		labelEmail = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_EMAIL);
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelEmail.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannEmail.add(labelEmail);
		 
		TFemail = new JTextField();
		TFemail.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFemail.setEditable(false);
		pannEmail.add(TFemail);
		
		pannRifAgente= new JPanel();
		FlowLayout flowLayout14 = (FlowLayout) pannRifAgente.getLayout();
		flowLayout14.setHgap(0);
		flowLayout14.setVgap(0);
		pannRifAgente.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannRifAgente);
		
		labelRifAgente = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_AGENTE_RIF);
		labelRifAgente.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelRifAgente.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannRifAgente.add(labelRifAgente);
		
		TFrifAgente = new JTextField();
		TFrifAgente.setEditable(false);
		TFrifAgente.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		pannRifAgente.add(TFrifAgente);
		
		pannErrore= new JPanel();
		FlowLayout flowLayout15 = (FlowLayout) pannErrore.getLayout();
		flowLayout15.setHgap(0);
		flowLayout15.setVgap(0);
		pannErrore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL_ERRORE, Costanti.HEIGHT_PANN_LABEL_ERRORE));
		contenitoreCampi.add(pannErrore);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ERRORE_CAMPI);
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_ERRORE, Costanti.HEIGHT_LABEL_ERRORE));
		pannErrore.add(labelErrore);
		
		
		pannelloEast = new JPanel();
		pannelloEast.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_EAST, Costanti.HEIGHT_PANN_EAST));
		FlowLayout fl_pannelloOvest = new FlowLayout(FlowLayout.CENTER);
		pannelloEast.setLayout(fl_pannelloOvest);
		this.add(pannelloEast,BorderLayout.EAST);
		
		pannelloBottoni = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pannelloBottoni.getLayout();
		flowLayout_1.setVgap(15);
		pannelloBottoni.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_BOTTONI, Costanti.HEIGHT_PANN_BOTTONI));//DA MODIFICARE I DUE BOTTONI SOTTO IN TEORIA NN DEVONO COMPARIRE
		pannelloEast.add(pannelloBottoni);

		bottoneInviaComunicazione = new JButton("");
		bottoneInviaComunicazione.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneInviaComunicazione);
		bottoneInviaComunicazione.setToolTipText(Costanti.TIP_COMUNICAZIONE_CLIENTE);
		bottoneInviaComunicazione.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.COMUNICAZIONE_CLIENTE_ICON)));
		
		bottoneModificaCliente = new JButton("");
		bottoneModificaCliente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneModificaCliente);
		bottoneModificaCliente.setToolTipText(Costanti.TIP_MODIFICA_CLIENTE);
		bottoneModificaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource(Costanti.MOD_CLIENTE_ICON)));
		
		bottoneCancellaCliente = new JButton("");
		bottoneCancellaCliente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneCancellaCliente);
		bottoneCancellaCliente.setToolTipText(Costanti.TIP_CANCELLA_CLIENTE);
		bottoneCancellaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource(Costanti.CANC_CLIENTE_ICON)));
		
		bottoneSalvaModifiche = new JButton("");
		bottoneSalvaModifiche.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaModifiche);
		//bottoneCancellaCliente.setToolTipText(Costanti.TIP_SALVA_MOD_CLIENTE);
		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.SALVA_MOD_CLIENTE_ICON)));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaModifica);
		//bottoneCancellaCliente.setToolTipText(Costanti.TIP_ANNULLA_MOD_CLIENTE);
		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.ANNULLA_MOD_CLIENTE_ICON)));
		

		
		bottoneModificaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().abilitaModifica();
			}
		});
		
		bottoneCancellaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Ctrl_gestisciCliente.getInstance().cancellaCliente((String)TFidCliente.getText());
			}
		});
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciCliente.getInstance().modificaCliente(Integer.parseInt(TFidCliente.getText()),(String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFcell.getText(), (String)TFfax.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
				try {
					Ctrl_gestisciCliente.getInstance().annullaModificheCliente(TFidCliente.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
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
		public void setRiepilogoCliente(String id, String cognome, String nome, String codice_fiscale, String partita_iva, String citta, String cap, String indirizzo, String email, String telefono, String cellulare, String fax, String rifAgente ) {
			
			this.TFidCliente.setText(id);
			this.TFcognome.setText(cognome);
			this.TFnome.setText(nome);
			this.TFcodicefiscale.setText(codice_fiscale);
			this.TFpartitaiva.setText(partita_iva);
			this.TFindirizzo.setText(indirizzo);
			this.TFcitta.setText(citta);
			this.TFcap.setText(cap);
			this.TFtelefono.setText(telefono);
			this.TFcell.setText(cellulare);
			this.TFfax.setText(fax);
			this.TFemail.setText(email);
			this.TFrifAgente.setText(rifAgente);
			
			//a che serve il rif agente nel singolo agente visto che è sempre e solo lui?
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
		
		//MODIFICATA DA ENABLE A VISIBLE e cambiato nome
		public void setVisibleBtnModifiche(boolean b){
		bottoneModificaCliente.setVisible(b);
		}
		
		//MODIFICATA DA ENABLE A VISIBLE e cambiato nome
		public void setVisibleBtnSalvaModifiche(boolean b){
			bottoneSalvaModifiche.setVisible(b);
		}
		
		//MODIFICATA DA ENABLE A VISIBLE e cambiato nome
		public void setVisibleBtnAnnullaModifiche(boolean b){
			bottoneAnnullaModifica.setVisible(b);
		}
		
		//MODIFICATA DA ENABLE A VISIBLE e cambiato il nome
		public void setVisibleBtnCancella(boolean b) {
			bottoneCancellaCliente.setVisible(b);
		}
		
		//NUOVA FUNZIONE INSERITA
		public void setVisibleBtnInviaPosta(boolean b) {
			bottoneInviaComunicazione.setVisible(b);
		}
		
		public void setErrore(String err){
			labelErrore.setText(err);
		}
		
		public void setVisibleErroreRiepCliente(boolean b){
			labelErrore.setVisible(b);
		}
		
//		QUESTA FUNZIONE SERVE PER ABILITARE I TOOLTIP
		public void abilitaToolTip(){
			
			TFcognome.setToolTipText(Costanti.TIP_COGNOME);
			TFnome.setToolTipText(Costanti.TIP_NOME_CLIENTE);
			TFcodicefiscale.setToolTipText(Costanti.TIP_COD_FIS);
			TFpartitaiva.setToolTipText(Costanti.TIP_PARTITA_IVA);
			TFindirizzo.setToolTipText(Costanti.TIP_INDIRIZZO);
			TFcitta.setToolTipText(Costanti.TIP_CITTA);
			TFcap.setToolTipText(Costanti.TIP_CAP);
			TFtelefono.setToolTipText(Costanti.TIP_TELEFONO);
			TFcell.setToolTipText(Costanti.TIP_CELLULARE);
			TFfax.setToolTipText(Costanti.TIP_FAX);
			TFemail.setToolTipText(Costanti.TIP_EMAIL);
		}
		
//		QUESTA FUNZIONE SERVE PER DISABILITARE I TOOLTIP
		public void disabilitaToolTip(){
			TFcognome.setToolTipText(null);
			TFnome.setToolTipText(null);
			TFcodicefiscale.setToolTipText(null);
			TFpartitaiva.setToolTipText(null);
			TFindirizzo.setToolTipText(null);
			TFcitta.setToolTipText(null);
			TFcap.setToolTipText(null);
			TFtelefono.setToolTipText(null);
			TFcell.setToolTipText(null);
			TFfax.setToolTipText(null);
			TFemail.setToolTipText(null);
		}
		

}
		


