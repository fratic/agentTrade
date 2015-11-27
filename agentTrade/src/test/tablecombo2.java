package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class tablecombo2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablecombo2 frame = new tablecombo2();
					frame.setVisible(true);
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tablecombo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JTable table = new JTable();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();

	    model.addColumn("A", new Object[] { "item1" });
	    model.addColumn("B", new Object[] { "item2" });

	    String[] values = new String[] { "1", "2", "3" };

	    TableColumn col = table.getColumnModel().getColumn(0);
	//    col.setCellEditor((TableCellEditor) new MyComboBoxEditor(values));
	  //  col.setCellRenderer(new MyComboBoxRenderer(values));
		
	    JScrollPane scroll = new JScrollPane(table);
	    getContentPane().add(scroll);

		
	}

}


/*

class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
	  public MyComboBoxRenderer(String[] items) {
	    super(items);
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	      boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      super.setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(table.getBackground());
	    }
	    setSelectedItem(value);
	    return this;
	  }
	}

	class MyComboBoxEditor extends DefaultCellEditor {
	  public MyComboBoxEditor(String[] items) {
	    super(new JComboBox(items));
	  }
	}
*/
