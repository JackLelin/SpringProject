package univers;

import java.io.Serializable;

public class Exercise implements Serializable
{
	private boolean[] answer = new boolean[4];
	private String[] choices = new String[4];
	private String title;
	private int credit;
	private String introduction;
	
	public Exercise(int _credit,String _introduction,String[] _choices,boolean[] _answer)
	{
		credit = _credit;
		answer = _answer;
		setChoices(_choices);
		setIntroduction(_introduction);
	}
	
	public Exercise(int _credit,String _introduction,String[] _choices,boolean[] _answer,String _title)
	{
		this(_credit,_introduction,_choices,_answer);
		title = _title;
	}
	
	public double getPoint(boolean[] chosen)
	{
		int point = 0;
		int trueNum = 0;
		for(int c=0;c<4;c++)
		{
			if(chosen[c]==answer[c])
			{
				if(answer[c]==true)
				{
					trueNum++;
				}
				point ++;
			}		
		}
		return point/trueNum*credit;
	}
	public String getIntroduction() 
	{
		return introduction;
	}
	
	public void setIntroduction(String introduction) 
	{
		this.introduction = introduction;
	}
	
	public String[] getChoices() 
	{
		return choices;
	}
	
	public void setChoices(String[] choices) 
	{
		this.choices = choices;
	}
	
	
	public boolean[] getAnswer()
	{
		return answer;
	}
	
	public void setAnswer(boolean[] answer)
	{
		this.answer = answer;
	}

	public String getTitle() 
	{
		return title;
	}
	public String toString()
	{
		return title;
	}
	
}
