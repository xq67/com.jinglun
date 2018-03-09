package biz;

import java.util.List;

import entity.News_detail;
import entity.News_comment;

public interface NewsBiz {
	//��ʾ���е�����
	public List<News_detail> showAllNews(String title);
	//ͨ������id��ʾ���������е�����
	public List<News_comment> showAllCommentById(int id);
	//��������
	public int addComment(News_comment nc);
	//ɾ������
	public int deleteNewsById(int id);
}
