package agent_trade.ui.content.listini;

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
import agent_trade.controller.Ctrl_gestisciAzienda;
import agent_trade.controller.Ctrl_gestisciListino;
import agent_trade.controller.Ctrl_gestisciSconto;
import agent_trade.ui.primaryView.PrimaryMandanteView;
import agent_trade.util.Costanti;

public class AlberoListini extends JPanel{

	/*attributi di classe*/
	
	public static DefaultTreeModel model;
	public static JTree albero;
		

	/*attributi privati*/
		
	private static DefaultMutableTreeNode radice;
	private static AlberoListini instance;
	
//	Variabile che serve per non abilitare il listener dell'albero quando si cancella  
	private static boolean abilitalistener = true;


	/*costruttori*/
		
	public AlberoListini() {
			
			radice = new DefaultMutableTreeNode(Costanti.ROOT_LISTINI_AZIENDE);
			model = new DefaultTreeModel(radice);
			setLayout(new GridLayout(1,1));

			albero = new JTree(model);
			albero.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			JScrollPane scroller = new JScrollPane(albero);
			add(scroller);
			
			ImageIcon imageIcon = new ImageIcon(AlberoListini.class.getResource(Costanti.ALBERO_LISTINO_ICON));
	        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
	        renderer.setLeafIcon(imageIcon);

	        albero.setCellRenderer(renderer);
				
			//quando seleziono l'azienda, mostra nel panel centrale il dettaglio
	        albero.addTreeSelectionListener((new TreeSelectionListener() {

	        	public void valueChanged(TreeSelectionEvent e) {
					TreeNode selezione = (TreeNode) e.getPath().getLastPathComponent();
					
					try {
						if(selezione.isLeaf() && abilitalistener == true)
	        			{
							Ctrl_gestisciListino.getInstance().recuperaListino(ottieniId(selezione));
        				}
						else if(!selezione.isLeaf()){
							PrimaryMandanteView.getInstance().resetPannelloCentraleListino();
							PrimaryMandanteView.getInstance().setSfondoListino();
						}
					} 
					catch (PersistentException e1) {
						e1.printStackTrace();
					}
					
				}}));
	        
	}		
	
	
			
	/*metodi di classe*/
	
	public static AlberoListini getInstance(){
		
		return ((instance == null) ? instance = new AlberoListini() : instance);	
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
//	    Ctrl_System.getInstance().initAlberoAziende();
		
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
	
	public static void refresh () throws PersistentException{
		
		//albero.clearSelection();
		abilitalistener = false;

		((DefaultMutableTreeNode) model.getRoot()).removeAllChildren();
	   // model.reload();
	    Ctrl_System.getInstance().initAlberoListini();
		    model.reload();
			abilitalistener = true;
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
