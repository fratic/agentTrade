package agent_trade.ui.primaryView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.agenti.DettaglioAgenteView;
import agent_trade.ui.content.agenti.RiepilogoAgenteView;
import agent_trade.util.Costanti;
import agent_trade.util.Sfondo_Agente;

public class PrimaryMandanteView extends PrimaryViewFactory 
{
	
	/*attributi di classe*/
	
	private static PrimaryMandanteView instance;	

	private static RiepilogoAgenteView riep_agente;
	private static DettaglioAgenteView dettaglio_agente;
	private static JPanel pannello_centrale_agente;

	
	/*attributi privati*/
	
	private JButton bottoneCercaAgente;
	private JButton bottoneNuovoAgente;

	private JPanel Agente;
	private JPanel panello_menu_agente;
	private JPanel panello_sottomenu_agente;
	private JPanel panello_laterale_agente;
	
	private JPanel alberoAgenti;

	
	
	/*costruttori*/
	
	private PrimaryMandanteView() {
		
		super(Costanti.TITOLO_MANDANTE_PRIMARY_VIEW);
		
		initTabAgente();
		
	}
	
	
	/*metodi di classe*/
	
	
	public static PrimaryMandanteView getInstance(){
		if (instance==null)
			instance = new PrimaryMandanteView();
		return instance;	 
	}
	

	public static void initDettaglioAgente() {
		
		dettaglio_agente = DettaglioAgenteView.getInstance();
		pannello_centrale_agente.add(dettaglio_agente);
		pannello_centrale_agente.repaint();
	}
	
	
	public static void initRiepilogoAgenteView() {
		
		riep_agente = RiepilogoAgenteView.getInstance();
		pannello_centrale_agente.add(riep_agente);
		pannello_centrale_agente.repaint();
		
	}
	
	
		
	/*metodi privati*/
	
	
	
	public void initTabAgente(){
		
		Agente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AGENTE, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.AGENTE_ICON)), Agente, Costanti.TIP_GESTISCI_AGENTE);
		Agente.setLayout(new BorderLayout());
		
		panello_menu_agente = new JPanel();
		panello_menu_agente.setPreferredSize(new Dimension(1013, 100));
		panello_menu_agente.setLayout(null);

		panello_menu_agente.setBackground(Color.WHITE);
		Agente.add(panello_menu_agente,BorderLayout.NORTH);
		
		bottoneNuovoAgente = new JButton();
		bottoneNuovoAgente.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.NUOVO_AGENTE_ICON)));
		bottoneNuovoAgente.setToolTipText(Costanti.TIP_NUOVO_AGENTE);
		bottoneNuovoAgente.setBounds(25, 25, 50, 50);
		panello_menu_agente.add(bottoneNuovoAgente);
		
		bottoneCercaAgente = new JButton("");
		bottoneCercaAgente.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_AGENTE_ICON)));
		bottoneCercaAgente.setToolTipText(Costanti.TIP_CERCA_AGENTE);
		bottoneCercaAgente.setBounds(103, 25, 50, 50);
		panello_menu_agente.add(bottoneCercaAgente);
		
		panello_sottomenu_agente= new JPanel();
		panello_sottomenu_agente.setPreferredSize(new Dimension(1013, 617));
		panello_sottomenu_agente.setLayout(new BorderLayout());
		Agente.add(panello_sottomenu_agente, BorderLayout.CENTER);

		
		panello_laterale_agente = new JPanel();
		panello_laterale_agente.setPreferredSize(new Dimension(260, 617));
		panello_sottomenu_agente.add(panello_laterale_agente, BorderLayout.WEST);
		panello_laterale_agente.setLayout(null);

		
		alberoAgenti = new AlberoAgenti();
		alberoAgenti.setBounds(0, 0, 261, 617);
		panello_laterale_agente.add(alberoAgenti);
		
		pannello_centrale_agente = new JPanel();
		pannello_centrale_agente.setBackground(SystemColor.control);

		pannello_centrale_agente.setPreferredSize(new Dimension(753, 617));
		panello_sottomenu_agente.add(pannello_centrale_agente, BorderLayout.CENTER);
		pannello_centrale_agente.setLayout(new GridLayout(1,1));
		pannello_centrale_agente.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoAgente();
		
		bottoneCercaAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAgente.getInstance().btnCerca();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			
			}
		});
		
		bottoneNuovoAgente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_gestisciAgente.getInstance().btnNewAgente();
				
			}
		});
			
	}
	
	
	
	/*metodi pubblici*/
	
	
	public void setSfondoAgente() 
	{
		JPanel sfondoAgente=new Sfondo_Agente();
		pannello_centrale_agente.add(sfondoAgente);
		
	}
	
	public void resetPannelloCentraleAgente(){
		pannello_centrale_agente.removeAll();
		pannello_centrale_agente.repaint();		
	}
	
	public void resetNuovoAgente() {
		((DettaglioAgenteView) dettaglio_agente).resetNewAgente();
	}
	
	public void resetAgente() {
		((RiepilogoAgenteView) riep_agente).resetCampiModifica();
	}
	
	public void setEnableCercaAgente(boolean b){
		bottoneCercaAgente.setEnabled(b);
	}
	
	public void setEnableNewAgente(boolean b){
		bottoneNuovoAgente.setEnabled(b);
	}
	
	//sblocca i campi per la modifica agente
	public void setModificheAgente(boolean b) {
		((RiepilogoAgenteView) riep_agente).setTFeditable(b);	
	}
	
	//rende visibili i tooltip solo quando si modifica il cliente
	public void setVisibleToolTipAgente(){
		((RiepilogoAgenteView) riep_agente).abilitaToolTip();
	}
			
	//rende invisibili i tooltip solo quando si modifica il cliente
	public void setInvisibleToolTipAgente(){
		((RiepilogoAgenteView) riep_agente).disabilitaToolTip();
	}	
	
	//blocca e sblocca bottoni relativi al tab agente
	public void disattivaModificaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnModifiche(b);
	}
		
	// relativo all'agente
	public void disattivaSalvaModificheAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnSalvaModifiche(b);
	}
			
	//relativo all'agente
	public void disattivaAnnullaModificheAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnAnnullaModifiche(b);
	}
	
	//relativo all'agente
	public void disattivaCancellaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnCancella(b);
	}
	
	//relativo all'agente
	public void disattivaInviaPostaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnInviaPosta(b);
	}
	
	public void setVisibleErroreRiepAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleErroreRiepAgente(b);
	}
	
	public void setSchedaAgente(String id, String cognome, String nome, String livello, String citta, String cap, String indirizzo, String email, String cellulare,  String username, String password) {
		
		((RiepilogoAgenteView) riep_agente).setRiepilogoAgente(id, cognome, nome, livello, citta, cap, indirizzo, email, cellulare, username, password);
	}
	
	public void setVisibleErroreNuovoAgente(boolean b){
		((DettaglioAgenteView) dettaglio_agente).setVisibleErroreNuovoAgente(b);
	}
	
}
