package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class AlberoPreventivi extends JPanel {

	/**
	 * Create the panel.
	 */
	
	/*private JTree treePrev;
	private DefaultTreeModel treeModel;
*/
	
	public DefaultMutableTreeNode radice;
	public DefaultMutableTreeNode figlio;
	public static DefaultTreeModel model;
	public JTree albero;
	
	public AlberoPreventivi() {
		/*setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 261, 585);
		add(panel);
		panel.setLayout(null);
		
		treePrev = new JTree();
		treePrev.setBounds(10, 11, 241, 563);
		panel.add(treePrev);
*/
		
		radice = new DefaultMutableTreeNode("Novembre 2015");
		//figlio = new DefaultMutableTreeNode("figlio");
		//radice.add(figlio);
		
		
		model = new DefaultTreeModel(radice);
		setLayout(null);

		albero = new JTree(model);
		JScrollPane scroller = new JScrollPane(albero);
		scroller.setBounds(10, 11, 241, 563);
		
		//inserisciNodo("Fratic");

		add(scroller);

	}
	
	  public static void inserisciNodo(String nodo) {
		    
		  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);

	
		   model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
		   // model.insertNodeInto(nodo, (MutableTreeNode) model.getRoot(), 1);
		   // model.setRoot(nodo);
		   // model.insertNodeInto(new DefaultMutableTreeNode("asdasdasd"),nodo, radice.getChildCount());

		  
		  }
}
