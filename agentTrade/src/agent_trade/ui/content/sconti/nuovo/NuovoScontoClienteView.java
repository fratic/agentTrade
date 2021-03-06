package agent_trade.ui.content.sconti.nuovo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.util.Costanti;

public class NuovoScontoClienteView extends NuovoScontoFactoryView{
	
	private JPanel pannPercent;
	
	private JLabel labelPercent;
	
	private JTextField TFPercent;
	
	
	public NuovoScontoClienteView() {
		
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
		TFPercent.setToolTipText(Costanti.TIP_PERCENTUALE_SCONTO);
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


		bottoneSalvaSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						System.out.print("SALVA SCONTO CLIENTE");
						M_ScontoCliente sconto = new M_ScontoCliente();
						sconto.setPercent( Float.valueOf(TFPercent.getText()).floatValue());
						Ctrl_gestisciSconto.getInstance().inserisciNuovoSconto(sconto);

				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}

			}	
		});
	
		
	}
	
	public static NuovoScontoClienteView getInstance(){
		if(instance == null)
			instance = new NuovoScontoClienteView();
		return (NuovoScontoClienteView) instance;
	}
	
	
	public void resetNewSconto(){
		super.resetNuovoSconto();
		TFPercent.setText(null);
	}
	

}
