package agent_trade.ui.content.clienti;

import java.awt.GridLayout;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.orm.PersistentException;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_gestisciClienteFactory;
import agent_trade.ui.content.preventivi.AlberoPreventivi;

public class AlberoClienti extends JPanel {

	/*attributi di classe*/
		
	public static DefaultTreeModel model;
	public static JTree albero;
		

	/*attributi privati*/
		
	private static DefaultMutableTreeNode radice;
	private static AlberoClienti instance;
	
//	Variabile che serve per non abilitare il listener dell'albero quando si cancella un cliente 
	private static boolean abilitalistener = true;


	/*costruttori*/
		
	public AlberoClienti() {
			
			radice = new DefaultMutableTreeNode("Clienti");
			model = new DefaultTreeModel(radice);
			setLayout(new GridLayout(1,1));

			albero = new JTree(model);
			albero.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			JScrollPane scroller = new JScrollPane(albero);
			add(scroller);
			
			ImageIcon imageIcon = new ImageIcon(AlberoPreventivi.class.getResource("/agent_trade/ui/img/ico-cliente1.png"));
	        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
	        renderer.setLeafIcon(imageIcon);

	        albero.setCellRenderer(renderer);
				
			//quando seleziono il cliente, mostra nel panel centrale il dettaglio
	        albero.addTreeSelectionListener((new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent e) {
					TreePath selection = e.getPath();
					try {if(abilitalistener == true){
						//System.out.println("MI ATTIVO");
						Ctrl_gestisciClienteFactory.getInstance().mostraCliente(selection.getLastPathComponent());
					}
					} catch (PersistentException e1)
					{
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
	
	public static void inserisciFiglio(String padre, String nodo) {	    
		
		DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(padre);

		  model.insertNodeInto(figlio, root, ((MutableTreeNode) model.getRoot()).getChildCount());
		  
		  albero.expandRow(0);
	}
			  
	public static void rimuoviNodo(String nodo) {
		
		Enumeration<MutableTreeNode> sottonodi = radice.children();
		while (sottonodi.hasMoreElements())
		{
			//ottengo i nodi singolarmente
			DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
			//System.out.print(nodo1);
			if(nodo1.toString().equals(nodo)) {
				abilitalistener = false;
				model.removeNodeFromParent(nodo1);
			}
			abilitalistener = true;
		}
	}
	
	public static void updateNodo (String nodo) throws PersistentException{
		
		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	    model.reload();
	    Ctrl_System.getInstance().initAlberoClienti();
		
	}
	
	public static void selectNode (String nodo) throws PersistentException{
		
		Enumeration<MutableTreeNode> sottonodi = radice.children();
		while (sottonodi.hasMoreElements())
		{
			DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
			
			if(nodo1.toString().equals(nodo)) {
				 TreeNode[] nodes = model.getPathToRoot(nodo1);  
		         //TreePath path = new TreePath(nodes);    
		         albero.setExpandsSelectedPaths(true);                
		         albero.setSelectionPath(new TreePath(nodes));
			}
		}
	}
	
	public static void deselezionaNodo(String nodo){
			
		//a che serve il nodo passato come parametro?
		  albero.clearSelection();

	 }
	
	public static void disabilitaAlbero() {
			albero.setEnabled(false);
	}

	public static void abilitaAlbero() {
			albero.setEnabled(true);
	}
		
	public static void refresh () throws PersistentException{
		
		//albero.clearSelection();
		abilitalistener = false;

		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	   // model.reload();
	    Ctrl_System.getInstance().initAlberoClienti();
		    model.reload();
			abilitalistener = true;
	}
	
}
