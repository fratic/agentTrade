package agent_trade.ui.content.agenti;

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
import agent_trade.controller.Ctrl_gestisciAgente;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class AlberoAgenti extends JPanel {

	/*attributi di classe*/
		
	public static DefaultTreeModel model;
	public static JTree albero;
		

	/*attributi privati*/
		
	private static DefaultMutableTreeNode radice;
	private static AlberoAgenti instance;
	
	private static boolean abilitalistener = true;


	/*costruttori*/
		
	public AlberoAgenti() {
			
			radice = new DefaultMutableTreeNode(Costanti.ROOT_AGENTI);
			model = new DefaultTreeModel(radice);
			setLayout(new GridLayout(1,1));

			albero = new JTree(model);
			albero.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			JScrollPane scroller = new JScrollPane(albero);			
			add(scroller);
			
			ImageIcon imageIcon = new ImageIcon(AlberoAgenti.class.getResource(Costanti.ALBERO_AGENTI_ICON));
	        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
	        renderer.setLeafIcon(imageIcon);

	        albero.setCellRenderer(renderer);
				
	        albero.addTreeSelectionListener((new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent e) {
					TreeNode selezione = (TreeNode) e.getPath().getLastPathComponent();
					
					
					try {
						if(selezione.isLeaf() && abilitalistener == true)
	        			{
							Ctrl_gestisciAgente.getInstance().recuperaAgente(ottieniId(selezione));
        				}
						else if(!selezione.isLeaf()){
							PrimaryMandanteView.getInstance().resetPannelloCentraleAgente();
							PrimaryMandanteView.getInstance().setSfondoAgente();					
						}
					} 
					catch (PersistentException e1) {
						e1.printStackTrace();
					}
					
				}}));
	}		
	
	
	/*metodi di classe*/
	
	public static AlberoAgenti getInstance(){
		
		return ((instance == null) ? instance = new AlberoAgenti() : instance);	
	}
	
	
	/*metodi privati*/
	/*metodi pubblici*/
	
	
	
	public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);
	
		  model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		  
		  albero.expandRow(0);
		  
	}
			  
	
	public static void refresh () throws PersistentException{
		
		abilitalistener = false;

		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	    Ctrl_System.getInstance().initAlberoAgenti();
		    model.reload();
			abilitalistener = true;
	}
	
	public static void selectNode (String nodo) throws PersistentException{
		
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
	
	public static void deselezionaNodo(){
		
		  albero.clearSelection();

	 }
	
	public static void disabilitaAlbero() {
			albero.setEnabled(false);
	}

	public static void abilitaAlbero() {
			albero.setEnabled(true);
	}
					  	
}
