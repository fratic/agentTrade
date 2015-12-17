package agent_trade.ui.content;

import java.awt.Toolkit;

public class Sfondo_Preventivo extends Sfondo {
		  
		  public Sfondo_Preventivo() {
		    img = Toolkit.getDefaultToolkit().createImage(Sfondo_Preventivo.class.getResource("/agent_trade/ui/img/sfondoAgentTrade2.png"));
		    loadImage(img);
		  }
	}
