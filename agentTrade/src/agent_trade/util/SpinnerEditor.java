package agent_trade.util;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableCellEditor;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    JTable table;
    SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 1000, 1);
    JSpinner spinner = new JSpinner(model);
    int clickCountToStart = 1;

    ChangeListener listener = new ChangeListener() {
    	@Override
		public void stateChanged(ChangeEvent e) {

    	    int qt=(int) spinner.getValue();
    	    int row = (int)table.convertRowIndexToModel(table.getEditingRow());
           
    	    if (row>=0){
	            Object id =table.getModel().getValueAt(row, 1);
	            try {
					Ctrl_elaboraPreventivo.getInstance().addQuant(Integer.parseInt((String) id), qt);
	            } 
	            catch (NumberFormatException | PersistentException e1) {
					e1.printStackTrace();
				}            
            }    
		}
	};
    	
    public SpinnerEditor(JTable t){
        spinner.addChangeListener(listener);
        this.table=t;
    }

    	
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row, int column) {
        spinner.setValue(((Integer)value).intValue());
        return spinner;
    }
 
    public Object getCellEditorValue() {
        return (Integer)spinner.getValue();
    }
 
    public boolean isCellEditable(EventObject anEvent) {
        if(anEvent instanceof MouseEvent) { 
            return ((MouseEvent)anEvent).getClickCount() >= clickCountToStart;
        }
        return true;
    }
 
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }
 
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }
 
    public void cancelCellEditing() {
        super.cancelCellEditing();
    }
}  
