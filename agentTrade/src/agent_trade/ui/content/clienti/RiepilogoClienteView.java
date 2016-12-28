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
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;
import agent_trade.ui.PrimaryView;

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
	
	
	/*costruttori*/
	
	public RiepilogoClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Scheda Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(new BorderLayout());
		
		
		pannelloCentro = new JPanel();
		pannelloCentro.setPreferredSize(new Dimension(435, 610));
		pannelloCentro.setLayout(new GridLayout(1,1));
		this.add(pannelloCentro, BorderLayout.CENTER);
		
		JPanel pannelloContenitore = new JPanel();
		pannelloContenitore.setPreferredSize(new Dimension(425, 460));
		
		scrollPane = new JScrollPane(pannelloContenitore);
		scrollPane.setBorder(null);
		
		pannelloCentro.add(scrollPane);
		
		pannelloCampi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pannelloCampi.getLayout();
		flowLayout.setVgap(15);
		pannelloCampi.setPreferredSize(new Dimension(425, 610));
		pannelloContenitore.add(pannelloCampi);
		
		
		
		
		//aggiunta immagine accanto alla form
		JLabel label_IMG_Riep = new JLabel("");
//		label_IMG_Riep.setBounds(5, 21, 163, 179);
//		add(label_IMG_Riep);
		label_IMG_Riep.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/Img_cliente_riepilogo.png")));

		label_IMG_Riep.setPreferredSize(new Dimension(163, 179));
//		pannelloCampi.add(label_IMG_Riep);
		
		/**************/

		
		labelIdCliente = DefaultComponentFactory.getInstance().createLabel("Codice cliente");
		labelIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelIdCliente.setPreferredSize(new Dimension(150, 14));
		pannelloCampi.add(labelIdCliente);

		
		TFidCliente = new JTextField();
		TFidCliente.setPreferredSize(new Dimension(261,20));
		TFidCliente.setEditable(false);
		pannelloCampi.add(TFidCliente);

		
		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome o Ragione sociale");
		labelCognome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCognome.setPreferredSize(new Dimension(150, 14));
		pannelloCampi.add(labelCognome);
				
		TFcognome = new JTextField();
		TFcognome.setPreferredSize(new Dimension(261,20));
		TFcognome.setEditable(false);
		pannelloCampi.add(TFcognome);

		
		
		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNome.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelNome);

		
		TFnome = new JTextField();
		TFnome.setPreferredSize(new Dimension(261,20));
		TFnome.setEditable(false);
		pannelloCampi.add(TFnome);

		
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale");
		labelCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCodiceFiscale.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setPreferredSize(new Dimension(261,20));
		TFcodicefiscale.setEditable(false);
		pannelloCampi.add(TFcodicefiscale);
		//TFcodicefiscale.setColumns(10);

		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("Partita Iva");
		labelPartitaIva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPartitaIva.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelPartitaIva);
		 
		TFpartitaiva = new JTextField();
//		MODIFICA PROSSIME 4
		//TFpartitaiva.setBounds(336, 166, 261, 20);
		TFpartitaiva.setPreferredSize(new Dimension(261,20));
		TFpartitaiva.setEditable(false);
		pannelloCampi.add(TFpartitaiva);
		//TFpartitaiva.setColumns(10);
		 
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo");
		labelIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 13));

		//labelIndirizzo.setBounds(149, 211, 69, 14);
				labelIndirizzo.setPreferredSize(new Dimension(150,14));
				pannelloCampi.add(labelIndirizzo);
				 
				TFindirizzo = new JTextField();
//				MODIFICA PROSSIME 4
				//TFindirizzo.setBounds(336, 205, 261, 20);
				TFindirizzo.setPreferredSize(new Dimension(261,20));
				TFindirizzo.setEditable(false);
				//TFindirizzo.setColumns(10);
				pannelloCampi.add(TFindirizzo);
		
		
		labelCitta = DefaultComponentFactory.getInstance().createLabel("Citt\u00E0");
		labelCitta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//labelCitta.setBounds(149, 250, 46, 14);
				labelCitta.setPreferredSize(new Dimension(150,14));
				pannelloCampi.add(labelCitta);
				
				TFcitta = new JTextField();
//				MODIFICA PROSSIME 4
				//TFcitta.setColumns(10);
				TFcitta.setEditable(false);
				//TFcitta.setBounds(336, 244, 261, 20);
				TFcitta.setPreferredSize(new Dimension(261,20));
				pannelloCampi.add(TFcitta);
				
		
		labelCAP = DefaultComponentFactory.getInstance().createLabel("CAP");
		labelCAP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCAP.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCAP);
		
		TFcap = new JTextField();
//		MODIFICA PROSSIME 4
		//TFcap.setColumns(10);
		TFcap.setEditable(false);
		//TFcap.setBounds(336, 283, 261, 20);
		TFcap.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcap);
		
		
		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTelefono.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelTelefono);
		
		TFtelefono = new JTextField();
//		MODIFICA PROSSIME 4
		//TFtelefono.setBounds(336, 322, 261, 20);
		TFtelefono.setPreferredSize(new Dimension(261,20));
		TFtelefono.setEditable(false);
		pannelloCampi.add(TFtelefono);
	
		
		labelCell = DefaultComponentFactory.getInstance().createLabel("Cellulare");
		//labelCell.setBounds(149, 367, 46, 14);
		labelCell.setFont(new Font("Tahoma", Font.PLAIN, 13));

		labelCell.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCell);
		
		TFcell = new JTextField();
//		MODIFICA PROSSIME 4
		//TFcell.setColumns(10);
		TFcell.setEditable(false);
		//TFcell.setBounds(336, 361, 261, 20);
		TFcell.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcell);
	
		
		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		//labelFax.setBounds(149, 406, 69, 14);
		labelFax.setFont(new Font("Tahoma", Font.PLAIN, 13));

		labelFax.setPreferredSize(new Dimension(150,14));
				pannelloCampi.add(labelFax);
				
				TFfax = new JTextField();
//				MODIFICA PROSSIME 4
				//TFfax.setBounds(336, 400, 261, 20);
				TFfax.setPreferredSize(new Dimension(261,20));
				TFfax.setEditable(false);
				pannelloCampi.add(TFfax);
				//TFfax.setColumns(10);
		 
		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		//labelEmail.setBounds(149, 445, 69, 14);
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));

				labelEmail.setPreferredSize(new Dimension(150,14));
				pannelloCampi.add(labelEmail);
				 
				TFemail = new JTextField();
//				MODIFICA PROSSIME 4
				//TFemail.setBounds(336, 439, 261, 20);
				TFemail.setPreferredSize(new Dimension(261,20));
				TFemail.setEditable(false);
				pannelloCampi.add(TFemail);
				//TFemail.setColumns(10);
		
		labelRifAgente = DefaultComponentFactory.getInstance().createLabel("Agente di riferimento");
		labelRifAgente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//labelRifAgente.setBounds(149, 484, 111, 14);
		labelRifAgente.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelRifAgente);
		
		TFrifAgente = new JTextField();
		TFrifAgente.setEnabled(false);
		TFrifAgente.setEditable(false);
//		MODIFICA PROSSIME 4
		//TFrifAgente.setBounds(336, 478, 261, 20);
		TFrifAgente.setPreferredSize(new Dimension(261,20));
		//TFrifAgente.setColumns(10);
		pannelloCampi.add(TFrifAgente);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(416,14));
		pannelloCampi.add(labelErrore);
		
		
		/******fin qui*******/
//		
//		bottoneModificaCliente = new JButton("");
//		bottoneModificaCliente.setBounds(677, 174, 50, 50);
//		add(bottoneModificaCliente);
//		bottoneModificaCliente.setToolTipText("Modifica i dati del cliente");
//		bottoneModificaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/settings_client.png")));
//		
//		bottoneCancellaCliente = new JButton("");
//		bottoneCancellaCliente.setBounds(677, 281, 50, 50);
//		add(bottoneCancellaCliente);
//		bottoneCancellaCliente.setToolTipText("Cancella cliente");
//		bottoneCancellaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/trash-icon.png")));
//		
//		//aggiunto il setToolTipText
//		bottoneSalvaModifiche = new JButton("");
//		bottoneSalvaModifiche.setBounds(511, 542, 50, 50);
//		add(bottoneSalvaModifiche);
//		bottoneSalvaModifiche.setToolTipText("Salva le modifiche");
//		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save_32.png")));
//		
//		//aggiunto il setToolTipText
//		bottoneAnnullaModifica = new JButton("");
//		bottoneAnnullaModifica.setBounds(601, 542, 50, 50);
//		add(bottoneAnnullaModifica);
//		bottoneAnnullaModifica.setToolTipText("Annulla le modifiche");
//		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/back-icon.png")));
//		
//		//aggiunto il setToolTipText
//		bottoneInviaComunicazione = new JButton("");
//		bottoneInviaComunicazione.setBounds(677, 66, 50, 50);
//		add(bottoneInviaComunicazione);
//		bottoneInviaComunicazione.setToolTipText("Invia mail al cliente");
//		bottoneInviaComunicazione.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/send-icon.png")));
//	
		
		pannelloOvest = new JPanel();
		pannelloOvest.setPreferredSize(new Dimension(70, 601));
		FlowLayout fl_pannelloOvest = new FlowLayout(FlowLayout.CENTER);
		//fl_pannelloOvest.setVgap(10);
		pannelloOvest.setLayout(fl_pannelloOvest);
		this.add(pannelloOvest,BorderLayout.EAST);
		
		pannelloBottoni = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pannelloBottoni.getLayout();
		flowLayout_1.setVgap(15);
		pannelloBottoni.setPreferredSize(new Dimension(70, 500));//DA MODIFICARE I DUE BOTTONI SOTTO IN TEORIA NN DEVONO COMPARIRE
		pannelloOvest.add(pannelloBottoni);

		bottoneInviaComunicazione = new JButton("");
//		MODIFICA PROSSIME 3
		//bottoneInviaComunicazione.setBounds(645, 52, 50, 50);
		bottoneInviaComunicazione.setPreferredSize(new Dimension(50,50));
		pannelloBottoni.add(bottoneInviaComunicazione);
		bottoneInviaComunicazione.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/send-icon.png")));
		
		bottoneModificaCliente = new JButton("");
//		MODIFICA PROSSIME 3
		//bottoneModificaCliente.setBounds(645, 151, 50, 50);
		bottoneModificaCliente.setPreferredSize(new Dimension(50,50));
		pannelloBottoni.add(bottoneModificaCliente);
		bottoneModificaCliente.setToolTipText("Modifica i dati del cliente");
		bottoneModificaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/settings_client.png")));
		
		bottoneCancellaCliente = new JButton("");
//		MODIFICA PROSSIME 3
		//bottoneCancellaCliente.setBounds(645, 250, 50, 50);
		bottoneCancellaCliente.setPreferredSize(new Dimension(50,50));
		pannelloBottoni.add(bottoneCancellaCliente);
		bottoneCancellaCliente.setToolTipText("Cancella cliente");
		bottoneCancellaCliente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource("/agent_trade/ui/img/trash-icon.png")));
		
		bottoneSalvaModifiche = new JButton("");
//		MODIFICA PROSSIME 3
		//bottoneSalvaModifiche.setBounds(645, 448, 50, 50);
		bottoneSalvaModifiche.setPreferredSize(new Dimension(50,50));
		pannelloBottoni.add(bottoneSalvaModifiche);
		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save_32.png")));
		
		bottoneAnnullaModifica = new JButton("");
//		MODIFICA PROSSIME 3
		//bottoneAnnullaModifica.setBounds(645, 349, 50, 50);
		bottoneAnnullaModifica.setPreferredSize(new Dimension(50,50));
		pannelloBottoni.add(bottoneAnnullaModifica);
		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/back-icon.png")));
		
		
		
		
		
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
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
				try {
					Ctrl_gestisciCliente.getInstance().annullaModificheCliente(TFidCliente.getText());
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
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
	}
		


