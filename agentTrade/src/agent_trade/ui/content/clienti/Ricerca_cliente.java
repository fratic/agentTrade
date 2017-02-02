package agent_trade.ui.content.clienti;

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

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Ricerca_cliente extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_cliente instance;
	
	/*attributi privati*/

	private JPanel panelloCerca;
	private JPanel panelloRisultati;
	private JPanel panelloBottoni;
	
	private JScrollPane scrollPane;

	private JTextField TFCerca;

	private JList<M_Cliente> clienti;
	
	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelCerca;
	
	private JButton BottoneVisualizza;
	private JButton BottoneCerca;
	private JTextField TFcercaPI;
	private JTextField TFcercaCF;
	private JTextField TFcercaCitta;
	
	/*costruttori*/

	public Ricerca_cliente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle("Cerca Cliente");
		setBounds(450, 250, 749, 406);
		getContentPane().setLayout(null);
		
		panelloCerca = new JPanel();
		panelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(panelloCerca);
		panelloCerca.setLayout(null);
		
		LabelCerca = new JLabel("Cognome o ragione sociale");
		LabelCerca.setBounds(10, 11, 137, 40);
		panelloCerca.add(LabelCerca);
		
		TFCerca = new JTextField();
		TFCerca.setBounds(157, 21, 180, 20);
		panelloCerca.add(TFCerca);
		TFCerca.setColumns(10);
		
		JLabel labelCercaPI = new JLabel("Partita Iva");
		labelCercaPI.setBounds(365, 11, 64, 40);
		panelloCerca.add(labelCercaPI);
		
		TFcercaPI = new JTextField();
		TFcercaPI.setColumns(10);
		TFcercaPI.setBounds(439, 21, 180, 20);
		panelloCerca.add(TFcercaPI);
		
		JLabel labelCercaCF = new JLabel("Codice Fiscale");
		labelCercaCF.setBounds(10, 50, 137, 40);
		panelloCerca.add(labelCercaCF);
		
		TFcercaCF = new JTextField();
		TFcercaCF.setColumns(10);
		TFcercaCF.setBounds(157, 60, 180, 20);
		panelloCerca.add(TFcercaCF);
		
		JLabel labelCercaCitta = new JLabel("Citt\u00E0");
		labelCercaCitta.setBounds(365, 50, 64, 40);
		panelloCerca.add(labelCercaCitta);
		
		TFcercaCitta = new JTextField();
		TFcercaCitta.setColumns(10);
		TFcercaCitta.setBounds(439, 60, 180, 20);
		panelloCerca.add(TFcercaCitta);
		
		BottoneCerca = new JButton("Cerca");
		BottoneCerca.setBounds(644, 80, 89, 23);
		panelloCerca.add(BottoneCerca);
		
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(10, 89, 219, 14);
		panelloCerca.add(labelError);
		
		panelloRisultati = new JPanel();
		panelloRisultati.setBounds(0, 114, 743, 176);
		getContentPane().add(panelloRisultati);
		panelloRisultati.setLayout(null);
		
		JTableModel = new DefaultTableModel(
                new String[][] { },
                new String[] {"ID", "Cognome", "Nome","Codice Fiscale", "Partita iva"});
			
		table =new JTable();
        
        table.setModel(JTableModel);

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 723, 154);
	    panelloRisultati.add(scrollPane);
		 
	  	panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 291, 743, 47);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		BottoneVisualizza = new JButton("Visualizza");
		BottoneVisualizza.setEnabled(false);
		BottoneVisualizza.setBounds(634, 11, 99, 23);
		panelloBottoni.add(BottoneVisualizza);
		
		//resetta i campi della ricerca e svuota la tabella
		JButton BottoneAnnullaCerca = new JButton("Annulla");
		BottoneAnnullaCerca.setBounds(506, 11, 99, 23);
		panelloBottoni.add(BottoneAnnullaCerca);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneAnnullaCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().annullaRicercaCliente();
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
						Ctrl_gestisciCliente.getInstance().ricercaCliente(TFCerca.getText(), TFcercaPI.getText(), TFcercaCF.getText(), TFcercaCitta.getText());
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
					Ctrl_gestisciCliente.getInstance().recuperaCliente((int) table.getValueAt(table.getSelectedRow(),0));
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
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	public void popolaTab(M_Cliente[] a){
		
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
		labelError.setText("");
		
		for (M_Cliente c : a) {
			((DefaultTableModel) JTableModel).addRow(new Object[]{c.getIdCliente(),c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getPartita_iva()});
		}	
	}
	
	
	public void updateTable(int id, String cognome, String nome,String cf, String pi){
//		int k=((DefaultTableModel) JTableModel).getRowCount();
//		for (int i=k-1; i>=0;i--){
//			((DefaultTableModel) JTableModel).removeRow(i);
//		}
			labelError.setText("");
            ((DefaultTableModel) JTableModel).addRow(new Object[]{id, cognome, nome, cf, pi});
	}
	
	//resetta i campi della ricerca cliente
	public void resetRicerca(){
		TFCerca.setText(null);
		TFcercaPI.setText(null);
		TFcercaCF.setText(null);
		TFcercaCitta.setText(null);
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
	
	public static void cancInstanza(){
		instance=null;	 
	}
	
	public String getRicerca(){
		return TFCerca.getText();
	}
	
	public static Ricerca_cliente getInstance(){
		if (instance==null)
			instance = new Ricerca_cliente();
		return instance;	 
	}
		
	public TableModel getJTableModel(){
		return JTableModel;	 
	}
		
	public JTable getTableInstance(){
		return table;	 
	}
		
	private void init(){
		this.clienti = new JList<M_Cliente>();
	}
}
		


