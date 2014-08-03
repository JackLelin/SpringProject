package clientGui;

import univers.ClientSetUpPack;
import univers.QuestionMapPack;
import univers.TalkPack;
import univers.HomeworkPack;

public interface ClientFrame 
{
	public void SetUpClientUI(ClientSetUpPack csup);
	
	public void setVisible(boolean b);
	
	public void newMessage(TalkPack tp);

	public void setUpQuestion(QuestionMapPack fp);
	
	public void setIcon(String icon);
	
	public void setHomework(HomeworkPack hp);
}
