<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		tr:nth-child(even){
			background:#74BCD4;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  </head>
  <body>
  	<script type="text/javascript">
  	$(function(){
  		$.getJSON("showAllNews.do",succ);
  		$("input[name='search']").click(function(){
  			var title=$("input[name='title']").val().trim();
  			$.getJSON("showAllNews.do",{"title":title},succ);
  		});
  		$("tbody").on("click","tr td a[name='del']",function(){
  			id=$(this).attr("date");
  			var flag=confirm("确认要删除新闻吗？");
  			if(flag){
  				$.getJSON("deleteNews.do",{"id":id},function(mes){
	  				if(mes==1){
	  					alert("删除成功！")
	  					location.reload();//刷新当前页
	  				}else{
	  					alert("删除失败！")
	  				}
	  			});
  			}
  			
  		});
  		
  	});
  	function succ(mes){
  		var str="";
  		if(mes.length==0){
  			str+="<tr><td colspan='6'>没有查询到结果</td></tr>"
  		}
  		for(var i=0;i<mes.length;i++){
  			var news=mes[i];
  			var time=news.createdate;
  			time=time.substring(0,16);
  			str+="<tr>"+
  					"<td>"+news.id+"</td>"+
  					"<td>"+news.title+"</td>"+
  					"<td>"+news.summary+"</td>"+
  					"<td>"+news.author+"</td>"+
  					"<td>"+time+"</td>"+
  					"<td><a href='comment.jsp?id="+news.id+"'>查看评论</a>&nbsp;&nbsp;"+
  					"<a href='say.jsp?id="+news.id+"'>评论</a>&nbsp;&nbsp;"+	
  					"<a href='JavaScript:void(0)' name='del' date='"+news.id+"'>删除</a></td>"+	
  				 "</tr>";
  		}
  		$("tbody").empty();
  		$("tbody").append(str);
  	};
  </script>
    <table border="1">
    	<thead>
    		<strong>新闻标题</strong>
    		<input type="text" name="title">
    		<input type="button" name="search" value="查询"><br/><br/>
    		<tr bgcolor="pink"><td colspan="6" align="center" valign="middle"><h2 style="margin:0px;padding:10px;">新闻列表</h3></td></tr>
    		<tr>
    			<td>新闻编号</td>
    			<td>新闻标题</td>
    			<td>新闻摘要</td>
    			<td>作者</td>
    			<td>创建时间</td>
    			<td>操作</td>
    		</tr>
    	</thead>
    	<tbody>
    		
    	</tbody>
    </table>
  </body>
</html>
