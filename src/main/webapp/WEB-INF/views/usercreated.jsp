<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.ResultSetMetaData"%>
<%@ page import="java.sql.Statement"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
font-family: Arial, Helvetica, sans-serif;
text-align:center;
background:url(http://groupvisual.io/designinganalytics/wp-content/uploads/2016/08/dvux.png);
}
* {box-sizing: border-box}
}

h3{
padding:30px;
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

</style>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<div class="topnav">
<a href="/" style="float:right" >Back to Home Page</a><br>
</div>
<h1>Your Account has been created</h1>
	<h3>user id is ${user_id}</h3>
	
</body>
</html>