<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Booking</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>

</head>
<body>
	<form:form class="form-horizontal" method="post" commandName="booking">
		<fieldset>
			<legend class="text-center header">Booking</legend>

			<form:errors path="*" element="div" cssClass="alert alert-danger" />

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-user bigicon"></i></span>
				<div class="col-md-8">
					<form:select id="restaurantId" path="restaurantId" name="restaurantId" type="text"
						class="form-control" >
						<form:option value = "NONE" label = "Select"/>
						<form:options items = "${aListRestaurnt}" />
						<form:errors path="restaurantId" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-user bigicon"></i></span>
				<div class="col-md-8">
					<form:input id="datepicker" path="day" name="day"
						type="text" />
					<form:errors path="lastname" />
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-envelope-o bigicon"></i></span>
				<div class="col-md-8">
					<form:input id="email" path="email" name="email" type="text"
						placeholder="Email" class="form-control" />
					<form:errors path="email" />
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-phone-square bigicon"></i></span>
				<div class="col-md-8">
					<form:input id="enterprise" path="enterprise" name="enterprise"
						type="text" placeholder="Empresa" class="form-control" />
					<form:errors path="enterprise" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-12 text-center">
					<form:button type="submit" class="btn btn-primary btn-lg">Guardar Registro</form:button>
				</div>
			</div>
		</fieldset>
	</form:form>

</body>
</html>