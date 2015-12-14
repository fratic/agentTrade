package agent_trade.util;

import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import agent_trade.ui.content.preventivi.ItemNuovoPreventivoView;

class ButtonsPanelRm extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton());
    public ButtonsPanelRm() {
        super();
        //setLayout(null);
        setOpaque(true);
        for (JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            b.setIcon(new ImageIcon(ItemNuovoPreventivoView.class.getResource("/agent_trade/ui/img/close_icon.png")));
            //b.setSize(25, 25);
            add(b);
        }
    }

}

