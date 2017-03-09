package agent_trade.ui.content.agenti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.util.Costanti;

public class RiepilogoAgenteView extends JPanel {

	/*attributi di classe*/
	
	private static RiepilogoAgenteView instance;
	
	/*attributi privati*/
	
	private JLabel labelIdAgente;
	private JLabel labelCognome;
	private JLabel labelNome;
	private JLabel labelLivello;
	private JLabel labelCitta;
	private JLabel labelIndirizzo;
	private JLabel labelCAP;
	private JLabel labelEmail;
	private JLabel labelCell;
	private JLabel labelUsername;
	private JLabel labelPassword;
	private JLabel labelErrore;
	
	private JTextField TFidAgente;
	private JTextField TFcognome;
	private JTextField TFnome;
	private JTextField TFlivello;
	private JTextField TFcitta;
	private JTextField TFindirizzo;
	private JTextField TFcap;
	private JTextField TFemail;
	private JTextField TFcell;
	private JTextField TFusername;
	private JTextField TFpassword;
	
	private JButton bottoneModificaAgente;
	private JButton bottoneCancellaAgente;
	private JButton bottoneSalvaModifiche;
	private JButton bottoneAnnullaModifica;
	private JButton bottoneInviaComunicazione;
	
	private JPanel pannelloCampi;

	private JPanel pannelloBottoni;

	private JPanel pannelloCentro;

	private JScrollPane scrollPane;

	private JPanel pannelloContenitore;

	private JPanel pannelloIcona;

	private JPanel contenitoreCampi;

	private JPanel pannIdAgente;

	private JPanel pannCognome;

	private JPanel pannNome;

	private JPanel pannLivello;
	
	private JPanel pannIndirizzo;

	private JPanel pannCitta;

	private JPanel pannCap;

	private JPanel pannCellulare;
	
	private JPanel pannEmail;

	private JPanel pannUsername;
	
	private JPanel pannPassword;

	private JPanel pannErrore;

	private JPanel pannelloEast;
	
	
	/*costruttori*/
	
	public RiepilogoAgenteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_SCHEDA_AGENTE, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		label_IMG.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.RIEPILOGO_AGENTE_ICON)));
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

		
		pannIdAgente = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannIdAgente.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannIdAgente.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannIdAgente);
		
		labelIdAgente = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID_AGENTE);
		labelIdAgente.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelIdAgente.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannIdAgente.add(labelIdAgente);

		
		TFidAgente = new JTextField();
		TFidAgente.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFidAgente.setEditable(false);
		pannIdAgente.add(TFidAgente);

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
		
		labelNome = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NOME);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelNome.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannNome.add(labelNome);

		TFnome = new JTextField();
		TFnome.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFnome.setEditable(false);
		pannNome.add(TFnome);

		pannLivello = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) pannLivello.getLayout();
		flowLayout5.setHgap(0);
		flowLayout5.setVgap(0);
		pannLivello.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannLivello);
		
		labelLivello = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_LVL);
		labelLivello.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelLivello.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannLivello.add(labelLivello);
		 
		TFlivello = new JTextField();
		TFlivello.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFlivello.setEditable(false);
		pannLivello.add(TFlivello);
		 
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
		 
		pannEmail = new JPanel();
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
		
		pannUsername = new JPanel();
		FlowLayout flowLayout14 = (FlowLayout) pannUsername.getLayout();
		flowLayout14.setHgap(0);
		flowLayout14.setVgap(0);
		pannUsername.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannUsername);
		
		labelUsername = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_USERNAME);
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelUsername.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannUsername.add(labelUsername);
		 
		TFusername = new JTextField();
		TFusername.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFusername.setEditable(false);
		pannUsername.add(TFusername);
		
		pannPassword = new JPanel();
		FlowLayout flowLayout10 = (FlowLayout) pannPassword.getLayout();
		flowLayout10.setHgap(0);
		flowLayout10.setVgap(0);
		pannPassword.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannPassword);
		
		labelPassword = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PASSWORD);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelPassword.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannPassword.add(labelPassword);
		 
		TFpassword = new JTextField();
		TFpassword.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFpassword.setEditable(false);
		pannPassword.add(TFpassword);
		
		
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
		bottoneInviaComunicazione.setToolTipText(Costanti.TIP_COMUNICAZIONE_AGENTE);
		bottoneInviaComunicazione.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.COMUNICAZIONE_AGENTE_ICON)));
		
		bottoneModificaAgente = new JButton("");
		bottoneModificaAgente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneModificaAgente);
		bottoneModificaAgente.setToolTipText(Costanti.TIP_MODIFICA_AGENTE);
		bottoneModificaAgente.setIcon(new ImageIcon(RiepilogoAgenteView.class.getResource(Costanti.MOD_AGENTE_ICON)));
		
		bottoneCancellaAgente = new JButton("");
		bottoneCancellaAgente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneCancellaAgente);
		bottoneCancellaAgente.setToolTipText(Costanti.TIP_CANCELLA_AGENTE);
		bottoneCancellaAgente.setIcon(new ImageIcon(RiepilogoAgenteView.class.getResource(Costanti.CANC_AGENTE_ICON)));
		
		bottoneSalvaModifiche = new JButton("");
		bottoneSalvaModifiche.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaModifiche);
		//bottoneSalvaModifiche.setToolTipText(Costanti.TIP_SALVA_MOD_AGENTE);
		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.SALVA_MOD_AGENTE_ICON)));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaModifica);
		//bottoneAnnullaModifica.setToolTipText(Costanti.TIP_ANNULLA_MOD_AGENTE);
		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.ANNULLA_MOD_AGENTE_ICON)));
		

		
		bottoneModificaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciAgente.getInstance().abilitaModifica();
			}
		});
		
		bottoneCancellaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
//				Ctrl_gestisciAgente.getInstance().cancellaAgente((String)TFidAgente.getText());
			}
		});
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAgente.getInstance().modificaAgente(Integer.parseInt(TFidAgente.getText()),(String)TFnome.getText(), (String)TFcognome.getText(), Integer.parseInt(TFlivello.getText()), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFcell.getText(), (String)TFusername.getText(), (String)TFpassword.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				
//				try {
//					Ctrl_gestisciCliente.getInstance().annullaModificheCliente(TFidCliente.getText());
//				} 
//				catch (PersistentException e) {
//					e.printStackTrace();
//				}
			}
		});
		
		bottoneInviaComunicazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//da implementare invio documenti
			}
		});
		
		
	}
		
		/*metodi di classe*/
		
		public static RiepilogoAgenteView getInstance(){
			if (instance==null)
				instance = new RiepilogoAgenteView();
			return instance;	 
			}
		
		/*metodi privati*/
		
		/*metodi pubblici*/
		
		
		
		public void setRiepilogoAgente(String id, String cognome, String nome, String livello, String citta, String cap, String indirizzo, String email, String cellulare, String username, String password ) {
			
			this.TFidAgente.setText(id);
			this.TFcognome.setText(cognome);
			this.TFnome.setText(nome);
			this.TFlivello.setText(livello);
			this.TFcitta.setText(citta);
			this.TFcap.setText(cap);
			this.TFindirizzo.setText(indirizzo);
			this.TFemail.setText(email);
			this.TFcell.setText(cellulare);
			this.TFusername.setText(username);
			this.TFpassword.setText(password);
		}
		
		//questo metodo rende le TF modificabili per effettuare update dei dati
		public void setTFeditable(boolean b) {
			TFcognome.setEditable(b);
			TFnome.setEditable(b);
			TFlivello.setEditable(b);
			TFcitta.setEditable(b);
			TFcap.setEditable(b);
			TFindirizzo.setEditable(b);
			TFemail.setEditable(b);
			TFcell.setEditable(b);
			TFusername.setEditable(b);
			TFpassword.setEditable(b);
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
		bottoneModificaAgente.setVisible(b);
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
			bottoneCancellaAgente.setVisible(b);
		}
		
		//NUOVA FUNZIONE INSERITA
		public void setVisibleBtnInviaPosta(boolean b) {
			bottoneInviaComunicazione.setVisible(b);
		}
		
		public void setErrore(String err){
			labelErrore.setText(err);
		}
		
		public void setVisibleErroreRiepAgente(boolean b){
			labelErrore.setVisible(b);
		}
		
//		QUESTA FUNZIONE SERVE PER ABILITARE I TOOLTIP
		public void abilitaToolTip(){
			
			TFcognome.setToolTipText(Costanti.TIP_COGNOME);
			TFnome.setToolTipText(Costanti.TIP_NOME);
			TFlivello.setToolTipText(Costanti.TIP_LIVELLO);
			TFindirizzo.setToolTipText(Costanti.TIP_INDIRIZZO);
			TFcitta.setToolTipText(Costanti.TIP_CITTA);
			TFcap.setToolTipText(Costanti.TIP_CAP);
			TFcell.setToolTipText(Costanti.TIP_CELLULARE);
			TFemail.setToolTipText(Costanti.TIP_EMAIL);
			TFusername.setToolTipText(Costanti.TIP_USERNAME);
			TFpassword.setToolTipText(Costanti.TIP_PASSWORD);
		}
		
//		QUESTA FUNZIONE SERVE PER DISABILITARE I TOOLTIP
		public void disabilitaToolTip(){
			TFcognome.setToolTipText(null);
			TFnome.setToolTipText(null);
			TFlivello.setToolTipText(null);
			TFindirizzo.setToolTipText(null);
			TFcitta.setToolTipText(null);
			TFcap.setToolTipText(null);
			TFcell.setToolTipText(null);
			TFemail.setToolTipText(null);
			TFusername.setToolTipText(null);
			TFpassword.setToolTipText(null);
		}
		

}
		


