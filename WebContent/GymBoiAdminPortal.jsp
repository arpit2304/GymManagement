<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
 <%@ page import="java.util.List" %>
 <%@ page import="DBUtil.jspDB" %>
 <%@ page import="Object.GymClass" %>
 <%@ page import="Object.Item" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Admin Portal</title>
</head>
<body>
	<%
		
/*		try{
			String fName = request.getAttribute("fName").toString();
			String userName = request.getAttribute("userName").toString();
		}catch(NullPointerException e){
			String redirectURL = "GymBoiUnLogged.jsp";
		    response.sendRedirect(redirectURL);
		}*/
	%>
	<h1>Welcome Admin</h1>
	
	
		<div class="mainDiv">

			<button class="tablink" onclick="openPage('Users', this, 'orange')" id="defaultOpen">Users</button>
			<button class="tablink" onclick="openPage('Classes', this, 'orange')" >Classes</button>
			<button class="tablink" onclick="openPage('Items', this, 'orange')">Items</button>

			<div id="Users" class="tabcontent">
				<h3>Home</h3>
				
			</div>

			<div id="Classes" class="tabcontent">
				<h3>Classes</h3>
				<%
					jspDB jdb = new jspDB();
					List<GymClass> classes = jdb.getClasses();
					for (GymClass gc : classes){
						out.println(gc.getName());out.println("<br>");
						
					}
				%>
			</div>
			
			<div id="Items" class="tabcontent">
				<h3>Items</h3>
				<%
					List<Item> items = jdb.getItems();
					for (Item i : items){
						out.println(i.getName());out.println("<br>");
						out.println(i.getImgPath());out.println("<br>");
						
					} 
				%>
			</div>
			
		</div>

	<script>
	
	function openPage(pageName, elmnt, color) {
		  var i, tabcontent, tablinks;
		  tabcontent = document.getElementsByClassName("tabcontent");
		  for (i = 0; i < tabcontent.length; i++) {
		    tabcontent[i].style.display = "none";
		  }
		  tablinks = document.getElementsByClassName("tablink");
		  for (i = 0; i < tablinks.length; i++) {
		    tablinks[i].style.backgroundColor = "";
		  }

		  document.getElementById(pageName).style.display = "block";
		  elmnt.style.backgroundColor = "orange";
		}

		document.getElementById("defaultOpen").click();
	</script>
</body>
</html>