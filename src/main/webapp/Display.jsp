<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
</head>
<body>

    <h1>Display Students</h1>
    <table width='95%' border=1>
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>COURSE</th>
                <th>PHONE</th>
                <th>EMAIL</th>
            </tr>
        </thead>
        <tbody>
        <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student student : students) {
                out.println("<tr><td>" + student.getSid() + "</td><td>" + student.getSname() + "</td><td>" + student.getScourse()
                + "</td><td>" + student.getSphone() + "</td><td>" + student.getSemail()
                + "</td></tr>");
            }
        } else {
            out.println("<tr><td colspan='5'>No students found</td></tr>");
        }
        %>
        </tbody>
    </table>
</body>
</html>
