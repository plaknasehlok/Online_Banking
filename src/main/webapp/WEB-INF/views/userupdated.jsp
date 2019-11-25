<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
font-family: Arial, Helvetica, sans-serif;
background:url(https://www.davesworld.com/wp-content/uploads/2015/10/Heat-Pump-Rebates.jpg);
}
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
h4{
text-align: center;
color:black;
}
</style>
<body>
<!-- Toplink -->
 <div class="topnav">
	<a href="fundstransfer">NEFT</a>
	<a href="fundstransfer">RTGS</a>
	<a href="fundstransfer">IMPS</a>
	<a href="accountstatement">Account Statement</a>
	<a href="loggingout" style="float:right">LogOut</a>
</div>
<h2>Transaction complete</h2><br>

<h4>Your Balance is ${balance}</h4>
</body>
</html>