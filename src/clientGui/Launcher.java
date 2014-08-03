package clientGui;


public class Launcher 
{
	public static LoginFrame lif;
	
	public static void main(String arg[])
	{	
		lif = new LoginFrame();
		lif.setLocationRelativeTo(null);
		lif.setVisible(true);
	}	
	
}
