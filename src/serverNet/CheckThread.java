package serverNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import projectException.PasswordTooShortException;
import server.ServerMain;
import univers.NewUser;
import univers.RequestPack;
import univers.ServerQueryError;
import univers.User;

public class CheckThread implements Runnable
{
	private Socket socket;
	private BufferedInputStream bis;
	private ObjectInputStream ois;
	private boolean stillLoop = true;
	public CheckThread(Socket s)
	{
		socket = s;
		System.out.println("检查CheckThread 是否生成");
	}
        @Override
	public void run()
	{
		try
		{
			while(stillLoop)
			{
				bis = new BufferedInputStream(socket.getInputStream());
				System.out.println("检查CheckThread 的 bis 是否生成");
				ois = new ObjectInputStream(bis);
				System.out.println("检查CheckThread 的 ois 是否生成");
				if(bis.available()!=0)
				{
					Object obj = ois.readObject();
					System.out.println("收到包裹"+obj.toString());			
					switch(obj.toString())
					{
						case "RequestPack":
						{
							RequestPack rp = (RequestPack)obj;
							String name = rp.getName();
							String pass = rp.getPass();
							System.out.println("用户名为"+name+"密码"+pass);
							User usr = ServerMain.logUserIn(name, pass);
							if(usr != null)
							{
								/**
								 * 验证成功之后在ServerConnector中放入一个和userNumber对应的ServerThread
								 * 并且为这个用户发送用户的信息
								 * 新建一个线程转为这个人处理收发信息
								 */
								BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
								ObjectOutputStream oos = new ObjectOutputStream(bos);
								oos.writeObject(usr);
								oos.flush();
								bos.flush();
								
								ServerThread st = new ServerThread(socket,usr.getUserNumber());
								new Thread(st).start();
								ServerConnector.ServerThreadMap.put(usr.getUserNumber(), st);
								stillLoop = false;
																
							}
							else
							{
								new ServerThread(socket,9999).SendOutpack(new ServerQueryError(ServerQueryError.LOGINFAIL));
							}
							break;
						}
						case "NewUser":
						{
							User usr = null;
							NewUser nu = (NewUser)obj;
							usr = nu.getU();
							ServerMain.newUser(usr);
							System.out.println("已新建用户"+"姓名"+usr.getUserName()+" ，类型："+usr.getType()+"，编号："+usr.getUserNumber());
							break;
						}
						default:
						{
							
						}
					}
				
				}
			}
			
			
		}
		catch(IOException e)
		{
			/**
			 * 有io方面的问题就移除socket
			 */
//			ServerConnector.toCheckSocket.remove(socket);
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (PasswordTooShortException e) 
		{
			e.printStackTrace();
		}
	}
}
