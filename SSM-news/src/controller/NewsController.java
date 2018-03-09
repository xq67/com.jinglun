package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import biz.NewsBiz;
import entity.News_comment;
import entity.News_detail;

@Controller
public class NewsController {
	@Resource
	private NewsBiz newsBiz;
	
	@RequestMapping("/show")
	public String goindex(){
		System.out.println("进入新闻主页，并显示所有新闻");
		return "index";
	}
	
	@RequestMapping(value="showAllNews.do",produces={"text/html;charset=UTF-8"})
	@ResponseBody
	public String showAll(HttpServletRequest request){
		System.out.println("进入显示新闻的方法");
		String title=request.getParameter("title");
		if(title!=null){
			try {
				title=new String(title.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<News_detail>list=newsBiz.showAllNews(title);
		String mes=JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss",
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty
			);
		System.out.println(mes);
		return mes;
	}
	
	@RequestMapping(value="showAllComment.do/{id}",produces={"text/html;charset=UTF-8"})
	@ResponseBody
	public String showAllComment(@PathVariable("id")String id){
		System.out.println("进入显示评论的方法");
		int nid=Integer.parseInt(id);
		List<News_comment>list=newsBiz.showAllCommentById(nid);
		String mes=JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss",
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty
			);
		System.out.println(mes);
		return mes;
	}
	
	@RequestMapping("deleteNews.do")
	public void deleteNews(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入删除新闻方法");
		PrintWriter out;
		try {
			out = response.getWriter();
			String sid= request.getParameter("id");
			int id=Integer.parseInt(sid);
			int mes=newsBiz.deleteNewsById(id);
			System.out.println("删除news的执行结果"+mes);
			out.print(mes); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/addComment.do")
	public String addComment(String content,String author,int id){
		System.out.println("进入添加评论方法");
		News_comment nc=new News_comment();
		try {
			if(author==null||author==""){
				author=null;
			}
			if(author!=null){
				author=new String(author.getBytes("ISO-8859-1"),"utf-8");
			}
			content=new String(content.getBytes("ISO-8859-1"),"utf-8");
			nc.setAuthor(author);
			nc.setContent(content);
			nc.setNewsid(id);
			newsBiz.addComment(nc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
		
	}
}
