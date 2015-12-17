package agent_trade.ui.content;

import java.awt.Toolkit;

public class Sfondo_Cliente extends Sfondo{
	  
	  public Sfondo_Cliente() {
	    img = Toolkit.getDefaultToolkit().createImage(Sfondo_Cliente.class.getResource("/agent_trade/ui/img/sfondoAgentTradeCliente.png"));
	    loadImage(img);  
	  }
}
