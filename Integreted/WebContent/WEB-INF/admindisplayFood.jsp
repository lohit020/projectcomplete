<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#back1 {

    
   padding: 100px;
    
   background: url(C:/Users/battu.divya/Desktop/d.png);
   background-size: 100% 100%;
    } 
input[type=text] {
    width: 100%;
    padding: 5px 5px;
    margin: 10px 0;
    box-sizing: border-box;
    border: 1px solid brown;
    border-radius: 4px;
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
</style>
</head>
<body>
<h1 align="center">Food Data</h1>
<form action="updateCart" method="post" >
<table align="center">
	<tr>
		<th>Food ID</th>
		<th>Name</th>
		<th>Type</th>
		<th>Food Size</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Delete</th>
		
	</tr>
	
	<c:forEach var="fds" items="${FoodBean}">
		<form action="updateCart" method="post">
		<tr>
			<td><input type="text" name="foodId"  value="${fds.foodId}" readonly="readonly"/></td>
			<td ><input type="text" name="fName"  value="${fds.fName}" readonly="readonly"/></td>
			<td ><input type="text" name="type"  value="${fds.type}"/></td>
			<td><input type="text" name="foodSize"   value="${fds.foodSize}"/></td>
			<td><input type="text"  name="quantity"  value="${fds.quantity}"/></td>
			<td><input type="text"  name="price"   value="${fds.quantity*fds.price}"/></td>
			<%-- <td><a href="updateCart?foodId=${fds.foodId}">AddtoCart</a></td>  
    		<td><a href="deleteFood/${fds.foodId}">Delete</a></td>  --%> 
    		<td><input class="button" type="submit" value="addFood"/></td>
		</tr>
		</form>
	</c:forEach>

</table>
</form>
</body>
</html>