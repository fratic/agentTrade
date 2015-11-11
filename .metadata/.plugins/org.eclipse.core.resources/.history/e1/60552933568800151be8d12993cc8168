package agent_trade.ui.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

public class CercaClienteView extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private static CercaClienteView instance;	
	
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
	
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			CercaClienteView dialog = new CercaClienteView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	/**
	 * Create the dialog.
	 */
	public CercaClienteView() {
		
		
		setTitle("Cerca Cliente");
		setBounds(100, 100, 576, 324);
		getContentPane().setLayout(null);
		
		panelloCerca = new JPanel();
		panelloCerca.setBounds(0, 0, 560, 62);
		getContentPane().add(panelloCerca);
		panelloCerca.setLayout(null);
		
		LabelCerca = new JLabel("Cerca Cliente");
		LabelCerca.setBounds(34, 11, 74, 40);
		panelloCerca.add(LabelCerca);
		
		textFieldCerca = new JTextField();
		textFieldCerca.setBounds(118, 21, 219, 20);
		panelloCerca.add(textFieldCerca);
		textFieldCerca.setColumns(10);
		
		BottoneCerca = new JButton("Cerca");
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
		
		
		
		JTableModel = new DefaultTableModel(
                      new String[][] { },
                      new String[] { "Cognome", "Nome", "Codice Fiscale", "Indirizzo", "e-mail" });
				
        table =new JTable();
        
        table.setModel(JTableModel);

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 540, 154);
	    panelloRisultati.add(scrollPane);
		 
	  	panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 238, 560, 47);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		BottoneInserisci = new JButton("Inserisci");
		BottoneInserisci.setEnabled(false);
		BottoneInserisci.setBounds(451, 11, 99, 23);
		panelloBottoni.add(BottoneInserisci);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//BottoneInserisci.setEnabled(false);
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//fare una funzione che resetta la tabella ed anche tutto il resto che va resettato
				int k=((DefaultTableModel) JTableModel).getRowCount();
					for (int i=k-1; i>=0;i--){
						((DefaultTableModel) JTableModel).removeRow(i);
					}
				Ctrl_gestisciCliente.getInstance().cercaCliente(textFieldCerca.getText());	
			}
		});
	
		BottoneInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//qui andrebbe passato o l'id del cliente oppure (meglio) l'oggetto cliente. AGGIUSTARE	
				Ctrl_elaboraPreventivo.getInstance().inserisciCliente((String) table.getValueAt(table.getSelectedRow(),0));						
			}
		});

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
			    BottoneInserisci.setEnabled(true);
			     }
		});		 
	}
	
	
	public void popolaTab(ArrayList a){
		
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
		labelError.setText("");
				
		Iterator iteraClienti = null;
		
		iteraClienti = a.iterator();
		
		while (iteraClienti.hasNext()) {
			M_Cliente c = new M_Cliente();
			c = (M_Cliente) iteraClienti.next();
			((DefaultTableModel) JTableModel).addRow(new Object[]{c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getIndirizzo(),c.getEmail()});
		}
	}
	
	public void updateTable(String cognome, String nome,String cf,String indirizzo,String email){
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
			labelError.setText("");
            ((DefaultTableModel) JTableModel).addRow(new Object[]{ cognome,  nome, cf, indirizzo, email});
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
