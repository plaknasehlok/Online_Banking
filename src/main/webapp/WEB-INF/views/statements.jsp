
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



<table border="1">
<tr>
    <th>Transaction ID</th>
    <th>Sender's Account NUmber</th>
    <th>Receiver's Account NUmber</th>
    <th>Amount</th>
    <th>Date Of Transfer</th>
  </tr>



<c:forEach items="${Statements}" var="item">
    
    <tr>
        <c:forEach items="${item}" var="entry">

            <td>${entry}</td>
    

        </c:forEach>
      
    </tr>
    

</c:forEach>
</table>

</body>
</html>