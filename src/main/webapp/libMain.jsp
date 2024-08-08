<%@page import="dao.LibrarianDAOImp"%>
<%@page import="dao.LibrarianDAO"%>
<%
if (session.getAttribute("lid") == null) {
%>
<h1>Hello</h1>
<%
return;
}
%>
<%
int id = (Integer) session.getAttribute("lid");
LibrarianDAO find = new LibrarianDAOImp();
String name = find.findById(id);
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<nav>
	
	 <div class="logo">
                <img src="logobg.png" alt="Logo" width="125" height="81">
            </div>
		<div class="logo" style="margin: 20px;">
			<h3><%="Welcome : " + " " + name + " !"%></h3>

			<script src="js/util.js"></script>
		</div>
		<ul class="menu">

			<li><a href="logout.jsp">Logout</a></li>
			<li></li>
		</ul>
	</nav>
	<header>
		<h1>Library Management System</h1>

	</header>
	<main>

		<div class="slider-container">
		
    <img src="https://patancollege.edu.np/assets/images/slider/silder-11.webp" class="active" alt="Image 1">
    <img src="https://patancollege.edu.np/assets/images/pcps-images/img_8887.webp" alt="Image 2">
    <img src="https://media.edusanjal.com/gallery/Patan_2.jpg" alt="Image 3">
    <div class="prev">&#10094;</div>
    <div class="next">&#10095;</div>
		</div>

		<script>
		var slideIndex = 0;
		var slides = document.getElementsByTagName("img");
		var slideInterval;

		function showSlides() {
		    var i;
		    for (i = 0; i < slides.length; i++) {
		        slides[i].classList.remove("active");
		    }
		    slideIndex++;
		    if (slideIndex > slides.length) {
		        slideIndex = 1;
		    }
		    slides[slideIndex - 1].classList.add("active");
		}

		function startSlideshow() {
		    showSlides();
		    slideInterval = setInterval(showSlides, 2000); 
		}
		startSlideshow();

		document.querySelector(".prev").addEventListener("click", function() {
		    slideIndex--;
		    if (slideIndex < 1) {
		        slideIndex = slides.length;
		    }
		    showSlides(); 
		});

		document.querySelector(".next").addEventListener("click", function() {
		    slideIndex++;
		    if (slideIndex > slides.length) {
		        slideIndex = 1;
		    }
		    showSlides(); /
		});


		</script>

		<div class="button-container">
				<a href="addstudent.jsp" class="button"><h5>Add-Student</h5></a>
			 	<a href="addBook.jsp" class="button"><h5>Add-Book</h5></a> 	
				<a href="SearchUser.jsp" class="button"><h5>Search-Student</h5></a>		
				<a href="issuebook.jsp" class="button"><h5>Issue-Book</h5></a> 
				<a href="checkdue.jsp" class="button"><h5>Check-Due</h5></a>

		</div>

		<div class="button-container">
			<a href="delstudent.jsp" class="button"><h5>Delete-Student</h5></a> <a
				href="delbook.jsp" class="button"><h5>Delete-Book</h5></a> <a
				href="allbook.jsp" class="button"><h5>All-Books</h5></a> <a
				href="allstudent.jsp" class="button"><h5>All-Student</h5></a>
		</div>

	</main>
	<footer>
		<p>&copy; 2024 Library Management System | All rights reserved |
			Design & Develop By Sayub Shakya | Student of PCPS College</p>
	</footer>
</body>
</html>
