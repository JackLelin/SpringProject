package client;

import univers.Question;

public class EditQuestion 
{
	private int questionId;
	private StringBuffer title;
	private StringBuffer intro;
	private StringBuffer content;
	
	private int AuthorId;
	private String AuthorName;
	
	public EditQuestion(EditQuestion questpack)
	{
		this.questionId = questpack.questionId;
		this.title = questpack.title;
		this.intro = questpack.intro;
		this.content = questpack.content;
	}
	public EditQuestion(int _authorId , String _authorName)
	{
		AuthorId = _authorId;
		AuthorName = _authorName;
	}
	
	public Question generateQuestion()
	{
		return null;
	}
	
}
