package server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import projectException.PasswordTooShortException;
import serverNet.ServerConnector;
import univers.Homework;
import univers.HomeworkInfo;
import univers.ProjectFileIO;
import univers.Question;
import univers.User;

public class ServerMain 
{
	public static HashMap<Integer,User> UserMap = new HashMap<Integer,User>();
	public static HashMap<Integer,String> IconMap = new HashMap<Integer,String>();
	public static HashMap<Integer,String> NameMap = new HashMap<Integer,String>();
	public static ServerConnector sc;
	private static SqlCommunicater sqc;
	private static int port;
	
	public ServerMain(int p) throws ClassNotFoundException, SQLException, IOException
	{
			port = p;
			sqc = new SqlCommunicater();
			sc = new ServerConnector(port);
			new Thread(sc).start();	
	}
	public static User logUserIn(String name, String pass) throws SQLException, PasswordTooShortException, ClassNotFoundException, IOException
	{
		User usr = sqc.logCheck(name, pass);
		if(usr!=null)
		{ 
			if(UserMap.get(usr.getUserNumber())==null)
			{ 
				UserMap.put(usr.getUserNumber(), usr);
				IconMap.put(usr.getUserNumber(), usr.getUserIcon());
				NameMap.put(usr.getUserNumber(), usr.getUserName());
				return usr;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
		
	}
	public static void newUser(User u) throws SQLException, IOException
	{
		sqc.addNewUser(u);	
	}

	public static HashMap<Long,Question> getUserQuestion(int userId) throws NumberFormatException, SQLException
	{
		HashMap<Long,Question> qm = sqc.getUserQuestion(userId);
		return qm;
	}
	
	public static HashMap<Long,Question> getFieldQuestion(String field) throws NumberFormatException, SQLException
	{
		HashMap<Long,Question> qm = sqc.getFieldQuestion(field);
		return qm;
	}
	
	public static void updateQuestion(Question q) throws SQLException
	{
		sqc.updateQuestion(q);
	}
	
	public static void deleteQuestion(long l) throws SQLException
	{
		sqc.deleteQuestion(l);
	}
	
	public static void changeIcon(int userNum,String icon) throws SQLException
	{
		User tu = UserMap.get(userNum);
		tu.setUserIcon(icon);
		IconMap.remove(userNum);
		IconMap.put(userNum, icon);
		sqc.changeUserIcon(tu,icon);
		
	}
	public static void addHomework(Homework h) throws SQLException, IOException
	{
		sqc.addHomework(h);
		ProjectFileIO.WriteProjectFile("HMWK/"+h.getHomeworkId()+".hmwk",h);
	}
	
	public static Homework getHomework(long q) throws ClassNotFoundException, SQLException, IOException
	{
		return sqc.queryHomework(q);
	}
	
	public static ArrayList<HomeworkInfo> getAllHomework() throws SQLException
	{
		return sqc.getAllHomework();
	}
	public static ArrayList<HomeworkInfo> getFieldHomework(String field) throws NumberFormatException, SQLException
	{
		return sqc.getFieldHomework(field);
	}
}
