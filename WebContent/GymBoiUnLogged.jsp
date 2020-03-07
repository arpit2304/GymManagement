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
<title>Welcome to GymBoi</title>
</head>
<body>
	<h1>Welcome to GymBoi</h1>
	<div class="loginBox">
		<form action="Login" method="Post">
			Username or Email: <input type="text" name="username"
				placeholder="Enter your username or email" id="username"><br>
			Password: <input type="text" name="password"
				placeholder="Enter your password" id="pwd"><br> <input
				type="submit" value="login" id="submit">
				<span id="message">${message }</span><br>
			No Account? No Problem! <a href="Register.jsp">Register Here</a>
		</form>

	</div>
	
	
		<div class="mainDiv">

			<button class="tablink" onclick="openPage('Home', this, 'orange')" id="defaultOpen">Home</button>
			<button class="tablink" onclick="openPage('Trainers', this, 'orange')" >Trainers</button>
			<button class="tablink" onclick="openPage('Classes', this, 'orange')">Classes</button>
			<button class="tablink" onclick="openPage('Store', this, 'orange')">Store</button>

			<div id="Home" class="tabcontent">
				<h3>Home</h3>
				<p>Home is where the heart is..</p>
			</div>

			<div id="Trainers" class="tabcontent">
				<h3>Trainers</h3>
				<p>Some news this fine day!</p>
			</div>

			<div id="Classes" class="tabcontent">
				<h3>Classes</h3>
				<p>Upcoming Classes</p>
				<%
					jspDB jdb = new jspDB();
					List<GymClass> classes = jdb.getClasses();
					for (GymClass gc : classes){
						out.println(gc.getName());out.println("<br>");
						
					}
				%>
			</div>

			<div id="Store" class="tabcontent">
				<h3>Store</h3>
				<p>Products currently available for order</p>
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
		  // Hide all elements with class="tabcontent" by default 
		  var i, tabcontent, tablinks;
		  tabcontent = document.getElementsByClassName("tabcontent");
		  for (i = 0; i < tabcontent.length; i++) {
		    tabcontent[i].style.display = "none";
		  }

		  // Remove the background color of all tablinks/buttons
		  tablinks = document.getElementsByClassName("tablink");
		  for (i = 0; i < tablinks.length; i++) {
		    tablinks[i].style.backgroundColor = "";
		  }

		  // Show the specific tab content
		  document.getElementById(pageName).style.display = "block";

		  // Add the specific color to the button used to open the tab content
		  elmnt.style.backgroundColor = "orange";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>

</body>

</html>