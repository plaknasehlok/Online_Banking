<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
footer {
  background-color: #777;
  
  text-align: center;
  color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Profile Created</title>
</head>
<body>

<div class="topnav">
<a href="login" style="float:right" >Login Here</a>
</div>
<h2>Welcome ${f_name}</h2><br>
<h4>Your User Id is ${user_profile_id}</h4><br>
<h4>Your Aadhar No. is ${aadhar_no}</h4>

<footer>
  <p>Please remember the above details</p>
 
</footer>
</body>
</html>