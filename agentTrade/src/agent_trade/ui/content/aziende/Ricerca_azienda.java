package agent_trade.ui.content.aziende;

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

import agent_trade.controller.Ctrl_gestisciAzienda;
import agent_trade.model.M_Azienda;
import agent_trade.util.Costanti;


public class Ricerca_azienda extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_azienda instance;
	
	/*attributi privati*/

	private JPanel panelloCerca;
	private JPanel panelloRisultati;
	private JPanel panelloBottoni;
	
	private JScrollPane scrollPane;

	private JTextField TFCercaNome;
	private JTextField TFcercaPIVA;
	private JTextField TFcercaCodFisc;
	private JTextField TFcercaCitta;

	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelCercaNome;
	private JLabel LabelCercaPIVA;
	private JLabel LabelCercaCodFisc;
	private JLabel LabelCercaCitta;
	
	private JButton BottoneVisualizza;
	private JButton BottoneCerca;
	

	/*attributi privati*/
	
	public Ricerca_azienda(){
		
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		setTitle(Costanti.TITOLO_CERCA_AZIENDA);
		setBounds(450, 250, 749, 406);
		getContentPane().setLayout(null);
		
		panelloCerca = new JPanel();
		panelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(panelloCerca);
		panelloCerca.setLayout(null);
		
		LabelCercaNome = new JLabel(Costanti.LABEL_NOME_AZIENDA);
		LabelCercaNome.setBounds(10, 11, 137, 40);
		panelloCerca.add(LabelCercaNome);
		
		TFCercaNome = new JTextField();
		TFCercaNome.setBounds(157, 21, 180, 20);
		panelloCerca.add(TFCercaNome);
		TFCercaNome.setColumns(10);
		
		LabelCercaPIVA = new JLabel(Costanti.LABEL_PARTITA_IVA);
		LabelCercaPIVA.setBounds(365, 11, 64, 40);
		panelloCerca.add(LabelCercaPIVA);
		
		TFcercaPIVA = new JTextField();
		TFcercaPIVA.setColumns(10);
		TFcercaPIVA.setBounds(439, 21, 180, 20);
		panelloCerca.add(TFcercaPIVA);
		
		LabelCercaCodFisc = new JLabel(Costanti.LABEL_COD_FISC);
		LabelCercaCodFisc.setBounds(10, 50, 137, 40);
		panelloCerca.add(LabelCercaCodFisc);
		
		TFcercaCodFisc = new JTextField();
		TFcercaCodFisc.setColumns(10);
		TFcercaCodFisc.setBounds(157, 60, 180, 20);
		panelloCerca.add(TFcercaCodFisc);
		
		LabelCercaCitta = new JLabel(Costanti.LABEL_CITTA);
		LabelCercaCitta.setBounds(365, 50, 64, 40);
		panelloCerca.add(LabelCercaCitta);
		
		TFcercaCitta = new JTextField();
		TFcercaCitta.setColumns(10);
		TFcercaCitta.setBounds(439, 60, 180, 20);
		panelloCerca.add(TFcercaCitta);
		
		BottoneCerca = new JButton(Costanti.BOTTONE_CERCA);
		BottoneCerca.setBounds(644, 80, 89, 23);
		panelloCerca.add(BottoneCerca);
		
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(10, 89, 219, 14);
		panelloCerca.add(labelError);
		
		panelloRisultati = new JPanel();
		panelloRisultati.setBounds(0, 114, 743, 216);
		getContentPane().add(panelloRisultati);
		panelloRisultati.setLayout(null);
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_RICERCA_AZIENDE;
		JTableModel = new DefaultTableModel(
                new String[][] { },
                colNames);
			
		table = new JTable();
        
        table.setModel(JTableModel);
        
        table.setRowSorter (new TableRowSorter (JTableModel)); 

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 723, 200);
	    panelloRisultati.add(scrollPane);
	    
	    panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 321, 743, 47);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		BottoneVisualizza = new JButton(Costanti.BOTTONE_VISUALIZZA);
		BottoneVisualizza.setEnabled(false);
		BottoneVisualizza.setBounds(634, 11, 99, 23);
		panelloBottoni.add(BottoneVisualizza);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				svuotaTabella();					
				try {
					Ctrl_gestisciAzienda.getInstance().ricercaAzienda(TFCercaNome.getText(), TFcercaPIVA.getText(), TFcercaCodFisc.getText(), TFcercaCitta.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		BottoneVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAzienda.getInstance().recuperaAzienda((int) table.getValueAt(table.getSelectedRow(),0));
				} catch (PersistentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				BottoneVisualizza.setEnabled(true);
			     }
		});	
		
	}
	
	/*metodi di classe*/
	
	public static void cancInstanza(){
		instance = null;	 
	}
	
	public static Ricerca_azienda getInstance(){
		if (instance == null)
			instance = new Ricerca_azienda();
		return instance;	 
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public void popolaTab(M_Azienda[] aziende){
		
		svuotaTabella();
		labelError.setText("");
		
		for (M_Azienda a : aziende) {
			((DefaultTableModel) JTableModel).addRow(new Object[]{a.getIdAzienda(), a.getRagioneSociale(), a.getCodiceFiscale(), a.getPartitaIva(), a.getCitta()});
		}	
	}
	
	public void updateTable(int id, String ragSoc, String codFis, String pIva, String citta){

		svuotaTabella();
		labelError.setText("");
        ((DefaultTableModel) JTableModel).addRow(new Object[]{id, ragSoc, codFis, pIva, citta});
	}
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	public void setVisibleErroreRicercaAzienda(boolean b){
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
	
}
