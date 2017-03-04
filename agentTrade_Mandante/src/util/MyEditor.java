package util;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class MyEditor extends DefaultCellEditor {

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