<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="css/bootstrap.min.css"> 
   <link href="resources/registration.css" rel="stylesheet">

<title> DocPlus Doctor Registration</title>

</head>
<body>
<form action="MainControllerD" method="post">
    <div class="container">
      <h1>Doctor Registration</h1>
      
      <input type=text name="fullName" placeholder="Enter full name" required><br>
       
      <label for="dob"><b>Date of Birth</b></label>
      <input type=date name="dob" placeholder="Enter dob"/><br>
  	 
  	  <label for="m"><b>Gender</b></label>
  	  <input type = radio name = "gender" value = "Male"> Male

      <input type = radio name = "gender" value = "Female"> Female<br>
      
      <input type = email name = "email" placeholder = "Enter email"> <br>
      
      <input type="text" placeholder="Enter UserName" name="userName" required>

      <input type = password name="password" placeholder="Enter Password"><br>
      
      <input type = text name = "speciality" placeholder = "speciality">

      <label for="practiseYear"><b>Practising year</b></label>
	  <input type = date name = "practiseYear" placeholder = "PractisingFrom"><br>

	  <input type=text name="desc" placeholder="Description"><br>

      <label for="hNo"><b>Address</b></label><br>
	  <input type=text name="hNo" placeholder="HouseNumber"><br>

	  <input type=text name="street" placeholder="street">

	  <input type=text name="city" placeholder="City"><br>

	  <input type=text name="state" placeholder="State">

	  <input type=text name="country" placeholder="Country"><br>

      <label for="contact"><b>Contact</b></label>
	  <input type=text name="contact" placeholder="Contact"/><br>
	  
      <button type="submit" class="btn">Register</button>
      
      <input type="hidden" name = "action" value = "docRegister">
      
	</div>  
</form>
</body>
</html>