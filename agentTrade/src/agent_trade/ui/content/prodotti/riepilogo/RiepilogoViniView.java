package agent_trade.ui.content.prodotti.riepilogo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class RiepilogoViniView extends RiepilogoProdottoFactoryView{

	private JPanel pannColore;
	private JPanel pannIndGeograf;
	private JPanel pannCantina;
	
	private JLabel labelColore;
	private JLabel labelGeo;
	private JLabel labelCantina;
	
	private JTextField TFGeo;
	private JTextField TFColore;
	private JTextField TFCantina;

	
	RiepilogoViniView(){		
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
		TFColore.setEditable(false);
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
		TFGeo.setEditable(false);
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
		TFCantina.setEditable(false);
		pannCantina.add(TFCantina);
	}
	
	
	public static RiepilogoViniView getInstance(){
		if(instance == null)
			 instance = new RiepilogoViniView();
		return  (RiepilogoViniView) instance;
	}
	
	
	public void setSchedaProdotto(M_Prodotto prod){
		super.setSchedaProdotto(prod);
		M_Vini vino = (M_Vini)prod;
		TFColore.setText(vino.getColore());
		TFGeo.setText(vino.getIndicazione_geografica());
		TFCantina.setText(vino.getCantina());
	}
}