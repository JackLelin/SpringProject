package clientGui;

public class questionInTree 
{
	private Long qn;
	private String qt;
	public questionInTree(Long num,String t)
	{
		qn = num;
		qt = t;
	}
	public String toString()
	{
		return qt;
	}
}
