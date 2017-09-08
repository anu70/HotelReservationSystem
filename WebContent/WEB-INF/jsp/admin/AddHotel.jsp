<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Hotel</title>
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
			<a href="welcomeAdmin">Welcome Screen</a> <span class="right">
				<a href="logout"> <strong>Logout</strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Add Hotel
		</h1>
		</header>
		<div class="form">
			<script type="text/javascript">
				if ("${alertMessage}" === "") {

				} else {
					alert("${alertMessage}");
					if ("${errorCode}" == 0)
						window.location = 'welcomeAdmin';

				}
			</script>
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

			<h4>
				<span style="color: red">${message}</span><br> <br>
			</h4>
			<form:form id="AddHotelPage" modelAttribute="hotel"
				action="processAddHotel" method="post">
				<p class="contact">
					<form:label path="hotelId">Hotel Id</form:label>
				</p>
				<form:input path="hotelId" required="required" minlength="7"
					maxlength="7"></form:input>
				<p class="contact">
					<form:label path="hotelName">Hotel Name</form:label>
				</p>
				<form:input path="hotelName" required="required" maxlength="20"></form:input>
				<p class="contact">
					<form:label path="countryId">Country</form:label>
				</p>

				<form:select class="select-style" id="countryDropDown" required="required"
					items="${countriesList}" itemValue="id" itemLabel="name"
					path="countryId" cssStyle="width:420px">
				</form:select>
				<br>
				<br>
				<p class="contact">
					<form:label path="cityId">City</form:label>
				</p>
				<form:select class="select-style" id="cityDropDown" required="required"
				items="${startCountrycitiesList}" itemValue="id" itemLabel="name"
					name="cityDropDown" path="cityId" cssStyle="width:420px">

				</form:select>


				<br>
				<br>

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
				<form:label path="rateAdultAC">Adult: </form:label>
				<form:input path="rateAdultAC" required="required"
					cssStyle="width:80px"></form:input>
				<form:label path="rateChildAC">Child: </form:label>
				<form:input path="rateChildAC" required="required"
					cssStyle="width:80px"></form:input>

				<p class="contact">
					<form:label path="rateAdultNonAC">Non-AC Room rate</form:label>
				</p>
				<form:label path="rateAdultNonAC">Adult: </form:label>
				<form:input path="rateAdultNonAC" required="required"
					cssStyle="width:80px"></form:input>
				<form:label path="rateChildNonAC">Child: </form:label>
				<form:input path="rateChildNonAC" required="required"
					cssStyle="width:80px"></form:input>


				<p class="contact">
					<form:label path="description">Description</form:label>
				</p>
				<form:input path="description" maxlength="150"></form:input>
				<input class="buttom" value="Add Hotel" type="submit"
					name="submitButton" />
			</form:form>
		</div>
	</div>
</body>
</html>