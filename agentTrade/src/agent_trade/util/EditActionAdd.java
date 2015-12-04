package agent_trade.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class EditActionAdd extends AbstractAction {
    private final JTable table;
    public EditActionAdd(JTable table) {
        super("    ");
        this.table = table;
    }
    @Override public void actionPerformed(ActionEvent e) {
        //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
       /* int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 1);
        JOptionPane.showMessageDialog(table, "ID : " + o+" quantita"+table.getValueAt(row, 4));
        */
		String sel= (String)table.getValueAt(table.getSelectedRow(),0);
		System.out.println("in editaction, SEL "+sel);
	//	Ctrl_elaboraPreventivo.getInstance().addItem((Integer)table.getValueAt(table.getSelectedRow(),0));
		Ctrl_elaboraPreventivo.getInstance().addItem(Integer.parseInt(sel));

    }
}