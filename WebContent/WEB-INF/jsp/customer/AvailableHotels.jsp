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
			<span> <a href="welcomeCustomer">Welcome Screen</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Available Hotels
		</h1>
		</header>
		<c:forEach items="${hotelsList.hotelList}" var="items"
			varStatus="status">
			<div class="form">
				<form:form id="availableHotelsForm" modelAttribute="hotel"
					action="bookHotel" method="post">
					<form:hidden path="hotelUniqueId" value="${items.hotelUniqueId}"/>
					<form:hidden path="hotelName" value="${items.hotelName}"/>
					<form:hidden path="rateAdultAC" value="${items.rateAdultAC}"/>
					<form:hidden path="rateChildAC" value="${items.rateChildAC}"/>
					<form:hidden path="rateAdultAC" value="${items.rateAdultAC}"/>
					<form:hidden path="rateChildNonAC" value="${items.rateChildNonAC}"/>
					<form:hidden path="rateAdultNonAC" value="${items.rateAdultNonAC}"/>
					<form:hidden path="description" value="${items.description}"/>
					<form:hidden path="countryId" value="${items.countryId}"/>
					<form:hidden path="cityId" value="${items.cityId}"/>
					<form:hidden path="hotelId" value="${items.hotelId}"/>
					<p class="contact">
						<form:label path="hotelName">${items.hotelName}</form:label>
					</p>
					<form:label path="cityId">${items.cityId},</form:label>
					<form:label path="countryId">${items.countryId}</form:label><br><br>
					
					<c:choose>
						<c:when test="${availableHotels[status.index]}">
							<input class="buttom" type="submit" name="action"
								value="Book Now" />
						</c:when>
						<c:otherwise>
							<input class="button_deactivated" type="submit" name="action"
								value="Book Now" disabled="true" />
						</c:otherwise>
					</c:choose>
				</form:form>
			</div>
			<br>

		</c:forEach>


	</div>

</body>

</html>