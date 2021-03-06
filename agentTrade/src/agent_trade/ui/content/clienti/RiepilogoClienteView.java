package agent_trade.ui.content.clienti;

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

import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.model.M_Agente;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.util.Costanti;

public class RiepilogoClienteView extends JPanel {

	/*attributi di classe*/
	
	private static RiepilogoClienteView instance;
	public static M_Cliente cliente;
	
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
	private JLabel labelSconto;
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
	private JTextField TFsconto;
	private JTextField TFrifAgente;
	
	private JButton bottoneModificaCliente;
	private JButton bottoneCancellaCliente;
//	private JButton bottoneBackToRicerca;
	private JButton bottoneSalvaModifiche;
	private JButton bottoneAnnullaModifica;
	private JButton bottoneInviaComunicazione;
	private JButton bottoneModificaSconto;
	private JButton bottoneModificaAgente;
	
	private JPanel pannelloCampi;
	private JPanel pannelloBottoni;
	private JPanel pannelloCentro;
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
	private JPanel pannSconto;
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
		flowLayout1.setVgap(13);
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
		
		pannSconto = new JPanel();
		FlowLayout flowLayout16 = (FlowLayout) pannSconto.getLayout();
		flowLayout16.setHgap(0);
		flowLayout16.setVgap(0);
		pannSconto.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannSconto);
		 
		labelSconto = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_SCONTO);
		labelSconto.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelSconto.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannSconto.add(labelSconto);
		 
		TFsconto = new JTextField();//NON E' EDITABILE VERRA' CARICATO UNO SCONTO INIZIALE
		TFsconto.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFsconto.setEditable(false);
		pannSconto.add(TFsconto);
		
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
		bottoneSalvaModifiche.setToolTipText(Costanti.TIP_SALVA_MOD_CLIENTE);
		bottoneSalvaModifiche.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.SALVA_MOD_CLIENTE_ICON)));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaModifica);
		bottoneAnnullaModifica.setToolTipText(Costanti.TIP_ANNULLA_MOD_CLIENTE);
		bottoneAnnullaModifica.setIcon(new ImageIcon(DettaglioClienteView.class.getResource(Costanti.ANNULLA_MOD_CLIENTE_ICON)));
		
		
		bottoneModificaSconto = new JButton("");
		bottoneModificaSconto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		bottoneModificaSconto.setToolTipText(Costanti.TIP_MOD_SCONTO_CLIENTE);
		bottoneModificaSconto.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource(Costanti.MOD_SCONTO_CLIENTE_ICON)));
//		bottoneModificaSconto.setVisible(false);
		pannelloBottoni.add(bottoneModificaSconto);
			
		bottoneModificaAgente = new JButton("");
		bottoneModificaAgente.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		bottoneModificaAgente.setToolTipText(Costanti.TIP_MOD_AGENTE_CLIENTE);
		bottoneModificaAgente.setIcon(new ImageIcon(RiepilogoClienteView.class.getResource(Costanti.MOD_AGENTE_CLIENTE_ICON)));
//		bottoneModificaAgente.setVisible(false);
		pannelloBottoni.add(bottoneModificaAgente);

		
		bottoneModificaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciClienteFactory.getInstance().abilitaModifica();
			}
		});
		
		bottoneCancellaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Ctrl_gestisciClienteFactory.getInstance().cancellaCliente((String)TFidCliente.getText());
			}
		});
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					cliente.setNome(TFnome.getText());
					cliente.setCognome(TFcognome.getText());
					cliente.setCodice_fiscale(TFcodicefiscale.getText());
					cliente.setPartita_iva(TFpartitaiva.getText());
					cliente.setCitta(TFcitta.getText());
					cliente.setCAP(TFcap.getText());
					cliente.setIndirizzo(TFindirizzo.getText());
					cliente.setEmail(TFemail.getText());
					cliente.setTelefono(TFtelefono.getText());
					cliente.setCell(TFcell.getText());
					cliente.setFax(TFfax.getText());
					cliente.setVersione(cliente.getVersione());
					cliente.setIdclienteagente(cliente.getIdCliente());
					Ctrl_gestisciClienteFactory.getInstance().modificaCliente(cliente);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			try {
				Ctrl_gestisciClienteFactory.getInstance().annullaModificheCliente(TFidCliente.getText());
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
		
		
		bottoneModificaSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciClienteFactory.getInstance().btnCercaSconto();
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});


		bottoneModificaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciClienteFactory.getInstance().btnCercaAgente();
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
				}
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
		public void setRiepilogoCliente(M_Cliente c) {
			
			cliente = c;
			
			this.TFidCliente.setText(Integer.toString(cliente.getIdCliente()));
			this.TFcognome.setText(cliente.getCognome());
			this.TFnome.setText(cliente.getNome());
			this.TFcodicefiscale.setText(cliente.getCodice_fiscale());
			this.TFpartitaiva.setText(cliente.getPartita_iva());
			this.TFindirizzo.setText(cliente.getIndirizzo());
			this.TFcitta.setText(cliente.getCitta());
			this.TFcap.setText(cliente.getCAP());
			this.TFtelefono.setText(cliente.getTelefono());
			this.TFcell.setText(cliente.getCell());
			this.TFfax.setText(cliente.getFax());
			this.TFemail.setText(cliente.getEmail());
			this.TFrifAgente.setText(cliente.getAgenteAssociato().getCognome()+" "+cliente.getAgenteAssociato().getNome());

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
		
		
//		cambia le label che sono obbligatorie a seconda che siano da modificare o meno
		public void setLabel(boolean b){
			if (b){
				labelCognome.setText(Costanti.LABEL_COGNOME_OBB);
				labelNome.setText(Costanti.LABEL_NOME_CLIENTE_OBB);
				labelCodiceFiscale.setText(Costanti.LABEL_COD_FISC_OBB);
				labelPartitaIva.setText(Costanti.LABEL_PARTITA_IVA_OBB);
				labelCitta.setText(Costanti.LABEL_CITTA_OBB);
				labelCAP.setText(Costanti.LABEL_CAP_OBB);
				labelIndirizzo.setText(Costanti.LABEL_INDIRIZZO_OBB);
				labelCell.setText(Costanti.LABEL_CELLULARE_OBB);
			}
			else{
				labelCognome.setText(Costanti.LABEL_COGNOME);
				labelNome.setText(Costanti.LABEL_NOME_CLIENTE);
				labelCodiceFiscale.setText(Costanti.LABEL_COD_FISC);
				labelPartitaIva.setText(Costanti.LABEL_PARTITA_IVA);
				labelCitta.setText(Costanti.LABEL_CITTA);
				labelCAP.setText(Costanti.LABEL_CAP);
				labelIndirizzo.setText(Costanti.LABEL_INDIRIZZO);
				labelCell.setText(Costanti.LABEL_CELLULARE);
			}
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
		

//		public void setScontoCliente(String sconto) {
//			TFsconto.setText(sconto);			
//		}
		
		public void setScontoCliente(M_Sconto sconto) throws PersistentException {
			
			String scnt = "0%";
			
			if (sconto instanceof M_ScontoCliente){
				scnt = ((M_ScontoCliente) sconto).getPercent()*100 + "%"; 
			}
			
			TFsconto.setText(scnt);	
			
//			if(Costanti.version.equals(Costanti.mandante)){
//				
//				cliente.setSconto(sconto.getId());
//				
////				Ctrl_gestisciClienteFactory.getInstance().modificaCliente(cliente);
//			}
		}		
		
		public void setVisibleBtnModSconto(boolean b) {
			bottoneModificaSconto.setVisible(b);
		}
				
				
		public void setVisibleBtnModAgente(boolean b) {
			bottoneModificaAgente.setVisible(b);
		}


		public void setAgenteRif(M_Agente agenteRif) throws PersistentException{
			
//			cliente.setAgenteAssociato(agenteRif);
			
//			TFrifAgente.setText(cliente.getAgenteAssociato().getCognome()+" "+cliente.getAgenteAssociato().getNome());
			TFrifAgente.setText(agenteRif.getCognome()+" "+agenteRif.getNome());

//			Ctrl_gestisciClienteFactory.getInstance().modificaCliente(cliente);
		}
}
		


