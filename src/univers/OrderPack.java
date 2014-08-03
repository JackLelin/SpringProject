package univers;

import java.io.Serializable;

public class OrderPack implements Serializable
{
	private int from;
	private String order;
	private int type;
	
	public static final int GETQUESTION  = 0;
	public static final int GETTHEHOMEWORK = 1;
	public static final int MYFOLLOWLIST = 2;
	public static final int GETSETUPINFO = 3;
	public static final int CHANGEICON   = 4;
	public static final int DELETQUESTION = 5;
	public static final int GETHOMEWORK = 6;
	
	public OrderPack(int _type ,int _from, String _order)
	{
		setType(_type);
		setFrom(_from);
		setOrder(_order);
	}
	public int getFrom() 
	{
		return from;
	}
	public void setFrom(int from) 
	{
		this.from = from;
	}
	public String getOrder() 
	{
		return order;
	}
	public void setOrder(String order) 
	{
		this.order = order;
	}
	public String toString()
	{
		return "OrderPack";
	}
	public int getType() 
	{
		return type;
	}
	public void setType(int type) 
	{
		this.type = type;
	}
}
