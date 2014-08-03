package serverNet;

import java.net.Socket;

public class SocketCheckThread implements Runnable
{
	private Socket socket;
	public SocketCheckThread(Socket s)
	{
		socket = s;
		System.out.println("SocketCheckThread 生成");
	}
	public void run()
	{
		try
		{
			new Thread(new CheckThread(socket)).start();
//			System.out.println("SocketCheckThread run()");
//			System.out.println("SocketCheckThread toCheckSocket size "+ServerConnector.toCheckSocket.size());
//			while(true)
//			{
//				int t = ServerConnector.toCheckSocket.size();
//				if(t  != 0)
//				{
//					System.out.println(t);
//				}
//				if( t != 0)
//				{		
//					System.out.println("SocketCheckThread socket 开始检测");
//					
//					for(Socket s : ServerConnector.toCheckSocket)
//					{
//						new Thread(new CheckThread(s)).start();
//						ServerConnector.toCheckSocket.remove(s);
//					}			
//				}
//			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
