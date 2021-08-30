<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(()=>{
	list();   
});
function list() {
	$("#bc").css("display","none");
	$("#bf").css("display","none");//글쓰기 이후에 안 보이게 함.
	 $.ajax({
		   url : "ajaxlist.do",    //-----AjaxBoardListController-----------
		   type : "get",           // JSON = dic : {"idx":1, "name:"}
		   success: callBack,      // <----------------
		   dataType: "json",
		   error : function() {alert("error");
		   }
	   });	   
}

function callBack(data) {
	//alert(data);
	var view = "<table class = 'table table-bordered'>";
	view+="<tr>";
	view+="<td>번호</td>";
	view+="<td>제목</td>";
	view+="<td>조회수</td>";
	view+="<td>작성자</td>";
	view+="<td>작성일</td>";
	view+="<td>삭제</td>";
	view+="</tr>";
	$.each(data,(index,obj)=>{
		
		view+="<tr>";
		view+="<td id ='idx"+index+"'>"+obj.idx+"</td>";  //<td id ='idx"+index+"'> 그냥붙이면 문자열이니 뜯어서 넣어줌
		view+="<td><a href='javascript:contentFn("+index+")'>"+obj.title+"</a></td>";
		//2가지 방식 view+="<td><a href='javascript:contentFn("+obj.idx+")'>"+obj.title+"</a></td>";
		view+="<td>"+obj.count+"</td>";
		view+="<td>"+obj.writer+"</td>";
		view+="<td>"+obj.indate+"</td>";
		
		view+="<c:if test='${sessionScope.userVO==null || sessionScope.userVO.user_id!=\'admin\'}'>";
		view+="<td><button class='btn btn-warning' onclick='delBtn("+obj.idx+")' disabled='disabled'>삭제</button></td>";
		view+="</c:if>";
		
		view+="<c:if test='${sessionScope.userVO.user_id==\'admin\'}'>";
		view+="<td><button class='btn btn-warning' onclick='delBtn("+obj.idx+")'>삭제</button></td>";
		view+="</c:if>";
		
		view+="</tr>";		
		
	});	
	view+="<tr>";
	view+="<td colspan='6'>";
	
	view+="<c:if test='${ !empty sessionScope.userVO}'>";
	view+="<input type= 'button' value='글쓰기' class = 'btn btn-primary' onclick = 'btnWrite()'/>";
	view+="</c:if>";
	
	view+="</td>";
	view+="</tr>";
	view+="<table>";
	$("#msg").html(view);
}

function contentFn(index) {
	var idx = $("#idx"+index).text();
	$.ajax({
		url: "ajaxcontent.do",
		type: "get",
		data: {"idx":idx},  // data를  url: "ajaxcontent.do",<-여기로 보냄
		dataType: "Json",
		success: callContent,
		error: function(){ alert("error"); }	
		
	});
}
function contentFn1() {
	var idx = $("#cidx").val();
	$.ajax({
		url: "ajaxcontent.do",
		type: "get",
		data: {"idx":idx},
		dataType: "Json",
		success: callContent,
		error: function(){ alert("error"); }	
		
	});
}

function callContent(data) {  // 여기서 data는  컨트롤러에서 내려오는것
	
	$("#bf").css("display","none");
	$("#bc").css("display","block");
	var idx = data.idx;
	var title = data.title;
	var contents = data.contents;
	var writer = data.writer;
	$("#cidx").val(idx);
	$("#ctitle").val(title);
	$("#ccontents").val(contents);
	$("#cwriter").val(writer);
}

/* function contentFn(idx) {  2가지 방식
	alert(idx);
} */

function btnWrite() {
	var writer = '${sessionScope.userVO.user_name}';
	$("#bc").css("display","none");
	$("#bf").css("display","block");
	$("#resetBtn").trigger("click");	
	$("#writer").val(writer);
}

// 삭제 할지 안할지 알림창
function delBtn(idx) {
	if(confirm ("정말로 삭제 하시겠습니까?")==true){
		$.ajax({
			url: "ajaxdelete.do",
			type:"get",
			data:{"idx" : idx},
			success : list,
			error : function() {alert("error")}					
			
		});
	}else{
		return false;
	}
	
}
function writeFn() {
	var formData= $("#frm").serialize();
	$.ajax({
		url : "ajaxregister.do",
		type: "post",
		data: formData,
		success: list,
		error: function() { alert("error");	}
	
	});	
}

function closeFn() {
	$("#bc").css("display","none");
	$("#bf").css("display","none");
}

function updateFn() {
	var formData= $("#ufrm").serialize();
	//alert(formData);
	$.ajax({
		url : "ajaxupdate.do",
		type: "post",
		data: formData,
		success: list,
		error: function() { alert("error");	}
	});
}

function loginFn() {
	var user_id= $("#user_id").val();
	var password= $("#password").val();
	$.ajax({ 
		url: "ajaxlogin.do",
		type: "post",
		data:{"user_id":user_id, "password":password},
		success: function(data){ 
			if(data=="NO"){
				alert("회원인증 실패.");
			}else{
				location.href="ajax04.jsp"; // 메인화면으로
			}
			
		},
		error: function() { alert("error"); }		
		
	});
	
}

function logoutFn() {
	$.ajax({
		url: "ajaxlogout.do",
		type: "get",
		success: function(){ 
			location.href = "ajax04.jsp";
		},
		error: function() { alert("error"); }	
	});
}

</script>
</head>
<body>

	<div class="container">
		<h4>
			MVC_(FrontController+POJO+HandlerMapping+ViewResolver+MyBatis+Ajax)게시판
			</h4>
			<div class="panel panel-default">
				<div class="panel-heading">
				<c:if test="${sessionScope.userVO==null}">
					<form id="Loginfrm" class="form-inline"  method="post">
						<div class="form-group">
							<label>ID:</label> 
							<input type="text" class="form-control"	id="user_id" name="user_id">
						</div>
						<div class="form-group">
							<label>PWD:</label> 
							<input type="password" class="form-control" id="password" name="password">
						</div>
						<button type="button" class="btn btn-info" onclick="loginFn()" >로그인</button>
					</form>
				</c:if>
				<c:if test="${sessionScope.userVO!=null}">
					${sessionScope.userVO.user_name}님 방문을 환영합니다.					
					<input type="button" value="로그아웃" onclick="logoutFn()" class="btn btn-info btn-sm">
				</c:if>	
				</div>
				<div class="panel-body">

					<div id="msg"></div>
					<div style="display: none;" id="bf">
						<c:import url="boardForm.jsp" />
					</div>
					<div style="display: none;" id="bc">
						<c:import url="boardContent.jsp" />
					</div>

				</div>
				<div class="panel-footer">빅데이터 4차 노현규</div>
			</div>
	</div>


</body>
</html>