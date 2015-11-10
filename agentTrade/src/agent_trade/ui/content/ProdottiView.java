package agent_trade.ui.content;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;

import javax.swing.JButton;

import test_interface.JButtonTableExample;

public class ProdottiView extends JPanel {
	
	private JPanel pannelloTabella;
	private JPanel pannelloProdotti;

	private JTable table;
	private static TableModel JTableModel;
	
	private JScrollPane scrollPane;
	private static ProdottiView instance;
	
	private JButton addItem;
	

	/**
	 * Create the panel.
	 */
	public ProdottiView() {
		setLayout(null);
		
		pannelloProdotti = new JPanel();
		pannelloProdotti.setLayout(null);
		pannelloProdotti.setBounds(0, 0, 745, 548);
		add(pannelloProdotti);
		
		pannelloTabella = new JPanel();
		pannelloTabella.setBounds(0, 0, 745, 371);
		pannelloProdotti.add(pannelloTabella);
		pannelloTabella.setLayout(null);
		
		addItem = new JButton("New button");


		JTableModel = new DefaultTableModel(
                new String[][] { { "125", "cioccoloco", "Dolce", "Maina", "1,12", "sdff" },
                				{ "21", "caramella", "Dolce", "Nestle", "0.05", "bottone" } },
                new String[] { "ID prodotto", "Nome", "Categoria", "Azienda", "Prezzo", "Aggiungi a preventivo" });
					
		  table =new JTable();
		  		  
	
		  
		  table.setModel(JTableModel);
		  
		 
		  scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(10, 11, 725, 349);
		  pannelloTabella.add(scrollPane);
		  
		
		
		  table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					//int sel=  (int) table.getValueAt(table.getSelectedRow(),0);
					Ctrl_elaboraPreventivo.getInstance().addItem((String)table.getValueAt(table.getSelectedRow(),0));
				}
		  });	
		  
	}


	

	
	public static ProdottiView getInstance(){
		if (instance==null)
			instance = new ProdottiView();
		return instance;	 
	}	
}