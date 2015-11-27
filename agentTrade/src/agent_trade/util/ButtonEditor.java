package agent_trade.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor{
protected JButton button;

private boolean isPushed;

private int id;


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public ButtonEditor(JCheckBox checkBox) {
  super(checkBox);
  button = new JButton();
  button.setOpaque(true);
  button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      fireEditingStopped();
    }
  });
}

public ButtonEditor(JCheckBox checkBox, int id) {
	  super(checkBox);
	  button = new JButton();
	  button.setOpaque(true);
	  
	  this.id=id;
	  
	  button.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	      fireEditingStopped();
	    }
	  });
	}

public Component getTableCellEditorComponent(JTable table, Object value,
  boolean isSelected, int row, int column) {
  if (isSelected) {
    button.setForeground(table.getSelectionForeground());
    button.setBackground(table.getSelectionBackground());
  } else {
    button.setForeground(table.getForeground());
    button.setBackground(table.getBackground());
  }
  isPushed = true;
  return button;
}

public Object getCellEditorValue() {
  if (isPushed) {
    JOptionPane.showMessageDialog(button, "ID: "+id);
  }
  isPushed = false;
  return new String();
}

public boolean stopCellEditing() {
  isPushed = false;
  return super.stopCellEditing();
}

protected void fireEditingStopped() {
  super.fireEditingStopped();
}
}