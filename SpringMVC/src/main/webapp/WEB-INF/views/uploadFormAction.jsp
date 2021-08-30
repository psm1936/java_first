<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goDown(uploadPath, uuid, fileName) {
		var fileCallPath = uploadPath +"\\"+uuid+"_"+fileName;
		//alert(encodeURIComponent(fileCallPath));
		location.href = "${cpath}/download.do?fileName="+encodeURIComponent(fileCallPath);
		//alert(fileCallPath);
	}
</script>
</head>
<body>
	<c:forEach var="vo" items="${list}">
		<li><a href="javascript:goDown('${vo.uploadPath}','${vo.uuid}','${vo.fileName}')">${vo.fileName }</a></li>	
	</c:forEach>
</body>
</html>