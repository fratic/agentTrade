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
import agent_trade.model.M_ScontoQuantita;
import agent_trade.util.Costanti;

public class RiepilogoScontoQuantitaView  extends RiepilogoScontoFactoryView{

	/*attributi di classe*/
	
	
	
	/*attributi privati*/
	
	private M_ScontoQuantita scontoQnt;
		
	private JPanel pannQnt;
	private JPanel pannFisso;
	
	private JLabel labelQnt;
	private JLabel labelFisso;
	
	private JTextField TFQnt;
	private JTextField TFFisso;
	
	/*costruttori*/
	
	public RiepilogoScontoQuantitaView(){
		
		super();
		
		pannQnt = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannQnt.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannQnt.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannQnt);
		
		labelQnt = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_QUANTITA_SCONTO);
		labelQnt.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelQnt.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannQnt.add(labelQnt);
		
		TFQnt = new JTextField();
		TFQnt.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFQnt.setEditable(false);
		pannQnt.add(TFQnt);
		
		pannFisso = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannFisso.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannFisso.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannFisso);
		
		labelFisso = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_FISSO_SCONTO);
		labelFisso.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelFisso.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannFisso.add(labelFisso);
		
		TFFisso = new JTextField();
		TFFisso.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFFisso.setEditable(false);
		pannFisso.add(TFFisso);
		
		pannErrore= new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) pannErrore.getLayout();
		flowLayout4.setHgap(0);
		flowLayout4.setVgap(0);
		pannErrore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL_ERRORE, Costanti.HEIGHT_PANN_LABEL_ERRORE));
		contenitoreCampi.add(pannErrore);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(426,15));
		pannErrore.add(labelErrore);
	
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					scontoQnt.setQuantita(Integer.parseInt(TFQnt.getText()));
					scontoQnt.setScontoFisso(Float.valueOf(TFFisso.getText()).floatValue());
					scontoQnt.setVersione(scontoQnt.getVersione()+1);
					
					Ctrl_gestisciSconto.getInstance().modificaSconto(scontoQnt);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	/*metodi di classe*/
	
	public static RiepilogoScontoQuantitaView getInstance(){
		if(instance == null){
			instance = new RiepilogoScontoQuantitaView();
		}
		return (RiepilogoScontoQuantitaView) instance;
	}
	
	/*metodi privati*/
	
	/*metodi pubblici*/	
	
	public void setSchedaSconto(M_Sconto sconto){
		super.setSchedaSconto(sconto);
		
		TFTipo.setText(Costanti.LISTA_TIPO_SCONTI[2]);
		scontoQnt = (M_ScontoQuantita) sconto;
		TFQnt.setText("" + scontoQnt.getQuantita());
		TFFisso.setText( "" + scontoQnt.getScontoFisso());
	}
	
	
	public void setTFeditable(boolean b){
		super.setTFeditable(b);
		TFQnt.setEditable(b);
		TFFisso.setEditable(b);
	}
	
	
	public void abilitaToolTip(){
		super.abilitaToolTip();
		TFQnt.setToolTipText(Costanti.TIP_QUANTITA_SCONTO);
		TFFisso.setToolTipText(Costanti.TIP_FISSO_SCONTO);
	}
	
	
	public void disabilitaToolTip(){
		super.disabilitaToolTip();
		TFQnt.setToolTipText(null);
		TFFisso.setToolTipText(null);
	}
}
