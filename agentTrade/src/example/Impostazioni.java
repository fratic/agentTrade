package example;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import agent_trade.ui.Setting;

public class Impostazioni extends JDialog {

	private JPanel contentPane;
	
	 private final int WIDTH = 500;
	 private final int HEIGHT = 800;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Impostazioni frame = new Impostazioni();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Impostazioni() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setModal(true);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-WIDTH)/2;
        int y = (screen.height-HEIGHT)/2;
        setBounds(x,y,WIDTH,HEIGHT);

		
		contentPane = new Setting();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
	}

}
