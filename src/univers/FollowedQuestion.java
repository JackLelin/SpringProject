package univers;

import java.io.Serializable;
import java.util.HashMap;

public class FollowedQuestion implements Serializable
{
	HashMap<Long, String> questions = new HashMap<Long,String>();

	public FollowedQuestion(HashMap<Long,String> a)
	{
		questions =a;
	}
	public HashMap<Long,String> getFollowList()
	{
		return questions;
	}
	public void followQuestion(Question question)
	{
		questions.put(question.getQuestionId(), question.getTitle());
	}
	public void followQuestion(Long qid, String qt)
	{
		questions.put(qid,qt);
	}
	public void unFollowQuestion(Question question)
	{
		questions.remove(question.getQuestionId());
	}
	public void unFollowQuestion(Long qid, String qt)
	{
		questions.remove(qid);
	}
//	int i = 0;
//	public void addFollowedQuestion(int num)
//	{
//		//用于压缩数组，防止部分数组由于用户取消关注产生大量0
//		//用户每当关注数量达到50时清理一次
//		if(i%50==0)
//		{
//			int t0 =0;
//			int[] compack = new int[questions.length];
//			int t = 0;
//			for( t=0;t<questions.length;t++)
//			{
//				if(questions[t]==0)
//				{
//					t0++;
//				}
//				else
//				{
//					compack[t-t0]=questions[t];
//				}
//			}
//			questions = compack;
//			i=t-t0;
//			compack = null;
//		}
//		//当数组发生越界的时候产生一个新的数组来存储旧数组的元素
//		if(i<questions.length)
//		{
//			questions[i] = num;
//			i++;
//		}
//		else
//		{
//			int[] newquestions = new int[i+50];
//			for(int counter = 0;counter<=i;counter++)
//			{
//				newquestions[counter] = questions[counter];
//				questions = newquestions;
//				newquestions = null;
//				i++;
//			}
//		}
//	}
}
