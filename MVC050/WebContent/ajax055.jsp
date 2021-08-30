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

function loginFn() {
      var user_id=$("#user_id").val();     
      var password=$("#password").val();
      $.ajax({
         url:"ajaxlogin.do",   
         type:"post",
         data: {"user_id":user_id,"password":password},  
         success : function (data) {
            if(data=="NO"){
               alert("회원 인증에 실패했습니다");
            }else{
               location.href="ajax05.jsp"; //메인화면으로
            }   
         },           //처리가 성공하면 바로 list를 뽑아준다
         error : function(){ alert("error");}
      });
}
function logoutFn(){
   $.ajax({
      url : "ajaxlogout.do",
      type :"get",
      success : function(){
         location.href="ajax05.jsp"//로그아웃 한다면 메인페이지로 돌아가게
      },
      error : function(){alert("error");}   
   });
}
</script>
</head>
<body>
   <div class="container">
      <h4>MVC_(FrontController+POJO+HandlerMapping+ViewResolver+MyBatis+Ajax)
         게시판</h4>
      <div class="panel panel-default">
         <div class="panel-heading">
            <c:if test="${sessionScope.userVO==null}">
               <form id="loginfrm" class="form-inline" method="post">
                  <div class="form-group">
                     <label>ID:</label> <input type="text" class="form-control"
                        id="user_id" name="user_id">
                  </div>
                  <div class="form-group">
                     <label>PWD:</label> <input type="password" class="form-control"
                        id="password" name="password">
                  </div>
                  <button type="button" class="btn btn-info" onclick="loginFn()">Login</button>
               </form>
            </c:if>
            
            <c:if test="${sessionScope.userVO!=null}"><!-- 회원 인증 성공 했을때 폼 -->
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