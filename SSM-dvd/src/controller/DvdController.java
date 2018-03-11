package controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import Biz.DvdBiz;
import entity.Page;


@Controller
public class DvdController {
	@Resource(name="dvdBiz")
	private DvdBiz dvdBiz;
	
	@RequestMapping("show")
	public String show(){
		return "index";
	}
	
	@RequestMapping(value="Dvdshow.do",produces={"text/html;charset=UTF-8"})
	@ResponseBody  //返回到body
	public String showAllDvd(HttpServletRequest request){
		System.out.println("显示所有的Dvd系统主页");
		String mes=null;
		try {
			String pno=request.getParameter("pno");
			String name=request.getParameter("name");
			if(name!=null){
				name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			}
			int p=1;
			if(pno!=null){
				 p=Integer.parseInt(pno);	
			}
			Page page= dvdBiz.getPageshow(p, name);
			mes=JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd HH:mm:ss",
					SerializerFeature.WriteDateUseDateFormat,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullListAsEmpty,
					SerializerFeature.WriteNullStringAsEmpty
				);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(mes);
		return mes;
	}
	
	@RequestMapping("addDvd.do")
	@ResponseBody  //返回到body
	public String add(HttpServletRequest request){
		System.out.println("添加DVD");
		String mes=null;
		try {
			String name= request.getParameter("name");
			if(name!=null){
				name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			}
			mes=dvdBiz.addDvd(name)+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mes;
	}
	@RequestMapping("deleteDvd.do")
	public void delete(HttpServletRequest request,HttpServletResponse response){
		System.out.println("删除DVD");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		try {
			PrintWriter out = response.getWriter();
			int mes=dvdBiz.delDvd(id);
			out.print(mes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("updateDvd.do")
	@ResponseBody
	public String update(HttpServletRequest request){
		System.out.println("修改DVD");
		String mes=null;
		try {
			String name= request.getParameter("name");
			System.out.println(name);
			if(name!=null){
				name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			}
			System.out.println(name);
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			mes=dvdBiz.updateDvd(id, name)+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mes;
	}
	
	@RequestMapping("lendDvd.do")
	@ResponseBody
	public String lendDvd(HttpServletRequest request){
		System.out.println("租借DVD");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String mes=dvdBiz.lendDvd(id)+"";
		return mes;
	}
	
	@RequestMapping("returnDvd.do")
	@ResponseBody
	public String returnDvd(HttpServletRequest request){
		System.out.println("返还DVD");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String mes=dvdBiz.returnDvd(id)+"";
		return mes;
	}
	

	
}
