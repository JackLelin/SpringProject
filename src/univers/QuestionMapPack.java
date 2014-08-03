package univers;

import java.io.Serializable;
import java.util.HashMap;

public class QuestionMapPack implements Serializable
{
	private HashMap<Long,Question> qmp;
	public QuestionMapPack(HashMap<Long,Question> _qmp)
	{
		qmp = _qmp;
	}
	public HashMap<Long,Question> getQmp() 
	{
		return qmp;
	}
	public void setQmp(HashMap<Long,Question> qmp) 
	{
		this.qmp = qmp;
	}
	public String toString()
	{
		return "QuestionMapPack";
 	}
}
