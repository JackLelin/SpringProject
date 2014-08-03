package univers;

import projectException.PasswordTooShortException;

public class Password 
{
	
	private String password;
	private boolean hasset = false;
	
	public Password(String pass) throws PasswordTooShortException
	{
		setPassword(pass);
	}
	
	public boolean setPassword(String pass) throws PasswordTooShortException
	{
		if(hasset == true)
		{
			if(pass.length()<=6)
			{
				throw(new PasswordTooShortException());
			}
			else
			{
				password = pass;
				return true;
			}
		}
		else
		{
			if(pass.length()<=6)
			{
				throw(new PasswordTooShortException());
			}
			else
			{
				password = pass;
				return true;
			}
		}
	}
	public boolean askPassword(String pass)
	{
		if(pass.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
