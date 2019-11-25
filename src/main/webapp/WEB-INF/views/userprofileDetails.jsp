<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background:
		url(https://www.davesworld.com/wp-content/uploads/2015/10/Heat-Pump-Rebates.jpg);
}

* {
	box-sizing: border-box
}

input[type=text], input[type=password] {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding-left: 500px;
	padding-right: 500px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 400%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Add padding to container elements */
.container {
	padding: 10px;
}

.btn {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
	opacity: 0.9;
}

.btn:hover {
	opacity: 1;
}

/* Float signup buttons and add an equal width */
.signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding-left: 400px;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
</head>

<body>

	<script type="text/javascript">
		function AadharValidate() {
			var aadhar = document.getElementById("txtAadhar").value;
			var adharcardTwelveDigit = /^\d{12}$/;
			var adharSixteenDigit = /^\d{16}$/;
			if (aadhar != '') {
				if (aadhar.match(adharcardTwelveDigit)) {
					return true;
				} else if (aadhar.match(adharSixteenDigit)) {
					return true;
				} else {
					alert("Enter valid Aadhar Number");
					return false;
				}
			}

		}
		function mobValidate() {
			var a = document.frm.mobile_no.value;
			if (a == "") {
				alert("please Enter the Contact Number");
				document.frm.mobile_no.value;
				return false;
			}
			if (isNaN(a)) {
				alert("Enter the valid Mobile Number(Like : 9566137117)");
				document.frm.mobile_no.value;
				return false;
			}

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

		function ValidateFname() {
			var letters = /^[A-Za-z]+$/;
			var fname = document.frm.f_name.value;

			if (fname.match(letters)) {
				return true;
			} else {
				alert('First name must have alphabet characters only');
				fname.focus();
				return false;
			}
		}

		function ValidateLname() {
			var letters = /^[A-Za-z]+$/;
			var lname = document.frm.l_name.value;

			if (lname.match(letters)) {
				return true;
			} else {
				alert('Last name must have alphabet characters only');
				lname.focus();
				return false;
			}
		}

		function ValidateMname() {
			var letters = /^[A-Za-z]+$/;
			var mname = document.frm.m_name.value;

			if (mname.match(letters)) {
				return true;
			} else {
				alert('Middle name must have alphabet characters only');
				mname.focus();
				return false;
			}
		}

		function ValidateFathers_name() {
			var letters = /^[A-Za-z]+$/;
			var fathername = document.frm.fathers_name.value;

			if (fathername.match(letters)) {
				return true;
			} else {
				alert('father name must have alphabet characters only');
				fathername.focus();
				return false;
			}
		}

		function ValidateResAddress() {
			var letters = /^[0-9a-zA-Z]+$/;
			var resaddr = document.frm.res_addr.value;

			if (resaddr.match(letters)) {
				return true;
			} else {
				alert('Residential address must have alphanumeric characters only');
				uadd.focus();
				return false;
			}
		}

		function ValidatePerAddress() {
			var letters = /^[0-9a-zA-Z]+$/;
			var peraddr = document.frm.per_addr.value;

			if (peraddr.match(letters)) {
				return true;
			} else {
				alert('Permanent address must have alphanumeric characters only');
				uadd.focus();
				return false;
			}
		}
	</script>

	<form name="frm" method="get" action="userprofileprocess">
		<div class="container">
			<h1 text-align="center">User Profile Info</h1>

			<p>
				<label for="text"><b>Aadhar No.:</b></label><br> <input
					type="text" id="txtAadhar" name="aadhar_no"
					onblur="AadharValidate();" />
			</p>
			<p>
				<label for="text"><b> First Name: </b></label> <br> <input
					type="text" name="f_name" required onblur="ValidateFname();" />
			</p>

			<p>
				<label for="text"><b>Last Name: </b></label> <br> <input
					type="text" name="l_name" required onblur="ValidateLname();" />

			</p>

			<p>

				<label for="text"><b> Middle Name: </b></label><br> <input
					type="text" name="m_name" onblur="ValidateMname();" />

			</p>

			<p>

				<label for="text"><b> Father's Name:</b></label><br> <input
					type="text" name="fathers_name" onblur="ValidateFathers_name();" />

			</p>

			<p>

				<label for="text"><b> Mobile No.: </b></label><br> <input
					type="text" id="txtMob" name="mobile_no" minlength="10"
					maxlength="10" title="Mobile number should contain 10 digits"
					required onblur="mobValidate();" />

			</p>

			<p>

				<label for="text"><b> Email Id: </b></label><br> <input
					type="text" name="email_id" required onblur="ValidateEmail();" /> <p>

				<label for="date"><b> Date of Birth: </b></label><br><input
					type="date" name="dob" required />
			</p>
		
		<p>
			
			<label for="text"><b> Residential Address: </b></label><br>

	<input type="text" name="res_addr" required
					onblur="ValidateResAddress();" />

	</p>
			
			<p>
			
			<label for="text"><b> Permanent Address: </b></label><br>

	<input type="text" name="per_addr" required
					onblur="ValidatePerAddress();" />

	</p>
			
			<p>
			
			<label for="text"><b> Occupational Details(Service/Business): </b></label><br>

	<input type="text" name="occ_details" required />
</p>
	<input class="btn" type="submit" value="Create Account" />

	
	</form>


</body>
</html>










