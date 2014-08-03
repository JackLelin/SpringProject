package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import clientGui.Launcher;
import univers.ClientSetUpPack;
import univers.HomeworkPack;
import univers.QuestionMapPack;
import univers.TalkPack;
import univers.User;

public class InClientThread implements Runnable
{
	private Socket socket;
	private BufferedInputStream bis;
	private ObjectInputStream ois;	
	private ClientMain cm;
	private boolean loop = true;
	
	public InClientThread(Socket s,ClientMain _cm)
	{
		socket = s;
		cm = _cm;
		
	}
	public void run()
	{
		while(loop)
		{
			try 
			{
				bis = new BufferedInputStream(socket.getInputStream());
				ois = new ObjectInputStream(bis);
				if(bis.available()!=0)
				{
					Object obj = ois.readObject();
					System.out.println("接收到了包裹"+obj.toString());
					switch(obj.toString())
					{
					/**************************************************
					 * 未完成
					 * 可能还有其他需要识别的包
					 * 
					 * 
					 **************************************************/
						case "TalkPack":
						{
							processTalk((TalkPack)obj);
							break;
						}										
						case "Question":
						{
							break;
						}
						case "User":
						{
							User user = (User)obj;
							cm.setUpUser(user); 
							break;
						}
						case "ClientSetUpPack":
						{
							ClientSetUpPack setpack = (ClientSetUpPack)obj;
							cm.SetUpClientUI(setpack);
							break;
						}
						case "ServerQueryError":
						{
							obj = null;
							cm.reconnectToServer();
							loop = false;
							break;
						}
						case "HomeworkPack":
						{
							cm.setHomework((HomeworkPack)obj);
							break;
						}
						case "QuestionMapPack":
						{
							QuestionMapPack qmp = (QuestionMapPack)obj;
							cm.SetFields(qmp);
							break;
						}
						case "Homework":
						{
							
							break;
						}
						default:
						{
							System.out.println("switch 没能工作,无法正常分类");
		
						} 
					}
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
				try 
				{
					loop=false;
					ois.close();
					bis.close();
					socket.close();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
				
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}	
	}
	public void processTalk(TalkPack tp)
	{
		cm.newMessage(tp);
	}

}
