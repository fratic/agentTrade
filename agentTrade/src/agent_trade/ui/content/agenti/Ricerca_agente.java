package agent_trade.ui.content.agenti;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
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
import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.model.M_Agente;
import agent_trade.ui.content.clienti.RiepilogoClienteView;
import agent_trade.util.Costanti;

public class Ricerca_agente extends JDialog {
	
	/*attributi di classe*/
	
	private static final long serialVersionUID = 1L;
	
	private static Ricerca_agente instance;
	
	/*attributi privati*/

	private JPanel pannelloCerca;
	private JPanel pannelloRisultati;
	private JPanel pannelloBottoni;
	private JPanel pannCognome;
	private JPanel pannLVL;
	private JPanel pannEmail;
	private JPanel pannCitta;
	private JPanel pannErrore;
	private JPanel pannBottone;
	
	private JScrollPane scrollPane;

	private JLabel LabelCognome;
	private JLabel labelLVL;
	private JLabel labelEmail;
	private JLabel labelCitta;
	private JLabel labelError;
	
	private JTextField TFCognome;
	private JTextField TFLVL;
	private JTextField TFEmail;
	private JTextField TFCitta;

	private JTable table;
	private TableModel JTableModel;
	
	private JButton BottoneVisualizza;
	private JButton BottoneModifica;
	private JButton BottoneCerca;	
	
	
	/*costruttori*/

	public Ricerca_agente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CERCA_AGENTE);
//		setBounds(450, 250, 749, 406);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-749)/2;
	    int y = (screen.height-406)/2;
	    setBounds(x,y,749,406);
		getContentPane().setLayout(null);
		
		pannelloCerca = new JPanel();
		pannelloCerca.setBounds(0, 0, 743, 114);
		getContentPane().add(pannelloCerca);
		
		pannCognome = new JPanel();
		pannCognome.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCognome);
		
		LabelCognome = new JLabel(Costanti.LABEL_COGNOME_AGENTE);
		LabelCognome.setPreferredSize(new Dimension(137, 14));
		pannCognome.add(LabelCognome);
		
		TFCognome = new JTextField();
		TFCognome.setPreferredSize(new Dimension(180, 20));
		pannCognome.add(TFCognome);
		
		pannLVL = new JPanel();
		pannLVL.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannLVL);
		
		labelLVL = new JLabel(Costanti.LABEL_LVL);
		labelLVL.setPreferredSize(new Dimension(137, 14));
		pannLVL.add(labelLVL);
		
		TFLVL = new JTextField();
		TFLVL.setPreferredSize(new Dimension(180, 20));
		pannLVL.add(TFLVL);
		
		pannEmail = new JPanel();
		pannEmail.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannEmail);
		
		labelEmail = new JLabel(Costanti.LABEL_EMAIL);
		labelEmail.setPreferredSize(new Dimension(137, 14));
		pannEmail.add(labelEmail);
		
		TFEmail = new JTextField();
		TFEmail.setPreferredSize(new Dimension(180, 20));
		pannEmail.add(TFEmail);
		
		pannCitta = new JPanel();
		pannCitta.setPreferredSize(new Dimension(365, 30));
		pannelloCerca.add(pannCitta);
		
		labelCitta = new JLabel(Costanti.LABEL_CITTA);
		labelCitta.setPreferredSize(new Dimension(137, 14));
		pannCitta.add(labelCitta);
		
		TFCitta = new JTextField();
		TFCitta.setPreferredSize(new Dimension(180, 20));
		pannCitta.add(TFCitta);
		
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
		
		String[] colNames = Costanti.INTESTAZIONE_TABELLA_RICERCA_AGENTI;
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
		BottoneVisualizza.setVisible(false);
		BottoneVisualizza.setBounds(634, 11, 99, 23);
		pannelloBottoni.add(BottoneVisualizza);

		BottoneModifica = new JButton(Costanti.BOTTONE_MODIFICA);
		BottoneModifica.setEnabled(false);
		BottoneModifica.setVisible(false);
		BottoneModifica.setBounds(634, 11, 99, 23);
		pannelloBottoni.add(BottoneModifica);

		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		BottoneCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				svuotaTabella();					
				try {
					Ctrl_gestisciAgente.getInstance().ricercaAgente(TFCognome.getText(), TFLVL.getText(), TFEmail.getText(), TFCitta.getText());
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

		BottoneModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Ctrl_gestisciClienteFactory.getInstance().assegnaAgente(RiepilogoClienteView.cliente, (int) table.getValueAt(table.getSelectedRow(),0));
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

//		svuotaTabella();
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
	
	public void setVisibleBtnVisualizza(boolean b){
		BottoneVisualizza.setVisible(b);
	}
	
	
	public void setVisibleBtnModifica(boolean b){
		BottoneModifica.setVisible(b);
	}
		
}
		


