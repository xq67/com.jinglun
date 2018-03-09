package biz;

import java.util.List;

import entity.News_detail;
import entity.News_comment;

public interface NewsBiz {
	//显示所有的新闻
	public List<News_detail> showAllNews(String title);
	//通过新闻id显示新闻下所有的评论
	public List<News_comment> showAllCommentById(int id);
	//增加评论
	public int addComment(News_comment nc);
	//删除新闻
	public int deleteNewsById(int id);
}
