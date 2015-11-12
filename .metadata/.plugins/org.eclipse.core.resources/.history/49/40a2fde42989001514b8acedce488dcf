import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class DynamicTreeDemo extends JPanel implements ActionListener {
  private int newNodeSuffix = 1;
  private static String ADD_COMMAND = "add";
  private static String REMOVE_COMMAND = "remove";
  private static String CLEAR_COMMAND = "clear";

  private DynamicTree treePanel;

  public DynamicTreeDemo() {
    super(new BorderLayout());

    // Create the components.
    treePanel = new DynamicTree();
    populateTree(treePanel);

    JButton addButton = new JButton("Add");
    addButton.setActionCommand(ADD_COMMAND);
    addButton.addActionListener(this);

    JButton removeButton = new JButton("Remove");
    removeButton.setActionCommand(REMOVE_COMMAND);
    removeButton.addActionListener(this);

    JButton clearButton = new JButton("Clear");
    clearButton.setActionCommand(CLEAR_COMMAND);
    clearButton.addActionListener(this);

    // Lay everything out.
    treePanel.setPreferredSize(new Dimension(300, 150));
    add(treePanel, BorderLayout.CENTER);

    JPanel panel = new JPanel(new GridLayout(0, 3));
    panel.add(addButton);
    panel.add(removeButton);
    panel.add(clearButton);
    add(panel, BorderLayout.SOUTH);
  }

  public void populateTree(DynamicTree treePanel) {
    String p1Name = new String("Parent 1");
    String p2Name = new String("Parent 2");
    String c1Name = new String("Child 1");
    String c2Name = new String("Child 2");

    DefaultMutableTreeNode p1, p2;

    p1 = treePanel.addObject(null, p1Name);
    p2 = treePanel.addObject(null, p2Name);

    treePanel.addObject(p1, c1Name);
    treePanel.addObject(p1, c2Name);

    treePanel.addObject(p2, c1Name);
    treePanel.addObject(p2, c2Name);
  }

  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    if (ADD_COMMAND.equals(command)) {
      // Add button clicked
      treePanel.addObject("New Node " + newNodeSuffix++);
    } else if (REMOVE_COMMAND.equals(command)) {
      // Remove button clicked
      treePanel.removeCurrentNode();
    } else if (CLEAR_COMMAND.equals(command)) {
      // Clear button clicked.
      treePanel.clear();
    }
  }

  /**
   * Create the GUI and show it. For thread safety, this method should be
   * invoked from the event-dispatching thread.
   */
  private static void createAndShowGUI() {
    // Create and set up the window.
    JFrame frame = new JFrame("DynamicTreeDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create and set up the content pane.
    DynamicTreeDemo newContentPane = new DynamicTreeDemo();
    newContentPane.setOpaque(true); // content panes must be opaque
    frame.setContentPane(newContentPane);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}

/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: -
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of Sun Microsystems nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

// package components;
/*
 * This code is based on an example provided by Richard Stanford, a tutorial
 * reader.
 */
class DynamicTree extends JPanel {
  protected DefaultMutableTreeNode rootNode;
  protected DefaultTreeModel treeModel;
  protected JTree tree;
  private Toolkit toolkit = Toolkit.getDefaultToolkit();

  public DynamicTree() {
    super(new GridLayout(1, 0));

    rootNode = new DefaultMutableTreeNode("Root Node");
    treeModel = new DefaultTreeModel(rootNode);

    tree = new JTree(treeModel);
    tree.setEditable(true);
    tree.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.setShowsRootHandles(true);

    JScrollPane scrollPane = new JScrollPane(tree);
    add(scrollPane);
  }

  /** Remove all nodes except the root node. */
  public void clear() {
    rootNode.removeAllChildren();
    treeModel.reload();
  }

  /** Remove the currently selected node. */
  public void removeCurrentNode() {
    TreePath currentSelection = tree.getSelectionPath();
    if (currentSelection != null) {
      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
          .getLastPathComponent());
      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
      if (parent != null) {
        treeModel.removeNodeFromParent(currentNode);
        return;
      }
    }

    // Either there was no selection, or the root was selected.
    toolkit.beep();
  }

  /** Add child to the currently selected node. */
  public DefaultMutableTreeNode addObject(Object child) {
    DefaultMutableTreeNode parentNode = null;
    TreePath parentPath = tree.getSelectionPath();

    if (parentPath == null) {
      parentNode = rootNode;
    } else {
      parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
    }

    return addObject(parentNode, child, true);
  }

  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
      Object child) {
    return addObject(parent, child, false);
  }

  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
      Object child, boolean shouldBeVisible) {
    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

    if (parent == null) {
      parent = rootNode;
    }

    // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
    treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

    // Make sure the user can see the lovely new node.
    if (shouldBeVisible) {
      tree.scrollPathToVisible(new TreePath(childNode.getPath()));
    }
    return childNode;
  }

  class MyTreeModelListener implements TreeModelListener {
    public void treeNodesChanged(TreeModelEvent e) {
      DefaultMutableTreeNode node;
      node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

      /*
       * If the event lists children, then the changed node is the child of the
       * node we've already gotten. Otherwise, the changed node and the
       * specified node are the same.
       */

      int index = e.getChildIndices()[0];
      node = (DefaultMutableTreeNode) (node.getChildAt(index));

      System.out.println("The user has finished editing the node.");
      System.out.println("New value: " + node.getUserObject());
    }

    public void treeNodesInserted(TreeModelEvent e) {
    }

    public void treeNodesRemoved(TreeModelEvent e) {
    }

    public void treeStructureChanged(TreeModelEvent e) {
    }
  }
}