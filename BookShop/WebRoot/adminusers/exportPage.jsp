<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript">
	function fun(){
	
		
		document.forms[0].submit();
	}

</script>
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
			<td width="39%" align="left">[ 导出Excel工作表 ]</td>

			
			<td width="3%" align="right"><img
				src="${pageContext.request.contextPath}/images/tright.gif" /></td>
		</tr>
	</table>

	<s:form namespace="/admin" action="Admin_exportExcel">
		<s:hidden id="pageId" name="pageId" value="%{nowPage}"></s:hidden>
		
		<s:hidden id="totalPages" name="totalPages" value="%{totalPages}"></s:hidden>
		<s:hidden id="type" name="type" value="%{type}"></s:hidden>
		<table width="88%" border="0" class="emp_table" style="width:80%;">
			
			<tr>
				<td colspan="2">
					请选择要导出的内容：
				</td>
			</tr>
			
			
			<tr>
				<td></td>
				<td width="100%">
					

					<s:checkboxlist list="excelList" name="excel" key="excel"></s:checkboxlist>
				</td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				</td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				<a href="javascript:void(0)" onclick="fun()">
						<img src="${pageContext.request.contextPath}/images/button/cjyh1.gif" />
				</a>
				</td>
			</tr>
		</table>
	</s:form>



	
	
	
</body>


</html>
