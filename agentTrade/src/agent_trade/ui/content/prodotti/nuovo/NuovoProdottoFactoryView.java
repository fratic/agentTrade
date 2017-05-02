package agent_trade.ui.content.prodotti.nuovo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class NuovoProdottoFactoryView extends JPanel{

	/*attributi di classe*/
	protected static NuovoProdottoFactoryView instance;
	
//	protected M_Prodotto prodotto;
	protected static M_Azienda aziendaRif;
	
	protected JPanel pannelloCentro;
	protected JScrollPane scrollPane;
	protected JPanel pannelloCampi;
	protected JPanel contenitoreCampi;
	protected JPanel pannIdProdotto;
	protected JPanel pannNome;
	protected JPanel pannCategoria;
	protected JPanel pannPrezzo;
	protected JPanel pannSconto;
	protected JPanel pannVersione;
	protected JPanel pannDescrizione;
	protected JPanel pannelloEast;
	protected JPanel pannelloBottoni;
	protected JPanel pannErrore;
	
	protected JLabel labelIdProdotto;
	protected JLabel labelNome;
	protected JLabel labelCategoria;
	protected JLabel labelPrezzo;
	protected JLabel labelSconto;
	protected JLabel labelDescrizione;
	protected JLabel labelVersione;
	protected JLabel labelErrore;
	
	protected JTextField TFidProdotto;	
	protected JTextField TFNome;
	protected JTextField TFCategoria;
	protected JTextField TFPrezzo;
	protected JTextField TFSconto;
	protected JTextField TFVersione;	
	protected JTextArea TADescrizione;
	
	protected JButton bottoneSalvaProdotto;
	protected JButton bottoneAnnullaNuovo;
	/*attributi privati*/
	
	
	
	/*costruttori*/
	
	protected NuovoProdottoFactoryView(){
		this.initComponent();
	}
	
	
	/*metodi di classe*/
	
	public static NuovoProdottoFactoryView getInstance(M_Azienda azienda){
		
		aziendaRif = azienda;
		
		if (instance == null){			
			if(azienda.getTipoProdotto().equals("vini")){
				instance = NuovoViniView.getInstance();
			}
//			else if(azienda.getTipoProdotto() == "dolci"){
//				instance = NuovoDolciView.getInstance();
//			}
//			else if(azienda.getTipoProdotto() == "carni"){
//				instance = NuovoCarniView.getInstance();
//			}
		}
		return instance;
	}
	
	public static void cancNuovoProdotto(){
		instance = null;
	}
	
	/*metodi privati*/
	
	protected void initComponent(){
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_NUOVO_PRODOTTO, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		
		scrollPane = new JScrollPane(pannelloCampi);
		scrollPane.setBorder(null);
		pannelloCentro.add(scrollPane);
		
		contenitoreCampi = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) contenitoreCampi.getLayout();
		flowLayout1.setVgap(15);
		flowLayout1.setHgap(0);
		flowLayout1.setAlignment(FlowLayout.CENTER);
		contenitoreCampi.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_CENTRO, Costanti.HEIGHT_PANN_CENTRO));
		pannelloCampi.add(contenitoreCampi);
		
//		pannIdProdotto = new JPanel();
//		FlowLayout flowLayout2 = (FlowLayout) pannIdProdotto.getLayout();
//		flowLayout2.setHgap(0);
//		flowLayout2.setVgap(0);
//		pannIdProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
//		contenitoreCampi.add(pannIdProdotto);
//		
//		labelIdProdotto = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID_PROD);
//		labelIdProdotto.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
//		labelIdProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
//		pannIdProdotto.add(labelIdProdotto);
//
//		TFidProdotto = new JTextField();
//		TFidProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
//		TFidProdotto.setEditable(false);
//		pannIdProdotto.add(TFidProdotto);
		
		pannNome = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) pannNome.getLayout();
		flowLayout3.setHgap(0);
		flowLayout3.setVgap(0);
		pannNome.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannNome);
		
		labelNome = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_NOME_PROD);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelNome.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannNome.add(labelNome);

		TFNome = new JTextField();
		TFNome.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFNome.setToolTipText(Costanti.TIP_NOME_PRODOTTO);
		pannNome.add(TFNome);
		
		pannCategoria = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) pannCategoria.getLayout();
		flowLayout4.setHgap(0);
		flowLayout4.setVgap(0);
		pannCategoria.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannCategoria);
		
		labelCategoria = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_CATEGORIA_PROD);
		labelCategoria.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelCategoria.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannCategoria.add(labelCategoria);

		TFCategoria = new JTextField();
		TFCategoria.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFCategoria.setToolTipText(Costanti.TIP_CATEGORIA_PRODOTTO);
		pannCategoria.add(TFCategoria);
		
		pannPrezzo = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) pannPrezzo.getLayout();
		flowLayout5.setHgap(0);
		flowLayout5.setVgap(0);
		pannPrezzo.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannPrezzo);
		
		labelPrezzo = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_PREZZO_PROD);
		labelPrezzo.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelPrezzo.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannPrezzo.add(labelPrezzo);

		TFPrezzo = new JTextField();
		TFPrezzo.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFPrezzo.setToolTipText(Costanti.TIP_PREZZO_PRODOTTO);
		pannPrezzo.add(TFPrezzo);
		
		pannSconto = new JPanel();
		FlowLayout flowLayout6 = (FlowLayout) pannSconto.getLayout();
		flowLayout6.setHgap(0);
		flowLayout6.setVgap(0);
		pannSconto.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannSconto);
		
		labelSconto = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_SCONTO_PROD);
		labelSconto.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelSconto.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannSconto.add(labelSconto);

		TFSconto = new JTextField();
		TFSconto.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFSconto.setToolTipText(Costanti.TIP_SCONTO_PRODOTTO);
		pannSconto.add(TFSconto);
		
//		pannVersione = new JPanel();
//		FlowLayout flowLayout7 = (FlowLayout) pannVersione.getLayout();
//		flowLayout7.setHgap(0);
//		flowLayout7.setVgap(0);
//		pannVersione.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
//		contenitoreCampi.add(pannVersione);
//		
//		labelVersione = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_VERSIONE_PROD);
//		labelVersione.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
//		labelVersione.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
//		pannVersione.add(labelVersione);
//
//		TFVersione = new JTextField();
//		TFVersione.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
//		TFVersione.setText("1");
//		TFVersione.setEditable(false);
//		pannVersione.add(TFVersione);
		
		pannDescrizione = new JPanel();
		FlowLayout flowLayout8 = (FlowLayout) pannDescrizione.getLayout();
		flowLayout8.setHgap(0);
		flowLayout8.setVgap(0);
		pannDescrizione.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, 60));
		contenitoreCampi.add(pannDescrizione);
		
		labelDescrizione = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_DESCRIZIONE_PROD);
		labelDescrizione.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelDescrizione.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannDescrizione.add(labelDescrizione);

		TADescrizione = new JTextArea();
		TADescrizione.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		TADescrizione.setBackground(UIManager.getColor("CheckBox.background"));
		TADescrizione.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,60));
		TADescrizione.setToolTipText(Costanti.TIP_DESCRIZIONE_PRODOTTO);
		pannDescrizione.add(TADescrizione);
		
		pannelloEast = new JPanel();
		pannelloEast.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_EAST, Costanti.HEIGHT_PANN_EAST));
		FlowLayout fl_pannelloOvest = new FlowLayout(FlowLayout.CENTER);
		pannelloEast.setLayout(fl_pannelloOvest);
		this.add(pannelloEast,BorderLayout.EAST);
		
		pannelloBottoni = new JPanel();
		FlowLayout flowLayout9 = (FlowLayout) pannelloBottoni.getLayout();
		flowLayout9.setVgap(15);
		pannelloBottoni.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_BOTTONI, Costanti.HEIGHT_PANN_BOTTONI));//DA MODIFICARE I DUE BOTTONI SOTTO IN TEORIA NN DEVONO COMPARIRE
		pannelloEast.add(pannelloBottoni);
				
		bottoneSalvaProdotto = new JButton("");
		bottoneSalvaProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaProdotto);
		bottoneSalvaProdotto.setToolTipText(Costanti.TIP_SALVA_NUOVO_PRODOTTO);
		bottoneSalvaProdotto.setIcon(new ImageIcon(NuovoProdottoFactoryView.class.getResource(Costanti.SALVA_MOD_PRODOTTO_ICON)));
		
		bottoneAnnullaNuovo = new JButton("");
		bottoneAnnullaNuovo.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaNuovo);
		bottoneAnnullaNuovo.setToolTipText(Costanti.TIP_ANNULLA_NUOVO_PRODOTTO);
		bottoneAnnullaNuovo.setIcon(new ImageIcon(NuovoProdottoFactoryView.class.getResource(Costanti.ANNULLA_MOD_PRODOTTO_ICON)));
		
		bottoneAnnullaNuovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciListino.getInstance().mostraCatalogo();
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	/*metodi pubblici*/	
	
	public void setErrore(String err) {
		labelErrore.setText(err);
    }
	
	public void setVisibleErroreNuovoProdotto(boolean b){
		labelErrore.setVisible(b);
	}
		
	public void resetNewProdotto(){
		
		TFNome.setText(null);
		TFCategoria.setText(null);
		TFPrezzo.setText(null);
		TFSconto.setText(null);
		TADescrizione.setText(null);
	}
}
