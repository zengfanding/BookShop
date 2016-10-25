<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
	
	<script type="text/javascript">
		function fun(){
			
			/*var str = "本网站仅做本人学习、测试使用。不做其他任何用途。\n\n本网站包含的商品信息(包括商品图片、价格等均来自网络)."
			alert(str);*/
			
		}
		
	</script>
	
	
	
  </head>
  
  <body onload="fun()"> 	  	
	   		<div class="signin">
	   			
				<div class="signin-head"><img src="images/test/head_120.png" alt="" class="img-circle"></div>
				<s:form cssClass="form-signin" role="form" namespace="/admin" action="Admin_login">
				
					<span><font color="red"><s:property value="adminloginerror" /> </font></span>
					<input name="username" type="text" class="form-control" placeholder="用户名" required autofocus />
					<input name="password" type="password" class="form-control" placeholder="密码" required />
					<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
					
				</s:form>
			</div>
		
   		
  </body>
</html>
