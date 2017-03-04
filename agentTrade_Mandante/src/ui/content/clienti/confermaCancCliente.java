package ui.content.clienti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.model.M_Cliente;
import example.DynamicTreeDemo;
import ui.content.clienti.RiepilogoClienteView;
import util.Costanti;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

import org.orm.PersistentException;

public class confermaCancCliente extends JDialog {
	
	/*attributi di classe*/
	
	//private static final long serialVersionUID = 1L;
	
	private static confermaCancCliente instance;	

	
	/*attributi privati*/

	private JPanel contentPane;
	private JPanel panelloBottoni;
	
	private JLabel LabelTesto;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private String cliente = null; //per tenere traccia del cliente
	
	/*costruttori*/

	public confermaCancCliente() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		
		
		setTitle(Costanti.TITOLO_CANCELLA_CLIENTE);
		setBounds(350, 200, 340, 151);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 334, 65);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		LabelTesto = new JLabel(Costanti.MESSAGGIO_CANCELLA_CLIENTE);
		LabelTesto.setBounds(43, 11, 241, 40);
		contentPane.add(LabelTesto);
		
		panelloBottoni = new JPanel();
		panelloBottoni.setBounds(0, 65, 334, 53);
		getContentPane().add(panelloBottoni);
		panelloBottoni.setLayout(null);
		
		okButton = new JButton(Costanti.BOTTONE_CONFERMA);
		okButton.setBounds(91, 11, 62, 23);
		panelloBottoni.add(okButton);
		
		cancelButton = new JButton(Costanti.BOTTONE_ANNULLA);
		cancelButton.setBounds(175, 11, 82, 23);
		panelloBottoni.add(cancelButton);
		 
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Ctrl_gestisciCliente.getInstance().postConfermaCancCliente(cliente);
				} 
				catch (PersistentException e) {
					e.printStackTrace();
				}
			}
		});
	
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ctrl_gestisciCliente.getInstance().notConfermaCancCliente();
			}
		});
		 
	}
	
	/*metodi di classe*/
	/*metodi privati*/
	/*metodi pubblici*/
	
	public static confermaCancCliente getInstance(){
		if (instance==null)
			instance = new confermaCancCliente();
		return instance;	 
	}
	
	public static void cancInst(){
		instance=null;	 
	}
	
	public String getCliente(){
		return cliente;
	}
	
	public void setCliente(String id){
		 cliente=id;
	}
	
}