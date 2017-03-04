package util;

import java.awt.Toolkit;

public class Sfondo_Cliente extends Sfondo{
	  
	  public Sfondo_Cliente() {
	    img = Toolkit.getDefaultToolkit().createImage(Sfondo_Cliente.class.getResource(Costanti.IMG_SFONDO_CLIENTE));
	    loadImage(img);  
	  }
}
