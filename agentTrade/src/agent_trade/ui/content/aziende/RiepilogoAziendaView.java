package agent_trade.ui.content.aziende;

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

import agent_trade.controller.Ctrl_gestisciAzienda;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;


public class RiepilogoAziendaView extends JPanel {
	
	/*attributi di classe*/
	private static RiepilogoAziendaView instance;
	
	/*attributi privati*/
	
	private JLabel labelIdAzienda;
	private JLabel labelRagioneSociale;
	private JLabel labelPartitaIva;
	private JLabel labelCodiceFiscale;
	private JLabel labelCitta;
	private JLabel labelIndirizzo;
	private JLabel labelCAP;
	private JLabel labelEmail;
	private JLabel labelTelefono;
	private JLabel labelFax;
	private JLabel labelUrl;
	
	private JLabel labelErrore;
	
	private JTextField TFidAzienda;
	private JTextField TFRagioneSociale;
	private JTextField TFPartitaIva;
	private JTextField TFCodiceFiscale;
	private JTextField TFcitta;
	private JTextField TFindirizzo;
	private JTextField TFcap;
	private JTextField TFemail;
	private JTextField TFTelefono;
	private JTextField TFFax;
	private JTextField TFUrl;
	
	private JButton bottoneModificaAzienda;
	private JButton bottoneCancellaAzienda;
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
	private JPanel pannIdAzienda;
	private JPanel pannRagSoc;
	private JPanel pannCodFis;
	private JPanel pannPIva;
	private JPanel pannIndirizzo;
	private JPanel pannCitta;
	private JPanel pannCap;
	private JPanel pannTelefono;
	private JPanel pannEmail;
	private JPanel pannFax;
	private JPanel pannUrl;
	private JPanel pannErrore;
	private JPanel pannelloEast;
	
	/*costruttori*/
	
	public RiepilogoAziendaView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_SCHEDA_AZIENDA, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		label_IMG.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.RIEPILOGO_AZIENDA_ICON)));
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

		
		pannIdAzienda = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannIdAzienda.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannIdAzienda.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannIdAzienda);
		
		labelIdAzienda = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID_AZIENDA);
		labelIdAzienda.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelIdAzienda.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannIdAzienda.add(labelIdAzienda);

		
		TFidAzienda = new JTextField();
		TFidAzienda.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFidAzienda.setEditable(false);
		pannIdAzienda.add(TFidAzienda);

		pannRagSoc = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannRagSoc.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannRagSoc.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannRagSoc);
		
		labelRagioneSociale = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NOME_AZIENDA);
		labelRagioneSociale.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelRagioneSociale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannRagSoc.add(labelRagioneSociale);
				
		TFRagioneSociale = new JTextField();
		TFRagioneSociale.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFRagioneSociale.setEditable(false);
		pannRagSoc.add(TFRagioneSociale);

		pannPIva = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) pannPIva.getLayout();
		flowLayout5.setHgap(0);
		flowLayout5.setVgap(0);
		pannPIva.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannPIva);
		
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PARTITA_IVA);
		labelPartitaIva.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelPartitaIva.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannPIva.add(labelPartitaIva);
		 
		TFPartitaIva = new JTextField();
		TFPartitaIva.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFPartitaIva.setEditable(false);
		pannPIva.add(TFPartitaIva);
		
		pannCodFis = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) pannCodFis.getLayout();
		flowLayout4.setHgap(0);
		flowLayout4.setVgap(0);
		pannCodFis.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCodFis);
		
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_COD_FISC);
		labelCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCodiceFiscale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCodFis.add(labelCodiceFiscale);

		TFCodiceFiscale = new JTextField();
		TFCodiceFiscale.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFCodiceFiscale.setEditable(false);
		pannCodFis.add(TFCodiceFiscale);
		 
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
	
		pannTelefono = new JPanel();
		FlowLayout flowLayout11 = (FlowLayout) pannTelefono.getLayout();
		flowLayout11.setHgap(0);
		flowLayout11.setVgap(0);
		pannTelefono.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannTelefono);
		
		labelTelefono = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TELEFONO);
		labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelTelefono.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannTelefono.add(labelTelefono);
		
		TFTelefono = new JTextField();
		TFTelefono.setEditable(false);
		TFTelefono.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		pannTelefono.add(TFTelefono);
		 
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
		
		pannFax = new JPanel();
		FlowLayout flowLayout14 = (FlowLayout) pannFax.getLayout();
		flowLayout14.setHgap(0);
		flowLayout14.setVgap(0);
		pannFax.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannFax);
		
		labelFax = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_FAX);
		labelFax.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelFax.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannFax.add(labelFax);
		 
		TFFax = new JTextField();
		TFFax.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFFax.setEditable(false);
		pannFax.add(TFFax);
		
		pannUrl = new JPanel();
		FlowLayout flowLayout16 = (FlowLayout) pannUrl.getLayout();
		flowLayout16.setHgap(0);
		flowLayout16.setVgap(0);
		pannUrl.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannUrl);
		
		labelUrl = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_URL_AZIENDA);
		labelUrl.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelUrl.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannUrl.add(labelUrl);
		 
		TFUrl = new JTextField();
		TFUrl.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFUrl.setEditable(false);
		pannUrl.add(TFUrl);
		
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
		bottoneInviaComunicazione.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.COMUNICAZIONE_AZIENDA_ICON)));
		
		bottoneModificaAzienda = new JButton("");
		bottoneModificaAzienda.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneModificaAzienda);
		bottoneModificaAzienda.setToolTipText(Costanti.TIP_MODIFICA_AZIENDA);
		bottoneModificaAzienda.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.MOD_AZIENDA_ICON)));
		
		bottoneCancellaAzienda = new JButton("");
		bottoneCancellaAzienda.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneCancellaAzienda);
		bottoneCancellaAzienda.setToolTipText(Costanti.TIP_CANCELLA_AZIENDA);
		bottoneCancellaAzienda.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.CANC_AZIENDA_ICON)));
		
		bottoneSalvaModifiche = new JButton("");
		bottoneSalvaModifiche.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaModifiche);
		bottoneSalvaModifiche.setToolTipText(Costanti.TIP_SALVA_MOD_AZIENDA);
		bottoneSalvaModifiche.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.SALVA_MOD_AZIENDA_ICON)));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaModifica);
		bottoneAnnullaModifica.setToolTipText(Costanti.TIP_ANNULLA_MOD_AZIENDA);
		bottoneAnnullaModifica.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.ANNULLA_MOD_AZIENDA_ICON)));
		

		
		bottoneModificaAzienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciAzienda.getInstance().abilitaModifica();
			}
		});
		
		bottoneCancellaAzienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Ctrl_gestisciAzienda.getInstance().cancellaAzienda((String)TFidAzienda.getText());
			}
		});
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAzienda.getInstance().modificaAzienda(Integer.parseInt(TFidAzienda.getText()),(String)TFRagioneSociale.getText(), (String)TFPartitaIva.getText(), (String)TFCodiceFiscale.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFTelefono.getText(), (String)TFFax.getText(), (String)TFUrl.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				try {
					Ctrl_gestisciAzienda.getInstance().annullaModificheAzienda(TFidAzienda.getText());
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
	
	public static RiepilogoAziendaView getInstance(){
		if (instance==null)
			instance = new RiepilogoAziendaView();
		return instance;	 
		}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public void setRiepilogoAzienda(String id, String ragSoc, String codFis, String PIva, String citta, String cap, String indirizzo, String email, String tel, String fax, String url ) {
		
		this.TFidAzienda.setText(id);
		this.TFRagioneSociale.setText(ragSoc);
		this.TFCodiceFiscale.setText(codFis);
		this.TFPartitaIva.setText(PIva);
		this.TFcitta.setText(citta);
		this.TFcap.setText(cap);
		this.TFindirizzo.setText(indirizzo);
		this.TFemail.setText(email);
		this.TFTelefono.setText(tel);
		this.TFFax.setText(fax);
		this.TFUrl.setText(url);
		}
	
	//questo metodo rende le TF modificabili per effettuare update dei dati
	public void setTFeditable(boolean b) {
		TFRagioneSociale.setEditable(b);
		TFCodiceFiscale.setEditable(b);
		TFPartitaIva.setEditable(b);
		TFcitta.setEditable(b);
		TFcap.setEditable(b);
		TFindirizzo.setEditable(b);
		TFemail.setEditable(b);
		TFTelefono.setEditable(b);
		TFFax.setEditable(b);
		TFUrl.setEditable(b);
	}
	
	public void resetCampiModifica(){
		setTFeditable(false);
	}
	
	public void setVisibleBtnModifiche(boolean b){
		bottoneModificaAzienda.setVisible(b);
	}
	
	public void setVisibleBtnSalvaModifiche(boolean b){
		bottoneSalvaModifiche.setVisible(b);
	}
	
	public void setVisibleBtnAnnullaModifiche(boolean b){
		bottoneAnnullaModifica.setVisible(b);
	}
	
	public void setVisibleBtnCancella(boolean b) {
		bottoneCancellaAzienda.setVisible(b);
	}
	
	public void setVisibleBtnInviaPosta(boolean b) {
		bottoneInviaComunicazione.setVisible(b);
	}
	
	public void setErrore(String err){
		labelErrore.setText(err);
	}
	
	public void setVisibleErroreRiepAzienda(boolean b){
		labelErrore.setVisible(b);
	}
	
	public void abilitaToolTip(){
		
		TFRagioneSociale.setToolTipText(Costanti.TIP_NOME_AZIENDA);
		TFCodiceFiscale.setToolTipText(Costanti.TIP_COD_FIS);
		TFPartitaIva.setToolTipText(Costanti.TIP_PARTITA_IVA);
		TFindirizzo.setToolTipText(Costanti.TIP_INDIRIZZO);
		TFcitta.setToolTipText(Costanti.TIP_CITTA);
		TFcap.setToolTipText(Costanti.TIP_CAP);
		TFTelefono.setToolTipText(Costanti.TIP_TELEFONO);
		TFemail.setToolTipText(Costanti.TIP_EMAIL);
		TFFax.setToolTipText(Costanti.TIP_FAX);
		TFUrl.setToolTipText(Costanti.TIP_URL_AZIENDA);
	}

	public void disabilitaToolTip(){
		TFRagioneSociale.setToolTipText(null);
		TFCodiceFiscale.setToolTipText(null);
		TFPartitaIva.setToolTipText(null);
		TFindirizzo.setToolTipText(null);
		TFcitta.setToolTipText(null);
		TFcap.setToolTipText(null);
		TFTelefono.setToolTipText(null);
		TFemail.setToolTipText(null);
		TFFax.setToolTipText(null);
		TFUrl.setToolTipText(null);
	}
	
}
