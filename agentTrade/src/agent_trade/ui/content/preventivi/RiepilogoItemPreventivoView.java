package agent_trade.ui.content.preventivi;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.orm.PersistentException;

import agent_trade.model.M_Preventivo;
import agent_trade.util.Costanti;

public class RiepilogoItemPreventivoView extends JPanel
{

	/*attributi di classe*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		panel.setLayout(new BorderLayout());
		add(panel);
		
		panelloTabella = new JPanel();
		panelloTabella.setPreferredSize(new Dimension(733,360));
		panel.add(panelloTabella, BorderLayout.CENTER);
		panelloTabella.setLayout(new GridLayout(1,1));
		

		
		
		JTableModel = new DefaultTableModel(
                new String[][] { }, Costanti.INTESTAZIONE_TABELLA_RIEPILOGO_ITEM);
			
		table =new JTable();
	  
		table.setModel(JTableModel);
		
		table.setRowHeight(25);
		scrollPane = new JScrollPane(table);
		panelloTabella.add(scrollPane);
	  
		panelloRiepilogo = new JPanel();
		panelloRiepilogo.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelloRiepilogo.setBackground(SystemColor.scrollbar);
		panelloRiepilogo.setBorder(new EmptyBorder(0, 0, 0, 30));
		panelloRiepilogo.setPreferredSize(new Dimension(733,85));
		panel.add(panelloRiepilogo,BorderLayout.SOUTH);

		sottoPannello = new JPanel();
		sottoPannello.setBackground(SystemColor.scrollbar);
		sottoPannello.setPreferredSize(new Dimension(180, 77));
		panelloRiepilogo.add(sottoPannello);
		
		JLabel labelImponibile = new JLabel(Costanti.LABEL_IMPONIBILE);
		labelImponibile.setPreferredSize(new Dimension(72,14));
		sottoPannello.add(labelImponibile);
		
		textFieldImponibile = new JTextField();
		textFieldImponibile.setColumns(10);
		textFieldImponibile.setPreferredSize(new Dimension(94,20));
		sottoPannello.add(textFieldImponibile);
		
		JLabel labelIVA = new JLabel(Costanti.LABEL_IVA);
		labelIVA.setPreferredSize(new Dimension(72,14));
		sottoPannello.add(labelIVA);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setColumns(10);
		textFieldIVA.setPreferredSize(new Dimension(94,20));
		sottoPannello.add(textFieldIVA);
		
		JLabel labelTotale = new JLabel(Costanti.LABEL_TOTALE);
		labelTotale.setPreferredSize(new Dimension(72,14));
		sottoPannello.add(labelTotale);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
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
		
	public void updateTable( String id, String nome, String categoria, String quantita, String prezzo, String sconto, String parziale, String parziale_scontato)
	{
		((DefaultTableModel) JTableModel).addRow(new Object[]{ id, nome, categoria, quantita, prezzo, sconto,  parziale, parziale_scontato});
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
	
	public void setTot(M_Preventivo m) throws PersistentException {
		
		
		
//		float imp= M_Preventivo.getInstance().calcolaImponibile();
//
//		float iva=M_Preventivo.getInstance().calcolaIva(imp);
//				
//		float tot=imp+iva;
//		tot= (float) (Math.ceil(tot * Math.pow(10, 2)) / Math.pow(10, 2));
//
//		
//		setImponibile(Float.toString(imp));
//		setIva(Float.toString(iva));
//		setTotale(Float.toString(tot));	
		
		
		/***/
		
//		somma di quant*prezzo unit
//		-Totale non scontato
		
//		somma di tutti gli sconti
//		-Sconto totale
		
//		somma di quant*prezzo - gli sconti (incluso anche quello cliente)
//		-Totale scontato (imponibile)
		
//		-iva
		
//		prezzo che effettivamente il cliente deve pagare
//		-Totale
		
		
		float tot_non_scontato = m.calcolaTotaleNonScontato();
		
		//questa funzione calcola anche gli sconti clienti. In pratica calcola qualsiasi sconto 
		float sconto_tot = m.calcolaScontoTotale();
		
//		imponibile, cioè il prezzo su cui si pagano le tasse
		float totale_scontato = tot_non_scontato-sconto_tot;
	
		float iva=m.calcolaIva(totale_scontato);

		float totale = totale_scontato+iva;

		//eventualmente si può mettere anche lo sconto relativo al cliente
//		float scontoCliente = m.calcolaScontoCliente();
		
		totale_scontato= (float) (Math.ceil(totale_scontato * Math.pow(10, 2)) / Math.pow(10, 2));
		
		totale= (float) (Math.ceil(totale * Math.pow(10, 2)) / Math.pow(10, 2));


		System.out.println("--------Sono qui-----------------");

		System.out.println("Sconto Totale"+sconto_tot);

		System.out.println("Totale non scontato"+tot_non_scontato);
		
		System.out.println("imponibile"+totale_scontato);

		System.out.println("iva"+iva);
		
		System.out.println("totale"+totale);

		
		System.out.println("...............................");

		setImponibile(Float.toString(totale_scontato));
		setIva(Float.toString(iva));
		setTotale(Float.toString(totale));		

	}
	
}
