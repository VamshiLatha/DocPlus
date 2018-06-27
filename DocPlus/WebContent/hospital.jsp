<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="css/bootstrap.min.css"> 
   <link href="resources/registration.css" rel="stylesheet">

<title> DocPlus Add Hospital</title>
<style type="text/css">



</style>

</head>
<body>
<form action="MainControllerD" method="post">
    <div class="container">
      <h1> Add Hospital</h1>
      
      <label for="hospital_name"><b>Hospital_name</b></label>
      <input type=text name="hospitalName" placeholder="Enter hospital_name"/><br>
      
      <label for="survey_number"><b>Survey_number</b></label>
	  <input type=text name="surveyNumber" placeholder="Enter survey_number"><br>
	  
	  <label for="street"><b>Street</b></label>
	  <input type=text name="street" placeholder="Enter street">
       
      <label for="city"><b>City</b></label>
	  <input type=text name="city" placeholder="Enter City"><br>
	  
	  <label for="pincode"><b>Pincode</b></label>
	  <input type=text name="pincode" placeholder="Enter pincode"/><br>
	  
	  <label for="state"><b>State</b></label>
	  <input type=text name="state" placeholder="State">
    
      <label for="country"><b>Country</b></label>
	  <input type=text name="country" placeholder="Enter Country"><br>
    
     
      
	  
<!-- 	  <label for="start_date"><b>Start_date</b></label>
	  <input type=date name="start_date" placeholder="Enter start_date"><br>
	  
	  <label for="end_date"><b>End_date</b></label>
	  <input type=date name="end_date" placeholder="Enter end_date"><br> -->
	  
	   <label for="consultation_fee"><b>Consultation_fee</b></label>
	  <input type=double name="consultation_fee" placeholder="Enter consultation_fee"><br>
	  
	  
	  <input type = "hidden" name = "action" value = "hRegister">
	  
      <button type="submit" class="btn">Register</button>
	</div>  
</form>
</body>
</html>