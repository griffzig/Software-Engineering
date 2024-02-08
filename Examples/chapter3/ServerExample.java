package chapter3;

import java.io.IOException;
import java.net.InetAddress;

import javax.swing.ImageIcon;

import java.awt.*;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ServerExample extends AbstractServer
{
  public ServerExample()
  {
    super(12345);
  }
  
  protected void clientConnected(ConnectionToClient client) 
  {
    System.out.println("Client Connected:" + client.toString());
    System.out.println("IP Address: " + client.getInetAddress().toString());
    System.out.println("Client Id: " + client.getId());
  }

  @Override
  protected void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
  {
    String string;
    ImageIcon image;
    // TODO Auto-generated method stub
    System.out.println("Received Message from Client" + arg1.getId());
    InetAddress address = arg1.getInetAddress();
   
    System.out.println("Client Info:" + arg1.toString());
    
    if (arg0 instanceof String)
    {
      string = (String)arg0;
      System.out.println(string);
    }
    else if (arg0 instanceof ImageIcon)
    {
      image = (ImageIcon)arg0;
       
      System.out.println(image.toString());
    }
    
   
    
    try
    {
      arg1.sendToClient("Hello Client " + arg1.getId() );
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

  }
  
  protected void listeningException(Throwable exception)
  {
    System.out.println(exception);
    exception.printStackTrace();
  }
  
  public void serverStarted()
  {
    System.out.println("Server Started");
  }


}

