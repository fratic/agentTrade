package agent_trade.ui.content;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Prodotto;
import agent_trade.util.ButtonRendererAdd;
import agent_trade.util.ButtonsEditorAdd;
import agent_trade.util.ButtonsEditorRm;


public class ProdottiView extends JPanel {
	
	/*attributi di classe*/
	
	private static ProdottiView instance;

	/*attributi privati*/
	
	private JPanel pannelloTabella;
	private JPanel pannelloProdotti;

	private JTable table;
	private static DefaultTableModel JTableModel;
	
	private JScrollPane scrollPane;
	
	private JButton addItem;
	

	/*costruttori*/
	
	public ProdottiView() {
		setLayout(null);
		
		pannelloProdotti = new JPanel();
		pannelloProdotti.setBounds(0, 0, 754, 550);
		add(pannelloProdotti);
		pannelloProdotti.setLayout(null);
		
		pannelloTabella = new JPanel();
		pannelloTabella.setBounds(0, 0, 754, 550);
		pannelloProdotti.add(pannelloTabella);
		
		addItem = new JButton("New button");


		/*JTableModel = new DefaultTableModel(
                new String[][] {  },
                new String[] { "ID prodotto", "Nome", "Categoria", "Azienda", "Prezzo", "Aggiungi a preventivo" });
					
		  table =new JTable();
		  		  
		  table.setModel(JTableModel);
		*/
		
		table = new JTable();
	    JTableModel = (DefaultTableModel) table.getModel();

	    JTableModel.addColumn("ID prodotto", new Object[] {});
	    JTableModel.addColumn("Nome", new Object[] {});
	    JTableModel.addColumn("Categoria", new Object[] {});
	    JTableModel.addColumn("Azienda", new Object[] {});
	    JTableModel.addColumn("Prezzo", new Object[] {});
	    JTableModel.addColumn("Aggiungi", new Object[] {});
	    pannelloTabella.setLayout(null);

	    
	    
	    table.setRowHeight(30);

	    
	    
	/*    String[] values = new String[] { "1", "2", "3" };

	    TableColumn col = table.getColumnModel().getColumn(4);
	    col.setCellEditor((TableCellEditor) new MyComboBoxEditor(values));
	    col.setCellRenderer(new MyComboBoxRenderer(values));
	  

	    col = table.getColumnModel().getColumn(0);
	    col.setCellRenderer(new ButtonRenderer());
	    col.setCellEditor(new ButtonEditor(new JCheckBox()));
*/
		  

		  scrollPane = new JScrollPane(table);
		  scrollPane.setBounds(0, 0, 754, 550);
		  pannelloTabella.add(scrollPane);
		  
		  
		
		  table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					//String sel= (String)table.getValueAt(table.getSelectedRow(),0);
					//System.out.println("in mpouseliste "+sel);
				//	Ctrl_elaboraPreventivo.getInstance().addItem((Integer)table.getValueAt(table.getSelectedRow(),0));
					//Ctrl_elaboraPreventivo.getInstance().addItem(Integer.parseInt(sel));
				    
				}
		  });		  
	}
	
	
	/*metodi di classe*/
	
	public static ProdottiView getInstance(){
		if (instance==null)
			instance = new ProdottiView();
		return instance;	 
	}	
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	public void updateTable(String id, String nome, String categoria, String azienda, String prezzo){
	
		((DefaultTableModel) JTableModel).addRow(new Object[]{ id, nome, categoria, azienda, prezzo});
		
	}

	public void initTable(ArrayList a){

		Iterator iteraProdotti = null;

		iteraProdotti = a.iterator();
		M_Prodotto p;// = new M_Prodotto();

		while (iteraProdotti.hasNext()) {				
			p = (M_Prodotto) iteraProdotti.next();
			//System.out.println("in init: "+p.getNome());
            ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), p.getNome(), p.getCategoria(), "",Float.toString(p.getPrezzo())});
            
    		TableColumn col = table.getColumnModel().getColumn(5);
    	    col.setCellRenderer(new ButtonRendererAdd());
    	    col.setCellEditor(new ButtonsEditorAdd(table));
    	    col.setPreferredWidth(35);

		
            
		}
		
	}
	
}