package agent_trade.ui.content.preventivi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.table.TableColumnModel;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;
import agent_trade.util.ButtonsEditorRm;
import agent_trade.util.ButtonsRendererRm;
import agent_trade.util.Costanti;
import agent_trade.util.SpinnerEditor;
import agent_trade.util.SpinnerRenderer;


public class ItemNuovoPreventivoView extends JPanel
{
	/*attributi di classe*/
	
	private static final Class ButtonsEditorRm = null;
	private static ItemNuovoPreventivoView instance;
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

	
	private JPanel sottoPannRiepilogo1;
	private JPanel sottoPannRiepilogo2;
	private JPanel sottoPannRiepilogoCampi;

	
	/*costruttori*/
	
	public ItemNuovoPreventivoView() {
		setLayout(new GridLayout(1, 1));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setLayout(new BorderLayout());
		add(panel);
		
		panelloTabella = new JPanel();
		panelloTabella.setBackground(Color.WHITE);
		panelloTabella.setBorder(new EmptyBorder(3, 3, 3, 3));
		panelloTabella.setPreferredSize(new Dimension(733,360));
		panel.add(panelloTabella,BorderLayout.CENTER);
		panelloTabella.setLayout(new GridLayout(1,1));
	   	
		scrollPane = new JScrollPane(creaTabellaProdotti());
		panelloTabella.add(scrollPane);
	  
		panelloRiepilogo = new JPanel();
		panelloRiepilogo.setLayout(new BorderLayout());
		panelloRiepilogo.setBackground(SystemColor.scrollbar);
		
		panelloRiepilogo.setPreferredSize(new Dimension(733,85));
		panel.add(panelloRiepilogo,BorderLayout.SOUTH);
		
		sottoPannRiepilogo2 = new JPanel();
		sottoPannRiepilogo2.setBackground(SystemColor.scrollbar);
		sottoPannRiepilogo2.setPreferredSize(new Dimension(95, 85));
		sottoPannRiepilogo2.setBorder(new EmptyBorder(10, 10, 0, 0));
		panelloRiepilogo.add(sottoPannRiepilogo2,BorderLayout.EAST);
		
		
		
		buttoneSalva = new JButton("");
		buttoneSalva.setToolTipText(Costanti.TIP_SALVA_PREV);
		buttoneSalva.setIcon(new ImageIcon(ItemNuovoPreventivoView.class.getResource(Costanti.SAVE_ICON)));
	
		buttoneSalva.setPreferredSize(new Dimension(50,50));
		sottoPannRiepilogo2.add(buttoneSalva);

		sottoPannRiepilogo1 = new JPanel();
		sottoPannRiepilogo1.setBackground(SystemColor.scrollbar);
		sottoPannRiepilogo1.setLayout(new BorderLayout());
		panelloRiepilogo.add(sottoPannRiepilogo1,BorderLayout.CENTER);
		
		sottoPannRiepilogoCampi = new JPanel();
		sottoPannRiepilogoCampi.setBackground(SystemColor.scrollbar);
		sottoPannRiepilogoCampi.setPreferredSize(new Dimension(170, 40));
		sottoPannRiepilogo1.add(sottoPannRiepilogoCampi,BorderLayout.EAST);
	
		
		
		JLabel labelImponibile = new JLabel(Costanti.LABEL_IMPONIBILE);
		labelImponibile.setPreferredSize(new Dimension(72,14));
		sottoPannRiepilogoCampi.add(labelImponibile);
		
		textFieldImponibile = new JTextField();
		textFieldImponibile.setColumns(10);
		textFieldImponibile.setPreferredSize(new Dimension(94,20));
		sottoPannRiepilogoCampi.add(textFieldImponibile);
		
		JLabel labelIVA = new JLabel(Costanti.LABEL_IVA);
		labelIVA.setPreferredSize(new Dimension(72,14));
		sottoPannRiepilogoCampi.add(labelIVA);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setColumns(10);
		textFieldIVA.setPreferredSize(new Dimension(94,20));
		sottoPannRiepilogoCampi.add(textFieldIVA);
		
		JLabel labelTotale = new JLabel(Costanti.LABEL_TOTALE);
		labelTotale.setPreferredSize(new Dimension(72,14));
		sottoPannRiepilogoCampi.add(labelTotale);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
		textFieldTotale.setPreferredSize(new Dimension(94,20));
		sottoPannRiepilogoCampi.add(textFieldTotale);
		
		
		buttoneSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_elaboraPreventivo.getInstance().salvaPreventivo();
				}
				catch (PersistentException e) {
					e.printStackTrace();
				}	
			}
		});
	}
	
	
	/*metodi di classe*/
	
	public static ItemNuovoPreventivoView getInstance(){
		if (instance==null)
			instance = new ItemNuovoPreventivoView();
		return instance;	 
	}
	
	public static void cancItem(){
		instance=null;
	}
	
	/*metodi privati*/
	
	private JTable creaTabellaProdotti() {
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_PREVENTIVI;
        
        final Object[][] data = {};
        
        JTableModel = new DefaultTableModel(data, colNames);
         
        table = new JTable(JTableModel);
        table.setBorder(new EmptyBorder(5, 5, 5, 5));

        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(Costanti.COLONNA_QUANTITA_TAB_PROD).setCellRenderer(new SpinnerRenderer());
        colModel.getColumn(Costanti.COLONNA_REMOVE_TAB_PROD).setCellRenderer(new ButtonsRendererRm());
        
        colModel.getColumn(Costanti.COLONNA_QUANTITA_TAB_PROD).setCellEditor(new SpinnerEditor(table));
        colModel.getColumn(Costanti.COLONNA_REMOVE_TAB_PROD).setCellEditor(new ButtonsEditorRm(table));

        colModel.getColumn(Costanti.COLONNA_REMOVE_TAB_PROD).setPreferredWidth(30);
        colModel.getColumn(Costanti.COLONNA_QUANTITA_TAB_PROD).setPreferredWidth(35);
        
	    table.setRowHeight(30);	
	    
	    return table;
	}
	
	/*metodi pubblici*/
	
	
	public void updateRow(float parz, float parziale_scontato){
		
		((DefaultTableModel) JTableModel).setValueAt(parz, table.getSelectedRow(), Costanti.COLONNA_PARZIALE_TAB_PREV);
		((DefaultTableModel) JTableModel).setValueAt(parziale_scontato, table.getSelectedRow(), Costanti.COLONNA_PARZIALE_SCONTATO_TAB_PREV);

	}
	
	public void updateTable(M_Prodotto prod, M_Preventivo_Item prev_item){
	
		int id = prod.getIdProdotto();
		String nome = prod.getNome();
		String categoria = prod.getCategoria();
		int quant = prev_item.getQuantita();
		String prezzo = Float.toString(prod.getPrezzo()); 
		//qui deve sapere di quant'è lo sconto
		String sconto = "";
		
		String parziale = Float.toString(prev_item.calcolaParziale());
		//sarebbe opportuno visualizzare il parziale scontato
		String parziale_scontato = Float.toString(prev_item.calcolaParzialeScontato());
		
		//se lo sconto è zero, non visualizzo nulla, altrimenti adatto a x,dd 
		if (prod.getSconto()!=0){
			sconto=(java.lang.Math.ceil(prod.getSconto()*100))+"%";
		}
		
		((DefaultTableModel) JTableModel).addRow(new Object[]{null, Integer.toString(id), nome, categoria, quant, prezzo, sconto, parziale, parziale_scontato});
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

	public void setTot() throws PersistentException {
		
//		somma di quant*prezzo unit
//		-Totale non scontato
		
//		somma di tutti gli sconti
//		-Sconto totale
		
//		somma di quant*prezzo - gli sconti (incluso anche quello cliente)
//		-Totale scontato (imponibile)
		
//		-iva
		
//		prezzo che effettivamente il cliente deve pagare
//		-Totale
		
		
		float tot_non_scontato = M_Preventivo.getInstance().calcolaTotaleNonScontato();
		
		//questa funzione calcola anche gli sconti clienti. In pratica calcola qualsiasi sconto 
		float sconto_tot = M_Preventivo.getInstance().calcolaScontoTotale();
		
//		imponibile, cioè il prezzo su cui si pagano le tasse
		float totale_scontato = tot_non_scontato-sconto_tot;
	
		float iva=M_Preventivo.getInstance().calcolaIva(totale_scontato);

		float totale = totale_scontato+iva;

		//eventualmente si può mettere anche lo sconto relativo al cliente
//		float scontoCliente = M_Preventivo.getInstance().calcolaScontoCliente();
		
		totale= (float) (Math.ceil(totale * Math.pow(10, 2)) / Math.pow(10, 2));


//		System.out.println("----------------------------------------");
//
//		System.out.println("Sconto Totale"+sconto_tot);
//
//		System.out.println("Totale non scontato"+tot_non_scontato);
//		
//		System.out.println("...............................");

		setImponibile(Float.toString(totale_scontato));
		setIva(Float.toString(iva));
		setTotale(Float.toString(totale));		
	}


}



  
 
