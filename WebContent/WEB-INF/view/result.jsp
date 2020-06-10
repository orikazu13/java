<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.BookInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>
	<a href="/gw/Menu">メニュー</a>
	<br>
	<%
	request.setCharacterEncoding("UTF-8");

	BookInfo book = (BookInfo)request.getAttribute("book");
	%>
	<table border="1">
		<tr>
			<th>BookID</th>
			<th>タイトル</th>
			<th>著者</th>
			<th>出版社</th>
			<th>貸出状況</th>
		</tr>
		<tr>
			<td><%=book.getBookid()%></td>
			<td><%=book.getBookname()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getCompany()%></td>
			<td><%=book.getLore()%></td>
		</tr>
	</table>
	<br>
	<a href="/gw/logout">ログアウト</a>
</body>
</html>