package agent_trade.ui.content.sconti.riepilogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.util.Costanti;

public class RiepilogoScontoPercentualeView  extends RiepilogoScontoFactoryView{

	/*attributi di classe*/
	
	
	
	/*attributi privati*/
	
	private M_ScontoPercent scontoPercent;
	
	private JPanel pannPercent;
	
	private JLabel labelPercent;
	
	private JTextField TFPercent;
	
	/*costruttori*/
	
	public RiepilogoScontoPercentualeView(){
		
		super();
		
		pannPercent = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannPercent.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannPercent.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannPercent);
		
		labelPercent = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PERCENTUALE_SCONTO);
		labelPercent.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelPercent.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannPercent.add(labelPercent);
		
		TFPercent = new JTextField();
		TFPercent.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFPercent.setEditable(false);
		pannPercent.add(TFPercent);
		
		pannErrore= new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannErrore.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannErrore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL_ERRORE, Costanti.HEIGHT_PANN_LABEL_ERRORE));
		contenitoreCampi.add(pannErrore);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(426,15));
		pannErrore.add(labelErrore);
	
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					scontoPercent.setPercent(Float.valueOf(TFPercent.getText()).floatValue());
					scontoPercent.setVersione(scontoPercent.getVersione()+1);
					
					Ctrl_gestisciSconto.getInstance().modificaSconto(scontoPercent);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	/*metodi di classe*/
	
	public static RiepilogoScontoPercentualeView getInstance(){
		if(instance == null){
			instance = new RiepilogoScontoPercentualeView();
		}
		return (RiepilogoScontoPercentualeView) instance;
	}
	
	/*metodi privati*/
	
	/*metodi pubblici*/	
	
	public void setSchedaSconto(M_Sconto sconto){
		super.setSchedaSconto(sconto);
		
		TFTipo.setText(Costanti.LISTA_TIPO_SCONTI[3]);
		scontoPercent = (M_ScontoPercent) sconto;
		TFPercent.setText( "" + scontoPercent.getPercent());
	}
	
	
	public void setTFeditable(boolean b){
		super.setTFeditable(b);
		TFPercent.setEditable(b);
	}
	
	
	public void abilitaToolTip(){
		super.abilitaToolTip();
		TFPercent.setToolTipText(Costanti.TIP_PERCENTUALE_SCONTO);
	}
	
	
	public void disabilitaToolTip(){
		super.disabilitaToolTip();
		TFPercent.setToolTipText(null);
	}
}
