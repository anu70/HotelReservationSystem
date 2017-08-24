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
			<a href="welcomeCustomer">Welcome Screen</a> </a> </span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Available Hotels
		</h1>
		</header>

		<form:form id="availableHotelsForm" modelAttribute="hotelsList"
			action="bookHotel" method="post">
			 <c:forEach items="${hotelsList.hotelList}" var="items"
				varStatus="status">
				<div class="form">
					<p class="contact">
						<form:label path="hotelList[${status.index}].hotelName">${items.hotelName}</form:label>
					</p>
					<input class="buttom" type="submit" name="action" value="${status.index}"/>
				</div>
				<br>
			</c:forEach> 
			
		</form:form>
	</div> 

</body>

</html>