 <link href="profile.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<body>
 
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#" target = "link" >My Appointments</a>
  <a href="MainControllerD?action=hospitalList" target = "link">Give Slots</a>
  <a href="hospital.jsp" target = "link">Add Hospitals</a>
  
</div>
<%-- <%
String fullName=(String)request.getAttribute("docName");
%> --%>


<div id="main">
  <%-- <center><h2>WELCOME <%=fullName%></h2></center>
  <center><h1>TO DOCPLUS</h1></center> --%>
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>
</div>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
}
</script>
</body>