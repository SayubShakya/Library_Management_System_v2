<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if (session.getAttribute("lid") == null) {
    %>
  <h1>Hello</h1>
  <%
  return;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Delete Student</title>

    <style>
        .form-container {
    max-width: 500px;
    margin: 100px auto;
}

form {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #fff;
    padding: 30px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

h2 {
    text-align: center;
    margin-bottom: 30px;
}

label {
    font-size: 16px;
    font-weight: 700;
    margin-bottom: 10px;
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
    <div class="form-container">
        <h2>Delete Student by ID</h2>
        <form action="DelStudentServlet" method="get">
        <%
        String status = (String) session.getAttribute("delstatus");
        if ("success".equals(status)) {
            %>
            <h3 style="color:green">Record Deleted Successfully!</h3>
            <%
            session.removeAttribute("delstatus");
        } else if ("failure".equals(status)) {
            %>
            <h3 style="color:red">Some Error Occurred!</h3>
            <%
            session.removeAttribute("delstatus");
        } else {
            %>
            <h3 style="color:red">Data Not Found!</h3>
            <%
        }
        %>
          <label for="student-id">Student ID:</label>
          <input type="text" id="student-id" name="student-id" required>
          <input type="submit" value="Delete">
          <br>
          <button type="button" onclick="window.location.href='libMain.jsp'">Home</button>
          
        </form>
      </div>
</body>
</html>
