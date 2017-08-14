<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form id="registrationForm" modelAttribute="user" action="processRegistration" method="post">
		<table align="centre">
			<tr>
				<td><form:label path="username">User name</form:label></td>
				<td><form:input path="username" />
			</tr>
			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:select path="role" items="${rolesList}"></form:select>
			</tr>
			<tr>
				<td><form:label path="email">Email Id</form:label></td>
				<td><form:input path="email" name="email" id="email" />
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:select path="country" items="${countriesList}"></form:select>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:select path="city" items="${citiesList}"></form:select>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile No.</form:label></td>
				<td><form:input path="mobile" />
			</tr>
			<tr>
				<td><form:label path="dob">Date Of Birth</form:label></td>
				<td><form:input path="dob" />
			</tr>
			
			<tr>
				<td><form:label path="pincode">Pincode</form:label></td>
				<td><form:input path="pincode" />
			</tr>
			<tr>
				<td><form:button>Register</form:button></td>
			</tr>

		</table>
	</form:form>
</body>
</html>