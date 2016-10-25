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
    
    <title>My JSP 'first.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" href="style/reset.css">
	<link type="text/css" rel="stylesheet" href="style/main.css">
	
	<style type="text/css">
		.goo{
			boder:1px red solid;
			width: 20px;
			height: 50px;
		}
	</style>
	
	
	<script type="text/javascript">
		function fun(){
			
			/*var str = "本网站仅做本人学习、测试使用。不做其他任何用途。\n\n本网站包含的商品信息(包括商品图片、价格等均来自网络)."
			alert(str);*/
			
		}
		
	</script>

  </head>
  
<!-- <body>
		<s:iterator value="#allBooks">
			<span  class="goo">
				<img src="./bookImgs/<s:property value='img' />"/>
				<s:property value="bookid"/>
			</span>
		</s:iterator>
  </body>  --> 
  
 <body onload="fun()">
  
	<div class="logoBar">
		<div class="comWidth">
			<div class="logo fl">
			<!--  	<a href="#"><img src="images/logo.jpg" alt="慕课网"></a> -->
			</div>
			
			
		</div>
	</div>
	

<div class="comWidth clearfix products">
	
	<div class="rightArea">
		
	
		
		<div class="products_list screening_list_more clearfix">
			
			<s:iterator value="#allBooks">
			
				<div class="item">
					<div class="item_cont">
						<div class="img_item">
							<s:a namespace="start" action="Shopping_getDetails">
								<img src="./bookImgs/<s:property value='img' />"/>
								
								<s:param name="tiaoma" value="tiaoma"></s:param>
							</s:a>
						</div>
						<p>
							<a href="#">
								<s:property value="name" /> &nbsp;
								<s:property value="author" />&nbsp;
								<s:property value="publishing" />&nbsp;
								
							</a>
							
						</p>
						<p class="money">￥<s:property value="price" /> </p>
						
					</div>
				</div>
			</s:iterator>
			
				
		</div>
	</div>
</div>

</body>
  
  
  
  
</html>
