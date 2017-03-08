package agent_trade.util;

import java.awt.Toolkit;

public class Sfondo_Agente extends Sfondo{
	  
	  public Sfondo_Agente() {
	    img = Toolkit.getDefaultToolkit().createImage(Sfondo_Agente.class.getResource(Costanti.IMG_SFONDO_AGENTE));
	    loadImage(img);  
	  }
}
