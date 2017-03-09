package agent_trade.ui.content.agenti;

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

import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.model.M_Agente;
import agent_trade.util.Costanti;

public class Ricerca_agente extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_agente instance;
	
	/*attributi privati*/

	private JPanel panelloCerca;
	private JPanel panelloRisultati;
	private JPanel panelloBottoni;
	
	private JScrollPane scrollPane;

	private JTextField TFCerca;

	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelCerca;
	
	private JButton BottoneVisualizza;
	private JButton BottoneCerca;
	private JTextField TFcercaLVL;
	private JTextField TFcercaEmail;
	private JTextField TFcercaCitta;
	
	/*costruttori*/

	public Ricerca_agente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CERCA_AGENTE);
		setBounds(450, 250, 749, 406);
		getContentPane().setLayout(null);
		
		panelloCerca = new JPanel();
		panelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(panelloCerca);
		panelloCerca.setLayout(null);
		
		LabelCerca = new JLabel(Costanti.LABEL_COGNOME_AGENTE);
		LabelCerca.setBounds(10, 11, 137, 40);
		panelloCerca.add(LabelCerca);
		
		TFCerca = new JTextField();
		TFCerca.setBounds(157, 21, 180, 20);
		panelloCerca.add(TFCerca);
		TFCerca.setColumns(10);
		
		JLabel labelCercaLVL = new JLabel(Costanti.LABEL_LVL);
		labelCercaLVL.setBounds(365, 11, 64, 40);
		panelloCerca.add(labelCercaLVL);
		
		TFcercaLVL = new JTextField();
		TFcercaLVL.setColumns(10);
		TFcercaLVL.setBounds(439, 21, 180, 20);
		panelloCerca.add(TFcercaLVL);
		
		JLabel labelCercaEmail = new JLabel(Costanti.LABEL_EMAIL);
		labelCercaEmail.setBounds(10, 50, 137, 40);
		panelloCerca.add(labelCercaEmail);
		
		TFcercaEmail = new JTextField();
		TFcercaEmail.setColumns(10);
		TFcercaEmail.setBounds(157, 60, 180, 20);
		panelloCerca.add(TFcercaEmail);
		
		JLabel labelCercaCitta = new JLabel(Costanti.LABEL_CITTA);
		labelCercaCitta.setBounds(365, 50, 64, 40);
		panelloCerca.add(labelCercaCitta);
		
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
		panelloRisultati.setBounds(0, 114, 743, 176);
		getContentPane().add(panelloRisultati);
		panelloRisultati.setLayout(null);
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_RICERCA_AGENTI;
		JTableModel = new DefaultTableModel(
                new String[][] { },
                colNames);
			
		table = new JTable();
        
        table.setModel(JTableModel);
        
        table.setRowSorter (new TableRowSorter (JTableModel)); 

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 723, 154);
	    panelloRisultati.add(scrollPane);
		 
	  	panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 291, 743, 47);
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
					Ctrl_gestisciAgente.getInstance().ricercaAgente(TFCerca.getText(), TFcercaLVL.getText(), TFcercaEmail.getText(), TFcercaCitta.getText());
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
		
		BottoneVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciAgente.getInstance().recuperaAgente((int) table.getValueAt(table.getSelectedRow(),0));
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
		instance=null;	 
	}
	
	public static Ricerca_agente getInstance(){
		if (instance==null)
			instance = new Ricerca_agente();
		return instance;	 
	}
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	public void popolaTab(M_Agente[] agenti){
		
		svuotaTabella();
		labelError.setText("");
		
		for (M_Agente a : agenti) {
			((DefaultTableModel) JTableModel).addRow(new Object[]{a.getIdAgente(), a.getCognome(), a.getNome(), a.getLivello(), a.getEmail(), a.getCitta()});
		}	
	}
	
	
	public void updateTable(int id, String cognome, String nome, int lvl, String email, String citta){

		svuotaTabella();
		labelError.setText("");
        ((DefaultTableModel) JTableModel).addRow(new Object[]{id, cognome, nome, lvl, email, citta});
	}
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	public void setVisibleErroreRicercaAgente(boolean b){
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
		


