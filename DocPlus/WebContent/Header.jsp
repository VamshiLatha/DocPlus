<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>DocPlus</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="resources/stylesheet.css" rel="stylesheet">




  
  
</head>
</body>
<body>

<div id="about" class="container">
</div>


<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">DocPlus</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#home">HOME</a></li>
        <li><a href="#about">AboutUs</a></li>
       
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="patientLogin.jsp">Login</a></li>
            <li><a href="patientRegistration.jsp">Register</a></li>
             
          </ul>
        </li>
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Doctor
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="docLogin.jsp">Login</a></li>
            <li><a href="doctorRegistration.jsp">Register</a></li>
             
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>