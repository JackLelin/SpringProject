package univers;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author JackLelin
 *
 */

//unfinished
public class Question implements Serializable
{
	private long questionId;
	private String title;
	private String field;
	private StringBuffer content;
	
	private int AuthorId;
	private String AuthorName;
	
	public Question(String _title,String _field,StringBuffer _content, int _AuthorId)
	{
		title = _title;
		field = _field;
		content = _content;
		AuthorId = _AuthorId;
		/**
		 * 这里还有一个给AutherName的方法没有写
		 */
		DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
        String s = format2.format(new Date());
        questionId = Long.valueOf(s);
	}
	public Question(long questionId, String title,String field,StringBuffer content, int AuthorId)
	{
		this(title,field,content,AuthorId);
		this.questionId = questionId;
	}
	/**
	 *get 和 set 方法
	 *
	 * @return
	 */
	public long getQuestionId() 
	{
		return questionId;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String t)
	{
		title = t;
	}
	public StringBuffer getContent() 
	{
		return content;
	}
	public void setContent(StringBuffer sb)
	{
		content = sb;
	}
	
	public int getAuthorId() 
	{
		return AuthorId;
	}

	public String getAuthorName() 
	{
		return AuthorName;
	}
	public String toString()
	{
		return "Question";
	}
	public String getField() {
		return field;
	}
	
//	public void setAuthorName(String authorName) 
//	{
//		AuthorName = authorName;
//	}
	
	
}
