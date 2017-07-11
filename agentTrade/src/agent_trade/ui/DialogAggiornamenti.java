package agent_trade.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import agent_trade.ui.primaryView.PrimaryViewFactory;

public class DialogAggiornamenti implements Runnable
{
  private JFrame frame = new JFrame();

public static void main(String[] args)
  {
	  DialogAggiornamenti example = new DialogAggiornamenti("");
  }

  public DialogAggiornamenti(String messaggio)
  {

	Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
	Dimension frameSize = PrimaryViewFactory.getInstance().getSize ();

	frame.setLocation ((screenSize.width - frameSize.width) / 2,
	(screenSize.height - frameSize.height) / 2);
	  
    JTextArea textArea = new JTextArea(10, 40);
    textArea.setText(messaggio);
    textArea.setEditable(false);
    
    JScrollPane scrollPane = new JScrollPane(textArea);
    
    JOptionPane.showMessageDialog(frame, scrollPane);
  }

@Override
public void run() {
	
}
  
}
