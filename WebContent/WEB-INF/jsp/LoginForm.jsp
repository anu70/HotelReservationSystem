<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body>
	<form:form id="loginForm" modelAttribute="login" action="processLogin"
		method="post">
		<table>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username"></form:input></td>
				<td><form:errors path="username"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password"></form:password></td>
			</tr>
			<tr>
				<td><form:button>Login</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>