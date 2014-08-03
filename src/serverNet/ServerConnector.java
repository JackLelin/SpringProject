package serverNet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerConnector implements Runnable
{
	public static HashMap<Integer,ServerThread> ServerThreadMap = new HashMap<Integer,ServerThread>();
	
	private ServerSocket ss;
	public ServerConnector(int port) throws IOException
	{
		ss = new ServerSocket(port);
	}
	public void run()
	{		
		try 
		{
			
			while(true)
			{
				Socket socket = ss.accept();
				System.out.println("接受到socket请求，已建立链接");
				System.out.println("接受到的socket放入toCheckSocket");
				new Thread(new SocketCheckThread(socket)).start();
			}	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void removeThread(int a)
	{
		ServerThreadMap.remove(a);
	}
}
