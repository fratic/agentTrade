package agent_trade.ui.content.sconti.riepilogo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.model.M_Sconto;
import agent_trade.model.M_ScontoCliente;
import agent_trade.model.M_ScontoPercent;
import agent_trade.model.M_ScontoQuantita;
import agent_trade.util.Costanti;

public class Ricerca_sconto extends JDialog {

/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_sconto instance;
	
	/*attributi privati*/

	private JPanel pannelloCerca;
	private JPanel pannelloRisultati;
	private JPanel pannelloBottoni;
	private JPanel pannTipo;
	private JPanel pannVuoto1;
	//private JPanel pannVuoto2;
	//private JPanel pannVuoto3;
	private JPanel pannErrore;
	private JPanel pannBottone;
	
	private JScrollPane scrollPane;

	private JComboBox JCTipo;

	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelTipoSconto;
	
	private JButton BottoneVisualizza;
	private JButton BottoneModifica;
	private JButton BottoneCerca;
//	serve per assegnare lo sconto al cliente
	private JButton BottoneModificaCliente;
//	serve per assegnare lo sconto al prodotto
	private JButton BottoneModificaProdotto;

	/*attributi privati*/
	
	public Ricerca_sconto(){
		
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		setTitle(Costanti.TITOLO_CERCA_SCONTO);
		setBounds(450, 250, 749, 406);
		getContentPane().setLayout(null);
		
		pannelloCerca = new JPanel();
		pannelloCerca.setBounds(0, 0, 743, 84);
		getContentPane().add(pannelloCerca);
		
		pannTipo = new JPanel();
		pannTipo.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannTipo);

		LabelTipoSconto = new JLabel(Costanti.LABEL_TIPO_SCONTO);
		LabelTipoSconto.setPreferredSize(new Dimension(137, 14));
		pannTipo.add(LabelTipoSconto);

		JCTipo = new JComboBox(Costanti.LISTA_CERCA_SCONTI);
		JCTipo.setPreferredSize(new Dimension(180, 20));
		JCTipo.setToolTipText(Costanti.TIP_TIPO_SCONTO);
		JCTipo.setSelectedIndex(0);
		pannTipo.add(JCTipo);

		pannVuoto1 = new JPanel();
		pannVuoto1.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannVuoto1);
		
		pannErrore = new JPanel();
		pannErrore.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannErrore);
				
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setPreferredSize(new Dimension(350, 14));
		pannErrore.add(labelError);
		
		pannBottone = new JPanel();
		pannBottone.setPreferredSize(new Dimension(365, 30));
		pannBottone.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		pannelloCerca.add(pannBottone);
		
		BottoneCerca = new JButton(Costanti.BOTTONE_CERCA);
		BottoneCerca.setPreferredSize(new Dimension(90, 25));
		pannBottone.add(BottoneCerca);
		
		pannelloRisultati = new JPanel();
		pannelloRisultati.setBounds(0, 84, 743, 246);
		getContentPane().add(pannelloRisultati);
		pannelloRisultati.setLayout(null);
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_RICERCA_SCONTI;
		JTableModel = new DefaultTableModel(
                new String[][] { },
                colNames);
			
		table = new JTable();
        
        table.setModel(JTableModel);
        
        table.setRowSorter (new TableRowSorter (JTableModel)); 

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 723, 200);
	    pannelloRisultati.add(scrollPane);
	    
	    pannelloBottoni = new JPanel();
		pannelloBottoni.setBounds(0, 321, 743, 47);
		getContentPane().add(pannelloBottoni);
		pannelloBottoni.setLayout(null);
		
		BottoneVisualizza = new JButton(Costanti.BOTTONE_VISUALIZZA);
		BottoneVisualizza.setEnabled(false);
		BottoneVisualizza.setBounds(624, 11, 110, 23);
		pannelloBottoni.add(BottoneVisualizza);
		
		BottoneModificaCliente = new JButton(Costanti.BOTTONE_MODIFICA);
		BottoneModificaCliente.setEnabled(false);
		BottoneModificaCliente.setBounds(624, 11, 110, 23);
		BottoneModificaCliente.setVisible(false);
		pannelloBottoni.add(BottoneModificaCliente);
			
		BottoneModificaProdotto = new JButton(Costanti.BOTTONE_MODIFICA);
		BottoneModificaProdotto.setEnabled(false);
		BottoneModificaProdotto.setBounds(624, 11, 110, 23);
		BottoneModificaProdotto.setVisible(false);
		pannelloBottoni.add(BottoneModificaProdotto);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				svuotaTabella();					
				try {
					
					Ctrl_gestisciSconto.getInstance().ricercaSconto(JCTipo.getSelectedItem().toString());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		BottoneVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciSconto.getInstance().recuperaSconto((int) table.getValueAt(table.getSelectedRow(),0));
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		BottoneModificaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						Ctrl_gestisciClienteFactory.getInstance().assegnaSconto((int) table.getValueAt(table.getSelectedRow(),0));
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		BottoneModificaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						Ctrl_gestisciListino.getInstance().assegnaSconto((int) table.getValueAt(table.getSelectedRow(),0));
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});

		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				BottoneVisualizza.setEnabled(true);
				BottoneModificaCliente.setEnabled(true);
				BottoneModificaProdotto.setEnabled(true);
			}
		});	
		
	}
	
	/*metodi di classe*/
	
	public static void cancInstanza(){
		instance = null;	 
	}
	
	public static Ricerca_sconto getInstance(){
		if (instance == null)
			instance = new Ricerca_sconto();
		return instance;	 
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public void popolaTab(M_Sconto[] sconti){
		
		svuotaTabella();
		labelError.setText("");
		
		for (M_Sconto s : sconti) {
			if(s instanceof M_ScontoCliente){
				((DefaultTableModel) JTableModel).addRow(new Object[]{s.getId(), "Sconto Cliente", ((M_ScontoCliente) s).getPercent(), null, null });
			}
			else if(s instanceof M_ScontoPercent){
				((DefaultTableModel) JTableModel).addRow(new Object[]{s.getId(), "Sconto Prodotto - Percentuale", ((M_ScontoPercent) s).getPercent(), null, null });
			}
			else if(s instanceof M_ScontoQuantita){
				((DefaultTableModel) JTableModel).addRow(new Object[]{s.getId(), "Sconto Prodotto - Quantit\u00E0", null, ((M_ScontoQuantita) s).getQuantita(), ((M_ScontoQuantita) s).getScontoFisso() });
			}			
		}	
	}
	
	
	public void updateTable(M_Sconto s){

		labelError.setText("");
		
		if(s instanceof M_ScontoCliente){
			((DefaultTableModel) JTableModel).addRow(new Object[]{s.getId(), "Sconto Cliente", ((M_ScontoCliente) s).getPercent(), null, null });
		}
		else if(s instanceof M_ScontoPercent){
			((DefaultTableModel) JTableModel).addRow(new Object[]{s.getId(), "Sconto Prodotto - Percentuale", ((M_ScontoPercent) s).getPercent(), null, null });
		}
		else if(s instanceof M_ScontoQuantita){
			((DefaultTableModel) JTableModel).addRow(new Object[]{s.getId(), "Sconto Prodotto - Quantit\u00E0", null, ((M_ScontoQuantita) s).getQuantita(), ((M_ScontoQuantita) s).getScontoFisso() });
		}	
	}
	
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	
	public void setVisibleErroreRicercaSconto(boolean b){
		labelError.setVisible(b);
	}
	
	
	public void setErrore(String err) {
		labelError.setText(err);
	}
	
		
	public TableModel getJTableModel(){
		return JTableModel;	 
	}
	
		
	public JTable getTableInstance(){
		return table;	 
	}
	
	
	public void setVisibleBtnVisualizza(boolean b){
		BottoneVisualizza.setVisible(b);
	}
	
	
	public void setVisibleBtnModificaCliente(boolean b){
		BottoneModificaCliente.setVisible(b);
	}


	public void setVisibleBtnModificaProdotto(boolean b){
		BottoneModificaProdotto.setVisible(b);
	}


//		public void setSelectionSconto(int i){
//			JCTipo.setSelectedIndex(i);
//		}
}
