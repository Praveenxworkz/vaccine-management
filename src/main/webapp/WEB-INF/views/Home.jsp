<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Home</title>
</head>
<body
	style="background-image: url('images/images.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
	<header>
		<div>
			<span style="margin-left: 8%; color: white; font-size: 35px;">Ministry
				of health and family welfare</span>
			<div>
				<span
					style="text-align: right; margin-left: 80%; margin-bottom: 50%; font-size: large; color: white;">${username}</span>
				<a href="logout"
					style="text-align: right; font-size: large; color: white;"
					class="btn btn-secondary" role="button">Logout</a>
			</div>
		</div>
	</header>
	<%
		if (session.getAttribute("UserName") == null) {
	%>
	<c:redirect url="/Home/Login"></c:redirect>
	<%
		}
	%>
	<div
		style="text-align: center; margin-left: 20px; font-size: 28px; font-weight: bold;">Welcome
		to Co-Vaccine</div>
	<h2
		style="margin-left: 560px; color: green; font-size: medium; font-weight: bold; margin-top: 5px; margin-bottom: 15px">${verifyMessage}</h2>
	<h2
		style="margin-left: 560px; color: green; font-size: medium; font-weight: bold; margin-top: 5px; margin-bottom: 15px">${savedMsg}</h2>
	<a href="addMember" class="btn btn-primary btn-lg active"
		role="button" aria-pressed="true"
		style="margin-left: 600px; margin-top: 0px; margin-bottom: 0px">Add
		Member</a>
</body>
<br />
<div>
	<a href="membersList"
		style="text-align: left; margin-left: 620px; font-size: large; margin-top: 0px">Members
		List</a>
	<h3
		style="text-align: center; margin-top: 10px; font-size: large; margin-bottom: 0px">With
		one account 6 members can be added for vaccination</h3>
	<table style="width: 100%; margin-top: 0px">
		<thead style="border-bottom: 1px solid #ddd; padding: 10px">
			<tr align="center"
				style="border-bottom: 1px solid #ddd; padding: 10px">
				<th scope="col" style="padding: 10px">Name</th>
				<th scope="col" style="padding: 10px">Gender</th>
				<th scope="col" style="padding: 10px">Date Of Birth</th>
				<th scope="col" style="padding: 10px">PhotoIdProof</th>
				<th scope="col" style="padding: 10px">PhotoIdNumber</th>
				<th scope="col" style="padding: 10px">VaccineType</th>
				<th scope="col" style="padding: 10px">Dose</th>
			</tr>
		</thead>
		<c:forEach items="${MembersList}" var="membersList">
			<tbody style="border-bottom: 1px solid #ddd; padding: 10px">
				<tr align="center"
					style="border-bottom: 1px solid #ddd; padding: 10px">
					<td scope="row" style="padding: 10px">${membersList.name }</td>
					<td scope="row" style="padding: 10px">${membersList.gender }</td>
					<td scope="row" style="padding: 10px">${membersList.dob }</td>
					<td scope="row" style="padding: 10px">${membersList.photoIdProof }</td>
					<td scope="row" style="padding: 10px">${membersList.photoIdNumber }</td>
					<td scope="row" style="padding: 10px">${membersList.vaccineType }</td>
					<td scope="row" style="padding: 10px">${membersList.dose }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
<footer>
	<div>Copyright © 2021. All Rights Reserved</div>
</footer>
</html>