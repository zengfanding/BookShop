<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css"
	type="text/css" rel="stylesheet" />
</head>

<body>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td class="topg"></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="0" class="wukuang"
		width="100%">
		<tr>
			<td width="1%"><img
				src="${pageContext.request.contextPath}/images/tleft.gif" /></td>
			<td width="39%" align="left">[查询书籍]</td>

			<td width="57%" align="right">
					<a href="${pageContext.request.contextPath}/book/addBook.jsp">
						<img
							src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
					</a>
				
			</td>
			<td width="3%" align="right"><img
				src="${pageContext.request.contextPath}/images/tright.gif" /></td>
		</tr>
	</table>

	<s:form namespace="/book" action="BookAction_find">
		<s:hidden id="pageId" name="pageId" value="%{nowPage}"></s:hidden>
		
		<s:hidden id="totalPages" name="totalPages" value="%{totalPages}"></s:hidden>
		<s:hidden id="type" name="type" value="%{type}"></s:hidden>
		<table width="88%" border="0" class="emp_table" style="width:80%;">
			<tr>
				<td width="10%">书籍条形码：</td>
				<td width="20%"><s:textfield name="tiaoma"></s:textfield></td>
				<td width="8%">书籍名称：</td>
				<td width="62%"><s:textfield name="name"></s:textfield></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><s:textfield name="author"></s:textfield></td>
				<td>出版社：</td>
				<td><s:textfield name="publishing"></s:textfield></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				<a href="javascript:void(0)" onclick="tellLeixint()">
						<img src="${pageContext.request.contextPath}/images/button/find.gif" />
				</a>
					
				
				</td>
			</tr>
		</table>
	</s:form>



	<table border="0" cellspacing="0" cellpadding="0"
		style="margin-top:5px;">
		<tr>
			<td><img
				src="${pageContext.request.contextPath}/images/result.gif" /></td>
		</tr>
	</table>
	<table width="97%" border="1">

		<tr class="henglan" style="font-weight:bold;">
			<td width="13%" align="center">条形码</td>
			<td width="17%" align="center">书籍名称</td>
			<td width="14%" align="center">作者</td>
			<td width="14%" align="center">出版社</td>
			<td width="10%" align="center">零售价</td>
			<td width="10%" align="center">书籍图片</td>
			<td width="11%" align="center">操作</td>
		</tr>
		
		
		<s:iterator value="#allBookList">
			<tr class="tabtd1">
				<td align="center"><s:property value="tiaoma" /></td>
				<td align="center"><s:property value="name" /></td>
				<td align="center"><s:property value="author" /></td>
				<td align="center"><s:property value="publishing" /></td>
				<td align="center"><s:property value="price" /></td>
				<td align="center"><img src="${pageContext.request.contextPath}/bookImgs/${img}" height="65px" width="50px" /></td>
				<td width="11%" align="center">
					<s:a namespace="/book" action="BookAction_edit">
						<img src="${pageContext.request.contextPath}/images/button/edit.gif" class="img" />
						<s:param name="bookid" value="bookid"></s:param>
						<s:param name="tiaoma" value="tiaoma"></s:param>
						<s:param name="name" value="name"></s:param>
						<s:param name="num" value="num"></s:param>
						<s:param name="author" value="author"></s:param>
						<s:param name="publishing" value="publishing"></s:param>
						<s:param name="price" value="price"></s:param>
						<s:param name="img" value="img"></s:param>
					</s:a>
					<s:a namespace="/book" action="BookAction_delete">
						<img src="${pageContext.request.contextPath}/images/button/del.gif" class="img" />
						<s:param name="bookid" value="bookid"></s:param>
						<s:param name="tiaoma" value="tiaoma"></s:param>
						<s:param name="name" value="name"></s:param>
						<s:param name="num" value="num"></s:param>
						<s:param name="author" value="author"></s:param>
						<s:param name="publishing" value="publishing"></s:param>
						<s:param name="price" value="price"></s:param>
						<s:param name="img" value="img"></s:param>
					</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<table border="0" cellspacing="0" cellpadding="0" align="center">
	
		<tr>
			<td align="right"><span>第 <span id="nowpage">${nowPage }</span> /<s:property value="totalPages" /> 页</span> 
			<span> <a href="javascript:void(0)" onclick="changePage(1)">[首页]</a>&nbsp;&nbsp;
				<s:if test="nowPage == 1 || totalPages == 0">
					<a>[上一页]</a>&nbsp;&nbsp; 
				</s:if>
				<s:else>
					<a href="javascript:void(0)" onclick="changePage(<s:property value="nowPage - 1"/>)">[上一页]</a>&nbsp;&nbsp; 
				</s:else>
				
				<s:if test="nowPage == totalPages || totalPages == 0">
					<a>[下一页]</a>
				</s:if>
				<s:else>
					<a href="javascript:void(0)" onclick="changePage(<s:property value="nowPage + 1"/>)">[下一页]</a>
				</s:else>
				
					
						 &nbsp;&nbsp;
					<a href="javascript:void(0)" onclick="changePage(<s:property value="totalPages"/>)">[尾页]</a>
			</span></td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	
	
	function changePage(num){
		
		
		document.getElementById("type").value=null;
		document.getElementById("pageId").value = num;
		document.forms[0].submit();
	
	
	}
	
	
	function tellLeixint(){
	
		document.getElementById("type").value="byButton";
		document.forms[0].submit()
	
	}
	
</script>

</html>
