package agent_trade.ui.content.preventivi;

import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.orm.PersistentException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.model.M_Cliente;
import agent_trade.model.M_Preventivo;
import agent_trade.util.Costanti;
import java.awt.FlowLayout;


public class Ricerca_preventivo extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	private static Ricerca_preventivo instance;
	
	/*attributi privati*/

	private JPanel pannelloCerca;
	private JPanel pannelloRisultati;
	private JPanel pannelloBottoni;
	private JPanel pannCognome;
	private JPanel pannID;
	private JPanel pannNome;
	private JPanel pannCodFis;
	private JPanel pannErrore;
	private JPanel pannBottone;
	
	private JTable table;
	private TableModel JTableModel;
	
	private JScrollPane scrollPane;

	private JLabel labelError;
	private JLabel LabelCognome;
	private JLabel labelID;
	private JLabel labelCodFis;
	private JLabel LabelNome;
	
	private JTextField TFCognome;
	private JTextField TFID;
	private JTextField TFCodFis;
	private JTextField TFNome;
	
	private JButton BottoneVisualizza;
	private JButton BottoneCerca;
	

	/*costruttori*/
	
	public Ricerca_preventivo(){
		
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CERCA_PREVENTIVO);
		setBounds(450, 250, 749, 406);
		getContentPane().setLayout(null);
		
		pannelloCerca = new JPanel();
		pannelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(pannelloCerca);
		
		pannID = new JPanel();
		pannID.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannID);
		
		labelID = new JLabel(Costanti.LABEL_ID_PREV);
		labelID.setPreferredSize(new Dimension(137, 14));
		pannID.add(labelID);
		
		TFID = new JTextField();
		TFID.setPreferredSize(new Dimension(180, 20));
		pannID.add(TFID);
		
		pannCodFis = new JPanel();
		pannCodFis.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCodFis);
		
		labelCodFis = new JLabel(Costanti.LABEL_COD_FISC);
		labelCodFis.setPreferredSize(new Dimension(137, 14));
		pannCodFis.add(labelCodFis);
		
		TFCodFis = new JTextField();
		TFCodFis.setPreferredSize(new Dimension(180, 20));
		pannCodFis.add(TFCodFis);
		
		pannCognome = new JPanel();
		pannCognome.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCognome);
		
		LabelCognome = new JLabel(Costanti.LABEL_COGNOME_CLIENTE);
		LabelCognome.setPreferredSize(new Dimension(137, 14));
		pannCognome.add(LabelCognome);
		
		TFCognome = new JTextField();
		TFCognome.setPreferredSize(new Dimension(180, 20));
		pannCognome.add(TFCognome);
		
		pannNome = new JPanel();
		pannNome.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannNome);
		
		LabelNome = new JLabel(Costanti.LABEL_NOME_CLIENTE);
		LabelNome.setPreferredSize(new Dimension(137, 14));
		pannNome.add(LabelNome);
		
		TFNome = new JTextField();
		TFNome.setPreferredSize(new Dimension(180, 20));
		pannNome.add(TFNome);	
		
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
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_RICERCA_PREVENTIVI;
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
		BottoneVisualizza.setBounds(634, 11, 99, 23);
		pannelloBottoni.add(BottoneVisualizza);
		
		JButton BottoneAnnullaCerca = new JButton(Costanti.BOTTONE_ANNULLA);
		BottoneAnnullaCerca.setBounds(506, 11, 99, 23);
		pannelloBottoni.add(BottoneAnnullaCerca);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneAnnullaCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_elaboraPreventivo.getInstance().annullaRicercaPreventivo();
			}
		});
		
		
		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int k=((DefaultTableModel) JTableModel).getRowCount();
					for (int i=k-1; i>=0;i--){
						((DefaultTableModel) JTableModel).removeRow(i);
					}

					try {
						Ctrl_elaboraPreventivo.getInstance().ricercaPreventivo(TFID.getText(), TFCodFis.getText(), TFCognome.getText(), TFNome.getText());
					} 
					catch (PersistentException e) {
						e.printStackTrace();
					}
			}
		});
		
		BottoneVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Ctrl_elaboraPreventivo.getInstance().recuperaPreventivo((int) table.getValueAt(table.getSelectedRow(),0));
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
	
	public static Ricerca_preventivo getInstance(){
		if(instance == null)
			instance = new Ricerca_preventivo();
		return instance;
	}
	
	public static void cancInstanza(){
		instance = null;
	}
	
	/*metodi privati*/
	
	
	/*metodi pubblici*/
	
	public void popolaTab(M_Preventivo[] listaPrev){
		
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
		labelError.setText("");
		
		for(M_Preventivo p : listaPrev){
			((DefaultTableModel) JTableModel).addRow(new Object[]{p.getIdPreventivo(), p.getRif_Cliente().getNome() +" "+ p.getRif_Cliente().getCognome(),p.getData()});
		}
	}
	

	public void updateTable(int idPreventivo, M_Cliente rif_Cliente, Date data) {
		
		labelError.setText("");
		((DefaultTableModel) JTableModel).addRow(new Object[]{idPreventivo, rif_Cliente.getNome() +" "+ rif_Cliente.getCognome(),data});
	}
	
	
	public void resetRicerca(){
		TFCodFis.setText(null);
		TFCognome.setText(null);
		TFID.setText(null);
		TFNome.setText(null);
	}
	
	
	public void svuotaTabella() {
		int k=((DefaultTableModel) JTableModel).getRowCount();
		for (int i=k-1; i>=0;i--){
			((DefaultTableModel) JTableModel).removeRow(i);
		}
	}
	
	
	public void setVisibleErroreRicercaPreventivo(boolean b){
		labelError.setVisible(b);
	}
	
	
	public void setErrore(String err) {
		labelError.setText(err);
	}
	
}
