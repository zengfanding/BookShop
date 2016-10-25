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
			<td width="39%" align="left">[查询销售单]</td>

			<td width="57%" align="right">
				
			</td>
			<td width="3%" align="right"><img
				src="${pageContext.request.contextPath}/images/tright.gif" /></td>
		</tr>
	</table>

	<s:form namespace="/xiao" action="Xiaoshou_find">
		<s:hidden id="pageId" name="pageId" value="%{nowPage}"></s:hidden>
		
		<s:hidden id="totalPages" name="totalPages" value="%{totalPages}"></s:hidden>
		<s:hidden id="type" name="type" value="%{type}"></s:hidden>
		<table width="88%" border="0" class="emp_table" style="width:80%;">
			<tr>
				<td width="10%">销售码：</td>
				<td width="20%"><s:textfield name="xiaoshouMa"></s:textfield></td>
				<td ></td>
				<td ></td>
			</tr>
			<tr>
				<td width="10%">书籍条形码：</td>
				<td width="20%"><s:textfield name="bookInfo.tiaoma"></s:textfield></td>
				<td ></td>
				<td ></td>
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
			<td width="12%" align="center">销售码</td>
			<td width="10%" align="center">书籍  条形码</td>
			<td width="12%" align="center">书籍  名称</td>
			<td width="12%" align="center">书籍  作者</td>
			<td width="14%" align="center">出版社</td>
			
			<td width="9%" align="center">书籍图片</td>
			<td width="10%" align="center">销售量</td>
			<td width="10%" align="center">销售日期</td>
			<td width="11%" align="center">操作</td>
		</tr>
		
		
		<s:iterator value="#allList">
			<tr class="tabtd1">
				<td align="center"><s:property value="xiaoshouMa" /></td>
				<td align="center"><s:property value="bookInfo.tiaoma" /></td>
				<td align="center"><s:property value="bookInfo.name" /></td>
				<td align="center"><s:property value="bookInfo.author" /></td>
				<td align="center"><s:property value="bookInfo.publishing" /></td>
				<td align="center"><img src="${pageContext.request.contextPath}/bookImgs/${bookInfo.img}" height="65px" width="50px" /></td>
				<td align="center"><s:property value="xiaoshouNum" /></td>
				
				
			
				<td align="center">
					<s:date name="xiaoshouDate" />
				</td>
				<td align="center"><span><font color = "green">已处理</font></span></td>
		
				
				
				
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
