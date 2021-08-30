<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
	String[] movieName = {"귀멸의 칼날","바이올렛 에버가든","더 스파이"};
	String[] movieStory = {"귀멸의 칼날",
							"바이올렛 에버가든",
							"가장 평범한 사람의 가장 위대한 첩보 실화  때론, 한 사람의 용기가 세상을 바꾼다!"};
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron text-center">
		<h1>더 스파이</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>

	<div class="container">
		<div class="row">
			<% for(int i =0; i<3; i++){ %>
			<div class="col-sm-4">
				<h3><%=movieName[i]%></h3>
				<p><img src="images/thespy<%=i+1%>.jpg" width="350" height="400"></p>
				<p><%=movieStory[i] %></p>
			</div>
			<%} %>
		</div>
	</div>

</body>
</html>
