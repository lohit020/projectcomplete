<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
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
	width:150px;

}
</style>
</head>
<body >
<form action="saveOrder" method="post">
<h1 align="center">Cart</h1>
<table align="center">
	<tr>
		<th>UserId</th>
		<th>FoodId</th>
		<th>Type</th>
		<th>Quantity</th>
		<th>Cost</th>
		<th>OrderDate</th>	
		<th>Delete</th>	
		
	</tr>
	
	<c:forEach var="str" items="${CartBean}">
		<tr>
			<td><input type="hidden" class="text" name="cartID"   value="${str.cartID}" readonly/></td>
			<td><input type="text" class="text" name="userId"  value="${str.userId}" readonly/></td>
			<td><input type="text" class="text" name="foodId"  value="${str.foodId}" readonly/></td>
			<td><input type="text" class="text" name="type"  value="${str.type}" readonly/></td>
			<td><input type="text" class="text" name="quantity"  value="${str.quantity}" readonly/></td>
			<td><input type="text" class="text"  name="cost"  value="${str.cost}"/></td>
			<td><input type="date" class="text"  name="orderDate"  value="${str.orderDate}"/></td>
			<td><a class="button" href="deleteCart?itemID=${str.cartID}">Delete</a></td> 
			
		</tr>
	</c:forEach>
	
</table>
<span align="center"><input type="submit" class="button" value="Order"/></span></form>
</form>
</body>
</html>
