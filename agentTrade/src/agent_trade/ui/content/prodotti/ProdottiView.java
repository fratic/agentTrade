package agent_trade.ui.content.prodotti;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import agent_trade.model.M_Prodotto;
import agent_trade.persistentTemp.Prodotto;
import agent_trade.util.DisableButton;
import agent_trade.util.MyEditor;
import agent_trade.util.MyRenderer;


public class ProdottiView extends JPanel {
	
	/*attributi di classe*/
	
	private static ProdottiView instance;
	private static Map<Integer, JButton> elencoBott=new TreeMap<>();

	/*attributi privati*/
	
	private JPanel pannelloTabella;
	private JPanel pannelloProdotti;

	private JTable table;
	private static DefaultTableModel JTableModel;
	
	private JScrollPane scrollPane;
		


	/*costruttori*/
	
	private ProdottiView() {

		setLayout(new GridLayout(1,1));
		
		pannelloProdotti = new JPanel();
//		MODIFICA LINEA SEGUENTE
		//pannelloProdotti.setBounds(0, 0, 753, 617);
		add(pannelloProdotti);
//		MODIFICA PROSSIMA RIGA
		pannelloProdotti.setLayout(new GridLayout(1,1));
		
		pannelloTabella = new JPanel();
//		MODIFICA PROSSIMA LINEA
		//pannelloTabella.setBounds(0, 0, 753, 617);
		pannelloProdotti.add(pannelloTabella);
//		MODIFICA PROSSIMA LINEA
	    pannelloTabella.setLayout(new GridLayout(1,1));


		String[] colNames = {"ID prodotto", "Nome", "Categoria", "Azienda", "Prezzo", "Aggiungi" };
        
        final Object[][] data = {};
        
        JTableModel = new DefaultTableModel(data, colNames);
         
        table = new JTable(JTableModel);
        table.setBorder(new EmptyBorder(5, 5, 5, 5));

	    
        TableColumnModel colModel = table.getColumnModel();
        
        colModel.getColumn(5).setPreferredWidth(35);
        table.setDefaultRenderer(Object.class, new MyRenderer());
        table.setDefaultEditor(Object.class, new MyEditor());
        
	    table.setRowHeight(30);
	    
	    scrollPane = new JScrollPane(table);
//	    MODIFICA PROSSIMA RIGA
	    //scrollPane.setBounds(0, 0, 753, 617);
	    pannelloTabella.add(scrollPane);
	  	}
	
	
	/*metodi di classe*/
	
	public static ProdottiView getInstance(){
		if (instance==null)
			instance = new ProdottiView();
		return instance;	 
	}	
	
	public static Map<Integer, JButton> elencoBottoniProdotti(){
		return elencoBott;
	}
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	public JTable getTable(){
		return this.table;
	}
	
	
	public void updateTable(String id, String nome, String categoria, String azienda, String prezzo){
	
		((DefaultTableModel) JTableModel).addRow(new Object[]{ id, nome, categoria, azienda, prezzo});
		
	}

	
	public void initTable(M_Prodotto[] prodotti){
		
//		Prodotto p;
		JButton jb;
//		while (iteraProdotti.hasNext()) {				
//			p = (M_Prodotto) iteraProdotti.next();
//			jb= new DisableButton();
//			jb.setEnabled(false);
//            ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
//            		p.getNome(), p.getCategoria(), "",Float.toString(p.getPrezzo()), jb});
//            
//    		elencoBott.put(p.getIdProdotto(), jb);
//
//            TableColumn col = table.getColumnModel().getColumn(5);
//       	    col.setMaxWidth(60);
//    	    col.setMinWidth(60);            
//		}
	
		for (M_Prodotto p : prodotti) {
		jb= new DisableButton();
		jb.setEnabled(false);
        ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
        		p.getNome(), p.getCategoria(), "",Float.toString(p.getPrezzo()), jb});
        
		elencoBott.put(p.getIdProdotto(), jb);

        TableColumn col = table.getColumnModel().getColumn(5);
   	    col.setMaxWidth(60);
	    col.setMinWidth(60);            
	}
	}
	
	
	public void enableBottoni(){
		
		JButton jb;
			int dim=(((DefaultTableModel) JTableModel).getRowCount());
			for(int i=0;i<dim;i++) {			
				jb= (JButton)table.getValueAt(i,5);
				jb.setEnabled(true);
				table.setValueAt(jb, i, 5);
			}
	}
	
	
	public void disableBottoni(){
		
		JButton jb;
			int dim=(((DefaultTableModel) JTableModel).getRowCount());
			for(int i=0;i<dim;i++) {			
				jb= (JButton)table.getValueAt(i,5);
				jb.setEnabled(false);
				table.setValueAt(jb, i, 5);
			}
	}
	
}
