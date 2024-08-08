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
<html>
<head>
    <title>Book Return Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; /* Full viewport height */
            margin: 0;
        }

        h1 {
            color: #4CAF50;
            text-align: center;
            margin-top: 50px;
        }

        p {
            font-size: 20px;
            color: #333;
            text-align: center;
            margin-top: 30px;
        }

        button {
            background-color: #f44336; 
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            margin-top: 30px;
        }

        button:hover {
            background-color: #c62828;
        }
    </style>
</head>
<body>
    <h1>Book Successfully Returned</h1>
    <p>Thank you for returning the book. We hope you enjoyed it!</p>
    
    <button type="button" onclick="window.location.href='libMain.jsp'">Home</button>
</body>
</html>
