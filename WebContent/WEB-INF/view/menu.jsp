<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書管理システムメニュー</title>
<link rel="stylesheet"
href ="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
<p>ようこそ<%=session.getAttribute("id") %>さん</p><br>
	<ul>
		<li><a href="/gw/Booklist">一覧画面</a></li>
		<li><a href="/gw/search">検索画面</a></li>
		<li><a href="/gw/Register">登録画面</a></li>
		<li><a href="/gw/Erase">削除画面</a></li>
	</ul>
	<br>
	<br>
	<a href="/gw/logout">ログアウト</a>

</body>
</html>