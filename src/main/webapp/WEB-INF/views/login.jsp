<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<title>Login  </title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">


<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/JS/Js/login.js"/>"></script>
</head>

<body>
<div class="mainbody">
<p><%=session.getAttribute("username") %></p>
	<form action="/java/loginpage" method="post">
	
	<p>${errormessage} </p>
		<div class="imgcontainer">
			<img src="/Images/login.png" alt="GPS21" class="avatar">
		</div>

		<div class="container">
			<label class="fsize"><b>Username</b></label> <input type="text" class="fsize"
				placeholder="Enter Username" name="login" required> <label class="fsize"><b>Password</b></label>
			<input type="password" class="fsize" placeholder="Enter Password" name="password"
				required>

			<button type="submit" >Login</button>
			<input type="checkbox" class="fsize" > Remember me</input>
		</div>

		<div class="container" style="background-color: #f1f1f1">
	<button onclick="closewindow();return false;" type="button"  class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>

</div>

</body>
</html>