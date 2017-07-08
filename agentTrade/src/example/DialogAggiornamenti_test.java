package example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import agent_trade.ui.primaryView.PrimaryViewFactory;

/**
 * A Java class to demonstrate how to put a scrolling text area
 * in a JOptionPane showMessageDialog dialog. 
 * 
 * Steps are simple - Just create a JTextArea, wrap it in a 
 * JScrollPane, and then add the JScrollPane to the showMessageDialog.
 */
public class DialogAggiornamenti_test implements Runnable
{
  private JFrame frame = new JFrame();

public static void main(String[] args)
  {
	  DialogAggiornamenti_test example = new DialogAggiornamenti_test("");
  }

  public DialogAggiornamenti_test(String messaggio)
  {

	Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
	System.out.println("dimensione schermo"+screenSize);
	Dimension frameSize = PrimaryViewFactory.getInstance().getSize ();
	System.out.println("dimensione finestra"+frameSize);

	frame.setLocation ((screenSize.width - frameSize.width) / 2,
	(screenSize.height - frameSize.height) / 2);
	  
    JTextArea textArea = new JTextArea(6, 25);
    textArea.setText(messaggio);
    textArea.setEditable(false);
    
    JScrollPane scrollPane = new JScrollPane(textArea);
    
    JOptionPane.showMessageDialog(frame, scrollPane);
  }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
  
}
