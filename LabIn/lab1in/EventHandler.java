package lab1in;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EventHandler implements ActionListener {
	
	private JLabel label;
	
	public EventHandler(JLabel label) {
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String actionCommand = ae.getActionCommand();
		
		switch(actionCommand) {
			case ClientGUI.CONNECT:
				label.setText("Connect Button Pressed");
				label.setForeground(Color.GREEN);
				break;
			
			case ClientGUI.SUBMIT:
				label.setText("Submit Button Pressed");
				label.setForeground(Color.BLUE);
				break;
				
			case ClientGUI.STOP:
				label.setText("Stop Button Pressed");
				label.setForeground(Color.ORANGE);
				break;
			
			default:
				label.setText("Not connected");
				break;
		}
	}
}