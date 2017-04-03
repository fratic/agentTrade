package agent_trade.ui.content.aziende;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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


public class DettaglioAziendaView extends JPanel {
	
/*attributi di classe*/
	
	private static DettaglioAziendaView instance;
	
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
	
	private JButton bottoneSalvaAzienda;
	private JButton bottoneEsci;
	
	private JPanel pannelloCentro;
	private JScrollPane scrollPane;
	private JPanel pannelloCampi;
	private JPanel pannelloBottoni;
	private JPanel pannelloContenitore;
	private JPanel pannelloIcona;
	private Container contenitoreCampi;
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
	
	public DettaglioAziendaView(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_NUOVA_AZIENDA, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		label_IMG.setIcon(new ImageIcon(RiepilogoAziendaView.class.getResource(Costanti.DETTAGLIO_AZIENDA_ICON)));
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
		TFRagioneSociale.setToolTipText(Costanti.TIP_NOME_AZIENDA);
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
		TFPartitaIva.setToolTipText(Costanti.TIP_PARTITA_IVA);
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
		TFCodiceFiscale.setToolTipText(Costanti.TIP_COD_FIS_AZIENDA);
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
		TFindirizzo.setToolTipText(Costanti.TIP_INDIRIZZO);
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
		TFcitta.setToolTipText(Costanti.TIP_CITTA);
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
		TFcap.setToolTipText(Costanti.TIP_CAP);
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
		TFTelefono.setToolTipText(Costanti.TIP_TELEFONO);
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
		TFemail.setToolTipText(Costanti.TIP_EMAIL);
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
		TFFax.setToolTipText(Costanti.TIP_FAX);
		pannFax.add(TFFax);
		
		pannUrl = new JPanel();
		FlowLayout flowLayout16 = (FlowLayout) pannUrl.getLayout();
		flowLayout16.setHgap(0);
		flowLayout16.setVgap(0);
		pannUrl.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannUrl);
		
		labelFax = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_URL_AZIENDA);
		labelFax.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelFax.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannUrl.add(labelFax);
		 
		TFUrl = new JTextField();
		TFUrl.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFUrl.setToolTipText(Costanti.TIP_URL_AZIENDA);
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
		
		bottoneSalvaAzienda = new JButton("");
		bottoneSalvaAzienda.setIcon(new ImageIcon(DettaglioAziendaView.class.getResource(Costanti.SALVA_AZIENDA_ICON)));
		bottoneSalvaAzienda.setToolTipText(Costanti.TIP_SALVA_AZIENDA);
		bottoneSalvaAzienda.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaAzienda);
					
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(610, 499, Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON);
		bottoneEsci.setToolTipText(Costanti.TIP_TORNA_INDIETRO);
		bottoneEsci.setIcon(new ImageIcon(DettaglioAziendaView.class.getResource(Costanti.INDIETRO_ICON)));
		pannelloBottoni.add(bottoneEsci);
				
		bottoneSalvaAzienda.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Ctrl_gestisciAzienda.getInstance().inserisciNuovaAzienda((String)TFRagioneSociale.getText(), (String)TFPartitaIva.getText(), (String)TFCodiceFiscale.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFTelefono.getText(), (String)TFFax.getText(), (String)TFUrl.getText());

			} 
			catch (PersistentException e) {
				e.printStackTrace();
			}

		}	
		});
	
		
		bottoneEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciAzienda.getInstance().esciNewAzienda();
			}
		});
			
	}
	
	/*metodi di classe*/
	
	public static DettaglioAziendaView getInstance(){
		if (instance==null)
			instance = new DettaglioAziendaView();
		return instance;	 
		}
	
	
	/*metodi pubblici*/
	
	public void setErrore(String err) {
		labelErrore.setText(err);
    }

	public void setVisibleErroreNuovaAzienda(boolean b){
		labelErrore.setVisible(b);
	}
		
	public void resetNewAzienda(){
		TFRagioneSociale.setText(null);
		TFPartitaIva.setText(null);
		TFCodiceFiscale.setText(null);
		TFcitta.setText(null);
		TFindirizzo.setText(null);
		TFcap.setText(null);
		TFemail.setText(null);
		TFTelefono.setText(null);
		TFFax.setText(null);
		TFUrl.setText(null);
	}
	
	
}
