package agent_trade.ui.content.prodotti.riepilogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Carni;
import agent_trade.model.M_Prodotto;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class RiepilogoCarniView extends RiepilogoProdottoFactoryView{

	private M_Carni carne;
	
	private JPanel pannProvenienza;
	private JPanel pannTaglio;
	private JPanel pannTipo;
	
	private JLabel labelProvenienza;
	private JLabel labelTaglio;
	private JLabel labelTipo;
	
	private JTextField TFProvenienza;
	private JTextField TFTaglio;
	private JTextField TFTipo;
	
//	private JComboBox JCTaglio;
//	private JComboBox JCTipo;
	
	public RiepilogoCarniView() {
		
		super();
		
		pannProvenienza = new JPanel();
		FlowLayout flowLayout9 = (FlowLayout) pannProvenienza.getLayout();
		flowLayout9.setHgap(0);
		flowLayout9.setVgap(0);
		pannProvenienza.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannProvenienza);
		
		labelProvenienza = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PROVENIENZA);
		labelProvenienza.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelProvenienza.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannProvenienza.add(labelProvenienza);

		TFProvenienza = new JTextField();
		TFProvenienza.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFProvenienza.setEditable(false);
		pannProvenienza.add(TFProvenienza);
		
		pannTaglio = new JPanel();
		FlowLayout flowLayout10 = (FlowLayout) pannTaglio.getLayout();
		flowLayout10.setHgap(0);
		flowLayout10.setVgap(0);
		pannTaglio.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannTaglio);
		
		labelTaglio = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TAGLIO);
		labelTaglio.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelTaglio.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannTaglio.add(labelTaglio);

//		JCTaglio = new JComboBox(Costanti.LISTA_TAGLIO_CARNE);
//		JCTaglio.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
//		JCTaglio.setEnabled(false);
//		JCTaglio.setSelectedIndex(0);
		TFTaglio = new JTextField();
		TFTaglio.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFTaglio.setEditable(false);
		pannTaglio.add(TFTaglio);
		
		pannTipo = new JPanel();
		FlowLayout flowLayout11 = (FlowLayout) pannTipo.getLayout();
		flowLayout11.setHgap(0);
		flowLayout11.setVgap(0);
		pannTipo.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannTipo);
		
		labelTipo = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TIPO);
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelTipo.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannTipo.add(labelTipo);

		
//		JCTipo = new JComboBox(Costanti.LISTA_TIPO_CARNE);
//		JCTipo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
//		JCTipo.setEnabled(false);
//		JCTipo.setSelectedIndex(0);
		TFTipo = new JTextField();
		TFTipo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFTipo.setEditable(false);
		pannTipo.add(TFTipo);
		
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
		
		bottoneCancellaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciListino.getInstance().cancellaProdotto(carne);
			}
		});
	
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciListino.getInstance().annullaModifica(carne);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		bottoneSalvaModifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
//					M_Carni carne = new M_Carni();
					
//					carne.setIdProdotto(carne.getIdProdotto());
					carne.setNome(TFNome.getText());
					carne.setPrezzo(Float.parseFloat(TFPrezzo.getText()));
					carne.setCategoria(TFCategoria.getText());
					carne.setIdDescrizioneProdotto(TADescrizione.getText());
					carne.setSconto(idSconto);
//					carne.setIdAzienda(prodotto.getIdAzienda());
//					carne.setVersione(prodotto.getVersione());
					carne.setProvenienza(TFProvenienza.getText());
					carne.setTaglio(TFTaglio.getText());
					carne.setTipo(TFTipo.getText());
					Ctrl_gestisciListino.getInstance().modificaProdotto(carne);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static RiepilogoCarniView getInstance(){
		if(instance == null)
			 instance = new RiepilogoCarniView();
		return  (RiepilogoCarniView) instance;
	}
	
//	public static void cancRiepilogoProdotto(){
//		instance = null;
//	}
	
	public void setSchedaProdotto(M_Prodotto prod){
//		super.setSchedaProdotto(prod);
		
		carne = (M_Carni) prod;
		TFidProdotto.setText(""+carne.getIdProdotto());
		TFNome.setText(carne.getNome());
		TFCategoria.setText(carne.getCategoria());
		TFPrezzo.setText(""+carne.getPrezzo());
//		TFSconto.setText(""+prodotto.getSconto());
		TFVersione.setText(""+carne.getVersione());
		TADescrizione.setText(carne.getIdDescrizioneProdotto());
		TFProvenienza.setText(carne.getProvenienza());
		TFTaglio.setText(carne.getTaglio());
		TFTipo.setText(carne.getTipo());
	}
	
	
	public void setTFeditable(boolean b){
		super.setTFeditable(b);
		TFProvenienza.setEditable(b);
		TFTaglio.setEditable(b);
		TFTipo.setEditable(b);
	}
	
	
	public void abilitaToolTip(){
		super.abilitaToolTip();
		TFProvenienza.setToolTipText(Costanti.TIP_PROV_CARNE);
		TFTaglio.setToolTipText(Costanti.TIP_TAGLIO_CARNE);
		TFTipo.setToolTipText(Costanti.TIP_TIPO_CARNE);
	}
	
	
	public void disabilitaToolTip(){
		super.disabilitaToolTip();
		TFProvenienza.setToolTipText(null);
		TFTaglio.setToolTipText(null);
		TFTipo.setToolTipText(null);
	}
}
