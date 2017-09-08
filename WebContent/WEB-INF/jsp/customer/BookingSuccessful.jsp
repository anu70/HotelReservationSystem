<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Successful</title>
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
			<span>Hotel Reservation System</span>Booking Successful
		</h1>
		</header>
		
		<div class="form">
			<img src="css/images/correct_icon.png" width="50px" height="50px"/><br><br>
			<b>Transaction Successful :</b>${TransactionId}<br>
			<br> <b>Your Booking id :</b> ${BookingId}<br><br>
			<b></b>
		</div><br>
		
		<div class="form">
			<span style="color: #719dab;font-weight:bold; font-size: 20pt">Payment Report:</span><br><br>
			<b> Bank Name : </b> ${payment.bank_name}<br><br>
			<b> Credit Card Number: </b>${payment.credit_card_no}<br><br>
			<b>Card Type: </b> ${payment.card_type}<br><br>
			<b>Name on Card: </b> ${payment.name_on_card}<br><br>
			<b>Expiry Date: </b> ${payment.expiry_date}<br><br>
			<b>cvv : </b> ${payment.cvv}<br><br>
			<b>Account number : </b> ${payment.account_no}<br><br>
			<b>Pin Number: </b> ${payment.atm_pin}<br><br>
			<b></b><br>
		</div>
	</div><br>
</body>
</html>