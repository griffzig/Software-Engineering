package chapter3;

import java.awt.*;
import javax.swing.ImageIcon;
import java.io.IOException;

public class ClientInterface
{
  private ExampleClient client;
  public ClientInterface(String host, int port) 
  {
    //Create client
    client = new ExampleClient(host,port);
    
    //Create a connection
    try
    {
      client.openConnection();
    } 
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    //Send a message
    String msg = "This is a message";
    try
    {
      client.sendToServer(msg);
    } 
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    //Get an image (must provide the package/name)
    ImageIcon uca1 = new ImageIcon("chapter3/uca.png");
    
    //Send to server
    try
    {
      client.sendToServer(uca1);
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  public static void main(String[] args)
  {
    new ClientInterface("localhost", 8300);
  }
}
