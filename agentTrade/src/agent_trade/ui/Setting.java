package agent_trade.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import agent_trade.controller.Ctrl_System;

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
				
				JRadioButton radioAgente = new JRadioButton("Agente");
				radioAgente.setSelected(true);
				panelJRadioButton.add(radioAgente);
				
				JRadioButton radioMandante = new JRadioButton("Mandante");
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
		
		JRadioButton radioButton = new JRadioButton("1");
		panelJRadioLook.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		panelJRadioLook.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		panelJRadioLook.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		panelJRadioLook.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setSelected(true);
		panelJRadioLook.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("6");
		panelJRadioLook.add(radioButton_5);
		
		
        ButtonGroup groupLook = new ButtonGroup();
        groupLook.add(radioButton);
        groupLook.add(radioButton_1);
        groupLook.add(radioButton_2);
        groupLook.add(radioButton_3);
        groupLook.add(radioButton_4);
        groupLook.add(radioButton_5);

		
		
		JPanel databaseLocale = new JPanel();
		databaseLocale.setMinimumSize(new Dimension(800, 800));
		panel.add(databaseLocale);
		//				panel.setPreferredSize(new Dimension(500, 1000));
		
		databaseLocale.setAlignmentX(Component.RIGHT_ALIGNMENT);
		databaseLocale.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Impostazioni Database Locale", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		databaseLocale.setLayout(new BoxLayout(databaseLocale, BoxLayout.PAGE_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 15, 0, 0));
		databaseLocale.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel label = new JLabel("Host");
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Nome database");
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("N\u00B0 porta");
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JLabel label_3 = new JLabel("Nome utente");
		panel_1.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_1.add(textField_3);
		
		JLabel label_4 = new JLabel("Password");
		panel_1.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_1.add(textField_4);
		
		JLabel label_5 = new JLabel("URL");
		panel_1.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_1.add(textField_5);
		
		JPanel databaseRemoto = new JPanel();
		panel.add(databaseRemoto);
		databaseRemoto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Impostazioni Database Remoto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		databaseRemoto.setAlignmentX(1.0f);
		databaseRemoto.setLayout(new BoxLayout(databaseRemoto, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(100, 100));
		databaseRemoto.add(panel_2);
		panel_2.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel label_6 = new JLabel("Host");
		panel_2.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		panel_2.add(textField_6);
		
		JLabel label_7 = new JLabel("Nome database");
		panel_2.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_2.add(textField_7);
		
		JLabel label_8 = new JLabel("N\u00B0 porta");
		panel_2.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_2.add(textField_8);
		
		JLabel label_9 = new JLabel("Nome utente");
		panel_2.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_2.add(textField_9);
		
		JLabel label_10 = new JLabel("Password");
		panel_2.add(label_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_2.add(textField_10);
		
		JLabel label_11 = new JLabel("URL");
		panel_2.add(label_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_2.add(textField_11);
		
		JPanel bottoni = new JPanel();
		panel.add(bottoni);
		bottoni.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnRipristinaDefault = new JButton("Ripristina Default");
		bottoni.add(btnRipristinaDefault);
		
		JButton btnSalva = new JButton("Salva");
		bottoni.add(btnSalva);

		
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Ctrl_System.getInstance().salvaSetting();
						
			}
		});
		
		
	}
}
