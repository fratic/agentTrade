package agent_trade.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
	
	private int id;
	
	  public MyComboBoxRenderer(String[] items, int id) {
	    super(items);
	    this.id=id;
	    System.out.println("sono nel costruttore di mycombocoxrend. ID= "+id);
		/*this.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.out.println("sono nel listener di combo. ");
				
			}
		});*/   	   
	    System.out.println("valore QUANTITA "+this.getSelectedIndex()); 
	    
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

