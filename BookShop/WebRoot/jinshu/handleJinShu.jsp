<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css"
	type="text/css" rel="stylesheet" />
	
	
	

</head>

<body class="emp_body">
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
			<td width="44%" align="left">[处理  进书单]</td>

		<!--  	<td width="52%" align="right"><a href="javascript:void(0)" onclick="document.forms[0].submit()"><img
					src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
				<a href="#"><img
					src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>

			</td> -->
			<td width="3%" align="right"><img
				src="${pageContext.request.contextPath}/images/tright.gif" /></td>
		</tr>
	</table>

	<s:form namespace="/jin" action="JinshuAction_saveJinshu" enctype="multipart/form-data" method="post">	
		
			<s:hidden name="bookInfo.bookid" value="%{bookInfo.bookid}" id="bookBookid"></s:hidden>
			<s:hidden name="bookInfo.img" value="%{bookInfo.img}" id="bookImg"></s:hidden>
			<s:hidden name="jinhuoId" value="%{jinhuoId}" id="jinhuoId"></s:hidden>
			<s:hidden name="bookInfo.price" value="%{bookInfo.price}" id="bookPrice"></s:hidden>
		<!--  	<s:hidden name="bookInfo.bookJinhuos" value="%{bookInfo.bookJinhuos}" id="bookJinhuos"></s:hidden>
			<s:hidden name="bookInfo.bookXiaoshous" value="%{bookInfo.bookXiaoshous}" id="bookXiaoshous"></s:hidden> -->
		<table width="88%" border="0" class="emp_table" style="width:80%;">
			<tr>
				<td width="10%">进书码：</td>
				<td width="20%"><s:textfield name="jinshuMa"  readonly="true"></s:textfield></td>
				<td ></td>
				<td ></td>
			</tr>
			<tr>
				<td width="10%">书籍条形码：</td>
				<td width="20%"><s:textfield name="bookInfo.tiaoma" readonly="true"></s:textfield></td>
				<td width="8%">书籍名称：</td>
				<td width="62%"><s:textfield name="bookInfo.name" id="bookInfo.bookName" readonly="true"></s:textfield></td>
			</tr>
			<tr>
				<td>作者：</td>
				<td><s:textfield name="bookInfo.author" id="bookInfo.bookAuthor" readonly="true"></s:textfield></td>
				<td>出版社：</td>
				<td><s:textfield name="bookInfo.publishing" id="bookInfo.bookPublishing" readonly="true"></s:textfield></td>
			</tr>
			<tr>
				<td>当前库存量：</td>
				<td><s:textfield name="bookInfo.num" id="bookInfo.bookNum" readonly="true"></s:textfield></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td>进价:</td>
				<td><s:textfield name="jinPrice" id="jinPrice" readonly="true"></s:textfield></td>
				<td>采购量:</td>
				<td><s:textfield name="caiGouNum" id="caiGouNum" readonly="true"></s:textfield></td>
				
			</tr>
			
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2">
					<a href="javascript:void(0)" onclick="document.forms[0].submit()">
					<img src="${pageContext.request.contextPath}/images/button/ensureGoujin.gif" class="img" />
					</a>
				</td>
				
			</tr>
			
		</table>
	</s:form>
	<div class="imgdiv">
		<img id="tupian" src="../bookImgs/<s:property value='bookInfo.img'></s:property>" width="140px" height="200px"/>
	</div>
	
</body>
</html>
