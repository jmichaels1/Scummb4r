<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ours Restaurant</title>
</head>
<body>

        <div class="container">
            <center><h1 class="display-1"><ins>LISTA DE RESTAURANTS</ins></h1></center>
            <p> Número de Restaurants : <c:url value="${aListRestaurants.size()}" />  </p>

            <div class="row">
                <table border>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>ADDRESS</th>
                            <th>DESCRIPTION</th>
                        </tr>    
                    </thead>
                    <tbody>
                        <c:forEach items="${aListRestaurants}" var="dato">
                            <tr>
                                <td><c:out value="${dato.restaurantId}"/></td>
                                <td><c:out value="${dato.name}"/></td>
                                <td><c:out value="${dato.address}"/></td>
                                <td><c:out value="${dato.description}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>