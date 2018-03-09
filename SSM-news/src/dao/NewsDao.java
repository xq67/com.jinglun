package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.News_comment;
import entity.News_detail;

public interface NewsDao {
	//显示所有的新闻
	public List<News_detail>showAllNews(@Param("title")String title);
	//通过新闻id显示新闻下所有的评论
	public List<News_comment> showAllCommentById(@Param("id")int id);
	//增加评论
	public int addComment(News_comment nc);
	//删除新闻
	public int deleteNewsById(@Param("id")int id);
	//删除该条新闻下的评论
	public int deleteComment(@Param("id")int id);
}
