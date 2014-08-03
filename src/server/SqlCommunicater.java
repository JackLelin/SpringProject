package server;

import univers.Homework;
import univers.HomeworkInfo;
import univers.ProjectFileIO;
import univers.Question;
import univers.RequestPack;
import univers.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import projectException.PasswordTooShortException;

public class SqlCommunicater 
{
	private Statement stm;
	private Connection conn;
	
	
	public SqlCommunicater() throws SQLException, IOException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = getCommunicate();
		stm = conn.createStatement();
		creatTable();
		creatQuestionTable();
		creatHomeworkTable();
		setSafeMode();
	}
	/**
	 * 未完成。。。。
	 * 还需要添加关于查询操作的方法
	 * @throws SQLException 
	 * 
	 */
	
	public int updateQuestion(Question q) throws SQLException
	{
		
		int userId = q.getAuthorId();
		String content = q.getContent().toString();
		String field = q.getField();
		long queId = q.getQuestionId();
		String title = q.getTitle();
		String query = "select * from questionList where questionId = " + queId;
		ResultSet rs = stm.executeQuery(query);
		if(rs.next())
		{
			String state = "update questionList set questionTitle = '"+title+"' where questionId = "+queId;
			stm.executeUpdate(state);
			state = "update questionList set content = '"+content+"' where questionId = "+queId;
			stm.executeUpdate(state);
			return 99;
		}
		else
		{
			String state = "insert into questionList(questionId,questionTitle,questionField,content,authorId) values("+queId+",'"+title+"','"+field+"','"+content+"',"+userId+")";
			return stm.executeUpdate(state);
		}
		
		
	}
	
	public ArrayList<HomeworkInfo> getAllHomework() throws SQLException
	{
		String query = "select * from homeworkList";
		ResultSet result = stm.executeQuery(query);
		ArrayList<HomeworkInfo> hl = new ArrayList<HomeworkInfo>();
		while(result.next())
		{
			long   Id 		= Long.valueOf(result.getString(1));
			String title 	= result.getString(2);
			String field    = result.getString(3);
			HomeworkInfo hw = new HomeworkInfo(Id,field,title);
			hl.add(hw);
		}
		return hl;
	}
	
	public ArrayList<HomeworkInfo> getFieldHomework(String _field) throws NumberFormatException, SQLException
	{
		String query = "select * from homeworkList where homeworkField = '"+_field+"'";
		ResultSet result = stm.executeQuery(query);
		ArrayList<HomeworkInfo> hl = new ArrayList<HomeworkInfo>();
		while(result.next())
		{
			long   Id 		= Long.valueOf(result.getString(1));
			String title 	= result.getString(2);
			String field    = result.getString(3);
			HomeworkInfo hw = new HomeworkInfo(Id,field,title);
			hl.add(hw);
		}
		return hl;
	}
	
	public HashMap<Long,Question> getUserQuestion(int userId) throws NumberFormatException, SQLException
	{
		String queryState = "select * from questionList where authorId = "+userId;
		ResultSet rrrr = stm.executeQuery(queryState);
		HashMap<Long,Question> qm = new HashMap<Long,Question>();
		System.out.println("getUserQuestion调用");
		while(rrrr.next())
		{
			
			long   qId 		= Long.valueOf(rrrr.getString(1));
			String qtitle 	= rrrr.getString(2);
			String field    = rrrr.getString(3);
			StringBuffer content  = new StringBuffer(rrrr.getString(4));
			int    aId      = Integer.valueOf(rrrr.getString(5));
			System.out.println("\t"+qId+"\t"+qtitle+"\t"+aId);
			Question temp = new Question(qId,qtitle,field,content,aId);
			qm.put(qId, temp);
		}
		return qm;
	}
	
	public HashMap<Long,Question> getFieldQuestion(String _field) throws NumberFormatException, SQLException
	{
		System.out.println("getFieldQuestion调用");
		String queryState = "select * from questionList where questionField = '"+ _field +"';";
		ResultSet result = stm.executeQuery(queryState);
		HashMap<Long,Question> qm = new HashMap<Long,Question>();
		while(result.next())
		{
			long   qId 		= Long.valueOf(result.getString(1));
			String qtitle 	= result.getString(2);
			String field    = result.getString(3);
			StringBuffer content  = new StringBuffer(result.getString(4));
			int    aId      = Integer.valueOf(result.getString(5));
			System.out.println("\t"+qId+"\t"+qtitle+"\t"+aId);
			Question temp = new Question(qId,qtitle,field,content,aId);
			qm.put(qId, temp);
		}
		return qm;
	}
	
	public User logCheck(String name,String pass) throws SQLException, PasswordTooShortException, ClassNotFoundException, IOException
	{

		String searchstate = "select * from userList where userName = '"+ name+"'";	
	
		ResultSet result = stm.executeQuery(searchstate);		
  		if(result.next())
  		{
  			String uid   = result.getString(1);
  			String uname = result.getString(2);
  			String utype = result.getString(3);
  			String uicon = result.getString(4);
  			String upass = result.getString(5);
  			String ufql  = result.getString(6);
  		
  				
  			if(pass.equals(upass))
  			{
  				int tempid;
  				int temptype;
  				tempid = Integer.valueOf(uid);
  				temptype = Integer.valueOf(utype);	
  				String tempque = ufql;
  				
  				User user = new User(uname,tempid,temptype,uicon,pass,ufql);
  				
  				
  				return user;
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
	
	public User logCheck(RequestPack rp) throws SQLException, PasswordTooShortException, ClassNotFoundException, IOException
	{
		String name = rp.getName();
		String pass = rp.getPass();
		return logCheck(name,pass);
	}
	
	public int deleteQuestion(long l) throws SQLException
	{
		String state = "delete from questionList where questionId = "+l;
		int t = stm.executeUpdate(state);
		System.out.println(t);
		return t;
	}
	

	
	public int searchQuestionbyNumber(int num) throws SQLException
	{
		ResultSet result;
		String searchstate = "select * from Questions";
		result = queryDataBase(searchstate); 
		return 0;
	}
	
	public int changeUserIcon(User u, String icon) throws SQLException
	{
		String state;
		state = "Update userList set userIcon = '"+icon+"' where userNumb ="+ u.getUserNumber();
		return stm.executeUpdate(state);
	}
	
	public int addHomework(Homework h) throws SQLException
	{
		long id = h.getHomeworkId(); 
		String title = h.getTitle();
		String field = h.getField();
		String state ="insert into homeworkList(homeworkId,homeworkTitle,homeworkField) "
				+ "values ("+id+",'"+title+"','"+field+"'"
						+ ")";
		return stm.executeUpdate(state);
	}
	
	public Homework queryHomework(long hId) throws SQLException, ClassNotFoundException, IOException
	{
		String 	queryState = "select * from homeworkList where homeworkId = "+hId;
		ResultSet result = stm.executeQuery(queryState);
		return (Homework)ProjectFileIO.ReadProjectFile("HMWK/"+hId+".hmwk");
	}
	
	
	public int addNewUser (User user) throws SQLException, IOException
	{
		//questions是个String由于指向该用户储存followList的文件
		int number = user.getUserNumber();
		String username = user.getUserName();
		int type = user.getType();
		String userIcon = user.getUserIcon();
		String password = user.getPassword();
		String field = user.getField();
		
		String state;
		state = "insert into userList(userNumb,userName,userType,userIcon,userPass,questions) "
																+ "values ("+number+",'"
																  	       +username+"',"
																		   +type+",'"
																		   +userIcon+"','"
																		   +password+"','"
																		   +field+"')";
		
		
		return stm.executeUpdate(state);	
		
		
	}
	
	
	public void queryAllUser() throws SQLException
	{
		ResultSet result = stm.executeQuery("select * from userList");
		while (result.next())
		{
			System.out.print("\t"+result.getString(1));
			System.out.print("\t"+result.getString(2));
			System.out.print("\t"+result.getString(3));
			System.out.print("\t"+result.getString(4));
			System.out.print("\t"+result.getString(5));
			System.out.print("\t"+result.getString(6)+"\n");
			
		}	
	}
	public void queryAllQuestion() throws SQLException
	{
		ResultSet result = stm.executeQuery("select * from questionList");
		while (result.next())
		{
			System.out.print("\t"+result.getString(1));
			System.out.print("\t"+result.getString(2));
			System.out.print("\t"+result.getString(3));
			System.out.print("\t"+result.getString(4));
			System.out.print("\t"+result.getString(5)+"\n");
			
		}
	}

	
	
	public int creatTable() throws SQLException
	{
		String state = "create table if not exists userList("
				
				+ "userNumb int     ,"
				+ "userName char(20)   ,"
				+ "userType int        ,"
				+ "userIcon char(15)    ,"
				+ "userPass char(20)   ,"
				+ "questions char(30))  ;";
		
		return stm.executeUpdate(state);
	}
	public int creatQuestionTable() throws SQLException
	{
		String state = "create table if not exists questionList("
				
				+ "questionId    bigint    ,"
				+ "questionTitle char(200) ,"
				+ "questionField char(20)  ,"
				+ "content       text(3000),"
				+ "authorId      int       ) ;";
		return stm.executeUpdate(state);
	}
	
	public int setSafeMode() throws SQLException
	{
		String mode = "SET SQL_SAFE_UPDATES=0;";
		return stm.executeUpdate(mode);
	}
	
	public int creatHomeworkTable() throws SQLException
	{
		String state = "create table if not exists homeworkList("
				+ "homeworkId     bigint  ,"
				+ "homeworkTitle   char(50),"
				+ "homeworkField  char(50))";
		return stm.executeUpdate(state);
	}
	
	
	
	public void disConnect() throws SQLException
	{
		stm.close();
		conn.close();	
	}
	
 

	
	
	/**
	 * private 方法部分
	 * 
	 */
	
	//对数据库进行查询操作
	private ResultSet queryDataBase(String ope) throws SQLException
	{
		ResultSet rs = stm.executeQuery(ope);
		rs.close();
		return  rs;
	}
	//对数据库进行修改操作
	private int operatDataBase(String m) throws SQLException
	{
		int count = stm.executeUpdate(m);
		return count;
	}
	
	
	/*
	 * 根据getCommunicate方法获取Connection和数据库进行链接
	 * 
	 */
	private static Connection getCommunicate() throws SQLException, IOException 
	{
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("database.properties");
		props.load(in);
		in.close();

		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null)
		{
			System.setProperty("jdbc.drivers", drivers);
		}
		
		String url = props.getProperty("jdbc.url");
		String DBName = props.getProperty("jdbc.dbname");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		String intro = props.getProperty("jdbc.intro");
		return DriverManager.getConnection(url + DBName+intro, username, password);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 仅在test阶段使用的方法
	 * 
	 * upudate 和 query
	 * @throws IOException 
	 * @throws SQLException 
	 */
//	
//	void userSaveQuestion(String route) throws IOException
//	{
//		HashMap<Long,String> tl = new HashMap<Long,String>();
//    	tl.put((long) 123456, "天安门坦克人");
//    	ProjectFileIO.WriteProjectFile(route, tl);
//	}
//	
//	int create() throws SQLException
//	{
//		String state = "create table if not exists test("
//				
//				+ "userNumb bigint,"
//				+ "userName char(20),"
//				+ "userType int,"
//				+ "userIcon char(5),"
//				+ "password char(20),"
//				+ "questions char(30))";
//		return stm.executeUpdate(state);
//	}
//	int update(String name,String password) throws SQLException
//	{
//		//questions是个String由于指向该用户储存followList的文件
//		long number = (new Date()).getTime();
//		String state;
//		state = "insert into test(number,name,password,questions) values("+number+",'"+name+"','"+password+"','userQL/"+number+".ql')";
//		return stm.executeUpdate(state);
//		
//	}
//	boolean droptesttable() throws SQLException
//	{
//		String state;
//		state = "drop table 'testing'.'test'";
//		return stm.execute(state);
//	}
//	ResultSet query() throws SQLException
//	{
//		return stm.executeQuery(
//				"select * "
//				+ "from test"
//						);
//	}
//	ResultSet query(String s) throws SQLException
//	{
//		return stm.executeQuery(
//				"select * "+ "from test where name = '"+s+"'"	);
//	}
//	
//	String queryByName(String name) throws SQLException
//	{
//		ResultSet result;
//		String state;
//		state ="select name from test where name = "+name;
//		result =stm.executeQuery(state);
//		result.close();
//		result = null;
//		return result.getString(1);
//	}
//	
}
