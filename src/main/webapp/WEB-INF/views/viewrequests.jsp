<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<style>

h2{
text-align: center;
padding-top: 20px;
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: teal;
  color: white;
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
</head>
<body>

 <div class="topnav">
 	<a href="loggingout" style="float:right">LogOut</a>
 	 <a href="adminsview">View new requests</a>
 	</div>
 	
		<h2>Hello ${user_id}</h2>
<table id="customers">
<tr>
    <th>User Profile ID</th>
    <th>Aadhar No</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Middle Name</th>
    <th>Father's Name</th>
    <th>Mobile Number</th>
    <th>Email ID</th>
    <th>Date Of Birth</th>
    <th>Residential Address</th>
    <th>Permanent Address</th>
    <th>Occupational Details</th>
    <th>Status</th>
        
  </tr>



<c:forEach items="${Requests}" var="item">
    
    <tr>
        <c:forEach items="${item}" var="entry">

            <td>${entry}</td>
    

        </c:forEach>
      
    </tr>
    

</c:forEach>
</table>


<br>
<hr>
 <br>

<input type="button" onclick="window.open('https://resident.uidai.gov.in/verify', '_blank')" value="Verify Aadhar Number" />

<br>

<hr>
 <br>


<div class="w3-container w3-half w3-margin-top" >

		<form method="get" action="approveprocess">
			<label>Enter user profile id for approval</label>
			<input class="w3-input" type="text" name="user_profile_id_fk" style="width:90%" required />
			
		<div class="row">	
			<input type="submit" value="APPROVE" />
		</div>
		</form>
</div>
</body>
</html>