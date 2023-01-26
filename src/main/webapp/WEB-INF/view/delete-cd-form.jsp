<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CDデータ削除</title>
</head>
<body>
<form action="DeleteCdServlet" method="post" >
<h1>削除したいデータの管理番号を入力してください。</h1>
<input type="text" name="isbn" class="box" placeholder="0～9の数字" >
<p></p>
<input type ="submit" value="削除" class="submit" >
</form>
<a href="CdTopServlet">CD管理トップページへ</a>

</body>
</html>