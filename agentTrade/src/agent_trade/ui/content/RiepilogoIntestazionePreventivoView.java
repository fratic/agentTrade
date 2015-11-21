package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class RiepilogoIntestazionePreventivoView extends JPanel 
{
	/*attributi di classe*/
	
	private static RiepilogoIntestazionePreventivoView instance;
	
	/*attributi privati*/
	
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
	private JButton bottoneModifica;

	
	/*costruttori*/
	
	public RiepilogoIntestazionePreventivoView() {
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
		
		bottoneAnnulla = new JButton("Conferma Ordine");
		bottoneAnnulla.setToolTipText("Annulla il preventivo in corso");
		bottoneAnnulla.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource("/agent_trade/ui/img/carrelloOrdine.png")));
		bottoneAnnulla.setBounds(298, 103, 161, 30);
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
		
		bottoneModifica = new JButton("Modifica Preventivo");
		bottoneModifica.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource("/agent_trade/ui/img/setting.png")));
		bottoneModifica.setBounds(100, 103, 166, 30);
		add(bottoneModifica);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 735, 7);
		add(separator);
		
		bottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		bottoneAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}
	
	/*metodi di classe*/

	public static RiepilogoIntestazionePreventivoView getInstance(){
		if (instance==null)
			instance = new RiepilogoIntestazionePreventivoView();
		return instance;	 
	}
	
	public static void cancellaIstanzaRiepilogoIntestazione(){
		instance=null;
	}

	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
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
	
}
