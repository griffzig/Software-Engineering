package lab3out;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ServerGUI extends JFrame {

	private JLabel status; //Initialized to “Not Connected”
	private JButton listen;
	private JButton close;
	private JButton stop;
	private JButton quit;
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JLabel logLabel;
	private JTextArea log;
	private ChatServer server;
	private int port;
	private int timeout;

	public ServerGUI(String title) {
		
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main variables
		JPanel north = new JPanel(new BorderLayout());
		JPanel center = new JPanel (new BorderLayout());
		JPanel south = new JPanel();
		EventHandler handler = new EventHandler();
		
		// North Container
		// Status label
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
			centerNorth.add(textField);
			
			textFields[i] = textField;
		}
		outerNorth.add(centerNorth);
		north.add(outerNorth, BorderLayout.CENTER);
		
		// Center Container
		// Center Grid
		JPanel centerCenter = new JPanel(new GridLayout(2, 1, 1, 1));
		logLabel = new JLabel("Server Log Below");
		centerCenter.add(logLabel);
		log = new JTextArea(8, 30);
		JScrollPane scrollPane = new JScrollPane(log);
		centerCenter.add(scrollPane);
		
		JPanel outerCenter = new JPanel(new FlowLayout());
		outerCenter.add(centerCenter);
		center.add(outerCenter, BorderLayout.CENTER);
		
		// South Container
		// Create buttons
		listen = new JButton("Listen");
		listen.addActionListener(handler);
		south.add(listen);
		close = new JButton("Close");
		close.addActionListener(handler);
		south.add(close);
		stop = new JButton("Stop");
		stop.addActionListener(handler);
		south.add(stop);
		quit = new JButton("Quit");
		quit.addActionListener(handler);
		south.add(quit);
		
		// Add north, south, and center JPanels to the JFrame
		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		
		// Instantiate ChatServer
		server = new ChatServer();
		server.setLog(log);
		server.setStatus(status);
		
		// Display window
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	class EventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent ae) {
		
			Object buttonClicked = ae.getSource();
			// listen button
			if (buttonClicked == listen) {
				String portText = textFields[0].getText().trim();
				String timeoutText = textFields[1].getText().trim();
				
				if (portText.isEmpty() || timeoutText.isEmpty()) {
					log.append("Port Number/timeout not entered before pressing Listen");
				} else {
					try {
						if (status.getText().equals("Exception Occurred when Listening")) {
							server.close();
							port = Integer.parseInt(textFields[0].getText());
							timeout = Integer.parseInt(textFields[1].getText());
							server.setPort(port);
							server.setTimeout(timeout);
							server.listen();
						} else {
							port = Integer.parseInt(textFields[0].getText());
							timeout = Integer.parseInt(textFields[1].getText());
							server.setPort(port);
							server.setTimeout(timeout);
							server.listen();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			// close button
			} else if (buttonClicked == close) {
				if (!server.isListening()) {
					log.append("Server not currently started");
				} else {
					try {
						server.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			// stop button
			} else if (buttonClicked == stop) {
				if (!server.isListening()) {
					log.append("Server not currently started");
				} else {
					server.stopListening();
				}
		
			// quit button
			} else if (buttonClicked == quit) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
    	new ServerGUI("Server 1"); //args[0] represents the title of the GUI
  }

}
