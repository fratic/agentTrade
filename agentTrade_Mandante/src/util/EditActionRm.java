package util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class EditActionRm extends AbstractAction {
    private final JTable table;
    public EditActionRm(JTable table) {
        super("   ");
        this.table = table;
    }
    
    @Override public void actionPerformed(ActionEvent e) {
    	
        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object id =table.getModel().getValueAt(row, Costanti.COLONNA_ID_REMOVE_ITEM);
        Ctrl_elaboraPreventivo.getInstance().rimuoviItem(Integer.parseInt((String) id), row);             
    }
}