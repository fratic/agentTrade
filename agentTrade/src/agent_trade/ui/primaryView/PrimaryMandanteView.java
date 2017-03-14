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
import agent_trade.controller.Ctrl_gestisciAzienda;
import agent_trade.ui.content.agenti.AlberoAgenti;
import agent_trade.ui.content.agenti.DettaglioAgenteView;
import agent_trade.ui.content.agenti.RiepilogoAgenteView;
import agent_trade.ui.content.aziende.AlberoAziende;
import agent_trade.ui.content.aziende.DettaglioAziendaView;
import agent_trade.ui.content.aziende.RiepilogoAziendaView;
import agent_trade.util.Costanti;
import agent_trade.util.Sfondo_Agente;
import agent_trade.util.Sfondo_Azienda;

public class PrimaryMandanteView extends PrimaryViewFactory 
{
	
	/*attributi di classe*/
	
	private static PrimaryMandanteView instance;	

	private static RiepilogoAgenteView riep_agente;
	private static DettaglioAgenteView dettaglio_agente;
	private static JPanel pannello_centrale_agente;
	
	private static RiepilogoAziendaView riep_azienda;
	private static DettaglioAziendaView dettaglio_azienda;
	private static JPanel pannello_centrale_azienda;
	
		
	/*attributi privati*/
	
	private JButton bottoneCercaAgente;
	private JButton bottoneNuovoAgente;

	private JPanel Agente;
	private JPanel pannello_menu_agente;
	private JPanel pannello_sottomenu_agente;
	private JPanel pannello_laterale_agente;
	
	private JPanel alberoAgenti;

	private JPanel Azienda;
	private JPanel pannello_menu_azienda;
	private JPanel pannello_sottomenu_azienda;
	private JPanel pannello_laterale_azienda; 
	
	private JButton bottoneNuovaAzienda;
	private JButton bottoneCercaAzienda;
	
	private JPanel alberoAziende;
	
	
	/*costruttori*/
	
	private PrimaryMandanteView() {
		
		super(Costanti.TITOLO_MANDANTE_PRIMARY_VIEW);
		
		initTabAgente();
		initTabAzienda();
		
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
	
	public static void initRiepilogoAziendaView() {
		
		riep_azienda = RiepilogoAziendaView.getInstance();
		pannello_centrale_azienda.add(riep_azienda);
		pannello_centrale_azienda.repaint();
	}
	
	public static void initDettaglioAzienda() {
		
		dettaglio_azienda = DettaglioAziendaView.getInstance();
		pannello_centrale_azienda.add(dettaglio_azienda);
		pannello_centrale_azienda.repaint();
	}
	
		
	/*metodi privati*/
	
	
	
	private void initTabAgente(){
		
		Agente = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AGENTE, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.AGENTE_ICON)), Agente, Costanti.TIP_GESTISCI_AGENTE);
		Agente.setLayout(new BorderLayout());
		
		pannello_menu_agente = new JPanel();
		pannello_menu_agente.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_agente.setLayout(null);

		pannello_menu_agente.setBackground(Color.WHITE);
		Agente.add(pannello_menu_agente,BorderLayout.NORTH);
		
		bottoneNuovoAgente = new JButton();
		bottoneNuovoAgente.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.NUOVO_AGENTE_ICON)));
		bottoneNuovoAgente.setToolTipText(Costanti.TIP_NUOVO_AGENTE);
		bottoneNuovoAgente.setBounds(25, 25, 50, 50);
		pannello_menu_agente.add(bottoneNuovoAgente);
		
		bottoneCercaAgente = new JButton("");
		bottoneCercaAgente.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_AGENTE_ICON)));
		bottoneCercaAgente.setToolTipText(Costanti.TIP_CERCA_AGENTE);
		bottoneCercaAgente.setBounds(103, 25, 50, 50);
		pannello_menu_agente.add(bottoneCercaAgente);
		
		pannello_sottomenu_agente= new JPanel();
		pannello_sottomenu_agente.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_agente.setLayout(new BorderLayout());
		Agente.add(pannello_sottomenu_agente, BorderLayout.CENTER);

		
		pannello_laterale_agente = new JPanel();
		pannello_laterale_agente.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_agente.add(pannello_laterale_agente, BorderLayout.WEST);
		pannello_laterale_agente.setLayout(null);

		
		alberoAgenti = new AlberoAgenti();
		alberoAgenti.setBounds(0, 0, 261, 617);
		pannello_laterale_agente.add(alberoAgenti);
		
		pannello_centrale_agente = new JPanel();
		pannello_centrale_agente.setBackground(SystemColor.control);

		pannello_centrale_agente.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_agente.add(pannello_centrale_agente, BorderLayout.CENTER);
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
	
	
	private void initTabAzienda(){
		
		Azienda = new JPanel();
		tabbedPrincipale.addTab(Costanti.TAB_AZIENDA, new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.AZIENDA_ICON)), Azienda, Costanti.TIP_GESTISCI_AZIENDA);
		Azienda.setLayout(new BorderLayout());
		
		pannello_menu_azienda = new JPanel();
		pannello_menu_azienda.setPreferredSize(new Dimension(1013, 100));
		pannello_menu_azienda.setLayout(null);
		
		pannello_menu_azienda.setBackground(Color.WHITE);
		Azienda.add(pannello_menu_azienda,BorderLayout.NORTH);
		
		bottoneNuovaAzienda = new JButton();
		bottoneNuovaAzienda.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.NUOVA_AZIENDA_ICON)));
		bottoneNuovaAzienda.setToolTipText(Costanti.TIP_NUOVA_AZIENDA);
		bottoneNuovaAzienda.setBounds(25, 25, 50, 50);
		pannello_menu_azienda.add(bottoneNuovaAzienda);
		
		bottoneCercaAzienda = new JButton("");
		bottoneCercaAzienda.setIcon(new ImageIcon(PrimaryMandanteView.class.getResource(Costanti.CERCA_AZIENDA_ICON)));
		bottoneCercaAzienda.setToolTipText(Costanti.TIP_CERCA_AZIENDA);
		bottoneCercaAzienda.setBounds(103, 25, 50, 50);
		pannello_menu_azienda.add(bottoneCercaAzienda);
		
		pannello_sottomenu_azienda= new JPanel();
		pannello_sottomenu_azienda.setPreferredSize(new Dimension(1013, 617));
		pannello_sottomenu_azienda.setLayout(new BorderLayout());
		Azienda.add(pannello_sottomenu_azienda, BorderLayout.CENTER);
		
		pannello_laterale_azienda = new JPanel();
		pannello_laterale_azienda.setPreferredSize(new Dimension(260, 617));
		pannello_sottomenu_azienda.add(pannello_laterale_azienda, BorderLayout.WEST);
		pannello_laterale_azienda.setLayout(null);
		
		alberoAziende = new AlberoAziende();
		alberoAziende.setBounds(0, 0, 261, 617);
		pannello_laterale_azienda.add(alberoAziende);
		
		pannello_centrale_azienda = new JPanel();
		pannello_centrale_azienda.setBackground(SystemColor.control);
		
		pannello_centrale_azienda.setPreferredSize(new Dimension(753, 617));
		pannello_sottomenu_azienda.add(pannello_centrale_azienda, BorderLayout.CENTER);
		pannello_centrale_azienda.setLayout(new GridLayout(1,1));
		pannello_centrale_azienda.setBorder(new EmptyBorder(7, 7, 0, 7));
		
		setSfondoAzienda();
		
		bottoneCercaAzienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAzienda.getInstance().btnCerca();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			
			}
		});
		
		bottoneNuovaAzienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciAzienda.getInstance().btnNewAzienda();
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
				
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
	
	//rende visibili i tooltip solo quando si modifica l'agente
	public void setVisibleToolTipAgente(){
		((RiepilogoAgenteView) riep_agente).abilitaToolTip();
	}
			
	//rende invisibili i tooltip solo quando si modifica l'agente
	public void setInvisibleToolTipAgente(){
		((RiepilogoAgenteView) riep_agente).disabilitaToolTip();
	}	
	
	//blocca e sblocca bottoni relativi al tab agente
	public void disattivaModificaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnModifiche(b);
	}
			
	public void disattivaSalvaModificheAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnSalvaModifiche(b);
	}
			
	public void disattivaAnnullaModificheAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnAnnullaModifiche(b);
	}
	
	public void disattivaCancellaAgente(boolean b){
		((RiepilogoAgenteView) riep_agente).setVisibleBtnCancella(b);
	}
	
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
	
	
	
	public void setSfondoAzienda() {
		JPanel sfondoAzienda = new Sfondo_Azienda();
		pannello_centrale_azienda.add(sfondoAzienda);
	}
	
	public void resetPannelloCentraleAzienda(){
		pannello_centrale_azienda.removeAll();
		pannello_centrale_azienda.repaint();		
	}
	
	public void setEnableNewAzienda(boolean b) {
		bottoneNuovaAzienda.setEnabled(b);		
	}

	public void setEnableCercaAzienda(boolean b) {
		bottoneCercaAzienda.setEnabled(b);
	}


	public void disattivaModificaAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnModifiche(b);
	}
	
	public void disattivaSalvaModificheAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnSalvaModifiche(b);
	}
	
	public void disattivaAnnullaModificheAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnAnnullaModifiche(b);
	}
	
	public void setSchedaAzienda(String idAzienda, String ragioneSociale, String codice_fiscale, String partita_iva, String citta, String cap, String indirizzo, String email, String telefono, String fax,String url) {
		((RiepilogoAziendaView) riep_azienda).setRiepilogoAzienda(idAzienda, ragioneSociale, codice_fiscale, partita_iva, citta, cap, indirizzo, email, telefono, fax, url);
	}

	public void setVisibleErroreRiepAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleErroreRiepAzienda(b);
	}

	public void disattivaCancellaAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnCancella(b);
	}
	
	public void resetAzienda() {
		((RiepilogoAziendaView) riep_azienda).resetCampiModifica();
	}
	
	public void disattivaInviaPostaAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setVisibleBtnInviaPosta(b);
	}

	public void setInvisibleToolTipAzienda() {
		((RiepilogoAziendaView) riep_azienda).disabilitaToolTip();
	}

	public void setVisibleToolTipAzienda() {
		((RiepilogoAziendaView) riep_azienda).abilitaToolTip();
	}
	
	public void setModificheAzienda(boolean b) {
		((RiepilogoAziendaView) riep_azienda).setTFeditable(b);
	}
	
	public void setVisibleErroreNuovaAzienda(boolean b){
		((DettaglioAziendaView) dettaglio_azienda).setVisibleErroreNuovaAzienda(b);
	}
	
	public void resetNuovaAzienda() {
		((DettaglioAziendaView) dettaglio_azienda).resetNewAzienda();
	}

	
}
