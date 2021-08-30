<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//매서드(선언문)
	public int hap(int a, int b){
		return a+b;
	}
%>
<%
	int cnt = hap(10,10); //call
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 주석문 -->
<%-- jsp 주석문 --%>

<%=cnt %>
</body>
</html>