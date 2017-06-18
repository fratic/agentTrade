package agent_trade.ui.content.sconti;

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
import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class AlberoSconti extends JPanel {

	/*attributi di classe*/
	
	public static DefaultTreeModel model;
	public static JTree albero;
	private static AlberoSconti instance;


	/*attributi privati*/
	
	private static DefaultMutableTreeNode radice;
	private static boolean abilitalistener = true;

	/*costruttori*/
	
	
	public AlberoSconti() {
		
		radice = new DefaultMutableTreeNode(Costanti.ROOT_SCONTI);
		model = new DefaultTreeModel(radice);
		setLayout(null);
		albero = new JTree(model);
		albero.setBorder(new EmptyBorder(10, 10, 10, 10));
	
		JScrollPane scroller = new JScrollPane(albero);
		scroller.setBounds(10, 12, 250, 595);

		add(scroller);
				
		ImageIcon imageIcon = new ImageIcon(AlberoSconti.class.getResource(Costanti.ALBERO_SCONTO_ICON));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
        renderer.setLeafIcon(imageIcon);

		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("Sconto Cliente");
		DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("Sconto Percentuale");
		DefaultMutableTreeNode root3 = new DefaultMutableTreeNode("Sconto Quantità");

		model.insertNodeInto(root1, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		model.insertNodeInto(root2, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		model.insertNodeInto(root3, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());

		
        albero.setCellRenderer(renderer);
        
		albero.addTreeSelectionListener((new TreeSelectionListener() {

		
		public void valueChanged(TreeSelectionEvent e) {
			TreeNode selezione = (TreeNode) e.getPath().getLastPathComponent();
			
			try {
				if(selezione.isLeaf() && abilitalistener == true)
    			{
					Ctrl_gestisciSconto.getInstance().recuperaSconto(ottieniId(selezione));
				}
				else if(!selezione.isLeaf()){
					PrimaryMandanteView.getInstance().resetPannelloCentraleSconto();
					PrimaryMandanteView.getInstance().setSfondoSconto();
				}
			} 
			catch (PersistentException e1) {
				e1.printStackTrace();
			}
			
		}}));
		
	}

		    
		    
	  
	  
	  
	public int ottieniId(TreeNode selezione){
		
		int id;
		
		if (selezione.isLeaf()){
			String idString=selezione.toString();
			String idVett[];
			idVett=idString.split("-");
			String idS=idVett[0].replaceAll("-","");
			idS=idS.replaceAll(" ","");
			id=Integer.parseInt(idS);
		}
		else {
			id=0;
		}
		return id;
	}


	
	/*metodi di classe*/
	
		public static AlberoSconti getInstance(){
		
			return ((instance == null) ? instance = new AlberoSconti() : instance);	
		}
	
		public static DefaultMutableTreeNode getRadice() {
			return radice;
		}

		public static void setRadice(DefaultMutableTreeNode radice) {
			AlberoSconti.radice = radice;
		}

	/*metodi privati*/
	/*metodi pubblici*/
		
	  public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);

		  model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
	     	  
	  }
	  
	  public static void inserisciNodo(String nodo, String radice) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
		  
//		  DefaultMutableTreeNode root = new DefaultMutableTreeNode(radice);

		  
//		  DefaultMutableTreeNode root = new DefaultMutableTreeNode(radice);

//		  model.insertNodeInto(root, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());

		   Enumeration sottonodi = ((DefaultMutableTreeNode) model.getRoot()).children();
		   
			 
				while (sottonodi.hasMoreElements())
				{
				   DefaultMutableTreeNode singoloNodo =(DefaultMutableTreeNode)sottonodi.nextElement();
				   
				   if ((singoloNodo.toString()).equals(radice)){

						 model.insertNodeInto(figlio, singoloNodo, singoloNodo.getChildCount());

				   }
				}
				model.reload();

		  
		    
		  albero.expandRow(albero.getRowCount());
		  
	}
	  
	  
	  public static void cancellaNodo() {
			    TreePath currentSelection = albero.getSelectionPath();
			    if (currentSelection != null) {
			      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
			          .getLastPathComponent());
			      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
			      if (parent != null) {
			        model.removeNodeFromParent(currentNode);
			        return;
			      }
			    }
			    
	  }
	  
	  
//	  public static void selezionaNodo(String nodo){
//		
//			DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
//			albero.setSelectionPath(new TreePath(figlio)); 
//			System.out.println("------------------nodo: "+nodo);
//
//			Enumeration<MutableTreeNode> sottonodi = radice.children();
//			while (sottonodi.hasMoreElements())
//			{
//				System.out.println("--------sottonodi"+sottonodi);
//				DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
//				if(nodo1.toString().equals(nodo)) {
//					 TreeNode[] nodes = model.getPathToRoot(nodo1);  
//			         albero.setExpandsSelectedPaths(true);                
//			         albero.setSelectionPath(new TreePath(nodes));
//				}
//			}
//	  }
	  
		public static void selectNode (String nodo) throws PersistentException{
			
			Enumeration<MutableTreeNode> sottonodi = radice.children();
			while (sottonodi.hasMoreElements())
			{

				DefaultMutableTreeNode nodo1 = (DefaultMutableTreeNode)sottonodi.nextElement();
				
				Enumeration<MutableTreeNode> sottonodi1 = nodo1.children();
				while (sottonodi1.hasMoreElements())
				{
					DefaultMutableTreeNode nodo2 = (DefaultMutableTreeNode)sottonodi1.nextElement();
	
					if(nodo2.toString().equals(nodo)) {
 
						TreeNode[] nodes = model.getPathToRoot(nodo2);  
				         //TreePath path = new TreePath(nodes);    
				         albero.setExpandsSelectedPaths(true);                
				         albero.setSelectionPath(new TreePath(nodes));
					}
			}}
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
	  
	  
	public static void refresh () throws PersistentException{
		
		//albero.clearSelection();
		abilitalistener = false;

		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	   // model.reload();
		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("Sconto Cliente");
		DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("Sconto Percentuale");
		DefaultMutableTreeNode root3 = new DefaultMutableTreeNode("Sconto Quantità");

		model.insertNodeInto(root1, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		model.insertNodeInto(root2, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		model.insertNodeInto(root3, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());

        
	    Ctrl_System.getInstance().initAlberoSconti();
		    model.reload();
			abilitalistener = true;
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
}
