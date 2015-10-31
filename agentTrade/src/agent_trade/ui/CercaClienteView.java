package agent_trade.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.RowFilter;

import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;
import agent_trade.persistentTemp.Dao_System;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

public class CercaClienteView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	public static CercaClienteView instance;	

	private JList<M_Cliente> clienti;
	private static JTable table;
	private JLabel labelError;
	public TableModel JTableModel;
	

	public void setErrore(String err) {
		labelError.setText(err);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CercaClienteView dialog = new CercaClienteView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CercaClienteView getInstance(){
		if (instance==null)
			instance = new CercaClienteView();
		return instance;	 
	}

	public static JTable getTableInstance(){
		return table;	 
	}
	
	public void setElements(M_Cliente[] listData){
		this.clienti.setListData(listData);
	}
	
	private void init(){
		this.clienti = new JList<M_Cliente>();
	}
	
	
	
	/**
	 * Create the dialog.
	 */
	public CercaClienteView() {
		
		
		setTitle("Cerca Cliente");
		setBounds(100, 100, 576, 324);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 62);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LabelCerca = new JLabel("Cerca Cliente");
		LabelCerca.setBounds(34, 11, 74, 40);
		panel.add(LabelCerca);
		
		textField = new JTextField();
		textField.setBounds(118, 21, 219, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton BottoneCerca = new JButton("Cerca");
		BottoneCerca.setBounds(385, 20, 89, 23);
		panel.add(BottoneCerca);
		
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(118, 48, 219, 14);
		panel.add(labelError);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 62, 560, 176);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/*JList list = new JList();
		list.setBounds(10, 11, 540, 154);
		panel_1.add(list);
		*/
		
		
		/*modifiche al table*/
		/*Object[][] data = { { "A", 5 }, { "B", 2 }, { "C", 4 }, { "D", 8 } };
	    String columnNames[] = { "Item", "Value" };
	    TableModel model = new DefaultTableModel(data, columnNames) {
	      /**
			 * 
			 */
		/*	private static final long serialVersionUID = 1L;

		public Class<?> getColumnClass(int column) {
	        return getValueAt(0, column).getClass();
	      }
	      };
	    */
		
		JTableModel = new DefaultTableModel(
                      new String[][] { },
                      new String[] { "Cognome", "Nome", "Codice Fiscale", "Indirizzo", "e-mail" });
		
		
		// Object rowData[][] = {{}};
		/*
		 Object rowData[][] = { { "fraticelli", "antonio", "frtntn89e26h926b","via foggia 271/c","fraticelli.antonio@gmail.com" },
				 { "", "", "","","" },
				 { "", "", "","","" },
				 { "", "", "","","" },
				 { "", "", "","","" },
				 { "", "", "","","" },
				 { "", "", "","","" },
				 { "", "", "","","" },
				 { "", "", "","","" } };
		 */
			//    Object columnNames[] = { "Cognome", "Nome", "Codice Fiscale", "Indirizzo", "e-mail" };
		
			  //  table = new JTable(rowData, columnNames);

        table =new JTable();
        
        table.setModel(JTableModel);

		
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 540, 154);
	    panel_1.add(scrollPane);
		 
	   // table.setValueAt("aa", 1, 0);   
	    
	    //Component asd = {  "fraticelli", "antonio", "","","" };
	    //table.add(asd );
	  	
	/*	  RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
		      public boolean include(Entry entry) {
		        Integer population = (Integer) entry.getValue(1);
		        return population.intValue() > 3;
		      }
		    };
		*/    
		    
		/*  TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		//    sorter.setRowFilter(filter);
		    table.setRowSorter(sorter);
		    JScrollPane scrollPane = new JScrollPane(table);
*/
		/*fine*/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 238, 560, 47);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton BottoneInserisci = new JButton("Inserisci");
		BottoneInserisci.setEnabled(false);
		BottoneInserisci.setBounds(451, 11, 99, 23);
		panel_2.add(BottoneInserisci);
		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().cercaCliente(textField.getText());	
				int k=((DefaultTableModel) JTableModel).getRowCount();
				//System.out.println("FUORI CICLO, K VALE: "+k);
						for (int i=k-1; i>=0;i--){
							((DefaultTableModel) JTableModel).removeRow(i);
						}
			

			}

		});
	
	}
	
	public void popolaTab(ArrayList a){
		
int k=((DefaultTableModel) JTableModel).getRowCount();
//System.out.println("FUORI CICLO, K VALE: "+k);
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
		
		
	/*	if (k>0)
		((DefaultTableModel) JTableModel).removeRow(1);
*/
	

		Iterator iteraClienti = null;
		
		iteraClienti = a.iterator();
		
		
		while (iteraClienti.hasNext()) {
			M_Cliente c = new M_Cliente();
			c = (M_Cliente) iteraClienti.next();
			
            ((DefaultTableModel) JTableModel).addRow(new Object[]{c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getIndirizzo(),c.getEmail()});
		
			}
		

		


		
	}
	
}
