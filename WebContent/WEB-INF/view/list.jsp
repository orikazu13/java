<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.BookInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧</title>
<link rel="stylesheet"
href ="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<a href="/gw/Menu">メニュー</a>
	<br>
	<table border="1">
		<tr>
			<th>BookID</th>
			<th>タイトル</th>
			<th>著者</th>
			<th>出版社</th>
			<th>貸出状況</th>
		</tr>
		<%
			ArrayList<BookInfo> list = (ArrayList<BookInfo>) request.getAttribute("list");
			for (int i = 0; i < list.size(); i++) {
				BookInfo book = list.get(i);
		%>
		<tr>
			<td><%=book.getBookid()%></td>
			<td><%=book.getBookname()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getCompany()%></td>
			<td><%=book.getLore()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<form action="/gw/Loan" method="post">
		【借りる本の図書IDを入力してください。】<br>
		<input type="text" name="bookid"><br>
		<input type="submit" value="送信">
	</form>
	<form action="/gw/Bookreturn" method="post">
		【返却する本の図書IDを入力してください。】<br>
		<input type="text" name="bookid"><br>
		<input type="submit" value="送信">
	</form>
	<a href="/gw/Menu">メニュー</a>
	<br>
	<a href="/gw/logout">ログアウト</a>

</body>
</html>