package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class sdfgsdfg extends JPanel {
	
	private JPanel pannelloTabella;
	private JPanel pannelloProdotti;

	private JTable table;
	private static TableModel JTableModel;
	
	private JScrollPane scrollPane;
	private static sdfgsdfg instance;
	

	/**
	 * Create the panel.
	 */
	public sdfgsdfg() {
		setLayout(null);
		
		pannelloProdotti = new JPanel();
		pannelloProdotti.setLayout(null);
		pannelloProdotti.setBounds(0, 0, 745, 449);
		add(pannelloProdotti);
		
		pannelloTabella = new JPanel();
		pannelloTabella.setBounds(0, 0, 745, 371);
		pannelloProdotti.add(pannelloTabella);
		pannelloTabella.setLayout(null);
		
		

		JTableModel = new DefaultTableModel(
                new String[][] { },
                new String[] { "ID prodotto", "Nome", "Categoria", "Azienda", "Prezzo", "Aggiungi a preventivo" });
					
		  table =new JTable();
		  
		  table.setModel(JTableModel);
		
		  scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(10, 11, 725, 349);
		  pannelloTabella.add(scrollPane);
		
		
	}

	public void initiz(){


	}
	
public void popola(){
		
		//int k=((DefaultTableModel) JTableModel).getRowCount();
		/*for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}*/
		
		//System.out.println("k vale: "+k);
	//	labelError.setText("");
				
		//((DefaultTableModel) ItemPreventivoView.getInstance().getModel()).addColumn(new Object[]{"asd","adsf","asdf","adsf","asdf"});
		
				
			//((DefaultTableModel) this.JTableModel).addRow(new Object[]{"dudeuduude","adsf","asdf","adsf","asdf"});
			 // table.setModel(JTableModel);

	}
	
	public void updateTable(String cognome, String nome,String cf,String indirizzo,String email){
		/*int k=((DefaultTableModel) JTableModelItem).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModelItem).removeRow(i);
		}
            ((DefaultTableModel) JTableModelItem).addRow(new Object[]{ cognome,  nome, cf, indirizzo, email});
	*/
	}
	
	public static sdfgsdfg getInstance(){
		if (instance==null)
			instance = new sdfgsdfg();
		return instance;	 
	}	
	
}
