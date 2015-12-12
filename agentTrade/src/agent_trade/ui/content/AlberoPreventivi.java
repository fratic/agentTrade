package agent_trade.ui.content;

import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import agent_trade.controller.Ctrl_System;
import agent_trade.controller.Ctrl_elaboraPreventivo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AlberoPreventivi extends JPanel {

	/*attributi di classe*/
	
	public static DefaultTreeModel model;
	public static JTree albero;
	private static AlberoPreventivi instance;


	/*attributi privati*/
	
	private DefaultMutableTreeNode radice;
//	private DefaultMutableTreeNode figlio;


	/*costruttori*/
	
	public AlberoPreventivi() {
		
		radice = new DefaultMutableTreeNode("Preventivi");
		model = new DefaultTreeModel(radice);
		setLayout(null);

		albero = new JTree(model);
		albero.setBorder(new EmptyBorder(10, 10, 10, 10));
	
//		for (int i = 0; i < albero.getRowCount(); i++) {
//	         albero.expandRow(i);
//	}		
		JScrollPane scroller = new JScrollPane(albero);
		scroller.setBounds(10, 12, 250, 595);
		
		//inserisciNodo("Fratic");

		add(scroller);
				
		ImageIcon imageIcon = new ImageIcon(AlberoPreventivi.class.getResource("/agent_trade/ui/img/prev.png"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
        renderer.setLeafIcon(imageIcon);

        albero.setCellRenderer(renderer);

		
		
		albero.addTreeSelectionListener((new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				TreePath selection = e.getPath();
				System.out.println("sono in action listner di jtree");
				Ctrl_elaboraPreventivo.getInstance().riepilogoPreventivo(selection.getLastPathComponent());
				
			}}));
	
	}
	
	
	/*metodi di classe*/
	
		public static AlberoPreventivi getInstance(){
		
			return ((instance == null) ? instance = new AlberoPreventivi() : instance);	
		}
	
	
	  public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);

		  model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
	     
		  albero.expandRow(0);

//		  albero.setSelectionPath(new TreePath(figlio)); 
		   
		   
//		   DefaultTreeModel model = (DefaultTreeModel)albero.getModel();
//		   DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
//		   root.add(new DefaultMutableTreeNode(nodo));
//		   model.reload();
//		   albero.updateUI();
		   
		   
		   // model.insertNodeInto(nodo, (MutableTreeNode) model.getRoot(), 1);
	
		   //funziona pr inserimento radice e figli
		/*   model.setRoot(new DefaultMutableTreeNode("*io sono radice"));
		   model.insertNodeInto(new DefaultMutableTreeNode("awawa"), (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
			   model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		 */
		   
		   // model.insertNodeInto(new DefaultMutableTreeNode("asdasdasd"),nodo, radice.getChildCount());
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
			    //selezionaRadice();
	}
	  
	  
	  public static void selezionaNodo(String nodo){
		
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
		  albero.setSelectionPath(new TreePath(figlio)); 

	  }
	  
	  
	  public static void selezionaRadice(){
		
		  albero.setSelectionPath(new TreePath(model.getRoot())); 

	  }
	  public static boolean controllaEsistenza(String nodo){
		  
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
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
	  
	  public static void clear() {
		  ((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
		    model.reload();
		    Ctrl_System.getInstance().initAlberoPreventivi();
		  }
	
	
	/*metodi privati*/
	/*metodi pubblici*/
		  
	 
	  	  
	
}
