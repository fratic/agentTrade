package test;

import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
   
public class JSpinnerTableExample extends JFrame {
  
  public JSpinnerTableExample(){
   // super( &amp, amp, quot, JSpinnerTable Example&amp, amp, quot);
     
    //SpinnerNumberModel spinnerModel1 = new SpinnerNumberModel(10.0, -500.0, 500.0, .5);
    //SpinnerDateModel spinnerModel2 = new SpinnerDateModel();
  
    //DefaultTableModel dtm = new DefaultTableModel();
    //dtm.setDataVector(new Object[][]{{ spinnerModel1, &amp;amp;quot;JSpinner1&amp;amp;quot; },
      //                               { spinnerModel2, &amp;amp;quot;JSpinner2&amp;amp;quot; }},
        //              new Object[]{&amp;amp;quot;JSpinner&amp;amp;quot;,&amp;amp;quot;String&amp;amp;quot;});
                      
   // JTable table = new JTable(dtm);
   // table.getColumn(&amp;amp;quot;JSpinner&amp;amp;quot;).setCellRenderer(new SpinnerRenderer());
    //table.getColumn(&amp;amp;quot;JSpinner&amp;amp;quot;).setCellEditor(new SpinnerEditor());
  
 //   table.setRowHeight(20);
   // JScrollPane scroll = new JScrollPane(table);
    //getContentPane().add(scroll);
  
    setSize( 400, 100 );
    setVisible(true);
  }
  
  public static void main(String[] args) {
    JSpinnerTableExample frame = new JSpinnerTableExample();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
  
class SpinnerRenderer extends JSpinner implements TableCellRenderer {
   public SpinnerRenderer() {
      setOpaque(true);
   }
   
   public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
      setModel((SpinnerModel) value);
   
      return this;
   }
}
   
class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
   protected JSpinner spinner;
   
   public SpinnerEditor() {
      spinner = new JSpinner();
   }
  
   public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {
      spinner.setModel((SpinnerModel) value);
  
      return spinner;
   }
  
   public Object getCellEditorValue() {
      SpinnerModel sm = spinner.getModel();
      return sm;
   }
}