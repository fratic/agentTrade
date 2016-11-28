package agent_trade.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPanel;

public class Sfondo extends JPanel {

  protected Image img;

  public Sfondo() {
  }

  protected void loadImage(Image img) {
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
    g.drawImage(img, getWidth()/2-150, getHeight()/2-150, null);
    super.paintComponent(g);
  }
}
