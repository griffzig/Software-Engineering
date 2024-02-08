package chapter3;

import java.io.IOException;

public class ServerInterface
{
  private ServerExample server;

  public ServerInterface()
  {
    //Create a Server Example
    server = new ServerExample();
    
    try
    {
      
      server.setPort(8300);
      server.setTimeout(500);
      server.listen();
      
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
    
    
  }
  
  public static void main(String[] args)
  {
    new ServerInterface();
  }

}
