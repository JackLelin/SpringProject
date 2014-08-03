package univers;

import java.io.Serializable;

public class HomeworkInfo implements Serializable
{
	private String title;
	private long num;
	private String field;
	public HomeworkInfo(long _num,String _title,String _field)
	{
		num = _num;
		title = _title;
		field = _field;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String toString()
	{
		return title;
	}
}
