package lab1out;

import javax.swing.*;

public class ServerGUI extends JFrame {

	private JLabel status; //Initialized to “Not Connected”
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea log;

	public ServerGUI(String title) {
		
	}
	
	public static void main(String[] args) {
		  
    	ServerGUI server = new ServerGUI("Server 1"); //args[0] represents the title of the GUI
  }

}
