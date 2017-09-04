<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<span> <a href="allBookings">All Bookings</a>
			</span>
			<div class="clr"></div>
		</div>
		<div class="freshdesignweb-top">
			<span class="right"> <a href="logout"> <strong>Logout
				</strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span><br>Welcome ${username}
		</h1>
		</header>
		<div class="form">
			<form:form id="hotelSearchForm" modelAttribute="trip"
				action="availableHotels" method="post">
				<p class="contact">
					<form:label path="countryId">Country</form:label>
				</p>
				<form:select class="select-style" id="country" path="countryId"
					items="${countriesList}" itemValue="id" itemLabel="name"
					cssStyle="width:420px"></form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="cityId">City</form:label>
				</p>
				<form:select class="select-style" id="city" path="cityId"
					items="${citiesList}" itemValue="id" itemLabel="name"
					cssStyle="width:420px"></form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="startDate">From</form:label>
				</p>
				<form:input type="date" path="startDate" required="required"></form:input>
				<p class="contact">
					<form:label path="endDate">To</form:label>
				</p>
				<form:input type="date" path="endDate" required="required"></form:input>

				
				<input class="buttom" value="Search" type="submit" />
			</form:form>
		</div>

	</div>
</body>
</html>