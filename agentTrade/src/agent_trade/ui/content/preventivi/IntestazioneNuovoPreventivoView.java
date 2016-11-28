package agent_trade.ui.content.preventivi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.xml.crypto.Data;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.ui.PrimaryView;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class IntestazioneNuovoPreventivoView extends JPanel {

	/*attributi di classe*/
	
	private static IntestazioneNuovoPreventivoView instance;

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
	private JButton btnNewButton;
	
	private JPanel pannelloNord;
	private JPanel pannelloSud;
	private JPanel pannelloSinistra;
	private JPanel pannelloDestra;
	
	

	/*costruttori*/
	
	public IntestazioneNuovoPreventivoView() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Intestazione", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBackground(UIManager.getColor("CheckBox.background"));
//		MODIFICA TUTTO
		setLayout(new BorderLayout());
		
		pannelloNord = new JPanel();
		pannelloNord.setPreferredSize(new Dimension(733, 65));
		pannelloNord.setLayout(new BorderLayout());
		this.add(pannelloNord,BorderLayout.NORTH);
		
		pannelloDestra = new JPanel();
		pannelloDestra.setPreferredSize(new Dimension(280,50));
		pannelloDestra.setMinimumSize(new Dimension(200,50));
		pannelloNord.add(pannelloDestra, BorderLayout.EAST);
		
		labelPrev = DefaultComponentFactory.getInstance().createLabel("Preventivo n\u00B0");
		//labelPrev.setBounds(488, 19, 97, 14);
		labelPrev.setPreferredSize(new Dimension(96,14));
		pannelloDestra.add(labelPrev);
		
		labelNumPrev = DefaultComponentFactory.getInstance().createLabel("1");
		//labelNumPrev.setBounds(582, 19, 27, 14);
		labelNumPrev.setPreferredSize(new Dimension(27,14));
		pannelloDestra.add(labelNumPrev);
		
		labelDel = DefaultComponentFactory.getInstance().createLabel("del");
		//labelDel.setBounds(618, 19, 40, 14);
		labelDel.setPreferredSize(new Dimension(45,14));
		pannelloDestra.add(labelDel);
		
		labelData = DefaultComponentFactory.getInstance().createLabel("03/11/2015");
		//labelData.setBounds(655, 19, 69, 14);
		labelData.setPreferredSize(new Dimension(79,14));
		pannelloDestra.add(labelData);
		
		lblNewLabel = new JLabel("effettuato dall'agente: ");
		//lblNewLabel.setBounds(488, 44, 128, 14);
		lblNewLabel.setPreferredSize(new Dimension(128,14));
		pannelloDestra.add(lblNewLabel);
		
		labelAgente = new JLabel();
		//labelAgente.setBounds(628, 44, 128, 14);
		labelAgente.setPreferredSize(new Dimension(128,15));
		pannelloDestra.add(labelAgente);
		
		JLabel labelvuota1 = new JLabel("");
		labelvuota1.setPreferredSize(new Dimension(230, 14));
		pannelloDestra.add(labelvuota1);
		
		bottoneAnnulla = new JButton("");
		bottoneAnnulla.setToolTipText("Annulla il preventivo in corso");
		bottoneAnnulla.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource("/agent_trade/ui/img/close_icon.png")));
		//bottoneAnnulla.setBounds(693, 65, 30, 30);
		bottoneAnnulla.setPreferredSize(new Dimension(20, 20));
		pannelloDestra.add(bottoneAnnulla);
		
		pannelloSinistra = new JPanel();
		pannelloSinistra.setPreferredSize(new Dimension(280,50));
		pannelloNord.add(pannelloSinistra, BorderLayout.WEST);
		
		labelCl = DefaultComponentFactory.getInstance().createLabel("Cliente: ");
		//labelCl.setBounds(21, 19, 69, 14);
		labelCl.setPreferredSize(new Dimension(50, 14));
		pannelloSinistra.add(labelCl);
		
		labelCliente = DefaultComponentFactory.getInstance().createLabel("");
		//labelCliente.setBounds(88, 19, 206, 14);
		labelCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(labelCliente);
		
		JLabel labelvuota2 = new JLabel("");
		labelvuota2.setPreferredSize(new Dimension(50,14));
		pannelloSinistra.add(labelvuota2);
		
		indirizzoCliente = new JLabel("");
		//indirizzoCliente.setBounds(88, 44, 206, 14);
		indirizzoCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(indirizzoCliente);
		
		JLabel labelvuota3 = new JLabel("");
		labelvuota3.setPreferredSize(new Dimension(50,14));
		pannelloSinistra.add(labelvuota3);
		
		altreInfoCliente = new JLabel("");
		//altreInfoCliente.setBounds(88, 69, 206, 14);
		altreInfoCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(altreInfoCliente);
			
		pannelloSud = new JPanel();
		pannelloSud.setPreferredSize(new Dimension(733,45));
		pannelloSud.setLayout(new FlowLayout());
		this.add(pannelloSud,BorderLayout.SOUTH);
		
		
		btnNewButton = new JButton();
		btnNewButton.setToolTipText("Aggiungi prodotti a questo preventivo");
		btnNewButton.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource("/agent_trade/ui/img/add-item.png")));
		//btnNewButton.setBounds(346, 103, 40, 30);
		btnNewButton.setPreferredSize(new Dimension(40,30));
		pannelloSud.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 723, 7);
		add(separator);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			PrimaryView.getInstance().selectTabCatalogo();		
			}
		});
		
		bottoneAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Ctrl_elaboraPreventivo.getInstance().annullaPreventivo();
			}
		});
		
	}
	
	/*metodi di classe*/
	
	public static IntestazioneNuovoPreventivoView getInstance(){
		if (instance==null)
			instance = new IntestazioneNuovoPreventivoView();
		return instance;	 
	}
	
	public static void cancIntestazione(){
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

	public void setData(Date data) {
		int anno=data.getYear()+1900;
		String d= data.getDate()+" / "+data.getMonth()+" / "+anno;
		this.labelData.setText(d);
	}
	
	public void setIndirizzoCliente(String i) {
		this.indirizzoCliente.setText(i);
	}
	
	public void setAltreInfoCliente(String a) {
		this.altreInfoCliente.setText(a);
	}
	
}
