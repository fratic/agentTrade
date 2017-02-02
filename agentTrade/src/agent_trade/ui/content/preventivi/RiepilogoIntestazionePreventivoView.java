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
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Intestazione", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		labelPrev.setPreferredSize(new Dimension(96,14));
		pannelloDestra.add(labelPrev);
		
		labelNumPrev = DefaultComponentFactory.getInstance().createLabel("1");
		labelNumPrev.setPreferredSize(new Dimension(27,14));
		pannelloDestra.add(labelNumPrev);
		
		labelDel = DefaultComponentFactory.getInstance().createLabel("del");
		labelDel.setPreferredSize(new Dimension(45,14));
		pannelloDestra.add(labelDel);
		
		labelData = DefaultComponentFactory.getInstance().createLabel("03/11/2015");
		labelData.setPreferredSize(new Dimension(79,14));
		pannelloDestra.add(labelData);

		lblNewLabel = new JLabel("effettuato dall'agente: ");
		lblNewLabel.setPreferredSize(new Dimension(128,14));
		pannelloDestra.add(lblNewLabel);
		
		labelAgente = new JLabel();
		labelAgente.setPreferredSize(new Dimension(128,15));
		pannelloDestra.add(labelAgente);
		
		
		pannelloSinistra = new JPanel();
		pannelloSinistra.setPreferredSize(new Dimension(280,50));
		pannelloNord.add(pannelloSinistra, BorderLayout.WEST);
		
		labelCl = DefaultComponentFactory.getInstance().createLabel("Cliente: ");
		labelCl.setPreferredSize(new Dimension(50, 14));
		pannelloSinistra.add(labelCl);
		
		labelCliente = DefaultComponentFactory.getInstance().createLabel("");
		labelCliente.setPreferredSize(new Dimension(206, 14));
		pannelloSinistra.add(labelCliente);
		
		JLabel labelvuota1 = new JLabel("");
		labelvuota1.setPreferredSize(new Dimension(50,14));
		pannelloSinistra.add(labelvuota1);
		
		indirizzoCliente = new JLabel("");
		indirizzoCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(indirizzoCliente);
		
		JLabel labelvuota2 = new JLabel("");
		labelvuota2.setPreferredSize(new Dimension(50,14));
		pannelloSinistra.add(labelvuota2);
		
		altreInfoCliente = new JLabel("");
		altreInfoCliente.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(altreInfoCliente);
		
		
		pannelloSud = new JPanel();
		pannelloSud.setPreferredSize(new Dimension(733,45));
		pannelloSud.setLayout(new GridLayout(1,2));
		this.add(pannelloSud,BorderLayout.SOUTH);
		
		pannelloSudEst = new JPanel();
		pannelloSudEst.setLayout(new FlowLayout(FlowLayout.LEFT));
		pannelloSud.add(pannelloSudEst);
		
		pannelloSudOvest = new JPanel();
		pannelloSudOvest.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pannelloSud.add(pannelloSudOvest);
		
		bottoneModifica = new JButton("");
		bottoneModifica.setToolTipText("Modifica Preventivo");
		bottoneModifica.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource("/agent_trade/ui/img/setting.png")));
		bottoneModifica.setPreferredSize(new Dimension(40,30));
		pannelloSudEst.add(bottoneModifica);
		
		bottoneConfermaVendita = new JButton("");
		bottoneConfermaVendita.setToolTipText("Conferma ordine");
		bottoneConfermaVendita.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource("/agent_trade/ui/img/carrelloOrdine.png")));
		bottoneConfermaVendita.setPreferredSize(new Dimension(40,30));
		pannelloSudEst.add(bottoneConfermaVendita);
		
		cancPrevButton = new JButton("");
		cancPrevButton.setToolTipText("Cancella preventivo");
		cancPrevButton.setIcon(new ImageIcon(RiepilogoIntestazionePreventivoView.class.getResource("/agent_trade/ui/img/delete.png")));
		cancPrevButton.setPreferredSize(new Dimension(40,30));
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
