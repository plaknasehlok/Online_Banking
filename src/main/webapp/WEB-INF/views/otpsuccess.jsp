<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
	<h1>otp success</h1>
	<form name="f" action="forgetpasswordprocess">

		<span>Enter User_Id</span> <input type="text" name="user_id" required
			onblur="ValidateEmail();" /> <span>Enter new password</span> <input
			type="password" name="password"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
			title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
			required /> <label for="psw-repeat"><b>Confirm Password</b></label><br>
		<input type="password" name="password2" required
			onblur="checkpassword();" /> <input type="submit" value="Confirm ">
	</form>
</body>
</html>