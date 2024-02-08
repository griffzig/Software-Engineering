package lab3out;

import ocsf.client.AbstractClient;
import javax.swing.*;
import java.awt.*;

public class ChatClient extends AbstractClient {
	
	private JLabel status; // status in ClientGUI
	private JTextArea serverMsg; // message received from ChatServer
	private JTextField clientID; // assigned by server

	// Constructor
	public ChatClient() {
		super("localhost", 8300);
	}
	
	// Setter for status
	public void setStatus(JLabel status) {
		this.status = status;
	}
	
	// Setter for serverMsg
	public void setServerMsg(JTextArea serverMsg) {
		this.serverMsg = serverMsg;
	}
	
	// Setter for clientID
	public void setClientID(JTextField clientID) {
		this.clientID = clientID;
	}
	
	// Hook method for Client
	public void connectionEstablished() {
		status.setText("Connected");
		status.setForeground(Color.GREEN);
	}
	
	// Slot method for Client
	public void handleMessageFromServer(Object arg0) {
		String msg = (String)arg0;
		
		System.out.println("Server: " + msg);
		
		// parse username from value and display newly assigned client's id in the 1st JTextField  
		if (msg.contains(":")) {
			String[] username = msg.split(":");
			if (username.length == 2) {
				String key = username[0].trim();
				String value = username[1].trim();
				
				if (key.equals("username")) {
					clientID.setText(value);
				}
			}
		} else {
			serverMsg.append("Server: " + msg + "\n");
		}	
	}
	
	public void connectionException(Throwable exception) {
		System.out.println("Connection Exception Occurred");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
	}
	
	// Hook method
	public void connectionClosed() {
		status.setText("Not Connected");
		status.setForeground(Color.RED);
	}
}
