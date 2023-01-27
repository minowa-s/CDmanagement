<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
</head>
<body>
	<h1>CDの登録</h1>
	<form action="successservlet" method="post">
	CD名:<input type="text" name="title"><br>
	作曲者:<input type="text" name="composer"><br>
	発売日:<input type="text" name="onsale"><br>
	ISBN:<input type="text" name="isbn"><br>
		<input type="submit" value="登録する"> 
	</form>
</body>
</html>