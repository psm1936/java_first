<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String[] f = {"사과","바나나","포도","귤","오렌지"};
	request.setAttribute("f", f);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>과일목록</td>
	</tr>
	<c:forEach var="data" items="${f}"> 
		<tr>
			<td>${data}</td>
		</tr>
	</c:forEach>
	
</table>	
</body>
</html>