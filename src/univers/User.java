package univers;



import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import projectException.PasswordTooShortException;
import projectException.UserNameTooLongException;

public class User implements Runnable , Serializable
{
	/**
	 * constant 部分
	 */
	final private static int STUDENTS = 0;
	final private static int TEACHERS = 1;
	final private static int ASSISTANT= 2;
	
	/**
	 * Field
	 */
	private String userName;
	private int userNumber;
	private int userType;
	private String userIcon = "Icon/02.png";
	private String field;
	private String password;
	/**
	 * 构造函数部分
	 * 
	 * @param _num
	 * @param _type
	 * @throws PasswordTooShortException 
	 */
	public User(String _name, int _num, int _type) throws PasswordTooShortException
	{
		userName = _name;
		userNumber = _num;
		userType = _type;
		field = "";
		
	}
	public User(String _name, String _pass, int _type)
	{
		long e = Long.valueOf("1000000000000");
		long t = (new Date().getTime()-e)/200;
		int i = (int)t;
		setPassword(_pass);
		userName = _name;
		userNumber = i;
		userType = _type;
	}
	
	public User(String _name,String _pass, int _type,String _field)
	{
		this(_name,_pass,_type);
		field = _field;
	}
	
	public User(String _name, int _num, int _type,String icon,String _pass,String _field) throws PasswordTooShortException
	{
		this(_name,_num,_type);
		
		setPassword(_pass);
		field = _field;
		userIcon = icon;
	}
	
	
	
	/**
	 * get,set function
	 */
	public int getUserNumber()
	{
		return userNumber;
	}
	
	public int getType()
	{
		return userType;
	}
	
	public boolean setUserName(String _name) throws UserNameTooLongException
	{	
		if(userName.length()<=20)
		{
			userName = _name;
			return true;
		}
		else
		{
			throw(new UserNameTooLongException());
		}
	}
	

	
	/**
	 * 答疑方面个重要函数
	 * 操作HashMap修改学生关注的问题
	 */
	

	
	
	public void run()
	{
		
	}

	
	public String toString()
	{
		return "User";
	}
	public String getUserName()
	{
		return userName;
	}
	public String getUserIcon() 
	{
		return userIcon;
	}
	public void setUserIcon(String userIcon) 
	{
		this.userIcon = userIcon;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}
