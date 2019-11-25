<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>otp mail </title>
</head>
<body>
<h1>enter mail</h1>
<form  action="emailActionProcess">

<span>Email ID :</span> <input type="text" name="emailid" size="65" required/>
<input type="submit" value="Send "> 
</form>

<form  action="otpActionProcess">
<span>Enter Otp :</span><input type="text" name="userotp" required />
<input type="submit" value="Verify OTP ">
${error}


<!-- <span>otp</span> <input type="number" name="userotp" size="65" />
<input type="button" value="Send E-mail">  -->
</form>
</body>
</html>