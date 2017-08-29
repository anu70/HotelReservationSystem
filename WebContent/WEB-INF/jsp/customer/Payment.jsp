<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Payment</title>
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
			<span>Hotel Reservation System</span>Payment
		</h1>
		</header>
		<div class="form">
			<form:form id="paymentForm" modelAttribute="payment"
				action="bookingSuccessful" method="post">
				<p class="contact">
					<form:label path="card_type">Credit Card Type</form:label>
				</p>
				<form:select class="select-style" path="card_type"
					items="${cardTypes}" cssStyle="width:420px"></form:select>
				<br>
				<br>

				<p class="contact">
					<form:label path="credit_card_no">Credit Card No.</form:label>
				</p>
				<form:input path="credit_card_no" required="required" type="text"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					minlength="16" maxlength="16" />

				<p class="contact">
					<form:label path="name_on_card">Name On Card:</form:label>
				</p>
				<form:input path="name_on_card" maxlength="30" minlength="3"
					required="required"></form:input>

				<p class="contact">
					<form:label path="expiry_date">Expiry Date</form:label>
				</p>
				<form:input type="date" path="expiry_date" required="required"></form:input>

				<p class="contact">
					<form:label path="cvv">cvv</form:label>
				</p>
				<form:input path="cvv" required="required" type="text"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					minlength="3" maxlength="3" />

				<p class="contact">
					<form:label path="atm_pin">ATM Pin</form:label>
				</p>
				<form:input path="atm_pin" required="required" type="text"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					minlength="6" maxlength="6" />
				<br>
				<p class="contact">
					<form:label path="account_no">Account No.</form:label>
				</p>
				<form:input path="account_no" required="required" type="text"
					onkeypress='return event.charCode >= 48 && event.charCode <= 57'
					minlength="10" maxlength="10" /><br>
				Are you a senior citizen? <form:checkbox path="is_senior_citizen" />
				<br>

				<input class="buttom" value="Pay" type="submit" />
			</form:form>
		</div>
	</div>
</body>
</html>