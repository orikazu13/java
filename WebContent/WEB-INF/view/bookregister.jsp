<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本の追加</title>
<link rel="stylesheet"
href ="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<a href="/gw/Menu">メニュー</a><br>
<form action="/gw/BookRegister" method="post">
		【追加する本を入力してください】<br>
		本のID:<input type="text" name="bookid"><br>
		本の名前:<input type="text" name="bookname"><br>
		著者:<input type="text" name="author"><br>
		出版社:<input type="text" name="company"><br>
		<input type="submit" value="送信">
</form>

</body>
</html>




