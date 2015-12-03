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

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
	
	
	  public MyComboBoxRenderer(String[] items) {
	    
		super(items);
	    //this.setSelectedIndex(0);
	    
	    this.setAction(new EditActionCb(this));
	    
//	    this.addActionListener(new ActionListener() {
//		
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			    System.out.println("sono nel listener di combo. ");
//			    
//			    //Ctrl_elaboraPreventivo.getInstance().setQt(id,qt);
//			    System.out.println("valore QUANTITA "+getSelectedItem());
//
//
//			}
//		});	   
	    
	    
	 //   System.out.println("valore QUANTITA "+getSelectedIndex()); 
//	    this.addActionListener(new ActionListener() {
	    
//	    this.addItemListener(new ItemListener() {
//	      @Override
//			public void itemStateChanged(ItemEvent e) {
//			    System.out.println("sono nel listener di combo. ");
//			    
//			    //Ctrl_elaboraPreventivo.getInstance().setQt(id,qt);
//			    System.out.println("valore QUANTITA "+getSelectedItem()); 
//				
//			}
//		});	   
//	    
	    
	    
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

