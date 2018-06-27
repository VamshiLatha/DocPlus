<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script>
var expanded = false;

function showCheckboxes() {
  var checkboxes = document.getElementById("checkboxes");
  if (!expanded) {
    checkboxes.style.display = "block";
    expanded = true;
  } else {
    checkboxes.style.display = "none";
    expanded = false;
  }
}
</script>
<style type="text/css">
.multiselect {
  width: 200px;
}

.selectBox {
  position: relative;
}

.selectBox select {
  width: 100%;
  font-weight: bold;
}

.overSelect {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

#checkboxes {
  display: none;
  border: 1px #dadada solid;
}

#checkboxes label {
  display: block;
}

#checkboxes label:hover {
  background-color: #1e90ff;
}
</style>

</head>
<body>
<form action="MainControllerD" method="post" enctype="multipart/form-data"> 
		
		<select name = "hospId" >
		<c:forEach items="${hList}" var="hospital">
		<option value = "${hospital.id}">${hospital.name} </option>
		</c:forEach>
		</select>
<br>
		<label>Select Date:</label> 
		<input type=date name="doa"	required="required" /><br>
		
		
		<div class="multiselect">
		<div class="selectBox" onclick="showCheckboxes()">
		<select>
		<option>Select Morning slots</option>
		</select>
      	<div class="overSelect"></div>
    	</div>
    	<div id="checkboxes">
        	<input type="checkbox" id="one" />9:00-9:30 AM</input> <br>
        	<input type="checkbox" id="two" />9:30-10:00 AM</input><br>
        	<input type="checkbox" id="three" />10:00-10:30 AM</input><br>
         	<input type="checkbox" id="four" />11:00-11:30 AM</input><br>
         	<input type="checkbox" id="five" />11:30-12:00 AM</input><br>
         	<input type="checkbox" id="six" />12:00-12:30 AM</input><br>
         	<input type="checkbox" id="seven" />12:30-01:00 AM</input>       	
    	</div>
  		</div>
	
		
		<div class="multiselect">
		<div class="selectBox" onclick="showCheckboxes()">
		<select>
    	<option>Select Evening Slots</option>
		</select>
      	<div class="overSelect"></div>
    	</div>
    	<div id="checkboxes">
        	<input type="checkbox" id="one" />02:00-02:30 PM</input> <br>
        	<input type="checkbox" id="two" />02:30-03:00 PM</input><br>
        	<input type="checkbox" id="three" />03:00-03:30 PM</input><br>
         	<input type="checkbox" id="four" />04:00-04:30 PM</input><br>
         	<input type="checkbox" id="five" />04:30-05:00 PM</input><br>
         	<input type="checkbox" id="six" />05:00-05:30 PM</input><br>
         	<input type="checkbox" id="seven" />05:30-06:00 PM</input><br>       	
    	</div>
  		</div>
  		<input type="hidden" name="action" value="slot"> </input>
  		<input type="submit" name = submit value="Submit"></input>       			
	</form>
</body>
</html>