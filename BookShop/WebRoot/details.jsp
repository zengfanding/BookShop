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
    
    <title>My JSP 'details.jsp' starting page</title>
    
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

  </head>
  
  <body>
  		
		  	<div class="logoBar">
				<div class="comWidth">
					<div class="logo fl">
					<!--  	<a href="#"><img src="images/logo.jpg" alt="慕课网"></a> -->
					</div>
					
					
				</div>
			</div><br/><br/><br/>
		  <div class="description_info comWidth">
			<div class="description clearfix">
				<div class="leftArea">
					<div class="description_imgs">
						<div class="big">
							<img src="./bookImgs/<s:property value="#detailBook.img" />"/>
						</div>
						
					</div>
				</div>
				<div class="rightArea">
					<div class="des_content">
						<h3 class="des_content_tit"><s:property value="#detailBook.name" />&nbsp;&nbsp;<s:property value="#detailBook.author" /> </h3>
						<div class="dl clearfix">
							<div class="dt">出版社</div>
							<div class="dd clearfix"><span class="hg"><s:property value="#detailBook.publishing" /></span></div>
						</div>
						<div class="dl clearfix">
							<div class="dt">优惠价</div>
							<div class="dd clearfix"><span class="des_money"><em>￥</em><s:property value="#detailBook.price" /></span></div>
						</div>
						
					<s:form namespace="/start" action="Shopping_buy" method="post">
						<div class="des_position">
							<div class="dl">
								<div class="dt des_num">数量</div>
								<div class="dd clearfix">
									<div class="des_number">
										<div class="reduction" onclick="changeNum('jian')">-</div>
										<div class="des_input">
											<input name="buynum" id="buyNum" type="text" value="1" onblur="judge()">
										</div>
										<div class="plus" onclick="changeNum('jia')">+</div>
									</div>
									<input type="hidden" value="<s:property value='#detailBook.num'/>" id="totalNum" />
									<span class="xg">库存 <em><s:property value="#detailBook.num"/></em> 本</span>
								</div>
							</div>
						</div>
						<input type="hidden"  name="bookid" value="<s:property value='#detailBook.bookid'/>" />
						<input type="hidden"  name="tiaoma" value="<s:property value='#detailBook.tiaoma'/>" />
						<input type="hidden"  name="name" value="<s:property value='#detailBook.name'/>" />
						<input type="hidden"  name="num" value="<s:property value='#detailBook.num'/>" />
						<input type="hidden"  name="author" value="<s:property value='#detailBook.author'/>" />
						<input type="hidden"  name="publishing" value="<s:property value='#detailBook.publishing'/>" />
						<input type="hidden"  name="price" value="<s:property value='#detailBook.price'/>" />
						<input type="hidden"  name="img" value="<s:property value='#detailBook.img'/>" />
						
					</s:form>
						<s:if test="#detailBook.num != 0">
							<div class="shop_buy">
								<a class="shopping_btn" href="javascript:void(0)" onclick="asubmit()"></a>
								<span class="line"></span>
							</div>
						</s:if>
						<s:else>
							<div class="shop_buy">
								<a class="cantshopping_btn"></a>
								<span class="line"></span>
							</div>
						</s:else>
						<div class="notes">
							<font color="#555555">注意：此商品可提供普通发票，不提供增值税发票。</font>
						</div>
					</div>
				</div>
			</div>
		</div>
  	
  		
  </body>
  
  <script type="text/javascript">
  		function changeNum(obj){
  			var o = document.getElementById("buyNum");
  			var total = document.getElementById("totalNum").value;
  			
  			if(total != 0){
  				if(obj == "jia"){
	  				
	  				var x = o.value * 1+1;
	  				o.value = x > total ? total : x;
	  				
	  				
	  			}else{
	  				if(obj == "jian"){
	  			
	  					o.value = o.value -1 == 0 ? 1 : o.value -1;
	  			
	  					
	  				}
	  				
	  			}
  			
  			
  			}
	  			
  		
  		}
  		
  		
  		function judge(){
  		
  			
  			var total = document.getElementById("totalNum").value *1 ;
  			var obj = document.getElementById("buyNum");
  			var buy = obj.value *1;
  			
  			if(buy > total){
  				obj.value = total;
  				var str = "当前库存为 "+document.getElementById("totalNum").value+" , 您要购买的数量超过当前库存.";
  				alert(str);
  			}
  			
  			if(buy < 1){
  				obj.value = 1;
  				alert("最少购买 1 本书."); 
  			}
  			
  		}
  		
  		function asubmit(){
  		
  			document.forms[0].submit();
  		}
  
  </script>
  
  
</html>
