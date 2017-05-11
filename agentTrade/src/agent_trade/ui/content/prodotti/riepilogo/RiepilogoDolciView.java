package agent_trade.ui.content.prodotti.riepilogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Dolci;
import agent_trade.model.M_Prodotto;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class RiepilogoDolciView extends RiepilogoProdottoFactoryView {

	
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
	
	RiepilogoDolciView(){
		
		super();
		
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
		JRArtiFalse = new JRadioButton("No", false);
		JRArtiTrue.setEnabled(false);
		JRArtiFalse.setEnabled(false);
		
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
		JRFreeTrue.setEnabled(false);
		JRFreeFalse.setEnabled(false);
		
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
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					M_Dolci dolce = new M_Dolci();
					dolce.setIdProdotto(prodotto.getIdProdotto());
					dolce.setNome(TFNome.getText());
					dolce.setPrezzo(Float.parseFloat(TFPrezzo.getText()));
					dolce.setCategoria(TFCategoria.getText());
					dolce.setIdDescrizioneProdotto(TADescrizione.getText());
					dolce.setSconto(Float.parseFloat(TFSconto.getText()));
					dolce.setIdAzienda(prodotto.getIdAzienda());
					dolce.setVersione(prodotto.getVersione());
					dolce.setArtigianale(JRArtiTrue.isSelected());
					dolce.setFree_gluten(JRFreeTrue.isSelected());
					
					Ctrl_gestisciListino.getInstance().modificaProdotto(dolce);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
	}


	public static RiepilogoDolciView getInstance(){
		if(instance == null)
			 instance = new RiepilogoDolciView();
		return  (RiepilogoDolciView) instance;
	}

	
	public void setSchedaProdotto(M_Prodotto prod){
		super.setSchedaProdotto(prod);
		M_Dolci dolce = (M_Dolci)prod;
		JRArtiTrue.setSelected(dolce.getArtigianale());
		JRArtiFalse.setSelected(!dolce.getArtigianale());
		JRFreeTrue.setSelected(dolce.getFree_gluten());
		JRFreeFalse.setSelected(!dolce.getFree_gluten());
	}
	
	
	public void setTFeditable(boolean b){
		super.setTFeditable(b);
		JRArtiTrue.setEnabled(b);
		JRArtiFalse.setEnabled(b);
		JRFreeTrue.setEnabled(b);
		JRFreeFalse.setEnabled(b);
	}
	
	
//	public void abilitaToolTip(){
//		super.abilitaToolTip();
//	}
//	
//	
//	public void disabilitaToolTip(){
//		super.disabilitaToolTip();
//	}
}
