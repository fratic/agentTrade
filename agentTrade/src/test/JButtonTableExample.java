package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import agent_trade.util.*;

public class JButtonTableExample extends JFrame {

  public JButtonTableExample() {
    
	  super("JButtonTable Example");

    
	  JTable table = new JTable();
	    DefaultTableModel JTableModel = (DefaultTableModel) table.getModel();

	    JTableModel.addColumn("Rimuovi", new Object[] {"sono qui"});
	    JTableModel.addColumn("ID prodotto", new Object[] {"sono qui"});
	    JTableModel.addColumn("Nome", new Object[] {"sono qui"});
	    JTableModel.addColumn("Categoria", new Object[] {"sono qui"});
	    JTableModel.addColumn("Quantità", new Object[] {"sono qui"});
	    JTableModel.addColumn("Prezzo", new Object[] {"sono qui"});
	    JTableModel.addColumn("Parziale", new Object[] {"sono qui"});

	    String[] values = new String[] { "1", "2", "3" };

	    TableColumn col = table.getColumnModel().getColumn(4);
	    col.setCellEditor((TableCellEditor) new MyComboBoxEditor(values));
	    col.setCellRenderer(new MyComboBoxRenderer(values,1));
	  

	    col = table.getColumnModel().getColumn(0);
	    col.setCellRenderer(new ButtonRendererRm());
	    col.setCellEditor(new ButtonEditor(new JCheckBox()));

	    
	    
	    JScrollPane scroll = new JScrollPane(table);
	    getContentPane().add(scroll);

    
    
    setSize(500, 150);
    setVisible(true);
  }

  public static void main(String[] args) {
  
	  JButtonTableExample frame = new JButtonTableExample();
	  frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
