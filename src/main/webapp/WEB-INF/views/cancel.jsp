<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Booking</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script>
  $( function() {
    $( "#datepicker" ).datepicker({ minDate:0});
  } );
  </script>
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
 </style> 
</head>
<body>

<div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">

	<form:form>
		<fieldset>
			<legend class="text-center header">Cancel Booking</legend>

			<form:errors path="*" element="div" cssClass="alert alert-danger" />

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-user bigicon"></i></span>
				<div class="col-md-8">
					<form:label path="restaurantName">restaurantName : </form:label>
					<form:select id="restaurantName" path="restaurantName" name="restaurantName" type="text" class="form-control">
						<form:options items="${aListRestaurant}" />
						<form:errors path="restaurantName" />
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
					<form:label path="turn">Turn : </form:label>
					<form:select id="turn" path="turn" name="turn" type="text"
						class="form-control">
						<form:options items="${aListTurn}" />
						<form:errors path="turn" />
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<span class="col-md-1 col-md-offset-2 text-center"><i
					class="fa fa-phone-square bigicon"></i></span>
				<div class="col-md-8">
					<form:label path="localizator">Localizator : </form:label>
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
	 </div>
                </div>
            </div>
        </div>
</body>
</html>