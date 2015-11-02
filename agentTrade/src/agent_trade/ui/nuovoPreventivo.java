package agent_trade.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class nuovoPreventivo extends JPanel {

	/**
	 * Create the panel.
	 */
	public nuovoPreventivo() {
		setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(124, 6, -91, 20);
		add(textPane);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(135, 5, 97, 23);
		add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(237, 5, 89, 23);
		add(btnNewButton);

	}

}
