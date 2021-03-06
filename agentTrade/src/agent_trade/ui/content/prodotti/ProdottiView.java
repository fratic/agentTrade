package agent_trade.ui.content.prodotti;

import java.awt.GridLayout;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Azienda;
import agent_trade.model.M_Prodotto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.util.Costanti;
import agent_trade.util.DisableButton;
import agent_trade.util.MyEditor;
import agent_trade.util.MyRenderer;


public class ProdottiView extends JPanel {
	
	/*attributi di classe*/
	
	private static ProdottiView instance;
	private static Map<Integer, JButton> elencoBott=new TreeMap<>();

	/*attributi privati*/
	
	private JPanel pannelloTabella;
	private JPanel pannelloProdotti;

	private static JTable table;
	private static DefaultTableModel JTableModel;
	
	private JScrollPane scrollPane;
		


	/*costruttori*/
	
	private ProdottiView() {
		
		setLayout(new GridLayout(1,1));
		
		pannelloProdotti = new JPanel();
		add(pannelloProdotti);
		pannelloProdotti.setLayout(new GridLayout(1,1));
		
		pannelloTabella = new JPanel();
		pannelloProdotti.add(pannelloTabella);
	    pannelloTabella.setLayout(new GridLayout(1,1));

	    creaTabella();
	  	
	}
	
	
	/*metodi di classe*/
	
	public static ProdottiView getInstance(){
		if (instance==null)
			instance = new ProdottiView();
		return instance;	 
	}	
	
	public static Map<Integer, JButton> elencoBottoniProdotti(){
		return elencoBott;
	}
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	public JTable getTable(){
		return this.table;
	}
	
	
	public void updateTable(String id, String nome, String categoria, String prezzo){
	
		((DefaultTableModel) JTableModel).addRow(new Object[]{ id, nome, categoria, prezzo});
		
	}

	
//	public void initTable(M_Prodotto[] prodotti) throws PersistentException{
//		
//		JButton jb;
//	
//		for (M_Prodotto p : prodotti) {
//			
//			jb= new DisableButton();
//			
//			if (Ctrl_elaboraPreventivo.prevInCorso)
//			{
//				if (Ctrl_elaboraPreventivo.getElencoBottDisat().containsKey(p.getIdProdotto())){
//					
//					jb.setEnabled(false);
//				}
//				else{
//					jb.setEnabled(true);
//				}
//			}
//			else{
//				jb.setEnabled(false);
//			}
//			String sconto=setTipoScontoTabella(p);
//	
//	        ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
//	        		p.getNome(), p.getCategoria(), sconto ,Float.toString(p.getPrezzo()), jb});
//	        
//			elencoBott.put(p.getIdProdotto(), jb);
//	
//	        TableColumn col = table.getColumnModel().getColumn(Costanti.COLONNA_ADD_ITEM);
//	   	    col.setMaxWidth(60);
//		    col.setMinWidth(60);            
//		}
//	}
	

	public void inserisciTabella(M_Prodotto[] prodotti, String azienda) throws PersistentException{
		
		JButton jb;
		int idAzienda=0;
		if(!azienda.equals("Tutti i prodotti")){
			idAzienda = M_Azienda.cercaAziendaNome(azienda).getIdAzienda();
		}
		
//		int k=JTableModel.getRowCount();
//		for (int i=k-1; i>=0;i--){
//			JTableModel.removeRow(i);
//			
////			System.out.println("------------Sto cancellando la riga "+i+" di "+k);
//		}		
		/*****/
		
		creaTabella();
		
		/******/
//		JTableModel.getDataVector().removeAllElements();
//		JTableModel.fireTableDataChanged();

		
		for (M_Prodotto p : prodotti) {
			
//			if (Ctrl_elaboraPreventivo.getElencoBottDisat().containsKey(p.getIdProdotto())){
//				
//				jb.setEnabled(false);
//				System.out.println("disabilitato");
//
//			}
//			else{
//				
//				jb.setEnabled(true);
//				System.out.println("abilitato");
//				
//			}
			jb= new DisableButton();

			if (Ctrl_elaboraPreventivo.prevInCorso)
			{
				if (Ctrl_elaboraPreventivo.getElencoBottDisat().containsKey(p.getIdProdotto())){
					jb.setEnabled(false);
				}
				else{
					jb.setEnabled(true);
				}
			}
			else{
				jb.setEnabled(false);
			}
			
			String sconto=setTipoScontoTabella(p);
	
			if(p.getIdAzienda()==idAzienda)
			{
				
		        ((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
		        		p.getNome(), p.getCategoria(), sconto ,Float.toString(p.getPrezzo()), jb});
		        
				//elencoBott.put(p.getIdProdotto(), jb);
//		        elencoBott.get(p.getIdProdotto());
		        TableColumn col = table.getColumnModel().getColumn(Costanti.COLONNA_ADD_ITEM);
		   	    col.setMaxWidth(60);
			    col.setMinWidth(60);   
		    }
			else if(idAzienda==0){
				
				((DefaultTableModel) JTableModel).addRow(new Object[]{ Integer.toString(p.getIdProdotto()), 
		        		p.getNome(), p.getCategoria(), sconto ,Float.toString(p.getPrezzo()), jb});
		        
				//elencoBott.put(p.getIdProdotto(), jb);
//		        elencoBott.get(p.getIdProdotto());
		        TableColumn col = table.getColumnModel().getColumn(Costanti.COLONNA_ADD_ITEM);
		   	    col.setMaxWidth(60);
			    col.setMinWidth(60); 
			}
		}
	}
	
	public void enableBottoni(){
		
		JButton jb;
			int dim=(((DefaultTableModel) JTableModel).getRowCount());
			for(int i=0;i<dim;i++) {			
				jb= (JButton)table.getValueAt(i,Costanti.COLONNA_ADD_ITEM);
				jb.setEnabled(true);
				table.setValueAt(jb, i, Costanti.COLONNA_ADD_ITEM);
			}
	}
	
	
	public void disableBottoni(){
		
		JButton jb;
			int dim=(((DefaultTableModel) JTableModel).getRowCount());
			for(int i=0;i<dim;i++) {			
				jb= (JButton)table.getValueAt(i,Costanti.COLONNA_ADD_ITEM);
				jb.setEnabled(false);
				table.setValueAt(jb, i, Costanti.COLONNA_ADD_ITEM);
			}
	}
	
	
	public String setTipoScontoTabella(M_Prodotto prodotto) throws PersistentException{
		
		String tipoSconto="";
		
		M_Sconto politicaSconto = M_Sconto.caricaSconto((int) prodotto.getSconto());
					
		if (politicaSconto instanceof M_ScontoQuantita)
		{
			if (((M_ScontoQuantita) politicaSconto).getScontoFisso()!=0) {
				tipoSconto="Sconto di "+((M_ScontoQuantita) politicaSconto).getScontoFisso()+" euro per q.t� superiori a "+((M_ScontoQuantita) politicaSconto).getQuantita();
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
	
	public void creaTabella(){
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_PRODOTTI;
        
        final Object[][] data = {};
        
        JTableModel = new DefaultTableModel(data, colNames);
         
        table = new JTable(JTableModel);
        table.setBorder(new EmptyBorder(5, 5, 5, 5));

        TableColumnModel colModel = table.getColumnModel();
        
        colModel.getColumn(Costanti.COLONNA_ADD_ITEM).setPreferredWidth(35);
        table.setDefaultRenderer(Object.class, new MyRenderer());
        table.setDefaultEditor(Object.class, new MyEditor());
        
	    table.setRowHeight(30);
	    pannelloTabella.removeAll();
	    scrollPane = new JScrollPane(table);
	    pannelloTabella.add(scrollPane);
	    pannelloTabella.repaint();
	}
	
}
