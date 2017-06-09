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

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.util.Costanti;

public class SelezionaScontoView extends JPanel{

	/*attributi di classe*/
	
	public static SelezionaScontoView instance;
	
	/*attributi privati*/
	
	private JPanel pannelloCentro;
	private JPanel pannelloCampi;
	private JPanel contenitoreCampi;
	private JPanel pannSelezione;
	private JPanel pannConferma;
	private JPanel pannelloEast;
	protected JPanel pannelloBottoni;	
	
	private JScrollPane scrollPane;

	private JLabel labelSel;
	private JComboBox JCSel;

	private JButton bottoneEsci;
	private JButton btnConferma;
	
	
	/* costruttori*/
	
	public SelezionaScontoView() {
		
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
		
		pannSelezione = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannSelezione.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannSelezione.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannSelezione);
		
		labelSel = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_TIPO_SCONTO);
		labelSel.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelSel.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannSelezione.add(labelSel);

		JCSel = new JComboBox(Costanti.LISTA_TIPO_SCONTI);
		JCSel.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		JCSel.setToolTipText(Costanti.TIP_TIPO_SCONTO);
		JCSel.setSelectedIndex(0);
		pannSelezione.add(JCSel);
		
		pannConferma = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannConferma.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannConferma.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannConferma);
		
		btnConferma = new JButton("vai all'inserimento");
		btnConferma.setPreferredSize(new Dimension(Costanti.WIDTH_BOTTONE_SELEZ_SCONTO, Costanti.HEIGHT_BOTTONE_SELEZ_SCONTO));
		btnConferma.setEnabled(false);
		btnConferma.setToolTipText(Costanti.TIP_CONFERMA_SEL);
		pannConferma.add(btnConferma);
		
		
		pannelloEast = new JPanel();
		pannelloEast.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_EAST, Costanti.HEIGHT_PANN_EAST));
		FlowLayout flowLayout7  = new FlowLayout(FlowLayout.CENTER);
		pannelloEast.setLayout(flowLayout7);
		this.add(pannelloEast,BorderLayout.EAST);
		
		pannelloBottoni = new JPanel();
		FlowLayout flowLayout8 = (FlowLayout) pannelloBottoni.getLayout();
		flowLayout8.setVgap(15);
		pannelloBottoni.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_BOTTONI, Costanti.HEIGHT_PANN_BOTTONI));
		pannelloEast.add(pannelloBottoni);
					
		bottoneEsci = new JButton("");
		bottoneEsci.setBounds(610, 499, Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON);
		bottoneEsci.setToolTipText(Costanti.TIP_TORNA_INDIETRO);
		bottoneEsci.setIcon(new ImageIcon(SelezionaScontoView.class.getResource(Costanti.INDIETRO_ICON)));
		pannelloBottoni.add(bottoneEsci);
		
		JCSel.addActionListener(
                new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						abilitaInserimento((String) JCSel.getSelectedItem());
						
					}
                }            
        );
		
		
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciSconto.getInstance().ConfermaSelezione((String) JCSel.getSelectedItem());
			}
			});
				
		
		bottoneEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciSconto.getInstance().esciSelezioneSconto();
			}
			});
	
	
	}
	
	/*metodi di classe*/
	
	public static SelezionaScontoView getInstance(){
		if(instance==null)
			instance = new SelezionaScontoView();
		return instance;
	}
	
	public static void cancSelezionaSconto(){
		instance = null;
	}
	
	/*metodi privati*/
	
	private void abilitaInserimento(String valore) {
		
		if(valore.equals("Seleziona sconto"))
	       {
			 btnConferma.setEnabled(false);
	       }
		else 
	       {
	         btnConferma.setEnabled(true);
	       }
	}
	
	/*metodi pubblici*/
	
	public void resetSelezioneSconto(){
		JCSel.setSelectedIndex(0);
		btnConferma.setEnabled(false);
	}
}
