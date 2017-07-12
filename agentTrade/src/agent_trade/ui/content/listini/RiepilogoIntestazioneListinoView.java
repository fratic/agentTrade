package agent_trade.ui.content.listini;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.util.Costanti;

public class RiepilogoIntestazioneListinoView extends JPanel {

	/*attributi di classe*/
	
	private static RiepilogoIntestazioneListinoView instance;
	
	/*attributi privati*/
	
	private JPanel pannelloNord;
	private JPanel pannelloSinistra;
	private JPanel pannelloDestra;

	private JLabel labelAzienda;
	private JLabel labelAz;
	private JLabel labelID;
	private JLabel labelID_Azienda;
	private JLabel labelCitta;
	private JLabel labelCitta_Azienda;	
	private JLabel labelInfo_Aggiornamento;
	private JLabel labelInfo;
	
	private JButton btnAggiungi;
	
	/*costruttori*/
	
	public RiepilogoIntestazioneListinoView(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_INTESTAZIONE_LISTINO, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(new BorderLayout());
		
		pannelloNord = new JPanel();
		pannelloNord.setPreferredSize(new Dimension(733,65));
		pannelloNord.setLayout(new BorderLayout());
		this.add(pannelloNord, BorderLayout.NORTH);
		
		pannelloSinistra = new JPanel();
		pannelloSinistra.setPreferredSize(new Dimension(310, 50));
		pannelloNord.add(pannelloSinistra, BorderLayout.WEST);
		
		labelAzienda = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_AZIENDA);
		labelAzienda.setPreferredSize(new Dimension(90, 14));
		pannelloSinistra.add(labelAzienda);
		
		labelAz = DefaultComponentFactory.getInstance().createLabel("");
		labelAz.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(labelAz);
		
		labelID = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID_AZIENDA);
		labelID.setPreferredSize(new Dimension(90, 14));
		pannelloSinistra.add(labelID);
		
		labelID_Azienda = DefaultComponentFactory.getInstance().createLabel("");
		labelID_Azienda.setPreferredSize(new Dimension(206, 14));
		pannelloSinistra.add(labelID_Azienda);
		
		labelCitta = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_CITTA);
		labelCitta.setPreferredSize(new Dimension(90, 14));
		pannelloSinistra.add(labelCitta);
		
		labelCitta_Azienda = DefaultComponentFactory.getInstance().createLabel("");
		labelCitta_Azienda.setPreferredSize(new Dimension(206,14));
		pannelloSinistra.add(labelCitta_Azienda);
		
		pannelloDestra = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pannelloDestra.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pannelloDestra.setPreferredSize(new Dimension(315, 50));
		pannelloNord.add(pannelloDestra, BorderLayout.EAST);
		
		labelInfo_Aggiornamento = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_AGGIORNAMENTO_AUTO);
		labelInfo_Aggiornamento.setHorizontalAlignment(SwingConstants.RIGHT);
		labelInfo_Aggiornamento.setPreferredSize(new Dimension(200, 14));
		pannelloDestra.add(labelInfo_Aggiornamento);
		
		labelInfo = DefaultComponentFactory.getInstance().createLabel("");
		labelInfo.setPreferredSize(new Dimension(90, 14));
		pannelloDestra.add(labelInfo);
		
		btnAggiungi = new JButton(Costanti.BOTTONE_AGIIUNGI_PRODOTTO); 
		btnAggiungi.setPreferredSize(new Dimension(170, 20));
		btnAggiungi.setToolTipText(Costanti.TIP_AGGIUNGI_PRODOTTO); 
		pannelloDestra.add(btnAggiungi);
		
	    btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciListino.getInstance().btnAggiungiProdotto();
			}	
		});
	}
	
	/*metodi di classe*/
	
	public static RiepilogoIntestazioneListinoView getInstance(){
		
		if (instance==null)
			instance = new RiepilogoIntestazioneListinoView();
		return instance;
	}
	
	/*metodi privati*/
	
	/*metodi pubblici*/
	
	public void setIntestazioneListino(String nomeAzienda, String idAzienda, String citta, String automatico) {
		
		labelAz.setText(nomeAzienda);
		labelID_Azienda.setText(idAzienda);
		labelCitta_Azienda.setText(citta);	
		labelInfo.setText(automatico);
	}

	
	public void setAbilitaAddProdotto(boolean b) {
		btnAggiungi.setEnabled(b);
	}
	
}
