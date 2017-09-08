<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Hotel</title>
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
			<a href="welcomeAdmin">Welcome Screen</a> </a> </span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Delete Hotel
		</h1>
		</header>
		<div class="form">
			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									$('#hotelIdDropDown')
											.change(
													function() {
														var hotelId = $(this)
																.val();
														<c:forEach var="hotel" items="${hotelsList}" varStatus="status">
														if ("${hotel.hotelId}" === hotelId) {
															$('#hotelName')
																	.val(
																			"${hotel.hotelName}");
															$('#countryId')
																	.val(
																			"${hotel.countryId}");
															$('#cityId')
																	.val(
																			"${hotel.cityId}");
															$('#description')
																	.val(
																			"${hotel.description}");
															$('#acRoomsCount')
																	.val(
																			"${hotel.acRoomsCount}");
															$(
																	'#nonACRoomsCount')
																	.val(
																			"${hotel.nonACRoomsCount}");
															$('#rateChildAC')
																	.val(
																			"${hotel.rateChildAC}");
															$('#rateAdultAC')
																	.val(
																			"${hotel.rateAdultAC}");
															$('#rateChildNonAC')
																	.val(
																			"${hotel.rateChildNonAC}");
															$('#rateAdultNonAC')
																	.val(
																			"${hotel.rateAdultNonAC}");
															$('#hotelUniqueId')
																	.val(
																			"${hotel.hotelUniqueId}");
															return false;
														}
														</c:forEach>
													});
								});
			</script>
			 <script type="text/javascript">
				$('#deleteHotelPage').submit(function() {
					var c = confirm("Click OK to continue?");
					return c; //you can just return c because it will be true or false
				});
			</script> 
			<script type="text/javascript">
				if ("${alertMessage}" === "") {

				} else {
					alert("${alertMessage}");
					if ("${errorCode}" == 0)
						window.location = 'welcomeAdmin';

				}
			</script>
			<form:form id="deleteHotelPage" modelAttribute="hotel"
				action="processDeleteHotel" method="post">
				<p class="contact">
					<form:label path="hotelId">Hotel Id</form:label>
				</p>
				<form:select id="hotelIdDropDown" class="select-style"
					path="hotelId" items="${hotelsList}" itemValue="hotelId"
					itemLabel="hotelId" cssStyle="width:420px" required="required"></form:select>
				<br>
				<br>
				<form:hidden path="hotelUniqueId" id="hotelUniqueId"
					value="${hotel.hotelUniqueId}" />
				<p class="contact">
					<form:label path="hotelName">Hotel Name</form:label>
				</p>
				<form:input path="hotelName" id="hotelName" required="required"
					maxlength="20" readonly="true"></form:input>
				<p class="contact">
					<form:label path="countryId">Country</form:label>
				</p>
				<form:input path="countryId" id="countryId" required="required"
					readonly="true"></form:input>
				<p class="contact">
					<form:label path="cityId">City</form:label>
				</p>
				<form:input path="cityId" id="cityId" required="required"
					readonly="true"></form:input>
				<p class="contact">
					<form:label path="acRoomsCount">No. of AC Rooms</form:label>
				</p>
				<form:input path="acRoomsCount" id="acRoomsCount"
					required="required"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					readonly="true"></form:input>

				<p class="contact">
					<form:label path="nonACRoomsCount">No. of Non-AC Rooms</form:label>
				</p>
				<form:input path="nonACRoomsCount" id="nonACRoomsCount"
					required="required"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					readonly="true"></form:input>

				<p class="contact">
					<form:label path="rateAdultAC">AC Room rate</form:label>
				</p>
				<form:label path="rateAdultAC">Adult: </form:label>
				<form:input path="rateAdultAC" id="rateAdultAC" required="required"
					cssStyle="width:80px" readonly="true"></form:input>
				<form:label path="rateChildAC">Child: </form:label>
				<form:input path="rateChildAC" id="rateChildAC" required="required"
					cssStyle="width:80px" readonly="true"></form:input>

				<p class="contact">
					<form:label path="rateAdultNonAC">Non-AC Room rate</form:label>
				</p>
				<form:label path="rateAdultNonAC">Adult: </form:label>
				<form:input path="rateAdultNonAC" id="rateAdultNonAC"
					required="required" cssStyle="width:80px" readonly="true"></form:input>
				<form:label path="rateChildNonAC">Child: </form:label>
				<form:input path="rateChildNonAC" id="rateChildNonAC"
					required="required" cssStyle="width:80px" readonly="true"></form:input>


				<p class="contact">
					<form:label path="description">Description</form:label>
				</p>
				<form:input path="description" id="description" maxlength="150"
					readonly="true"></form:input>
				<input class="buttom" value="Delete" type="submit" />
			</form:form>
		</div>
	</div>
</body>
</html>