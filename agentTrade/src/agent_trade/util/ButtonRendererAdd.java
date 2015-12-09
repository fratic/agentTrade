package agent_trade.util;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRendererAdd extends ButtonsPanelAdd implements TableCellRenderer {
    
	public ButtonRendererAdd() {
        super();
    }
	
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Object cell = value;

        if (cell instanceof JButton) {
            return (JButton) cell;
        }
    	
    	this.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return this;
    }
}