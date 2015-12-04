package agent_trade.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class EditActionRm extends AbstractAction {
    private final JTable table;
    public EditActionRm(JTable table) {
        super("   ");
        this.table = table;

    }
    @Override public void actionPerformed(ActionEvent e) {
    	
        //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
        int row = table.convertRowIndexToModel(table.getEditingRow());
      //  JOptionPane.showMessageDialog(table, "ID : " + o+" quantita: "+table.getValueAt(row, 4));
        
        
        Object id =table.getModel().getValueAt(row, 1);
        //System.out.println("ID : " + id+" quantita: "+qt);
        
        
     //   Ctrl_elaboraPreventivo.getInstance().addQuant(Integer.parseInt((String) id), qt, row);
  
        
        Ctrl_elaboraPreventivo.getInstance().rimuoviItem(Integer.parseInt((String) id), row);
        
        
    }
}