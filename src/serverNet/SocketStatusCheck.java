package serverNet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SocketStatusCheck implements Runnable
{
	
	HashMap<Integer,ServerThread> ServerThreadMap;
	public SocketStatusCheck(HashMap<Integer,ServerThread> stm)
	{
		ServerThreadMap = stm;
	}
	public void run()
	{
		long timeInterval = new Date().getTime();
		while(true)
		{
			if(timeInterval-new Date().getTime()<1000)
			{
				ArrayList<Integer> keyset = new ArrayList(ServerThreadMap.keySet());
				for(int i : keyset)
				{
					ServerThreadMap.get(i).socketCheck();
				}
				timeInterval = new Date().getTime();
			}
			
		}
	}
}
