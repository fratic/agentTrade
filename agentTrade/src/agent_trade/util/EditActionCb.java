package agent_trade.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

class EditActionCb extends AbstractAction {

    public EditActionCb(final JComboBox cb) {
        super();
    
    //@Override public void actionPerformed(ActionEvent e) {
        //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
//        int row = table.convertRowIndexToModel(table.getEditingRow());
//        Object o = table.getModel().getValueAt(row, 1);
//        JOptionPane.showMessageDialog(table, "ID : " + o+" quantita"+table.getValueAt(row, 4));
    
    	
        
        /*cb.addItemListener(new ItemListener() {
  	      @Override
  			public void itemStateChanged(ItemEvent e) {
  			    System.out.println("sono nel listener di combo. ");
  			    
  			    //Ctrl_elaboraPreventivo.getInstance().setQt(id,qt);
  			    System.out.println("valore QUANTITA "+cb.getSelectedItem()); 
			    System.out.println("oggetto: "+this.toString()); 

  			}
  		});	   */
        
        
	    cb.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.out.println("sono nel listener di combo. ");
			    
			    //Ctrl_elaboraPreventivo.getInstance().setQt(id,qt);
  			    System.out.println("valore QUANTITA "+cb.getSelectedItem()); 
  			    System.out.println("OGGETTT "+this.toString()); 


			}
		});	
  	    
    
    
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}