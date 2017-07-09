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
import javax.swing.SwingConstants;
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


	private JScrollPane scrollPane;
	private JPanel PannTotNoSconto;
	private JTextField textFieldTotNoSconto;
	private JPanel PannImponibile;
	private JPanel PannScontoCliente;
	private JTextField textFieldScontoCliente;
	private JPanel PannIVA;
	private JPanel PannScontoTotale;
	private JTextField textFieldScontoTotale;
	private JPanel PannTotale;

	
	/*costruttori*/
	
	public RiepilogoItemPreventivoView() {

		setLayout(new GridLayout(1,1));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setLayout(new BorderLayout());
		add(panel);
		
		panelloTabella = new JPanel();
		panelloTabella.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_TAB,Costanti.HEIGHT_PANN_TAB));
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
		panelloRiepilogo.setPreferredSize(new Dimension(780, 110));
		panel.add(panelloRiepilogo,BorderLayout.SOUTH);

		sottoPannello = new JPanel();
		sottoPannello.setBackground(SystemColor.scrollbar);
		sottoPannello.setPreferredSize(new Dimension(600, 105));
		panelloRiepilogo.add(sottoPannello);
		
		PannTotNoSconto = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PannTotNoSconto.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		PannTotNoSconto.setBackground(SystemColor.scrollbar);
		PannTotNoSconto.setPreferredSize(new Dimension(250, 30));
		sottoPannello.add(PannTotNoSconto);
		
		JLabel labelTotNoSconto = new JLabel(Costanti.LABEL_TOTALE_NON_SCONTATO);
		labelTotNoSconto.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTotNoSconto.setPreferredSize(new Dimension(100, 14));
		PannTotNoSconto.add(labelTotNoSconto);
		
		textFieldTotNoSconto = new JTextField();
		textFieldTotNoSconto.setColumns(10);
		textFieldTotNoSconto.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannTotNoSconto.add(textFieldTotNoSconto);
		
		PannImponibile = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) PannImponibile.getLayout();
		flowLayout1.setVgap(0);
		flowLayout1.setHgap(0);
		PannImponibile.setBackground(SystemColor.scrollbar);
		PannImponibile.setPreferredSize(new Dimension(250, 30));
		sottoPannello.add(PannImponibile);
		
		JLabel labelImponibile = new JLabel(Costanti.LABEL_IMPONIBILE);
		labelImponibile.setHorizontalAlignment(SwingConstants.RIGHT);
		labelImponibile.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
		PannImponibile.add(labelImponibile);
		
		textFieldImponibile = new JTextField();
		textFieldImponibile.setColumns(10);
		textFieldImponibile.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannImponibile.add(textFieldImponibile);
		
		PannScontoCliente = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) PannScontoCliente.getLayout();
		flowLayout2.setVgap(0);
		flowLayout2.setHgap(0);
		PannScontoCliente.setBackground(SystemColor.scrollbar);
		PannScontoCliente.setPreferredSize(new Dimension(250, 30));
		sottoPannello.add(PannScontoCliente);
		
		JLabel labelScontoCliente = new JLabel(Costanti.LABEL_SCONTO_CLIENTE);
		labelScontoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		labelScontoCliente.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
		PannScontoCliente.add(labelScontoCliente);
		
		textFieldScontoCliente = new JTextField();
		textFieldScontoCliente.setColumns(10);
		textFieldScontoCliente.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannScontoCliente.add(textFieldScontoCliente);
		
		PannIVA = new JPanel();
		FlowLayout flowLayout3 = (FlowLayout) PannIVA.getLayout();
		flowLayout3.setVgap(0);
		flowLayout3.setHgap(0);
		PannIVA.setBackground(SystemColor.scrollbar);
		PannIVA.setPreferredSize(new Dimension(250, 30));
		sottoPannello.add(PannIVA);
		
		JLabel labelIVA = new JLabel(Costanti.LABEL_IVA);
		labelIVA.setHorizontalAlignment(SwingConstants.RIGHT);
		labelIVA.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
		PannIVA.add(labelIVA);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setColumns(10);
		textFieldIVA.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannIVA.add(textFieldIVA);
		
		PannScontoTotale = new JPanel();
		FlowLayout flowLayout4 = (FlowLayout) PannScontoTotale.getLayout();
		flowLayout4.setVgap(0);
		flowLayout4.setHgap(0);
		PannScontoTotale.setBackground(SystemColor.scrollbar);
		PannScontoTotale.setPreferredSize(new Dimension(250, 30));
		sottoPannello.add(PannScontoTotale);
		
		JLabel labelScontoTotale = new JLabel(Costanti.LABEL_SCONTO_TOTALE);
		labelScontoTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelScontoTotale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
		PannScontoTotale.add(labelScontoTotale);
		
		textFieldScontoTotale = new JTextField();
		textFieldScontoTotale.setColumns(10);
		textFieldScontoTotale.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannScontoTotale.add(textFieldScontoTotale);
		
		PannTotale = new JPanel();
		FlowLayout flowLayout5 = (FlowLayout) PannTotale.getLayout();
		flowLayout5.setVgap(0);
		flowLayout5.setHgap(0);
		PannTotale.setBackground(SystemColor.scrollbar);
		PannTotale.setPreferredSize(new Dimension(250, 30));
		sottoPannello.add(PannTotale);
		
		JLabel labelTotale = new JLabel(Costanti.LABEL_TOTALE);
		labelTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTotale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
		PannTotale.add(labelTotale);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
		textFieldTotale.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannTotale.add(textFieldTotale);

		
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
	
	public void setScontoCliente(String a){
		textFieldScontoCliente.setText(a);
	}
	
	public void setTotNonScontato(String a){
		textFieldTotNoSconto.setText(a);
	}
	
	public void setScontoTotale(String a){
		textFieldScontoTotale.setText(a);
	}
	
	public void setTot(M_Preventivo m) throws PersistentException {
		
		
		float tot_non_scontato = m.calcolaTotaleNonScontato();
		float sconto_tot = m.calcolaScontoTotale();
		float totale_scontato = tot_non_scontato-sconto_tot;
		float iva=m.calcolaIva(totale_scontato);
		float totale = totale_scontato+iva;
		float scontoCliente = m.calcolaScontoCliente();
		
		totale_scontato= (float) (Math.ceil(totale_scontato * Math.pow(10, 2)) / Math.pow(10, 2));
		iva= (float) (Math.ceil(iva * Math.pow(10, 2)) / Math.pow(10, 2));
		totale= (float) (Math.ceil(totale * Math.pow(10, 2)) / Math.pow(10, 2));
		tot_non_scontato= (float) (Math.ceil(tot_non_scontato * Math.pow(10, 2)) / Math.pow(10, 2));
		sconto_tot= (float) (Math.ceil(sconto_tot * Math.pow(10, 2)) / Math.pow(10, 2));		
		scontoCliente= (float) (Math.ceil(scontoCliente * Math.pow(10, 2)) / Math.pow(10, 2));

		setImponibile(Float.toString(totale_scontato));
		setIva(Float.toString(iva));
		setTotale(Float.toString(totale));	
		setTotNonScontato(Float.toString(tot_non_scontato));
		setScontoTotale(Float.toString(sconto_tot));
		setScontoCliente(Float.toString(scontoCliente));

	}
	
}
