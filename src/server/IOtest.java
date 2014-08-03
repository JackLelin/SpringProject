package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import univers.RequestPack;

public class IOtest 
{
	public static void main(String[] arg) throws IOException, ClassNotFoundException
	{
		write();
		read();
	}
	public static void read() throws ClassNotFoundException, IOException
	{
		File file = new File("test.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bif = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bif);
		Object obj = ois.readObject();
//		System.out.println(obj.toString());
		if(obj.toString().equals("RequestPack"))
		{
			RequestPack rp = (RequestPack)obj;
			System.out.print(rp.getPass());
		}
		ois.close();
		bif.close();
		fis.close();
	}
	public static void write() throws IOException
	{
		File file = new File("test.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		RequestPack rp = new RequestPack("123","123");
		oos.writeObject(rp);
		bos.flush();
		oos.close();
		bos.close();
		fos.close();
		
	}

}
