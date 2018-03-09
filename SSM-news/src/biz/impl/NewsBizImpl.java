package biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import biz.NewsBiz;
import dao.NewsDao;
import entity.News_comment;
import entity.News_detail;
@Service
public class NewsBizImpl implements NewsBiz{
	@Resource
	private NewsDao newsDao;
	@Override
	public List<News_detail> showAllNews(String title) {
		List<News_detail>list=newsDao.showAllNews(title);
		return list;
	}
	@Override
	public List<News_comment> showAllCommentById(int id) {
		List<News_comment>list=newsDao.showAllCommentById(id);
		return list;
	}
	@Override
	public int addComment(News_comment nc) {
		return newsDao.addComment(nc);
	}
	@Override
	/**
	 * 删除新闻,先删除该新闻下的所有评论
	 */
	public int deleteNewsById(int id) {
		newsDao.deleteComment(id);
		return newsDao.deleteNewsById(id);
	}
	
}
