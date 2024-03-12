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
<title>Vaccination</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body
	style="background-image: url('images/images.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<header>
		<div>
			<span style="margin-left: 8%; color: white; font-size: 35px;">Ministry of health and
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

	<form action="getOTP" method="post" style="text-align: center">
		<table class="tab">
			<tr>
				<td>
					<div>
						<h1>Register For Vaccination</h1>
					</div>
					<div>
						<h4 style="color: red">${ValidationEmailID }</h4>
					</div>
					<div>
						<h4>An OTP will be sent to your mail for verification</h4>
					</div>
					<div class="container col-md-10 mb-8">
						<div class="form-group">
							<input type="email" placeholder="Enter your EmailID"
								name="emailID" class="form-control">
						</div>
					</div>
					<div>
						<button type="submit" class="btn btn-primary"
							style="text-align: center">Get OTP</button>
					</div>
				</td>
				<td><img src="images/vaccine.png" class="image"></td>
			</tr>
		</table>
	</form>
</body>
<footer>
	<div style="color: white;">Copyright © 2021. All Rights Reserved</div>
</footer>
</html>