package lab1in;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class ClientGUI extends JFrame {

	private JLabel statusText;
	private JLabel status;
	  private JButton connect;
	  private JButton submit;
	  private JButton stop;
	  
	 public final static String CONNECT = "ClientGUI.CONNECT";
	 public final static String SUBMIT = "ClientGUI.SUBMIT";
	 public final static String STOP = "ClientGUI.STOP";
	 public static String STATUS = "";
	  
	  public ClientGUI(String title)
	  {
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
		// JLabel for Status on Client
		status = new JLabel("Status: ", JLabel.LEFT);
		statusText = new JLabel("Not Connected", JLabel.LEFT);
		statusText.setForeground(Color.RED);
		JPanel north = new JPanel();
		north.add(status);
		north.add(statusText);
				
	    int i = 0;
	    
	    EventHandler eventHandler = new EventHandler(statusText);
	    
	    // JButtons for connect, submit, stop on Client
	    JButton connect = new JButton("Connect");
	    connect.setActionCommand(ClientGUI.CONNECT);
	    connect.addActionListener(eventHandler);
	    
	    JButton submit = new JButton("Submit");
	    submit.setActionCommand(ClientGUI.SUBMIT);
	    submit.addActionListener(eventHandler);
	    
	    JButton stop = new JButton("Stop");
	    stop.setActionCommand(ClientGUI.STOP);
	    stop.addActionListener(eventHandler);
	    
	    JPanel south = new JPanel();
	    south.add(connect);
	    south.add(submit);
	    south.add(stop);
	    
	    this.add(north, BorderLayout.NORTH);
	    this.add(south, BorderLayout.SOUTH);
	    
	    this.setSize(400, 500);
	    this.setVisible(true);
	    	    
	    
	  }
	  
	  public static void main(String[] args) {
		  
	    	ClientGUI client = new ClientGUI("Client 1"); //args[0] represents the title of the GUI
	  }

}