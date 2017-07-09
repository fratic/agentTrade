package agent_trade.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
//		setBorder(new EmptyBorder(0, 15, 10, 15));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(250, 320));
		add(panel);
		
		
		JPanel Version = new JPanel();
		Version.setPreferredSize(new Dimension(250, 100));
		Version.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Versione del software", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(Version);
				
		JPanel panelJRadioButton = new JPanel();
		panelJRadioButton.setLayout(new GridLayout(1, 2, 0, 0));
		panelJRadioButton.setPreferredSize(new Dimension(240, 60));
		Version.add(panelJRadioButton);
			
		radioAgente = new JRadioButton("Agente");
		panelJRadioButton.add(radioAgente);
		
		radioMandante = new JRadioButton("Mandante");
		panelJRadioButton.add(radioMandante);
				
        ButtonGroup groupVersione = new ButtonGroup();
        groupVersione.add(radioAgente);
        groupVersione.add(radioMandante);
		
        
		JPanel LookandFeel = new JPanel();		
		LookandFeel.setBorder(new TitledBorder(null, "Scegli la tua grafica", TitledBorder.LEADING, TitledBorder.TOP, null,new Color(0, 0, 0)));
		LookandFeel.setPreferredSize(new Dimension(250, 100));
		panel.add(LookandFeel);
		
		JPanel panelJRadioLook = new JPanel();
		panelJRadioLook.setLayout(new GridLayout(2, 3, 0, 0));
		panelJRadioLook.setPreferredSize(new Dimension(240, 60));
		LookandFeel.add(panelJRadioLook);
		
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

		JPanel pannVuoto = new JPanel();
		pannVuoto.setPreferredSize(new Dimension(240, 10));
		panel.add(pannVuoto);
		
		JPanel bottoni = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) bottoni.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(0);
		bottoni.setPreferredSize(new Dimension(240, 50));
		panel.add(bottoni);
		
		JPanel pannDefault = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pannDefault.getLayout();
		pannDefault.setPreferredSize(new Dimension(160, 50));
		flowLayout.setVgap(10);
		bottoni.add(pannDefault);
		
		JButton btnRipristinaDefault = new JButton("Ripristina Default");
		pannDefault.add(btnRipristinaDefault);
		
		JPanel pannSalva = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pannSalva.getLayout();
		pannSalva.setPreferredSize(new Dimension(80, 50));
		flowLayout_1.setVgap(10);
		bottoni.add(pannSalva);
		
		JButton btnSalva = new JButton("Salva");
		pannSalva.add(btnSalva);

		
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
