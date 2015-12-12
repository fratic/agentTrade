package agent_trade;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoBackgroundSwing extends JPanel {

  private Image img;

  public DemoBackgroundSwing() {
    img = Toolkit.getDefaultToolkit().createImage(DemoBackgroundSwing.class.getResource("/agent_trade/ui/img/splash.png"));
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
    g.drawImage(img, 50, 50, null);
    super.paintComponent(g);
  }

  public static void main(String... argv) {
    JFrame frame = new JFrame("Demo Background Image");
    DemoBackgroundSwing back = new DemoBackgroundSwing();
    frame.getContentPane().add(back);
    frame.setSize(400, 287);
    frame.setVisible(true);
  }
}