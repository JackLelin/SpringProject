package univers;

import java.io.Serializable;

public class ServerQueryError implements Serializable
{
	public static int LOGINFAIL = 0;
	private int type = 9999;
	public ServerQueryError(int _type)
	{
		setType(_type);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String toString()
	{
		return "ServerQueryError";
	}
}
