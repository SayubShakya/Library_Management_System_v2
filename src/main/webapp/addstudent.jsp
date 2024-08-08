<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
if (session.getAttribute("lid") == null) {
%>
    <h1>Hello</h1>
    <%
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <style>
        form {
            max-width: 500px;
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f2f2f2;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

         input[type=text], select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit], button {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover, button:hover {
            background-color: #45a049;
        }

        button {
            background-color: #f44336; 
        }

        button:hover {
            background-color: #c62828;
        }
        
    </style>
</head>
<body>

    <form action="AddStudentServlet" method="post">
        <h2>Add Student</h2>
        <%
        String status = (String) session.getAttribute("stdstatus");
        if ("success".equals(status)) {
        %>
            <h3 style="color:green">Record Inserted Successfully!</h3>
            <%
            session.setAttribute("stdstatus", null);
        } else if ("failure".equals(status)) {
        %>
            <h3 style="color:red">Some Error Occurred!</h3>
        <%
        }
        %>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter student's name" required>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" placeholder="Enter student's email" required>

        <label for="course">Course:</label>
        <input type="text" id="course" name="course" placeholder="Enter student's course" required>

        <label for="phoneno">Phone No:</label>
        <input type="text" id="phoneno" name="phoneno" placeholder="Enter student's phone no" required>

        <label for="sid">Enrollment No / Student Id:</label>
        <input type="text" id="sid" name="sid" placeholder="Enter enrollment no." required>

       <input type="submit" value="Add Student">
        <button type="button" onclick="window.location.href='libMain.jsp'">Home</button>
    </form>
</body>
</html>