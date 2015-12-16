package agent_trade.ui.content;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class sfondo_cliente extends sfondo{
	  
	  private Image img;


	  public sfondo_cliente() {
	    img = Toolkit.getDefaultToolkit().createImage(sfondo_cliente.class.getResource("/agent_trade/ui/img/sfondoAgentTradeCliente.png"));
	    loadImage(img);  
	  }

	  private void loadImage(Image img) {
	    try {
	      MediaTracker track = new MediaTracker(this);
	      track.addImage(img, 0);
	      track.waitForID(0);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }

	  protected void paintComponent(Graphics g) {
	    setOpaque(false);
	    g.drawImage(img, 0, 0, null);
	    super.paintComponent(g);
	  }

	  public static void main(String... argv) {
	    JFrame frame = new JFrame("Demo Background Image");
	    sfondo_cliente back = new sfondo_cliente();
	    frame.getContentPane().add(back);
	    frame.setSize(400, 287);
	    frame.setVisible(false);
	  }

}
