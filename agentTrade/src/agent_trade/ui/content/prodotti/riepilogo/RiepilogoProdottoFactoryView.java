package agent_trade.ui.content.prodotti.riepilogo;

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
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Vini;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public abstract class RiepilogoProdottoFactoryView extends JPanel {

	/*attributi di classe*/
	protected static RiepilogoProdottoFactoryView instance;
	
	protected M_Prodotto prodotto;
	
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
	
	protected JLabel labelIdProdotto;
	protected JLabel labelNome;
	protected JLabel labelCategoria;
	protected JLabel labelPrezzo;
	protected JLabel labelSconto;
	protected JLabel labelDescrizione;
	protected JLabel labelVersione;
	
	protected JTextField TFidProdotto;	
	protected JTextField TFNome;
	protected JTextField TFCategoria;
	protected JTextField TFPrezzo;
	protected JTextField TFSconto;
	protected JTextField TFVersione;	
	protected JTextArea TADescrizione;
	
	protected JButton bottoneModificaProdotto;
	protected JButton bottoneCancellaProdotto;
	protected JButton bottoneIndietro;
	protected JButton bottoneSalvaModifiche;
	protected JButton bottoneAnnullaModifica;
	/*attributi privati*/
	
	
	
	/*costruttori*/
	
	protected RiepilogoProdottoFactoryView(){
		this.initComponent();
	}
	
	
	/*metodi di classe*/
	
	public static RiepilogoProdottoFactoryView getInstance(M_Prodotto prod){
		
		if (instance == null){			
			if(prod instanceof M_Vini){
				instance = RiepilogoViniView.getInstance();
			}
		}
		return instance;
	}
	
	public static void cancRiepilogoProdotto(){
		instance = null;
	}
	
	/*metodi privati*/
	
	protected void initComponent(){
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_SCHEDA_PRODOTTO, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
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
		
		pannIdProdotto = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) pannIdProdotto.getLayout();
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		pannIdProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannIdProdotto);
		
		labelIdProdotto = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_ID_PROD);
		labelIdProdotto.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelIdProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannIdProdotto.add(labelIdProdotto);

		TFidProdotto = new JTextField();
		TFidProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFidProdotto.setEditable(false);
		pannIdProdotto.add(TFidProdotto);
		
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
		TFNome.setEditable(false);
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
		TFCategoria.setEditable(false);
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
		TFPrezzo.setEditable(false);
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
		TFSconto.setEditable(false);
		pannSconto.add(TFSconto);
		
		pannVersione = new JPanel();
		FlowLayout flowLayout7 = (FlowLayout) pannVersione.getLayout();
		flowLayout7.setHgap(0);
		flowLayout7.setVgap(0);
		pannVersione.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_LABEL, Costanti.HEIGHT_PANN_LABEL));
		contenitoreCampi.add(pannVersione);
		
		labelVersione = DefaultComponentFactory.getInstance().createLabel(Costanti.LABEL_VERSIONE_PROD);
		labelVersione.setFont(new Font("Tahoma", Font.PLAIN, Costanti.FONT));
		labelVersione.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL, Costanti.HEIGHT_LABEL));
		pannVersione.add(labelVersione);

		TFVersione = new JTextField();
		TFVersione.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD,Costanti.HEIGHT_TEXT_FIELD));
		TFVersione.setEditable(false);
		pannVersione.add(TFVersione);
		
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
		TADescrizione.setEditable(false);
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
		
		bottoneIndietro = new JButton("");
		bottoneIndietro.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneIndietro);
		bottoneIndietro.setToolTipText(Costanti.TIP_TORNA_ELENCO);
		bottoneIndietro.setIcon(new ImageIcon(RiepilogoProdottoFactoryView.class.getResource(Costanti.INDIETRO_ICON)));
		
		bottoneModificaProdotto = new JButton("");
		bottoneModificaProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneModificaProdotto);
		bottoneModificaProdotto.setToolTipText(Costanti.TIP_MODIFICA_PRODOTTO);
		bottoneModificaProdotto.setIcon(new ImageIcon(RiepilogoProdottoFactoryView.class.getResource(Costanti.MOD_PRODOTTO_ICON)));
		
		bottoneCancellaProdotto = new JButton("");
		bottoneCancellaProdotto.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneCancellaProdotto);
		bottoneCancellaProdotto.setToolTipText(Costanti.TIP_CANCELLA_PRODOTTO);
		bottoneCancellaProdotto.setIcon(new ImageIcon(RiepilogoProdottoFactoryView.class.getResource(Costanti.CANC_PRODOTTO_ICON)));
		
		bottoneSalvaModifiche = new JButton("");
		bottoneSalvaModifiche.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneSalvaModifiche);
		bottoneSalvaModifiche.setToolTipText(Costanti.TIP_SALVA_MOD_PRODOTTO);
		bottoneSalvaModifiche.setIcon(new ImageIcon(RiepilogoProdottoFactoryView.class.getResource(Costanti.SALVA_MOD_PRODOTTO_ICON)));
		
		bottoneAnnullaModifica = new JButton("");
		bottoneAnnullaModifica.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON,Costanti.HEIGHT_BUTTON));
		pannelloBottoni.add(bottoneAnnullaModifica);
		bottoneAnnullaModifica.setToolTipText(Costanti.TIP_ANNULLA_MOD_PRODOTTO);
		bottoneAnnullaModifica.setIcon(new ImageIcon(RiepilogoProdottoFactoryView.class.getResource(Costanti.ANNULLA_MOD_PRODOTTO_ICON)));
		
		bottoneIndietro.addActionListener(new ActionListener() {
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
	
	public void setSchedaProdotto(M_Prodotto prod) {

		prodotto = prod;
		
		TFidProdotto.setText(""+prodotto.getIdProdotto());
		TFNome.setText(prodotto.getNome());
		TFCategoria.setText(prodotto.getCategoria());
		TFPrezzo.setText(""+prodotto.getPrezzo());
		TFSconto.setText(""+prodotto.getSconto());
		TFVersione.setText(""+prodotto.getVersione());
		TADescrizione.setText(prodotto.getIdDescrizioneProdotto());
	}


	public void setVisibleBtnSalvaModifiche(boolean b) {
		
		bottoneSalvaModifiche.setVisible(b);
	}


	public void setVisibleBtnAnnullaModifiche(boolean b) {
		
		bottoneAnnullaModifica.setVisible(b);
	}


	public void setVisibleBtnModifica(boolean b) {
		
		bottoneModificaProdotto.setVisible(b);
	}
	
	
	public void setVisibleBtnCancella(boolean b) {
		
		bottoneCancellaProdotto.setVisible(b);
	}
	
	
	
	
}