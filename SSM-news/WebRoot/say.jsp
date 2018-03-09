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
  </head>
  <script type="text/javascript">
  	$(function(){
  		$("input[name='back']").click(function(){
  			window.location.href="index.jsp"
  		});
  	});
  </script>
  
  <body>
  	<form action="addComment.do" method="get">
    <table border="1">
    		<tr bgcolor="pink">
    			<td colspan="2" align="center" valign="middle">
    				<h1 style="margin:0px;padding:10px;">添加评论</h1>
    			</td>
    		</tr>
    		<tr>
    			<td>评论内容(*)</td>
    			<td><textarea rows="5" cols="40" required name="content"></textarea></td>
    		</tr>
    		<tr>
    			<td>评论人</td>
    			<td>
    				<input type="text" name="author" >
    				<input type="hidden" name="id" value="<%=request.getParameter("id")%>" >
    			</td>
    		</tr>
    		<tr>
    			<td><input type="submit" name="go" value="提交"></td>
    			<td><input type="button" name="back" value="返回"></td>
    		</tr>
    </table>
    </form>
  </body>
</html>
