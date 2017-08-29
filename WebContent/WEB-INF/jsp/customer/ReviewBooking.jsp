<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Booking</title>
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
			<span>Hotel Reservation System</span>Review Booking
		</h1>
		</header>
		<div class="form">
			<form:form id="reviewBookingPage" modelAttribute="booking"
				action="makePayment" method="post">
				<h2>You are booking: ${hotel.hotelName} 
				<a href="bookHotel"> <img src="css/images/edit_icon.png" width="30px" height="30px"/></a> </h2><br>

				<h2>Total AC Rooms: ${booking.ac_rooms_count}</h2><br>

				<h2>Total Non-AC Rooms: ${booking.non_ac_rooms_count}</h2><br>
				<h2>From: ${trip.startDate}       To: ${trip.endDate}</h2><br>
				<h2>Total Cost: ${totalCost}</h2><br><br>
				<input class="buttom" type="submit" name="action" value="Pay Now" />
			</form:form>
		</div>
</body>
</html>