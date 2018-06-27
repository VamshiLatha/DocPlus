<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/login.css" rel="stylesheet">
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>DocPlus Patient Login</title>

</head>
<body>



 <form action="MainControllerD" class="div1" method="post">



<h3 class="header_login"> PATIENT LOGIN </h3>


<input type="text"  required  name="userName" placeholder="User Name"><span><i class="fa fa-user icons" aria-hidden="true" style="font-size:19px"></i></span> </br>
<input type="password" required name="password" placeholder="Password"  ><span><i class="fa fa-lock icons" aria-hidden="true" style="font-size:20px"></i></span> </br> </br>
<p align=right> <input type="submit"  class="button" id="submit" value="Login" onclick="eval()" ></p>
<input type="hidden" name = "action" value = "patientLogin">
</form>
</body>
</html>