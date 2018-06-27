<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>
<form action="MainControllerD" class="div1" method="post">
<select name = "hospId" >
<c:forEach items="${hList}" var="hospital">
<option value = "${hospital.id}">${hospital.name} </option>
</c:forEach>
</select>
<br>
<input type="hidden" name="action" value="select"> </input>
<input type="submit" name="submit" value="next"> </input>


</form>
</body>

    
</html>