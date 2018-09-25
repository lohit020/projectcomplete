<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >

input {
	border-radius: 4px;
	width: 200px;
	height:30px;
}
table,h1{
border-color:white;
 border-left:4px; 
 border-top-:4px;
 color:white;
 margin-top: 100px;
 text-shadow: -1px 0 black, 0 4px black, 1px 0 black, 0 -1px black; 
}
td{

font-size:40px;
}

</style>
</head>

<body style="background-image:url('http://retaildesignblog.net/wp-content/uploads/2014/04/Peppes-Pizza-restaurant-by-RISS-INTERIORARKITEKTER-Oslo-Norway.jpg');background-repeat:no-repeat;background-position: center;
    background-repeat: no-repeat;
    background-size: cover;">
<div align="center">
<h1 >Add Store</h1>
<form action="saveStores" method="post">

<table>
	<tr>
		<td><input type="hidden" name="storeId"/></td>
	</tr>
	<tr>
		<td>Name</td>
		<td> <input type="text" name="name"/> </td>
	</tr>
	<tr>
		<td>Street</td>
		<td><input type="text" name="street"/></td>
	</tr>
	<tr>
		<td>Mobile Number</td>
		<td><input type="text" name="mobileNo"/></td>
	</tr>
	<tr>
		<td>City</td>
		<td><input type="text" name="city"/></td>
	</tr>
	<tr>
		<td>State</td>
		<td><input type="text" name="state"/></td>
	</tr>
	<tr>
		<td>Pincode</td>
		<td><input type="text" name="pincode"/></td>
	</tr>
</table>
<input type="submit" value="save"/>

</form>
</div>
</body>
</html>