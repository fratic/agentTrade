package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import test.JButtonTableExample;
import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.util.ButtonEditor;
import agent_trade.util.ButtonRendererRm;
import agent_trade.util.MyComboBoxEditor;
import agent_trade.util.MyComboBoxRenderer;

public class ItemPreventivoView extends JPanel
{
	/*attributi di classe*/
	
	private static ItemPreventivoView instance;
	private static DefaultTableModel JTableModel;

	/*attributi privati*/
	
	private JTextField textFieldImponibile;
	private JTextField textFieldIVA;
	private JTextField textFieldTotale;
	
	private JPanel panelloTabella;
	private JPanel panelloRiepilogo;
	
	private JTable table;
	
	private JScrollPane scrollPane;

	private JButton buttoneSalva;

	
	/*costruttori*/
	
	public ItemPreventivoView() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setLayout(null);
		panel.setBounds(0, 0, 745, 449);
		add(panel);
		
		panelloTabella = new JPanel();
		panelloTabella.setBounds(0, 0, 745, 371);
		panel.add(panelloTabella);
		panelloTabella.setLayout(null);
		
		

		/*JTableModel = new DefaultTableModel(
                new String[][] { },
                new String[] { "Rimuovi","ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo", "Parziale" });
		*/
		/*
		JTableModel = new DefaultTableModel();
		JTableModel.setDataVector(new Object[][] {{null,"I123", "panna", "latticini",null, "1", "2"}},
				new Object[] { "Rimuovi","ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo", "Parziale" });
		table =new JTable(JTableModel);
		  table.getColumn("Rimuovi").setCellRenderer(new ButtonRenderer());
		    table.getColumn("Rimuovi").setCellEditor(
		        new ButtonEditor(new JCheckBox()));  
		    table.getColumn("Quantità").setCellRenderer((TableCellRenderer) new Spinner());
*/
		
		
		table = new JTable();
	    JTableModel = (DefaultTableModel) table.getModel();

	    JTableModel.addColumn("Rimuovi", new Object[] {});
	    JTableModel.addColumn("ID prodotto", new Object[] {});
	    JTableModel.addColumn("Nome", new Object[] {});
	    JTableModel.addColumn("Categoria", new Object[] {});
	    JTableModel.addColumn("Quantità", new Object[] {});
	    JTableModel.addColumn("Prezzo", new Object[] {});
	    JTableModel.addColumn("Parziale", new Object[] {});
	    
	    
	    
	    
/*
	    String[] values = new String[] { "1", "2", "3" };

	    TableColumn col = table.getColumnModel().getColumn(4);
	    col.setCellEditor((TableCellEditor) new MyComboBoxEditor(values));
	    col.setCellRenderer(new MyComboBoxRenderer(values, 2));
	  

	    col = table.getColumnModel().getColumn(0);
	    col.setCellRenderer(new ButtonRendererRm());
	    col.setCellEditor(new ButtonEditor(new JCheckBox()));
	    col.setPreferredWidth(30);
*/


	    table.setRowHeight(20);
	   
	    
		    //table.setModel(JTableModel);
	
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 725, 349);
		panelloTabella.add(scrollPane);
	  
		panelloRiepilogo = new JPanel();
		panelloRiepilogo.setLayout(null);
		panelloRiepilogo.setBackground(Color.LIGHT_GRAY);
		panelloRiepilogo.setBounds(0, 369, 745, 80);
		panel.add(panelloRiepilogo);
		
		buttoneSalva = new JButton("");
		buttoneSalva.setIcon(new ImageIcon(ItemPreventivoView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		buttoneSalva.setBounds(8, 8, 45, 45);
		panelloRiepilogo.add(buttoneSalva);
		
		JLabel labelImponibile = new JLabel("Imponibile");
		labelImponibile.setBounds(512, 8, 72, 14);
		panelloRiepilogo.add(labelImponibile);
		
		JLabel labelIVA = new JLabel("I.V.A.");
		labelIVA.setBounds(512, 33, 46, 14);
		panelloRiepilogo.add(labelIVA);
		
		JLabel labelTotale = new JLabel("Totale");
		labelTotale.setBounds(512, 58, 46, 14);
		panelloRiepilogo.add(labelTotale);
		
		textFieldImponibile = new JTextField();
		textFieldImponibile.setColumns(10);
		textFieldImponibile.setBounds(594, 5, 94, 20);
		panelloRiepilogo.add(textFieldImponibile);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setColumns(10);
		textFieldIVA.setBounds(594, 30, 94, 20);
		panelloRiepilogo.add(textFieldIVA);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
		textFieldTotale.setBounds(594, 55, 94, 20);
		panelloRiepilogo.add(textFieldTotale);
		
		
		
		buttoneSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Ctrl_elaboraPreventivo.getInstance().salvaPreventivo();	
			}
		});
		
	}
	
	
	/*metodi di classe*/
	
	public static ItemPreventivoView getInstance(){
		if (instance==null)
			instance = new ItemPreventivoView();
		return instance;	 
	}
	
	public static void cancItem(){
		instance=null;
	}
	
	//public static DefaultTableModel getModel(){
		
	//	return (DefaultTableModel) JTableModel;	 
	//}
	
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	public void updateTable(String rem, int id, String nome, String categoria, String quantita, String prezzo, String parziale)
	{
		((DefaultTableModel) JTableModel).addRow(new Object[]{rem, Integer.toString(id), nome, categoria, quantita, prezzo, parziale});
		
		
		String[] values = new String[] { "1", "2", "3" };

		    TableColumn col = table.getColumnModel().getColumn(4);
		    col.setCellEditor((TableCellEditor) new MyComboBoxEditor(values));
		    col.setCellRenderer(new MyComboBoxRenderer(values, id));

		    col = table.getColumnModel().getColumn(0);
		    
		    ButtonRendererRm brm =new ButtonRendererRm();
		    col.setCellRenderer(brm);
		    
		    ButtonEditor be = new ButtonEditor(new JCheckBox(), id);
		    col.setCellEditor(be);
		    col.setPreferredWidth(30);
		
	}
	
	public void setImponibile(String a){
		textFieldImponibile.setText(a);
	}
	
	public void setIva(String a){
		textFieldIVA.setText(a);
	}
	
	public void setTotale(String a){
		textFieldTotale.setText(a);
	}	
	
}
