package agent_trade.ui.content.prodotti.nuovo;

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
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class NuovoCarniView extends NuovoProdottoFactoryView {

	
	private JPanel pannProvenienza;
	private JPanel pannTaglio;
	private JPanel pannTipo;
	
	private JLabel labelProvenienza;
	private JLabel labelTaglio;
	private JLabel labelTipo;
	
	private JTextField TFProvenienza;
	
	private JComboBox JCTaglio;
	private JComboBox JCTipo;
	
	public NuovoCarniView() {
		
		super();
		
		TFCategoria.setText("Carni");
		
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
		TFProvenienza.setToolTipText(Costanti.TIP_PROV_CARNE);
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

		JCTaglio = new JComboBox(Costanti.LISTA_TAGLIO_CARNE);
		JCTaglio.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		JCTaglio.setToolTipText(Costanti.TIP_TAGLIO_CARNE);
		JCTaglio.setSelectedIndex(0);
		pannTaglio.add(JCTaglio);
		
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

		
		JCTipo = new JComboBox(Costanti.LISTA_TIPO_CARNE);
		JCTipo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		JCTipo.setToolTipText(Costanti.TIP_TIPO_CARNE);
		JCTipo.setSelectedIndex(0);
		pannTipo.add(JCTipo);
		
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
					M_Carni carne = new M_Carni();
					
					carne.setNome(TFNome.getText());
					carne.setPrezzo(Float.parseFloat(TFPrezzo.getText()));
					carne.setCategoria(TFCategoria.getText());
					carne.setIdDescrizioneProdotto(TADescrizione.getText());
					carne.setSconto(Float.parseFloat(TFSconto.getText()));
					carne.setIdAzienda(aziendaRif.getIdAzienda());
					carne.setVersione(1);
					carne.setProvenienza(TFProvenienza.getText());
					carne.setTaglio(JCTaglio.getSelectedItem().toString());
					carne.setTipo(JCTipo.getSelectedItem().toString());
					Ctrl_gestisciListino.getInstance().salvaProdotto(carne);
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static NuovoCarniView getInstance(){
		if(instance == null)
			 instance = new NuovoCarniView();
		return  (NuovoCarniView) instance;
	}
	
	
	public void resetNewProdotto(){
		super.resetNewProdotto();
		TFProvenienza.setText(null);
		JCTaglio.setSelectedIndex(0);
		JCTipo.setSelectedIndex(0);
	}
}
