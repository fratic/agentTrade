package agent_trade.ui.content.preventivi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class RiepilogoIntestazionePreventivoView extends JPanel 
{
	/*attributi di classe*/
	
	private static RiepilogoIntestazionePreventivoView instance;
	/*attributi privati*/

	private int id_Preventivo;

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
		
	private JButton bottoneConfermaVendita;
	private JButton bottoneModifica;
	private JButton cancPrevButton;

	private JPanel pannelloNord;
	private JPanel pannelloDestra;
	private JPanel pannelloSinistra;
	private JPanel pannelloSud;
	private JPanel pannelloSudEst;
	private JPanel pannelloSudOvest;

	
	/*costruttori*/
	
	public RiepilogoIntestazionePreventivoView() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.LABEL_INTESTAZIONE, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
//		MODIFICA TUTTO
		setLayout(new BorderLayout());

		pannelloNord = new JPanel();
		pannelloNord.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_NORD, Costanti.HEIGHT_PANN_NORD));
		pannelloNord.setLayout(new BorderLayout());
		this.add(pannelloNord,BorderLayout.NORTH);
		
		pannelloDestra = new JPanel();
		pannelloDestra.setPreferredSize(new Dimension(290, 60));
		pannelloDestra.setMinimumSize(new Dimension(Costanti.WIDTH_PANN_DESTRA_MIN, Costanti.HEIGHT_PANN_DESTRA_MIN));
		pannelloNord.add(pannelloDestra, BorderLayout.EAST);
		
		labelPrev = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NPREV);
		labelPrev.setPreferredSize(new Dimension(100, 14));
		pannelloDestra.add(labelPrev);
		
		labelNumPrev = DefaultComponentFactory.getInstance().createLabel("");
		labelNumPrev.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_NUM_PREV, Costanti. HEIGHT_LABEL_NUM_PREV));
		pannelloDestra.add(labelNumPrev);
		
		labelDel = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_DEL);
		labelDel.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_DEL, Costanti. HEIGHT_LABEL_DEL));
		pannelloDestra.add(labelDel);
		
		labelData = DefaultComponentFactory.getInstance().createLabel("");
		labelData.setPreferredSize(new Dimension(89, 14));
		pannelloDestra.add(labelData);

		lblNewLabel = new JLabel(Costanti.LABEL_EFFETTUATO_AG);
		lblNewLabel.setPreferredSize(new Dimension(140, 14));
		pannelloDestra.add(lblNewLabel);
		
		labelAgente = new JLabel();
		labelAgente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_AG, Costanti. HEIGHT_LABEL_AG));
		pannelloDestra.add(labelAgente);
		
		
		pannelloSinistra = new JPanel();
		pannelloSinistra.setPreferredSize(new Dimension(300, 60));
		pannelloNord.add(pannelloSinistra, BorderLayout.WEST);
		
		labelCl = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_Cliente);
		labelCl.setPreferredSize(new Dimension(55, 14));
		pannelloSinistra.add(labelCl);
		
		labelCliente = DefaultComponentFactory.getInstance().createLabel("");
		labelCliente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_CLIENTE_PREV, Costanti. HEIGHT_LABEL_CLIENTE_PREV));
		pannelloSinistra.add(labelCliente);
		
		JLabel labelvuota1 = new JLabel("");
		labelvuota1.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_VUOTA_2, Costanti. HEIGHT_LABEL_VUOTA_2));
		pannelloSinistra.add(labelvuota1);
		
		indirizzoCliente = new JLabel("");
		indirizzoCliente.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_CLIENTE_IND, Costanti. HEIGHT_LABEL_CLIENTE_IND));
		pannelloSinistra.add(indirizzoCliente);
		
		JLabel labelvuota2 = new JLabel("");
		labelvuota2.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_VUOTA_3, Costanti. HEIGHT_LABEL_VUOTA_3));
		pannelloSinistra.add(labelvuota2);
		
		altreInfoCliente = new JLabel("");
		altreInfoCliente.setPreferredSize(new Dimension(206, 16));
		pannelloSinistra.add(altreInfoCliente);
		
		labelSconto = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_SCONTO_INTESTAZ);
		labelSconto.setPreferredSize(new Dimension(101, 14));
		pannelloSinistra.add(labelSconto);
		
		labelScontoCl = DefaultComponentFactory.getInstance().createLabel("");
		labelScontoCl.setPreferredSize(new Dimension(Costanti. WIDTH_LABEL_SCONTO_CL_PREV, Costanti. HEIGHT_LABEL_SCONTO_CL_PREV));
		pannelloSinistra.add(labelScontoCl);
		
		
		pannelloSud = new JPanel();
		pannelloSud.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_SUD, Costanti.HEIGHT_PANN_SUD));
		pannelloSud.setLayout(new GridLayout(1,2));
		this.add(pannelloSud,BorderLayout.SOUTH);
		
		pannelloSudEst = new JPanel();
		pannelloSudEst.setLayout(new FlowLayout(FlowLayout.LEFT));
		pannelloSud.add(pannelloSudEst);
		
		pannelloSudOvest = new JPanel();
		pannelloSudOvest.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pannelloSud.add(pannelloSudOvest);
		
		bottoneModifica = new JButton("");
		bottoneModifica.setToolTipText(Costanti.TIP_MODIFICA_PREV);
		bottoneModifica.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource(Costanti.SETTING_ICON)));
		bottoneModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BOTTONE_PREV, Costanti.HEIGHT_BOTTONE_PREV));
		pannelloSudEst.add(bottoneModifica);
		
		bottoneConfermaVendita = new JButton("");
		bottoneConfermaVendita.setToolTipText(Costanti.TIP_CONFERMA_ORDINE);
		bottoneConfermaVendita.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource(Costanti.CONFERMA_ORDINE_ICON)));
		bottoneConfermaVendita.setPreferredSize(new Dimension(Costanti.WIDTH_BOTTONE_PREV, Costanti.HEIGHT_BOTTONE_PREV));
		pannelloSudEst.add(bottoneConfermaVendita);
		
		cancPrevButton = new JButton("");
		cancPrevButton.setToolTipText(Costanti.TIP_CANCELLA_PREV);
		cancPrevButton.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource(Costanti.CANCELLA_PREV_ICON)));
		cancPrevButton.setPreferredSize(new Dimension(Costanti.WIDTH_BOTTONE_PREV, Costanti.HEIGHT_BOTTONE_PREV));
		pannelloSudOvest.add(cancPrevButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 99, 735, 7);
		add(separator);
		
		bottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_elaboraPreventivo.getInstance().modificaPreventivo(id_Preventivo);
				}
				catch (PersistentException e) {
					e.printStackTrace();
				}
			
			}
		});
		
		bottoneConfermaVendita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		cancPrevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_elaboraPreventivo.getInstance().cancellaPreventivo(id_Preventivo);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}

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
	
	public  int getId_Preventivo() {
		return this.id_Preventivo;
	}

	public  void setId_Preventivo(int id_Preventivo) {
		this.id_Preventivo = id_Preventivo;
	}
	
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
