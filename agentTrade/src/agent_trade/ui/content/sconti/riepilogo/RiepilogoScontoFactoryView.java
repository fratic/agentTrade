package agent_trade.ui.content.sconti.riepilogo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.util.Costanti;

public class RiepilogoScontoFactoryView extends JPanel{

	/*attributi di classe*/
	
	protected static RiepilogoScontoFactoryView instance;
	
	protected JPanel pannelloCentro;
	protected JPanel pannelloCampi;
	protected JPanel contenitoreCampi;
	protected JPanel pannelloEast;
	protected JPanel pannelloBottoni;
	protected JPanel pannTipo;
	protected JPanel pannID;
	protected JPanel pannErrore;
	
	protected JLabel labelTipo;
	protected JLabel labelID;
	protected JLabel labelErrore;
	
	protected JTextField TFTipo;
	protected JTextField TFID;
	
	protected JButton bottoneModificaSconto;
	protected JButton bottoneCancellaSconto;
	protected JButton bottoneSalvaModifiche;
	protected JButton bottoneAnnullaModifica;

		
	/*attributi privati*/
		
	
	/*costruttori*/
	
	protected RiepilogoScontoFactoryView() {
		this.initComponent();
	}
	
	/*metodi di classe*/
	
	public static RiepilogoScontoFactoryView getInstance(M_Sconto sconto){
		
		if(sconto instanceof M_ScontoCliente){
			instance = RiepilogoScontoClienteView.getInstance();
		}
		else if(sconto instanceof M_ScontoPercent){
			instance = RiepilogoScontoPercentualeView.getInstance();
		}
		else if(sconto instanceof M_ScontoQuantita){
			instance = RiepilogoScontoQuantitaView.getInstance();
		}
		return instance;
	}
	
	public static void cancRiepilogoSconto(){
		instance = null;
	}
	
	
	/*metodi privati*/
	
	protected void initComponent(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),  Costanti.TITOLO_SELEZIONA_SCONTO, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		pannTipo.add(TFTipo);
		
		pannID = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannID.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannID.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannID);
		
		labelID = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID_SCONTO);
		labelID.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelID.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannID.add(labelID);
		
		TFID = new JTextField();
		TFID.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFID.setEditable(false);
		pannID.add(TFID);
	
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
		
		
		bottoneModificaSconto = new JButton("");
		bottoneModificaSconto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneModificaSconto);
		bottoneModificaSconto.setToolTipText(Costanti.TIP_MODIFICA_SCONTO);
		bottoneModificaSconto.setIcon(new ImageIcon(RiepilogoScontoFactoryView.class.getResource(Costanti.MOD_SCONTO_ICON)));
		
		bottoneCancellaSconto = new JButton("");
		bottoneCancellaSconto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneCancellaSconto);
		bottoneCancellaSconto.setToolTipText(Costanti.TIP_CANCELLA_SCONTO);
		bottoneCancellaSconto.setIcon(new ImageIcon(RiepilogoScontoFactoryView.class.getResource(Costanti.CANC_SCONTO_ICON)));
		
		bottoneSalvaModifiche = new JButton("");
		bottoneSalvaModifiche.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaModifiche);
		bottoneSalvaModifiche.setToolTipText(Costanti.TIP_SALVA_MOD_SCONTO);
		bottoneSalvaModifiche.setIcon(new ImageIcon(RiepilogoScontoFactoryView.class.getResource(Costanti.SALVA_MOD_SCONTO_ICON)));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaModifica);
		bottoneAnnullaModifica.setToolTipText(Costanti.TIP_ANNULLA_MOD_SCONTO);
		bottoneAnnullaModifica.setIcon(new ImageIcon(RiepilogoScontoFactoryView.class.getResource(Costanti.ANNULLA_MOD_SCONTO_ICON)));
	
	
		bottoneModificaSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Ctrl_gestisciSconto.getInstance().abilitaModifica();
			}
		});
		
		bottoneCancellaSconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Ctrl_gestisciSconto.getInstance().cancellaSconto(Integer.parseInt(TFID.getText()));
			}
		});
		
		bottoneAnnullaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						Ctrl_gestisciSconto.getInstance().annullaModificheSconto(Integer.parseInt(TFID.getText()));
					} catch (NumberFormatException | PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
	}
	
	/*metodi pubblici*/
	
	public void setSchedaSconto( M_Sconto sconto){
		TFID.setText(""+sconto.getId());
	}
	
	
	public void setVisibleBtnSalvaModifiche(boolean b) {
		bottoneSalvaModifiche.setVisible(b);
	}


	public void setVisibleBtnAnnullaModifiche(boolean b) {
		bottoneAnnullaModifica.setVisible(b);
	}


	public void setVisibleBtnModifica(boolean b) {
		bottoneModificaSconto.setVisible(b);
	}
	
	
	public void setVisibleBtnCancella(boolean b) {
		bottoneCancellaSconto.setVisible(b);
	}
	
	
	public void setErrore(String err) {
		labelErrore.setText(err);
    }
	
	
	public void setVisibleErroreRiepSconto(boolean b){
		labelErrore.setVisible(b);
	}

	
	public void setTFeditable(boolean b) {
	
	}
	

	public void abilitaToolTip() {
	
	}
	
	public void disabilitaToolTip() {
		
	}
	
		
}
