//package agent_trade.ui.content.clienti;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.border.TitledBorder;
//
//import com.jgoodies.forms.factories.DefaultComponentFactory;
//
//import agent_trade.controller.Ctrl_gestisciCliente;
//
//import java.awt.Color;
//import java.awt.SystemColor;
//
//import javax.swing.DropMode;
//
//import org.orm.PersistentException;
//
//public class DettaglioClienteView extends JPanel {
//
//	/*attributi di classe*/
//	
//	private static DettaglioClienteView instance;
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
//	private JButton bottoneSalvaCliente;
//	private JButton bottoneAnnullaInserimento;
//	private JButton bottoneEsci;
//	
//	/*costruttori*/
//	
//	public DettaglioClienteView() {
//		
//		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuova scheda cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
//		setBackground(UIManager.getColor("CheckBox.background"));
//		
//		setLayout(null);
//		
//		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome: ");
//		labelNome.setBounds(43, 47, 69, 14);
//		add(labelNome);
//		 
//		TFnome = new JTextField();
//		TFnome.setBounds(178, 44, 261, 20);
//		add(TFnome);
//		 TFnome.setColumns(10);
//		 
//		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome: ");
//		labelCognome.setBounds(43, 90, 69, 14);
//		add(labelCognome);
//		 
//		TFcognome = new JTextField();
//		TFcognome.setBounds(178, 87, 261, 20);
//		add(TFcognome);
//		TFcognome.setColumns(10);
//		 
//		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale: ");
//		labelCodiceFiscale.setBounds(43, 133, 111, 14);
//		add(labelCodiceFiscale);
//		 
//		TFcodicefiscale = new JTextField();
//		TFcodicefiscale.setBounds(178, 130, 261, 20);
//		add(TFcodicefiscale);
//		TFcodicefiscale.setColumns(10);
//		 
//		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("Partita Iva: ");
//		labelPartitaIva.setBounds(43, 176, 69, 14);
//		add(labelPartitaIva);
//		 
//		TFpartitaiva = new JTextField();
//		TFpartitaiva.setBounds(178, 173, 261, 20);
//		add(TFpartitaiva);
//		TFpartitaiva.setColumns(10);
//		 
//		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo: ");
//		labelIndirizzo.setBounds(44, 219, 69, 14);
//		add(labelIndirizzo);
//		 
//		TFindirizzo = new JTextField();
//		TFindirizzo.setBounds(178, 216, 261, 20);
//		add(TFindirizzo);
//		TFindirizzo.setColumns(10);
//		 
//		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
//		labelEmail.setBounds(43, 262, 69, 14);
//		add(labelEmail);
//		 
//		TFemail = new JTextField();
//		TFemail.setBounds(178, 259, 261, 20);
//		add(TFemail);
//		TFemail.setColumns(10);
//		 
//		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
//		labelTelefono.setBounds(43, 305, 69, 14);
//		add(labelTelefono);
//		 
//		TFtelefono = new JTextField();
//		TFtelefono.setBounds(178, 302, 261, 20);
//		add(TFtelefono);
//		TFtelefono.setColumns(10);
//		 
//		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
//		labelFax.setBounds(43, 348, 69, 14);
//		add(labelFax);
//		 
//		TFfax = new JTextField();
//		TFfax.setBounds(178, 345, 261, 20);
//		add(TFfax);
//		TFfax.setColumns(10);
//		
//		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
//		labelErrore.setBounds(43, 376, 219, 20);
//		add(labelErrore);
//		
//		bottoneSalvaCliente = new JButton("Salva");
//		bottoneSalvaCliente.setBounds(41, 418, 113, 30);
//		add(bottoneSalvaCliente);
//		bottoneSalvaCliente.setToolTipText("Salva il cliente");
//		bottoneSalvaCliente.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save-user.png")));
//		
//		bottoneAnnullaInserimento = new JButton("Annulla");
//		bottoneAnnullaInserimento.setBounds(206, 418, 113, 30);
//		add(bottoneAnnullaInserimento);
//		bottoneAnnullaInserimento.setToolTipText("Pulisci form");
//		bottoneAnnullaInserimento.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/close_icon.png")));
//		
//		bottoneEsci = new JButton("Esci");
//		bottoneEsci.setBounds(371, 418, 113, 30);
//		add(bottoneEsci);
//		bottoneEsci.setToolTipText("Torna indietro");
//		bottoneEsci.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/arrow_icon.png")));
//		
//		bottoneSalvaCliente.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					Ctrl_gestisciCliente.getInstance().inserisciNuovoCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFfax.getText());
//				} catch (PersistentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}	
//		});
//		
//		bottoneAnnullaInserimento.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Ctrl_gestisciCliente.getInstance().annullaNewCliente();
//			}
//		});
//		
//		bottoneEsci.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Ctrl_gestisciCliente.getInstance().esciNewCliente();
//			}
//		});
//			
//
//		
//	}
//		
//	/*metodi di classe*/
//		
//	public static DettaglioClienteView getInstance(){
//		if (instance==null)
//			instance = new DettaglioClienteView();
//		return instance;	 
//		}
//	
//	public void setErrore(String err) {
//		labelErrore.setText(err);
//    }
//	
//	public void setVisibleErroreNuovoCliente(boolean b){
//		labelErrore.setVisible(b);
//	}
//		
//	public void resetNewCliente(){
//		TFcognome.setText(null);
//		TFnome.setText(null);
//		TFcodicefiscale.setText(null);
//		TFpartitaiva.setText(null);
//		TFindirizzo.setText(null);
//		TFemail.setText(null);
//		TFtelefono.setText(null);
//		TFfax.setText(null);
//	}
//}

package agent_trade.ui.content.clienti;

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

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.util.Costanti;

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
	//private JButton bottoneAnnullaInserimento;
	private JButton bottoneEsci;
	
	private JPanel pannelloCentro;

	private JScrollPane scrollPane;

	private JPanel pannelloCampi;

	private JPanel pannelloOvest;

	private JPanel pannelloBottoni;

	private JPanel pannelloContenitore;

	private JPanel pannelloIcona;

	private Container contenitoreCampi;

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

	private JPanel pannRifAgente ;

	private JPanel pannErrore;

	private JPanel pannelloEast;
	
	
	/*costruttori*/
	
	public DettaglioClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),  Costanti.TITOLO_NUOVO_CLIENTE, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		label_IMG.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.DETTAGLIO_CLIENTE_ICON)));
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
		
		//sono state sollevate tutte le label e le field e i bottoni SALVA e ESCI sono stati spostati in basso
		
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
		
		labelNome = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NOME_CLIENTE);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelNome.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannNome.add(labelNome);
		 
		TFnome = new JTextField();
		TFnome.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFnome.setToolTipText(Costanti.TIP_NOME_CLIENTE);
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
		TFcodicefiscale.setToolTipText(Costanti.TIP_COD_FIS);
		pannCodFis.add(TFcodicefiscale);
		
		pannPartitaIva = new JPanel();
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
		TFpartitaiva.setToolTipText(Costanti.TIP_PARTITA_IVA);
		pannPartitaIva.add(TFpartitaiva);
		 
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
		
		pannTelefono = new JPanel();
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
		TFtelefono.setToolTipText(Costanti.TIP_TELEFONO);
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
		TFcell.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFcell.setToolTipText(Costanti.TIP_CELLULARE);
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
		TFfax.setToolTipText(Costanti.TIP_FAX);
		pannFax.add(TFfax);
		
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
		
		pannRifAgente = new JPanel();
		FlowLayout flowLayout14 = (FlowLayout) pannRifAgente.getLayout();
		flowLayout14.setHgap(0);
		flowLayout14.setVgap(0);
		pannRifAgente.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannRifAgente);
		
		labelRifAgente = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_AGENTE_RIF);
		labelRifAgente.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelRifAgente.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannRifAgente.add(labelRifAgente);
		
		TFrifAgente = new JTextField((Ctrl_System.getAgenteLog().getCognome()+" "+Ctrl_System.getAgenteLog().getNome()));
		TFrifAgente.setEditable(false);
		TFrifAgente.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		pannRifAgente.add(TFrifAgente);
		
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
		
		bottoneSalvaCliente = new JButton("");
		bottoneSalvaCliente.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.SALVA_CLIENTI_ICON)));
		bottoneSalvaCliente.setToolTipText(Costanti.TIP_SALVA_CLIENTE);
		bottoneSalvaCliente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaCliente);
		
				
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(610, 499, Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON);
		bottoneEsci.setToolTipText(Costanti.TIP_TORNA_INDIETRO);
		bottoneEsci.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.INDIETRO_ICON)));
		pannelloBottoni.add(bottoneEsci);
				
		
//		bottoneAnnullaInserimento = new JButton("");
//		bottoneAnnullaInserimento.setBounds(655, 413, 50, 50);
//		bottoneAnnullaInserimento.setToolTipText("Pulisci form");
//		bottoneAnnullaInserimento.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/clean-form.png")));
//		add(bottoneAnnullaInserimento);
		
		
		bottoneSalvaCliente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Ctrl_gestisciCliente.getInstance().inserisciNuovoCliente((String)TFnome.getText(), (String)TFcognome.getText(), (String)TFcodicefiscale.getText(), (String)TFpartitaiva.getText(), (String)TFcitta.getText(), (String)TFcap.getText(), (String)TFindirizzo.getText(), (String)TFemail.getText(), (String)TFtelefono.getText(), (String)TFcell.getText(), (String)TFfax.getText());

			} 
			catch (PersistentException e) {
				e.printStackTrace();
			}

		}	
		});
	
		
		bottoneEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().esciNewCliente();
			}
		});
		
		
		
//		bottoneAnnullaInserimento.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent arg0) {
//			Ctrl_gestisciCliente.getInstance().annullaNewCliente();
//		}
//	});
				
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