<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Cancel</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="main/webapp/css/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#datepicker" ).datepicker({ minDate:0});
  } );
  </script>
</head>
<body>

	<form:form>
		<fieldset>
			<legend class="text-center header">Cancel Booking</legend>

			<form:errors path="*" element="div" cssClass="alert alert-danger" />

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-user bigicon"></i></span>
				<div class="col-md-8">
					<form:label path="restaurantId">restaurantId : </form:label>
					<form:select id="restaurantId" path="restaurantId" name="restaurantId" type="text" class="form-control">
						<form:options items="${aListRestaurnt}" />
						<form:errors path="restaurantId" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-user bigicon"></i></span>
				<div class="col-md-8">
					<form:label path="day">Day : </form:label>
					<form:input id="datepicker" path="day" name="day" type="text" />
					<form:errors path="day" />
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-envelope-o bigicon"></i></span>
				<div class="col-md-8">
					<form:label path="turnId">Turn : </form:label>
					<form:select id="turnId" path="turnId" name="turnId" type="text"
						class="form-control">
						<form:options items="${aListTurn}" />
						<form:errors path="turnId" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-phone-square bigicon"></i></span>
				<div class="col-md-8">
					<form:label path="persons">Localizator : </form:label>
					<form:input id="localizator" path="localizator" name="localizator" type="text"
						placeholder="localizator" class="form-control" />
					<form:errors path="localizator" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-12 text-center">
					<form:button type="submit" class="btn btn-primary btn-lg">Cancel Booking</form:button>
				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>