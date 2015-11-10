package agent_trade.ui.content;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.persistentTemp.Dao_System;

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
                new String[][] {  },
                new String[] { "ID prodotto", "Nome", "Categoria", "Azienda", "Prezzo", "Aggiungi a preventivo" });
					
		  table =new JTable();
		  		  
		  table.setModel(JTableModel);
		  		 
		  scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(10, 11, 725, 349);
		  pannelloTabella.add(scrollPane);
		  
		
		  table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					String sel= (String)table.getValueAt(table.getSelectedRow(),0);
					System.out.println("in mpouseliste "+sel);
				//	Ctrl_elaboraPreventivo.getInstance().addItem((Integer)table.getValueAt(table.getSelectedRow(),0));
					Ctrl_elaboraPreventivo.getInstance().addItem(Integer.parseInt(sel));

				}
		  });	
		  
	}


	
	public void updateTable(String id, String nome, String categoria, String azienda, String prezzo){
	
		((DefaultTableModel) JTableModel).addRow(new Object[]{ id, nome, categoria, azienda, prezzo});
	}

	
	public void initTable(ArrayList a){

		Iterator iteraProdotti = null;

		iteraProdotti = a.iterator();
		M_Prodotto p;// = new M_Prodotto();

		while (iteraProdotti.hasNext()) {				
			p = (M_Prodotto) iteraProdotti.next();
			System.out.println("in init: "+p.getNome());
            ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), p.getNome(), p.getCategoria(), "",Float.toString(p.getPrezzo())});
		}
	
	}

	
	public static ProdottiView getInstance(){
		if (instance==null)
			instance = new ProdottiView();
		return instance;	 
	}	
}