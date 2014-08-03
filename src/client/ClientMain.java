package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clientGui.ClientFrame;
import clientGui.Launcher;
import clientGui.StudentFrame;
import clientGui.TeacherFrame;
import projectException.PasswordTooShortException;
import univers.ClientSetUpPack;
import univers.HomeworkPack;
import univers.NewUser;
import univers.QuestionMapPack;
import univers.RequestPack;
import univers.TalkPack;
import univers.User;

public class ClientMain implements Runnable
{
	private Socket socket;
	private UserOutConnector uos;
	private ClientFrame cf;
	private String ip;
	private int port;
	private InClientThread inClientThread;
    public  HashMap<Integer,String> IconMap = new HashMap<Integer,String>();
	public  HashMap<Integer,String> NameMap = new HashMap<Integer,String>();
	//private User user;

	
	public ClientMain(String _ip) throws UnknownHostException, IOException
	{
		this(_ip, 11235);
		ip = _ip;	
	}
	
	public ClientMain(String ip, int _port)  throws UnknownHostException, IOException
	{
		socket = new Socket(ip,_port);
		uos = new UserOutConnector(socket);
		inClientThread = new InClientThread(socket,this);
	}
	public boolean checkSocket()
	{
		return socket.isConnected();
	}
	
	public void run()
	{
		/***************************************************************
		 * 
		 * 未完成
		 * 
		 ***************************************************************/
		try
		{
			while(true)
			{
				
				throw new PasswordTooShortException();
			}
			
		}
		catch(PasswordTooShortException re)
		{
			re.printStackTrace();
		}
	}
	
	public void registUser(String userName, String pass,int _type) throws IOException
	{
		User u = new User(userName,pass,_type);
		NewUser nu = new NewUser(u);
		uos.outPack(nu);
	}
	public void registUser(String userName, String pass,int _type,String field) throws IOException
	{
		User u = new User(userName,pass,_type,field);
		NewUser nu = new NewUser(u);
		uos.outPack(nu);
	}
	public void loginUser(String name,String pass) throws IOException
	{
		uos.outPack(new RequestPack(name,pass));	
		new Thread(inClientThread).start();
	}
	public void setUpUser(User _user)
	{
		Launcher.lif.setVisible(false);
		if(_user.getType()==0)
		{
			cf = new StudentFrame(this,_user);
			cf.setVisible(true);
			
		}	
		else if(_user.getType()==1)
		{
			cf = new TeacherFrame(this,_user);
			cf.setVisible(true);
			//TODO
		}
		else 
		{
			JOptionPane.showMessageDialog(Launcher.lif, "登录用户类型无法识别");
		}
	}
	public void reconnectToServer() throws IOException
	{
		new Thread(inClientThread).stop();
		socket.close();
		JOptionPane.showMessageDialog(Launcher.lif, "登录失败，账号或密码错误");
		
		socket = new Socket(ip,port);
		inClientThread = new InClientThread(socket,this);
	}
	public void sendOutPack(Object obj) throws IOException
	{
		uos.outPack(obj);
	}
	public void SetUpClientUI(ClientSetUpPack csup)
	{
		cf.SetUpClientUI(csup);
	}
	public void newMessage(TalkPack tp)
	{
		cf.newMessage(tp);
	}
	public void SetFields(QuestionMapPack fp)
	{
		cf.setUpQuestion(fp);;
	}
	
	public void setHomework(HomeworkPack hp)
	{
		cf.setHomework(hp);
	}
}
