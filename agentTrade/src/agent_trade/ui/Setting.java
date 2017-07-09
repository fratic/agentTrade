package agent_trade.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import agent_trade.controller.Ctrl_System;
import agent_trade.util.Costanti;

public class Setting extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	JRadioButton radioAgente;
	JRadioButton radioMandante;
	JRadioButton radioButton_0;
	JRadioButton radioButton_1;
	JRadioButton radioButton_2;
	JRadioButton radioButton_3;
	JRadioButton radioButton_4;
	JRadioButton radioButton_5;
	JRadioButton radioButton_6;
	
	
	ButtonGroup groupLook;
	
	/**
	 * Create the panel.
	 */
	public Setting() {

		setBorder(new EmptyBorder(10, 15, 10, 15));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JPanel Version = new JPanel();
//		Version.setPreferredSize(new Dimension(600, 100));
		panel.add(Version);
				Version.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Versione del software", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				Version.setLayout(new BoxLayout(Version, BoxLayout.PAGE_AXIS));
				
				JPanel panelJRadioButton = new JPanel();
				panelJRadioButton.setLayout(new GridLayout(1, 2, 0, 0));
				
				radioAgente = new JRadioButton("Agente");
//				radioAgente.setSelected(true);
				panelJRadioButton.add(radioAgente);
				
				radioMandante = new JRadioButton("Mandante");
				panelJRadioButton.add(radioMandante);
				
				Version.add(panelJRadioButton);
				
		        ButtonGroup groupVersione = new ButtonGroup();
		        groupVersione.add(radioAgente);
		        groupVersione.add(radioMandante);

				
				
				
				
		
		JPanel LookandFeel = new JPanel();
		LookandFeel.setMinimumSize(new Dimension(800, 1000));

		panel.add(LookandFeel);
		LookandFeel.setBorder(new TitledBorder(null, "Scegli la tua grafica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		LookandFeel.setLayout(new BoxLayout(LookandFeel, BoxLayout.PAGE_AXIS));
		
		JPanel panelJRadioLook = new JPanel();
		LookandFeel.add(panelJRadioLook);
		panelJRadioLook.setLayout(new GridLayout(2, 3, 0, 0));
		
		radioButton_0 = new JRadioButton("0");
		panelJRadioLook.add(radioButton_0);

		radioButton_1 = new JRadioButton("1");
		panelJRadioLook.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("2");
		panelJRadioLook.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("3");
		panelJRadioLook.add(radioButton_3);
		
		radioButton_4 = new JRadioButton("4");
		panelJRadioLook.add(radioButton_4);
		
		radioButton_5 = new JRadioButton("5");
		radioButton_5.setSelected(true);
		panelJRadioLook.add(radioButton_5);
		
		radioButton_6 = new JRadioButton("6");
		panelJRadioLook.add(radioButton_6);
		
		
        groupLook = new ButtonGroup();
        groupLook.add(radioButton_0);
        groupLook.add(radioButton_1);
        groupLook.add(radioButton_2);
        groupLook.add(radioButton_3);
        groupLook.add(radioButton_4);
        groupLook.add(radioButton_5);
        groupLook.add(radioButton_6);

		
		
		JPanel bottoni = new JPanel();
		panel.add(bottoni);
		bottoni.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnRipristinaDefault = new JButton("Ripristina Default");
		bottoni.add(btnRipristinaDefault);
		
		JButton btnSalva = new JButton("Salva");
		bottoni.add(btnSalva);

		
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String versione = null;
				String look = null;
				
				
				if (radioAgente.isSelected()){
					versione="agente";
				}
				if(radioMandante.isSelected()){
					versione="mandante";
				}
				
				if(radioButton_0.isSelected()){
					look="0";
				}
				
				if(radioButton_1.isSelected()){
					look="1";
				}

				if(radioButton_2.isSelected()){
					look="2";
				}
				if(radioButton_3.isSelected()){
					look="3";
				}
				if(radioButton_4.isSelected()){
					look="4";
				}
				if(radioButton_5.isSelected()){
					look="5";
				}
				if(radioButton_6.isSelected()){
					look="6";
				}
					
				
				Ctrl_System.getInstance().salvaSetting(versione, look);
			}
		});
		
		
		btnRipristinaDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String versione = "agente";
				String look = "5";		
				Ctrl_System.getInstance().salvaSetting(versione, look);
				
			}
		});
		
	}
	
	
	public void setImpostazioni(String readVersion, int readLook) {


		if (readVersion.equals(Costanti.agente))
		{
			radioAgente.setSelected(true);
			radioMandante.setSelected(false);
		}
		if (readVersion.equals(Costanti.mandante))
		{
			radioAgente.setSelected(false);
			radioMandante.setSelected(true);
		}
			
		
		switch (readLook) {
		
		case 0:
			radioButton_0.setSelected(true);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
			radioButton_4.setSelected(false);
			radioButton_5.setSelected(false);
			radioButton_6.setSelected(false);

			break;
		case 1:
			radioButton_0.setSelected(false);
			radioButton_1.setSelected(true);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
			radioButton_4.setSelected(false);
			radioButton_5.setSelected(false);
			radioButton_6.setSelected(false);

			break;

		case 2:
			radioButton_0.setSelected(false);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(true);
			radioButton_3.setSelected(false);
			radioButton_4.setSelected(false);
			radioButton_5.setSelected(false);
			radioButton_6.setSelected(false);
					
			break;
		case 3:
			radioButton_0.setSelected(false);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(true);
			radioButton_4.setSelected(false);
			radioButton_5.setSelected(false);
			radioButton_6.setSelected(false);

			break;
		case 4:
			radioButton_0.setSelected(false);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
			radioButton_4.setSelected(true);
			radioButton_5.setSelected(false);
			radioButton_6.setSelected(false);

			break;
		case 5:
			radioButton_0.setSelected(false);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
			radioButton_4.setSelected(false);
			radioButton_5.setSelected(true);
			radioButton_6.setSelected(false);

			break;
		case 6:
			radioButton_0.setSelected(false);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
			radioButton_4.setSelected(false);
			radioButton_5.setSelected(false);
			radioButton_6.setSelected(true);

			break;
		}
	}
}
