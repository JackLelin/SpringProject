package projectException;

public class PasswordTooShortException extends PasswordException
{

	public PasswordTooShortException()
	{
		super();
	}
	public PasswordTooShortException(String mess)
	{
		super(mess);
	}
}
