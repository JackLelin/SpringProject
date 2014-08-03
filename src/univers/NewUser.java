package univers;

import java.io.Serializable;

public class NewUser implements Serializable
{
	private User user = null;
	public NewUser(User s)
	{
		setU(s);
	}
	public User getU() {
		return user;
	}
	public void setU(User u) {
		this.user = u;
	}
	public String toString()
	{
		return "NewUser";
	}
}

