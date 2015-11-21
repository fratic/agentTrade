package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class ItemPreventivoView extends JPanel 
{
	/*attributi di classe*/
	
	private static ItemPreventivoView instance;
	private static TableModel JTableModel;

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
		
		

		JTableModel = new DefaultTableModel(
                new String[][] { },
                new String[] { "Rimuovi","ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo", "Parziale" });
			
		table =new JTable();
	  
		table.setModel(JTableModel);
	
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
	
	public static DefaultTableModel getModel(){
		
		return (DefaultTableModel) JTableModel;	 
	}
	
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	public void updateTable(String rem, String id, String nome, String categoria, String quantita, String prezzo, String parziale)
	{
		((DefaultTableModel) JTableModel).addRow(new Object[]{rem, id, nome, categoria, quantita, prezzo, parziale});
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
