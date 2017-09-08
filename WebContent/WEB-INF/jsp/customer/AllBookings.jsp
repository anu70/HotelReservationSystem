<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="css/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<c:url value="css/jquery-3.2.1.js" />"></script>
<script type="text/javascript">
	window.scrollTo(0, 1);
</script>
</head>
<body>
	<script type="text/javascript">
		if ("${alertMessage}" === "") {

		} else {
			alert("${alertMessage}");

		}
	</script>
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
				<form:form id="allBookingsForm" modelAttribute="booking"
					action="changeBooking" method="post">
					<span style="font-weight: bold"> ${items.id}
						${hotelsList[status.index].hotelName} ${items.start_date}
						${items.end_date} ${items.total_cost} </span>
					<form:hidden path="id" value="${items.id}" />
					<form:hidden path="hotel_id" value="${items.hotel_id}" />
					<form:hidden path="user_id" value="${items.user_id}" />
					<form:hidden path="booking_date" value="${items.booking_date}" />
					<form:hidden path="start_date" value="${items.start_date}" />
					<form:hidden path="end_date" value="${items.end_date}" />
					<form:hidden path="adults_count" value="${items.adults_count}" />
					<form:hidden path="child_count" value="${items.child_count}" />
					<form:hidden path="ac_rooms_count" value="${items.ac_rooms_count}" />
					<form:hidden path="non_ac_rooms_count"
						value="${items.non_ac_rooms_count}" />
					<form:hidden path="total_cost" value="${items.total_cost}" />

					<input type="submit" name="action" value="edit" />
					<input type="submit" name="action" value="cancel"
						background="<c:url value='css/images/cancel-icon.png' />" />
					<!-- <a href="welcomeCustomer"> <img
					src="css/images/edit_icon.png" width="30px" height="30px" /></a>
				</h2>
				<a href="welcomeCustomer"> <img src="css/images/cancel-icon.png"
					width="30px" height="30px" /></a>
				</h2> -->
				</form:form>
				<br>
			</div>
			<br>

		</c:forEach>


	</div>

</body>

</html>