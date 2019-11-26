<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Dashboard</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">

<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:10px;
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
<body>
<!-- Toplink -->
 <div class="topnav">
	<a href="fundstransfer">NEFT</a>
	<a href="fundstransfer">RTGS</a>
	<a href="fundstransfer">IMPS</a>
	<a href="beneficiary">Add Beneficiary</a>
	<a href="accountstatement">Account Statement</a>
	<a href="loggingout" style="float:right">LogOut</a>
</div>


<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

  <!-- Header -->
  <div class="w3-container" style="margin-top:40px" id="showcase">
    <h1><b>Dashboard</b></h1>
    
    <hr style="width:50px;border:5px solid red" class="w3-round">
  </div>
  

    
  <!-- Services -->
  <div class="w3-container" id="services" style="margin-top:75px">
    <h4 class="w3-xlarge w3-text-black"><b>Account No.</b></h4>
    <hr style="width:50px;border:5px #D6EAF8" class="w3-round">
	<h5>${acc_no_fk}</h5>
  </div>
  <!-- Designers -->

  <div class="w3-container" id="designers" style="margin-top:75px">
    <h4 class="w3-xlarge w3-text-black"><b>Your User Id:</b></h4>
    <hr style="width:50px;border:5px #D6EAF8" class="w3-round">
    <h5>${user_id}</h5>
  </div>


<!-- W3.CSS Container -->
<br><div class="w3-light-grey w3-container w3-padding-20" style="float:left" ><h6>Don't share your User Id or Account No.  information to anyone.</h6></div>

<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>

</body>
</html>
