<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<script type="text/javascript" src="css/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<c:url value="css/jquery-3.2.1.js" />"></script>
<script type="text/javascript">
	window.scrollTo(0, 1);
</script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery-1.6.1.min.js" />"></script>
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<a href="home">Home</a> <span class="right"> <a href="login">
					<strong>Already registered? Login here. </strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Registration Form
		</h1>
		</header>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#countryDropDown').change(function() {

					var countryId = $(this).val();
					$('#cityDropDown').empty();
					<c:forEach var="city" items="${citiesList}" varStatus="status">
					if ("${city.country_id}" == countryId) {
						$('#cityDropDown').append($('<option>', {
							value : "${city.id}",
							text : "${city.name}"
						}));
					}
					</c:forEach>
				});
			});
		</script>
		<div class="form">
			<h4>
				<span style="color: red">${message}</span><br> <br>
			</h4>
			<form:form id="registrationForm" modelAttribute="user"
				action="processRegistration" method="post">
				<form:errors />
				<p class="contact">
					<form:label path="username">Username</form:label>
				</p>
				<form:input path="username" maxlength="20" minlength="3"
					required="required"></form:input>
				<p class="contact">
					<form:label path="role">Role</form:label>
				</p>
				<form:select class="select-style" path="role" items="${rolesList}"
					cssStyle="width:420px"></form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="email" maxlength="50">Email Id</form:label>
				</p>
				<form:input path="email" name="email" id="email" required="required"
					type="email" />
				<p class="contact">
					<form:label path="password">Password</form:label>
				</p>
				<form:password path="password" name="password" id="password"
					required="required" minlength="8" maxlength="30" />
				<p class="contact">
					<form:label path="country">Country</form:label>
				</p>
				<form:select class="select-style" id="countryDropDown"
					path="country" items="${countriesList}" itemValue="id"
					required="required" itemLabel="name" cssStyle="width:420px"></form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="city">City</form:label>
				</p>
				<form:select class="select-style" id="cityDropDown" path="city"
					items="${startCountrycitiesList}" itemValue="id" itemLabel="name"
					required="required" cssStyle="width:420px"></form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="mobile">Mobile No.</form:label>
				</p>
				<form:input path="mobile" required="required" type="text"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					minlength="10" maxlength="10" />
				<p class="contact">
					<form:label path="dob">Date Of Birth</form:label>
				</p>
				<form:input type="date" path="dob" required="required" />
				<p class="contact">
					<form:label path="pincode">Pincode</form:label>
				</p>
				<form:input path="pincode" required="required" type="text"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					minlength="6" maxlength="6" />
				<input class="buttom" value="Register" type="submit" />

			</form:form>
		</div>

	</div>

</body>
</html>