<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
input[type=text] {
    width: 100%;
    padding: 5px 5px;
    margin: 10px 0;
    box-sizing: border-box;
    border: 1px solid brown;
    border-radius: 4px;
}
body{
background: linear-gradient(110deg, #fdcd3b 60%, #ffed4b 60%);}
.button {
    background-color: brown; 
    border: black;
    color: white;
    padding: 5px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 18px;
    margin: 2px 2px;
    cursor: pointer;
	border-radius: 4px;
}

b,h1
color:white;
}
</style>
<style>
p{
color: maroon;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="back1">
<center><h1>Add Profile</h1></center>
<form  action="saveProfile"  method="post">
<table align="center">
<tr>
<td ><input type="hidden" name="userId"/></td>
</tr>
<tr>
<td><b>First Name</b></td>
<td> <input type="text" name="firstName"/> </td>
</tr>
<tr>
<td><b>Last Name</b></td>
<td><input type="text" name="lastName"/></td>
</tr>
<tr>
<td><b>Date of birth</b></td>
<td><input type="Date" name="dateOfBirth"/></td>
</tr>
<tr>
<td><b>Gender</b></td>
<td><input type="text" name="gender"/></td>
</tr>
<tr>
<td><b>Street<b></td>
<td><input type="text" name="street"/></td>
</tr>
<tr>
<td><b>City</b></td>
<td><input type="text" name="city"/></td>
</tr>
<tr>
<td><b>State</b></td>
<td><input type="text" name="state"/></td>
</tr>
<tr>
<td><b>Location</b></td>
<td><input type="text" name="location"/></td>
</tr>
<tr>
<td><b>pincode</b></td>
<td><input type="text" name="pincode"/></td>
</tr>
<tr>
<td><b>Mobile number</b></td>
<td><input type="text" name="mobileNo"/></td>
</tr>
<!-- <td><b>Password</b></td>
<tr>
<td><input type="text" name="password"/></td>
</tr> -->
</table>

<center><button class="button">Save</button></center>
</form>
</div>
</body>
</html>    