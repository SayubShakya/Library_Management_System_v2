package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.StudentDAO;
import dao.StudentDAOImp;
import dto.Student;

public class DelStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("student-id"));
        String delstatus;
        StudentDAO studentDAO = new StudentDAOImp();
        Student student = studentDAO.findById(sid);
        if (student != null) {
            delstatus = studentDAO.deleteById(sid);
        } else {
            delstatus = "failure";
        }
        HttpSession session = request.getSession();
        session.setAttribute("delstatus", delstatus);
        response.sendRedirect("delstudent.jsp");
    }
}