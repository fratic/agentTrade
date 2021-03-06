package agent_trade.util;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Object cell = value;

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