<%@page import="dao.LibrarianDAOImp"%>
<%@page import="dao.LibrarianDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="style/Studentstyle.css">
</head>
<body>
    <%
    HttpSession session1 = request.getSession(false);
    if (session1 != null && session1.getAttribute("username") != null) {
        String username = (String) session1.getAttribute("username");
    %>
    <nav>
        <div class="logo">
            <img src="logobg.png" alt="Logo" width="125" height="81">
        </div>
        <div class="logo" style="margin: 20px;">
            <h1>Welcome: <%= username %></h1>
        </div>
        <ul class="menu">
            <li class="nav__item dropdown">
                <div class="dropdown">
                    <a href="#" class="nav__link dropdown-toggle">My Profile</a>
                    <ul class="dropdown-menu">
                        <li><a href="EditProfile.jsp">Edit Profile</a></li>
                        <li><a href="ChangePassword.jsp">Change Password</a></li>
                    </ul>
                </div>
            </li>
            <li class="nav__item"><a href="index.html">Logout</a></li>
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
                showSlides();
            });
        </script>

        <div class="button-container">
            <a href="issuebookstudent.jsp" class="button"><h5>Borrow Book</h5></a>
            <a href="checkdue.jsp" class="button"><h5>Return Book</h5></a>
        </div>

        <div class="button-container">
            <a href="#" class="button"><h5>Search Book</h5></a>
            <a href="allbook.jsp" class="button"><h5>All Books</h5></a>
        </div>
    </main>
    <footer>
        <p>&copy; 2024 Library Management System | All rights reserved | Design & Develop By Sayub Shakya | Student of PCPS College</p>
    </footer>

    <%
    } else {
        response.sendRedirect("signin.html");
    }
    %>
</body>
</html>
