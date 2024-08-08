package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dao.IssueBookImp;
import dao.StudentDAOImp;
import dto.Student;

/**
 * Servlet implementation class CheckDue
 */
public class CheckDue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid;
        try {
            sid = Integer.parseInt(request.getParameter("student-id"));
        } catch (NumberFormatException e) {
            HttpSession session = request.getSession();
            session.setAttribute("chstat", "error");
            response.sendRedirect("checkdue.jsp");
            return;
        }

        StudentDAOImp studentDAO = new StudentDAOImp();
        IssueBookImp issueBookDAO = new IssueBookImp();
        HttpSession session = request.getSession();
        Student student = studentDAO.findById(sid);
        List<List<Object>> data;

        if (student != null) {
            try {
                data = issueBookDAO.checkdue(sid);
            } catch (Exception e) {
                e.printStackTrace(); // Handle exception
                session.setAttribute("chstat", "error");
                response.sendRedirect("checkdue.jsp");
                return;
            }

            if (!data.isEmpty()) {
                session.setAttribute("checkData", data);
                response.sendRedirect("checkform.jsp");
            } else {
                session.setAttribute("chstat", "error");
                response.sendRedirect("checkdue.jsp");
            }
        } else {
            session.setAttribute("chstat", "error");
            response.sendRedirect("checkdue.jsp");
        }
    }
}