package agent_trade.ui.content.prodotti.nuovo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Dolci;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class NuovoDolciView extends NuovoProdottoFactoryView{

	private JPanel pannArtigianale;
	private JPanel pannFreeGluten;
	
	private JLabel labelArtigianale;
	private JLabel labelFreeGluten;
	
	private ButtonGroup JBGArtigianale;
	private ButtonGroup JBGFreeGluten;
	
	private JRadioButton JRArtiTrue;
	private JRadioButton JRArtiFalse;
	private JRadioButton JRFreeTrue;
	private JRadioButton JRFreeFalse;
	
	
	public NuovoDolciView() {
		
		super();
		
		TFCategoria.setText("Dolci");
		
		pannArtigianale = new JPanel();
		FlowLayout flowLayout9 = (FlowLayout) pannArtigianale.getLayout();
		flowLayout9.setAlignment(FlowLayout.LEFT);
		flowLayout9.setHgap(0);
		flowLayout9.setVgap(0);
		pannArtigianale.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannArtigianale);
		
		labelArtigianale = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ARTIGIANALE);
		labelArtigianale.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelArtigianale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannArtigianale.add(labelArtigianale);

		JRArtiTrue = new JRadioButton("Si", false);
		JRArtiFalse = new JRadioButton("No", true);
		
		JBGArtigianale = new ButtonGroup();
		JBGArtigianale.add(JRArtiTrue);
		JBGArtigianale.add(JRArtiFalse);
		
		pannArtigianale.add(JRArtiTrue);
		pannArtigianale.add(JRArtiFalse);

		pannFreeGluten = new JPanel();
		FlowLayout flowLayout10 = (FlowLayout) pannFreeGluten.getLayout();
		flowLayout10.setAlignment(FlowLayout.LEFT);
		flowLayout10.setHgap(0);
		flowLayout10.setVgap(0);
		pannFreeGluten.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannFreeGluten);
		
		labelFreeGluten = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_FREE_GLUTEN);
		labelFreeGluten.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelFreeGluten.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannFreeGluten.add(labelFreeGluten);

		JRFreeTrue = new JRadioButton("Si", false);
		JRFreeFalse = new JRadioButton("No", true);
		
		JBGFreeGluten = new ButtonGroup();
		JBGFreeGluten.add(JRFreeTrue);
		JBGFreeGluten.add(JRFreeFalse);
		
		pannFreeGluten.add(JRFreeTrue);
		pannFreeGluten.add(JRFreeFalse);
		
		pannErrore = new JPanel();
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
					M_Dolci dolce = new M_Dolci();
					
					dolce.setNome(TFNome.getText());
					dolce.setPrezzo(Float.parseFloat(TFPrezzo.getText()));
					dolce.setCategoria(TFCategoria.getText());
					dolce.setIdDescrizioneProdotto(TADescrizione.getText());
					dolce.setIdAzienda(aziendaRif.getIdAzienda());
					dolce.setVersione(1);
					dolce.setArtigianale(JRArtiTrue.isSelected());
					dolce.setFree_gluten(JRFreeTrue.isSelected());
					
					Ctrl_gestisciListino.getInstance().salvaProdotto(dolce);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static NuovoDolciView getInstance(){
		if(instance == null)
			 instance = new NuovoDolciView();
		return  (NuovoDolciView) instance;
	}
	
	
	public void resetNewProdotto(){
		super.resetNewProdotto();
	}
}
