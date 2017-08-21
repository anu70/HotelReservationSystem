<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Hotel</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<a href="welcomeAdmin">Welcome Screen</a> </a> </span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Delete Hotel
		</h1>
		</header>
		<div class="form">
			<form:form id="deleteHotelPage" modelAttribute="hotel"
				action="processDeleteHotel" method="post">
				<p class="contact">
					<form:label path="hotelId">Hotel Id</form:label>
				</p>
				<form:select class="select-style" path="identifyHotel"
					items="${hotelIds}" cssStyle="width:420px" required="required"></form:select>
				<br>
				<br>
				<input class="buttom" value="Delete" type="submit" />
			</form:form>
		</div>
	</div>
</body>
</html>