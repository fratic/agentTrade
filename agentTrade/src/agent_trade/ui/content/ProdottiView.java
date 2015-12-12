package agent_trade.ui.content;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Prodotto;
import javax.swing.border.EmptyBorder;
//import agent_trade.util.ButtonRendererAdd;
//import agent_trade.util.ButtonsEditorAdd;
//import agent_trade.util.DisableButton;
//import agent_trade.util.MyEditor;
//import agent_trade.util.MyRenderer;


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
	
	public ProdottiView() {
		setLayout(null);
		
		pannelloProdotti = new JPanel();
		pannelloProdotti.setBounds(0, 0, 753, 617);
		add(pannelloProdotti);
		pannelloProdotti.setLayout(null);
		
		pannelloTabella = new JPanel();
		pannelloTabella.setBounds(0, 0, 753, 617);
		pannelloProdotti.add(pannelloTabella);
	    pannelloTabella.setLayout(null);



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
		  scrollPane.setBounds(0, 0, 753, 617);
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

	public void initTable(ArrayList a){

		Iterator iteraProdotti = null;

		iteraProdotti = a.iterator();
		M_Prodotto p;// = new M_Prodotto();
		JButton jb;
		while (iteraProdotti.hasNext()) {				
			p = (M_Prodotto) iteraProdotti.next();
			//System.out.println("in init: "+p.getNome());
			jb= new DisableButton();
			jb.setEnabled(false);
            ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
            		p.getNome(), p.getCategoria(), "",Float.toString(p.getPrezzo()), jb});
            
    		elencoBott.put(p.getIdProdotto(), jb);

            
            TableColumn col = table.getColumnModel().getColumn(5);
            

//          col.setCellRenderer(new ButtonRendererAdd());
//          col.setCellEditor(new ButtonsEditorAdd(table));

            
//    		TableColumn col = table.getColumnModel().getColumn(5);
//    	    col.setCellRenderer(new ButtonRendererAdd());
//    	    col.setCellEditor(new ButtonsEditorAdd(table));
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

class DisableButton extends JButton {
	 
    /**
     * 
     */
    private static final long serialVersionUID = 592607338233558371L;
     
    public DisableButton() {
        super(new ImageIcon(ProdottiView.class.getResource("/agent_trade/ui/img/carr.png")));
        //setIcon(new ImageIcon(mainProdotti.class.getResource("/agent_trade/ui/img/carr.png")));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        	
            	JTable table=ProdottiView.getInstance().getTable();
            	String sel= (String)table.getValueAt(table.getSelectedRow(),0);
            	JButton jb= (JButton)table.getValueAt(table.getSelectedRow(),5);

        		Ctrl_elaboraPreventivo.getInstance().addItem(Integer.parseInt(sel), jb);

//                setText("Disabled");
//                setEnabled(false);
            }
        });
    }
     
    @Override
    public String toString() {
        return "";
    }
}


class MyRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Object cell = value;
        /*System.out.print(Calendar.getInstance().getTime() + " " );
        System.out.println(tableModel.getDataVector());*/
        if (cell instanceof JButton) {
            return (JButton) cell;
        }
        if (cell == null) {
            return null;
        }
        String str = cell.toString();
        return new JLabel(str);
    }
}

class MyEditor extends DefaultCellEditor {

    /**
     * 
     */
    private static final long serialVersionUID = 4788029237585436042L;
    private Object value;

    public MyEditor() {
        super(new JCheckBox());
        // necessario
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        Object cell = value;
        this.value = value;
        if (cell instanceof JButton) {
            return (JButton) cell;
        }
        return null;
    }
     
    @Override
    public Object getCellEditorValue()
    {
        return value;
    }
     
    @Override
    public void fireEditingStopped() {
         
    }
}

