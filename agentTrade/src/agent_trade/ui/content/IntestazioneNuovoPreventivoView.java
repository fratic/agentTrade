package agent_trade.ui.content;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.ui.PrimaryView;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class IntestazioneNuovoPreventivoView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JLabel labelCliente;
	private JLabel labelAgente;
	private JLabel labelNumPrev;
	private JLabel labelData;
	private JLabel altreInfoCliente;
	private JLabel indirizzoCliente;
	private JLabel labelPrev;
	private JLabel labelDel;
	private JLabel labelCl;
	private JLabel lblNewLabel;
	
	
	private JButton bottoneAnnulla;
	private JButton btnNewButton;
	
	private static IntestazioneNuovoPreventivoView instance;

	public IntestazioneNuovoPreventivoView() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Intestazione", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(null);

		
		labelPrev = DefaultComponentFactory.getInstance().createLabel("Preventivo n\u00B0");
		labelPrev.setBounds(488, 19, 97, 14);
		add(labelPrev);
		
		labelNumPrev = DefaultComponentFactory.getInstance().createLabel("1");
		labelNumPrev.setBounds(582, 19, 27, 14);
		add(labelNumPrev);
		
		labelDel = DefaultComponentFactory.getInstance().createLabel("del");
		labelDel.setBounds(618, 19, 40, 14);
		add(labelDel);
		
		labelData = DefaultComponentFactory.getInstance().createLabel("03/11/2015");
		labelData.setBounds(655, 19, 69, 14);
		add(labelData);
		
		 labelCl = DefaultComponentFactory.getInstance().createLabel("Cliente: ");
		labelCl.setBounds(21, 19, 69, 14);
		add(labelCl);
		
		labelCliente = DefaultComponentFactory.getInstance().createLabel("");
		labelCliente.setBounds(88, 19, 206, 14);
		add(labelCliente);
		
		bottoneAnnulla = new JButton("Annulla Preventivo");
		bottoneAnnulla.setToolTipText("Annulla il preventivo in corso");
		bottoneAnnulla.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource("/agent_trade/ui/img/close_icon.png")));
		bottoneAnnulla.setBounds(563, 69, 161, 23);
		add(bottoneAnnulla);
		
		lblNewLabel = new JLabel("effettuato dall'agente: ");
		lblNewLabel.setBounds(488, 44, 128, 14);
		add(lblNewLabel);
		
		labelAgente = new JLabel();
		labelAgente.setBounds(628, 44, 128, 14);
		add(labelAgente);
		
		indirizzoCliente = new JLabel("");
		indirizzoCliente.setBounds(88, 44, 206, 14);
		add(indirizzoCliente);
		
		altreInfoCliente = new JLabel("");
		altreInfoCliente.setBounds(88, 69, 206, 14);
		add(altreInfoCliente);
		
		btnNewButton = new JButton("Aggiungi prodotti");
		btnNewButton.setBounds(21, 106, 138, 23);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 735, 7);
		add(separator);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			PrimaryView.getInstance().selectTabCatalogo();
			ItemPreventivoView.getInstance().popolaTabProdottiItem(Ctrl_gestisciCliente.getInstance().caricaClienti());

			}
		});
		
		bottoneAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Ctrl_elaboraPreventivo.getInstance().annullaPreventivo();
			}
		});
		
	}
	
	public void setCliente(String cognome, String nome, String indirizzo, String email){
		this.labelCliente.setText(cognome+" "+nome);
		setIndirizzoCliente(indirizzo);
		setAltreInfoCliente(email);
	}
	
	public void setAgente(String a){
		this.labelAgente.setText(a);
	}
	
	public void setNumPrev(String n) {
		this.labelNumPrev.setText(n);
	}

	public void setData(String d) {
		this.labelData.setText(d);
	}
	
	public void setIndirizzoCliente(String i) {
		this.indirizzoCliente.setText(i);
	}
	
	public void setAltreInfoCliente(String a) {
		this.altreInfoCliente.setText(a);
	}
	
	public static IntestazioneNuovoPreventivoView getInstance(){
		if (instance==null)
			instance = new IntestazioneNuovoPreventivoView();
		return instance;	 
	}
}
