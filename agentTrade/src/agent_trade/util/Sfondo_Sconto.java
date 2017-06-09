package agent_trade.util;

import java.awt.Toolkit;

public class Sfondo_Sconto extends Sfondo {
	
	public Sfondo_Sconto(){
		img = Toolkit.getDefaultToolkit().createImage(Sfondo_Azienda.class.getResource(Costanti.IMG_SFONDO_SCONTO));
	    loadImage(img);  
	}

}
