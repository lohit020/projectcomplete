<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food</title>
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
<div align="center">
<h1>Add Food</h1>
<form action="saveFood" method="post">

<table>
	<tr>
		<td>Food Id</td>
		<td><input type="text" name="foodId"/></td>
	</tr>
	<tr>
		<td>Name</td>
		<td> <input type="text" name="fName"/> </td>
	</tr>
	<tr>
		<td>Type</td>
		<td><input type="text" name="type"/></td>
	</tr>
	<tr>
		<td>Food Size</td>
		<td><input type="text" name="foodSize"/></td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td><input type="text" name="quantity"/></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type="text" name="price"/></td>
	</tr>
	
</table>
<input type="submit" value="save"/>
</div>
</form>
</body>
</html>