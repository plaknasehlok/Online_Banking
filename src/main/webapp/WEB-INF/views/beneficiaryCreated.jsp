<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
font-family: Arial, Helvetica, sans-serif;
background:url(http://groupvisual.io/designinganalytics/wp-content/uploads/2016/08/dvux.png);
}
* {box-sizing: border-box}
}
h1{
text-align:center;
padding-top: 25px;
}

h4{
text-align:center;
padding-top: 40px;
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
  font-size: 20px;
}
/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
</style>
<script type="text/javaScript">
function disableBackButton() {
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
<meta charset="ISO-8859-1">
<title>beneficiaryadded</title>
</head>
<body>

<!-- Toplink -->
 <div class="topnav">
	<a href="fundstransfer">NEFT</a>
	<a href="fundstransfer">RTGS</a>
	<a href="fundstransfer">IMPS</a>
	<a href="accountstatement">Account Statement</a>
	<a href="loggingout" style="float:right">LogOut</a>
</div>

<h1>Beneficiary Added !!!!</h1>

<h4>Beneficiary Name:  ${bene_nickname}</h4>
<h4>Your beneficiary Bank Name is ${bene_bankname}</h4>
</body>
</html>