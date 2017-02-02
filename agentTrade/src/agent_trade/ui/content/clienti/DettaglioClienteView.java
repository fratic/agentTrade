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

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
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

import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.ui.PrimaryView;

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
	
	
	/*costruttori*/
	
	public DettaglioClienteView() {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nuova scheda cliente", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		JLabel label_IMG = new JLabel("");
//		label_IMG.setBounds(24, 24, 163, 179);
//		add(label_IMG);
		label_IMG.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/Img_cliente_dettaglio.png")));
		
		
		//sono state sollevate tutte le label e le field e i bottoni SALVA e ESCI sono stati spostati in basso
		
		labelCognome = DefaultComponentFactory.getInstance().createLabel("Cognome o Ragione sociale");
		labelCognome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCognome.setPreferredSize(new Dimension(150, 14));
		pannelloCampi.add(labelCognome);
		
		TFcognome = new JTextField();
//		MODIFICA PROSSIME 4
		//TFcognome.setBounds(336, 49, 261, 20);
		TFcognome.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcognome);
		
		
		labelNome = DefaultComponentFactory.getInstance().createLabel("Nome");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNome.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelNome);
		 
		TFnome = new JTextField();
		TFnome.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFnome);
		 
		labelCodiceFiscale = DefaultComponentFactory.getInstance().createLabel("Codice Fiscale");
		labelCodiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCodiceFiscale.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCodiceFiscale);
		 
		TFcodicefiscale = new JTextField();
		TFcodicefiscale.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcodicefiscale);
		 
		labelPartitaIva = DefaultComponentFactory.getInstance().createLabel("Partita Iva");
		labelPartitaIva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPartitaIva.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelPartitaIva);

		TFpartitaiva = new JTextField();
		TFpartitaiva.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFpartitaiva);
		 
		 
		labelIndirizzo = DefaultComponentFactory.getInstance().createLabel("Indirizzo");
		labelIndirizzo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelIndirizzo.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelIndirizzo);
		 
		TFindirizzo = new JTextField();
		TFindirizzo.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFindirizzo);	
		
		
		labelCitta = DefaultComponentFactory.getInstance().createLabel("Citt\u00E0");
		labelCitta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCitta.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCitta);
		
		TFcitta = new JTextField();
		TFcitta.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcitta);
		
		labelCAP = DefaultComponentFactory.getInstance().createLabel("CAP");
		labelCAP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCAP.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCAP);
		
		TFcap = new JTextField();
		TFcap.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcap);
		
		
		labelTelefono = DefaultComponentFactory.getInstance().createLabel("Telefono: ");
		labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTelefono.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelTelefono);
		
		TFtelefono = new JTextField();
		TFtelefono.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFtelefono);
		
		
		labelCell = DefaultComponentFactory.getInstance().createLabel("Cellulare");
		labelCell.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCell.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelCell);

		TFcell = new JTextField();
		TFcell.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFcell);
		
		labelFax = DefaultComponentFactory.getInstance().createLabel("Fax: ");
		labelFax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelFax.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelFax);
		
		TFfax = new JTextField();
		TFfax.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFfax);
		 
		labelEmail = DefaultComponentFactory.getInstance().createLabel("Email: ");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEmail.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelEmail);
		 
		TFemail = new JTextField();
		TFemail.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFemail);
		
		labelRifAgente = DefaultComponentFactory.getInstance().createLabel("Agente di riferimento");
		labelRifAgente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelRifAgente.setPreferredSize(new Dimension(150,14));
		pannelloCampi.add(labelRifAgente);
		
		TFrifAgente = new JTextField();
		TFrifAgente.setEnabled(false);
		TFrifAgente.setEditable(false);
		TFrifAgente.setPreferredSize(new Dimension(261,20));
		pannelloCampi.add(TFrifAgente);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(416,14));
		pannelloCampi.add(labelErrore);
		
		pannelloOvest = new JPanel();
		pannelloOvest.setPreferredSize(new Dimension(70, 601));
		FlowLayout fl_pannelloOvest = new FlowLayout(FlowLayout.CENTER);
		pannelloOvest.setLayout(fl_pannelloOvest);
		this.add(pannelloOvest,BorderLayout.EAST);
		
		pannelloBottoni = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pannelloBottoni.getLayout();
		flowLayout_1.setVgap(15);
		pannelloBottoni.setPreferredSize(new Dimension(70, 500));//DA MODIFICARE I DUE BOTTONI SOTTO IN TEORIA NN DEVONO COMPARIRE
		pannelloOvest.add(pannelloBottoni);
		
		bottoneSalvaCliente = new JButton("");
		bottoneSalvaCliente.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/save_32.png")));
		bottoneSalvaCliente.setToolTipText("Salva il cliente");
		bottoneSalvaCliente.setPreferredSize(new Dimension(50,50));
		pannelloBottoni.add(bottoneSalvaCliente);
		
				
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(610, 499, 50, 50);
		bottoneEsci.setToolTipText("Torna indietro");
		bottoneEsci.setIcon(new ImageIcon(DettaglioClienteView.class.getResource("/agent_trade/ui/img/sign-out.png")));
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