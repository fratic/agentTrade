package agent_trade.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import agent_trade.ui.content.ItemPreventivoView;

public class DisableButton extends JButton {
	 

    private static final long serialVersionUID = 592607338233558371L;
     private int id;
     
    public DisableButton(int id) {
        super();
        this.id=id;

        //setIcon(new ImageIcon(ItemPreventivoView.class.getResource("/agent_trade/ui/img/carr.png")));
        
        //setText("miao");

//        addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setAction(new EditActionAdd());
//
//                setText("In Preventivo");
//                setEnabled(false);
//
//                
//            }
//        });
    }
     
    @Override
    public String toString() {
        return "";
    }
}