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
import javax.swing.table.TableRowSorter;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.model.M_Cliente;
import agent_trade.util.Costanti;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CercaClienteView extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static CercaClienteView instance;	

	
	/*attributi privati*/

	private JPanel panelloCerca;
	private JPanel panelloRisultati;
	private JPanel panelloBottoni;
	
	private JScrollPane scrollPane;

	private JTextField textFieldCerca;

	private JList<M_Cliente> clienti;
	
	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelCerca;
	
	private JButton BottoneInserisci;
	private JButton BottoneCerca;
	
	
	/*costruttori*/

	public CercaClienteView() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CERCA_CLIENTE);
		setBounds(450, 250, 576, 324);
		getContentPane().setLayout(null);
		
		panelloCerca = new JPanel();
		panelloCerca.setBounds(0, 0, 560, 62);
		getContentPane().add(panelloCerca);
		panelloCerca.setLayout(null);
		
		LabelCerca = new JLabel(Costanti.LABEL_CERCA_CLIENTE);
		LabelCerca.setBounds(34, 11, 74, 40);
		panelloCerca.add(LabelCerca);
		
		textFieldCerca = new JTextField();
		textFieldCerca.setBounds(118, 21, 219, 20);
		panelloCerca.add(textFieldCerca);
		textFieldCerca.setColumns(10);
		
		BottoneCerca = new JButton(Costanti.BOTTONE_CERCA);
		BottoneCerca.setBounds(385, 20, 89, 23);
		panelloCerca.add(BottoneCerca);
		
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(118, 48, 219, 14);
		panelloCerca.add(labelError);
		
		panelloRisultati = new JPanel();
		panelloRisultati.setBounds(0, 62, 560, 176);
		getContentPane().add(panelloRisultati);
		panelloRisultati.setLayout(null);
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_CERCA_CLIENTI;
		
		JTableModel = new DefaultTableModel(
                      new String[][] { },
                      colNames);
				
        table =new JTable();
        
        table.setModel(JTableModel);

        table.setRowSorter (new TableRowSorter (JTableModel));
        
	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 540, 154);
	    panelloRisultati.add(scrollPane);
		 
	  	panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 238, 560, 47);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		BottoneInserisci = new JButton(Costanti.BOTTONE_INSERISCI);
		BottoneInserisci.setEnabled(false);
		BottoneInserisci.setBounds(451, 11, 99, 23);
		panelloBottoni.add(BottoneInserisci);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//fare una funzione che resetta la tabella ed anche tutto il resto che va resettato
				int k=((DefaultTableModel) JTableModel).getRowCount();
					for (int i=k-1; i>=0;i--){
						((DefaultTableModel) JTableModel).removeRow(i);
					}
				try {
					Ctrl_gestisciClienteFactory.getInstance().cercaCliente(textFieldCerca.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}	
			}
		});
	
		
		BottoneInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//qui andrebbe passato o l'id del cliente oppure (meglio) l'oggetto cliente. AGGIUSTARE	
				try {
					Ctrl_elaboraPreventivo.getInstance().inserisciCliente((Integer)table.getValueAt(table.getSelectedRow(),0));
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});

		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
			    BottoneInserisci.setEnabled(true);
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
			((DefaultTableModel) JTableModel).addRow(new Object[]{c.getIdCliente(), c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getPartita_iva(),});
		}
	}
	
	public void updateTable(int id, String cognome, String nome,String cf,String p_iva){
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
			labelError.setText("");
            ((DefaultTableModel) JTableModel).addRow(new Object[]{ id, cognome,  nome, cf, p_iva});
	}
	
	public void setErrore(String err) {
		labelError.setText(err);
	}
	
	public String getRicerca(){
		return textFieldCerca.getText();
	}
	
	public static CercaClienteView getInstance(){
		if (instance==null)
			instance = new CercaClienteView();
		return instance;	 
	}
	
	public static void cancInst(){
		instance=null;	 
	}
		
	public TableModel getJTableModel(){
		return JTableModel;	 
	}
	
	
	public JTable getTableInstance(){
		return table;	 
	}
	
	public void setElements(M_Cliente[] listData){
		this.clienti.setListData(listData);
	}
	
	private void init(){
		this.clienti = new JList<M_Cliente>();
	}
	
}
