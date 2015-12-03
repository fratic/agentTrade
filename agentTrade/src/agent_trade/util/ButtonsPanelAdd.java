package agent_trade.util;

import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import agent_trade.ui.content.ItemPreventivoView;

class ButtonsPanelAdd extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton());
    public ButtonsPanelAdd() {
        super();
        setOpaque(true);
        for (JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            b.setIcon(new ImageIcon(ItemPreventivoView.class.getResource("/agent_trade/ui/img/carr.png")));
            add(b);
        }
    }

}

