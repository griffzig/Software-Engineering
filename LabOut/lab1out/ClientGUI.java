package lab1out;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame {

	// Data fields
	private JLabel status;
	private JButton connect;
	private JButton submit;
	private JButton stop;
	private String[] labels = {"Client ID", "Server URL", "Server Port"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea clientArea;
	private JTextArea serverArea;
	  
	
	  public ClientGUI(String title) {
		  
		// Main variables
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel northBuffer = new JPanel(new FlowLayout());
		JPanel north = new JPanel(new GridLayout(4, 2, 10, 10));
		JPanel south = new JPanel();
		EventHandler handler = new EventHandler();
		
		// Set title and default close operation
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
		// JLabel for Status on Client
		JLabel statusText = new JLabel("Status:");
		north.add(statusText);
		status = new JLabel("Not Connected");
		status.setForeground(Color.RED);
		north.add(status);
		
		// Create Grid
		for (int i = 0; i < labels.length; i++) {
			
			JLabel label = new JLabel(labels[i]);
			north.add(label);
			
			textFields[i] = new JTextField();
			north.add(textFields[i]);
		}
	    
	    // JButtons for connect, submit, stop on Client
	    connect = new JButton("Connect");
	    connect.addActionListener(handler);
	    south.add(connect);
	    submit = new JButton("Submit");
	    submit.addActionListener(handler);
	    south.add(submit);
	    stop = new JButton("Stop");
	    stop.addActionListener(handler);
	    south.add(stop);
	    
	    northBuffer.add(north);
	    
	    mainPanel.add(northBuffer, BorderLayout.NORTH);
	    mainPanel.add(south, BorderLayout.SOUTH);
	    
	    this.add(mainPanel);
	    
	    // Add north and south JPanels to the JFrame 
	    this.add(north, BorderLayout.NORTH);
	    this.add(south, BorderLayout.SOUTH);
	    
	    // Display the window
	    this.setSize(450, 450);
	    this.setVisible(true);
	  }
	  
	  public static void main(String[] args) {
		  
	    	new ClientGUI("Client 1"); //args[0] represents the title of the GUI
	  }
	  
	  // Class for handling events
	  class EventHandler implements ActionListener {
		  
		  public void actionPerformed(ActionEvent ae) {
			  
			  Object buttonClicked = ae.getSource();
			  
			  if (buttonClicked == connect){
				  System.out.println("Connect Button Pressed");
			  } else if (buttonClicked == submit) {
				  System.out.println("Submit Button Pressed");
			  } else if (buttonClicked == stop) {
				  System.out.println("Stop Button Pressed");
			  }
		  }
	  }

}