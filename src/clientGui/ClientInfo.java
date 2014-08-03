package clientGui;

import java.io.Serializable;

public class ClientInfo implements Serializable
{
	private String userName;
	private String userPass;
	private String serverIP;
	public ClientInfo(String name,String pass,String ip)
	{
		userName = name;
		userPass = pass;
		serverIP = ip;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getUserPass()
	{
		return userPass;
	}
	public String getServerIP()
	{
		return serverIP;
	}
}
