<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="card card-container">
<%-- 			<link href="<c:url value="resources/css/styles.css" />" --%>
<!-- 				rel="stylesheet" /> -->
<!-- 			<link -->
<!-- 				href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" -->
<!-- 				rel="stylesheet" id="bootstrap-css"> -->
			<script
				src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
			<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
			<span id="reauth-email" class="reauth-email"></span> <br>
			<ul>
				<li>
					<c:out value="${message}" />
				</li>
<!-- 				<span id="reauth-email" class="reauth-email"></span> -->
<!-- 				<br> -->
<!-- 				<br> -->
				<!--                     <input type="button"  class="btn btn-primary btn-lg" onclick="location.href='lista.htm'" value="Ir a la Página Principal" > -->
			</ul>
		</div>
	</div>
</body>
</html>