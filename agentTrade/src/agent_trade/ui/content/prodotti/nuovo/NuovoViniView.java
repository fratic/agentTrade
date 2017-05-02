package agent_trade.ui.content.prodotti.nuovo;

import java.awt.BorderLayout;
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

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Vini;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class NuovoViniView extends NuovoProdottoFactoryView{

	private JPanel pannColore;
	private JPanel pannIndGeograf;
	private JPanel pannCantina;
	
	private JLabel labelColore;
	private JLabel labelGeo;
	private JLabel labelCantina;
	
	private JTextField TFGeo;
	private JTextField TFColore;
	private JTextField TFCantina;
	
	public NuovoViniView() {
		
		super();
		
		pannColore = new JPanel();
		FlowLayout flowLayout9 = (FlowLayout) pannColore.getLayout();
		flowLayout9.setHgap(0);
		flowLayout9.setVgap(0);
		pannColore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannColore);
		
		labelColore = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_COLORE);
		labelColore.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelColore.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannColore.add(labelColore);

		TFColore = new JTextField();
		TFColore.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFColore.setToolTipText(Costanti.TIP_COLORE_VINO);
		pannColore.add(TFColore);
		
		pannIndGeograf = new JPanel();
		FlowLayout flowLayout10 = (FlowLayout) pannIndGeograf.getLayout();
		flowLayout10.setHgap(0);
		flowLayout10.setVgap(0);
		pannIndGeograf.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannIndGeograf);
		
		labelGeo = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_IND_GEOG);
		labelGeo.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelGeo.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannIndGeograf.add(labelGeo);

		TFGeo = new JTextField();
		TFGeo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFGeo.setToolTipText(Costanti.TIP_IND_GEOG_VINO);;
		pannIndGeograf.add(TFGeo);
		
		pannCantina = new JPanel();
		FlowLayout flowLayout11 = (FlowLayout) pannCantina.getLayout();
		flowLayout11.setHgap(0);
		flowLayout11.setVgap(0);
		pannCantina.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCantina);
		
		labelCantina = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_CANTINA);
		labelCantina.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCantina.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCantina.add(labelCantina);

		TFCantina = new JTextField();
		TFCantina.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFCantina.setToolTipText(Costanti.TIP_CANTINA_VINO);
		pannCantina.add(TFCantina);
		
		pannErrore= new JPanel();
		FlowLayout flowLayout15 = (FlowLayout) pannErrore.getLayout();
		flowLayout15.setHgap(0);
		flowLayout15.setVgap(0);
		pannErrore.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL_ERRORE, Costanti.HEIGHT_PANN_LABEL_ERRORE));
		contenitoreCampi.add(pannErrore);
		
		labelErrore = DefaultComponentFactory.getInstance().createLabel("");
		labelErrore.setForeground(Color.RED);
		labelErrore.setPreferredSize(new Dimension(426,15));
		pannErrore.add(labelErrore);
	
		bottoneSalvaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					M_Vini vino = new M_Vini();
					
					vino.setNome(TFNome.getText());
					vino.setPrezzo(Float.parseFloat(TFPrezzo.getText()));
					vino.setCategoria(TFCategoria.getText());
					vino.setIdDescrizioneProdotto(TADescrizione.getText());
					vino.setSconto(Float.parseFloat(TFSconto.getText()));
					vino.setIdAzienda(aziendaRif.getIdAzienda());
					vino.setVersione(1);
					vino.setColore(TFColore.getText());
					vino.setIndicazione_geografica(TFGeo.getText());
					vino.setCantina(TFCantina.getText());
					Ctrl_gestisciListino.getInstance().SalvaProdotto(vino);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static NuovoViniView getInstance(){
		if(instance == null)
			 instance = new NuovoViniView();
		return  (NuovoViniView) instance;
	}
	
	
	public void resetNewProdotto(){
		
		super.resetNewProdotto();
		TFGeo.setText(null);
		TFColore.setText(null);
		TFCantina.setText(null);
	}
}
