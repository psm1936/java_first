<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
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
<script type="text/javascript">
  	function goWrite(){
  		location.href = "${cpath}/boardForm.do";
  	}
  	
  	function goJson() { //jquery가 연결되어있어야 쓸수있음
		$.ajax({
			url: "${cpath}/boardListAjax.do",
			type: "get",
			dataType: "json",
			success: resultHtml,
			error: function(){alert("error");}
		});
	}
  	function resultHtml(data) { // data=>[{ },{ },{ }....] 으로 있다.
		//alert(data);
  		var html="<table class='table'>";
  		
  		html+="<tr>";
  		html+="<td>번호</td>";
  		html+="<td>제목</td>";
  		html+="<td>조회수</td>";
  		html+="<td>작성자</td>";
  		html+="<td>작성일</td>";
  		html+="<td>삭제</td>";
  		html+="</tr>";
  		
  		// 반복문
  		$.each(data,(index,obj)=>{
  			html+="<tr>";
  	  		html+="<td id='idx"+index+"'>"+obj.idx+"</td>";
  	  		html+="<td>"+obj.title+"</td>";
  	  		html+="<td>"+obj.count+"</td>";
  	  		html+="<td>"+obj.writer+"</td>";
  			html+="<td>"+obj.indate+"</td>"; 
  			html+="<td><button class='btn btn-warning btn-sm' onclick='delBtn("+obj.idx+")'>삭제(Ajax)</button></td>"; 
  	  		html+="</tr>";
  		});
  		
  		html+="</table>";
  		$("#list").html(html);
	}
  	function delBtn(idx) {
  		if(confirm ("정말로 삭제 하시겠습니까?")==true){
  			$.ajax({
  				url: "boardDeleteAjax.do",
  				type:"get",
  				data:{"idx" : idx},
  				success : goJson,
  				error : function() {alert("error")}					
  				
  			});
  		}else{
  			return false;
  		}
  		
  	}
  	
  </script>
</head>
<body>
	<div class="container">
		<h2>Spring MVC BOARD</h2>
		<div class="panel panel-default">
			<div class="panel-heading">BOARD LIST</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>조회수</td>
						<td>작성자</td>
						<td>작성일</td>
					</tr>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.idx}</td>
							<td><a href="${cpath}/boardContent.do?idx=${vo.idx}">${vo.title}</a></td>
							<td>${vo.count}</td>
							<td>${vo.writer}</td>
							<td>${vo.indate}</td>
						</tr>
					</c:forEach>
				</table>
				<button class="btn btn-info btn-sm" onclick="goWrite()">글쓰기</button><br><br>
				<div>
				<form action="${cpath}/boardSearch.do" method="post">
					<table class="table">
						<tr>
							<td>
								<select name="part" class="form-control">
									<option value="title">제목</option>
									<option value="writer">작성자</option>
									<option value="contents">내용</option>
								</select>
							</td>
							<td><input type="text" name="keyword" class="form-control"></td>
							<td><button type="submit" class="btn">검색</button></td>
						</tr>
					</table>
				</form>
				</div>
				<button class="btn btn-success btn-sm" onclick="goJson()">JSON DATA 가져오기(Ajax)</button>				
				<div id="list">여기에 게시판 리스트를 출력</div>
			</div>
			<div class="panel-footer">빅데이터-4차 노현규</div>
		</div>
	</div>
</body>
</html>