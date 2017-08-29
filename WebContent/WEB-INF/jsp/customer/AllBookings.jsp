<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Bookings</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<span> <a href="welcomeCustomer">Welcome Screen</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> All bookings
		</h1>
		</header>
		<c:forEach items="${bookingsList}" var="items" varStatus="status">
			<div class="form">
				${items.id} ${items.hotel_id} ${items.start_date} ${items.end_date}
				${items.total_cost} <a href="welcomeCustomer"> <img
					src="css/images/edit_icon.png" width="30px" height="30px" /></a>
				</h2>
				 <a href="welcomeCustomer"> <img
					src="css/images/cancel-icon.png" width="30px" height="30px" /></a>
				</h2>
				<br>
			</div>
			<br>

		</c:forEach>


	</div>

</body>

</html>