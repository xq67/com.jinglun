<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<style>
		tr:nth-child(even){
			background:#74BCD4;
		}
	</style>
  </head>
  <script type="text/javascript">
  	$(function(){
  	    var id=$("h2").attr("date");
  		$.getJSON("showAllComment.do/"+id,succ);
  		$("input[name='back']").click(function(){
  			window.location.href="index.jsp"
  		});
  	});
  	function succ(mes){
  		var str="";
  		if(mes.length==0){
  			str+="<tr><td colspan='4'>该新闻暂时没有评论</td></tr>"
  		}
  		for(var i=0;i<mes.length;i++){
  			var news=mes[i];
  			var time=news.createdate;
  			time=time.substring(0,16);
  			str+="<tr>"+
  					"<td>"+news.id+"</td>"+
  					"<td>"+news.content+"</td>"+
  					"<td>"+news.author+"</td>"+
  					"<td>"+time+"</td>"+
  				 "</tr>";
  		}
  		$("tbody").empty();
  		$("tbody").append(str);
  	}
  </script>
  
  <body>
    <table border="1">
    	<thead>
    		<tr bgcolor="pink">
    			<td colspan="3" align="center" valign="middle">
    				<h2 style="margin:0px;padding:10px;" date="<%=request.getParameter("id")%>">评论列表</h3>
    			</td>
    			<td><input type="button" name="back" value="返回新闻列表"></td>
    		</tr>
    		<tr>
    			<td>评论编号</td>
    			<td>评论内容</td>
    			<td>评论人</td>
    			<td>评论时间</td>
    		</tr>
    	</thead>
    	<tbody>
    		
    	</tbody>
    </table>
  </body>
</html>
