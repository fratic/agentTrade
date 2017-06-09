package agent_trade.ui.content.sconti.nuovo;

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
import agent_trade.model.M_ScontoQuantita;
import agent_trade.util.Costanti;

public class NuovoScontoProdottoQuantitaView extends NuovoScontoFactoryView {
	
	private JPanel pannQuantita;
	private JLabel labelQuantita;
	private JTextField TFQuantita;
	private JPanel pannFisso;
	private JLabel labelFisso;
	private JTextField TFFisso;


	public NuovoScontoProdottoQuantitaView(){
		
		super();
		
		pannQuantita = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) pannQuantita.getLayout();
		flowLayout4.setHgap(0);
		flowLayout4.setVgap(0);
		pannQuantita.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannQuantita);
		
		labelQuantita = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_QUANTITA_SCONTO);
		labelQuantita.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelQuantita.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannQuantita.add(labelQuantita);
		
		TFQuantita = new JTextField();
		TFQuantita.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFQuantita.setToolTipText(Costanti.TIP_QUANTITA_SCONTO);
		pannQuantita.add(TFQuantita);
		
		pannFisso = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) pannFisso.getLayout();
		flowLayout5.setHgap(0);
		flowLayout5.setVgap(0);
		pannFisso.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannFisso);
		
		labelFisso = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_FISSO_SCONTO);
		labelFisso.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelFisso.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannFisso.add(labelFisso);
		
		TFFisso = new JTextField();
		TFFisso.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFFisso.setToolTipText(Costanti.TIP_FISSO_SCONTO);
		pannFisso.add(TFFisso);
		
		pannErrore= new JPanel();
		FlowLayout flowLayout6 = (FlowLayout) pannErrore.getLayout();
		flowLayout6.setHgap(0);
		flowLayout6.setVgap(0);
		pannErrore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL_ERRORE, Costanti.HEIGHT_PANN_LABEL_ERRORE));
		contenitoreCampi.add(pannErrore);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(426,15));
		pannErrore.add(labelErrore);
		
		bottoneSalvaSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.print("SALVA SCONTO PROD QUANTITA");
					M_ScontoQuantita sconto =  new M_ScontoQuantita();
					sconto.setQuantita(Integer.parseInt(TFQuantita.getText()));
					sconto.setScontoFisso( Float.valueOf(TFFisso.getText()).floatValue());
					Ctrl_gestisciSconto.getInstance().inserisciNuovoSconto(sconto);

				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}

			}	
		});
	}

	
	public static NuovoScontoProdottoQuantitaView getInstance(){
		if(instance == null)
			instance = new NuovoScontoProdottoQuantitaView();
		return (NuovoScontoProdottoQuantitaView) instance;
	}
	
	
	public void resetNewSconto(){
		super.resetNuovoSconto();
		TFQuantita.setText(null);
		TFFisso.setText(null);
	}
	
}
