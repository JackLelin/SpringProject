package univers;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeworkPack implements Serializable
{
	ArrayList<HomeworkInfo> homeworkPack;
	public HomeworkPack(ArrayList<HomeworkInfo> h)
	{
		homeworkPack = h;
	}
	public ArrayList<HomeworkInfo> getHomeworkPack()
	{
		return homeworkPack;
	}
	public String toString()
	{
		return "HomeworkPack";
	}
}
