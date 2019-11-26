<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>changepassword</title>
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
</head>
<body>
<div class="topnav">
<a href="/">Back to Home Page</a><br>
</div>
	<script>
		function checkpassword() {
			var p = f.password.value;
			var cp = f.password2.value;
			if (p != cp)
				alert("Password and Confirm Passwords Mismatch");
		}
		function ValidateEmail() {
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			var email = document.frm.email_id.value;
			if (email.match(mailformat)) {
				return true;
			} else {
				alert("You have entered an invalid email address!");
				return false;
			}
		}
	</script>
<header class="w3-container w3-teal">
  <h4>Change Password</h4>
</header>

<div class="w3-container w3-half w3-margin-top">

<form class="w3-container w3-card-4" name="f" action="forgetpasswordprocess">

<p>
<input class="w3-input" type="text" name="user_id" style="width:90%" onblur="ValidateEmail();" required>
<label><b>Enter User_Id:</b></label></p>
<p>
<input class="w3-input" type="password" style="width:90%" name="password"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
			title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required >
<label><b>Enter New Password</b></label></p>

<p>
<input class="w3-input" type="password"  style="width:90%" name="password2" required  onblur="checkpassword();" >
<label for="psw-repeat"><b>Confirm Password</b></label><br>



<p>
 <input type="submit" value="Confirm "></p>

</form>

</div>

</body>
</html> 