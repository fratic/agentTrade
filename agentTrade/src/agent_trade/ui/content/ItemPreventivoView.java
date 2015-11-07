package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JTable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import agent_trade.model.M_Cliente;

import javax.swing.ListSelectionModel;

public class ItemPreventivoView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JPanel panel_1;
	
	private TableModel JTableModelItem;
	
	private JScrollPane scrollPane;

	private static ItemPreventivoView instance;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ItemPreventivoView() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setLayout(null);
		panel.setBounds(0, 0, 745, 449);
		add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 745, 371);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
	
		
		
				

		
		JTableModelItem = new DefaultTableModel(
                new String[][] {{"fratic", "anto", "Codice Fiscale", "Indirizzo", "e-mail" }},
                new String[] { "Cognome", "Nome", "Codice Fiscale", "Indirizzo", "e-mail" });


        table =new JTable();
        
        table.setModel(JTableModelItem);
	    
        
        scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 735, 360);

		panel_1.add(scrollPane);

		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 369, 745, 80);
		panel.add(panel_2);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ItemPreventivoView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		button.setBounds(8, 8, 45, 45);
		panel_2.add(button);
		
		JLabel label = new JLabel("Imponibile");
		label.setBounds(512, 8, 72, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("I.V.A.");
		label_1.setBounds(512, 33, 46, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Totale");
		label_2.setBounds(512, 58, 46, 14);
		panel_2.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(594, 5, 94, 20);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(594, 30, 94, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(594, 55, 94, 20);
		panel_2.add(textField_2);
		
		((DefaultTableModel) JTableModelItem).addRow(new Object[]{"cognome","nome","coficn","mailcn","dfsgsdg"});


	}

	
	public void popolaTabProdottiItem(ArrayList a){
		
		int k=((DefaultTableModel) JTableModelItem).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModelItem).removeRow(i);
		}
		
		//labelError.setText("");
		System.out.println("sono in popola tab prodotti "+k);
				
		Iterator iteraClienti = null;
		
		iteraClienti = a.iterator();
		
		k=((DefaultTableModel) JTableModelItem).getRowCount();
		System.out.println("dopo k vale "+k);

		
		while (iteraClienti.hasNext()) {
			M_Cliente c = new M_Cliente();
			c = (M_Cliente) iteraClienti.next();
			System.out.println("Cognome "+c.getCognome());
			((DefaultTableModel) JTableModelItem).addRow(new Object[]{c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getIndirizzo(),c.getEmail()});
			k=((DefaultTableModel) JTableModelItem).getRowCount();
			System.out.println("nel ciclio k vale "+k);

		
		}
	}
	
	public void updateTable(String cognome, String nome,String cf,String indirizzo,String email){
		int k=((DefaultTableModel) JTableModelItem).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModelItem).removeRow(i);
		}
            ((DefaultTableModel) JTableModelItem).addRow(new Object[]{ cognome,  nome, cf, indirizzo, email});
	}
	
	public static ItemPreventivoView getInstance(){
		if (instance==null)
			instance = new ItemPreventivoView();
		return instance;	 
	}
	
	
}
