package chapter3;

import ocsf.client.AbstractClient;

public class ExampleClient extends AbstractClient
{
  private String host;
  private int port;
  
  public ExampleClient()
  {
    super("localhost", 8300);
  }
  
  protected void connectionEstablished()
  {
    System.out.println("Client Connected");
  }
  
  public ExampleClient(String host, int port)
  {
    super(host, port);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void handleMessageFromServer(Object arg0)
  {
    // TODO Auto-generated method stub
    System.out.println(arg0);

  }

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub

  }

}
