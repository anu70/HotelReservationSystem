<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotels List</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<a href="welcomeCustomer">Welcome Screen</a> </a> </span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Available Hotels
		</h1>
		</header>

		<c:if test="${not empty lists}">

			<ul>
				<c:forEach var="listValue" items="${lists}">
					<li><div class="container">
							<div class="form">
								<form:form id="hotelDetailsRow" modelAttribute="listValue"
									action="welcomeCustomer" method="get">
									<h4>${listValue.hotelName}</h4>
									<h4>${listValue.city},${listValue.country}</h4><br>
									<input class="buttom" value="Book Now" type="submit" />
								</form:form>
							</div>
						</div><br></li>
				</c:forEach>
			</ul>

		</c:if>
	</div>

</body>

</html>