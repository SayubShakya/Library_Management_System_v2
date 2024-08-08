<%@ page import="java.util.List"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.temporal.ChronoUnit"%>

<%
if (session.getAttribute("lid") == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Due Form</title>
    <style>
        .table-container {
            max-width: 100%;
            overflow-x: auto;
            margin-bottom: 1em;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border-spacing: 0;
            font-size: 16px;
            font-weight: 400;
            line-height: 1.5;
            color: #333;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 4px;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #f8f8f8;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.03em;
            border-bottom: 1px solid #ccc;
        }
        tbody tr:nth-of-type(even) {
            background-color: #f4f4f4;
        }
        tbody tr:hover {
            background-color: #e0e0e0;
        }
        @media screen and (max-width: 600px) {
            table {
                display: block;
                overflow-x: auto;
                white-space: nowrap;
            }
            thead, tbody, th, td, tr {
                display: block;
            }
            th {
                text-align: left;
            }
            tbody tr td {
                border-bottom: 1px solid #ddd;
            }
            tbody tr:last-of-type td {
                border-bottom: none;
            }
        }
    </style>
</head>
<body>
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Book Id</th>
                    <th>Book Name</th>
                    <th>Issue Date</th>
                    <th>Due Date</th>
                    <th>Return</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<List<Object>> data = (List<List<Object>>) session.getAttribute("checkData");
                if (data != null) {
                    for (List<Object> row : data) {
                        int studentId = (int) row.get(0);
                        String studentName = (String) row.get(1);
                        int bookId = (int) row.get(2);
                        String bookName = (String) row.get(3);
                        Date issueDate = (Date) row.get(4);
                        Date dueDate = (Date) row.get(5);
                        %>
                        <tr>
                            <td><%= studentId %></td>
                            <td><%= studentName %></td>
                            <td><%= bookId %></td>
                            <td><%= bookName %></td>
                            <td><%= issueDate %></td>
                            <td><%= dueDate %></td>
                            <td>
                                <style>
                                    .green-button {
                                        background-color: green;
                                        color: white;
                                        padding: 10px 20px;
                                        border: none;
                                        border-radius: 5px;
                                        font-size: 16px;
                                        cursor: pointer;
                                    }
                                </style>
                                <form action="ReturnBook">
                                    <input type="hidden" name="sid" value="<%= studentId %>">
                                    <input type="hidden" name="bid" value="<%= bookId %>">
                                    <button type="submit" name="return" value="Return" class="green-button">Return</button>
                                </form>
                            </td>
                        </tr>
                        <%
                    }
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
