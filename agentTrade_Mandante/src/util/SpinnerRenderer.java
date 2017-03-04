package util;

import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellRenderer;

public class SpinnerRenderer implements TableCellRenderer {
    SpinnerNumberModel model = new SpinnerNumberModel(0, 0, null, 1);
    JSpinner spinner = new JSpinner(model);
 
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row, int column) {

        spinner.setValue(((Integer)value).intValue());
        return spinner;
    }
}