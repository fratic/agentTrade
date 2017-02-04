package agent_trade.util;

import java.awt.Toolkit;

public class Sfondo_Preventivo extends Sfondo {
		  
		  public Sfondo_Preventivo() {
		    img = Toolkit.getDefaultToolkit().createImage(Sfondo_Preventivo.class.getResource(Costanti.IMG_SFONDO_PREVENTIVO));
		    loadImage(img);
		  }
	}
