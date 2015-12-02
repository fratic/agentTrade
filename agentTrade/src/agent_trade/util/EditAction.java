package agent_trade.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

class EditAction extends AbstractAction {
    private final JTable table;
    public EditAction(JTable table) {
        super();
        this.table = table;
    }
    @Override public void actionPerformed(ActionEvent e) {
        //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 1);
        JOptionPane.showMessageDialog(table, "ID : " + o+" quantita"+table.getValueAt(row, 4));
    }
}