package agent_trade.ui.content.prodotti;

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
import agent_trade.controller.Ctrl_elaboraPreventivo;
import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.util.Costanti;

public class AlberoProdotti extends JPanel {

	/*attributi di classe*/
	
	public static DefaultTreeModel model;
	public static JTree albero;
	private static AlberoProdotti instance;
	
	private static boolean abilitalistener = true;


	/*attributi privati*/
	
	private static DefaultMutableTreeNode radice;

	/*costruttori*/
	
	
	public AlberoProdotti() {
		
		radice = new DefaultMutableTreeNode(Costanti.ROOT_PRODOTTI);
		model = new DefaultTreeModel(radice);
		setLayout(new GridLayout(1,1));
		albero = new JTree(model);
		albero.setBorder(new EmptyBorder(10, 10, 10, 10));
	
		JScrollPane scroller = new JScrollPane(albero);
		add(scroller);
				
		ImageIcon imageIcon = new ImageIcon(AlberoProdotti.class.getResource(Costanti.ALBERO_PRODOTTI_ICON));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
        renderer.setLeafIcon(imageIcon);

        albero.setCellRenderer(renderer);
        
		albero.addTreeSelectionListener((new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				TreeNode selezione = (TreeNode) e.getPath().getLastPathComponent();
				try {
					if(selezione.isLeaf())
						Ctrl_gestisciListino.getInstance().inserisciProdottoInTabella(ottieniAzienda(selezione));
				} 
				catch (PersistentException e1) {
					e1.printStackTrace();
				}
				
			}}));
	}
	
	public String ottieniAzienda(TreeNode selezione){
		
		String azienda=null;
		
		if (selezione.isLeaf()){
			azienda=selezione.toString();
		}
		return azienda;
	}
	
	/*metodi di classe*/
	
		public static AlberoProdotti getInstance(){
		
			return ((instance == null) ? instance = new AlberoProdotti() : instance);	
		}
	
		public static DefaultMutableTreeNode getRadice() {
			return radice;
		}

		public static void setRadice(DefaultMutableTreeNode radice) {
			AlberoProdotti.radice = radice;
		}

	/*metodi privati*/
	/*metodi pubblici*/
		
	  public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);

		  model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
	     
		  albero.expandRow(0);

	  }
	  
	  
	  public static void cancellaNodo() {
			    TreePath currentSelection = albero.getSelectionPath();
			    if (currentSelection != null) {
			      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
			          .getLastPathComponent());
			      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
			      if (parent != null) {
			        model.removeNodeFromParent(currentNode);
			        System.out.println("cancellato nodo: "+currentNode.toString());
			        return;
			      }
			    }
			    
	  }
	  
	  
	  public static void selezionaNodo(String nodo){
		
			DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
			albero.setSelectionPath(new TreePath(figlio)); 
		  
			Enumeration<MutableTreeNode> sottonodi = radice.children();
			while (sottonodi.hasMoreElements())
			{
				DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
				
				if(nodo1.toString().equals(nodo)) {
					 TreeNode[] nodes = model.getPathToRoot(nodo1);  
			         albero.setExpandsSelectedPaths(true);                
			         albero.setSelectionPath(new TreePath(nodes));
				}
			}
	  }
	  
	  
	  public static void selezionaRadice(){
		
		  albero.setSelectionPath(new TreePath(model.getRoot())); 

	  }
	  
	  public static boolean controllaEsistenza(String nodo){
		  
		   Enumeration sottonodi = ((DefaultMutableTreeNode) model.getRoot()).children();
		   
			 
				while (sottonodi.hasMoreElements())
				{
				   DefaultMutableTreeNode singoloNodo =(DefaultMutableTreeNode)sottonodi.nextElement();
				   if ((singoloNodo.toString()).equals(nodo)){
					   return true;
				   }
				}
				return false;
	  }
	  
	  
	  public static void disabilitaAlbero(){
		  albero.disable();
	  }

	  public static void abilitaAlbero(){
		  albero.enable();
	  }
	

	  public static void posInit() {
		  albero.setSelectionPath(new TreePath(model.getRoot())); 	
	  }
	  
	  public static void clear() throws PersistentException {
		
		  ((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
		  model.reload();
		  Ctrl_System.getInstance().initAlberoPreventivi();
	}	
	  
	public static void refresh () throws PersistentException{
		
		//albero.clearSelection();
		abilitalistener = false;

		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	   // model.reload();
	    Ctrl_System.getInstance().initAlberoProdotti();
		    model.reload();
			abilitalistener = true;
	}
}
