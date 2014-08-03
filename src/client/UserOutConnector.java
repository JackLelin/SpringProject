package client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import univers.Question;
import univers.RequestPack;
import univers.TalkPack;

public class UserOutConnector
{
	private Socket socket;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;
	public UserOutConnector(Socket sok)
	{
		socket = sok;
	}
	
	
	public void request(RequestPack rp) throws IOException
	{
		
		bos = new BufferedOutputStream(socket.getOutputStream());
		oos = new ObjectOutputStream(bos);
		oos.writeObject(rp);
		
	}
	
	public void communicateOutPack(TalkPack pack) throws IOException
	{
		bos = new BufferedOutputStream(socket.getOutputStream());
		oos = new ObjectOutputStream(bos);
		oos.writeObject(pack);		
	}
	public void communivateOutPack(Question pack) throws IOException
	{
		bos = new BufferedOutputStream(socket.getOutputStream());
		oos = new ObjectOutputStream(bos);
		oos.writeObject(pack);
	}
	public void outPack(Object obj) throws IOException
	{
		bos = new BufferedOutputStream(socket.getOutputStream());
		oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		System.out.println(obj.toString()+"包 发送出去");
		oos.flush();
		bos.flush();
	}
	/**
	 * 这一段写错了暂时不删除了
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *
	public TalkPack communicateInTalk() throws IOException, ClassNotFoundException
	{
		InputStream inst;
		ObjectInputStream talkin;
		BufferedInputStream bfin;
		
		inst = sok.getInputStream();
		bfin = new BufferedInputStream(inst);
		talkin = new ObjectInputStream(bfin);
		TalkPack tp = (TalkPack)talkin.readObject();
		
		inst.close();
		bfin.close();
		talkin.close();
		return tp;
	}
	public Question communicateInQuestion() throws IOException, ClassNotFoundException
	{
		InputStream inst;
		ObjectInputStream ois;
		BufferedInputStream bfin;
		inst = sok.getInputStream();
		bfin = new BufferedInputStream(inst);
		ois = new ObjectInputStream(bfin);
		Object obj = ois.readObject();
		Question question = (Question)obj;
		
		inst.close();
		bfin.close();
		ois.close();
		return question;
	}
	
	public void ShutDownCommunicate() throws IOException
	{
		
		sok.close();
	}
	*/
	
}
