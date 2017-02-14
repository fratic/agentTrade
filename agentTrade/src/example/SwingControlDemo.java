package example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SwingControlDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   
   public SwingControlDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingControlDemo  swingControlDemo = new SwingControlDemo();      
      swingControlDemo.showProgressBarDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private JProgressBar progressBar;
   private Task task;
   private JButton startButton;
   private JTextArea outputTextArea;
   
   private void showProgressBarDemo(){
      headerLabel.setText("Control in action: JProgressBar"); 
      progressBar = new JProgressBar(0, 100);
      progressBar.setValue(0);
      progressBar.setStringPainted(true);
      startButton = new JButton("Start");
      outputTextArea = new JTextArea("",5,20);
      JScrollPane scrollPane = new JScrollPane(outputTextArea);    
      
      startButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            task = new Task();                
            task.start();
         }
      });
      controlPanel.add(startButton);
      controlPanel.add(progressBar);
      controlPanel.add(scrollPane);
      mainFrame.setVisible(true);  
   }
   private class Task extends Thread {    
      public Task(){
      }
      public void run(){
         for(int i =0; i<= 100; i+=10){
            final int progress = i;
            
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  progressBar.setValue(progress);
                  outputTextArea.setText(outputTextArea.getText() 
                     + String.format("Completed %d%% of task.\n", progress));
               }
            });
            try {
               Thread.sleep(100);
            } catch (InterruptedException e) {}
         }
      }
   }   
}