package agent_trade.ui.content.sconti.nuovo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.util.Costanti;

public class NuovoScontoFactoryView extends JPanel {

	/*attributi di classe*/
	
	protected static NuovoScontoFactoryView instance;
	
	protected static String TipoSconto = null;
	
	protected JPanel pannelloCentro;
	protected JPanel pannelloCampi;
	protected JPanel contenitoreCampi;
	protected JPanel pannTipo;
	protected JPanel pannErrore;
	protected JPanel pannelloEast;
	protected JPanel pannelloBottoni;	
	
	protected JScrollPane scrollPane;

	protected JLabel labelTipo;
	protected JLabel labelErrore;
	
	protected JTextField TFTipo;

	protected JButton bottoneEsci;
	protected JButton bottoneSalvaSconto;
	
	
	/*attributi privati*/
		
	
	/*costruttori*/
	
	protected NuovoScontoFactoryView() {
		this.initComponent();
	}
	
	/*metodi di classe*/
	
	public static NuovoScontoFactoryView getInstance(String tipoSconto){
		
		TipoSconto = tipoSconto;
		if(instance == null){
			
			if(tipoSconto == Costanti.LISTA_TIPO_SCONTI[1]){
				instance = NuovoScontoClienteView.getInstance();
			}
			else if (tipoSconto == Costanti.LISTA_TIPO_SCONTI[3]){
				instance = NuovoScontoProdottoPercentualeView.getInstance();
			}
			else if (tipoSconto == Costanti.LISTA_TIPO_SCONTI[2]){
				instance = NuovoScontoProdottoQuantitaView.getInstance();
			}
		}
		return instance;
	}
	
	
	public static void cancNuovoSconto(){
		instance = null;
	}
	
	
	/*metodi privati*/
	
	protected void initComponent(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),  Costanti.TITOLO_NUOVO_SCONTO, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		
		setLayout(new BorderLayout());
		
		pannelloCentro = new JPanel();
		pannelloCentro.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCentro.setLayout(new GridLayout(1,1));
		this.add(pannelloCentro, BorderLayout.CENTER);
		
		pannelloCampi = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pannelloCampi.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		pannelloCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCentro.add(pannelloCampi);
		
//		scrollPane = new JScrollPane(pannelloCampi);
//		scrollPane.setBorder(null);
//		pannelloCentro.add(scrollPane);
		
		contenitoreCampi = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) contenitoreCampi.getLayout();
		flowLayout1.setVgap(15);
		flowLayout1.setHgap(0);
		flowLayout1.setAlignment(FlowLayout.CENTER);
		contenitoreCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCampi.add(contenitoreCampi);
		
		pannTipo = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannTipo.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannTipo.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannTipo);
		
		labelTipo = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TIPO_SCONTO);
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelTipo.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannTipo.add(labelTipo);
		
		TFTipo = new JTextField();
		TFTipo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFTipo.setEditable(false);
		TFTipo.setText(TipoSconto);
		pannTipo.add(TFTipo);
	
		pannelloEast = new JPanel();
		pannelloEast.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_EAST, Costanti.HEIGHT_PANN_EAST));
		FlowLayout flowLayout4  = new FlowLayout(FlowLayout.CENTER);
		pannelloEast.setLayout(flowLayout4);
		this.add(pannelloEast,BorderLayout.EAST);
		
		pannelloBottoni = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) pannelloBottoni.getLayout();
		flowLayout5.setVgap(15);
		pannelloBottoni.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_BOTTONI, Costanti.HEIGHT_PANN_BOTTONI));
		pannelloEast.add(pannelloBottoni);
		
		bottoneSalvaSconto = new JButton("");
		bottoneSalvaSconto.setIcon(new ImageIcon(SelezionaScontoView.class.getResource(Costanti.SALVA_AGENTI_ICON)));
		bottoneSalvaSconto.setToolTipText(Costanti.TIP_SALVA_SCONTO);
		bottoneSalvaSconto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaSconto);
					
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(610, 499, Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON);
		bottoneEsci.setToolTipText(Costanti.TIP_TORNA_INDIETRO);
		bottoneEsci.setIcon(new ImageIcon(SelezionaScontoView.class.getResource(Costanti.INDIETRO_ICON)));
		pannelloBottoni.add(bottoneEsci);
		
				
		bottoneEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciSconto.getInstance().esciNewSconto();
			}
			});
	}

	/*metodi pubblici*/
	
	public void setErrore(String err) {
		labelErrore.setText(err);
    }
	
	public void setVisibleErroreNuovoSconto(boolean b){
		labelErrore.setVisible(b);
	}
	
	public void resetNuovoSconto(){
		TFTipo.setText(null);
	}
		
	
}
