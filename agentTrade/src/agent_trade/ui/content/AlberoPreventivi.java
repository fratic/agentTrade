package agent_trade.ui.content;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class AlberoPreventivi extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTree treePrev;
	private DefaultTreeModel treeModel;

	
	public AlberoPreventivi() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 261, 585);
		add(panel);
		panel.setLayout(null);
		
		treePrev = new JTree();
		treePrev.setBounds(10, 11, 241, 563);
		panel.add(treePrev);

	}
	
	  public void populateTree(JTree treePanel) {
		    String p1Name = new String("Parent 1");
		    String p2Name = new String("Parent 2");
		    String c1Name = new String("Child 1");
		    String c2Name = new String("Child 2");

		    DefaultMutableTreeNode p1, p2;

		    
		    
		  
		  
		  }
}