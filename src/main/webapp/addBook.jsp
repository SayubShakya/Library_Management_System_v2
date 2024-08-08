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
<title>Book Information Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
	margin-top: 80px;
	color: #333;
}

form {
	max-width: 500px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0px 0px 10px #aaa;
}

label {
	display: block;
	font-size: 18px;
	font-weight: bold;
	margin-bottom: 10px;
	color: #555;
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
	<h1>Book Information Form</h1>
	<form action="AddBookServlet">
		<%
		String str1 = (String) session.getAttribute("baddstatus");
		if ("success".equals(str1)) {
		%>
		<h3 style="color: green">Record Inserted Successfully !!</h3>
		<%
		session.setAttribute("baddstatus", null);
		} else if ("failure".equals(str1)) {
		%>
		<h3 style="color: red">Some Error Occurred!</h3>
		<%
		}
		%>
		<label for="bname">Book Name:</label> <input type="text" id="bname"
			name="bname" placeholder="Enter book name..."> <label
			for="bid">Book ID:</label> <input type="text" id="bid" name="bid"
			placeholder="Enter book ID..."> <label for="bautho">Book
			Author:</label> <input type="text" id="bautho" name="bautho"
			placeholder="Enter book author..."> <label for="bsubject">Book
			Subject:</label> <input type="text" id="bsubject" name="bsubject"
			placeholder="Enter book subject..."> <input type="submit"
			value="Submit">
			<button type="button" onclick="window.location.href='libMain.jsp'">Home</button>
			
	</form>
</body>
</html>