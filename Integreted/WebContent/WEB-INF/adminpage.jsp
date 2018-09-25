<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   
    
    
    .row.content {height: 675px}
    
    
    .sidenav {
	  
      padding-top: 20px;
      background-color:#1a1a1a;
      height: 100%;
    }
    
   
    
    
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
	
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">POS</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><button onclick="doLogout()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-4 sidenav">
	<br>
	<br>
	
	
	
      <p><a href="addStore"><b><i><u><h3>Add a new store</h3></u></i></b></a></p>
	  <br>
      <p><a href="editStorepage"><b><i><u><h3>Modify the store</h3></u></i></b></a></p>
	  <br>
      <p><a href="showstores"><b><i><u><h3>Delete a store</h3></u></i></b></a></p>
	  <br>
      <p><a href="addFood"><b><i><u><h3>Add a new food item</h3></u></i></b></a></p>
	  <br>
      <p><a href="displayfoodadmin"><b><i><u><h3>View,Modify and Delete a food item</h3></u></i></b></a></p>
	  <br>
      <p><a href="orderadmin"><b><i><u><h3>View and Modify order</h3></u></i></b></a></p>
	  <br>
      
    </div>
	
    <div class="col-sm-8 text-left"> 
      <h1>THE PIZZA COMPANY!</h1>
     <td><img src="https://ae01.alicdn.com/kf/HTB13w_FKpXXXXXVaXXXq6xXFXXXa/Free-Shipping-3D-custom-sushi-letters-mural-borderless-restaurant-pizza-store-coffee-shop-wallpaper-m
     			ural.jpg_640x640.jpg" width="800" height="600"/></td>
      <hr>
      
    
    </div>
   
  </div>
</div>
<script type="text/javascript">
function doLogout() {
    var backlen = history.length;
    history.go(-backlen);
    window.location.replace("/Integrared/");
}
</script>

</body>
</html>
