<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
</style>
<title>forgotpassword</title>
</head>

<body>
<header class="w3-container w3-teal">
  <h4>Forgot Password?</h4>
</header>
<div class="topnav">
<a href="login" style="float:right" >Login Here</a>
<a href="/">Back to Home Page</a><br>
</div>
<div class="w3-container w3-half w3-margin-top">

<form class="w3-container w3-card-4" action="emailActionProcess">
<p>
<input class="w3-input" type="text" name="emailid" style="width:90%" required>
<label>Email Id:</label></p>

<p><button class="w3-button w3-section w3-teal w3-ripple" value="Send "> Send </button></p>
</form>

<form  action="otpActionProcess">
<p>
<input class="w3-input" type="text" name="userotp" style="width:90%" required>
<label>Enter OTP</label></p>

<p><button class="w3-button w3-section w3-teal w3-ripple" value="Verify OTP ">Verify OTP </button></p>

${error}
</form>
</div>
</body>
</html>