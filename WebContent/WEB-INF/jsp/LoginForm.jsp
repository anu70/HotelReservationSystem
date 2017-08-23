<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>

<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<a href="home">Home</a>
			 <span class="right"> <a href="register"> <strong>Register
						here</strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span> Login
		</h1>
		</header>
		<div class="form">
			<form:form id="loginForm" modelAttribute="login"
				action="processLogin" method="post">
				<p class="contact">
					<form:label path="email">Email id</form:label>
				</p>
				<form:input path="email" required="required" maxlength="50"></form:input>
				<p class="contact">
					<form:label path="password">Password</form:label>
				</p>
				<form:password path="password" required="required"  minlength="8" maxlength="30"></form:password>
				<input class="buttom" value="Login" type="submit" />
			</form:form>
		</div>
		<h4><span style="color:red">${message}</span></h4>
	</div>
</body>
</html>