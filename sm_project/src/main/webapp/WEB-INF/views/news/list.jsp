<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />

			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			<section id="container">
				<form role="form" method="post" action="/news/write">
					<table border="1">
						<tr>
						<th>번호</th>
						<th>뉴스제목</th>
						
						</tr>
						
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.news_index}" /></td>
								<td><c:out value="${list.news_title}" /></td>
								
								
							</tr>
						</c:forEach>
						
					</table>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>