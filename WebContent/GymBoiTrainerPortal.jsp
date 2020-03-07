<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Trainer Portal</title>
</head>
<body>
	<%
		
		try{
			String fName = request.getAttribute("fName").toString();
			String userName = request.getAttribute("userName").toString();
		}catch(NullPointerException e){
			String redirectURL = "GymBoiUnLogged.jsp";
		    response.sendRedirect(redirectURL);
		}
	%>
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

			<div id="Classes" class="tabcontent">
				<h3>Classes</h3>
				<p>Get in touch, or swing by for a cup of coffee.</p>
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