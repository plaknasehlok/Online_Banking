<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Hello Admin
 <br>
 <hr>
 <br>
 <hr>
 <br>
 ${user_id}
 <hr>
 <br>
<br>

<table border="1">
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

</body>
<div style="margin: 50px">

		<form method="get" action="approveprocess">
			<span>Enter user profile id for approval</span>
			<input type="text" name="user_profile_id_fk" required />
			<input type="submit" value="APPROVE" />
		</form>
</div>
</html>