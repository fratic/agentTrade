package ui.content.agenti;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

//import controller.Ctrl_System;
import controller.Ctrl_gestisciAgente;
import ui.PrimaryView;
import util.Costanti;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;

import org.orm.PersistentException;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

public class DettaglioAgenteView extends JPanel {

	/*attributi di classe*/
	
	private static DettaglioAgenteView instance;
	
	/*attributi privati*/
	
	//private JLabel labelIdAgente;
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
	
	//private JTextField TFidCliente;
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
	
	private JButton bottoneSalvaAgente;
	//private JButton bottoneAnnullaInserimento;
	private JButton bottoneEsci;
	
	private JPanel pannelloCentro;

	private JScrollPane scrollPane;

	private JPanel pannelloCampi;

//	private JPanel pannelloOvest;

	private JPanel pannelloBottoni;

	private JPanel pannelloContenitore;

	private JPanel pannelloIcona;

	private Container contenitoreCampi;

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
	
	public DettaglioAgenteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),  Costanti.TITOLO_NUOVO_AGENTE, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
//		label_IMG.setBounds(24, 24, 163, 179);
		label_IMG.setPreferredSize(new Dimension(Costanti.WIDTH_ICON, Costanti.HEIGHT_ICON));
		label_IMG.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.DETTAGLIO_AGENTE_ICON)));
		pannelloIcona.add(label_IMG);
				
		pannelloCampi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pannelloCampi.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		pannelloCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloContenitore.add(pannelloCampi, BorderLayout.CENTER);
	
		contenitoreCampi = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) contenitoreCampi.getLayout();
		flowLayout2.setVgap(15);
		flowLayout2.setHgap(0);
		flowLayout2.setAlignment(FlowLayout.CENTER);
		contenitoreCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCampi.add(contenitoreCampi);
		
		
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
		TFcognome.setToolTipText(Costanti.TIP_COGNOME);
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
		TFnome.setToolTipText(Costanti.TIP_NOME);
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
		TFlivello.setToolTipText(Costanti.TIP_LIVELLO);
		pannLivello.add(TFlivello);
		 
		pannIndirizzo = new JPanel();
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
		
		pannCitta = new JPanel();
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
		TFcitta.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFcitta.setToolTipText(Costanti.TIP_CITTA);
		pannCitta.add(TFcitta);
		
		pannCap = new JPanel();
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
		TFcap.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFcap.setToolTipText(Costanti.TIP_CAP);
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
		TFcell.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFcell.setToolTipText(Costanti.TIP_CELLULARE);
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
		TFemail.setToolTipText(Costanti.TIP_EMAIL);
		pannEmail.add(TFemail);
		
		pannUsername = new JPanel();
		FlowLayout flowLayout6 = (FlowLayout) pannUsername.getLayout();
		flowLayout6.setHgap(0);
		flowLayout6.setVgap(0);
		pannUsername.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannUsername);
		 
		labelUsername = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_USERNAME);
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelUsername.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannUsername.add(labelUsername);

		TFusername = new JTextField();
		TFusername.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFusername.setToolTipText(Costanti.TIP_USERNAME);
		pannUsername.add(TFusername);
		
		pannPassword = new JPanel();
		FlowLayout flowLayout14 = (FlowLayout) pannPassword.getLayout();
		flowLayout14.setHgap(0);
		flowLayout14.setVgap(0);
		pannPassword.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannPassword);
		 
		labelPassword = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PASSWORD);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelPassword.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannPassword.add(labelPassword);

		TFpassword = new JTextField();
		TFpassword.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFpassword.setToolTipText(Costanti.TIP_PASSWORD);
		pannPassword.add(TFpassword);
		
		
		pannErrore= new JPanel();
		FlowLayout flowLayout15 = (FlowLayout) pannErrore.getLayout();
		flowLayout15.setHgap(0);
		flowLayout15.setVgap(0);
		pannErrore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL_ERRORE, Costanti.HEIGHT_PANN_LABEL_ERRORE));
		contenitoreCampi.add(pannErrore);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(426,15));
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
		
		bottoneSalvaAgente = new JButton("");
		bottoneSalvaAgente.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.SALVA_AGENTI_ICON)));
		bottoneSalvaAgente.setToolTipText(Costanti.TIP_SALVA_AGENTE);
		bottoneSalvaAgente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaAgente);
		
				
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(610, 499, Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON);
		bottoneEsci.setToolTipText(Costanti.TIP_TORNA_INDIETRO);
		bottoneEsci.setIcon(new ImageIcon(DettaglioAgenteView.class.getResource(Costanti.INDIETRO_ICON)));
		pannelloBottoni.add(bottoneEsci);
				
		
//		bottoneAnnullaInserimento = new JButton("");
//		bottoneAnnullaInserimento.setBounds(655, 413, 50, 50);
//		bottoneAnnullaInserimento.setToolTipText("Pulisci form");
//		bottoneAnnullaInserimento.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/clean-form.png")));
//		add(bottoneAnnullaInserimento);
		
		
		bottoneSalvaAgente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Ctrl_gestisciAgente.getInstance().inserisciNuovoAgente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFlivello.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFcell.getText(), (String)TFusername.getText(), (String)TFpassword.getText());

			} 
			catch (PersistentException e) {
				e.printStackTrace();
			}

		}	
		});
	
		
		bottoneEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciAgente.getInstance().esciNewAgente();
			}
		});
		
		
		
//		bottoneAnnullaInserimento.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent arg0) {
//			Ctrl_gestisciCliente.getInstance().annullaNewCliente();
//		}
//	});
				
	}
		
	/*metodi di classe*/
		
	public static DettaglioAgenteView getInstance(){
		if (instance==null)
			instance = new DettaglioAgenteView();
		return instance;	 
		}
	
	
	/*metodi pubblici*/
	
	public void setErrore(String err) {
		labelErrore.setText(err);
    }
	
	public void setVisibleErroreNuovoAgente(boolean b){
		labelErrore.setVisible(b);
	}
		
	public void resetNewAgente(){
		TFcognome.setText(null);
		TFnome.setText(null);
		TFlivello.setText(null);
		TFcitta.setText(null);
		TFindirizzo.setText(null);
		TFcap.setText(null);
		TFemail.setText(null);
		TFcell.setText(null);
		TFusername.setText(null);
		TFpassword.setText(null);
	}
}