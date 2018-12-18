<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Booking</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet" />
<style type="text/css">
body, html {
	height: 100%;
	background-repeat: repeat;
	background-image: linear-gradient(rgb(104, 120, 162), rgb(12, 80, 33));
}

.header {
	color: #36A0FF;
	font-size: 27px;
	padding: 10px;
}

.bigicon {
	font-size: 35px;
	color: #36A0FF;
}

.card-container.card {
    max-width: 350px;
    padding: 40px 40px;
}

/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

</style>
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<span id="reauth-email" class="reauth-email"></span> <br>
			<ul>
				<li><c:out value="${message}" /></li>
				<span id="reauth-email" class="reauth-email"></span>
				<br>
				<br>
			</ul>
		</div>
		<dir>
			<input type="button" class="btn btn-primary btn-lg"
					onclick="location.href='cancel'"
					value="Volver a Formulario de Reserva">
		</dir>
	</div>
</body>
</html>