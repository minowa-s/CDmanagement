<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除成功</title>
</head>
<body>
<h1><font size="10">データの削除に成功しました</font></h1>
<%
request.setCharacterEncoding("UTF-8");
String isbn = request.getParameter("isbn");

%>
<h2 ><font size="7">
	管理番号:<%=isbn %>
</font>
</h2>

</body>
</html>