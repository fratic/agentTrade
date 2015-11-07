package agent_trade.ui.content;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import agent_trade.controller.Ctrl_elaboraPreventivo;
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
	public static TableModel JTableModel;
	public JButton BottoneInserisci;
	

	public void setErrore(String err) {
		labelError.setText(err);
	}
	
	public String getRicerca(){
		return textField.getText();
	}

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
	
	
	public static CercaClienteView getInstance(){
		if (instance==null)
			instance = new CercaClienteView();
		return instance;	 
	}
	
	
	public static TableModel getJTableModel(){
		return JTableModel;	 
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
		
		
		
		JTableModel = new DefaultTableModel(
                      new String[][] { },
                      new String[] { "Cognome", "Nome", "Codice Fiscale", "Indirizzo", "e-mail" });
		
		
		
        table =new JTable();
        
        table.setModel(JTableModel);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 540, 154);
	    panel_1.add(scrollPane);
		 
	  
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 238, 560, 47);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		BottoneInserisci = new JButton("Inserisci");
		BottoneInserisci.setEnabled(false);
		BottoneInserisci.setBounds(451, 11, 99, 23);
		panel_2.add(BottoneInserisci);
		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int k=((DefaultTableModel) JTableModel).getRowCount();
						for (int i=k-1; i>=0;i--){
							((DefaultTableModel) JTableModel).removeRow(i);
						}
				Ctrl_gestisciCliente.getInstance().cercaCliente(textField.getText());	
				
			

			}

		});
	
		BottoneInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Ctrl_elaboraPreventivo.getInstance().inserisciCliente((String) table.getValueAt(table.getSelectedRow(),0));
								
			}

		});

		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
	
}