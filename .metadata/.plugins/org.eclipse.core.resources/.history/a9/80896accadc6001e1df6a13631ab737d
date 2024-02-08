package lab3out;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class ClientGUI extends JFrame
{
  // Data fields.
  private JLabel status;
  private JButton connect;
  private JButton submit;
  private JButton stop;
  private String[] labels = {"Client ID", "Server URL", "Server Port"};
  private JTextField[] textFields = new JTextField[labels.length];
  private JLabel clientLabel;
  private JLabel serverLabel;
  private JTextArea clientArea;
  private JTextArea serverArea;
  private ChatClient client;


  // Constructor for the client GUI.
	public ClientGUI(String title) {
		
		 // Set the title and default close operation.
	    this.setTitle(title);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		// Create the main variables that will be used.
		JPanel north = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new BorderLayout());
		JPanel south = new JPanel();
		EventHandler handler = new EventHandler();
	    
	    // North Container
	    // Create the status label
		JPanel outerNorth = new JPanel(new FlowLayout());
	    JPanel statusPanel = new JPanel();
	    JLabel statusText = new JLabel("Status:");	   
	    statusPanel.add(statusText);
	    status = new JLabel("Not Connected");
	    status.setForeground(Color.RED);
	    statusPanel.add(status);
	    north.add(statusPanel, BorderLayout.NORTH);
	    
	    // North Grid
	    JPanel centerNorth = new JPanel(new GridLayout(labels.length, 1, 10, 10));
	    for (int i = 0; i < labels.length; i++) {
	    	
	    	JLabel label = new JLabel(labels[i]);
	    	centerNorth.add(label);
	    	
	    	JTextField textField = new JTextField();
	    	
	    	if (labels[i].equals("Client ID")) {
	    		textField.setEditable(false);
	    	}
	    	
	    	centerNorth.add(textField);
	    	
	    	textFields[i] = textField;
	    }
	    outerNorth.add(centerNorth);
	    north.add(outerNorth, BorderLayout.CENTER);
	    
	    // Center Container
	    // Center Grid
	    JPanel centerCenter = new JPanel(new GridLayout(4, 1, 1, 1));
	    clientLabel = new JLabel("Enter Client Data Below");
	    centerCenter.add(clientLabel);
	    clientArea = new JTextArea(4, 20);
	    JScrollPane clientScrollPane = new JScrollPane(clientArea);
	    centerCenter.add(clientScrollPane);
	    serverLabel = new JLabel("Received Server Data");
	    centerCenter.add(serverLabel);
	    serverArea = new JTextArea(4, 20);
	    serverArea.setEditable(false);
	    JScrollPane serverScrollPane = new JScrollPane(serverArea);
	    centerCenter.add(serverScrollPane);
	    
	    JPanel outerCenter = new JPanel(new FlowLayout());
	    outerCenter.add(centerCenter);
	    center.add(outerCenter, BorderLayout.CENTER);
	    
	    // South Container
	    // Create buttons
	    connect = new JButton("Connect");
	    connect.addActionListener(handler);
	    south.add(connect);
	    submit = new JButton("Submit");
	    submit.addActionListener(handler);
	    south.add(submit);
	    stop = new JButton("Stop");
	    stop.addActionListener(handler);
	    south.add(stop);
	    
	    // Add the north, south, and center JPanels to the JFrame
	    this.add(north, BorderLayout.NORTH);
	    this.add(center, BorderLayout.CENTER);
	    this.add(south, BorderLayout.SOUTH);
	    
	    // Display window
	    this.setSize(500, 500);
	    this.setVisible(true);
	    
	    // Instantiate ChatClient
	    client = new ChatClient();
	    client.setHost("localhost");
	    client.setPort(8300);
	    client.setStatus(status);
	    client.setServerMsg(serverArea);
	    client.setClientID(textFields[0]);
	    
		}
		
		// Main function for the client.
		public static void main(String[] args) {
			// Create a ClientGUI object with the first command-line argument as its title.
			new ClientGUI("Client 1");
		}
	
	// Class for handling events.
	class EventHandler implements ActionListener {
	  // Event handler for ActionEvent.
		public void actionPerformed(ActionEvent ae) {
      // Display a message indicating which button was clicked.
			Object buttonClicked = ae.getSource();
			// connect button
			if (buttonClicked == connect) {
				try {
					client.openConnection();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			// submit button
			} else if (buttonClicked == submit) {
				String clientData = clientArea.getText();
				try {
					client.sendToServer(clientData);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			// stop button
			} else if (buttonClicked == stop) {
				try {
					client.closeConnection();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}