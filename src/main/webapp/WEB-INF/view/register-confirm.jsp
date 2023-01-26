<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.CDAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
	CDAccount cdaccount = (CDAccount)session.getAttribute("input_data");
	%>
	名前：<%=cdaccount.getName() %><br>
	メール：<%=cdaccount.getMail() %><br>
	パスワード：********<br>
	<a href="RegisterExecuteServlet">OK</a><br>
	<a href="RegisterFormServlet">戻る</a>
</body>
</html>