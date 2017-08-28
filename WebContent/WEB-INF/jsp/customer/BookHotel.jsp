<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Hotel</title>
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
			<span>Hotel Reservation System</span>Book Hotel
		</h1>
		</header>
		<div class="form">
			<form:form id="bookHotelPage" modelAttribute="booking"
				action="reviewBooking" method="post">
				<h3>You are booking: ${hotel.hotelName}</h3>
				<br>

				<h3>Cost of AC Room: ${hotel.rateAdultAC}/${hotel.rateChildAC}</h3>
				<br>

				<h3>Cost of Non-AC Room: ${hotel.rateAdultNonAC}/
					${hotel.rateChildNonAC}</h3>
				<br>

				<p class="contact">
					<form:label path="ac_rooms_count">No. Of AC Rooms</form:label>
				</p>
				<form:input path="ac_rooms_count" required="required"></form:input>
				<p class="contact">
					<form:label path="non_ac_rooms_count">No. Of Non-AC Rooms</form:label>
				</p>
				<form:input path="non_ac_rooms_count" required="required"></form:input>
				<p class="contact">${hotel.description}</p>
				<br>
				<input class="buttom" type="submit" name="action" value="Book Now" />
			</form:form>
		</div>
</body>
</html>