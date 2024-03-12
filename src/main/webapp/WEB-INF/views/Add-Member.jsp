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
<title>Add-Member</title>
</head>
<body
	style="background-image: url('images/images.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<header>
		<div>
			<span style="margin-left: 8%; color: white; font-size: 35px;">Ministry of
				health and family welfare</span>
			<!-- <div>
				<a href="getLogin.vaccine"
					style="text-align: right; margin-left:5%; margin-bottom: 50%; font-size: large; color: white;">Login</a>
				<a href="getSignUp.vaccine"
					style="text-align: right; margin-left:80%; margin-bottom: 50%; font-size: large;color: white;">SignUp</a>
			</div>
 -->
			<!-- <img src="images/logo.jpg" class="logo" /> -->
		</div>
	</header>

	<form action="addMember" method="post" style="text-align: center;">
		<h1 style="font-size: medium;">Your Photo ID will be verified at the time of your
			vaccination appointment</h1>
			<h3 style="color: red;margin-top: 0px">${MemberCountMsg}</h3>
		<label>Name</label> <input name="name" type="text"
			placeholder="Your Name">
		<p style="color: red;margin-top: 0px">${validateName}</p>
		<label>Gender</label> <input name="gender" type="radio" value="Male">Male
		<input name="gender" type="radio" value="Female">Female <input
			name="gender" type="radio" value="Others">Others
		<p style="color: red;margin-top: 0px">${validateGender}</p>
		<label>Date of Birth</label> <input name="dob" type="date"
			placeholder="DOB">
		<p style="color: red;margin-top: 0px">${validateDob}</p>
		<label>Photo ID Proof</label> <select name="photoIdProof">
			<option>ID Proof</option>
			<option>Aadhar card</option>
			<option>Pan card</option>
			<option>Voter ID</option>
			<option>Driving Licence</option>
			<option>Passport</option>
		</select>
		<p style="color: red;margin-top: 0px">${validateId}</p>
		 <label>Photo ID Number</label> <input name="photoIdNumber"
			type="text" placeholder="ID Number">
		<p style="color: red;margin-top: 0px">${validateIdNumber}</p>
		<label>Vaccine Type</label> <select name="vaccineType">
			<option>Type</option>
			<option>Covishield</option>
			<option>Covaxin</option>
			<option>Sputnik</option>
		</select>
		<p style="color: red;margin-top: 0px">${validateType}</p>
		 <label>Dose</label> <select name="dose">
			<option>Doses</option>
			<option>Dose 1</option>
			<option>Dose 2</option>
			<option>Booster Dose</option>
		</select>
		<p style="color: red;margin-top: 0px">${validateDoses}</p>
		 <input type="submit" class="btn btn-primary"
			style="text-align: center" value="Add Member" />
	</form>
	<footer>
		<div>Copyright © 2021. All Rights Reserved</div>
	</footer>
</body>
</html>