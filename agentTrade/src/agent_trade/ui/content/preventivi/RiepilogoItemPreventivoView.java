package agent_trade.ui.content.preventivi;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class RiepilogoItemPreventivoView extends JPanel
{

	/*attributi di classe*/
	
	private static RiepilogoItemPreventivoView instance;
	private static TableModel JTableModel;

	
	/*attributi privati*/

	private JTextField textFieldImponibile;
	private JTextField textFieldIVA;
	private JTextField textFieldTotale;
	
	private JPanel panelloTabella;
	private JPanel panelloRiepilogo;
	private JPanel sottoPannello;

	private JTable table;

	//private JButton buttoneSalva;

	private JScrollPane scrollPane;

	
	/*costruttori*/
	
	public RiepilogoItemPreventivoView() {

		setLayout(new GridLayout(1,1));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
//		MODIFICA
		panel.setLayout(new BorderLayout());
		//panel.setBounds(0, 0, 733, 457);
		add(panel);
		
		panelloTabella = new JPanel();
//		MODIFICA PROSSIME 4 RIGHE
		//panelloTabella.setBounds(0, 4, 733, 360);
		panelloTabella.setPreferredSize(new Dimension(733,360));
		panel.add(panelloTabella, BorderLayout.CENTER);
		panelloTabella.setLayout(new GridLayout(1,1));
		

		
		
		JTableModel = new DefaultTableModel(
                new String[][] { },
                new String[] {"ID prodotto", "Nome", "Categoria", "Quantità", "Prezzo", "Parziale" });
			
		table =new JTable();
	  
		table.setModel(JTableModel);
		
		table.setRowHeight(25);
		scrollPane = new JScrollPane(table);
//		MODIFICA PROSSIMA RIGA
		//scrollPane.setBounds(0, 0, 733, 360);
		panelloTabella.add(scrollPane);
	  
		panelloRiepilogo = new JPanel();
//		MODIFICA
		panelloRiepilogo.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelloRiepilogo.setBackground(SystemColor.scrollbar);
		//panelloRiepilogo.setBounds(0, 372, 733, 85);
		panelloRiepilogo.setBorder(new EmptyBorder(0, 0, 0, 30));
		panelloRiepilogo.setPreferredSize(new Dimension(733,85));
		panel.add(panelloRiepilogo,BorderLayout.SOUTH);

//		MODIFICA ORDINE INSERIMENTO LABEL E FARE MODIFICHE	
		sottoPannello = new JPanel();
		sottoPannello.setBackground(SystemColor.scrollbar);
		sottoPannello.setPreferredSize(new Dimension(180, 77));
		panelloRiepilogo.add(sottoPannello);
		
		JLabel labelImponibile = new JLabel("Imponibile");
		//labelImponibile.setBounds(512, 8, 72, 14);
		labelImponibile.setPreferredSize(new Dimension(72,14));
		sottoPannello.add(labelImponibile);
		
		textFieldImponibile = new JTextField();
		textFieldImponibile.setColumns(10);
		//textFieldImponibile.setBounds(594, 5, 94, 20);
		textFieldImponibile.setPreferredSize(new Dimension(94,20));
		sottoPannello.add(textFieldImponibile);
		
		JLabel labelIVA = new JLabel("I.V.A.");
		//labelIVA.setBounds(512, 33, 72, 14);
		labelIVA.setPreferredSize(new Dimension(72,14));
		sottoPannello.add(labelIVA);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setColumns(10);
		//textFieldIVA.setBounds(594, 30, 94, 20);
		textFieldIVA.setPreferredSize(new Dimension(94,20));
		sottoPannello.add(textFieldIVA);
		
		JLabel labelTotale = new JLabel("Totale");
		//labelTotale.setBounds(512, 58, 72, 14);
		labelTotale.setPreferredSize(new Dimension(72,14));
		sottoPannello.add(labelTotale);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
		//textFieldTotale.setBounds(594, 55, 94, 20);
		textFieldTotale.setPreferredSize(new Dimension(94,20));
		sottoPannello.add(textFieldTotale);

		
	}
	
	/*metodi di classe*/
	
	public static RiepilogoItemPreventivoView getInstance(){
		if (instance==null)
			instance = new RiepilogoItemPreventivoView();
		return instance;	 
	}
	
	public static DefaultTableModel getModel(){
		
		return (DefaultTableModel) JTableModel;	 
	}
	
	public static void cancellaIstanzaRiepilogoItem(){
		instance=null;
	}

	
	/*metodi privati*/
	/*metodi pubblici*/
		
	public void updateTable( String id, String nome, String categoria, String quantita, String prezzo, String parziale)
	{
		((DefaultTableModel) JTableModel).addRow(new Object[]{ id, nome, categoria, quantita, prezzo, parziale});
	}
	
	public void resetTable(){
		int k=((DefaultTableModel) JTableModel).getRowCount();

		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
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
	
	public void setTot(float imp, float iva, float tot) {
		setImponibile(Float.toString(imp));
		setIva(Float.toString(iva));
		setTotale(Float.toString(tot));		
	}
	
}
