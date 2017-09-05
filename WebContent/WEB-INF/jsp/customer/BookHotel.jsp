<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Hotel</title>
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
		<script type="text/javascript">
				$(document)
						.ready(
								function() {
									$('#startDate')
											.change(
													function() {
														var startDate=$(this).val();
														var nextDaydate = new Date(startDate);
														nextDaydate.setDate(nextDaydate.getDate() + 1);
														var next7Daydate = new Date(startDate);
														next7Daydate.setDate(next7Daydate.getDate() + 7);
														$('#endDate').attr('min',dateString(nextDaydate));
														$('#endDate').attr('max',dateString(next7Daydate));
													});
								});
				
				function dateString(date){
					var day = date.getDate()+"";
					var mon = (date.getMonth()+1)+"";
					var year = date.getFullYear()+"";
					if(day.length==1)
						day = "0"+day;
					if(mon.length==1)
						mon = "0"+mon;
					var dateStr =  year+'-'+ mon +'-'+ day;
					return dateStr;
				}
			</script> 
			<form:form id="bookHotelPage" modelAttribute="booking"
				action="reviewBooking" method="post">
				<form:hidden path="id" value="${booking.id}"/>
				<h3>You are booking: ${hotel.hotelName}</h3>
				<br>

				<h3>Cost of AC Room: ${hotel.rateAdultAC}/${hotel.rateChildAC}</h3>
				<br>

				<h3>Cost of Non-AC Room: ${hotel.rateAdultNonAC}/
					${hotel.rateChildNonAC}</h3>
				<br>
				<p class="contact">
					<form:label path="start_date">From</form:label>
				</p>
				<form:input type="date" path="start_date" id="startDate" required="required" min="${todaysDate}"></form:input>
				<p class="contact">
					<form:label path="end_date">To</form:label>
				</p>
				<form:input type="date" path="end_date" id="endDate" required="required"></form:input>
				<p class="contact">
					<form:label path="ac_rooms_count">No. Of AC Rooms</form:label>
				</p>
				<form:input type="number" path="ac_rooms_count" required="required" min="0" max="${hotel.leftACRoom}"></form:input>
				<p class="contact">
					<form:label path="non_ac_rooms_count">No. Of Non-AC Rooms</form:label>
				</p>
				<form:input type="number" path="non_ac_rooms_count" required="required" min="0" max="${hotel.leftNonACRoom}"></form:input>
				<p class="contact">${hotel.description}</p>
				<br>
				<p class="contact">
					<form:label  path="adults_count" >No. of Adults</form:label>
				</p>
				<form:input type="number" path="adults_count" min="0" required="required"></form:input>
				<p class="contact">
					<form:label  path="child_count" >No. of Child</form:label>
				</p>
				<form:input type="number" path="child_count" min="0" required="required"></form:input><br>
				<input class="buttom" type="submit" name="action" value="Book Now" />
			</form:form>
		</div>
</body>
</html>