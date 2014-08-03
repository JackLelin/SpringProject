package server;

import java.io.IOException;
import java.sql.SQLException;

public class BDTest 
{
	private static SqlCommunicater sqc;
	public static void main(String[] sv)
	{
		try 
		{
			sqc = new SqlCommunicater();
			sqc.getUserQuestion(1);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		};
	}
}
