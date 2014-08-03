package serverNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Date;

import server.ServerMain;
import univers.ClientSetUpPack;
import univers.Homework;
import univers.HomeworkPack;
import univers.OrderPack;
import univers.Question;
import univers.QuestionMapPack;
import univers.TalkPack;

public class ServerThread implements Runnable
{
	private final Socket socket;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int hostId;
	
	public ServerThread(Socket s,int id)
	{
		socket = s;
		hostId = id;
	}
        @Override
	public void run()
	{
            try 
            {
            	
            	SendOutpack(new ClientSetUpPack(ServerMain.IconMap,ServerMain.NameMap));
            	
                while(true)
                {
                	bis = new BufferedInputStream(socket.getInputStream());
                	ois = new ObjectInputStream(bis);
                	if(bis.available()!=0)
                	{
                		 Object obj = ois.readObject();
                		 System.out.println("收到包裹"+obj.toString());
                         switch(obj.toString())
                         {
                         	case "RequestPack":
                         	{
                         		System.out.println("接受到错误包");
                         		break;
                         	}
                         	case "OrderPack":
                         	{
                         		OrderPack op = (OrderPack)obj;
                         		processOrder(op);
                         		break;
                         	}
                         	case "Question":
                         	{
                         		processQuestion(obj) ;
                         		break;
                         	}
                         	case "NewUser":
                         	{
                         		
                         		break;
                         	}
                         	case "TalkPack":
                         	{
                         		TalkPack tp = (TalkPack)obj;
                         		processTalk(tp);
                         		break;
                         	}
                         	case "Homework":
                         	{
                         		Homework h = (Homework)obj; 
                         		processHomework(h);
                         		break;
                         	}
                         	case "":
                         	{
                         		break;
                         	}
                        	/******************************************************************
                        	 * unfinished
                        	 * 这里的function用于将接受的的pack分类
                        	 * 分类之后处理
                        	 * 
                        	 * 
                        	 ******************************************************************/
                     	}
                	}
                }
            } 
            catch (ClassNotFoundException|IOException ex) 
            {
                stopSocket();
                ex.printStackTrace();
            } 
            catch (NumberFormatException e) {
				e.printStackTrace();
			} 
            catch (SQLException e) {
				e.printStackTrace();
			} 
	}
        
        
    private void processHomework(Homework h)
    {
    	try 
    	{
			ServerMain.addHomework(h);
		} 
    	catch (SQLException | IOException e) 
    	{
			e.printStackTrace();
		}
    }
        
    private void processOrder(OrderPack op) throws NumberFormatException, SQLException, ClassNotFoundException, IOException
    {
    	int type = op.getType();
    	switch(type)
    	{
    	/**
    	 * 还没有完成
    	 */
	    	case 0:
	    	{
	    		if(op.getOrder().equals("byauthor"))
	    		{
		    		SendOutpack(new QuestionMapPack(ServerMain.getUserQuestion(op.getFrom())));
	    			System.out.println(op.getFrom());
	    		}
	    		else
	    		{
	    			
	    			SendOutpack(new QuestionMapPack(ServerMain.getFieldQuestion(op.getOrder())));
	    			
	    		}
	    		break;
	    		
	    	}
	    	case 1:
	    	{
	    		long l = Long.valueOf(op.getOrder());
	    		SendOutpack(ServerMain.getHomework(l));
	    		break;
	    	}
			case 3:
			{
				SendOutpack(new ClientSetUpPack(ServerMain.IconMap,ServerMain.NameMap));			
				break;
			}
			case 4:
			{
				String icon = op.getOrder();
				int userNum = op.getFrom();
				ServerMain.changeIcon(userNum,icon);
				break;
			}
			case 5:
			{
				long l = Long.valueOf(op.getOrder());
				ServerMain.deleteQuestion(l);
				break;
			}
			case 6:
			{
				if(op.getOrder().equals("all"))
	    		{
		    		SendOutpack(new HomeworkPack(ServerMain.getAllHomework()));
	    		}
	    		else
	    		{
	    			SendOutpack(new HomeworkPack(ServerMain.getFieldHomework(op.getOrder())));
	    		}
				break;
			}

    	}
    }
    
    private void processTalk(TalkPack tp) throws IOException
    {

    		int to;
        	to = tp.sendTo();
        	ServerThread st = (ServerMain.sc.ServerThreadMap).get(to);
        	st.SendOutpack(tp);

    }
    
    public void SendOutpack(Object obj)
    {
    	try
    	{
    		System.out.println(obj.toString() +" 被发出了");
        	bos = new BufferedOutputStream(socket.getOutputStream());
        	oos = new ObjectOutputStream(bos);
        	oos.writeObject(obj);
        	oos.flush();
        	bos.flush();
    	}
    	catch(IOException e)
    	{
    		stopSocket();
    		e.printStackTrace();
    	}
    		
    }
    
    public void processQuestion(Object obj) throws SQLException
    {
    	Question q = (Question)obj;
    	ServerMain.updateQuestion(q);
    }
    
    public void socketCheck()
    {
    	
    	try {
    		bos = new BufferedOutputStream(socket.getOutputStream());
			oos = new ObjectOutputStream(bos);
			oos.writeObject(new String(""));
	    	oos.flush();
	    	bos.flush();
		} 
    	catch (IOException e) {
    		stopSocket();
    		e.printStackTrace();
		}
    }
    private void stopSocket()
    {
    	ServerMain.IconMap.remove(hostId);
		ServerMain.UserMap.remove(hostId);
		ServerMain.sc.ServerThreadMap.remove(hostId);
    }
}
