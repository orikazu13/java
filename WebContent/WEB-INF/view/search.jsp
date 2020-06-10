<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link rel="stylesheet"
href ="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<a href="/gw/Menu">メニュー</a><br>
	<form action="/gw/result" method="post">
		【図書名を入力して下さい。】<br>
		図書名：<input type="text" name="bookname"><br>
		<input type="submit" value="送信">
	</form>
	<br>
	<br>
	<a href="/loginLogicSample/logout">ログアウト</a>
</body>
</html>