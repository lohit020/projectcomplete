<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	width: 100wh;
	height: 90vh;
	color: #fff;
	background: linear-gradient(-45deg, #EE7752, #E73C7E, #23A6D5, #23D5AB);
	background-size: 400% 400%;
	-webkit-animation: Gradient 15s ease infinite;
	-moz-animation: Gradient 15s ease infinite;
	animation: Gradient 15s ease infinite;
}@-webkit-keyframes Gradient {
	0% {
		background-position: 0% 50%
	}
	50% {
		background-position: 100% 50%
	}
	100% {
		background-position: 0% 50%
	}
}

@-moz-keyframes Gradient {
	0% {
		background-position: 0% 50%
	}
	50% {
		background-position: 100% 50%
	}
	100% {
		background-position: 0% 50%
	}
}

@keyframes Gradient {
	0% {
		background-position: 0% 50%
	}
	50% {
		background-position: 100% 50%
	}
	100% {
		background-position: 0% 50%
	}
}

td {
    padding: 5px 5px;
    margin: 10px;
    width:auto;
    box-sizing: border-box;
    border: 1px solid black;
    border-radius: 4px;
    text-align: center;
}

p{
color: maroon;

}

.button {
    background-color: brown; 
    border: black;
    color: black;
    padding: 5px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 18px;
    margin: 2px 2px;
    cursor: pointer;
	border-radius: 4px;
}
.text{
	background-color: transparent;
	border:0px;
	width:140px;

}</style>
</head>
<body>
<h1>Store Data</h1>
<button style="float: right;" onclick="goBack()">Go Back</button>
<form action="done" method="post">
<table border="3">
	<tr>
		<th>Order Id</th>
		<th>User Id</th>
		<th>Order Date</th>
		<th>Store Id</th>
		<th>Cart Id</th>
		<th>Total Prize</th>
		<th>Order status</th>
		<th>Street</th>
		<th>City</th>
		<th>State</th>
		<th>Pincode</th>
		<th>Mobile No</th>
		<th>Delete</th>
		
	</tr>
	
	<c:forEach var="str" items="${OrderBean}">
		<tr>
			<td>${str.orderId}</td>
			<td>${str.userId}</td>
			<td>${str.orderDate}</td>
			<td>${str.storeId}</td>
			<td>${str.cartId}</td>
			<td>${str.totalPrice}</td>
			<td>${str.orderStatus}</td>
			<td>${str.street}</td>
			<td>${str.city}</td>
			<td>${str.state}</td>
			<td>${str.pincode}</td>
			<td>${str.mobileNo}</td>
    		<td><a href="deleteOrder/${str.orderId}">Delete</a></td>  
		</tr>
	
	
	</c:forEach>
</table>
<input type="submit" value="Order"/>  
</form>
</body>
<script>
function goBack() {
    window.history.back();
}
</script>
</html>