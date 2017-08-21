<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<span class="right"> <a href="logout"> <strong>Logout </strong>
			</a>
			</span>
			<div class="clr"></div>
		</div>
		<header>
		<h1>
			<span>Hotel Reservation System</span><br>Welcome ${username}
		</h1>
		</header>
		<div class="freshdesignweb-demos">
			<a href="addHotel">Add Hotel</a>
		</div>
		<div class="freshdesignweb-demos">
			<a href="login">Delete Hotel</a>
		</div>
		<div class="freshdesignweb-demos">
			<a href="editHotel">Edit Hotel</a>
		</div>
	</div>

</body>
</html>