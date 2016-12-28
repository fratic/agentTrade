package agent_trade.ui.content.clienti;

import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.basic.BasicTreeUI.TreeSelectionHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_gestisciCliente;
import agent_trade.ui.PrimaryView;
import agent_trade.ui.content.preventivi.AlberoPreventivi;

public class AlberoClienti extends JPanel {

	/*attributi di classe*/
		
	public static DefaultTreeModel model;
	public static JTree albero;
		

	/*attributi privati*/
		
	private static DefaultMutableTreeNode radice;
	private static AlberoClienti instance;


	/*costruttori*/
		
	public AlberoClienti() {
			
			radice = new DefaultMutableTreeNode("Clienti");
			model = new DefaultTreeModel(radice);
			setLayout(null);

			albero = new JTree(model);
			albero.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			JScrollPane scroller = new JScrollPane(albero);
			scroller.setBounds(10, 12, 250, 595);
			
			add(scroller);
			
			ImageIcon imageIcon = new ImageIcon(AlberoPreventivi.class.getResource("/agent_trade/ui/img/ico-cliente1.png"));
	        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
	        renderer.setLeafIcon(imageIcon);

	        albero.setCellRenderer(renderer);
				
			//quando seleziono il cliente, mostra nel panel centrale il dettaglio
	        albero.addTreeSelectionListener((new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent e) {
					TreePath selection = e.getPath();
					try {
						Ctrl_gestisciCliente.getInstance().mostraCliente(selection.getLastPathComponent());
					} catch (PersistentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}}));
	        
	 
						
	}		
	
	
			
	/*metodi di classe*/
	
	public static AlberoClienti getInstance(){
		
		return ((instance == null) ? instance = new AlberoClienti() : instance);	
	}
	
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	//quando viene creato un nuovo cliente aggiunge un nodo all'albero	
	
	public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
	
		  model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		  
		  albero.expandRow(0);
		  
	}
			  
	public static void rimuoviNodo(String nodo) {
		
		Enumeration<MutableTreeNode> sottonodi = radice.children();
		while (sottonodi.hasMoreElements())
		{
			//ottengo i nodi singolarmente
			DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
			System.out.print(nodo1);
			if(nodo1.toString().equals(nodo)) {
				model.removeNodeFromParent(nodo1);
			}
				
		}
	}
	
	public static void updateNodo (String nodo) throws PersistentException{
		
		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	    model.reload();
	    Ctrl_System.getInstance().initAlberoClienti();
		
	}
	
	//NUOVA FUNZIONE - RISOLVE I PRECEDENTI PROBLEMI
	public static void deselezionaNodo(String nodo){
		
		  //DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
		  albero.clearSelection();

	 }
	
//	public static void selezionaRadice(){
//		
//		  albero.setSelectionPath(new TreePath(model.getRoot())); 
//		  PrimaryView.getInstance().resetPannelloCentraleCliente();
//		  PrimaryView.getInstance().setSfondoCliente();  
//
//	  }
	
	//quando seleziono la root si resetta il pannello centrale
	
	
  
	public static void disabilitaAlbero() {
			albero.setEnabled(false);
	}

	public static void abilitaAlbero() {
			albero.setEnabled(true);
	}
					  	
				  	  
				
}

//
//package agent_trade.ui.content.clienti;
//
//import java.util.Enumeration;
//
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTree;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.DefaultTreeCellRenderer;
//import javax.swing.tree.DefaultTreeModel;
//import javax.swing.tree.MutableTreeNode;
//import javax.swing.tree.TreePath;
//
//import org.orm.PersistentException;
//
//import agent_trade.controller.Ctrl_System;
//import agent_trade.controller.Ctrl_gestisciCliente;
//import agent_trade.ui.content.preventivi.AlberoPreventivi;
//
//public class AlberoClienti extends JPanel {
//
//	/*attributi di classe*/
//		
//	public static DefaultTreeModel model;
//	public static JTree albero;
//		
//
//	/*attributi privati*/
//		
//	private static DefaultMutableTreeNode radice;
//	private static AlberoClienti instance;
//
//
//	/*costruttori*/
//		
//	public AlberoClienti() {
//			
//			radice = new DefaultMutableTreeNode("Clienti");
//			model = new DefaultTreeModel(radice);
//			setLayout(null);
//
//			albero = new JTree(model);
//			albero.setBorder(new EmptyBorder(10, 10, 10, 10));
//			
//			JScrollPane scroller = new JScrollPane(albero);
//			scroller.setBounds(10, 12, 250, 595);
//			
//			add(scroller);
//			
//			ImageIcon imageIcon = new ImageIcon(AlberoPreventivi.class.getResource("/agent_trade/ui/img/ico-cliente1.png"));
//	        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
//	        renderer.setLeafIcon(imageIcon);
//
//	        albero.setCellRenderer(renderer);
//				
//			//quando seleziono il cliente, mostra nel panel centrale il dettaglio
//	        albero.addTreeSelectionListener((new TreeSelectionListener() {
//
//				public void valueChanged(TreeSelectionEvent e) {
//					TreePath selection = e.getPath();
//					try {
//						Ctrl_gestisciCliente.getInstance().mostraCliente(selection.getLastPathComponent());
//					} catch (PersistentException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}}));
//			
//	}		
//	
//	
//			
//	/*metodi di classe*/
//	
//	public static AlberoClienti getInstance(){
//		
//		return ((instance == null) ? instance = new AlberoClienti() : instance);	
//	}
//	
//	
//	/*metodi privati*/
//	/*metodi pubblici*/
//	
//	
//	//quando viene creato un nuovo cliente aggiunge un nodo all'albero	
//	
//	public static void inserisciNodo(String nodo) {
//		    
//		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
//	
//		  model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
//		  
//		  albero.expandRow(0);
//		  
//	}
//			  
//	public static void rimuoviNodo(String nodo) {
//		
//		Enumeration<MutableTreeNode> sottonodi = radice.children();
//		while (sottonodi.hasMoreElements())
//		{
//			//ottengo i nodi singolarmente
//			DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
//			System.out.print(nodo1);
//			if(nodo1.toString().equals(nodo)) {
//				model.removeNodeFromParent(nodo1);
//			}
//				
//		}
//	}
//	
//	
//	public static void updateNodo (String nodo) throws PersistentException{
//		
//		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
//	    model.reload();
//	    Ctrl_System.getInstance().initAlberoClienti();
//		
//	}
//	
//	public static void selezionaNodo(String nodo){
//			
//		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
//		  albero.setSelectionPath(new TreePath(figlio)); 
//
//	 }
//	
//	//NUOVA FUNZIONE - RISOLVE I PRECEDENTI PROBLEMI
//	public static void deselezionaNodo(String nodo){
//		
//		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
//		  albero.clearSelection();
//
//	 }
//			
//  
//	public static void disabilitaAlbero() {
//			albero.setEnabled(false);
//	}
//
//	public static void abilitaAlbero() {
//			albero.setEnabled(true);
//	}
//					  	
//				  	  
//				
//}
//
