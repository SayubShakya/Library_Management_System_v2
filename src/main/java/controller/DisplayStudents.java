package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.StudentDAOImp;
import dto.Student;

public class DisplayStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    StudentDAOImp studentDAO = new StudentDAOImp();
	    List<Student> students = studentDAO.findAll();

	    if (students == null || students.isEmpty()) {
	        System.out.println("No students found.");
	    } else {
	        System.out.println("Students fetched: " + students.size());
	    }

	    request.setAttribute("students", students);
	    request.getRequestDispatcher("allstudent.jsp").forward(request, response);
	}
}