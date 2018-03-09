package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.News_comment;
import entity.News_detail;

public interface NewsDao {
	//��ʾ���е�����
	public List<News_detail>showAllNews(@Param("title")String title);
	//ͨ������id��ʾ���������е�����
	public List<News_comment> showAllCommentById(@Param("id")int id);
	//��������
	public int addComment(News_comment nc);
	//ɾ������
	public int deleteNewsById(@Param("id")int id);
	//ɾ�����������µ�����
	public int deleteComment(@Param("id")int id);
}
