package agent_trade.util;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class MyEditor extends DefaultCellEditor implements TableCellEditor {


    private static final long serialVersionUID = 4788029237585436042L;
    private Object value;
    private int id;

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