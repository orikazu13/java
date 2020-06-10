<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除</title>
<link rel="stylesheet"
href ="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<a href="/gw/Menu">メニュー</a>
	<br>
	<form action="/gw/BookErase" method="post">
		【削除する本のIDを入力してください】<br>
		ID:<input type="text" name="bookid"><br>
		<input type="submit" value="送信">
	</form>

</body>
</html>




