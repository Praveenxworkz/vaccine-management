<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/style.css">
<title>Login</title>
</head>
<body
	style="background-image: url('images/images.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<header>
		<div>
			<span style="margin-left: 8%; color: white; font-size: 35px">Ministry of health and
				family welfare</span>
			<div>
				<a href="getLogin"
					style="text-align: right; margin-left:5%; margin-bottom: 50%; font-size: large; color: white;">Login</a>
				<a href="getSignUp"
					style="text-align: right; margin-left:80%; margin-bottom: 50%; font-size: large;color: white;">SignUp</a>
			</div>

			<!-- <img src="images/logo.jpg" class="logo" /> -->
		</div>
	</header>

	<div class="container-fluid p-0 m-0">
		<div>
			<h1>Login page</h1>
		</div>
		<div style="text-align: center;">
			<h2>${validateMessage }</h2>
		</div>
		<p style="text-align: center; color: red">${LoginAttempts }</p>
		<p style="text-align: center; color: red">${Wrongpassword }</p>
		<form action="login" method="post" style="text-align: center;">
			<label>User Name</label> <input name="userName"
				placeholder="Enter your user name" type="text" />
			<p style="color: red">${validateUserName }</p>
			<label>Password</label> <input name="password"
				placeholder="Enter your password" type="password">
			<p style="color: red">${validatePassword }</p>
			<br /> <input type="submit" value="Login" class="btn btn-success">
			<a href="resetpassword" >Forgot Password</a>
			<h2 style="text-align: center;">${validateUpdatedMsg }</h2>
		</form>
	</div>
</body>
<footer>
	<div>Copyright © 2021. All Rights Reserved</div>
</footer>
</html>