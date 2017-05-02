package agent_trade.util;

import java.awt.Toolkit;

public class Sfondo_Listino extends Sfondo{

	public Sfondo_Listino(){
		 img = Toolkit.getDefaultToolkit().createImage(Sfondo_Preventivo.class.getResource(Costanti.IMG_SFONDO_LISTINO));
		    loadImage(img);
	}
	
}
