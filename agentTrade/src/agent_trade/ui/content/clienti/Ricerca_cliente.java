package agent_trade.ui.content.clienti;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.model.M_Cliente;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Ricerca_cliente extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_cliente instance;
	
	/*attributi privati*/

	private JPanel pannelloCerca;
	private JPanel pannelloRisultati;
	private JPanel pannelloBottoni;
	private JPanel pannCognome;
	private JPanel pannPIVA;
	private JPanel pannCodFis;
	private JPanel pannCitta;
	private JPanel pannErrore;
	private JPanel pannBottone;
	
	private JScrollPane scrollPane;
	
	private JTable table;
	private TableModel JTableModel;
	
	private JLabel LabelCognome;
	private JLabel labelPI;
	private JLabel labelCodFis;
	private JLabel labelCitta;
	private JLabel labelError;
	
	private JTextField TFCognome;
	private JTextField TFPI;
	private JTextField TFCodFis;
	private JTextField TFCitta;
	
	private JButton BottoneVisualizza;
	private JButton BottoneCerca;

		
	/*costruttori*/

	public Ricerca_cliente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CERCA_CLIENTE);
		setBounds(450, 250, 749, 406);
		getContentPane().setLayout(null);
		
		pannelloCerca = new JPanel();
		pannelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(pannelloCerca);
		
		pannCognome = new JPanel();
		pannCognome.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCognome);
		
		LabelCognome = new JLabel(Costanti.LABEL_COGNOME);
		LabelCognome.setPreferredSize(new Dimension(137, 14));
		pannCognome.add(LabelCognome);
		
		TFCognome = new JTextField();
		TFCognome.setPreferredSize(new Dimension(180, 20));
		pannCognome.add(TFCognome);
		
		pannPIVA = new JPanel();
		pannPIVA.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannPIVA);
		
		labelPI = new JLabel(Costanti.LABEL_PARTITA_IVA);
		labelPI.setPreferredSize(new Dimension(137, 14));
		pannPIVA.add(labelPI);
		
		TFPI = new JTextField();
		TFPI.setPreferredSize(new Dimension(180, 20));
		pannPIVA.add(TFPI);
		
		pannCodFis = new JPanel();
		pannCodFis.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCodFis);
		
		labelCodFis = new JLabel(Costanti.LABEL_COD_FISC);
		labelCodFis.setPreferredSize(new Dimension(137, 14));
		pannCodFis.add(labelCodFis);
		
		TFCodFis = new JTextField();
		TFCodFis.setPreferredSize(new Dimension(180, 20));
		pannCodFis.add(TFCodFis);
		
		pannCitta = new JPanel();
		pannCitta.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCitta);
		
		labelCitta = new JLabel(Costanti.LABEL_CITTA);
		labelCitta.setPreferredSize(new Dimension(137, 14));
		pannCitta.add(labelCitta);
		
		TFCitta = new JTextField();
		TFCitta.setPreferredSize(new Dimension(180, 20));
		pannCitta.add(TFCitta);
		
		pannErrore = new JPanel();
		pannErrore.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannErrore);
				
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setPreferredSize(new Dimension(350, 14));
		pannErrore.add(labelError);
		
		pannBottone = new JPanel();
		pannBottone.setPreferredSize(new Dimension(365, 30));
		pannBottone.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		pannelloCerca.add(pannBottone);
		
		BottoneCerca = new JButton(Costanti.BOTTONE_CERCA);
		BottoneCerca.setPreferredSize(new Dimension(90, 25));
		pannBottone.add(BottoneCerca);
		
		pannelloRisultati = new JPanel();
		pannelloRisultati.setBounds(0, 114, 743, 216);
		getContentPane().add(pannelloRisultati);
		pannelloRisultati.setLayout(null);
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_RICERCA_CLIENTI;
		JTableModel = new DefaultTableModel(
                new String[][] { },
                colNames);
			
		table = new JTable();
        
        table.setModel(JTableModel);
        
        table.setRowSorter (new TableRowSorter (JTableModel)); 

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 723, 200);
	    pannelloRisultati.add(scrollPane);
		 
	  	pannelloBottoni = new JPanel();
		pannelloBottoni.setBounds(0, 321, 743, 47);
		getContentPane().add(pannelloBottoni);
		pannelloBottoni.setLayout(null);
		
		BottoneVisualizza = new JButton(Costanti.BOTTONE_VISUALIZZA);
		BottoneVisualizza.setEnabled(false);
		BottoneVisualizza.setBounds(634, 11, 99, 23);
		pannelloBottoni.add(BottoneVisualizza);
		
		//resetta i campi della ricerca e svuota la tabella
		JButton BottoneAnnullaCerca = new JButton(Costanti.BOTTONE_ANNULLA);
		BottoneAnnullaCerca.setBounds(506, 11, 99, 23);
		pannelloBottoni.add(BottoneAnnullaCerca);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneAnnullaCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciClienteFactory.getInstance().annullaRicercaCliente();
			}
		});
		
		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//fare una funzione che resetta la tabella ed anche tutto il resto che va resettato
				int k=((DefaultTableModel) JTableModel).getRowCount();
					for (int i=k-1; i>=0;i--){
						((DefaultTableModel) JTableModel).removeRow(i);
					}
					//fare le modifiche a ricerca cliente!!!!
					try {
						Ctrl_gestisciClienteFactory.getInstance().ricercaCliente(TFCognome.getText(), TFPI.getText(), TFCodFis.getText(), TFCitta.getText());
					} 
					catch (PersistentException e) {
						e.printStackTrace();
					}
			}
		});
		
		BottoneVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//qui andrebbe passato o l'id del cliente oppure (meglio) l'oggetto cliente. AGGIUSTARE	
				try {
					//SE QUI VA PASSATO L'ID (e va fatto), BISOGNA INSERIRLO ANCHE IN TABELLA
					Ctrl_gestisciClienteFactory.getInstance().recuperaCliente((int) table.getValueAt(table.getSelectedRow(),0));
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				BottoneVisualizza.setEnabled(true);
			     }
		});		 
	}
	
	/*metodi di classe*/
	
	public static Ricerca_cliente getInstance(){
		if (instance==null)
			instance = new Ricerca_cliente();
		return instance;	 
	}
	
	public static void cancInstanza(){
		instance=null;	 
	}
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	public void popolaTab(M_Cliente[] a){
		
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
		labelError.setText("");
		
		for (M_Cliente c : a) {
			((DefaultTableModel) JTableModel).addRow(new Object[]{c.getIdCliente(),c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getPartita_iva(), c.getCitta()});
		}	
	}
	
	
	public void updateTable(int id, String cognome, String nome,String cf, String pi, String citta){
//		int k=((DefaultTableModel) JTableModel).getRowCount();
//		for (int i=k-1; i>=0;i--){
//			((DefaultTableModel) JTableModel).removeRow(i);
//		}
			labelError.setText("");
            ((DefaultTableModel) JTableModel).addRow(new Object[]{id, cognome, nome, cf, pi, citta});
	}
	
	//resetta i campi della ricerca cliente
	public void resetRicerca(){
		TFCognome.setText(null);
		TFPI.setText(null);
		TFCodFis.setText(null);
		TFCitta.setText(null);
	}
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	public void setVisibleErroreRicercaCliente(boolean b){
		labelError.setVisible(b);
	}
	
	public void setErrore(String err) {
		labelError.setText(err);
	}
	
////	non usato
//	public String getRicerca(){
//		return TFCognome.getText();
//	}
//	
////	non usato	
//	public TableModel getJTableModel(){
//		return JTableModel;	 
//	}
////	non usato
//	public JTable getTableInstance(){
//		return table;	 
//	}
////	non usato	
//	private void init(){
//		this.clienti = new JList<M_Cliente>();
//	}
}
		


