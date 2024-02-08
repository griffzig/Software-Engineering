package lab1out;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		
		// Display window
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		  
    	new ServerGUI(args[0]); //args[0] represents the title of the GUI
  }
	
	class EventHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent ae) {
		
			Object buttonClicked = ae.getSource();
			if (buttonClicked == listen) {
				System.out.println("Listen Button Pressed");
			} else if (buttonClicked == close) {
				System.out.println("Close Button Pressed");
			} else if (buttonClicked == stop) {
				System.out.println("Stop Button Pressed");
			} else if (buttonClicked == quit) {
				System.exit(0);
			}
		}
	}

}
