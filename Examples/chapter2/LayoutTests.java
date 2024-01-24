package chapter2;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class LayoutTests extends JFrame
{

  public LayoutTests() // Incorrect way to do things
  {
    //Invoke Base Class constructor for title
    super("Layout Test");

    //Set Default Closing Operation
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Add a button to each location
    JLabel jlabel = new JLabel("Label 1",JLabel.CENTER);
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    add(jlabel, BorderLayout.NORTH); // Maintain PS in vertical
    
    jlabel = new JLabel("Label 2",JLabel.CENTER);
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    add(jlabel, BorderLayout.SOUTH);
    
    jlabel = new JLabel("Label 3",JLabel.CENTER);
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    add(jlabel, BorderLayout.EAST); // Maintain PS in horizontal
    
    jlabel = new JLabel("Label 4",JLabel.CENTER);
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    add(jlabel, BorderLayout.WEST);
    
    jlabel = new JLabel("Label 5",JLabel.CENTER);
    jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
    add(jlabel, BorderLayout.CENTER);
    
    
    
    //Make visible
    setSize(1000,800);
    //this.pack();
    setVisible(true);


  }

  public LayoutTests(int dummy)
  // Grid Layout will expand to cover the entire region
  {
    super("Layout Tests");
    int i = 0;
    int j = 0;


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //Set layout manager of Frame to FlowLayout
    this.setLayout(new GridLayout(3,4,5,5));

    //Add 3 rows x 2 columns consisting of  labels, and buttons
    for (i = 0; i < 3; i++)
    {
      for (j = 0; j < 2; j++)
      {
        String str_label = "Label " + (i+1) + "," + (j+1) ;
        String str_button = "Button " + (i+1) + "," + (j+1);

        //Create JLabel
        JLabel jlabel = new JLabel(str_label,JLabel.RIGHT);
        jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        JButton jbutton = new JButton(str_button);
       

        //Add label then a button
        this.add(jlabel);
        this.add(jbutton);
      }
    }

    setSize(300,500);
    this.pack(); //Set window to preferred size 
    setVisible(true);

  }
  
  public LayoutTests(int dummy1, int dummy2, int dummy3)
  {
    super("Layout Tests");
    int i = 0;
    int j = 0;


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set layout manager of JPanel to GridLayou
    JPanel outer_panel = new JPanel(new GridLayout(3,1,5,5));
    outer_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    //Add 3 rows x 2 columns consisting of  labels, and buttons
    for (i = 0; i < 3; i++)
    {
      JPanel jp = new JPanel();
      for (j = 0; j < 2; j++)
      {
        String str_label = "Label " + (i+1) + "," + (j+1) ;
        String str_button = "Button " + (i+1) + "," + (j+1);

        //Create JLabel
        JLabel jlabel = new JLabel(str_label);
        JButton jbutton = new JButton(str_button);

        //Add label then a button
        jp.add(jlabel);
        jp.add(jbutton);
      }
      outer_panel.add(jp);
    }

    //Add grid layout to flow layout
    JPanel all_panel = new JPanel();
    all_panel.add(outer_panel);
    this.add(all_panel,BorderLayout.CENTER);

    setSize(350,500);
    //pack();
    setVisible(true);

  }

  public LayoutTests(int dummy1, int dummy2)
  {
    super("Layout Tests");
    int i = 0;
    int j = 0;


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set layout manager of Frame to GridLayout
    JPanel outer_panel = new JPanel(new GridLayout(3,4,5,5));
    outer_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    //Add 3 rows x 2 columns consisting of  labels, and buttons
    for (i = 0; i < 3; i++)
    {
      
      
      for (j = 0; j < 2; j++)
      {
        String str_label = "Label " + (i+1) + "," + (j+1) ;
        String str_button = "Button " + (i+1) + "," + (j+1);

        //Create JLabel
        JLabel jlabel = new JLabel(str_label,JLabel.RIGHT);
        JButton jbutton = new JButton(str_button);

        //Add label then a button
       
        outer_panel.add(jlabel);
        outer_panel.add(jbutton);
      }
      
    }

   
    
    
    
    //Buffer
    JPanel jp = new JPanel();	// FlowLayout
    jp.add(outer_panel);
   
    this.add(jp,BorderLayout.CENTER);
    

    setSize(500,500);
    //pack();
    setVisible(true);

  }


  public static void main(String[] args)
  {
    //LayoutTests layouttests = new LayoutTests();
    LayoutTests lt1 = new LayoutTests(1,1,1);
  }
}