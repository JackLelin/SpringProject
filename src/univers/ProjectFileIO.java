package univers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProjectFileIO 
{
//	public static void main(String[] arg)
//	{
//		String[] acg = {"Math","Java","English","Physics","Biology"};
//		ArrayList<String> al = new ArrayList<String>();
//		for(String s : acg)
//		{
//			al.add(s);
//		}
//		try {
//			WriteProjectFile("fields.list",al);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public static Object ReadProjectFile(String route) throws IOException, ClassNotFoundException
	{
		File file =new File(route);
		System.out.println(route+" exist "+file.exists());
		if(file.exists())
		{
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Object obj = ois.readObject();
			ois.close();
			bis.close();
			fis.close();
			return obj;
		}
		else
		{
			return null;
		}
		
	}
	public static void WriteProjectFile(String route,Object obj) throws IOException
	{
		File file = new File(route);

		if(file.exists())
		{
			file.delete();
			WriteProjectFile(route,obj);
		}
		else
		{
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bos.flush();
			oos.close();
			bos.close();
			fos.close();
		}

		
	}
}
