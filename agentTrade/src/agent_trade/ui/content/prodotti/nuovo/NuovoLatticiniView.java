package agent_trade.ui.content.prodotti.nuovo;

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
import agent_trade.model.M_Latticini;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class NuovoLatticiniView extends NuovoProdottoFactoryView{

	
	private JPanel pannStagionatura;
	private JPanel pannTipo;
	
	private JLabel labelStagionatura;
	private JLabel labelTipo;
	
	private JTextField TFStagionatura;
	private JTextField TFTipo;
	
	public NuovoLatticiniView() {
		
		super();
		
		TFCategoria.setText("Latticini");
		
		pannStagionatura = new JPanel();
		FlowLayout flowLayout9 = (FlowLayout) pannStagionatura.getLayout();
		flowLayout9.setHgap(0);
		flowLayout9.setVgap(0);
		pannStagionatura.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannStagionatura);
		
		labelStagionatura = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_STAGIONATURA);
		labelStagionatura.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelStagionatura.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannStagionatura.add(labelStagionatura);

		TFStagionatura = new JTextField();
		TFStagionatura.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFStagionatura.setToolTipText(Costanti.TIP_STAGIONATURA_LATT);
		pannStagionatura.add(TFStagionatura);
		
		pannTipo = new JPanel();
		FlowLayout flowLayout10 = (FlowLayout) pannTipo.getLayout();
		flowLayout10.setHgap(0);
		flowLayout10.setVgap(0);
		pannTipo.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannTipo);
		
		labelTipo = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TIPO);
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelTipo.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannTipo.add(labelTipo);

		TFTipo = new JTextField();
		TFTipo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFTipo.setToolTipText(Costanti.TIP_TIPO_LATT);
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
	
		bottoneSalvaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					M_Latticini latticino = new M_Latticini();
					
					latticino.setNome(TFNome.getText());
					latticino.setPrezzo(Float.parseFloat(TFPrezzo.getText()));
					latticino.setCategoria(TFCategoria.getText());
					latticino.setIdDescrizioneProdotto(TADescrizione.getText());
					latticino.setIdAzienda(aziendaRif.getIdAzienda());
					latticino.setVersione(1);
					latticino.setStagionatura(Integer.parseInt(TFStagionatura.getText()));
					latticino.setTipo(TFTipo.getText());
					Ctrl_gestisciListino.getInstance().salvaProdotto(latticino);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static NuovoLatticiniView getInstance(){
		if(instance == null)
			 instance = new NuovoLatticiniView();
		return  (NuovoLatticiniView) instance;
	}
	
	
	public void resetNewProdotto(){
		super.resetNewProdotto();
		TFTipo.setText(null);
		TFStagionatura.setText(null);
	}
}
