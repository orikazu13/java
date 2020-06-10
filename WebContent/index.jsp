<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>＜図書管理システム＞ログイン</title>
<link rel="stylesheet"
href ="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<% if(request.getParameter("error") != null){ %>
		<p style="color:red">エラーです。再度ログインして下さい。</p>

	<%} %>

	<form action="/gw/login" method="post">
		【図書管理システムへようこそ】<br>
		【IDとPWを入力してください。】<br>
		ユーザID：<input type="text" name="id"><br>
		PW：<input type="password" name="pw"><br>
		<input type="submit" value="送信">
	</form>

</body>
</html>