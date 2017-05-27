package agent_trade.ui.content.preventivi;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Preventivo;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.sconti.ScontoAssolutoProdottoStrategy;
import agent_trade.sconti.ScontoPercentProdottoStrategy;
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
	private JPanel panelloTabella;
	private JPanel panelloRiepilogo;
	private JPanel sottoPannRiepilogo1;
	private JPanel sottoPannRiepilogo2;
	private JPanel sottoPannRiepilogoCampi;
	private JPanel PannTotNoSconto;
	private JPanel PannImponibile;
	private JPanel PannScontoCliente;
	private JPanel PannIVA;
	private JPanel PannScontoTotale;
	private JPanel PannTotale;
	
	private JTextField textFieldImponibile;
	private JTextField textFieldIVA;
	private JTextField textFieldTotale;
	private JTextField textFieldTotNoSconto;
	private JTextField textFieldScontoCliente;
	private JTextField textFieldScontoTotale;
	
	private JTable table;
	
	private JScrollPane scrollPane;

	private JButton buttoneSalva;

	
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
		panelloTabella.setPreferredSize(new Dimension(Costanti.WIDTH_PANN_TAB,Costanti.HEIGHT_PANN_TAB));
		panel.add(panelloTabella,BorderLayout.CENTER);
		panelloTabella.setLayout(new GridLayout(1,1));
	   	
		scrollPane = new JScrollPane(creaTabellaProdotti());
		panelloTabella.add(scrollPane);
	  
		panelloRiepilogo = new JPanel();
		panelloRiepilogo.setLayout(new BorderLayout());
		panelloRiepilogo.setBackground(SystemColor.scrollbar);		
		panelloRiepilogo.setPreferredSize(new Dimension(850, 100));
		panel.add(panelloRiepilogo,BorderLayout.SOUTH);

		sottoPannRiepilogo1 = new JPanel();
		sottoPannRiepilogo1.setBackground(SystemColor.scrollbar);
		sottoPannRiepilogo1.setLayout(new BorderLayout());
		panelloRiepilogo.add(sottoPannRiepilogo1,BorderLayout.CENTER);
		
		sottoPannRiepilogoCampi = new JPanel();
		sottoPannRiepilogoCampi.setBackground(SystemColor.scrollbar);
		sottoPannRiepilogoCampi.setPreferredSize(new Dimension(600, 80));
		sottoPannRiepilogo1.add(sottoPannRiepilogoCampi,BorderLayout.EAST);
	
		
		
		PannTotNoSconto = new JPanel();
		FlowLayout flowLayout = (FlowLayout) PannTotNoSconto.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		PannTotNoSconto.setBackground(SystemColor.scrollbar);
		PannTotNoSconto.setPreferredSize(new Dimension(250, 30));
		sottoPannRiepilogoCampi.add(PannTotNoSconto);
		
		JLabel labelTotNoSconto = new JLabel(Costanti.LABEL_TOTALE_NON_SCONTATO);
		labelTotNoSconto.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTotNoSconto.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
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
		sottoPannRiepilogoCampi.add(PannImponibile);
		
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
		sottoPannRiepilogoCampi.add(PannScontoCliente);
		
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
		sottoPannRiepilogoCampi.add(PannIVA);
		
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
		sottoPannRiepilogoCampi.add(PannScontoTotale);
		
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
		sottoPannRiepilogoCampi.add(PannTotale);
		
		JLabel labelTotale = new JLabel(Costanti.LABEL_TOTALE);
		labelTotale.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTotale.setPreferredSize(new Dimension(Costanti.WIDTH_LABEL_PREV, Costanti.HEIGHT_LABEL_PREV));
		PannTotale.add(labelTotale);
		
		textFieldTotale = new JTextField();
		textFieldTotale.setColumns(10);
		textFieldTotale.setPreferredSize(new Dimension(Costanti.WIDTH_TEXT_FIELD_PREV,Costanti.HEIGHT_TEXT_FIELD_PREV));
		PannTotale.add(textFieldTotale);
		
		sottoPannRiepilogo2 = new JPanel();
		panel.add(sottoPannRiepilogo2, BorderLayout.NORTH);
		sottoPannRiepilogo2.setBackground(SystemColor.scrollbar);
		sottoPannRiepilogo2.setPreferredSize(new Dimension(Costanti.WIDTH_SOTTO_PANN_RIEPILOGO1, Costanti.HEIGHT_SOTTO_PANN_RIEPILOGO1));
		sottoPannRiepilogo2.setBorder(new EmptyBorder(10, 10, 0, 0));
		
		
		
		buttoneSalva = new JButton("");
		buttoneSalva.setToolTipText(Costanti.TIP_SALVA_PREV);
		buttoneSalva.setIcon(new ImageIcon(ItemNuovoPreventivoView.class.getResource(Costanti.SAVE_ICON)));
		
			buttoneSalva.setPreferredSize(new Dimension(Costanti.WIDTH_BUTTON_SALVA,Costanti.HEIGHT_BUTTON_SALVA));
			sottoPannRiepilogo2.add(buttoneSalva);
		
		
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
	
	public void updateTable(M_Prodotto prod, M_Preventivo_Item prev_item) throws PersistentException{
	
		int id = prod.getIdProdotto();
		M_Preventivo prev= M_Preventivo.getInstance();
		String nome = prod.getNome();
		String categoria = prod.getCategoria();
		int quant = prev_item.getQuantita();
		String prezzo = Float.toString(prod.getPrezzo()); 
		
		String sconto = setTipoScontoTabella(prev_item);
		
		String parziale = Float.toString(prev_item.calcolaParziale());
		//sarebbe opportuno visualizzare il parziale scontato
		String parziale_scontato = Float.toString(prev_item.calcolaParziale()-prev_item.getStrategiaProdotto().calcolaSconto(prev));
		
//		//se lo sconto è zero, non visualizzo nulla, altrimenti adatto a x,dd 
//		if (prod.getSconto()!=0){
//			sconto=(java.lang.Math.ceil(prod.getSconto()*100))+"%";
//		}
		
		((DefaultTableModel) JTableModel).addRow(new Object[]{null, Integer.toString(id), nome, categoria, quant, prezzo, sconto, parziale, parziale_scontato});
	}
	
	public String setTipoScontoTabella(M_Preventivo_Item item) throws PersistentException{
		
			String tipoSconto="";
			
			M_Sconto politicaSconto = M_Sconto.caricaSconto((int) ((M_Preventivo_Item) item).getIdProdotto().getSconto());
						
			if (politicaSconto instanceof M_ScontoQuantita)
			{
				if (((M_ScontoQuantita) politicaSconto).getScontoFisso()!=0) {
					tipoSconto="Sconto di "+((M_ScontoQuantita) politicaSconto).getScontoFisso()+" euro per q.tà superiori a "+((M_ScontoQuantita) politicaSconto).getQuantita();
				}
			}
			else if (politicaSconto instanceof M_ScontoPercent)
			{
				if(((M_ScontoPercent) politicaSconto).getPercent()!=0)
				{
					tipoSconto=((M_ScontoPercent) politicaSconto).getPercent()*100+" %";
				}
			}
			
			return tipoSconto;
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
	
	public void setScontoCliente(String a){
		textFieldScontoCliente.setText(a);
	}
	
	public void setTotNonScontato(String a){
		textFieldTotNoSconto.setText(a);
	}
	
	public void setScontoTotale(String a){
		textFieldScontoTotale.setText(a);
	}

	public void enableSave(boolean b){
		buttoneSalva.setEnabled(b);
	}

	public void setTot() throws PersistentException {
			
		float tot_non_scontato = M_Preventivo.getInstance().calcolaTotaleNonScontato();
		float sconto_tot = M_Preventivo.getInstance().calcolaScontoTotale();
		float totale_scontato = tot_non_scontato-sconto_tot;
		float iva=M_Preventivo.getInstance().calcolaIva(totale_scontato);
		float totale = totale_scontato+iva;
		float scontoCliente = M_Preventivo.getInstance().calcolaScontoCliente();
		
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



  
 
