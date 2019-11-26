<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: teal;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
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
			<a href="accountstatement">Account Statement</a>
			<a href="loggingout" style="float:right">LogOut</a>
		</div>
	
<h3>Add Beneficiary</h3>

<div>
  <form method="get" action="beneficiaryprocess">
  
    <label for="bene_acc_no">Beneficiary Account No. :</label>
    <input type="text" name="bene_acc_no" required>

    <label for="bene_nickname"> Beneficiary Nick Name :</label>
    <input type="text" name="bene_nickname">
    
     <label for="bene_bankname"> Beneficiary Bank Name :</label>
    <input type="text" name="bene_bankname" value="Berenberg Bank" readonly>
	
     <label for="acc_no_fk"> Account number: </label>
    <input type="text" name="acc_no_fk" value="${acc_no}" readonly>
   
  
    <input type="submit" value="Add Beneficiary">
  </form>
</div>

</body>
</html>
