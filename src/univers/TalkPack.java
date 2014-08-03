package univers;

import java.io.Serializable;

public class TalkPack implements Serializable
{
	private int getfrom;
	private int sendto;
	private String content;
	private long time;
	
	public TalkPack(int getfrom,int sendto,String content)
	{
		this.getfrom = getfrom;
		this.sendto = sendto;
		this.content = content;
	}
	public TalkPack(int getfrom,int sendto,String content,long time)
	{
		this.getfrom = getfrom;
		this.sendto = sendto;
		this.content = content;
		this.time = time;
		
	}
	public int getFrom()
	{
		return getfrom;
	}
	public int sendTo()
	{
		return sendto;
		
	}
	public String getContent()
	{
		return content;
	}
	public long getSendTime()
	{
		return time;
	}
	public String toString()
	{
		return "TalkPack";
	}
}
