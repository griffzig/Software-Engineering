package lab2out;

import javax.swing.*;
import ocsf.server.*;
import java.awt.*;

public class ChatServer extends AbstractServer {

	private JTextArea log; // = JTextArea of ServerGUI
	private JLabel status; // = JLabel of ServerGUI
	
	
	public ChatServer() {
		
		super(12345);
	}
	
	// Setter for JTextArea 
	public void setLog(JTextArea log) {
		this.log = log;
	}
	
	// Setter for JLabel status area
	public void setStatus(JLabel status) {
		this.status = status;
	}
	
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		
		System.out.println("Message from Client Received");
	}
	
	public void listeningException(Throwable exception) {
		
		if (log != null) {
			log.append("Listening Exception: " + exception.getMessage() + "\n");
			log.append("Press 'Listen' to restart server.\n");
		}
		
		if (status != null) {
			status.setText("Exception Occurred when Listening");
			status.setForeground(Color.RED);
		}
	}
	
	public void serverStarted() {
		if (log != null) {
			log.append("Server started\n");
		}
		
		if (status != null) {
			status.setText("Listening");
			status.setForeground(Color.GREEN);
		}
	}
	
	public void serverStopped() {
		if (log != null) {
			log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients");
		}
		
		if (status != null) {
			status.setText("Stopped");
			status.setForeground(Color.RED);
		}
	}
	
	public void serverClosed() {
		if (log != null) {
			log.append("Server and all current clients are closed - Press Listen to Restart");
		}
		
		if (status != null) {
			status.setText("Closed");
			status.setForeground(Color.RED);
		}
	}
	
	public void clientConnected(ConnectionToClient client) {
		if (log != null) {
			log.append("Client connected");
		}
	}
}
