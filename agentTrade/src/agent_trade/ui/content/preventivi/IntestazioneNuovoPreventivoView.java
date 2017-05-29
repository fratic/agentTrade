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

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.ui.primaryView.PrimaryAgenteView;
import agent_trade.util.Costanti;

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
	private JLabel labelSconto;
	private JLabel labelScontoCl;
		
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

		setLayout(new BorderLayout());
		
		pannelloNord = new JPanel();
		pannelloNord.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_NORD, Costanti.HEIGHT_PANN_NORD));
		pannelloNord.setLayout(new BorderLayout());
		this.add(pannelloNord,BorderLayout.NORTH);
		
		pannelloDestra = new JPanel();
		pannelloDestra.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_DESTRA, Costanti.HEIGHT_PANN_DESTRA));
		pannelloDestra.setMinimumSize(new Dimension(Costanti.WIDTH_PANN_DESTRA_MIN, Costanti.HEIGHT_PANN_DESTRA_MIN));
		pannelloNord.add(pannelloDestra, BorderLayout.EAST);
		
		labelPrev = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NPREV);
		labelPrev.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_PREV_INT, Costanti. HEIGHT_LABEL_PREV_INT));
		pannelloDestra.add(labelPrev);
		
		labelNumPrev = DefaultComponentFactory.getInstance().createLabel("");
		labelNumPrev.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_NUM_PREV, Costanti. HEIGHT_LABEL_NUM_PREV));
		pannelloDestra.add(labelNumPrev);
		
		labelDel = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_DEL);
		labelDel.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_DEL, Costanti. HEIGHT_LABEL_DEL));
		pannelloDestra.add(labelDel);
		
		labelData = DefaultComponentFactory.getInstance().createLabel("");
		labelData.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_DATA, Costanti. HEIGHT_LABEL_DATA));
		pannelloDestra.add(labelData);
		
		lblNewLabel = new JLabel(Costanti.LABEL_EFFETTUATO_AG);
		lblNewLabel.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_EFFETTUATO, Costanti. HEIGHT_LABEL_EFFETTUATO));
		pannelloDestra.add(lblNewLabel);
		
		labelAgente = new JLabel();
		labelAgente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_AG, Costanti. HEIGHT_LABEL_AG));
		pannelloDestra.add(labelAgente);
		
		JLabel labelvuota1 = new JLabel("");
		labelvuota1.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_VUOTA_1, Costanti. HEIGHT_LABEL_VUOTA_1));
		pannelloDestra.add(labelvuota1);
		
		JLabel labelvuota4 = new JLabel("");
		labelvuota4.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_VUOTA_4, Costanti. HEIGHT_LABEL_VUOTA_4));
		pannelloDestra.add(labelvuota4);
		
		bottoneAnnulla = new JButton("");
		bottoneAnnulla.setToolTipText(Costanti.TIP_ANNULLA_PREV);
		bottoneAnnulla.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource(Costanti.CLOSE_ICON)));
		bottoneAnnulla.setPreferredSize(new Dimension(Costanti. WIDTH_BOTTONE_ANNULLA_PREV, Costanti. HEIGHT_BOTTONE_ANNULLA_PREV));
		pannelloDestra.add(bottoneAnnulla);
		
		pannelloSinistra = new JPanel();
		pannelloSinistra.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_SINISTRA, Costanti.HEIGHT_PANN_SINISTRA));
		pannelloNord.add(pannelloSinistra, BorderLayout.WEST);
		
		labelCl = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_Cliente);
		labelCl.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_CL_PREV, Costanti. HEIGHT_LABEL_CL_PREV));
		pannelloSinistra.add(labelCl);
		
		labelCliente = DefaultComponentFactory.getInstance().createLabel("");
		labelCliente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_CLIENTE_PREV, Costanti. HEIGHT_LABEL_CLIENTE_PREV));
		pannelloSinistra.add(labelCliente);
		
		JLabel labelvuota2 = new JLabel("");
		labelvuota2.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_VUOTA_2, Costanti. HEIGHT_LABEL_VUOTA_2));
		pannelloSinistra.add(labelvuota2);
		
		indirizzoCliente = new JLabel("");
		indirizzoCliente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_CLIENTE_IND, Costanti. HEIGHT_LABEL_CLIENTE_IND));
		pannelloSinistra.add(indirizzoCliente);
		
		JLabel labelvuota3 = new JLabel("");
		labelvuota3.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_VUOTA_3, Costanti. HEIGHT_LABEL_VUOTA_3));
		pannelloSinistra.add(labelvuota3);
		
		altreInfoCliente = new JLabel("");
		altreInfoCliente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_ALTRE_INFO, Costanti. HEIGHT_LABEL_ALTRE_INFO));
		pannelloSinistra.add(altreInfoCliente);
		
		labelSconto = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_SCONTO_INTESTAZ);
		labelSconto.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_SCONTO_PREV, Costanti. HEIGHT_LABEL_SCONTO_PREV));
		pannelloSinistra.add(labelSconto);
		
		labelScontoCl = DefaultComponentFactory.getInstance().createLabel("");
		labelScontoCl.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_SCONTO_CL_PREV, Costanti. HEIGHT_LABEL_SCONTO_CL_PREV));
		pannelloSinistra.add(labelScontoCl);
			
		pannelloSud = new JPanel();
		pannelloSud.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_SUD, Costanti.HEIGHT_PANN_SUD));
		pannelloSud.setLayout(new FlowLayout());
		this.add(pannelloSud,BorderLayout.SOUTH);
		
		
		btnNewButton = new JButton();
		btnNewButton.setToolTipText(Costanti.TIP_ADD_ITEM);
		btnNewButton.setIcon(new ImageIcon(IntestazioneNuovoPreventivoView.class.getResource(Costanti.ADD_ITEM_ICON)));
		btnNewButton.setPreferredSize(new Dimension(Costanti.WIDTH_BOTTONE_PREV, Costanti.HEIGHT_BOTTONE_PREV));
		pannelloSud.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 723, 7);
		add(separator);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			PrimaryAgenteView.getInstance().selectTabCatalogo();		
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

	
	
	public void setCliente(String cognome, String nome, String indirizzo, String email, String sconto){
		this.labelCliente.setText(cognome+" "+nome);
		setIndirizzoCliente(indirizzo);
		setAltreInfoCliente(email);
		setScontoCliente(sconto);
	}
	
	public void setAgente(String a){
		this.labelAgente.setText(a);
	}
	
	public void setNumPrev(int i) {
		this.labelNumPrev.setText(""+i);
	}

	public void setData(Date data) {
		String d= data.getDate()+" / "+(data.getMonth()+1)+" / "+(data.getYear()+1900);
		this.labelData.setText(d);
	}
	
	public void setIndirizzoCliente(String i) {
		this.indirizzoCliente.setText(i);
	}
	
	public void setAltreInfoCliente(String a) {
		this.altreInfoCliente.setText(a);
	}
	
	public void setScontoCliente(String a) {
		this.labelScontoCl.setText(a);
	}
	
}
