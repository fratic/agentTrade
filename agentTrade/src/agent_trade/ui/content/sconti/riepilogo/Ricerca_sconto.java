package agent_trade.ui.content.sconti.riepilogo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
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

import agent_trade.controller.Ctrl_gestisciCliente;
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
	private JPanel pannID;
	private JPanel pannPIVA;
	private JPanel pannCodFis;
	private JPanel pannCitta;
	private JPanel pannErrore;
	private JPanel pannBottone;
	
	private JScrollPane scrollPane;

	private JTextField TFCercaID;
	private JTextField TFcercaPIVA;
	private JTextField TFcercaCodFisc;
	private JTextField TFcercaCitta;

	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelCercaID;
	private JLabel LabelCercaPIVA;
	private JLabel LabelCercaCodFisc;
	private JLabel LabelCercaCitta;
	
	private JButton BottoneVisualizza;
	private JButton BottoneModifica;
	private JButton BottoneCerca;
	

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
		pannelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(pannelloCerca);
		
		pannID = new JPanel();
		pannID.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannID);

		LabelCercaID = new JLabel(Costanti.LABEL_ID_SCONTO);
		LabelCercaID.setPreferredSize(new Dimension(137, 14));
		pannID.add(LabelCercaID);
		
		TFCercaID = new JTextField();
		TFCercaID.setPreferredSize(new Dimension(180, 20));
		pannID.add(TFCercaID);
		
		pannPIVA = new JPanel();
		pannPIVA.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannPIVA);
		
//		LabelCercaPIVA = new JLabel(Costanti.LABEL_PARTITA_IVA);
//		LabelCercaPIVA.setPreferredSize(new Dimension(137, 14));
//		pannPIVA.add(LabelCercaPIVA);
//		
//		TFcercaPIVA = new JTextField();
//		TFcercaPIVA.setPreferredSize(new Dimension(180, 20));
//		pannPIVA.add(TFcercaPIVA);
		
		pannCodFis = new JPanel();
		pannCodFis.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCodFis);
		
//		LabelCercaCodFisc = new JLabel(Costanti.LABEL_COD_FISC);
//		LabelCercaCodFisc.setPreferredSize(new Dimension(137, 14));
//		pannCodFis.add(LabelCercaCodFisc);
//		
//		TFcercaCodFisc = new JTextField();
//		TFcercaCodFisc.setPreferredSize(new Dimension(180, 20));
//		pannCodFis.add(TFcercaCodFisc);
		
		pannCitta = new JPanel();
		pannCitta.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCitta);
		
//		LabelCercaCitta = new JLabel(Costanti.LABEL_CITTA);
//		LabelCercaCitta.setPreferredSize(new Dimension(137, 14));
//		pannCitta.add(LabelCercaCitta);
//		
//		TFcercaCitta = new JTextField();
//		TFcercaCitta.setPreferredSize(new Dimension(180, 20));
//		pannCitta.add(TFcercaCitta);
		
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
		pannelloRisultati.setBounds(0, 114, 743, 216);
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
		
		BottoneModifica = new JButton(Costanti.BOTTONE_MODIFICA);
		BottoneModifica.setEnabled(false);
		BottoneModifica.setBounds(624, 11, 110, 23);
		BottoneModifica.setVisible(false);
		pannelloBottoni.add(BottoneModifica);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				svuotaTabella();					
				try {
					
					Ctrl_gestisciSconto.getInstance().ricercaSconto(TFCercaID.getText());
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
		
		BottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						Ctrl_gestisciCliente.getInstance().assegnaSconto((int) table.getValueAt(table.getSelectedRow(),0));
					} catch (PersistentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});

		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				BottoneVisualizza.setEnabled(true);
				BottoneModifica.setEnabled(true);
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

		svuotaTabella();
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
	
	
	public void setVisibleBtnModifica(boolean b){
		BottoneModifica.setVisible(b);
	}
}
