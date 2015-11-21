package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import agent_trade.controller.Ctrl_elaboraPreventivo;

public class AlberoPreventivi extends JPanel {

	/*attributi di classe*/
	
	public static DefaultTreeModel model;
	public static JTree albero;
	

	/*attributi privati*/
	
	private DefaultMutableTreeNode radice;
	private DefaultMutableTreeNode figlio;


	/*costruttori*/
	
	public AlberoPreventivi() {
		
		radice = new DefaultMutableTreeNode("* Novembre 2015");
		model = new DefaultTreeModel(radice);
		setLayout(null);

		albero = new JTree(model);
		JScrollPane scroller = new JScrollPane(albero);
		scroller.setBounds(10, 11, 241, 563);
		
		//inserisciNodo("Fratic");

		add(scroller);
				
		albero.addTreeSelectionListener((new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				TreePath selection = e.getPath();
				Ctrl_elaboraPreventivo.getInstance().riepilogoPreventivo(selection.getLastPathComponent());
				
			}}));
	
	}
	
	
	/*metodi di classe*/
	
	  public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);

		   model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		   // model.insertNodeInto(nodo, (MutableTreeNode) model.getRoot(), 1);
	
		   //funziona pr inserimento radice e figli
		/*   model.setRoot(new DefaultMutableTreeNode("*io sono radice"));
		   model.insertNodeInto(new DefaultMutableTreeNode("awawa"), (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
			   model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		 */
		   
		   // model.insertNodeInto(new DefaultMutableTreeNode("asdasdasd"),nodo, radice.getChildCount());
		  
		  }
	  
	  public static void disabilitaAlbero(){
		  albero.disable();
	  }

	  public static void abilitaAlbero(){
		  albero.enable();
	  }
	
	/*metodi privati*/
	/*metodi pubblici*/
		  
	  public void ricaricaAlbero(){
		  model.reload();
	  }
	  	  
	
}
