package agent_trade.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.ui.content.prodotti.ProdottiView;

public class DisableButton extends JButton {
	 
    private static final long serialVersionUID = 592607338233558371L;
     
    public DisableButton() {
        super(new ImageIcon(ProdottiView.class.getResource("/agent_trade/ui/img/carr.png")));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        	
            	JTable table=ProdottiView.getInstance().getTable();
            	String sel= (String)table.getValueAt(table.getSelectedRow(),0);
            	JButton jb= (JButton)table.getValueAt(table.getSelectedRow(),5);

        		try {
					Ctrl_elaboraPreventivo.getInstance().addItem(Integer.parseInt(sel), jb);
				} catch (NumberFormatException | PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
     
    @Override
    public String toString() {
        return "";
    }
}