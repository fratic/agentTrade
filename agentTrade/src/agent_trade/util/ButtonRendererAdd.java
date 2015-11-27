package agent_trade.util;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

import test.JButtonTableExample;

public class ButtonRendererAdd extends JButton implements TableCellRenderer {

public ButtonRendererAdd() {
  setOpaque(true);
  this.setIcon(new ImageIcon(JButtonTableExample.class.getResource("/agent_trade/ui/img/carrello.gif")));
}

public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {
  if (isSelected) {
    setForeground(table.getSelectionForeground());
    setBackground(table.getSelectionBackground());
  } else {
    setForeground(table.getForeground());
    setBackground(UIManager.getColor("Button.background"));
  }
  setText((value == null) ? "" : value.toString());
  return this;
}
}