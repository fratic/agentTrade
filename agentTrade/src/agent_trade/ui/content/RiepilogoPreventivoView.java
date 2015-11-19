package agent_trade.ui.content;

import javax.swing.JPanel;
import java.awt.BorderLayout;

public class RiepilogoPreventivoView extends JPanel {

	private JPanel riepilogoIntestazione; 
	private JPanel riepilogoItem;
	
	public RiepilogoPreventivoView() {
		setLayout(null);
		
		riepilogoIntestazione =new RiepilogoIntestazionePreventivoView();
		riepilogoIntestazione.setBounds(0, 0, 745, 140);
		add(riepilogoIntestazione);

		riepilogoItem =new RiepilogoItemPreventivoView();
		riepilogoItem.setBounds(0, 141, 745, 585);
		add(riepilogoItem);


	}

}
