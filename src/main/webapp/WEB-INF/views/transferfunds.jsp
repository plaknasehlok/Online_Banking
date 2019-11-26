<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<title>Fund Transfer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
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
		<a href="fundstransfer">NEFT</a> <a href="fundstransfer">RTGS</a> <a
			href="fundstransfer">IMPS</a> <a href="accountstatement">Account
			Statement</a> <a href="beneficiary">Add Beneficiary</a> <a
			href="loggingout" style="float: right">LogOut</a>
	</div>
	<header class="w3-container w3-teal">
		<h1>Hello ${user_id}</h1>
	</header>


	<form method="get" class="w3-container w3-card-4"
		action="fundstransferprocess">
		<div class="w3-container w3-half w3-margin-top">


			<p>
				<input class="w3-input" type="text" style="width: 90%"
					name="sender_acc_no" value="${acc_no}" readonly> <label>Sender's
					Account No. :</label>
			</p>
			<p>
				<label>Receiver's Account No. :</label> <select
					name="receiver_acc_no">
					<option>Select from added beneficiaries</option>
					<c:forEach items="${bene_accounts}" var="entry">
						<option>${entry}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<input class="w3-input" type="number" style="width: 90%"
					name="amount" required> <label>Amount:</label>
			</p>
			${balanceerror}


			<p>
				<input type="submit" value="Transfer" />
		</div>

	</form>

</body>
</html>
