package agent_trade.ui.content;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.util.ButtonsEditorRm;
import agent_trade.util.ButtonsRendererRm;
import agent_trade.util.SpinnerEditor;
import agent_trade.util.SpinnerRenderer;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;


public class ItemPreventivoView extends JPanel
{
	/*attributi di classe*/
	
	private static final Class ButtonsEditorRm = null;
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
		panel.setBackground(SystemColor.menu);
		panel.setLayout(null);
		panel.setBounds(0, 0, 733, 457);
		add(panel);
		
		panelloTabella = new JPanel();
		panelloTabella.setBackground(Color.WHITE);
		panelloTabella.setBorder(new EmptyBorder(3, 3, 3, 3));
		panelloTabella.setBounds(0, 4, 733, 360);
		panel.add(panelloTabella);
		panelloTabella.setLayout(null);
	   	
		scrollPane = new JScrollPane(creaTabellaProdotti());
		scrollPane.setBounds(0, 0, 733, 360);
		panelloTabella.add(scrollPane);
	  
		panelloRiepilogo = new JPanel();
		panelloRiepilogo.setLayout(null);
		panelloRiepilogo.setBackground(SystemColor.scrollbar);
		panelloRiepilogo.setBounds(0, 372, 733, 85);
		panel.add(panelloRiepilogo);
		
		buttoneSalva = new JButton("");
		buttoneSalva.setToolTipText("Salva preventivo");
		buttoneSalva.setIcon(new ImageIcon(ItemPreventivoView.class.getResource("/agent_trade/ui/img/save-icon.png")));
		buttoneSalva.setBounds(665, 20, 50, 50);
		panelloRiepilogo.add(buttoneSalva);
		
		JLabel labelImponibile = new JLabel("Imponibile");
		labelImponibile.setBounds(458, 11, 72, 14);
		panelloRiepilogo.add(labelImponibile);
		
		JLabel labelIVA = new JLabel("I.V.A.");
		labelIVA.setBounds(458, 36, 46, 14);
		panelloRiepilogo.add(labelIVA);
		
		JLabel labelTotale = new JLabel("Totale");
		labelTotale.setBounds(458, 61, 46, 14);
		panelloRiepilogo.add(labelTotale);
		
		textFieldImponibile = new JTextField();
		textFieldImponibile.setColumns(10);
		textFieldImponibile.setBounds(540, 8, 94, 20);
		panelloRiepilogo.add(textFieldImponibile);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setColumns(10);
		textFieldIVA.setBounds(540, 33, 94, 20);
		panelloRiepilogo.add(textFieldIVA);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
		textFieldTotale.setBounds(540, 58, 94, 20);
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
	
	
	/*metodi privati*/
	
	private JTable creaTabellaProdotti() {
		
		String[] colNames = {"Rimuovi", "ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo", "Parziale" };
        
        final Object[][] data = {};
        
        JTableModel = new DefaultTableModel(data, colNames);
         
        table = new JTable(JTableModel);
        table.setBorder(new EmptyBorder(5, 5, 5, 5));

        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(4).setCellRenderer(new SpinnerRenderer());
        colModel.getColumn(0).setCellRenderer(new ButtonsRendererRm());
        
        colModel.getColumn(4).setCellEditor(new SpinnerEditor(table));
        colModel.getColumn(0).setCellEditor(new ButtonsEditorRm(table));

        colModel.getColumn(0).setPreferredWidth(30);
        colModel.getColumn(4).setPreferredWidth(35);
        
	    table.setRowHeight(30);	
	    
	    return table;
	}
	
	/*metodi pubblici*/
	
	
	public void updateRow(float parz){
		
		((DefaultTableModel) JTableModel).setValueAt(parz, table.getSelectedRow(), 6);
	}
	
	public void updateTable(String rem, int id, String nome, String categoria, int quant, String prezzo, String parziale)
	{
		((DefaultTableModel) JTableModel).addRow(new Object[]{null, Integer.toString(id), nome, categoria, quant, prezzo, parziale});
	}
	
	public void deleteRow(int row) {
		((DefaultTableModel) JTableModel).removeRow(row);
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

	public void enableSave(boolean b){
		buttoneSalva.setEnabled(b);
	}


}



  
 
