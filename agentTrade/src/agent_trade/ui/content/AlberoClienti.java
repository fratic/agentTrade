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
import agent_trade.controller.Ctrl_gestisciCliente;

public class AlberoClienti extends JPanel {

	/*attributi di classe*/
		
	public static DefaultTreeModel model;
	public static JTree albero;
		

	/*attributi privati*/
		
	private DefaultMutableTreeNode radice;
	private DefaultMutableTreeNode figlio;


	/*costruttori*/
		
	public AlberoClienti() {
			
			radice = new DefaultMutableTreeNode("Clienti");
			model = new DefaultTreeModel(radice);
			setLayout(null);

			albero = new JTree(model);
			JScrollPane scroller = new JScrollPane(albero);
			scroller.setBounds(10, 11, 241, 563);
			
			//inserisciNodo("A");

			add(scroller);
					
			albero.addTreeSelectionListener((new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent e) {
					TreePath selection = e.getPath();
					//Ctrl_gestisciCliente.getInstance().mostraCliente(selection.getLastPathComponent());
					
				}}));
			
			}		
			
			/*metodi di classe*/
			
			  public static void inserisciNodo(String nodo) {
				    
				  DefaultMutableTreeNode figlio = new DefaultMutableTreeNode(nodo);

				   model.insertNodeInto(figlio, (MutableTreeNode)model.getRoot(), ((MutableTreeNode) model.getRoot()).getChildCount());
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