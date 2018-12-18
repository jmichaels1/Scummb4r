<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet" />
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
						<h1>Hello world : </h1>
						<P>The name is : ${name}.</P>
				</div>
			</div>
		</div>
	</div>

	

</body>
</html>