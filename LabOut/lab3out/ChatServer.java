package lab3out;

import javax.swing.*;
import ocsf.server.*;
import java.awt.*;
import java.io.IOException;

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
		try {
			String msg = (String)arg0;
			log.append("Client" + arg1.getId() + " says: " + msg + "\n");
			arg1.sendToClient(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void clientConnected(ConnectionToClient client) {
		try {
			client.sendToClient("Username:client-" + client.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.append("Client " + client.getId() + " Connected \n");
	}
	
	public void listeningException(Throwable exception) {
		log.append("Listening Exception: " + exception.getMessage() + "\n");
		log.append("Press Listen to Restart Server");
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.RED);
	}
	
	public void serverStarted() {
		log.setText("Server started\n");
		status.setText("Listening");
		status.setForeground(Color.GREEN);
	}
	
	public void serverStopped() {
		log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients");
		status.setText("Stopped");
		status.setForeground(Color.RED);
	}
	
	public void serverClosed() {
		log.append("Server and all current clients are closed - Press Listen to Restart");
		status.setText("Closed");
		status.setForeground(Color.RED);
	}
	
	
}