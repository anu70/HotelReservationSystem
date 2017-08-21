<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Hotel</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<a href="welcomeAdmin">Home</a> </a> </span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Edit Hotel
		</h1>
		</header>
		<div class="form">
			<form:form id="EditHotelPage" modelAttribute="hotel"
				action="processEditHotel" method="post">
				<p class="contact">
					<form:label path="hotelId">Hotel Id</form:label>
				</p>
				<form:select class="select-style" path="identifyHotel"
					items="${hotelIds}" cssStyle="width:420px"></form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="hotelName">Hotel Name</form:label>
				</p>
				<form:input path="hotelName" required="required" maxlength="20"></form:input>
				
				<p class="contact">
					<form:label path="acRoomsCount">No. of AC Rooms</form:label>
				</p>
				<form:input path="acRoomsCount" required="required" 
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'></form:input>
					
				<p class="contact">
					<form:label path="nonACRoomsCount">No. of Non-AC Rooms</form:label>
				</p>
				<form:input path="nonACRoomsCount" required="required"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'></form:input>
					
				<p class="contact">
					<form:label path="rateAdultAC">AC Room rate</form:label>
				</p>
				<form:input path="rateChildAC" required="required"></form:input>
				<form:input path="rateAdultAC" required="required"></form:input>
				
				<p class="contact">
					<form:label path="rateAdultNonAC">Non-AC Room rate</form:label>
				</p>
				<form:input path="rateChildNonAC" required="required"
					placeholder="child"></form:input>
				<form:input path="rateAdultNonAC" required="required"
					placeholder="adult"></form:input>

				<p class="contact">
					<form:label path="description">Description</form:label>
				</p>
				<form:input path="description" maxlength="150"></form:input>
				<input class="buttom" value="Update" type="submit" />
			</form:form>
		</div>
	</div>
</body>
</html>