package agent_trade.ui.content.listini;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.model.M_Preventivo_Item;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.util.Costanti;
import agent_trade.util.MyEditor;
import agent_trade.util.MyRenderer;


import org.orm.PersistentException;


public class RiepilogoListinoView extends JPanel {

	/*attributi di classe*/
	
	private static RiepilogoListinoView instance;

	/*attributi privati*/
	
	private JPanel pannelloCentro;
	private JPanel pannelloProdotti;
	private JPanel pannelloTabella;
	
	private DefaultTableModel JTableModel;
	private JTable table;

	private JScrollPane scrollPane;
	
	/*costruttori*/
	
	public RiepilogoListinoView(){
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), Costanti.TITOLO_SCHEDA_LISTINO, TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.focus")));
		setBackground(UIManager.getColor("CheckBox.background"));
		setLayout(new BorderLayout());
		
		pannelloCentro = new JPanel();
		pannelloCentro.setPreferredSize(new Dimension(733,610));
		pannelloCentro.setLayout(new GridLayout(1,1));
		this.add(pannelloCentro, BorderLayout.CENTER);
		
		pannelloProdotti = new JPanel();
		pannelloProdotti.setLayout(new GridLayout(1,1));
		pannelloCentro.add(pannelloProdotti);
		
		pannelloTabella = new JPanel();
		pannelloProdotti.add(pannelloTabella);
	    pannelloTabella.setLayout(new GridLayout(1,1));


		String[] colNames = Costanti.INTESTAZIONE_LISTINO_PRODOTTI;
        
        final Object[][] data = {};
        
        JTableModel = new DefaultTableModel(data, colNames);
         
        table = new JTable(JTableModel);
        table.setBorder(new EmptyBorder(5, 5, 5, 5));

	    
        TableColumnModel colModel = table.getColumnModel();
        
        colModel.getColumn(Costanti.COLONNA_SHOW_ITEM_BUTTON).setPreferredWidth(35); 
        table.setDefaultRenderer(Object.class, new MyRenderer());
        table.setDefaultEditor(Object.class, new MyEditor());
        
	    table.setRowHeight(30);
	    
	    scrollPane = new JScrollPane(table);
	    pannelloTabella.add(scrollPane);

	}
	
	/*metodi di classe*/
	
	public static RiepilogoListinoView getInstance(){
		if (instance==null)
			instance = new RiepilogoListinoView();
		return instance;
	}

	
	public static void cancRiepilogoListino(){
		instance = null;
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public void initTable(M_Prodotto[] prodotti) throws PersistentException{
		
		svuotaTabella();
		
		JButton btnDettaglio; //FORSE è UTILE FARE COME DISABLEBUTTON 
		
		for (M_Prodotto p : prodotti) {
			
			btnDettaglio = new JButton("");
			btnDettaglio.setPreferredSize(new Dimension(35, 20));
			btnDettaglio.setToolTipText(Costanti.TIP_DETTAGLIO_PRODOTTO);
			btnDettaglio.setIcon(new ImageIcon(RiepilogoListinoView.class.getResource(Costanti.SHOW_ICON)));
			
			String sconto=setTipoScontoTabella(p);
	
			
	        ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
	        		p.getNome(), p.getCategoria(), sconto ,Float.toString(p.getPrezzo()),  btnDettaglio});
	        
	        TableColumn col = table.getColumnModel().getColumn(Costanti.COLONNA_SHOW_ITEM_BUTTON); 
	   	    col.setMaxWidth(80);
		    col.setMinWidth(80);
		
		    btnDettaglio.addActionListener(new ActionListener() {
				
		    	public void actionPerformed(ActionEvent arg0) {
					
					String sel= (String)table.getValueAt(table.getSelectedRow(),Costanti.COLONNA_ID_SHOW_ITEM_BUTTON);
					
					try {
						Ctrl_gestisciListino.getInstance().mostraProdotto(Integer.parseInt(sel));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			});
		
		}
	}
	
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	
	public JTable getTable(){
		return this.table;
	}
	
	
	public String setTipoScontoTabella(M_Prodotto prodotto) throws PersistentException{
		
		String tipoSconto="";
		
		M_Sconto politicaSconto = M_Sconto.caricaSconto((int) prodotto.getSconto());
					
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
	
	
	
}
