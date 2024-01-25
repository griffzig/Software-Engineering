package lab1out;

import java.awt.*;
import java.awt.event.*;
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


  // Constructor for the client GUI.
	public ClientGUI(String title) {
		
		// Create the main variables that will be used.
		JPanel north = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new FlowLayout());
		JPanel south = new JPanel();
		EventHandler handler = new EventHandler();

    
	    // Set the title and default close operation.
	    this.setTitle(title);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // north panel
	    // Create the status label.
	    JPanel statusPanel = new JPanel();
	    JLabel statusText = new JLabel("Status:");	   
	    status = new JLabel("Not Connected");
	    status.setForeground(Color.RED);
	    statusPanel.add(statusText);
	    statusPanel.add(status);
	    north.add(statusPanel, BorderLayout.NORTH);
	   
	    // Create Grid
	    JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1, 10, 10));
	  	for (int i = 0; i < labels.length; i++) {
	  			
	  		JLabel label = new JLabel(labels[i]);
	  		textFields[i] = new JTextField();
	  		
	  		labelPanel.add(label);
	  		labelPanel.add(textFields[i]);
	  	}
	  	north.add(labelPanel, BorderLayout.CENTER);
	  	
	  	// Center 
	  	JPanel dataPanel = new JPanel(new GridLayout(4, 1, 10, 10));
	  	clientLabel = new JLabel("Enter Client Data Below");
	  	serverLabel = new JLabel("Received Server Data");
	  	
	  	clientArea = new JTextArea();
	  	serverArea = new JTextArea();
	  	JScrollPane clientScrollPane = new JScrollPane(clientArea);
	  	clientScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        clientScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane serverScrollPane = new JScrollPane(serverArea);
        serverScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        serverScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	  	
	  	dataPanel.add(clientLabel);
	  	dataPanel.add(clientArea);
	  	dataPanel.add(serverLabel);
	  	dataPanel.add(serverArea);
	  	center.add(dataPanel);
	  	
	
	    
	    // Create the buttons.
	    connect = new JButton("Connect");
	    connect.addActionListener(handler);
	    south.add(connect);
	    submit = new JButton("Submit");
	    submit.addActionListener(handler);
	    south.add(submit);
	    stop = new JButton("Stop");
	    stop.addActionListener(handler);
	    south.add(stop);
	    
	    // Add the north and south JPanels to the JFrame.
	    this.add(north, BorderLayout.NORTH);
	    this.add(center, BorderLayout.CENTER);
	    this.add(south, BorderLayout.SOUTH);
	    
	    // Display the window.
	    this.setSize(450, 450);
	    this.setVisible(true);
	    
		}
		
		// Main function for the client.
		public static void main(String[] args) {
			// Create a ClientGUI object with the first command-line argument as its title.
			ClientGUI client = new ClientGUI("Client 1");
		}
	
	// Class for handling events.
	class EventHandler implements ActionListener {
	  // Event handler for ActionEvent.
		public void actionPerformed(ActionEvent e) {
      // Display a message indicating which button was clicked.
			Object buttonClicked = e.getSource();
			if (buttonClicked == connect) {
				System.out.println("Connect Button Pressed");
			} else if (buttonClicked == submit) {
				System.out.println("Submit Button Pressed");
			} else if (buttonClicked == stop) {
				System.out.println("Stop Button Pressed");
			}
		}
	}
}
