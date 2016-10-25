<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML><HEAD>
<link href="${pageContext.request.contextPath}/css/dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
</HEAD>
<BODY bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<input type="hidden" id="quan" value="<s:property value='#session.loginAdminUser.quanxian'></s:property>" />
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center" >
<tr>
<div class="dtree">
	<script type="text/javascript">
		var o = document.getElementById("quan");
		var i = o.value;
		
		
		d = new dTree('d','${pageContext.request.contextPath}');
		d.add('01','-1','BookStore管理系统');
		
		
		
		var temp;
		
		
		temp = i & 1;
		if(temp == 1){
		
			d.add('0101','01','书籍管理','${pageContext.request.contextPath}/book/BookAction_findAll','','right');
		}
		
		temp = i & 2;
		if(temp == 2){
			
			d.add('0102','01','库存管理','${pageContext.request.contextPath}/book/BookAction_findAllToKucun','','right');
		
		}
		
		temp = i & 4;
		if(temp == 4){
		
			d.add('0103','01','进书管理','${pageContext.request.contextPath}/jin/JinshuAction_findAll','','right');
		
		}
		
		temp = i & 8;
		if(temp == 8){
		
			d.add('0104','01','销售管理','${pageContext.request.contextPath}/xiao/Xiaoshou_findAll','','right');
		}
		
		temp = i & 16;
		if(temp == 16){
			d.add('0105','01','添加账号','${pageContext.request.contextPath}/adminusers/addadminuser.jsp','','right');
			
		}
		
		
		
		
		
		document.write(d);
	</script>
</div>
</tr>
</table>
</BODY>
</HTML>
      			
			


      