package projectException;

public class UserNameTooLongException extends Exception
{
	public UserNameTooLongException()
	{
		super();
	}
	public UserNameTooLongException(String msg)
	{
		super(msg);
	}


}
