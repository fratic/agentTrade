package agent_trade.util;

import java.awt.Toolkit;

public class Sfondo_Azienda extends Sfondo{
	
	public Sfondo_Azienda() {
	    img = Toolkit.getDefaultToolkit().createImage(Sfondo_Azienda.class.getResource(Costanti.IMG_SFONDO_AZIENDA));
	    loadImage(img);  
	  }

}
