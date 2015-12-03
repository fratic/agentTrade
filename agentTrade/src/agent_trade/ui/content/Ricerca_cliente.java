package agent_trade.ui.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;

public class Ricerca_cliente extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_cliente instance;
	
	/*attributi privati*/

	private JPanel panelloCerca;
	private JPanel panelloRisultati;
	private JPanel panelloBottoni;
	
	private JScrollPane scrollPane;

	private JTextField TFCerca;

	private JList<M_Cliente> clienti;
	
	private JTable table;
	private TableModel JTableModel;
	
	private JLabel labelError;
	private JLabel LabelCerca;
	
	private JButton BottoneVisualizza;
	private JButton BottoneCerca;
	
	/*costruttori*/

	public Ricerca_cliente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle("Cerca Cliente");
		setBounds(350, 200, 576, 324);
		getContentPane().setLayout(null);
		
		panelloCerca = new JPanel();
		panelloCerca.setBounds(0, 0, 560, 62);
		getContentPane().add(panelloCerca);
		panelloCerca.setLayout(null);
		
		LabelCerca = new JLabel("Cerca Cliente");
		LabelCerca.setBounds(34, 11, 74, 40);
		panelloCerca.add(LabelCerca);
		
		TFCerca = new JTextField();
		TFCerca.setBounds(118, 21, 219, 20);
		panelloCerca.add(TFCerca);
		TFCerca.setColumns(10);
		
		BottoneCerca = new JButton("Cerca");
		BottoneCerca.setBounds(385, 20, 89, 23);
		panelloCerca.add(BottoneCerca);
		
		labelError = DefaultComponentFactory.getInstance().createLabel("");
		labelError.setHorizontalAlignment(SwingConstants.CENTER);
		labelError.setBounds(118, 48, 219, 14);
		panelloCerca.add(labelError);
		
		panelloRisultati = new JPanel();
		panelloRisultati.setBounds(0, 62, 560, 176);
		getContentPane().add(panelloRisultati);
		panelloRisultati.setLayout(null);
		
		JTableModel = new DefaultTableModel(
                new String[][] { },
                new String[] { "Cognome", "Nome","Codice Fiscale", "Partita iva"});
			
		table =new JTable();
        
        table.setModel(JTableModel);

	    scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(10, 11, 540, 154);
	    panelloRisultati.add(scrollPane);
		 
	  	panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 238, 560, 47);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		BottoneVisualizza = new JButton("Visualizza");
		BottoneVisualizza.setEnabled(false);
		BottoneVisualizza.setBounds(451, 11, 99, 23);
		panelloBottoni.add(BottoneVisualizza);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//fare una funzione che resetta la tabella ed anche tutto il resto che va resettato
				int k=((DefaultTableModel) JTableModel).getRowCount();
					for (int i=k-1; i>=0;i--){
						((DefaultTableModel) JTableModel).removeRow(i);
					}
					//fare le modifiche a ricerca cliente!!!!
					Ctrl_gestisciCliente.getInstance().ricercaCliente(TFCerca.getText());
			}
		});
		
		BottoneVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//qui andrebbe passato o l'id del cliente oppure (meglio) l'oggetto cliente. AGGIUSTARE	
				Ctrl_gestisciCliente.getInstance().recuperaCliente((String) table.getValueAt(table.getSelectedRow(),0));
				//CercaClienteView.getInstance().dispose();
			}
		});

		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				BottoneVisualizza.setEnabled(true);
			     }
		});		 
	}
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/
	
	public void popolaTab(ArrayList a){
		
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
		labelError.setText("");
				
		Iterator iteraClienti = null;
		
		iteraClienti = a.iterator();
		
		while (iteraClienti.hasNext()) {
			M_Cliente c = new M_Cliente();
			c = (M_Cliente) iteraClienti.next();
			((DefaultTableModel) JTableModel).addRow(new Object[]{c.getCognome(),c.getNome(),c.getCodice_fiscale(),c.getPartita_iva()});
		}
	}
	
	public void updateTable(String cognome, String nome,String cf, String pi){
//		int k=((DefaultTableModel) JTableModel).getRowCount();
//		for (int i=k-1; i>=0;i--){
//			((DefaultTableModel) JTableModel).removeRow(i);
//		}
			labelError.setText("");
            ((DefaultTableModel) JTableModel).addRow(new Object[]{ cognome, nome, cf, pi});
	}
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	public void setErrore(String err) {
		labelError.setText(err);
	}
	
	public static void cancInstanza(){
		instance=null;	 
	}
	
	public String getRicerca(){
		return TFCerca.getText();
	}
	
	public static Ricerca_cliente getInstance(){
		if (instance==null)
			instance = new Ricerca_cliente();
		return instance;	 
	}
	
//	public static void cancInst(){
//		instance=null;	 
//	}
		
	public TableModel getJTableModel(){
		return JTableModel;	 
	}
	
	
	public JTable getTableInstance(){
		return table;	 
	}
	
//	public void setElements(M_Cliente[] listData){
//		this.clienti.setListData(listData);
//	}
	
	private void init(){
		this.clienti = new JList<M_Cliente>();
	}
	
}
		


