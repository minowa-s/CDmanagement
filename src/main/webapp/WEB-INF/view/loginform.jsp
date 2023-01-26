<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
 	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>ログインページ</title>
</head>
<body>
		<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
		<div class="alert alert-danger" role="alert">
 			ログインに失敗しました
		</div>	
	  <h2>ログイン</h2>
 <div class="container">
        <form class="m-3" action=LoginServlet method="post">
            <div class="row mb-3">
              <label for="inputEmail3" class="col-md-2 col-form-label">Log In ID</label>
              <div class="col-md-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email Address" name="mail">
              </div>
            </div>
            <div class="row mb-3">
              <label for="inputPassword3" class="col-md-2 col-form-label">Password</label>
              <div class="col-md-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="pw">
              </div>
            </div>
             <button type="submit" class="btn btn-outline-info">ログイン</button>
        </form>
 </div>    
	<a href="index.html">戻る</a><br>
	<%
		} else {
	%>
	  <h2>ログイン</h2>
 <div class="container">
        <form class="m-3" action=LoginServlet method="post">
            <div class="row mb-3">
              <label for="inputEmail3" class="col-md-2 col-form-label">Log In ID</label>
              <div class="col-md-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email Address" name="mail">
              </div>
            </div>
            <div class="row mb-3">
              <label for="inputPassword3" class="col-md-2 col-form-label">Password</label>
              <div class="col-md-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="pw">
              </div>
            </div>
             <button type="submit" class="btn btn-outline-info">ログイン</button>
        </form>
 </div>    
	<a href="./">戻る</a><br>
	<%
		}
	%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
 	   integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>