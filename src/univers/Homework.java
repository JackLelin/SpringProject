package univers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Homework implements Serializable
{
	private String title;
	private ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
	private String field;
	private long homeworkId;
	
	public Homework(String _category,String _title)
	{
		homeworkId = new Date().getTime();
		setField(_category);
		title = _title;
	}
	
	public Homework(String _category,String _title,long id)
	{
		this(_category,_title);
		homeworkId = id;
	}
	
	public Homework(String _category,String _title,long id,ArrayList<Exercise> list)
	{
		homeworkId = new Date().getTime();
		setField(_category);
		title = _title;
		exerciseList=list;
	}
	
	public void addExersice(Exercise ex)
	{
		exerciseList.add(ex);
	}
	
	public String getField() 
	{
		return field;
	}
	public void setField(String category) 
	{
		this.field = category;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public ArrayList<Exercise> getExerciseList()
	{
		return exerciseList;
	}

	public long getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(long homeworkId) {
		this.homeworkId = homeworkId;
	}
	public String toString()
	{
		return "Homework";
	}
}
