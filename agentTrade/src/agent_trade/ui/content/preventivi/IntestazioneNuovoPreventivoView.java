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

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.ui.PrimaryView;
import agent_trade.util.Costanti;

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
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.LABEL_INTESTAZIONE, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		labelPrev = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NPREV);
		labelPrev.setPreferredSize(new Dimension(96,14));
		pannelloDestra.add(labelPrev);
		
		labelNumPrev = DefaultComponentFactory.getInstance().createLabel("");
		labelNumPrev.setPreferredSize(new Dimension(27,14));
		pannelloDestra.add(labelNumPrev);
		
		labelDel = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_DEL);
		labelDel.setPreferredSize(new Dimension(45,14));
		pannelloDestra.add(labelDel);
		
		labelData = DefaultComponentFactory.getInstance().createLabel("");
		labelData.setPreferredSize(new Dimension(79,14));
		pannelloDestra.add(labelData);
		
		lblNewLabel = new JLabel(Costanti.LABEL_EFFETTUATO_AG);
		lblNewLabel.setPreferredSize(new Dimension(128,14));
		pannelloDestra.add(lblNewLabel);
		
		labelAgente = new JLabel();
		labelAgente.setPreferredSize(new Dimension(128,15));
		pannelloDestra.add(labelAgente);
		
		JLabel labelvuota1 = new JLabel("");
		labelvuota1.setPreferredSize(new Dimension(230, 14));
		pannelloDestra.add(labelvuota1);
		
		bottoneAnnulla = new JButton("");
		bottoneAnnulla.setToolTipText(Costanti.TIP_ANNULLA_PREV);
		bottoneAnnulla.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource(Costanti.CLOSE_ICON)));
		bottoneAnnulla.setPreferredSize(new Dimension(20, 20));
		pannelloDestra.add(bottoneAnnulla);
		
		pannelloSinistra = new JPanel();
		pannelloSinistra.setPreferredSize(new Dimension(280,50));
		pannelloNord.add(pannelloSinistra, BorderLayout.WEST);
		
		labelCl = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_Cliente);
		labelCl.setPreferredSize(new Dimension(50, 14));
		pannelloSinistra.add(labelCl);
		
		labelCliente = DefaultComponentFactory.getInstance().createLabel("");
		labelCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(labelCliente);
		
		JLabel labelvuota2 = new JLabel("");
		labelvuota2.setPreferredSize(new Dimension(50,14));
		pannelloSinistra.add(labelvuota2);
		
		indirizzoCliente = new JLabel("");
		indirizzoCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(indirizzoCliente);
		
		JLabel labelvuota3 = new JLabel("");
		labelvuota3.setPreferredSize(new Dimension(50,14));
		pannelloSinistra.add(labelvuota3);
		
		altreInfoCliente = new JLabel("");
		altreInfoCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(altreInfoCliente);
			
		pannelloSud = new JPanel();
		pannelloSud.setPreferredSize(new Dimension(733,45));
		pannelloSud.setLayout(new FlowLayout());
		this.add(pannelloSud,BorderLayout.SOUTH);
		
		
		btnNewButton = new JButton();
		btnNewButton.setToolTipText(Costanti.TIP_ADD_ITEM);
		btnNewButton.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource(Costanti.ADD_ITEM_ICON)));
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
				try {
					Ctrl_elaboraPreventivo.getInstance().annullaPreventivo();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
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
	
	public void setNumPrev(int i) {
		this.labelNumPrev.setText(""+i);
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
