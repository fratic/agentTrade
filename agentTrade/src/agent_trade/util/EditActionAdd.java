package agent_trade.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.ui.content.ProdottiView;

public class EditActionAdd extends AbstractAction {
    private JTable table=ProdottiView.getInstance().getTable();
    JButton jb;
    
    public EditActionAdd() {
        super("    ");
        this.table = table;
        this.jb=jb;
    }
    
    @Override public void actionPerformed(ActionEvent e) {
        //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
       /* int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 1);
        JOptionPane.showMessageDialog(table, "ID : " + o+" quantita"+table.getValueAt(row, 4));
        */
		String sel= (String)table.getValueAt(table.getSelectedRow(),0);
//		System.out.println("in editaction, SEL "+sel);
	//	Ctrl_elaboraPreventivo.getInstance().addItem((Integer)table.getValueAt(table.getSelectedRow(),0));
		Ctrl_elaboraPreventivo.getInstance().addItem(Integer.parseInt(sel), jb);
		
		
		//JButton asd= (JButton)(table.getValueAt(table.getSelectedRow(),5));
	//	System.out.println("sono in editaction add"+(table.getValueAt(table.getSelectedRow(),5)).getClass());
		//asd.disable();
		//jb.setEnabled(false);
		//System.out.println("edit add, jb "+jb.toString());

//		table.setValueAt("ciao", table.getSelectedRow(),4);
		
		
//		

    }
}