<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Hotel</title>
</head>
<body>
	<form:form id="addHotelForm" modelAttribute="hotel"
		action="processHotelAddition" method="post">
		<table>
			<tr>
				<td><form:label path="hotelId">Hotel Id</form:label></td>
				<td><form:input path="hotelId" /></td>
			</tr>
			<tr>
				<td><form:label path="hotelName">Hotel Name</form:label></td>
				<td><form:input path="hotelName" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:select path="country" items="${countriesList}"></form:select></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:select path="city" items="${citiesList}"></form:select></td>
			</tr>
			<tr>
				<td><form:label path="acRoomsCount">No. of AC Rooms</form:label></td>
				<td><form:input path="acRoomsCount" /></td>
			</tr>
			<tr>
				<td><form:label path="nonACRoomsCount">No. of Non-AC Rooms</form:label></td>
				<td><form:input path="nonACRoomsCount" /></td>
			</tr>
			
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>