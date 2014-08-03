package univers;

import java.io.Serializable;

public class RequestPack implements Serializable
{
	private String pass;
	private String name;
	
	public RequestPack(String na,String pa)
	{
		name = na;
		pass = pa;
	}
	public String getName()
	{
		return name;
	}
	public String getPass()
	{
		return pass;
	}
	public String toString()
	{
		return "RequestPack";
	}
}
